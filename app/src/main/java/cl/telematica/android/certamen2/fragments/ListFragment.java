package cl.telematica.android.certamen2.fragments;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen2.R;
import cl.telematica.android.certamen2.models.Values;

public class ListFragment extends Fragment {

    /**
     * New instance of ListFragment
     *
     * @return new instance of ListFragment
     */

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Values> mDataset;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private List<Values> getLista(String result){
        List<Values> listavalues = new ArrayList<>();

        try{
            JSONArray lista = new JSONArray(result);
            int size = lista.length();

            for( int i = 0; i<size; i++) {
                Values value = new Values();
                JSONObject objeto = lista.getJSONObject(i);


                value.setId(objeto.getInt("Id"));
                value.setJoke(objeto.getString("joke"));
                listavalues.add(value);

            }
            return listavalues;




        } catch (JSONException e) {
            e.printStackTrace();
            return listavalues;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.fragment_list, null);



        /*
         * Aquí es donde deben hacer el link a los elementos del layout fragment_list,
         * y donde prácticamente se debe hacer el desarrollo
        */

        return mainView;
    }
}
