package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticonview.VoiceGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class PicEmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String h = "PicEmotionDownloader";
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public PicEmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i;
    if (paramDownloadParams != null) {
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder().append("downloadImage|useGifAnimation=").append(paramDownloadParams.useGifAnimation).append(" headers.len=");
        if (paramDownloadParams.headers == null)
        {
          i = 0;
          QLog.d("PicEmotionDownloader", 2, i + " urlStr=" + paramDownloadParams.urlStr + " url.toString=" + paramDownloadParams.url.toString() + " config.tag=" + String.valueOf(paramDownloadParams.tag));
        }
      }
      else
      {
        paramOutputStream = paramDownloadParams.getHeader("emo_tasks");
        if (paramOutputStream == null) {
          break label475;
        }
        i = 1;
        paramOutputStream = paramOutputStream.getValue();
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(paramOutputStream);
        if (!(paramDownloadParams.tag instanceof Emoticon)) {
          break label253;
        }
        paramOutputStream = (Emoticon)paramDownloadParams.tag;
        paramURLDrawableHandler = paramDownloadParams.getHeader("my_uin");
        if (paramURLDrawableHandler == null) {
          break label470;
        }
        paramURLDrawableHandler = paramURLDrawableHandler.getValue();
        if ((paramURLDrawableHandler != null) && (paramURLDrawableHandler.length() != 0)) {
          break label299;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|get selfuin is null");
        }
        throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
      }
      catch (Exception paramOutputStream)
      {
        throw new FileDownloadFailedException(9302, 0L, "can't find emoticon tasks:" + paramOutputStream.toString(), false, false);
      }
      i = paramDownloadParams.headers.length;
      break;
      label253:
      throw new FileDownloadFailedException(9302, 0L, "can't find emoticon!", false, false);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|config is null");
      }
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
      label299:
      paramURLDrawableHandler = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramURLDrawableHandler);
      if (paramURLDrawableHandler == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage|qq_error|app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
      int k = i;
      if (i != 0)
      {
        k = i;
        if (EmoticonController.a(paramURLDrawableHandler).c(paramOutputStream, j)) {
          k = 0;
        }
      }
      if (k != 0)
      {
        boolean bool = EmoticonController.a(paramURLDrawableHandler).b(paramOutputStream, j);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "qq_error|downloadImage| emocontroller result=" + bool + " emo:" + String.valueOf(paramDownloadParams.tag));
        }
        if (!bool) {
          throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
      }
      return new File(AppConstants.an);
      label470:
      paramURLDrawableHandler = null;
      continue;
      label475:
      paramOutputStream = null;
      int j = -1;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    Object localObject = paramDownloadParams.url.getHost();
    int i;
    if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof Emoticon)))
    {
      paramFile = (Emoticon)paramDownloadParams.tag;
      i = paramFile.jobType;
    }
    for (;;)
    {
      if (("big_img".equals(localObject)) || ("big_sound".equals(localObject)))
      {
        if (i == 1)
        {
          paramDownloadParams = EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId);
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramDownloadParams);
          }
          paramFile = new NativeGifImage(new File(EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId)), false);
          paramDownloadParams = paramFile;
          if (paramFile != null)
          {
            paramFile.setDensity(320);
            paramDownloadParams = paramFile;
          }
        }
        do
        {
          return paramDownloadParams;
          if (i == 2)
          {
            paramFile = new NativeGifImage(new File(EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId)), true, true, 0, 0, 0.0F);
            if (paramFile != null) {
              paramFile.setDensity(320);
            }
            return paramFile;
          }
          paramDownloadParams = paramURLDrawableHandler;
        } while (i != 0);
      }
      for (paramFile = EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId);; paramFile = null)
      {
        try
        {
          if (EmosmUtils.isGifFile(paramFile))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + paramFile);
            }
            paramFile = new File(paramFile);
            if ("big_img".equals(localObject)) {}
            for (paramFile = new NativeGifImage(paramFile, true, true, 0, 0, 0.0F);; paramFile = new VoiceGifImage(paramFile, 0, true))
            {
              if (paramFile == null) {
                return paramFile;
              }
              paramFile.setDensity(320);
              return paramFile;
              if (!"big_sound".equals(localObject)) {
                break;
              }
            }
          }
        }
        catch (FileNotFoundException paramFile)
        {
          paramDownloadParams = paramURLDrawableHandler;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
          return null;
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + paramFile);
          }
          localObject = EmosmUtils.getDecryptFileData(paramFile);
          paramDownloadParams = paramURLDrawableHandler;
          if (localObject == null) {
            break;
          }
          paramDownloadParams = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          if (paramDownloadParams == null)
          {
            paramDownloadParams = paramURLDrawableHandler;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + paramFile);
            return null;
          }
        }
        catch (IOException paramFile)
        {
          paramDownloadParams = paramURLDrawableHandler;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
          return null;
          return paramDownloadParams;
        }
        catch (Exception paramFile)
        {
          paramDownloadParams = paramURLDrawableHandler;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
        return null;
        if ("aio_preview".equals(localObject)) {
          if (i == 1) {
            paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramFile);
          }
          paramDownloadParams = paramURLDrawableHandler;
          if (paramFile == null) {
            break;
          }
          paramDownloadParams = paramURLDrawableHandler;
          if (paramFile.length() <= 0) {
            break;
          }
          return BitmapFactory.decodeFile(paramFile, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          paramFile = EmosmUtils.getEmoticonAIOPreviewPath(paramFile.epId, paramFile.eId);
          continue;
          if ("panel_preview".equals(localObject)) {
            paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
          } else {
            paramFile = "";
          }
        }
      }
      i = 0;
      paramFile = null;
    }
    return paramFile;
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */