package project.world.box;

public class GrassBox extends Box {
    private boolean mowed = false;

    public GrassBox(int x, int y) {
        super(x, y);
    }

    public void setMowed(boolean mowed) {
        this.mowed = mowed;
    }

    public boolean isMowed() {
        return mowed;
    }

    public String toString() {
        if (pawn != null) {
            return pawn.getName();
        } else if (mowed) {
            return "__";
        } else {
            return "||";
        }
    }
}
