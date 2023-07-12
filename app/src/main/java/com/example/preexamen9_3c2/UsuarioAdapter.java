package com.example.preexamen9_3c2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private List<Usuario> lst;

    public UsuarioAdapter(Context context, List<Usuario> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.usuario_item, parent, false);

            holder = new ViewHolder();
            holder.textViewCorreo = convertView.findViewById(R.id.textViewCorreo);
            holder.textViewUsuario = convertView.findViewById(R.id.textViewUsuario);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Usuario usuario = lst.get(position);
        holder.textViewCorreo.setText(usuario.getCorreo());
        holder.textViewUsuario.setText(usuario.getUsuario());

        return convertView;
    }

    static class ViewHolder {
        TextView textViewCorreo;
        TextView textViewUsuario;
    }
}

