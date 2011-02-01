package com.ssol.mat

object KnownTypes {
  final val ClassSymbol       = "scala.tools.nsc.symtab.Symbols$ClassSymbol"
  final val ModuleClassSymbol = "scala.tools.nsc.symtab.Symbols$ModuleClassSymbol"
  final val ModuleSymbol      = "scala.tools.nsc.symtab.Symbols$ModuleSymbol"
  final val MethodSymbol      = "scala.tools.nsc.symtab.Symbols$MethodSymbol"
  final val TermSymbol        = "scala.tools.nsc.symtab.Symbols$TermSymbol"
  final val TypeSymbol        = "scala.tools.nsc.symtab.Symbols$TypeSymbol"
    
  final val cons = "scala.collection.immutable.$colon$colon"
  final val nil = "scala.collection.immutable.Nil$"
    
  final val BatchSourceFile = "scala.tools.nsc.util.BatchSourceFile"
  final val EclipseFile = "scala.tools.eclipse.util.EclipseFile"
  final val CoreFile    = "org.eclipse.core.internal.resources.File"
  final val CorePath    = "org.eclipse.core.runtime.Path"
  
  final val DefaultEntry = "scala.collection.mutable.DefaultEntry"
}