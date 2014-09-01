package com.example.expressar;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
 
public class Licoes extends Activity implements OnItemClickListener {
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.licoes);
 
        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
 
        createListView();
    }
 
    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Lição 1 - O que faz você sorrir?", R.drawable.ic_launcher);
        ItemListView item2 = new ItemListView("Lição 2 - Quando eu estou feliz", R.drawable.ic_launcher);
        ItemListView item3 = new ItemListView("Lição 3 - Quem está sorrindo?(1)", R.drawable.ic_launcher);
        ItemListView item4 = new ItemListView("Lição 4 - Quem está sorrindo?(2)", R.drawable.ic_launcher);
 
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
 
        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);
 
        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
    
    public void botaoVoltar(View v){
    	Intent voltar = new Intent(Licoes.this, Config.class);		
		startActivity(voltar);
	}
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostração
        
        
        Intent Licao1 = new Intent(Licoes.this, Tela_sorrir1.class);
		Intent Licao2 = new Intent(Licoes.this, Tela_sorrir2.class);
		Intent Licao3 = new Intent(Licoes.this, Tela_sorrir3.class);
		Intent Licao4 = new Intent(Licoes.this, Tela_sorrir4.class);
		
		String opcao = item.getTexto();
		if (opcao.equals("Lição 1 - O que faz você sorrir?")){
			startActivity(Licao1);
		} else if (opcao.equals("Lição 2 - Quando eu estou feliz")){
			startActivity(Licao2);	
		} else if (opcao.equals("Lição 3 - Quem está sorrindo?(1)")){
			startActivity(Licao3);
		} else if (opcao.equals("Lição 4 - Quem está sorrindo?(2)")){
			startActivity(Licao4);
		}
    }
}