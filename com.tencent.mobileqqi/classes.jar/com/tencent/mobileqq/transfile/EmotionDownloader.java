package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.Header;

public class EmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String O = "EmotionDownloader";
  static File jdField_a_of_type_JavaIoFile;
  static File b;
  public static final String h = "system_face_decode_copyfile";
  public final int a;
  Application jdField_a_of_type_AndroidAppApplication;
  public final int b;
  
  public EmotionDownloader(Application paramApplication)
  {
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    jdField_b_of_type_JavaIoFile = paramApplication.getDir("", 0);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if ((jdField_a_of_type_JavaIoFile == null) || (!jdField_a_of_type_JavaIoFile.exists()))
      {
        jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_AndroidAppApplication.getDir("systemface", 0);
        paramOutputStream = this.jdField_a_of_type_AndroidAppApplication.getDir("sysface", 0);
        if (paramOutputStream.exists()) {
          paramOutputStream.delete();
        }
        if (!jdField_a_of_type_JavaIoFile.exists()) {
          jdField_a_of_type_JavaIoFile.mkdirs();
        }
      }
      Object localObject = paramDownloadParams.url.getHost();
      paramOutputStream = new File(jdField_a_of_type_JavaIoFile + "/" + (String)localObject);
      if ((paramOutputStream.exists()) && (paramOutputStream.length() != 0L)) {
        break label413;
      }
      paramURLDrawableHandler = new File(jdField_a_of_type_JavaIoFile + "/" + (String)localObject + ".tmp");
      if (paramURLDrawableHandler.exists()) {
        paramURLDrawableHandler.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionDownloader", 2, "downloadImage isGIF !targetFile.exists(),url=" + paramDownloadParams.urlStr + ",drawableName=" + (String)localObject + ",targetFile=" + paramOutputStream.getAbsolutePath());
      }
      int i = this.jdField_a_of_type_AndroidAppApplication.getResources().getIdentifier((String)localObject, "drawable", this.jdField_a_of_type_AndroidAppApplication.getPackageName());
      paramDownloadParams = this.jdField_a_of_type_AndroidAppApplication.getResources().openRawResource(i);
      localObject = new byte[4096];
      FileOutputStream localFileOutputStream = new FileOutputStream(paramURLDrawableHandler);
      while (paramDownloadParams.read((byte[])localObject) != -1)
      {
        localFileOutputStream.write((byte[])localObject);
        localFileOutputStream.flush();
      }
      localFileOutputStream.close();
    }
    catch (Exception paramOutputStream)
    {
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("param_FailCode", Integer.toString(89500));
      paramDownloadParams.put("param_FailMsg", AbstractImageDownloader.a(paramOutputStream));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramDownloadParams, "");
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "downloadImage", paramOutputStream);
      }
      return jdField_b_of_type_JavaIoFile;
    }
    paramDownloadParams.close();
    paramURLDrawableHandler.renameTo(paramOutputStream);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", true, 0L, 0L, null, "");
    label413:
    if (paramOutputStream.exists()) {
      return paramOutputStream;
    }
    paramOutputStream = new HashMap();
    paramOutputStream.put("param_FailCode", Integer.toString(89501));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramOutputStream, "");
    paramOutputStream = jdField_b_of_type_JavaIoFile;
    return paramOutputStream;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(jdField_b_of_type_JavaIoFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID").getValue();
        if (paramFile != null)
        {
          int i = Integer.valueOf(paramFile).intValue();
          return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppApplication.getResources(), i);
        }
      }
      else
      {
        if (!GifDrawable.isGifFile(paramFile)) {
          break label85;
        }
        paramFile = new NativeGifImage(paramFile, false);
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
    }
    return null;
    label85:
    paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.EmotionDownloader
 * JD-Core Version:    0.7.0.1
 */