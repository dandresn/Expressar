package com.example.expressar;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;;

public class Tela_sorrir1 extends Activity {
	

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_sorrir1);
		
		ImageButton btnInicio = (ImageButton) findViewById(R.id.btnInicio);
		ImageButton btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);
		ImageButton btnAvancar = (ImageButton) findViewById(R.id.btnAvancar);
		Button btnZerar = (Button) findViewById(R.id.btnZerar);
				
		
		btnInicio.setOnClickListener(clickListener);
		btnVoltar.setOnClickListener(clickListener);
		btnAvancar.setOnClickListener(clickListener);
		btnZerar.setOnClickListener(clickListener);
		
		VideoView video = (VideoView) findViewById(R.id.videoView1);
		Uri src = Uri.parse("android.resource://com.example.expressar/raw/sorrir1");
		video.setVideoURI(src);
		
		video.start();
		
	
	}
	private View minhaView = null;
	public void chamaImagem(View v){
		
		switch (v.getId()) {
		
		case R.id.bike:
			minhaView = (View) findViewById(R.id.view);
			break;
		case R.id.bola:
			minhaView = (View) findViewById(R.id.view2);
			break;
		case R.id.skate:
			minhaView = (View) findViewById(R.id.view3);
			break;
		case R.id.sorvete:
			minhaView = (View) findViewById(R.id.view4);
			break;
		}
		
		minhaView.setVisibility(View.VISIBLE);
		minhaView.postDelayed(new Runnable() {
		        public void run() {
		            minhaView.setVisibility(View.GONE);
		            VideoView video = (VideoView) findViewById(R.id.videoView1);
					Uri src = Uri.parse("android.resource://com.example.expressar/raw/sorrir2");
					video.setVideoURI(src);
					video.start();
		        }
		}, 3000);	
	}
	
private OnClickListener clickListener = new OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent inicio = new Intent(Tela_sorrir1.this, Licoes.class);
		Intent voltar = new Intent(Tela_sorrir1.this, Licoes.class);
		Intent avancar = new Intent(Tela_sorrir1.this, Tela_sorrir2.class);
		
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
		case R.id.btnZerar:
			VideoView video = (VideoView) findViewById(R.id.videoView1);
			Uri src = Uri.parse("android.resource://com.example.expressar/raw/sorrir1");
			video.setVideoURI(src);
			video.start();
			break;
		}
		
	}
};
}
