package music4U;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import weka.core.Instance;

public class MusicView extends JFrame { //implements ActionListener {
	
	private static MusicView INSTANCE;
	
	private MusicView() {
		
	}
	
	public static MusicView getInstance(){
		if (INSTANCE == null){
			INSTANCE = new MusicView();
		}
		return INSTANCE;
	}
	
	public void draw(ArrayList<MusicRecomended> musics){
		JPanel panel = new JPanel(new GridLayout(0, 3));
		for (MusicRecomended i : musics){
			panel.add(new JLabel(i.instance.stringValue(0)));
			JButton gostei = new JButton("Gostei");
			gostei.addActionListener(new Gostei(i));
			panel.add(gostei);
			JButton desgostei = new JButton("Desgostei");
			desgostei.addActionListener(new Desgostei(i));
			panel.add(desgostei);
		}
		panel.setSize(500, 500);
		add(panel);
		this.setSize(500, 500);
		pack();
		this.setTitle("Musicas");
		setVisible(true);
	}
	
	public class Gostei implements ActionListener {
		
		private MusicRecomended mr;
		
		public Gostei(MusicRecomended mr) {
			this.mr = mr;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			MusicEvaluation me = MusicEvaluation.getInstance();
			me.alterClass(mr, "true");
		}
		
	}
	
	public class Desgostei implements ActionListener {
		
		private MusicRecomended mr;
		
		public Desgostei(MusicRecomended mr) {
			this.mr = mr;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			MusicEvaluation me = MusicEvaluation.getInstance();
			me.alterClass(mr, "true");
		}
		
	}

}