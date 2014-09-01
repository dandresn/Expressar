package com.example.expressar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tela_inicial extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_inicial);
		
		Button btnCreditos = (Button) findViewById(R.id.btnCreditos);
		Button btnAjuda = (Button) findViewById(R.id.btnAjuda);
		Button btnSeleciona = (Button) findViewById(R.id.btnSeleciona);
		
		btnCreditos.setOnClickListener(clickListener);
		btnAjuda.setOnClickListener(clickListener);
		btnSeleciona.setOnClickListener(clickListener);
	}
	
	
	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent credito = new Intent(Tela_inicial.this, Creditos.class);
			Intent ajuda = new Intent(Tela_inicial.this, Ajuda.class);
			Intent seleciona = new Intent(Tela_inicial.this, Config.class);
			
			switch (v.getId()) {
			
			case R.id.btnCreditos:
				startActivity(credito);
				break;
			case R.id.btnAjuda:
				startActivity(ajuda);
				break;
			case R.id.btnSeleciona:
				startActivity(seleciona);
				break;
			}
			
		}
	};
}
