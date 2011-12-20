package com.notnoop.todo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class TodoRepository {

    @Inject
    var mongoTemplate: MongoTemplate = _

    val logger = LoggerFactory.getLogger(classOf[TodoRepository])

    def create(todo: Todo): Todo = {
      mongoTemplate.insert(todo)
      todo
    }

    def update(todo: Todo) = {
         mongoTemplate.save(todo)
         todo
    }

    def findById(id: String) = {
        mongoTemplate.findById(id, classOf[Todo])
    }

    def findAll() = {
        mongoTemplate.findAll(classOf[Todo])
    }

    def remove(id: String) {
         mongoTemplate.remove(new Query(Criteria.where("id").is(id)), classOf[Todo])
    }

    def removeAll() {
        if (mongoTemplate.collectionExists(classOf[Todo])) {
            mongoTemplate.dropCollection(classOf[Todo])
            mongoTemplate.createCollection(classOf[Todo])
        }

    }

}

