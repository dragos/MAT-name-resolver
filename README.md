MAT extensions for Scala compiler
==============

[Eclipse MAT][mat] is a fine tool for memory analysis (hunting memory leaks). This plugin allows
MAT to print a better description for some objects coming from Scala (such as Lists).

Currently it is directed towards finding leaks in the Scala compiler, so
most of the types it knows about come from scalac.

Install
-------

Download the jar-file and copy it in your Eclipse dropin/ directory.

Features 
----------

This plugin adds support for some Scala types in MAT. It will print better values for the following types:

- List/Nil: List(.., .., ..) or Nil
- mutable.DefaultEntry (prints key -> value)
- scala.tools.nsc.symtab.Names$Name (Term/Type)  - the proper name (scalac interns names in a custom array, so MAT cannot display them correctly)
- Symbol (Type/Method/Module/Class/ModuleSymbol) - the Scala name, and its validity (the runId of the field validTo)
- EclipseFile/Path (the path to the file)
- BatchSourceFile (the path to the underlying file)

[mat]: http://www.eclipse.org/mat/