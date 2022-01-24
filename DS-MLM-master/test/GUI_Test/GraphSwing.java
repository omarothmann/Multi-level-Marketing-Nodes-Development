/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Test;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.*;

/** @see https://stackoverflow.com/a/45055683/230513 */
public class GraphSwing {

    public static void main(String args[]) {
        EventQueue.invokeLater(new GraphSwing()::display);
    }

    private void display() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout()){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        Graph graph = new SingleGraph("Tutorial", false, true);
        graph.addEdge("AB", "A", "B");
        Node a = graph.getNode("A");
        a.setAttribute("xy", 1, 1);
        Node b = graph.getNode("B");
        b.setAttribute("xy", -1, -1);
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        ViewPanel viewPanel = viewer.addDefaultView(false);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
