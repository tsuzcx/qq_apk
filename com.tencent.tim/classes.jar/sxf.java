import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class sxf
  extends SQLiteOpenHelper
  implements sxe
{
  public sxf(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL COLLATE NOCASE,second_key text  NOT NULL COLLATE NOCASE,value String,PRIMARY KEY (main_key,second_key))");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_navigator_bar (uin text PRIMARY KEY NOT NULL,entraceid INTEGER NOT NULL,entracename text NOT NULL,entraceicon text,entraceaction text,isDefault INTEGER,tabid INTEGER,qbossentraceicon text,qbosstraceinfo text)");
    paramSQLiteDatabase.execSQL("create table if not exists table_qz_unread(own_uin text, type integer, ucount integer,icontrol integer,frienduins BLOB,friendMsg text,friendsNum integer,trace_info text,existDL integer, pushMsg text,schema text,iconUrl text,showMsg text,reportValue text,countID text,cTime text,iShowLevel integer,hasShow integer,  PRIMARY KEY(own_uin,type))");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    paramSQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
    paramSQLiteDatabase.execSQL("drop table if exists table_qz_unread");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    paramSQLiteDatabase.execSQL("drop table if exists qz_navigator_bar");
    paramSQLiteDatabase.execSQL("drop table if exists table_qz_unread");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxf
 * JD-Core Version:    0.7.0.1
 */