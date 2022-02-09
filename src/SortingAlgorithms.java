import javax.swing.*;
import java.awt.*;

public class SortingAlgorithms {

    private Pillar[] pillars;
    private final int numPillars;
    private final int widthPillars = 20;

    private final int widthWindow;
    private final int heightWindow;

    private final JFrame f;

    private final int sleepTime =5;

    public SortingAlgorithms(int numPillars, int widthWindow, int heightWindow, JFrame f){
        this.numPillars = numPillars;
        this.widthWindow = widthWindow;
        this.heightWindow = heightWindow;
        this.f = f;
        pillars = new Pillar[numPillars];
        int tempSize;
        for(int i = 0; i < numPillars; i++){
            tempSize = (int) (((Math.random() +0.2) * 400d));
            pillars[i] = new Pillar(i * widthPillars, heightWindow, widthPillars, tempSize, false);
        }
    }

    public void paintPillar(Graphics g){
        for(Pillar pillar : pillars){
            pillar.paint(g);
        }
    }

    public void calculateNextStep() {

    }

    public void bubbleSort() throws InterruptedException {
        Pillar tempPillar;
        int tempPillarX;
        for(int j = 1; j < numPillars; j++){
            for (int i = 0; i < numPillars - j; i++) {
                pillars[i].setSelected(true);
                pillars[i+1].setSelected(true);
                repaint();
                if (pillars[i].getValue() > pillars[i + 1].getValue()) {
                    tempPillar = pillars[i];
                    pillars[i] = pillars[i + 1];
                    pillars[i + 1] = tempPillar;
                    //Switch posY and posX positions
                    tempPillarX = pillars[i +1].getPosX();
                    pillars[i +1].setPosX(pillars[i].getPosX());
                    pillars[i].setPosX(tempPillarX);
                    repaint();
                    for(Pillar pillar : pillars) {
                        pillar.setSelected(false);
                    }
                    repaint();
                }
                for(Pillar pillar : pillars) {
                    pillar.setSelected(false);
                }
                f.repaint();
            }
        }
        sortingCompleteDialog();
    }

    public void selectionSort() throws InterruptedException {
        int tempPillarX;
        for (int i = 0; i < numPillars - 1; i++) {
            int minPos = i;
            Pillar min = pillars[minPos];
            pillars[i].setSelected(true);
            repaint();
            for (int j = i + 1; j < numPillars; j++) {
                pillars[j].setSelected(true);
                repaint();
                if(min.getValue() > pillars[j].getValue()){
                    if(!min.equals(pillars[i]))
                        min.setSelected(false);
                    minPos = j;
                    min = pillars[j];
                    min.setSelected(true);
                    repaint();
                }else {
                    pillars[j].setSelected(false);
                    repaint();
                }
            }
            if(minPos != i){
                pillars[minPos] = pillars[i];
                pillars[i] = min;
                tempPillarX = min.getPosX();
                min.setPosX(pillars[minPos].getPosX());
                pillars[minPos].setPosX(tempPillarX);
                repaint();
                for(int k = i +1; k < numPillars; k++) {
                    pillars[k].setSelected(false);
                }
                repaint();
            }
            for(Pillar pillar : pillars) {
                pillar.setSelected(false);
                f.repaint();
            }
        }
        sortingCompleteDialog();
    }

    public void insertionSort() throws InterruptedException{
        int tempPillarX;
        for (int i = 1; i < numPillars; ++i) {
            Pillar key = pillars[i];
            int j = i - 1;
            pillars[i].setSelected(true);
            repaint();
            while (j >= 0 && pillars[j].getValue() > key.getValue()) {
                tempPillarX = pillars[j].getPosX();
                pillars[j+1] = pillars[j];
                pillars[j+1].setPosX(key.getPosX());
                pillars[j] = key;
                pillars[j].setPosX(tempPillarX);
                repaint();
                pillars[j+1].setSelected(false);
                repaint();
                j = j - 1;
            }
            pillars[j + 1] = key;
            pillars[i].setSelected(false);
            repaint();
            for(Pillar pillar : pillars) {
                pillar.setSelected(false);
                f.repaint();
            }
        }
        for(Pillar pillar : pillars) {
            pillar.setSelected(false);
            f.repaint();
        }
        sortingCompleteDialog();
    }
    public void iniMergeSort() throws  InterruptedException{
        mergeSort(pillars, numPillars);
    }

    public void mergeSort(Pillar[] a, int n) throws InterruptedException{
        if (n < 2) {return;}
        int mid = n / 2;

        Pillar[] l = new Pillar[mid];
        Pillar[] r = new Pillar[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(l, r, mid, n - mid);
    }

    public void merge(Pillar[] l, Pillar[] r, int left, int right) throws InterruptedException {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            pillars[k].setSelected(true);
            repaint();
            if (l[i].getValue() <= r[j].getValue()) {
                l[i].setSelected(true);
                repaint();
                l[i].setPosX(pillars[k].getPosX());
                pillars[k++] = l[i++];
            }
            else{
                r[j].setSelected(true);
                repaint();
                r[j].setPosX(pillars[k].getPosX());
                pillars[k++] = r[j++];
            }
            for(Pillar pillar : pillars)
                pillar.setSelected(false);
            repaint();
        }
        while (i < left) {
            l[i].setSelected(true);
            repaint();
            l[i].setPosX(pillars[k].getPosX());
            pillars[k++] = l[i++];
            l[i-1].setSelected(false);
            repaint();
        }
        while (j < right) {
            r[j].setSelected(true);
            repaint();
            r[j].setPosX(pillars[k].getPosX());
            pillars[k++] = r[j++];
            r[j-1].setSelected(false);
            repaint();
        }
    }

    public void quickSort() throws InterruptedException{
    }

    private void repaint() throws InterruptedException {
        f.repaint();
        Thread.sleep(sleepTime);
    }

    private void sortingCompleteDialog(){
        JOptionPane.showMessageDialog(
                f,
                "Sorting Complete!"
        );
    }



}
