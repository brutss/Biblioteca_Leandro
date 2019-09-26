package br.com.naun.bibliotecabrutss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {

        banco = new CriaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getTITULO(), titulo);
        valores.put(CriaBanco.getAUTOR(), autor);
        valores.put(CriaBanco.getEDITORA(), editora);
        resultado = db.insert(CriaBanco.getTABELA(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public String insereDadoUsuario(String email, String nome, String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getEmailUsuario(),email);
        valores.put(CriaBanco.getNome(),nome);
        valores.put(CriaBanco.getSenhaUsuario(), senha);
        resultado = db.insert(CriaBanco.getTabelaUsuarios(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getTITULO()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosUsuarios() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getEmailUsuario()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaUsuarios(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos =
                {CriaBanco.getID(), CriaBanco.getTITULO(), CriaBanco.getAUTOR(), CriaBanco.getEDITORA()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor carregaDadoByIdUsuario(int id) {
        Cursor cursor;
        String[] campos =
                {CriaBanco.getIdUsuarios(), CriaBanco.getEmailUsuario(), CriaBanco.getNome()};
        String where = CriaBanco.getIdUsuarios() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaUsuarios(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void alteraRegistro(int id, String titulo, String autor, String editora) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getID() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getTITULO(), titulo);
        valores.put(CriaBanco.getAUTOR(), autor);
        valores.put(CriaBanco.getEDITORA(), editora);
        db.update(CriaBanco.getTABELA(), valores, where, null);
        db.close();
    }
    public void alteraRegistroUsuario(int id, String email, String nome, String senha) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getIdUsuarios() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getEmailUsuario(), email);
        valores.put(CriaBanco.getNome(), nome);
        valores.put(CriaBanco.getSenhaUsuario(), senha);
        db.update(CriaBanco.getTabelaUsuarios(), valores, where, null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();

        db.delete(CriaBanco.getTABELA(), where, null);

        db.close(); // Fechar conexão
    }
    public void deletaRegistroUsuario(int id) {
        String where = CriaBanco.getIdUsuarios() + "=" + id;
        db = banco.getReadableDatabase();

        db.delete(CriaBanco.getTabelaUsuarios(), where, null);

        db.close(); // Fechar conexão
    }
}