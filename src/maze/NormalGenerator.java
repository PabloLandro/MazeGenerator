/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author landr
 */
public class NormalGenerator implements Generator{
    
    private static final float BRANCH_ODD = 0.5f;
    private float extension;
    
    private boolean finished;
    private Tile tile;

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
    
}
