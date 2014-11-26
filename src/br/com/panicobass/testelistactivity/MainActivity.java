package br.com.panicobass.testelistactivity;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//Classe extend ListActivity
public class MainActivity extends Activity {

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);

		// Implementamos um ArrayList com hashmap para poder passar para a lista
		ArrayList<HashMap<String, String>> carros = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < 20; i++) {
			HashMap<String, String> carro = new HashMap<String, String>();
			carro.put("carro", "Carro " + (i + 1));
			carro.put("marca", "Marca " + (i + 1));
			// Addo hasmap a lista
			carros.add(carro);
		}

		// Definimos as chaves que serão usadas para acessar õs items da lista
		String[] from = new String[] { "carro", "marca" };
		
		// Definimos Text de referencia para os tilulos
		int[] to = new int[] {R.id.txtCarro, R.id.txtMarca };
		
		// Definimos o layout que será usado
		int layout = R.layout.layout_lista;		
		
		//setamos o listView para ser mostrado
		listView.setAdapter(new SimpleAdapter(this, carros, R.layout.layout_lista, from, to));
	}

	// Método para acessar a activity 1
	public void acessarActivity1(View view) {
		Intent intent = new Intent(MainActivity.this, Activity1.class);
		startActivity(intent);
	}

	// Método para acessar a activity 2
	public void acessarActivity2(View view) {
		Intent intent = new Intent(MainActivity.this, Activity2.class);
		startActivity(intent);
	}

	// Método para sair da app
	public void sair(View view) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
