package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import gnh;
import gni;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "FileAssistantDownloader";
  protected BaseApplicationImpl a;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap a(gnh paramgnh)
  {
    Bitmap localBitmap = null;
    int i = paramgnh.jdField_a_of_type_Int;
    int j = paramgnh.jdField_b_of_type_Int;
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramgnh.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = ImageUtil.b((BitmapFactory.Options)localObject, i, j);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeFile(paramgnh.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      if (localObject != null) {
        localBitmap = new ExifBitmapCreator(paramgnh.jdField_a_of_type_JavaLangString).a((Bitmap)localObject);
      }
      return localBitmap;
    }
    catch (Throwable paramgnh)
    {
      QLog.d("AlbumThumbManager", 2, "make Thumb", paramgnh);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f = this.a.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public gnh a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      gnh localgnh = new gnh(this);
      localgnh.jdField_a_of_type_JavaLangString = paramURL[0];
      localgnh.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localgnh.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localgnh.jdField_b_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localgnh.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label145;
          }
          bool1 = true;
          label105:
          localgnh.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6) {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label150;
          }
        }
      }
      label145:
      label150:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localgnh.c = bool1;
        return localgnh;
        bool1 = false;
        break;
        bool1 = false;
        break label105;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream.jdField_a_of_type_JavaLangString == null) {
      return new File(AppConstants.al);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, gnh paramgnh)
  {
    Object localObject = null;
    paramDownloadParams = null;
    String str = paramgnh.jdField_a_of_type_JavaLangString;
    if (str == null) {
      paramgnh = paramDownloadParams;
    }
    File localFile;
    for (;;)
    {
      return paramgnh;
      localFile = new File(str);
      try
      {
        if ((GifDrawable.isGifFile(localFile)) && (paramgnh.jdField_a_of_type_Boolean))
        {
          paramgnh = paramDownloadParams;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileAssistantDownloader", 2, "DecodeFile END,GIF image,cacheFile=" + localFile.getAbsolutePath() + ",url=" + str);
          return null;
        }
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = URLDrawableHelper.a;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
    if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0)) {
      throw new IOException("step:decode bounds error, not valid pic");
    }
    localOptions.inSampleSize = AbstractImageDownloader.a(localOptions, paramgnh.jdField_a_of_type_Int, paramgnh.jdField_b_of_type_Int);
    int i = localOptions.outWidth;
    i = localOptions.outHeight;
    localOptions.inJustDecodeBounds = false;
    i = 1;
    paramgnh = null;
    label223:
    paramDownloadParams = localObject;
    if (i <= 3)
    {
      paramDownloadParams = paramgnh;
      try
      {
        paramgnh = BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
        if (paramgnh == null)
        {
          paramDownloadParams = paramgnh;
          throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i + ",path:" + localFile.getAbsolutePath());
        }
      }
      catch (OutOfMemoryError paramgnh)
      {
        if (paramDownloadParams != null) {
          paramDownloadParams.recycle();
        }
        if (paramgnh == null) {}
      }
    }
    for (paramgnh = paramgnh.getMessage();; paramgnh = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantDownloader", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",cacheFile=" + localFile.getAbsolutePath() + ",url=" + str + ",oom.msg:" + paramgnh);
      }
      localOptions.inSampleSize *= 2;
      i += 1;
      paramgnh = paramDownloadParams;
      break label223;
      paramDownloadParams = paramgnh;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDownloadParams = paramgnh;
        boolean bool = SliceBitmap.needSlice(paramgnh);
        if (!bool) {}
      }
      paramDownloadParams = paramgnh;
      paramgnh = paramDownloadParams;
      if (paramDownloadParams != null) {
        break;
      }
      throw new IOException("decode image failed");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    gnh localgnh = a(paramDownloadParams.url);
    if ((localgnh.jdField_a_of_type_Boolean) && (!localgnh.jdField_b_of_type_Boolean) && (!localgnh.c))
    {
      paramDownloadParams = a(paramDownloadParams, localgnh);
      return paramDownloadParams;
    }
    if (localgnh.c)
    {
      paramFile = FileCategoryUtil.b(this.a, localgnh.jdField_a_of_type_JavaLangString);
      if (paramFile == null) {
        break label133;
      }
      paramFile = a(paramFile);
    }
    for (;;)
    {
      paramDownloadParams = paramURLDrawableHandler;
      if (paramFile == null) {
        break;
      }
      if (localgnh.jdField_b_of_type_Boolean)
      {
        return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
        paramFile = paramFile.a(paramDownloadParams.url, new gni(this));
      }
      else
      {
        return paramFile;
        label133:
        paramFile = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */