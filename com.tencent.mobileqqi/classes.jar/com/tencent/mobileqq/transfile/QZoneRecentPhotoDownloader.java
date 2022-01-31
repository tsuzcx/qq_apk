package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class QZoneRecentPhotoDownloader
  extends AbsDownloader
{
  public static final String a = "Q.QZoneRecentPhotoDownloader";
  public static final String b = "troop_photo_qzone";
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int m;
    int i;
    int j;
    if (paramBitmap != null)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if (k <= m) {
        break label63;
      }
      i = m;
      if (k <= m) {
        break label68;
      }
      j = (k - m) / 2;
      label40:
      if (k <= m) {
        break label73;
      }
    }
    label63:
    label68:
    label73:
    for (int k = 0;; k = (m - k) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
      return localBitmap;
      i = k;
      break;
      j = 0;
      break label40;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, "downloadPhoto|filePath = " + paramString1 + ", url = " + paramString2);
    }
    Object localObject = paramString1 + "_temp";
    File localFile1 = new File((String)localObject);
    if (localFile1.exists()) {
      localFile1.delete();
    }
    File localFile2 = localFile1.getParentFile();
    if ((localFile2 != null) && (!localFile2.exists())) {
      localFile2.mkdirs();
    }
    if (HttpDownloadUtil.a(null, paramString2, localFile1))
    {
      paramString2 = a(BitmapFactory.decodeFile((String)localObject));
      if (paramString2 != null)
      {
        paramString1 = new File(paramString1);
        if (paramString1.exists()) {
          paramString1.delete();
        }
        localObject = paramString1.getParentFile();
        if ((localObject != null) && (!((File)localObject).exists())) {
          ((File)localObject).mkdirs();
        }
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1);
      if (paramString1 != null) {
        paramString2.compress(Bitmap.CompressFormat.JPEG, 70, paramString1);
      }
    }
    catch (FileNotFoundException paramString1)
    {
      try
      {
        paramString1.flush();
        paramString1.close();
        localFile1.delete();
        return;
        paramString1 = paramString1;
        paramString1.printStackTrace();
        paramString1 = null;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  private String e(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    int k = paramString.indexOf('[');
    if (k == 0) {
      i = k + 1;
    }
    k = paramString.lastIndexOf(']');
    if (k == paramString.length() - 1) {
      j = k;
    }
    for (;;)
    {
      paramString = paramString.substring(i, j);
      if (QLog.isColorLevel()) {
        QLog.i("Q.QZoneRecentPhotoDownloader", 2, "dealHost|host = " + paramString);
      }
      return paramString;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    Object localObject = paramDownloadParams.url;
    paramOutputStream = paramURLDrawableHandler;
    if (localObject != null)
    {
      paramOutputStream = paramURLDrawableHandler;
      if (Utils.a(((URL)localObject).getProtocol(), "troop_photo_qzone"))
      {
        paramURLDrawableHandler = ((URL)localObject).getFile();
        paramDownloadParams = new File(paramURLDrawableHandler);
        localObject = ((URL)localObject).getHost();
        if (QLog.isColorLevel()) {
          QLog.i("Q.QZoneRecentPhotoDownloader", 2, "downloadImage| path = " + paramURLDrawableHandler + ", host = " + (String)localObject);
        }
        if ((paramDownloadParams.exists()) && (paramDownloadParams.length() > 0L))
        {
          paramOutputStream = paramDownloadParams;
          if (localObject != null) {}
        }
        else
        {
          a(paramURLDrawableHandler, e((String)localObject));
          paramOutputStream = paramDownloadParams;
        }
      }
    }
    return paramOutputStream;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, "decodeFile| f = " + paramFile);
    }
    if (paramFile == null) {}
    for (paramFile = null;; paramFile = paramFile.getPath())
    {
      paramURLDrawableHandler = paramFile;
      if (TextUtils.isEmpty(paramFile))
      {
        paramURLDrawableHandler = paramFile;
        if (paramDownloadParams != null)
        {
          paramURLDrawableHandler = paramFile;
          if (paramDownloadParams.url != null) {
            paramURLDrawableHandler = paramDownloadParams.url.getPath();
          }
        }
      }
      paramFile = localObject;
      if (!TextUtils.isEmpty(paramURLDrawableHandler)) {
        paramFile = BitmapFactory.decodeFile(paramURLDrawableHandler);
      }
      return paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QZoneRecentPhotoDownloader
 * JD-Core Version:    0.7.0.1
 */