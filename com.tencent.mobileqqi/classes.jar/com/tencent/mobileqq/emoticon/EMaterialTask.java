package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class EMaterialTask
  implements TaskInterface, HttpDownloadUtil.HttpDownloadListener
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  private EmoticonController.ProgressHandler jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  
  public EMaterialTask(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
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
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    Object localObject1 = EmosmUtils.getQFaceMaterialFolderPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
    Object localObject2;
    if (FileUtil.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = 100;
      ((EmoticonController.ProgressHandler)localObject2).jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
      this.jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EMaterialTask| zip folder exist, it's not necessary to download.:" + (String)localObject1);
      }
    }
    Object localObject3;
    do
    {
      for (;;)
      {
        return;
        localObject3 = EmosmUtils.getQFaceMaterialUrl(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        localObject2 = EmosmUtils.getQFaceMaterialZipPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        localObject1 = new File((String)localObject2);
        localObject3 = new DownloadInfo((String)localObject3, (File)localObject1, 10);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "EMaterialTask| startdownload eMaterial");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 0;
        HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject3, this, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
        if (((DownloadInfo)localObject3).b != 0) {
          break label327;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "emoDownload| QFace material.zip download success.try to unzip...");
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 1;
          FileUtils.a((String)localObject2, EmosmUtils.getQFaceMaterialFolderPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, false));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 2;
          ((File)localObject1).delete();
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d == 2)
          {
            this.jdField_a_of_type_Int = 0;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.emoji.EmoDown", 2, "emoDownload| QFace material.zip unzip success.");
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
            ((DownloadInfo)localObject3).e = localIOException.toString();
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.d = 3;
          }
          this.jdField_a_of_type_Int = 11025;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "emoDownload|qq_error| QFace unzip fail.EXCEPTION:" + ((DownloadInfo)localObject3).e + " time:" + System.currentTimeMillis());
    return;
    label327:
    this.jdField_a_of_type_Int = EmosmUtils.checkResultCode(((DownloadInfo)localObject3).b);
    a((DownloadInfo)localObject3, 10);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Int = ((int)paramLong1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b = ((int)paramLong2);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "onHttpEnd qFace epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " result:" + paramInt + " url[" + paramString + "] time=" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EMaterialTask
 * JD-Core Version:    0.7.0.1
 */