package com.notnoop.todo

import javax.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.web.bind.annotation._

@Controller
@RequestMapping(Array("/api/todo"))
class TodoController {

    @Inject
    private var todoRepository: TodoRepository = _

    val logger = LoggerFactory.getLogger(classOf[TodoController])

    @RequestMapping(method = Array(RequestMethod.GET), produces = Array("application/json")) @ResponseBody
    def findAll(): java.util.List[Todo] = {
        todoRepository.findAll()
    }

    @RequestMapping(value = Array("{id}"),method = Array(RequestMethod.GET) ) @ResponseBody
    def get( @PathVariable( "id" ) id: String): Todo = {
        this.todoRepository.findById(id)
    }

    @RequestMapping(method = Array(RequestMethod.POST), consumes =
    Array("application/json"), produces = Array("application/json"))
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    def create(@RequestBody todo: Todo): Todo = {
        Assert.notNull(todo)
        todoRepository.create(todo)
    }

    @RequestMapping(value = Array("{id}"), method = Array(RequestMethod.PUT)) @ResponseStatus(HttpStatus.OK)
    def update(@RequestBody todo: Todo, @PathVariable id: String) {
        Assert.isTrue(todo.id.equals(id))
        todoRepository.update(todo)
    }

    @RequestMapping(value = Array("{id}"), method = Array(RequestMethod.DELETE)) @ResponseStatus(HttpStatus.OK)
    def remove(@PathVariable id: String) {
        todoRepository.remove(id)
    }
}

