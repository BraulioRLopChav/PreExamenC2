package com.example.preexamen9_3c2.modelo;

import com.example.preexamen9_3c2.Usuario;

public interface Persistencia {
    public void openDataBase();
    public void closeDataBase();
    public long insertUsuario(Usuario usuario);
    public long updateUsuario(Usuario usuario);
    public void deleteUsuario(int id);

}
