package com.ssol.mat

object KnownTypes {
  private final val symbolsPackage = "scala.reflect.internal."
  
  final val ClassSymbol       = symbolsPackage + "Symbols$ClassSymbol"
  final val ModuleClassSymbol = symbolsPackage + "Symbols$ModuleClassSymbol"
  final val ModuleSymbol      = symbolsPackage + "Symbols$ModuleSymbol"
  final val MethodSymbol      = symbolsPackage + "Symbols$MethodSymbol"
  final val TermSymbol        = symbolsPackage + "Symbols$TermSymbol"
  final val TypeSymbol        = symbolsPackage + "Symbols$TypeSymbol"
    
  final val cons = "scala.collection.immutable.$colon$colon"
  final val nil = "scala.collection.immutable.Nil$"
    
  final val BatchSourceFile = "scala.tools.nsc.util.BatchSourceFile"
  final val EclipseFile = "scala.tools.eclipse.util.EclipseFile"
  final val CoreFile    = "org.eclipse.core.internal.resources.File"
  final val CorePath    = "org.eclipse.core.runtime.Path"
  
  final val DefaultEntry = "scala.collection.mutable.DefaultEntry"
    
  final val Contexts = "scala.tools.nsc.typechecker.Contexts$Context"
}