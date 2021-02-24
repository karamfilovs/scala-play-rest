package api

import play.api.Logger
import play.api.libs.ws.ahc.AhcCurlRequestLogger
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.test.WSTestClient

import scala.concurrent.Await
import scala.concurrent.duration._

abstract class HTTPClient {
  private val authHeaderValue: String = "Basic a2FyYW1maWxvdnNAZ21haWwuY29tOjEyMzQ1Ng=="
  private val PlayPort = 9000
  private val MaxWait = 10.seconds
  private val ws: WSClient = WSTestClient.newClient(PlayPort).asScala()
  private val logger: Logger = Logger(this.getClass)
  private val baseUrl: String = sys.props.getOrElse("url", "https://st2016.inv.bg/RESTapi")


  private def printResponse(response: WSRequest#Response): Unit = {
    println("--------------------------------------- RESPONSE ---------------------------------------")
    logger.info(response.status.toString)
    if (response.body.nonEmpty)
      logger.info(response.body)
  }

  private def initRequest(path: String) = {
    println("--------------------------------------- REQUEST ---------------------------------------")
    ws.url(baseUrl + path)
      .withHttpHeaders("Content-Type" -> "application/json", "Authorization" -> authHeaderValue)
      .withRequestFilter(AhcCurlRequestLogger.apply())
  }


  protected def post(path: String, body: String): WSResponse = {
    val response = Await.result(initRequest(path).post(body), MaxWait)
    printResponse(response)
    response

  }

  protected def get(path: String): WSResponse = {
    val response = Await.result(initRequest(path).get(), MaxWait)
    printResponse(response)
    response
  }

  protected def delete(path: String): WSResponse = {
    val response = Await.result(initRequest(path).delete(), MaxWait)
    printResponse(response)
    response
  }


  protected def put(path: String, body: String): WSResponse = {
    val response = Await.result(initRequest(path).put(body), MaxWait)
    printResponse(response)
    response
  }

}
