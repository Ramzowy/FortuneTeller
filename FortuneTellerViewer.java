import javax.swing.*;

public class FortuneTellerViewer {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FortuneTellerFrame("Frame").setVisible(true);
            }
        });

        FortuneTellerFrame aFrame = new FortuneTellerFrame("Frame");
    }
}