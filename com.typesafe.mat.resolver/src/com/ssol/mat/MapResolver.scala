package com.ssol.mat

import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver
import org.eclipse.mat.snapshot.model._
import org.eclipse.mat.snapshot.extension.Subject

import KnownTypes._

@Subject(DefaultEntry)
class MapResolver extends IClassSpecificNameResolver {
  def resolve(o: IObject): String = {
    val obj = HeapObject(o)
    println("resolving " + o + obj.resolve("key") + obj.resolve("value"))
    (for { key <- obj.resolve("key")
          value <- obj.resolve("value")
      } yield "%s -> %s".format(key.classSpecificName, value.classSpecificName)) getOrElse null
  }
}