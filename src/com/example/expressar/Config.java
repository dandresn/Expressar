package com.example.expressar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Config extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);
		
		Spinner spinner = (Spinner) findViewById(R.id.opcoes);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.opcoes, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		Button btn_inicia = (Button) findViewById(R.id.btn_inicia);
		Button btnSeleciona = (Button) findViewById(R.id.btnSeleciona);
	
		btn_inicia.setOnClickListener(clickListener);
		btnSeleciona.setOnClickListener(clickListener);
	}
	
	public class SpinnerActivity extends Activity implements OnItemSelectedListener {
	   
	    
	    public void onItemSelected1(AdapterView<?> parent, View view, 
	            int pos, long id) {
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
	    }

	    public void onNothingSelected1(AdapterView<?> parent) {
	        // Another interface callback
	    }

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public void botaoVoltar(View v){
		Intent voltar = new Intent(Config.this, Tela_inicial.class);		
		startActivity(voltar);
	}
	
	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intencao = new Intent(Config.this, Licoes.class);
			Intent seleciona = new Intent(Config.this, Seleciona.class);
			
			switch (v.getId()) {
			case R.id.btnSeleciona:
				startActivity(seleciona);
				break;
			case R.id.btn_inicia:
				startActivity(intencao);
				break;
			}
			
		}
	};
}
