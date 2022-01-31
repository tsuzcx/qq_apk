package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EPCoverTask
  implements TaskInterface
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  private EmoticonController.ProgressHandler jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler;
  
  public EPCoverTask(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.kinId;
      j = 13;
    }
    for (int i = 14;; i = 4)
    {
      Object localObject2 = EmosmUtils.getCoverUrl(j, (String)localObject1);
      File localFile = new File(EmosmUtils.getCoverPath(3, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
      if (!localFile.exists())
      {
        localObject2 = new DownloadInfo((String)localObject2, localFile, 3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "EPCoverTask| startdownload epcover");
        }
        HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject2, null, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
        int k = ((DownloadInfo)localObject2).b;
        j = k;
        if (k == 0) {
          break label163;
        }
        this.jdField_a_of_type_Int = EmosmUtils.checkResultCode(k);
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 3, k, this.jdField_a_of_type_Int);
        a((DownloadInfo)localObject2, 3);
      }
      label163:
      do
      {
        return;
        j = 0;
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 3, j, 0);
        localObject2 = EmosmUtils.getCoverUrl(i, (String)localObject1);
        localFile = new File(EmosmUtils.getCoverPath(4, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EPCoverTask| startdownload epcover gray");
          }
          localObject2 = new DownloadInfo((String)localObject2, localFile, 4);
          HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject2, null, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
          j = ((DownloadInfo)localObject2).b;
          i = j;
          if (j != 0)
          {
            this.jdField_a_of_type_Int = EmosmUtils.checkResultCode(j);
            EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 4, j, this.jdField_a_of_type_Int);
            a((DownloadInfo)localObject2, 4);
          }
        }
        else
        {
          i = 0;
        }
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 4, i, 0);
      } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 0);
      localObject1 = EmosmUtils.getCoverUrl(2, (String)localObject1);
      localObject2 = new File(EmosmUtils.getCoverPath(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId));
      if (!((File)localObject2).exists())
      {
        localObject1 = new DownloadInfo((String)localObject1, (File)localObject2, 2);
        HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler);
        j = ((DownloadInfo)localObject1).b;
        i = j;
        if (j != 0)
        {
          this.jdField_a_of_type_Int = EmosmUtils.checkResultCode(j);
          EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 2, j, this.jdField_a_of_type_Int);
          a((DownloadInfo)localObject1, 2);
        }
      }
      else
      {
        i = 0;
      }
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 2, i, 0);
      this.jdField_a_of_type_Int = 0;
      return;
      j = 3;
    }
  }
  
  public void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if ((paramProgressHandler != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler = paramProgressHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPCoverTask
 * JD-Core Version:    0.7.0.1
 */