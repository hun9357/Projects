import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Center {
	public void align(JTable t, JLabel l1,JLabel l2,JLabel l3,JLabel l4)
	{
		DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
	    
		rendar.setHorizontalAlignment(l1.CENTER);
	    t.getColumnModel().getColumn(0).setCellRenderer(rendar); 
	    
	    rendar.setHorizontalAlignment(l2.CENTER);
	    t.getColumnModel().getColumn(1).setCellRenderer(rendar);
	    
	    rendar.setHorizontalAlignment(l3.CENTER);
	    t.getColumnModel().getColumn(2).setCellRenderer(rendar);

	    rendar.setHorizontalAlignment(l4.CENTER);
	    t.getColumnModel().getColumn(3).setCellRenderer(rendar);
	    
	}
}
