package com.example.liverpoolbusqueda.busquedaLiverPool.ResicleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liverpoolbusqueda.R;
import com.example.liverpoolbusqueda.busquedaLiverPool.ProductosBusquedaEncontrados;
import com.example.liverpoolbusqueda.databinding.CardViewBusquedaBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BusquedaAdapter extends RecyclerView.Adapter<BusquedaAdapter.BusquedaHolder> {
    public Context context;
    private ArrayList<ProductosBusquedaEncontrados> busqueda;

    public BusquedaAdapter(ArrayList<ProductosBusquedaEncontrados> busqueda) {
        this.busqueda = busqueda;
    }

    @NonNull
    @Override
    public BusquedaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        return new BusquedaHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.card_view_busqueda, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusquedaHolder holder, int position) {
        ProductosBusquedaEncontrados currenBusqueda = busqueda.get(position);
        holder.binding.tvTituloCard.setText(currenBusqueda.getTitulo());
        holder.binding.tvPrecioCard.setText("$" + currenBusqueda.getPrecio());
        Picasso.get().load(currenBusqueda.getImagen())
                .placeholder(context.getResources().getDrawable(R.drawable.loading))
                .error(context.getResources().getDrawable(R.drawable.error_carga_magen))
                .resize(100,100)
                .centerCrop()
                .into(holder.binding.ivImagenCarg);
    }

    @Override
    public int getItemCount() {
        return busqueda.size();
    }

    class BusquedaHolder extends RecyclerView.ViewHolder {
        CardViewBusquedaBinding binding;

        public BusquedaHolder(@NonNull CardViewBusquedaBinding binding1) {
            super(binding1.getRoot());
            this.binding = binding1;
        }
    }
}
