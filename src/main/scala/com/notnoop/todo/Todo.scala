package com.notnoop.todo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.reflect.BeanProperty

@Document
case class Todo(
    @BeanProperty @Id var id: String,
    @BeanProperty var content: String,
    @BeanProperty var order: java.lang.Integer,
    @BeanProperty var done: java.lang.Boolean) {

    def this(content: String) = this(null, content, 0, false)
    def this() = this(null)


    override def toString() = {
        "Todo{" + "id=" + id + ", content=" + content + ", order=" + order + ", done=" + done + '}'
    }

}

