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
import android.net.Uri;
import oicq.wlogin_sdk.tools.util;

public class WloginProvider
  extends ContentProvider
{
  private WloginProvider.a a;
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
    switch (this.i.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unnown URI" + paramUri);
    }
    int k = this.b.delete("rsa_pubkey", paramString, paramArrayOfString);
    this.h.getContentResolver().notifyChange(paramUri, null);
    return k;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (this.i.match(paramUri) != 1) {
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    }
    long l = this.b.insert("rsa_pubkey", null, paramContentValues);
    if (l > 0L)
    {
      paramUri = ContentUris.withAppendedId(this.j, l);
      this.h.getContentResolver().notifyChange(paramUri, null);
      return paramUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }
  
  public boolean onCreate()
  {
    this.h = getContext();
    this.f = "oicq.wlogin_sdk.WloginProvider";
    this.j = Uri.parse("content://" + this.f + "/" + "rsa_pubkey");
    this.i.addURI(this.f, "rsa_pubkey", 1);
    util.LOGI("oncreated!");
    this.a = new WloginProvider.a(this, this.h, "wlogin_provider.db", null, 4);
    this.b = this.a.getWritableDatabase();
    return this.b != null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (this.i.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unnown URI" + paramUri);
    }
    paramArrayOfString1 = this.b.query("rsa_pubkey", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
    paramArrayOfString1.setNotificationUri(this.h.getContentResolver(), paramUri);
    return paramArrayOfString1;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    switch (this.i.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unnown URI" + paramUri);
    }
    return this.b.update("rsa_pubkey", paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginProvider
 * JD-Core Version:    0.7.0.1
 */