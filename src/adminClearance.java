
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class adminClearance extends JPanel implements ActionListener{
    private mainPageAdmin AMain;
	JTable cTable;
    JPanel cpanel;
    JPanel cheader;
    JPanel average;
    JLabel header;
    JTextField searchbar;
    JButton searchbutton;
    JLabel Ssearch;
    public adminClearance(mainPageAdmin MAdmin){
        this.AMain = MAdmin;
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
            cTable.setEnabled(true);
            cTable.setRowHeight(25);
            cTable.getTableHeader().setBounds(100, 75, 900, 25);

        cpanel = new JPanel();
            cpanel.setLayout(null);
            cpanel.setPreferredSize(new Dimension(200, 100));
            cpanel.setBackground(Color.lightGray);
            cpanel.add(cTable.getTableHeader());
            cpanel.add(cTable);

        searchbar = new JTextField();
            searchbar.setBounds(730, 100, 250, 30);
            searchbar.setBorder(null);

        searchbutton = new JButton("SEARCH");
            searchbutton.setBounds(990, 100, 80, 30);
            searchbutton.setBackground(new Color(0,0,98));
            searchbutton.setForeground(Color.WHITE);
            searchbutton.setFont(new Font(null, Font.PLAIN, 10));
            searchbutton.setFocusable(false);
            searchbutton.setBorder(null);
        
        Ssearch = new JLabel("Search Students");
            Ssearch.setBounds(730, 125, 100, 30);
            Ssearch.setForeground(Color.WHITE);
            Ssearch.setFont(new Font("null", Font.BOLD, 12));
        
        header = new JLabel("CLEARANCE");
            header.setForeground(Color.WHITE);
            header.setBounds(10,65,500,20);
            header.setFont(new Font("arial", Font.BOLD, 26));
            
        cheader = new JPanel();
            cheader.setLayout(null);
            cheader.setBackground(Color.GRAY);
            cheader.setPreferredSize(new Dimension(0, 150));
            cheader.add(header);
            cheader.add(searchbar);
            cheader.add(searchbutton);
            cheader.add(Ssearch);
        
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
