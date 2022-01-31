package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmoticonTask
  implements TaskInterface, HttpDownloadUtil.HttpDownloadListener
{
  private final int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private EmoticonController.ProgressHandler jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  private int b;
  
  public EmoticonTask(Emoticon paramEmoticon, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler != null) && (paramDownloadInfo != null))
    {
      paramDownloadInfo.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.a("param_step", paramInt);
    }
  }
  
  private void b()
  {
    String str;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      str = EmosmUtils.getQFaceThumbUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey);
      localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      i = 15;
      File localFile = new File((String)localObject);
      if (localFile.exists()) {
        break label174;
      }
      localObject = new DownloadInfo(str, localFile, i);
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      if (((DownloadInfo)localObject).jdField_b_of_type_Int != 0) {
        break label155;
      }
      this.jdField_b_of_type_Int = 0;
    }
    label155:
    label174:
    do
    {
      return;
      str = EmosmUtils.getEmoticonPreviewUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      i = 6;
      break;
      this.jdField_b_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject).jdField_b_of_type_Int);
      a((DownloadInfo)localObject, 6);
      return;
      this.jdField_b_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "handleImgPreview| preview exist. path=" + (String)localObject);
  }
  
  private void c()
  {
    Object localObject1 = EmosmUtils.getEmoticonEncrytUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    Object localObject2 = EmosmUtils.getEmoticonEncryptPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    File localFile = new File((String)localObject2);
    if (!localFile.exists())
    {
      localObject2 = new DownloadInfo((String)localObject1, localFile, 7);
      ((DownloadInfo)localObject2).c = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey;
      ((DownloadInfo)localObject2).f = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey != null) {
        HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject2, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      }
      if (((DownloadInfo)localObject2).jdField_b_of_type_Int == 0)
      {
        try
        {
          if ((((DownloadInfo)localObject2).i == null) || (!((DownloadInfo)localObject2).i.toLowerCase().contains("gzip"))) {
            break label377;
          }
          localObject1 = Utils.a(((DownloadInfo)localObject2).jdField_a_of_type_ArrayOfByte);
          int i = EmosmUtils.saveEmosm((byte[])localObject1, ((DownloadInfo)localObject2).c, ((DownloadInfo)localObject2).jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (i != 0)
          {
            ((DownloadInfo)localObject2).jdField_b_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "emoDownload|qq_error|download encrypt exception,resultCode=" + ((DownloadInfo)localObject2).jdField_b_of_type_Int + " info.url=" + ((DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
            }
            ((DownloadInfo)localObject2).jdField_a_of_type_JavaIoFile.delete();
            if ((Utils.e()) && (Utils.b() > 1048576L)) {
              FileUtils.a(AppConstants.an + "err" + File.separator + String.valueOf(((DownloadInfo)localObject2).f) + "_" + String.valueOf(((DownloadInfo)localObject2).c) + "_" + ((DownloadInfo)localObject2).jdField_a_of_type_JavaIoFile.getName(), (byte[])localObject1, false);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "emoDownload| Emotiocon encode resource done.result=" + i + " time:" + System.currentTimeMillis() + " url=" + ((DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
            ((DownloadInfo)localObject2).jdField_b_of_type_Int = 11020;
            ((DownloadInfo)localObject2).e = localThrowable.toString();
            ((DownloadInfo)localObject2).jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "emoDownload|qq_error| Emotiocon encode resource fail .EXCEPTION:" + ((DownloadInfo)localObject2).e + " time:" + System.currentTimeMillis() + " url=" + ((DownloadInfo)localObject2).jdField_b_of_type_JavaLangString);
            }
          }
        }
        this.jdField_b_of_type_Int = 0;
      }
    }
    label377:
    do
    {
      return;
      localObject1 = ((DownloadInfo)localObject2).jdField_a_of_type_ArrayOfByte;
      break;
      this.jdField_b_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject2).jdField_b_of_type_Int);
      a((DownloadInfo)localObject2, 7);
      return;
      this.jdField_b_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "handleImgEncrypt| imgEncrypt exist. path=" + (String)localObject2);
  }
  
  private void d()
  {
    String str;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      str = EmosmUtils.getQFaceThumbUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey);
      localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      i = 15;
      File localFile = new File((String)localObject);
      if (localFile.exists()) {
        break label174;
      }
      localObject = new DownloadInfo(str, localFile, i);
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      if (((DownloadInfo)localObject).jdField_b_of_type_Int != 0) {
        break label155;
      }
      this.jdField_b_of_type_Int = 0;
    }
    label155:
    label174:
    do
    {
      return;
      str = EmosmUtils.getEmoticonAIOPreviewUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      i = 8;
      break;
      this.jdField_b_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject).jdField_b_of_type_Int);
      a((DownloadInfo)localObject, 8);
      return;
      this.jdField_b_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "handleImgPreviewStatic| imgPreviewStatic exist. path=" + (String)localObject);
  }
  
  private void e()
  {
    Object localObject = EmosmUtils.getQFaceGifUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey);
    String str = EmosmUtils.getQFaceGifPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    File localFile = new File(str);
    if (!localFile.exists())
    {
      localObject = new DownloadInfo((String)localObject, localFile, 12);
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      if (((DownloadInfo)localObject).jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = 0;
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject).jdField_b_of_type_Int);
      a((DownloadInfo)localObject, 12);
      return;
      this.jdField_b_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "handleQFaceGif| qFace gif exist. path=" + str);
  }
  
  private void f()
  {
    Object localObject = EmosmUtils.getEmoticonSoundUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    String str = EmosmUtils.getEmoticonSoundPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    File localFile = new File(str);
    if (!localFile.exists())
    {
      localObject = new DownloadInfo((String)localObject, localFile, 9);
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      if (((DownloadInfo)localObject).jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = 0;
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject).jdField_b_of_type_Int);
      a((DownloadInfo)localObject, 9);
      return;
      this.jdField_b_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "handleSound| imgSound exist. path=" + str);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Emoticon a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  }
  
  public EmoticonController.ProgressHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_b_of_type_Int == 0) && ((this.jdField_a_of_type_Int & 0x2) == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doTask| Emoticon download emo imgPreview.pid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " type=" + this.jdField_a_of_type_Int + " time:" + System.currentTimeMillis());
      }
      b();
    }
    if ((this.jdField_b_of_type_Int == 0) && ((this.jdField_a_of_type_Int & 0x4) == 4))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) {
        break label425;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doTask| Emoticon download qFace gif.pid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " type=" + this.jdField_a_of_type_Int + " time:" + System.currentTimeMillis());
      }
      e();
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Int == 0) && ((this.jdField_a_of_type_Int & 0x1) == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "doTask| Emoticon download emo AIO preview static.pid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " type=" + this.jdField_a_of_type_Int + " time:" + System.currentTimeMillis());
        }
        d();
      }
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && ((this.jdField_a_of_type_Int & 0x8) == 8))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "doTask| Emoticon download emo sound.pid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " type=" + this.jdField_a_of_type_Int + " time:" + System.currentTimeMillis());
        }
        f();
      }
      return;
      label425:
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doTask| Emoticon download emo img AIO Encrypt.pid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eid=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " type=" + this.jdField_a_of_type_Int + " time:" + System.currentTimeMillis());
      }
      c();
    }
  }
  
  public void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if ((paramProgressHandler != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId))) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler = paramProgressHandler;
    }
    while ((paramProgressHandler == null) || (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId == null) || (!paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler = paramProgressHandler;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpStart epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " task=" + this.jdField_a_of_type_Int + " code:" + paramInt + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpProgress epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " task=" + this.jdField_a_of_type_Int + " length:" + paramLong1 + " loaded:" + paramLong2 + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpEnd epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " eId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + " task=" + this.jdField_a_of_type_Int + " result:" + paramInt + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EmoticonTask)) {}
    Emoticon localEmoticon;
    do
    {
      return false;
      paramObject = (EmoticonTask)paramObject;
      localEmoticon = paramObject.a();
    } while ((localEmoticon == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId.equals(localEmoticon.epId)) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId != localEmoticon.eId) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonTask
 * JD-Core Version:    0.7.0.1
 */