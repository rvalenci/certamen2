package cl.telematica.android.certamen2.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.io.InputStreamReader;

import cl.telematica.android.certamen2.R;
import cl.telematica.android.certamen2.connection.HttpServerConnection;

public class InputFragment extends Fragment {

    /**
     * New instance of InputFragment
     *
     * @return new instance of InputFragment
     */
    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }


    private Button boton;
    private EditText Name;
    private EditText Lastname;
    private String URL;
    private RecyclerView.Adapter mAdapter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_input, null);
        boton = (Button)mainView.findViewById(R.id.button);
        Name = (EditText)mainView.findViewById(R.id.name);
        Lastname = (EditText)mainView.findViewById(R.id.lastname);
        URL = "http://api.icndb.com/jokes/random?firstName="+Name+"&lastName="+Lastname;

        boton.setOnClickListener(new View.OnClickListener(){
        public void onClick (View mainView) {
            //JsonReader reader = new JsonReader(new InputStreamReader(URL, "UTF-8"));
            AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

                protected void onPreExecute(){

                }

                protected String doInBackground(Void... params) {
                    String resultado = new HttpServerConnection().connectToServer(URL,1500);
                    return resultado;
                }

                protected void onPostExecute(String result){
                    if(result != null){
                        System.out.println(result);

                    }
                }

            };

        }
    });




        /*
         * Aquí es donde deben hacer el link a los elementos del layout fragment_input,
         * y donde prácticamente se debe hacer el desarrollo
        */

        return mainView;
    }

}
