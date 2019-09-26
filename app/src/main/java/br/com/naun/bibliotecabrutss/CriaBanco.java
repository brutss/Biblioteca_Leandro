package br.com.naun.bibliotecabrutss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PasswordAuthentication;

import androidx.annotation.Nullable;
import androidx.annotation.Nullable;


public class CriaBanco extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "banco.db"; //Variavel do Banco

    //Variaveis para criação da Tabela "Livros"
    //------------------------------------------------------
    private static final String TABELA = "livros";
    private static final String ID = "_id";
    private static final String TITULO="titulo";
    private static final String AUTOR="autor";
    private static final String EDITORA = "editora";
    private static final String CATEGORIA ="categoria";
    //------------------------------------------------------


    //Getter and Setter Tabela Livros
    //------------------------------------------------------
    public static String getTABELA() {return TABELA;}
    public static String getID() {return ID;}
    public static String getTITULO() {return TITULO;}
    public static String getAUTOR() { return AUTOR; }
    public static String getEDITORA() {return EDITORA;}
    public static String getCATEGORIA() {return CATEGORIA;}


    //------------------------------------------------------



    // Getter and Setter Tabela Usuarios
    //------------------------------------------------------
    public static String getTabelaUsuarios() {return TABELA_USUARIOS; }
    public static String getIdUsuarios() {return ID_USUARIOS;}
    public static String getEmailUsuario() {return EMAIL_USUARIO;}
    public static String getSenhaUsuario() {return SENHA_USUARIO;}
    public static String getTipoUsuario() {return TIPO_USUARIO; }
    public static String getNome(){return NOME_USUARIO;}
    //------------------------------------------------------

    //Variáveis para tabela Usuários
    //------------------------------------------------------
    private static final String NOME_USUARIO="nome";
    private static final String TABELA_USUARIOS = "usuarios";
    private static final String ID_USUARIOS = "_id";
    private static final String EMAIL_USUARIO = "email";
    private static final String SENHA_USUARIO = "senha";
    private static final String TIPO_USUARIO = "tipo";
    //------------------------------------------------------


    //------------------------------------------------------
    public static String getNomeBanco() {return NOME_BANCO;}
    public static int getVERSAO() {return VERSAO;}
    //------------------------------------------------------

    private static final int VERSAO = 1;

    public CriaBanco(@Nullable Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE " + TABELA +
                "("+
                ID + " integer primary key autoincrement, " +
                TITULO + " text, "+
                AUTOR + " text, " +
                EDITORA +" text, "+
                CATEGORIA +" text "+
                ")";

        String criarTBUsuarios = "CREATE TABLE " + TABELA_USUARIOS +
                "("+
                ID_USUARIOS + " integer primary key autoincrement, " +
                NOME_USUARIO +" text, "+
                EMAIL_USUARIO + " text, "+
                SENHA_USUARIO + " text, " +
                TIPO_USUARIO +" text "+
                ")";

        sqLiteDatabase.execSQL(criarTBUsuarios);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABELA+TABELA_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
