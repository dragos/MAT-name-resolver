package com.ssol.mat

import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver
import org.eclipse.mat.snapshot.model._
import org.eclipse.mat.snapshot.extension.Subjects

import KnownTypes._

@Subjects(Array(CoreFile, CorePath, EclipseFile, BatchSourceFile))
class SourceFileResolver extends IClassSpecificNameResolver {
  
  def resolvePath(o: IObject): String = {
    val obj = HeapObject(o)
    val snapshot = obj.underlying.getSnapshot
    obj.resolve("segments") match {
      case Some(HeapObject(array: IObjectArray)) =>
        val segments = array.getReferenceArray() map (addr => HeapObject(snapshot.getObject(snapshot.mapAddressToId(addr))))
        segments.map(_.classSpecificName).mkString("", "/", "")
      case None =>
        println("didn't find segments")
        null
    }
  }
  
  def resolveFile(o: IObject): String = {
    val obj = HeapObject(o)
    (obj.resolve("path") map ("file: " + _.classSpecificName)) getOrElse null
  }
  
  def resolveEclipseFile(o: IObject): String = {
    val obj = HeapObject(o)
    obj.resolve("underlying") map (_.classSpecificName) getOrElse null
  }

  def resolveBatchSourceFile(o: IObject): String = {
    val obj = HeapObject(o)
    obj.resolve("file") map (_.classSpecificName) getOrElse null
  }

  def resolve(o: IObject): String = {
    val obj = HeapObject(o)
    o.getClazz().getName() match {
      case CorePath => resolvePath(o)
      case CoreFile => resolveFile(o)
      case EclipseFile => resolveEclipseFile(o) 
      case BatchSourceFile => resolveBatchSourceFile(o)
      case _ => "can't happen"
    }
  }
}