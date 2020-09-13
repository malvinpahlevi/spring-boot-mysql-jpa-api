package com.yanmalvin.easynotesapp.controller;

import com.yanmalvin.easynotesapp.exception.ResourceNotFoundException;
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
    * Create new note
    *
    * The @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content with @NotBlank annotation in the Note model?
    * If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
    * */
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);
    }

    /*
    *  Get single note
    *
    * (ResourceNotFoundException)return a 404 Not Found error to the client
     * */
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId){
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    /*
    * Update Note
    *
    * */
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails){

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updateNote = noteRepository.save(note);
        return updateNote;

    }

}
