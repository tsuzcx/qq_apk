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
import gng;
import gnh;
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
  
  private Bitmap a(gng paramgng)
  {
    Bitmap localBitmap = null;
    int i = paramgng.jdField_a_of_type_Int;
    int j = paramgng.jdField_b_of_type_Int;
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramgng.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = ImageUtil.b((BitmapFactory.Options)localObject, i, j);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeFile(paramgng.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      if (localObject != null) {
        localBitmap = new ExifBitmapCreator(paramgng.jdField_a_of_type_JavaLangString).a((Bitmap)localObject);
      }
      return localBitmap;
    }
    catch (Throwable paramgng)
    {
      QLog.d("AlbumThumbManager", 2, "make Thumb", paramgng);
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
  
  public gng a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      gng localgng = new gng(this);
      localgng.jdField_a_of_type_JavaLangString = paramURL[0];
      localgng.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localgng.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localgng.jdField_b_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localgng.jdField_a_of_type_Boolean = bool1;
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
          localgng.jdField_b_of_type_Boolean = bool1;
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
        localgng.c = bool1;
        return localgng;
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
  
  public Object a(DownloadParams paramDownloadParams, gng paramgng)
  {
    Object localObject = null;
    paramDownloadParams = null;
    String str = paramgng.jdField_a_of_type_JavaLangString;
    if (str == null) {
      paramgng = paramDownloadParams;
    }
    File localFile;
    for (;;)
    {
      return paramgng;
      localFile = new File(str);
      try
      {
        if ((GifDrawable.isGifFile(localFile)) && (paramgng.jdField_a_of_type_Boolean))
        {
          paramgng = paramDownloadParams;
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
    localOptions.inSampleSize = AbstractImageDownloader.a(localOptions, paramgng.jdField_a_of_type_Int, paramgng.jdField_b_of_type_Int);
    int i = localOptions.outWidth;
    i = localOptions.outHeight;
    localOptions.inJustDecodeBounds = false;
    i = 1;
    paramgng = null;
    label223:
    paramDownloadParams = localObject;
    if (i <= 3)
    {
      paramDownloadParams = paramgng;
      try
      {
        paramgng = BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
        if (paramgng == null)
        {
          paramDownloadParams = paramgng;
          throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i + ",path:" + localFile.getAbsolutePath());
        }
      }
      catch (OutOfMemoryError paramgng)
      {
        if (paramDownloadParams != null) {
          paramDownloadParams.recycle();
        }
        if (paramgng == null) {}
      }
    }
    for (paramgng = paramgng.getMessage();; paramgng = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantDownloader", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",cacheFile=" + localFile.getAbsolutePath() + ",url=" + str + ",oom.msg:" + paramgng);
      }
      localOptions.inSampleSize *= 2;
      i += 1;
      paramgng = paramDownloadParams;
      break label223;
      paramDownloadParams = paramgng;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDownloadParams = paramgng;
        boolean bool = SliceBitmap.needSlice(paramgng);
        if (!bool) {}
      }
      paramDownloadParams = paramgng;
      paramgng = paramDownloadParams;
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
    gng localgng = a(paramDownloadParams.url);
    if ((localgng.jdField_a_of_type_Boolean) && (!localgng.jdField_b_of_type_Boolean) && (!localgng.c))
    {
      paramDownloadParams = a(paramDownloadParams, localgng);
      return paramDownloadParams;
    }
    if (localgng.c)
    {
      paramFile = FileCategoryUtil.b(this.a, localgng.jdField_a_of_type_JavaLangString);
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
      if (localgng.jdField_b_of_type_Boolean)
      {
        return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
        paramFile = paramFile.a(paramDownloadParams.url, new gnh(this));
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