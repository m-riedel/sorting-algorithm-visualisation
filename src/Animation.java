import java.awt.*;
import javax.swing.*;

public class Animation extends JPanel {

    private SortingAlgorithms sortingAlgorithms;
    private final int numOfElementsToSort = 49;
    private final JFrame f;

    private final static int widthOfWindow = 997;
    private final static int heightOfWindow = 500;

    private final static Object[] options = {
            "BubbleSort",
            "Selection Sort",
            "Insertion Sort"
    };

    public Animation(JFrame f){
        sortingAlgorithms = new SortingAlgorithms(numOfElementsToSort, widthOfWindow, heightOfWindow, f);
        this.f = f;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        sortingAlgorithms.paintPillar(g);
    }

    public static void main(final String[] args) {

        Animation panel;
        JFrame f = new JFrame("Animation of Sorting Algorithms");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new Animation(f);
        panel.setBackground(Color.BLACK);
        f.getContentPane().add(panel, BorderLayout.CENTER);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(widthOfWindow, heightOfWindow);
        f.setVisible(true);
        f.setResizable(false);

        int n = JOptionPane.showOptionDialog(
                f,
                "Choose the Sorting Algorithm to Visualize",
                "Choose Sorting Algorithm",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]
        );

        switch (n){
            case 0:
                try {
                    panel.getSortingAlgorithms().bubbleSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    panel.getSortingAlgorithms().selectionSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    panel.getSortingAlgorithms().insertionSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    panel.getSortingAlgorithms().iniMergeSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    panel.getSortingAlgorithms().quickSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }

        //Runnable gui = new Runnable() {

           // @Override
            //public void run() {
            //}
        //};
        // GUI must start on EventDispatchThread:
        //SwingUtilities.invokeLater(gui);
    }

    public SortingAlgorithms getSortingAlgorithms() {
        return sortingAlgorithms;
    }

    public void setSortingAlgorithms(SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public JFrame getF() {
        return f;
    }
}
