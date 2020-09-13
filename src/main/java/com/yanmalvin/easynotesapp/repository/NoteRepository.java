/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanmalvin.easynotesapp.repository;

import com.yanmalvin.easynotesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Malvin Pahlevi
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
    
}
