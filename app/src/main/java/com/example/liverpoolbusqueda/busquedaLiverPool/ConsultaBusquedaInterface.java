package com.example.liverpoolbusqueda.busquedaLiverPool;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConsultaBusquedaInterface {

    @GET("appclienteservices/services/v3/plp")
    Call<ModeloBusqueda> consultaBusqueda(
            @Query("force-plp") boolean boleano,
            @Query("search-string") String terBusqueda,
            @Query("page-number") int numPagina,
            @Query("number-of-items-per-page") int numItems
    );
}
