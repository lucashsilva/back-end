package com.ufcg.sad.repositories.questionario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sad.models.questionario.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
