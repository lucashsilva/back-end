package com.ufcg.sad.models.questao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import com.ufcg.sad.models.Questao;
import com.ufcg.sad.models.TipoResposta;
import com.ufcg.sad.repositories.QuestaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestaoTest {
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Test
	public void testQuestao() {
		Questao questao1 = new Questao(new Long(1), "A ementa da disciplina foi seguida adequadamente?", TipoResposta.ESCOLHA_SIMPLES, "");
		Questao questao2 = new Questao(new Long(2), "Você tem alguma sugestão para melhorar a disciplina?", TipoResposta.TEXTO, "");
		questaoRepository.save(questao1);
		questaoRepository.save(questao2);
	}
	
	@Test(expected = TransactionSystemException.class)
	public void testQuestaoInvalida1() {
		Questao questao = new Questao(new Long(1), null, null, null);
		questaoRepository.save(questao);
	}
	
	@Test(expected = TransactionSystemException.class)
	public void testQuestaoInvalida2() {
		Questao questao = new Questao(new Long(1), "A ementa da disciplina foi seguida adequadamente?", null, "");
		questaoRepository.save(questao);
	}
	
	@Test(expected = TransactionSystemException.class)
	public void testQuestaoInvalida3() {
		Questao questao = new Questao(new Long(1), "Que pontos precisam ser melhorados?", TipoResposta.MULTIPLA_ESCOLHA, null);
		questaoRepository.save(questao);
	}
	
	@Test(expected = TransactionSystemException.class)
	public void testQuestaoInvalida4() {
		Questao questao = new Questao(new Long(1), null, TipoResposta.MULTIPLA_ESCOLHA, "");
		questaoRepository.save(questao);
	}
}
