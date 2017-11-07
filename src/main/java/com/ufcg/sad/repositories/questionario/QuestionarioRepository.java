package com.ufcg.sad.repositories.questionario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sad.models.questionario.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {

}
