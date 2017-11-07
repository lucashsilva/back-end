package com.ufcg.sad.models.questionario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ufcg.sad.models.questionario.Questao;
import com.ufcg.sad.models.questionario.TipoResposta;

public class QuestaoTest {
	@Test
	public void testQuestao() {
		Questao questao = new Questao(new Long(1), "A ementa da disciplina foi seguida adequadamente?", TipoResposta.ESCOLHA_SIMPLES, "");
		
		assertEquals(questao.getId(), new Long(1));
		assertEquals(questao.getComentario(), "");
		assertEquals(questao.getEnunciado(), "A ementa da disciplina foi seguida adequadamente?");
		assertEquals(questao.getTipoResposta(), TipoResposta.ESCOLHA_SIMPLES);
	}
}
