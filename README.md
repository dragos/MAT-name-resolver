MAT extensions for Scala (compiler)
==============

[Eclipse MAT][mat] is an Eclipse-based tool for memory analysis. This plugin allows
MAT to print a better description for some objects coming from Scala (such as Lists).

Currently it is directed towards finding memory leaks in the Scala compiler, so
most of the types it knows about come from scalac.

Install
-------

Point Eclipse (or the MAT stand-alone application) to the following update site:

http://download.scala-ide.org/plugins/mat-name-resolver/site/

Features 
----------

This plugin adds support for some Scala types in MAT. This plugin depends on internals of the types it "understands", and the current version works well with Scala 2.10.2.

We handle to following types:

- `List/Nil`: List(.., .., ..) or Nil
- `mutable.DefaultEntry` (prints key -> value)
- `scala.reflect.internal.Names$Name` (Term/Type)  - the proper name (scalac interns names in a custom array, so MAT cannot display them correctly)
- `Symbol (Type/Method/Module/Class/ModuleSymbol)` - the Scala name, and its validity (the runId of the field validTo)
- `EclipseFile/Path` (the path to the file)
- `BatchSourceFile` (the path to the underlying file)

[mat]: http://www.eclipse.org/mat/