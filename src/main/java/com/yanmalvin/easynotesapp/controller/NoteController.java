package com.yanmalvin.easynotesapp.controller;

import com.yanmalvin.easynotesapp.model.Note;
import com.yanmalvin.easynotesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    /*
    *  @GetMapping is a short from of
    *  @RequestMapping(value="/notes", method=RequestMethod.GET)
    * */
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();

    }

    /*
    *  Create new note
    * */
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);
    }




}
