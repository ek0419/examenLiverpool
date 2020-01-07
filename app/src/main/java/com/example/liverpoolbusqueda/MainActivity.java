package com.example.liverpoolbusqueda;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.liverpoolbusqueda.Utilerias.UTUtils;
import com.example.liverpoolbusqueda.busquedaLiverPool.BuscadorFragment;
import com.example.liverpoolbusqueda.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        lanzarBuscador();
    }


    private void lanzarBuscador()
    {
        UTUtils.lanzarFragment(getSupportFragmentManager(),R.id.flContainer,new BuscadorFragment());
    }
}
