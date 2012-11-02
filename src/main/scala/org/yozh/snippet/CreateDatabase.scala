package org.yozh.snippet

import slick.session.Database
import net.liftweb.http.S
import org.yozh.model.User

/**
 *
 * @author Artem
 */
class CreateDatabase {
   def render {
      Database.forURL(S.?("mysql.connection"), driver = "com.mysql.jdbc.Driver") withSession {
         User.ddl.createStatements
      }

      S.notice("Database created")
      S.redirectTo("/userform")
   }
}
