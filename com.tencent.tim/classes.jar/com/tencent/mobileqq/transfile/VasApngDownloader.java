package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aoja;
import aquz;
import aqva;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class VasApngDownloader
  extends aoja
{
  public VasApngDownloader()
  {
    super("VasApngDownloader", BaseApplicationImpl.getApplication());
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (paramDownloadParams == null) {
      return null;
    }
    paramURLDrawableHandler = paramDownloadParams.url.getHost();
    File localFile = new File(paramURLDrawableHandler);
    label42:
    long l;
    int i;
    if ((paramDownloadParams.mExtraInfo instanceof Bundle))
    {
      paramOutputStream = (Bundle)paramDownloadParams.mExtraInfo;
      if (paramOutputStream == null) {
        break label420;
      }
      l = paramOutputStream.getLong("bundle_key_bid", 0L);
      paramOutputStream = paramOutputStream.getString("bundle_key_scid");
      if ((l == 0L) || (TextUtils.isEmpty(paramOutputStream))) {
        break label95;
      }
      i = 1;
    }
    for (;;)
    {
      if (localFile.exists())
      {
        return localFile;
        paramOutputStream = null;
        break label42;
        label95:
        i = 0;
        continue;
      }
      if (i != 0)
      {
        VasQuickUpdateManager.getFileFromLocal(BaseApplicationImpl.sApplication.getRuntime(), l, paramOutputStream, null, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage method err, scid=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        QLog.e("vasapngdownloader", 2, "downloadImage url err, url=" + paramDownloadParams + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith(File.separator)) {
        paramOutputStream = paramDownloadParams.substring(1);
      }
      if (!paramOutputStream.startsWith("http"))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage url has no http err, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = new aquz(paramOutputStream, localFile);
      paramDownloadParams.cWq = true;
      i = aqva.a(paramDownloadParams, BaseApplicationImpl.sApplication.getRuntime());
      if (i == 0)
      {
        if (localFile.exists()) {
          return localFile;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage file not exists, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
        return null;
      }
      QLog.e("vasapngdownloader", 1, "downloadImage Error url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
      return null;
      label420:
      i = 0;
      paramOutputStream = null;
      l = 0L;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (ApngDrawable.isApngFile(paramFile))
    {
      paramURLDrawableHandler = localObject2;
      if (paramFile.exists())
      {
        paramURLDrawableHandler = localObject2;
        if (paramDownloadParams != null)
        {
          paramURLDrawableHandler = localObject2;
          if (paramDownloadParams.useApngImage)
          {
            paramURLDrawableHandler = localObject1;
            if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
              paramURLDrawableHandler = (Bundle)paramDownloadParams.mExtraInfo;
            }
            paramURLDrawableHandler = new VasApngImage(paramFile, true, paramURLDrawableHandler);
            if (paramURLDrawableHandler.firstFrame == null) {
              ChatBackgroundManager.Mk(paramFile.getAbsolutePath());
            }
          }
        }
      }
      return paramURLDrawableHandler;
    }
    if (paramFile == null)
    {
      QLog.e("vasapngdownloader", 1, "decodeFile error : file == null");
      return null;
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public static class VasApngImage
    extends ApngImage
  {
    private float Ae;
    
    public VasApngImage(File paramFile, boolean paramBoolean, Bundle paramBundle)
      throws IOException
    {
      super(paramBoolean, paramBundle);
      this.Ae = paramBundle.getFloat("key_frame_delay_fraction", 0.0F);
    }
    
    /* Error */
    public boolean getNextFrame()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 31	com/tencent/image/ApngImage:getNextFrame	()Z
      //   6: ifeq +33 -> 39
      //   9: aload_0
      //   10: getfield 25	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:Ae	F
      //   13: fconst_0
      //   14: fcmpl
      //   15: ifle +18 -> 33
      //   18: aload_0
      //   19: aload_0
      //   20: getfield 35	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:currentFrameDelay	I
      //   23: i2f
      //   24: aload_0
      //   25: getfield 25	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:Ae	F
      //   28: fmul
      //   29: f2i
      //   30: putfield 35	com/tencent/mobileqq/transfile/VasApngDownloader$VasApngImage:currentFrameDelay	I
      //   33: iconst_1
      //   34: istore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: iload_1
      //   38: ireturn
      //   39: iconst_0
      //   40: istore_1
      //   41: goto -6 -> 35
      //   44: astore_2
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_2
      //   48: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	49	0	this	VasApngImage
      //   34	7	1	bool	boolean
      //   44	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	33	44	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader
 * JD-Core Version:    0.7.0.1
 */