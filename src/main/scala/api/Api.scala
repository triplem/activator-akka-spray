package api

import spray.routing.HttpService

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * The REST API layer. It exposes the REST services, but does not provide any
 * web server interface.<br/>
 * Notice that it requires to be mixed in with ``core.CoreActors``, which provides access
 * to the top-level actors that make up the system.
 */
trait Api extends HttpService with CoreActors with Core {

  //protected implicit val system : ActorSystem
  val routes =
    new RegistrationService(registration).route ~
    new MessengerService(messenger).route ~
    new FruitService(fruit).fruitroute


}
