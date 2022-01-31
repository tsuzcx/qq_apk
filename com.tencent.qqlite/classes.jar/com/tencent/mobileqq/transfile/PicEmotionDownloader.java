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
import com.tencent.mobileqq.emoticon.EmojiManager;
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
          break label479;
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
          break label474;
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
      paramURLDrawableHandler = (EmojiManager)paramURLDrawableHandler.getManager(39);
      int k = i;
      if (i != 0)
      {
        k = i;
        if (paramURLDrawableHandler.c(paramOutputStream, j)) {
          k = 0;
        }
      }
      if (k != 0)
      {
        boolean bool = paramURLDrawableHandler.b(paramOutputStream, j);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "qq_error|downloadImage| emocontroller result=" + bool + " emo:" + String.valueOf(paramDownloadParams.tag));
        }
        if (!bool) {
          throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
      }
      return new File(AppConstants.as);
      label474:
      paramURLDrawableHandler = null;
      continue;
      label479:
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
    int i;
    if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof Emoticon)))
    {
      paramFile = (Emoticon)paramDownloadParams.tag;
      i = paramFile.jobType;
      paramDownloadParams = paramDownloadParams.url.getHost();
      if ((!"big_img".equals(paramDownloadParams)) && (!"big_sound".equals(paramDownloadParams))) {
        break label465;
      }
      if (i == 1)
      {
        paramDownloadParams = EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId);
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramDownloadParams);
        }
        paramDownloadParams = new NativeGifImage(new File(EmosmUtils.getQFaceGifPath(paramFile.epId, paramFile.eId)), false);
        paramDownloadParams.setDensity(320);
        return paramDownloadParams;
      }
    }
    else
    {
      return null;
    }
    if (i == 2)
    {
      paramFile = new NativeGifImage(new File(EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId)), true, true, 0, 0, 0.0F);
      paramFile.setDensity(320);
      return paramFile;
    }
    if (i == 0) {
      paramURLDrawableHandler = EmosmUtils.getEmoticonEncryptPath(paramFile.epId, paramFile.eId);
    }
    for (;;)
    {
      try
      {
        if (EmosmUtils.isGifFile(paramURLDrawableHandler))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + paramURLDrawableHandler);
          }
          paramFile = new File(paramURLDrawableHandler);
          if ("big_img".equals(paramDownloadParams))
          {
            paramFile = new NativeGifImage(paramFile, true, true, 0, 0, 0.0F);
            paramDownloadParams = paramFile;
            if (paramFile == null) {
              break;
            }
            paramFile.setDensity(320);
            return paramFile;
          }
        }
      }
      catch (FileNotFoundException paramFile)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
        }
        return null;
        if (!"big_sound".equals(paramDownloadParams)) {
          break label593;
        }
        paramFile = new VoiceGifImage(paramFile, 0, true);
        continue;
      }
      catch (IOException paramFile)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + paramURLDrawableHandler);
        }
        paramFile = EmosmUtils.getDecryptFileData(paramURLDrawableHandler);
        if (paramFile == null) {
          continue;
        }
        paramFile = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
        paramDownloadParams = paramFile;
        if (paramFile != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + paramURLDrawableHandler);
        }
        return null;
      }
      catch (Exception paramFile)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmotionDownloader", 2, "decode MARKET File", paramFile);
        continue;
      }
      label465:
      if ("aio_preview".equals(paramDownloadParams)) {
        if (i == 1) {
          paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile host == STATIC,path=" + paramFile);
        }
        if ((paramFile != null) && (paramFile.length() > 0))
        {
          return BitmapFactory.decodeFile(paramFile, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          paramFile = EmosmUtils.getEmoticonAIOPreviewPath(paramFile.epId, paramFile.eId);
          continue;
          if ("panel_preview".equals(paramDownloadParams)) {
            paramFile = EmosmUtils.getEmoticonPreviewPath(paramFile.epId, paramFile.eId);
          }
        }
        else
        {
          return null;
        }
        paramFile = "";
      }
      label593:
      paramFile = null;
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */