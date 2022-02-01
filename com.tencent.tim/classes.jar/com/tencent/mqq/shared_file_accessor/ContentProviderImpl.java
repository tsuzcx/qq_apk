package com.tencent.mqq.shared_file_accessor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.test.AccessRecorder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ContentProviderImpl
  extends ContentProvider
{
  private static final String LOG_TAG = "ContentProviderImpl";
  private static final String[] sMockColums = { "value" };
  
  private String getParam(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = paramUri.getQueryParameter(paramString);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      return null;
    }
    catch (NullPointerException paramUri)
    {
      label9:
      break label9;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramUri = getParam(paramUri, "file");
    if ("*".equals(paramString))
    {
      SharedPreferencesProxyManager.getInstance().getProxyInner(paramUri, 0, false).edit().clear();
      return 0;
    }
    SharedPreferencesProxyManager.getInstance().getProxyInner(paramUri, 0, false).edit().remove(paramString);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return "N/A";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = getParam(paramUri, "file");
    Object localObject2 = (Map.Entry)paramContentValues.valueSet().iterator().next();
    if (localObject2 == null) {
      return null;
    }
    paramContentValues = (String)((Map.Entry)localObject2).getKey();
    localObject2 = ((Map.Entry)localObject2).getValue();
    localObject1 = SharedPreferencesProxyManager.getInstance().getProxyInner((String)localObject1, 0, false).edit();
    if ((localObject2 instanceof Integer))
    {
      ((SharedPreferences.Editor)localObject1).putInt(paramContentValues, ((Integer)localObject2).intValue());
      return paramUri;
    }
    if ((localObject2 instanceof Long))
    {
      ((SharedPreferences.Editor)localObject1).putLong(paramContentValues, ((Long)localObject2).longValue());
      return paramUri;
    }
    if ((localObject2 instanceof Float))
    {
      ((SharedPreferences.Editor)localObject1).putFloat(paramContentValues, ((Float)localObject2).floatValue());
      return paramUri;
    }
    if ((localObject2 instanceof Boolean))
    {
      ((SharedPreferences.Editor)localObject1).putBoolean(paramContentValues, ((Boolean)localObject2).booleanValue());
      return paramUri;
    }
    if ((localObject2 instanceof String))
    {
      ((SharedPreferences.Editor)localObject1).putString(paramContentValues, (String)localObject2);
      return paramUri;
    }
    return null;
  }
  
  public boolean onCreate()
  {
    LogUtil.timeLogEnd("ContentProviderImpl's init", LogUtil.timeLogBegin());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    String str = getParam(paramUri, "file");
    paramString1 = "0";
    int i = 0;
    int j = paramArrayOfString1.length;
    for (;;)
    {
      paramUri = paramString1;
      if (i < j)
      {
        if ("cmd".equals(paramArrayOfString1[i])) {
          paramUri = paramArrayOfString1[(i + 1)];
        }
      }
      else
      {
        if (!"5".equals(paramUri)) {
          break;
        }
        ((SharedPreferencesProxy.EditorImpl)((SharedPreferencesProxy)SharedPreferencesProxyManager.getInstance().getProxyInner(str, 0, false)).edit()).commit(false);
        return null;
      }
      i = i + 1 + 1;
    }
    if ("101".equals(paramUri))
    {
      paramUri = null;
      paramString1 = null;
      i = 0;
      if (i < paramArrayOfString1.length)
      {
        if ("process".equals(paramArrayOfString1[i]))
        {
          j = i + 1;
          paramArrayOfString2 = paramArrayOfString1[j];
        }
        for (;;)
        {
          i = j + 1;
          paramUri = paramArrayOfString2;
          break;
          j = i;
          paramArrayOfString2 = paramUri;
          if ("log".equals(paramArrayOfString1[i]))
          {
            j = i + 1;
            paramString1 = paramArrayOfString1[j];
            paramArrayOfString2 = paramUri;
          }
        }
      }
      if ((!TextUtils.isEmpty(paramUri)) && (!TextUtils.isEmpty(paramString1))) {
        SharedPreferencesProxyManager.getInstance().onModifySp(str, paramUri, paramString1);
      }
      return null;
    }
    paramString1 = "NO_SUCH_KEY";
    int k = -1;
    paramUri = null;
    j = 0;
    int n = paramArrayOfString1.length;
    if (j < n)
    {
      int m;
      if ("key".equals(paramArrayOfString1[j]))
      {
        j += 1;
        i = j;
        paramArrayOfString2 = paramUri;
        m = k;
        paramString2 = paramString1;
        if (j < n)
        {
          paramString2 = paramArrayOfString1[j];
          m = k;
          paramArrayOfString2 = paramUri;
          i = j;
        }
      }
      for (;;)
      {
        j = i + 1;
        paramUri = paramArrayOfString2;
        k = m;
        paramString1 = paramString2;
        break;
        if ("value_type".equals(paramArrayOfString1[j]))
        {
          j += 1;
          i = j;
          paramArrayOfString2 = paramUri;
          m = k;
          paramString2 = paramString1;
          if (j < n)
          {
            m = Integer.parseInt(paramArrayOfString1[j]);
            i = j;
            paramArrayOfString2 = paramUri;
            paramString2 = paramString1;
          }
        }
        else
        {
          i = j;
          paramArrayOfString2 = paramUri;
          m = k;
          paramString2 = paramString1;
          if ("default".equals(paramArrayOfString1[j]))
          {
            j += 1;
            i = j;
            paramArrayOfString2 = paramUri;
            m = k;
            paramString2 = paramString1;
            if (j < n)
            {
              paramArrayOfString2 = paramArrayOfString1[j];
              i = j;
              m = k;
              paramString2 = paramString1;
            }
          }
        }
      }
    }
    if (("NO_SUCH_KEY".equals(paramString1)) || (k == -1)) {
      return null;
    }
    paramArrayOfString2 = new MatrixCursor(sMockColums);
    paramString2 = SharedPreferencesProxyManager.getInstance().getProxyInner(str, 0, false);
    switch (k)
    {
    default: 
      paramUri = null;
    }
    for (;;)
    {
      label530:
      if (paramUri != null)
      {
        if (k == 6) {}
        try
        {
          paramUri = ((Set)paramUri).iterator();
          while (paramUri.hasNext()) {
            paramArrayOfString2.addRow(new Object[] { (String)paramUri.next() });
          }
          paramUri = Integer.valueOf(paramString2.getInt(paramString1, Integer.parseInt(paramUri)));
        }
        catch (Exception paramUri) {}
        paramUri = Long.valueOf(paramString2.getLong(paramString1, Long.parseLong(paramUri)));
        continue;
        if (!paramString2.getBoolean(paramString1, Boolean.parseBoolean(paramUri))) {
          break label760;
        }
      }
      label760:
      for (i = 1;; i = 0)
      {
        paramUri = Integer.valueOf(i);
        break label530;
        paramUri = Float.valueOf(paramString2.getFloat(paramString1, Float.parseFloat(paramUri)));
        break label530;
        paramArrayOfString1 = paramUri;
        if ("null".equals(paramUri)) {
          paramArrayOfString1 = null;
        }
        paramUri = paramString2.getString(paramString1, paramArrayOfString1);
        break label530;
        paramUri = paramString2.getStringSet(paramString1, null);
        if ((paramUri == null) || (paramUri.isEmpty())) {
          break;
        }
        break label530;
        if (!paramString2.contains(paramString1)) {
          break label766;
        }
        paramUri = Integer.valueOf(0);
        break label530;
        paramArrayOfString2.addRow(new Object[] { paramUri });
        return paramArrayOfString2;
      }
      label766:
      paramUri = null;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null) {
      return -1;
    }
    if (paramUri.equals("log")) {
      AccessRecorder.getInstance().log(paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.ContentProviderImpl
 * JD-Core Version:    0.7.0.1
 */