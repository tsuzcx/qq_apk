package oicq.wlogin_sdk.request;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import oicq.wlogin_sdk.tools.util;

public class WloginProvider
  extends ContentProvider
{
  private a a;
  private SQLiteDatabase b = null;
  private final String c = "wlogin_provider.db";
  private final int d = 4;
  private final String e = "rsa_pubkey";
  private String f;
  private final int g = 1;
  private Context h;
  private UriMatcher i = new UriMatcher(-1);
  private Uri j;
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.i.match(paramUri) == 1)
    {
      int k = this.b.delete("rsa_pubkey", paramString, paramArrayOfString);
      this.h.getContentResolver().notifyChange(paramUri, null);
      return k;
    }
    paramString = new StringBuilder();
    paramString.append("Unnown URI");
    paramString.append(paramUri);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (this.i.match(paramUri) == 1)
    {
      long l = this.b.insert("rsa_pubkey", null, paramContentValues);
      if (l > 0L)
      {
        paramUri = ContentUris.withAppendedId(this.j, l);
        this.h.getContentResolver().notifyChange(paramUri, null);
        return paramUri;
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("Failed to insert row into ");
      paramContentValues.append(paramUri);
      throw new SQLException(paramContentValues.toString());
    }
    paramContentValues = new StringBuilder();
    paramContentValues.append("Unknown URI ");
    paramContentValues.append(paramUri);
    throw new IllegalArgumentException(paramContentValues.toString());
  }
  
  public boolean onCreate()
  {
    this.h = getContext();
    this.f = "oicq.wlogin_sdk.WloginProvider";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(this.f);
    localStringBuilder.append("/");
    localStringBuilder.append("rsa_pubkey");
    this.j = Uri.parse(localStringBuilder.toString());
    this.i.addURI(this.f, "rsa_pubkey", 1);
    util.LOGI("oncreated!");
    this.a = new a(this.h, "wlogin_provider.db", null, 4);
    this.b = this.a.getWritableDatabase();
    return this.b != null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (this.i.match(paramUri) == 1)
    {
      paramArrayOfString1 = this.b.query("rsa_pubkey", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      paramArrayOfString1.setNotificationUri(this.h.getContentResolver(), paramUri);
      return paramArrayOfString1;
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString1.append("Unnown URI");
    paramArrayOfString1.append(paramUri);
    throw new IllegalArgumentException(paramArrayOfString1.toString());
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (this.i.match(paramUri) == 1) {
      return this.b.update("rsa_pubkey", paramContentValues, paramString, paramArrayOfString);
    }
    paramContentValues = new StringBuilder();
    paramContentValues.append("Unnown URI");
    paramContentValues.append(paramUri);
    throw new IllegalArgumentException(paramContentValues.toString());
  }
  
  private class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, paramCursorFactory, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL(String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER, subappid INTEGER, pubkey TEXT, pubkey_md5 TEXT)", new Object[] { "rsa_pubkey" }));
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        util.printException(paramSQLiteDatabase, "");
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS rsa_pubkey");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginProvider
 * JD-Core Version:    0.7.0.1
 */