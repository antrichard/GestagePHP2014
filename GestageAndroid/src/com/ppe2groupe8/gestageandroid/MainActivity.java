package com.ppe2groupe8.gestageandroid;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.ppe2groupe8.gestageandroid.ElevesDetailActivity;
import com.ppe2groupe8.gestageandroid.AuthentificationDetailActivity;

import com.ppe2groupe8.gestageandroid.Personne;
import com.ppe2groupe8.gestageandroid.Classe;
import com.ppe2groupe8.gestageandroid.AnneeScol;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity  implements
OnItemSelectedListener, OnItemClickListener {

	private static final String CLASSES_EMPTY = "<lesclasses><classe>Vide!</classe></lesclasses>";
	private static final String ANNEESCOL_EMPTY = "<lesannneesscol><annneescol>Vide!</annneescol></lesannneesscol>";
	private static final String PERSONNES_EMPTY = "<lespersonnes><personne>Vide!</personne><lespersonnes>";
	private static final String STAGES_EMPTY = "<lesstages><stage>Vide!</stage></lesstages>";
	
	
	
	// 10.0.2.2 : pour atteindre une ressource sur la machine hôte de l'AVD
	// private static final String URL_XMLRESSOURCE =
	// "http://192.168.0.3/projects/World2/xmlCountries.php?continent=";
	
	/*private static final String URL_XMLRESSOURCE_CLASSES = "http://172.15.6.244/arichard/gestageAndroid/rest/index.php?ressource=Classes&action=getAll";
	private static final String URL_XMLRESSOURCE_ANNEESCOL = "http://172.15.6.244/arichard/gestageAndroid/rest/index.php?ressource=AnneeScol&action=getAll";
	private static final String URL_XMLRESSOURCE_PERSONNE = "http://172.15.6.244/arichard/gestageAndroid/rest/index.php?ressource=Personne&action=getAllEtudiantsByClasseAndAnneeScol&";
	private static final String URL_XMLRESSOURCE_STAGES = "http://172.15.6.244/arichard/gestageAndroid/rest/index.php?ressource=Stage&action=getOneById&id=";
	*/
	private static final String URL_XMLRESSOURCE_CLASSES = "http://172.15.4.45/sites/2SLAM/gestageAndroid/rest/index.php?ressource=Classes&action=getAll";
	private static final String URL_XMLRESSOURCE_ANNEESCOL = "http://172.15.4.45/sites/2SLAM/gestageAndroid/rest/index.php?ressource=AnneeScol&action=getAll";
	private static final String URL_XMLRESSOURCE_PERSONNE = "http://172.15.4.45/sites/2SLAM/gestageAndroid/rest/index.php?ressource=Personne&action=getAllEtudiantsByClasseAndAnneeScol&";
	private static final String URL_XMLRESSOURCE_STAGES = "http://172.15.4.45/sites/2SLAM/gestageAndroid/rest/index.php?ressource=Stage&action=getOneById&id=";
	
	private Spinner spinClasses;
	private Spinner spinAnneeScol;
	private ListView listViewEleves;
	private ArrayList<Personne> desEleves;

	private ReqHTTPTask reqHTTPTask = null;

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choix_classe);

		// obtenir les références des instances de widgets désérialisés
		this.spinClasses = (Spinner) findViewById(R.id.spinnerClasses);
		this.spinAnneeScol = (Spinner) findViewById(R.id.spinnerAnnees);
		this.listViewEleves = (ListView) findViewById(R.id.listViewEleves);
		this.desEleves = new ArrayList<Personne>();

		// ArrayAdapter : permet de remplir les données d'un TextView
		// param1 : le contexte
		// param2 : l'id du textView
		// param3 : les données = une list de Pays
		this.listViewEleves.setAdapter(new ArrayAdapter<Personne>(this,
				R.layout.liste_eleves_en_stage, desEleves));
		this.listViewEleves.setOnItemClickListener(this);

		// mise en place du "modèle" de spinContinents
		// Crée un nouvel ArrayAdapter Ã  partir d'une ressource
		// param1 : le contexte
		// param2 : les donnÃ©es qui viennent d'une ressource tableau =t ableau
		// de continents
		// param3 : l'id du Spinner
		// CharSequence = interface séquence de caractÃ¨res ? On aurait pu mettre String ?
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.classes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinClasses.setAdapter(adapter);
		spinClasses.setOnItemSelectedListener(this);
		
		//même chose pour les années scolaires
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.anneeScol, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinAnneeScol.setAdapter(adapter2);
		spinAnneeScol.setOnItemSelectedListener(this);
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

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {
		Toast.makeText(
				getApplicationContext(),
				"Elève sélectionné : " + listViewEleves.getAdapter().getItem(position),Toast.LENGTH_LONG).show();

		Bundle bundle = new Bundle();
		bundle.putString("eleve", listViewEleves.getAdapter().getItem(position).toString());
		Intent detailIntent = new Intent(getApplicationContext(),ElevesDetailActivity.class);
		detailIntent.putExtras(bundle);
		startActivity(detailIntent);
	}


	// Début définition eleve ReqHTTPTask
	public class ReqHTTPTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {
			try {

				// modification de la liste des élèves
				desEleves.clear();
				UtilWorldXml.parseListePersonnes(
						URL_XMLRESSOURCE_PERSONNE + "classe=" + URLEncoder.encode(spinClasses.getSelectedItem().toString(),"UTF-8") 
						+ "&anneeScol=" + URLEncoder.encode(spinAnneeScol.getSelectedItem().toString(),"UTF-8"), 
						PERSONNES_EMPTY, desEleves);
				return true;
			} catch (UnsupportedEncodingException e) {
				return false;
			}
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			reqHTTPTask = null;
			if (success) {
				Toast.makeText(getApplicationContext(),"Nombre d'eleves :" + desEleves.size(), Toast.LENGTH_LONG).show();

				@SuppressWarnings("unchecked")
				ArrayAdapter<Personne> modelDeListeEleves = (ArrayAdapter<Personne>) listViewEleves.getAdapter();

				modelDeListeEleves.notifyDataSetChanged();

				Toast.makeText(getApplicationContext(), "Succès : " + success, Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(getApplicationContext(), "erreur de chargement des eleves", Toast.LENGTH_LONG).show();

			}
		}
	} // fin définition eleve ReqHTTPTask


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
