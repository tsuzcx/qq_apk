package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class MediaUtils
{
  private static final String TAG = "MediaUtils";
  
  public static void getImageForVideo(WeakReference<IMiniAppContext> paramWeakReference, String paramString, OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    new LoadVideoImageTask(paramWeakReference, paramOnLoadVideoImageListener).execute(new String[] { paramString });
  }
  
  public static class LoadVideoImageTask
    extends AsyncTask<String, Integer, File>
  {
    private MediaUtils.OnLoadVideoImageListener listener;
    private WeakReference<IMiniAppContext> miniAppContextWeakReference;
    
    public LoadVideoImageTask(WeakReference<IMiniAppContext> paramWeakReference, MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
    {
      this.listener = paramOnLoadVideoImageListener;
    }
    
    protected File doInBackground(String... paramVarArgs)
    {
      MediaMetadataRetriever localMediaMetadataRetriever;
      Bitmap localBitmap;
      Object localObject;
      try
      {
        localMediaMetadataRetriever = new MediaMetadataRetriever();
        paramVarArgs = paramVarArgs[0];
        if ((paramVarArgs.startsWith("http")) || (paramVarArgs.startsWith("https"))) {
          localMediaMetadataRetriever.setDataSource(paramVarArgs, new HashMap());
        }
        for (;;)
        {
          localBitmap = localMediaMetadataRetriever.getFrameAtTime();
          localObject = (IMiniAppContext)this.miniAppContextWeakReference.get();
          if (localObject != null) {
            break;
          }
          return null;
          localMediaMetadataRetriever.setDataSource(paramVarArgs);
        }
        localObject = new File(((MiniAppFileManager)((IMiniAppContext)localObject).getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
      }
      catch (Exception paramVarArgs)
      {
        QMLog.e("MediaUtils", "getImageForVideo error." + paramVarArgs);
        return null;
      }
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        localMediaMetadataRetriever.release();
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MediaUtils", "doInBackground: " + paramVarArgs, localException);
        }
      }
    }
    
    protected void onPostExecute(File paramFile)
    {
      super.onPostExecute(paramFile);
      if (this.listener != null) {
        this.listener.onLoadImage(paramFile);
      }
    }
  }
  
  public static abstract interface OnLoadVideoImageListener
  {
    public abstract void onLoadImage(File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MediaUtils
 * JD-Core Version:    0.7.0.1
 */