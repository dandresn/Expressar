package com.example.expressar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class Tela_sorrir3 extends Activity {
	private Uri src_global = Uri.parse("android.resource://com.example.expressar/raw/parabens");
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_sorrir3);
		
		((Button) findViewById(R.id.btnMotivas)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				final String[] items = view.getResources().getStringArray(R.array.videos);
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tela_sorrir3.this, android.R.layout.simple_spinner_dropdown_item, items);
				new AlertDialog.Builder(Tela_sorrir3.this).setTitle("Escolha o v’deo motivacional").setAdapter(adapter, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						((Button) findViewById(R.id.btnMotivas)).setText(items[which]);
						if(which==0){						
				    		src_global = Uri.parse("android.resource://com.example.expressar/raw/parabens");
				    	} else if (which==1){
				    		src_global = Uri.parse("android.resource://com.example.expressar/raw/muitobem");
				    	} else if (which==2){
				    		src_global = Uri.parse("android.resource://com.example.expressar/raw/muitobem_rock");
				    	} else if (which==3){
				    		src_global = Uri.parse("android.resource://com.example.expressar/raw/muitobem_fogos");
				    	} else if (which==4){
				    		src_global = Uri.parse("android.resource://com.example.expressar/raw/aplauso_rock");
				    	} 
						dialog.dismiss();
					}
				}).create().show();
			}
		}); 
		
		ImageButton btnInicio = (ImageButton) findViewById(R.id.btnInicio);
		ImageButton btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);
		ImageButton btnAvancar = (ImageButton) findViewById(R.id.btnAvancar);
		
		btnInicio.setOnClickListener(clickListener);
		btnVoltar.setOnClickListener(clickListener);
		btnAvancar.setOnClickListener(clickListener);
		
	}

public void chamaVideo(View v){
		final VideoView video = (VideoView) findViewById(R.id.video_acerto);
		video.setVisibility(View.VISIBLE);
		video.setVideoURI(src_global);
		video.start();
		      
		video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer arg0) {
				// TODO Auto-generated method stub
				video.setVisibility(View.GONE);
				
				
			}
		});
}
	
private OnClickListener clickListener = new OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent inicio = new Intent(Tela_sorrir3.this, Licoes.class);
		Intent voltar = new Intent(Tela_sorrir3.this, Tela_sorrir2.class);
		Intent avancar = new Intent(Tela_sorrir3.this, Tela_sorrir4.class);
		
		switch (v.getId()) {
		
		case R.id.btnInicio:
			startActivity(inicio);
			break;
		case R.id.btnVoltar:
			startActivity(voltar);
			break;
		case R.id.btnAvancar:
			startActivity(avancar);
			break;
		}
		
	}
};
}
