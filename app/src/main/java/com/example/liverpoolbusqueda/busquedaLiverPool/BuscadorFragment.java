package com.example.liverpoolbusqueda.busquedaLiverPool;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liverpoolbusqueda.Utilerias.UTUtils;
import com.example.liverpoolbusqueda.busquedaLiverPool.ResicleView.BusquedaAdapter;
import com.example.liverpoolbusqueda.databinding.FragmentBuscadorBinding;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class BuscadorFragment extends Fragment {

    private CompositeDisposable mCompositeDisposable;
    private FragmentBuscadorBinding binding;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBuscadorBinding.inflate(inflater, container, false);
        binding.btBuscarProducto.setOnClickListener(view -> realizaBusqueda());
        mCompositeDisposable = new CompositeDisposable();
        return binding.getRoot();
    }

    void realizaBusqueda() {
        final String categoria = Objects.requireNonNull(binding.etCriterioBusqueda.getText()).toString().trim();
        final String numeroItems = Objects.requireNonNull(binding.etNumeroItems.getText()).toString().trim();
        final String paginas = Objects.requireNonNull(binding.etNumeroPagina.getText()).toString().trim();
        iniciarVistar();

        if (!categoria.isEmpty() & !numeroItems.isEmpty() & !paginas.isEmpty()) {
            UTUtils.mostrarProgressDialog("", "", getActivity());
            mCompositeDisposable.add(Observable.fromCallable(() -> {
                BuscadorWS buscar = new BuscadorWS();
                return buscar.parsearBusqueda(categoria, Integer.parseInt(numeroItems), Integer.parseInt(paginas));
            }).delay(1, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(productos -> {
                        if (productos != null && productos.size() != 0) {
                            llenarRecyclerView(productos);
                            mostrarRecycler();

                        } else
                            mostrarMensajeSinResultados();
                    }));
        } else {
            UTUtils.mostrarToas(getActivity(), "Completa todos los campos", false);
        }
    }

    private void mostrarRecycler() {
        UTUtils.esconderProgressDialog();
        binding.rvResultadoBusqueda.setVisibility(View.VISIBLE);

    }

    private void llenarRecyclerView(ArrayList<ProductosBusquedaEncontrados> productos) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        adapter = new BusquedaAdapter(productos);
        binding.rvResultadoBusqueda.hasFixedSize();
        binding.rvResultadoBusqueda.setItemAnimator(new DefaultItemAnimator());
        binding.rvResultadoBusqueda.computeHorizontalScrollRange();
        binding.rvResultadoBusqueda.setLayoutManager(manager);
        binding.rvResultadoBusqueda.setAdapter(adapter);

    }


    private void mostrarMensajeSinResultados() {
        UTUtils.esconderProgressDialog();
        binding.tvSinResultado.setVisibility(View.VISIBLE);
    }

    private void iniciarVistar() {
        binding.rvResultadoBusqueda.setVisibility(View.GONE);
        binding.tvSinResultado.setVisibility(View.GONE);
    }


}
