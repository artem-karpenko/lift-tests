package bootstrap.liftweb

import net.liftweb.http.LiftRules
import net.liftweb.sitemap.{SiteMap, Loc, Menu}

/**
 *
 * @author Artem
 */
class Boot {
   def boot {
      LiftRules.addToPackages("org.yozh")
   }
}