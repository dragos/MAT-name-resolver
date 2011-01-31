MAT extensions for Scala compiler
==============

[Eclipse MAT][mat] is a fine tool for memory analysis (hunting memory leaks). This plugin allows
MAT to print a better description for some objects coming from Scala (such as Lists).

Currently it is directed towards finding leaks in the Scala compiler itself, so
most of the types it knows about come from scalac.

Install
-------

Download the jar-file and copy it in your Eclipse dropin/ directory.

Features 
----------

This plugin adds support for some Scala types in MAT. It will print better values for the following types:

- List/Nil: List(.., .., ..) or Nil
- Symbol (Type/Method/Module/Class/ModuleSymbol) - the Scala name
- scala.tools.nsc.symtab.Names$Name (Term/Type)  - the proper name (scalac interns names in a custom array, so MAT cannot display them correctly)
- EclipseFile/Path (the path to the file)
- BatchSourceFile (the path to the underlying file)

[mat]: http://www.eclipse.org/mat/