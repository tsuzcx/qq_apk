package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class ScreenCapture
{
  public static final String SNAP_CACHE_FILE = "snap_cache";
  public static final String SNAP_CACHE_FILE_SUCCESS_KEY = "snap_cache_file_success_key";
  
  public static void captureViewToFile(String paramString, View paramView)
  {
    if ((paramString == null) || (paramView == null)) {
      return;
    }
    QLog.i("sethmao", 4, "path is " + paramString);
    new a(paramView).execute(new String[] { paramString });
  }
  
  public static boolean clearSnapCacheFile(Context paramContext)
  {
    return deleteDir(new File(getSnapDir(paramContext)));
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static String getSnapDir(Context paramContext)
  {
    return paramContext.getFilesDir() + "/" + "snap";
  }
  
  public static String getSnapPath(Context paramContext, int paramInt)
  {
    return paramContext.getFilesDir() + "/" + "snap/" + paramInt;
  }
  
  public static boolean hasSnapFile(Context paramContext)
  {
    return paramContext.getSharedPreferences("snap_cache", 0).getBoolean("snap_cache_file_success_key", false);
  }
  
  public static void setSnapFile(Context paramContext, boolean paramBoolean)
  {
    boolean bool = paramContext.getSharedPreferences("snap_cache", 0).edit().putBoolean("snap_cache_file_success_key", paramBoolean).commit();
    QLog.i("sethmao", 4, "captured is " + paramBoolean + ", success is " + bool + ", has snap file is " + hasSnapFile(paramContext));
  }
  
  static class a
    extends AsyncTask<String, Void, Boolean>
  {
    private Bitmap dC;
    private WeakReference<View> eE;
    
    public a(View paramView)
    {
      if (paramView != null)
      {
        Context localContext = paramView.getContext();
        this.eE = new WeakReference(paramView);
        paramView.setDrawingCacheEnabled(true);
        this.dC = paramView.getDrawingCache();
        ScreenCapture.setSnapFile(localContext, false);
      }
    }
    
    protected Boolean doInBackground(String... paramVarArgs)
    {
      Boolean localBoolean = Boolean.FALSE;
      if (isCancelled()) {}
      while ((this.eE.get() == null) || (this.dC == null) || (this.dC.isRecycled())) {
        return localBoolean;
      }
      Bitmap localBitmap = this.dC;
      paramVarArgs = new File(paramVarArgs[0]);
      File localFile = paramVarArgs.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      try
      {
        paramVarArgs = new FileOutputStream(paramVarArgs);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramVarArgs);
        paramVarArgs.flush();
        paramVarArgs.close();
        paramVarArgs = Boolean.TRUE;
        return paramVarArgs;
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return localBoolean;
    }
    
    protected void onCancelled() {}
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      if (this.eE != null)
      {
        View localView = (View)this.eE.get();
        if (localView != null)
        {
          if (paramBoolean.booleanValue()) {
            ScreenCapture.setSnapFile(localView.getContext(), true);
          }
          this.dC = null;
          localView.setDrawingCacheEnabled(false);
          localView.destroyDrawingCache();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ScreenCapture
 * JD-Core Version:    0.7.0.1
 */