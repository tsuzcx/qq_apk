package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class EMagicTask
  implements TaskInterface, HttpDownloadUtil.HttpDownloadListener
{
  private static int jdField_a_of_type_Int = 0;
  private static int b = 1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  private EmoticonController.ProgressHandler jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  private int c;
  
  public EMagicTask(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler != null) && (paramDownloadInfo != null))
    {
      paramDownloadInfo.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.a("param_step", paramInt);
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.c = 0;
    Object localObject1 = EmosmUtils.getCoverUrl(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    Object localObject2 = new File(EmosmUtils.getCoverPath(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
    if (!((File)localObject2).exists())
    {
      localObject1 = new DownloadInfo((String)localObject1, (File)localObject2, 2);
      HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
      this.c = ((DownloadInfo)localObject1).b;
      if (this.c != 0)
      {
        this.c = EmosmUtils.checkResultCode(this.c);
        a((DownloadInfo)localObject1, 2);
      }
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, b))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = 90;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
      this.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| zip folder exist, it's not necessary to download.");
      }
      if (!a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, jdField_a_of_type_Int)) {
        break label482;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = 100;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
      this.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| zip folder exist, it's not necessary to download.");
      }
    }
    Object localObject3;
    label468:
    label482:
    do
    {
      for (;;)
      {
        for (;;)
        {
          return;
          localObject3 = EmosmUtils.getMagicFaceMaterialPackageUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, 1);
          localObject2 = EmosmUtils.getMagicFaceZipPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          localObject1 = new File((String)localObject2);
          localObject3 = new DownloadInfo((String)localObject3, (File)localObject1, 10);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| startdownload eMagicVedio");
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 0;
          HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject3, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
          if (((DownloadInfo)localObject3).b != 0) {
            break label468;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| magicl face.zip download success.try to unzip...");
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 1;
            FileUtils.a((String)localObject2, EmosmUtils.getEmoticonPackageFolder(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
            ((File)localObject1).delete();
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d == 2)
            {
              this.c = 0;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask|magicl face.zip unzip success.");
            }
          }
          catch (IOException localIOException1)
          {
            for (;;)
            {
              localIOException1.printStackTrace();
              ((DownloadInfo)localObject3).e = localIOException1.toString();
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 3;
            }
            this.c = 17;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask|qq_error| magicl face unzip fail.EXCEPTION:" + ((DownloadInfo)localObject3).e + " time:" + System.currentTimeMillis());
          return;
          this.c = EmosmUtils.checkResultCode(((DownloadInfo)localObject3).b);
          break;
          localObject3 = EmosmUtils.getMagicFaceMaterialPackageUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, 0);
          String str = EmosmUtils.getMagicFaceZipPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          localObject1 = new File(str);
          localObject3 = new DownloadInfo((String)localObject3, (File)localObject1, 10);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| startdownload eMagicSound");
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 0;
          HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject3, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
          if (((DownloadInfo)localObject3).b != 0) {
            break label724;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask| magicl face sound.zip download success.try to unzip...");
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 1;
            FileUtils.a(str, EmosmUtils.getEmoticonPackageFolder(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
            ((File)localObject1).delete();
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d == 2)
            {
              this.c = 0;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask|magicl face sound.zip unzip success.");
            }
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              localIOException2.printStackTrace();
              ((DownloadInfo)localObject3).e = localIOException2.toString();
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 3;
            }
            this.c = 17;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "EMagiclTask|qq_error| magicl face unzip fail.EXCEPTION:" + ((DownloadInfo)localObject3).e + " time:" + System.currentTimeMillis());
    return;
    label724:
    this.c = EmosmUtils.checkResultCode(((DownloadInfo)localObject3).b);
  }
  
  public void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if ((paramProgressHandler != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler = paramProgressHandler;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpStart qFace epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " code:" + paramInt + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpProgress qFace epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " length:" + paramLong1 + " loaded:" + paramLong2 + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3))
    {
      if (paramString.contains("android"))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = ((int)paramLong1);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = ((int)(paramLong2 * 0.9D));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = ((int)paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = ((int)(paramLong2 * 0.1D + paramLong1 * 0.9D));
  }
  
  public boolean a(String paramString, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (paramInt == b)
    {
      localObject1 = "small";
      if (DeviceInfoUtil.f() >= 480L) {
        localObject1 = "big";
      }
      localObject2 = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + "video.ini");
      if (!((File)localObject2).exists()) {
        return false;
      }
      localObject2 = FileUtils.a((File)localObject2).split("&");
      i = localObject2.length;
      paramInt = 0;
      while (paramInt < i)
      {
        String str = localObject2[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + str).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == jdField_a_of_type_Int)
    {
      localObject1 = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini");
      if (!((File)localObject1).exists()) {
        return false;
      }
      localObject1 = FileUtils.a((File)localObject1).split("&");
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = localObject1[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject2).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpEnd qFace epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " result:" + paramInt + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EMagicTask
 * JD-Core Version:    0.7.0.1
 */