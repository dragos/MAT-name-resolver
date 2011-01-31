package com.ssol.mat

import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver
import org.eclipse.mat.snapshot.model._
import org.eclipse.mat.snapshot.extension.Subjects

@Subjects(Array("scala.tools.nsc.symtab.Names$TermName", "scala.tools.nsc.symtab.Names$TypeName"))
class ScalaCompilerNameResolver extends IClassSpecificNameResolver {
  def resolve(obj: IObject): String = {
    val name = HeapObject(obj)
    
    (for {
      names <- name.resolve("$outer")
      chrs <- names.field("chrs")
      index <- name.field("index")
      len <- name.field("len")
    } yield chrs.value.asInstanceOf[ObjectReference].getObject match {
      case array: IPrimitiveArray =>
        new String(array.getValueArray(index.toInt, len.toInt).asInstanceOf[Array[Char]])
      case _ =>
        println(chrs + " val: " + chrs.value.getClass)
        null
    }).get
  }
}
