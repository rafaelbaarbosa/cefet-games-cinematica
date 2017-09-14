package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;

/**
 * Movimenta o agente em uma direção aleatória, vagando pelo cenário.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Vagar extends AlgoritmoMovimentacao {

    private static final char NOME = 'w';
    private float maxAngular = 30f;

    public Vagar() {
        super(NOME);
    }

    public Vagar(float tangencial, float angular) {
        super(NOME);
        maxVelocidade = tangencial;
        maxAngular = angular;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        output.velocidade = agente.getOrientacaoComoVetor().scl(maxVelocidade);
         
        output.rotacao = (MathUtils.random() - MathUtils.random()) * maxAngular;
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.W;
    }
}
