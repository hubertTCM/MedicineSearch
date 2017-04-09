package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel rightNorthPanel; // �Ҳ�����еı������
	private JScrollPane rightScrollPane; // �Ҳ�����е�Scroll���
	private JLabel rightLabel; // �Ҳ�����еı�������еı�ǩ���
	private JButton searchNextButton; // �Ҳ�����еı�������еİ�ť���
	private JTextArea jTextArea; // �Ҳ�����е��м�Scroll����е�TextArea���

	public RightPanel(MainFrame mainFrame) {
		this.setLayout(new BorderLayout());
		rightNorthPanel = new JPanel(new GridLayout(1, 3));
		jTextArea = new JTextArea();
		rightLabel = new JLabel("�����ı�");
		searchNextButton = new JButton("����/��һ��");
		rightNorthPanel.add(new JLabel(""));
		rightNorthPanel.add(rightLabel);
		rightNorthPanel.add(searchNextButton);
		this.add(rightNorthPanel, BorderLayout.NORTH);
		jTextArea.setEditable(false); // ���ò��ɱ༭
		jTextArea.setText("�������Ѷ�����������24Сʱ�ṩ��½��̨�塢��ۡ������ش�������Ѷ,\n��˾۽�����׷�١����֪������ʱ���ȵ�,���¡���ʷ����");
		rightScrollPane = new JScrollPane(jTextArea);
		this.add(rightScrollPane, BorderLayout.CENTER);
		// ��ʼ��text
		// ��ʼ��pattern��matcher
		mainFrame.setText(jTextArea.getText());
		// �þ�һ��Ҫ����matcher = pattern.matcher(text);֮�󣬷����ָ���쳣
		searchNextButton.addActionListener(
				new MyButtonActionListener(mainFrame, jTextArea, mainFrame.leftPane.getLeftTable(), mainFrame.getMatcher()));
	}

	public JTextArea getjTextArea() {
		return jTextArea;
	}
}