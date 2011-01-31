package com.ssol.mat

import org.eclipse.mat.snapshot.model._
import scala.collection.JavaConversions._

case class HeapObject(val underlying: IObject) {
  def resolve(name: String): Option[HeapObject] = underlying.resolveValue(name) match {
    case null =>
      println(name + " not found ")
      None
    case obj: IObject => 
      Some(HeapObject(obj))
    case r =>
      println("resolved to %s".format(r.getClass))
      None
  }
  
  def fields: List[HeapField] = underlying match {
    case inst: IInstance =>
      inst.getFields.map(HeapField).toList
    case _ => List()
  }
  
  def field(name: String): Option[HeapField] = underlying match {
    case inst: IInstance =>
      Option(inst.getField(name)) map HeapField
    case _ => 
      None
  }
  
  def toInt: Int = {
    underlying match {
      case n: Number => n.intValue
      case _ => throw new NumberFormatException(underlying.getClass.toString)
    }
  }
  
  def classSpecificName = underlying.getClassSpecificName
  
  override def toString = underlying.toString
}

case class HeapField(val underlying: Field) {
  def value = underlying.getValue
  def tpe   = underlying.getType
  def toInt: Int = {
    value match {
      case n: Number => n.intValue
      case _ => throw new NumberFormatException(underlying.getClass.toString)
    }
  }
}