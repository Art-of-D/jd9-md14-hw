package com.app.model;

import com.app.entity.Note;
import com.app.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    @Autowired
    private NoteService notes;

    @GetMapping("/note/list")
    public ModelAndView getList(){
        return new ModelAndView("test").addObject("notes", notes.listAll());
    }
    @GetMapping("/note/get")
    public ModelAndView getById(@RequestParam(required = false,name = "id",defaultValue = "1") String id){
        return new ModelAndView("test").addObject("notes", notes.getById(Long.parseLong(id)));
    }

    @PostMapping("/note/delete")
    public ModelAndView delete(@RequestParam(name = "id") String id) {
        notes.deleteById(Long.parseLong(id));
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping(value = "/note/edit", params = "id")
    public ModelAndView edit(@RequestParam("id") long id){
        Note note = notes.getById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/note/edit")
    public ModelAndView edit(@RequestParam(name = "id") String id, @RequestParam(name = "title") String title,
                             @RequestParam(name = "content") String content) {
        notes.update(new Note(Long.parseLong(id), title, content));
        return new ModelAndView("redirect:/note/list");
    }

}
