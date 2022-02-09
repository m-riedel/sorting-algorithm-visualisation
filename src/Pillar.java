import java.awt.*;

public class Pillar {

    private int posX;
    private int posY;
    private final int width;
    private final int height;
    private boolean isSelected;
    private final int value;

    private final Color colorOnSelect = Color.RED;
    private final Color colorDefault = Color.WHITE;

    public Pillar(int posX, int posY, int width, int height, boolean isSelected) {
        this.posX = posX;
        this.posY = posY - height;
        this.width = width;
        this.height = height;
        this.value = height;
        this.isSelected = isSelected;
    }

    public Pillar(int posX, int posY, int width, int height) {
        this(posX, posY, width, height, false);
    }

    public void paint(Graphics g) {
        if (isSelected)
            g.setColor(colorOnSelect);
        else
            g.setColor(colorDefault);
        g.fillRect(this.posX, this.posY, this.width, this.height);
        g.setColor(Color.BLACK);
        g.drawRect(this.posX, this.posY, this.width, this.height);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY + height;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Color getColorOnSelect() {
        return colorOnSelect;
    }

    public Color getColorDefault() {
        return colorDefault;
    }

    public int getValue() {
        return value;
    }
}
