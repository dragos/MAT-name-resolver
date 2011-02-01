package com.ssol.mat

import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver
import org.eclipse.mat.snapshot.model._
import org.eclipse.mat.snapshot.extension.Subjects


import KnownTypes._

@Subjects(Array(ClassSymbol, ModuleClassSymbol, ModuleSymbol, MethodSymbol, TermSymbol, TypeSymbol))
class CompilerSymbolResolver extends IClassSpecificNameResolver {

  def kind(obj: IObject): String = {
    obj.getClazz().getName match {
      case ClassSymbol => "class"
      case ModuleClassSymbol => "class"
      case ModuleSymbol => "object"
      case MethodSymbol => "def"
      case TermSymbol => "val"
      case TypeSymbol => "type"
      case _ => "<?>"
    }
  }
  
  def runId(obj: HeapObject): Int = {
    obj.field("validTo").map(_.toInt >> 8) getOrElse(-1)
  }
  
  def resolve(obj: IObject): String = {
    val sym = HeapObject(obj)
    (for {
      rawName <- sym.resolve("rawname") 
    } yield "%s %s [runId: %s]".format(kind(obj), rawName.classSpecificName, runId(sym))).get
  }
}
