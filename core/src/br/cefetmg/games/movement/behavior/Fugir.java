package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;

/**
 * Guia o agente de forma a fugir na direção contrária ao alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Fugir extends AlgoritmoMovimentacao {

    private static final char NOME = 'f';

    public Fugir(float maxVelocidade) {
        super(NOME);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        output.velocidade = agente.posicao.cpy().sub(alvo.getObjetivo().cpy());
        
        output.velocidade.nor();
        output.velocidade.x *= maxVelocidade;
        output.velocidade.y *= maxVelocidade;
        
        agente.olharNaDirecaoDaVelocidade(output.velocidade);
        
        output.rotacao = 0;
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.F;
    }

}
