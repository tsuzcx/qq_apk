package com.tencent.mm.sdk.storage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class ContentProviderDB<T>
  implements ISQLiteDatabase
{
  private final Context q;
  
  public ContentProviderDB(Context paramContext)
  {
    this.q = paramContext;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Uri localUri = getUriFromTable(paramString1);
    if (localUri == null)
    {
      paramString2 = new StringBuilder("get uri from table failed, table=");
      paramString2.append(paramString1);
      Log.e("MicroMsg.SDK.MContentProviderDB", paramString2.toString());
      return 0;
    }
    return this.q.getContentResolver().delete(localUri, paramString2, paramArrayOfString);
  }
  
  public boolean execSQL(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder("do not support, execSQL sql=");
    paramString1.append(paramString2);
    Log.e("MicroMsg.SDK.MContentProviderDB", paramString1.toString());
    return false;
  }
  
  public abstract Uri getUriFromTable(String paramString);
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    paramString2 = getUriFromTable(paramString1);
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder("get uri from table failed, table=");
      paramString2.append(paramString1);
      Log.e("MicroMsg.SDK.MContentProviderDB", paramString2.toString());
      return -1L;
    }
    return ContentUris.parseId(this.q.getContentResolver().insert(paramString2, paramContentValues));
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    paramString3 = getUriFromTable(paramString1);
    if (paramString3 == null)
    {
      paramString2 = new StringBuilder("get uri from table failed, table=");
      paramString2.append(paramString1);
      Log.e("MicroMsg.SDK.MContentProviderDB", paramString2.toString());
      return new MatrixCursor(paramArrayOfString1);
    }
    paramString2 = this.q.getContentResolver().query(paramString3, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = new MatrixCursor(paramArrayOfString1);
    }
    return paramString1;
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    paramArrayOfString = new StringBuilder("do not support, rawQuery sql=");
    paramArrayOfString.append(paramString);
    Log.e("MicroMsg.SDK.MContentProviderDB", paramArrayOfString.toString());
    return null;
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    paramString2 = new StringBuilder("do not support, replace table=");
    paramString2.append(paramString1);
    Log.e("MicroMsg.SDK.MContentProviderDB", paramString2.toString());
    return 0L;
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    Uri localUri = getUriFromTable(paramString1);
    if (localUri == null)
    {
      paramContentValues = new StringBuilder("get uri from table failed, table=");
      paramContentValues.append(paramString1);
      Log.e("MicroMsg.SDK.MContentProviderDB", paramContentValues.toString());
      return 0;
    }
    return this.q.getContentResolver().update(localUri, paramContentValues, paramString2, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.ContentProviderDB
 * JD-Core Version:    0.7.0.1
 */