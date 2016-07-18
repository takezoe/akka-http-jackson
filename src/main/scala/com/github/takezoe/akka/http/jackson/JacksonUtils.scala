package com.github.takezoe.akka.http.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.ClassTag

object JacksonUtils {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def serialize(doc: AnyRef): String = mapper.writeValueAsString(doc)

  def deserialize[T](json: String)(implicit c: ClassTag[T]): T = mapper.readValue(json, c.runtimeClass).asInstanceOf[T]

}
