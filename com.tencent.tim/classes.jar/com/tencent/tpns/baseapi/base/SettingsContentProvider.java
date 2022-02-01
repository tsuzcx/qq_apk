package com.tencent.tpns.baseapi.base;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsContentProvider
  extends ContentProvider
{
  public static Uri BASE_URI;
  public static final String BOOLEAN_TYPE = "boolean";
  public static final String FLOAT_TYPE = "float";
  public static final String INT_TYPE = "integer";
  public static final String KEY = "key";
  public static final String LONG_TYPE = "long";
  public static final String MEMORY_TYPE = "memory";
  public static final String PREFFERENCE_AUTHORITY = "XG_SETTINGS_PROVIDER";
  public static final String STRING_TYPE = "string";
  public static final String TYPE = "type";
  private static UriMatcher a;
  private static String b = null;
  private SharedPreferences c = null;
  
  private void a(Context paramContext)
  {
    if (b == null) {
      b = paramContext.getPackageName() + "." + "XG_SETTINGS_PROVIDER";
    }
    if (a == null)
    {
      a = new UriMatcher(-1);
      a.addURI(b, "*/*", 65536);
    }
    if (BASE_URI == null) {
      BASE_URI = Uri.parse("content://" + b);
    }
    if (this.c == null) {
      this.c = paramContext.getApplicationContext().getSharedPreferences(".xg.vip.settings.xml", 0);
    }
  }
  
  public static boolean getBooleanValue(Cursor paramCursor, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramCursor == null) {
      return paramBoolean;
    }
    if (paramCursor.moveToFirst())
    {
      paramBoolean = bool;
      if (paramCursor.getInt(0) > 0) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      paramCursor.close();
      return paramBoolean;
    }
  }
  
  public static final Uri getContentUri(Context paramContext, String paramString1, String paramString2)
  {
    if (BASE_URI == null)
    {
      if (b == null) {
        b = paramContext.getPackageName() + "." + "XG_SETTINGS_PROVIDER";
      }
      BASE_URI = Uri.parse("content://" + b);
    }
    return BASE_URI.buildUpon().appendPath(paramString1).appendPath(paramString2).build();
  }
  
  public static float getFloatValue(Cursor paramCursor, float paramFloat)
  {
    if (paramCursor == null) {
      return paramFloat;
    }
    if (paramCursor.moveToFirst()) {
      paramFloat = paramCursor.getFloat(0);
    }
    paramCursor.close();
    return paramFloat;
  }
  
  public static int getIntValue(Cursor paramCursor, int paramInt)
  {
    if (paramCursor == null) {
      return paramInt;
    }
    if (paramCursor.moveToFirst()) {
      paramInt = paramCursor.getInt(0);
    }
    paramCursor.close();
    return paramInt;
  }
  
  public static long getLongValue(Cursor paramCursor, long paramLong)
  {
    if (paramCursor == null) {
      return paramLong;
    }
    if (paramCursor.moveToFirst()) {
      paramLong = paramCursor.getLong(0);
    }
    paramCursor.close();
    return paramLong;
  }
  
  public static Object getObjectValue(Cursor paramCursor, String paramString)
  {
    if (paramCursor == null) {
      return paramString;
    }
    if (paramCursor.moveToFirst()) {
      paramString = paramCursor.getString(0);
    }
    paramCursor.close();
    return paramString;
  }
  
  public static String getStringValue(Cursor paramCursor, String paramString)
  {
    if (paramCursor == null) {
      return paramString;
    }
    if (paramCursor.moveToFirst()) {
      paramString = paramCursor.getString(0);
    }
    paramCursor.close();
    return paramString;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (a.match(paramUri))
    {
    default: 
      Logger.e("SettingsContentProvider", "Unsupported uri " + paramUri);
    }
    for (;;)
    {
      return 0;
      this.c.edit().clear().commit();
    }
  }
  
  public String getType(Uri paramUri)
  {
    return "vnd.android.cursor.item/vnd.XG_SETTINGS_PROVIDER.item";
  }
  
  @SuppressLint({"NewApi"})
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (a.match(paramUri))
    {
    default: 
      Logger.e("SettingsContentProvider", "Unsupported uri " + paramUri);
    }
    for (;;)
    {
      return null;
      SharedPreferences.Editor localEditor = this.c.edit();
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Object localObject2 = (Map.Entry)paramContentValues.next();
        Object localObject1 = ((Map.Entry)localObject2).getValue();
        localObject2 = Util.getKey((String)((Map.Entry)localObject2).getKey());
        if (localObject1 == null) {
          localEditor.remove((String)localObject2);
        } else if ((localObject1 instanceof String)) {
          localEditor.putString((String)localObject2, (String)localObject1);
        } else if ((localObject1 instanceof Boolean)) {
          localEditor.putBoolean((String)localObject2, ((Boolean)localObject1).booleanValue());
        } else if ((localObject1 instanceof Long)) {
          localEditor.putLong((String)localObject2, ((Long)localObject1).longValue());
        } else if ((localObject1 instanceof Integer)) {
          localEditor.putInt((String)localObject2, ((Integer)localObject1).intValue());
        } else if ((localObject1 instanceof Float)) {
          localEditor.putFloat((String)localObject2, ((Float)localObject1).floatValue());
        } else {
          Logger.e("SettingsContentProvider", "Unsupported type " + paramUri);
        }
      }
      if (Build.VERSION.SDK_INT > 8) {
        localEditor.apply();
      } else {
        localEditor.commit();
      }
    }
  }
  
  public boolean onCreate()
  {
    a(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (a.match(paramUri))
    {
    default: 
      Logger.e("SettingsContentProvider", "Unsupported uri " + paramUri);
      paramUri = null;
    }
    for (;;)
    {
      paramArrayOfString2 = paramUri;
      String str;
      boolean bool;
      do
      {
        return paramArrayOfString2;
        paramString2 = (String)paramUri.getPathSegments().get(0);
        paramArrayOfString1 = Util.getKey(paramString2);
        str = (String)paramUri.getPathSegments().get(1);
        bool = "memory".equals(str);
        paramString1 = paramArrayOfString1;
        if (!this.c.contains(paramArrayOfString1))
        {
          paramString1 = paramArrayOfString1;
          if (!bool) {
            paramString1 = (String)paramUri.getPathSegments().get(0);
          }
        }
        paramArrayOfString1 = new MatrixCursor(new String[] { paramString1 });
        if (this.c.contains(paramString1)) {
          break;
        }
        paramArrayOfString2 = paramArrayOfString1;
      } while (!bool);
      paramArrayOfString2 = paramArrayOfString1.newRow();
      if ("string".equals(str)) {
        paramUri = this.c.getString(paramString1, null);
      }
      for (;;)
      {
        paramArrayOfString2.add(paramUri);
        paramUri = paramArrayOfString1;
        break;
        if ("boolean".equals(str))
        {
          if (this.c.getBoolean(paramString1, false)) {}
          for (int i = 1;; i = 0)
          {
            paramUri = Integer.valueOf(i);
            break;
          }
        }
        if ("long".equals(str))
        {
          paramUri = Long.valueOf(this.c.getLong(paramString1, 0L));
        }
        else if ("integer".equals(str))
        {
          paramUri = Integer.valueOf(this.c.getInt(paramString1, 0));
        }
        else if ("float".equals(str))
        {
          paramUri = Float.valueOf(this.c.getFloat(paramString1, 0.0F));
        }
        else
        {
          if (!bool) {
            break label354;
          }
          paramUri = TGlobalHelper.loadWithIPC(paramString2);
        }
      }
      label354:
      Logger.e("SettingsContentProvider", "Unsupported type " + paramUri);
      paramUri = paramArrayOfString1;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Logger.e("SettingsContentProvider", "UnsupportedOperation: update!");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.SettingsContentProvider
 * JD-Core Version:    0.7.0.1
 */