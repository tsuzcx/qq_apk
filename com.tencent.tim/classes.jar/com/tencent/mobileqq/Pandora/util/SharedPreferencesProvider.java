package com.tencent.mobileqq.Pandora.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferencesProvider
  extends ContentProvider
{
  public static final String AUTHORIRY = "com.tencent.mobileqq.Pandora";
  public static final String PATH = "SharedPreferences";
  private static final int PATH_CODE = 1;
  private static final String TAG = "PreferencesProvider";
  private UriMatcher mUriMatcher;
  
  private static String getFileProviderName(Context paramContext)
  {
    return "com.tencent.mobileqq.Pandora." + paramContext.getPackageName();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject = (Map.Entry)paramContentValues.valueSet().iterator().next();
    if (localObject == null)
    {
      Log.d("PreferencesProvider", "empty entity found when inserting.");
      return null;
    }
    paramContentValues = (String)((Map.Entry)localObject).getKey();
    localObject = ((Map.Entry)localObject).getValue();
    SharedPreferencesManager.saveDataToSp(getContext(), paramContentValues, (String)localObject);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    this.mUriMatcher = new UriMatcher(-1);
    this.mUriMatcher.addURI(getFileProviderName(getContext()), "SharedPreferences", 1);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramUri = null;
    if (paramArrayOfString2 != null) {
      paramUri = paramArrayOfString2[0];
    }
    paramString1 = new MatrixCursor(new String[] { "KEY", "VALUE" });
    try
    {
      if (SharedPreferencesManager.isSaveInSp(getContext(), paramUri).booleanValue()) {}
      for (paramArrayOfString1 = SharedPreferencesManager.getDataFromSp(getContext(), paramUri);; paramArrayOfString1 = "data is null")
      {
        paramString1.addRow(new Object[] { paramUri, paramArrayOfString1 });
        return paramString1;
      }
      return paramString1;
    }
    catch (Exception paramUri)
    {
      Log.e("PreferencesProvider", "Provider query error : ", paramUri);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.SharedPreferencesProvider
 * JD-Core Version:    0.7.0.1
 */