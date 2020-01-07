package com.example.liverpoolbusqueda.busquedaLiverPool;

import android.graphics.Bitmap;

import com.example.liverpoolbusqueda.retrofit.RequestManager;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;

public class BuscadorWS {

    private static final String RESULT_OK = "OK";
    private String serviceUrl;
    private RequestManager requestManager;

    public BuscadorWS() {

        serviceUrl = "https://shoppapp.liverpool.com.mx/";
    }

    ModeloBusqueda consurtarServicio(String terBusqueda, int numItems, int numPagina) {

        requestManager = new RequestManager(serviceUrl);
        Call<ModeloBusqueda> call = requestManager.create(ConsultaBusquedaInterface.class).consultaBusqueda(true, terBusqueda, numItems, numPagina);
        ModeloBusqueda modelo = null;

        try {
            modelo = call.execute().body();

            if (modelo.getStatus().getStatus().equals(RESULT_OK)) {
                return modelo;
            }
        } catch (Exception e) {
            return modelo;
        }
        return modelo;
    }

    public ArrayList<ProductosBusquedaEncontrados> parsearBusqueda(String terBusqueda, int numItems, int numPagina) {
        ModeloBusqueda busqueda = consurtarServicio(terBusqueda, numItems, numPagina);

        ArrayList<ProductosBusquedaEncontrados> result = new ArrayList<>();

        for (Record record : busqueda.getPlpResults().getRecords()) {

            result.add(new ProductosBusquedaEncontrados(record.getProductDisplayName(), Objects.requireNonNull(record.getMaximumListPrice()).toString(),record.getSmImage()));
        }

        return result;
    }
}
