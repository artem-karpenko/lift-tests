package org.yozh.snippet

import net.liftweb.http.{SHtml, S}
import java.util.PropertyResourceBundle
import slick.session.Database
import org.yozh.model.{UserAlreadyExistsException, User}
import Database.threadLocalSession
import slick.lifted.Query
import net.liftweb.util.Helpers._

/**
 *
 * @author Artem
 */
object UserForm {
   def render = {
      var name = ""
      var age = 0

      def process() {
         if (name.isEmpty) {
            S.error("Please enter name")
         }
         if (age == 0) {
            S.error("Please enter age")
         }

         if (S.errors.isEmpty) {
            createNewUser(name, age)
         }
      }

      "name=name" #> SHtml.onSubmit(name = _) & // set the name
         // set the age variable if we can convert to an Int
         "name=age" #> SHtml.onSubmit(s => asInt(s).foreach(age = _)) &
         // when the form is submitted, process the variable
         "type=submit" #> SHtml.onSubmitUnit(process)
   }

   def createNewUser(name: String, age: Int) = {
      Database.forURL(S.?("mysql.connection"), driver = "com.mysql.jdbc.Driver") withSession {
         if (User.exists(name)) {
            throw new UserAlreadyExistsException(name)
         }
         else {
            User.create(name, age)
         }
      }
   }
}
