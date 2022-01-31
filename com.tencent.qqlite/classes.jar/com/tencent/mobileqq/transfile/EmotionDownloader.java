package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
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
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  public final int b;
  
  public EmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    jdField_b_of_type_JavaIoFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_JavaIoFile == null) || (!jdField_a_of_type_JavaIoFile.exists()))
        {
          jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getDir("systemface", 0);
          paramOutputStream = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getDir("sysface", 0);
          if (paramOutputStream.exists()) {
            paramOutputStream.delete();
          }
          if (!jdField_a_of_type_JavaIoFile.exists()) {
            jdField_a_of_type_JavaIoFile.mkdirs();
          }
        }
        try
        {
          paramOutputStream = EarlyDownloadManager.a();
          paramURLDrawableHandler = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
          File localFile = null;
          paramOutputStream = localFile;
          if (paramURLDrawableHandler != null)
          {
            paramURLDrawableHandler = (EarlyDownloadManager)paramURLDrawableHandler.getManager(58);
            paramOutputStream = localFile;
            if (paramURLDrawableHandler != null) {
              paramOutputStream = (SystemFaceHandler)paramURLDrawableHandler.a("qq.android.system.face.gif");
            }
          }
          paramURLDrawableHandler = paramDownloadParams.url.getHost();
          localFile = new File(jdField_a_of_type_JavaIoFile + "/" + paramURLDrawableHandler);
          if ((localFile.exists()) && (localFile.length() != 0L)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("EmotionDownloader", 2, "downloadImage isGIF !targetFile.exists(),url=" + paramDownloadParams.urlStr + ",drawableName=" + paramURLDrawableHandler + ",targetFile=" + localFile.getAbsolutePath());
          }
          if (paramOutputStream != null)
          {
            paramOutputStream.b(paramDownloadParams.getHeader("faceIdx").getValue());
            paramOutputStream.b(true);
            paramOutputStream.c(false);
          }
          if (!localFile.exists()) {
            break label395;
          }
          return localFile;
        }
        catch (Exception paramOutputStream)
        {
          if (!QLog.isColorLevel()) {
            break label439;
          }
        }
        QLog.d("EmotionDownloader", 2, "getting QQApp throws a Exception:" + paramOutputStream.getMessage());
      }
      catch (Exception paramOutputStream)
      {
        paramDownloadParams = new HashMap();
        paramDownloadParams.put("param_FailCode", Integer.toString(89500));
        paramDownloadParams.put("param_FailMsg", AbstractImageDownloader.a(paramOutputStream));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramDownloadParams, "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmotionDownloader", 2, "downloadImage", paramOutputStream);
        return jdField_b_of_type_JavaIoFile;
      }
      if (paramOutputStream != null)
      {
        paramOutputStream.c(true);
        continue;
        label395:
        paramOutputStream = new HashMap();
        paramOutputStream.put("param_FailCode", Integer.toString(89501));
        StatisticCollector.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramOutputStream, "");
        paramOutputStream = jdField_b_of_type_JavaIoFile;
        return paramOutputStream;
        label439:
        paramURLDrawableHandler = null;
      }
    }
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
          return BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.EmotionDownloader
 * JD-Core Version:    0.7.0.1
 */