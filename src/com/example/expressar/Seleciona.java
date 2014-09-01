package com.example.expressar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Seleciona extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seleciona_imagem);
	}
	
	public void botaoVoltar(View v){
		finish();
	}
}
