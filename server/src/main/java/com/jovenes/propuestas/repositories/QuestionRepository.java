package com.jovenes.propuestas.repositories;


import com.jovenes.propuestas.entities.Question;
import com.jovenes.propuestas.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends BaseRepository<Question> {
}
