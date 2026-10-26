
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class clearance extends JPanel implements ActionListener{
    private mainPageStudent SMain;
	JTable cTable;
    JPanel cpanel;
    JPanel cheader;
    JPanel average;
    JLabel header;

    public clearance(mainPageStudent MStudent){
        this.SMain = MStudent;
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        String [] cColumn = {"clearance", "Status"};
        Object[][] cdata = {
            {"clearance1", "cleared"}, 
            {"clearance2", "cleared"}, 
            {"clearance3", "cleared"},
            {"clearance4 ", "cleared"}};

         cTable = new JTable(cdata, cColumn);
            cTable.setBounds(100,100, 900, 200);
            cTable.setFont(new Font("arial", Font.PLAIN, 15));
            cTable.setEnabled(false);
            cTable.setRowHeight(25);
            cTable.getTableHeader().setBounds(100, 75, 900, 25);

        cpanel = new JPanel();
            cpanel.setLayout(null);
            cpanel.setPreferredSize(new Dimension(200, 100));
            cpanel.setBackground(Color.lightGray);
            cpanel.add(cTable.getTableHeader());
            cpanel.add(cTable);

        header = new JLabel("CLEARANCE");
            header.setForeground(Color.WHITE);
            header.setBounds(10,65,500,20);
            header.setFont(new Font("arial", Font.BOLD, 26));
            
        cheader = new JPanel();
            cheader.setLayout(null);
            cheader.setBackground(Color.GRAY);
            cheader.setPreferredSize(new Dimension(0, 150));
            cheader.add(header);
        
        average = new JPanel();
            average.setLayout(null);
            average.setBackground(Color.GRAY);
            average.setPreferredSize(new Dimension(0, 50));    
        
        add(cpanel, BorderLayout.CENTER);
        add(cheader, BorderLayout.NORTH); 
        add(average, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
