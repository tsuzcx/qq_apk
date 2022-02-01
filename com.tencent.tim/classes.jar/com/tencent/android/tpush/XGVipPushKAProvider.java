package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;

public class XGVipPushKAProvider
  extends ContentProvider
{
  private void a(Uri paramUri, Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      TLogger.d("XGVipPushKAProvider", "prepare startService");
      Intent localIntent = new Intent();
      localIntent.setData(paramUri);
      localIntent.setClass(paramContext, XGVipPushService.class);
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramUri)
    {
      TLogger.w("XGVipPushKAProvider", "start service failed.", paramUri);
    }
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    a(paramUri, getContext());
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    a(paramUri, getContext());
    return null;
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    a(paramUri, getContext());
    return null;
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder().append("onCreate start service context: ");
    if (localContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      TLogger.d("XGVipPushKAProvider", bool);
      if (localContext != null) {
        b.a(localContext);
      }
      return false;
    }
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    a(paramUri, getContext());
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    a(paramUri, getContext());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGVipPushKAProvider
 * JD-Core Version:    0.7.0.1
 */