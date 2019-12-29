// src/main/scala/progscala3/implicits/implicit-conversions-resolution2.sc
// Add the following if you don't use the flag -language:implicitConversions
// import scala.language.implicitConversions

// WARNING: You must :paste mode in the REPL for the following.
// Using :load won't compile the two definitions together!
case class Foo(s: String)
object Foo {
  implicit def fromString(s: String): Foo = 
  	new Foo(s"object Foo implicit conversion: $s")
}
import Foo._

object scope {
  implicit def overridingConversion(s: String): Foo = 
  	new Foo(s"object scope implicit conversion: $s")

  def mf(foo: Foo): String  = foo.s 
  def ms(s: String): String = mf(s)
}

def m(foo: Foo): String = foo.s

m("string1")
scope.m("string2")
scope.m2("string3")
