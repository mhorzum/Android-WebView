package org.kod5.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint({ "NewApi", "ShowToast" })
public class MainActivity extends Activity {

	//Spinner i�erisine koyaca��m�z verileri tan�ml�yoruz.
	private String[] iller={"�STANBUL","ANKARA"};
	private String[] ilceler0={"ADALAR","ARNAVUTK�Y","ATA�EH�R","AVCILAR","BA�CILAR","BAH�EL�EVLER","BAKIRK�Y","BA�AK�EH�R","BAYRAMPA�A","BE��KTA�","BEYL�KD�Z�","BEYO�LU","B�Y�K�EKMECE","BEYKOZ","�ATALCA","�EKMEK�Y","ESENLER","ESENYURT","EY�P","FAT�H","GAZ�OSMANPA�A","G�NG�REN","KADIK�Y","KA�ITHANE","KARTAL","K���K�EKMECE","MALTEPE","PEND�K","SANCAKTEPE","SARIYER","S�L�VR�","SULTANBEYL�","SULTANGAZ�","��LE","���L�","TUZLA","�SK�DAR","�MRAN�YE","ZEYT�NBURNU"};
	private String[] ilceler1={"AKYURT","ALTINDA�","AYA�","BALA","BEYPAZARI","�AMLIDERE","�ANKAYA","�UBUK","ELMADA�","ET�MESGUT","EVREN","G�LBA�I","G�D�L","HAYMANA","KALEC�K","KAZAN","KE�܅REN","KIZILCAHAMAM","MAMAK","NALLIHAN","POLATLI","PURSAKLAR","S�NCAN","�EREFL�KO�H�SAR","YEN�MAHALLE"};
	
	//Spinner'lar� ve Adapter'lerini tan�ml�yoruz.
	private Spinner spinnerIller;
	private Spinner spinnerIlceler;
	private ArrayAdapter<String> dataAdapterForIller; 
	private ArrayAdapter<String> dataAdapterForIlceler;
	
	
	@Override // Bu metod uygulama a��ld���nda �al��t�r�lan metod.
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//xml k�sm�nda haz�rlad���m�z spinnerlar� burda tan�mlad�klar�m�zla e�le�tiriyoruz.
		spinnerIller = (Spinner) findViewById(R.id.spinner1);
		spinnerIlceler = (Spinner) findViewById(R.id.spinner2);
		 
        //Spinner'lar i�in adapterleri haz�rl�yoruz. 
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilceler0);
        
        //Listelenecek verilerin g�r�n�m�n� belirliyoruz.
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        //Haz�rlad���m�z Adapter'leri Spinner'lara ekliyoruz.
        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerIlceler.setAdapter(dataAdapterForIlceler);
        
        // Listelerden bir eleman se�ildi�inde yap�lacaklar� tan�ml�yoruz.
		spinnerIller.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//Hangi il se�ilmi�se onun il�eleri adapter'e ekleniyor.
				if(parent.getSelectedItem().toString().equals(iller[0])) 
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler0);
				else if(parent.getSelectedItem().toString().equals(iller[1]))
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler1);
				
				dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerIlceler.setAdapter(dataAdapterForIlceler);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		
		spinnerIlceler.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view,
							int position, long id) {
						//Se�ilen il ve il�eyi ekranda g�steriyoruz.
						Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"\n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
	}

	
}
