package com.ssol.mat
import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver
import org.eclipse.mat.snapshot.model._
import org.eclipse.mat.snapshot.extension.Subjects

import scala.collection.mutable

import KnownTypes._

@Subjects(Array(cons, nil))
class ScalaListResolver extends IClassSpecificNameResolver {
  def resolve(obj: IObject): String = {
    val o = HeapObject(obj)
    if (obj.getClazz.getName == nil) "Nil"
    else {
      val xs = toList(o)
      xs.mkString("List(", ", ", ")")
    }
  }
  
  def toList(o: HeapObject): List[HeapObject] = {
    val buf = new mutable.ListBuffer[HeapObject]
    var obj: Option[HeapObject] = Some(o)
    while (obj.isDefined) {
      obj.get.resolve("scala$collection$immutable$$colon$colon$$hd") map (buf +=)   
      obj = obj.get.resolve("tl")
    }
    buf.toList
  }
}
