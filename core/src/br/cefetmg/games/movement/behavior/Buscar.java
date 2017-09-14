package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Buscar extends AlgoritmoMovimentacao {

    private static final char NOME = 's';

    public Buscar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Buscar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        output.velocidade = alvo.getObjetivo().cpy().sub(agente.posicao.cpy());
        
        output.velocidade.nor();
        output.velocidade.x *= maxVelocidade;
        output.velocidade.y *= maxVelocidade;
        
        agente.olharNaDirecaoDaVelocidade(output.velocidade);
        
        output.rotacao = 0;
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.S;
    }
}
