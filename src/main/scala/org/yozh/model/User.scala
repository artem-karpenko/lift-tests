package org.yozh.model

import scala.slick.driver.MySQLDriver.simple._
import slick.lifted.ColumnOption.{AutoInc, PrimaryKey}
import slick.lifted.Query


/**
 *
 * @author Artem
 */
object User extends Table[(Int, String, Int)]("user") {
   def id = column[Int]("id", PrimaryKey, AutoInc)
   def name = column[String]("name")
   def age = column[Int]("age")

   def * = id ~ name ~ age

   def exists(name: String) = {
      User.filter(_.name == name).list().length > 0
   }

   def create(name: String, age: Int) = {
      User.insert(1, name, age)
   }
}

class UserAlreadyExistsException(name: String) extends Exception("User " + name + " already exists")