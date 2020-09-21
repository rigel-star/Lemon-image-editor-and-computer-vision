package org.lemon.gui.texture;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import org.lemon.image.WoodTexture;

public class TextureList extends JList<TexturePanel> {
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	
	private static DefaultListModel<TexturePanel> model = new DefaultListModel<>();
	private static TextureItemRenderer renderer = new TextureItemRenderer();
	
	
	public TextureList() {
		super( model );
		setCellRenderer( renderer );
		setLayoutOrientation( JList.HORIZONTAL_WRAP );
		setVisibleRowCount( -1 );
		
		renderer.setSelectionBackground( new Color( 240, 240, 240 ));
		
		add( new TexturePanel( new WoodTexture()) );
		add( new TexturePanel( new WoodTexture()) );
	}
	
	
	public static void main( String[] args ) {
		
		var frame = new JFrame();
		frame.setSize( 600, 400 );
		frame.setResizable( false );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().add( new TextureList(), BorderLayout.CENTER );
		frame.setVisible( true );
		
	}
	
	
	public void add( TexturePanel tx ) {
		model.addElement( tx );
	}
	
	
	public void remove( TexturePanel tx ) {
		model.removeElement( tx );
	}

	
	public int getTextureCount() {
		return model.size();
	}

}
