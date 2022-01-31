package com.tencent.mobileqq.transfile;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.AioPicOperator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class ChatImageDownloader
  extends AbstractImageDownloader
  implements ProtocolDownloaderConstants
{
  static final String e = "ChatImageDownloader";
  
  public ChatImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public ChatImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private ChatImageDownloader.DownloadData a(DownloadParams paramDownloadParams)
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    ChatImageDownloader.DownloadData localDownloadData = new ChatImageDownloader.DownloadData(this);
    localDownloadData.jdField_a_of_type_JavaNetURL = paramDownloadParams.url;
    Logger.a("PIC_TAG", "getDownloadData", "url:" + localDownloadData.jdField_a_of_type_JavaNetURL);
    localDownloadData.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    localDownloadData.jdField_a_of_type_Long = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof PicUiInterface)))
    {
      Object localObject = (PicUiInterface)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        localDownloadData.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localDownloadData.d = PicPreDownloadUtils.a();
        localDownloadData.jdField_c_of_type_Int = PicPreDownloadUtils.a(localDownloadData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDownloadData.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localDownloadData.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = ((PicUiInterface)localObject).getPicDownloadInfo();
      a(localDownloadData, "getDownloadData", "uuid:" + localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g + ",md5：" + localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString);
      localDownloadData.jdField_a_of_type_JavaLangString = a(localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int == 1) {
        bool = true;
      }
      localDownloadData.jdField_a_of_type_Int = URLDrawableHelper.a(paramDownloadParams, bool);
      if (((PicUiInterface)localObject).isSendFromLocal())
      {
        localDownloadData.jdField_a_of_type_Boolean = true;
        localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUiInterface)localObject).getPicUploadInfo();
        localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Boolean = true;
        if (localDownloadData.jdField_a_of_type_Int != 65537) {
          break label438;
        }
        if (localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int != TranDbRecord.PicDbRecord.g) {
          break label427;
        }
        localObject = ((PicFowardDbRecordData)localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject).jdField_c_of_type_JavaLangString;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = a(localDownloadData, (String)localObject);
        }
      }
      label427:
      label438:
      for (localDownloadData.jdField_b_of_type_JavaLangString = paramDownloadParams;; localDownloadData.jdField_b_of_type_JavaLangString = localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g)
      {
        a(localDownloadData, "getDownloadData", "path:" + localDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g + ",sendPath：" + localDownloadData.jdField_b_of_type_JavaLangString);
        return localDownloadData;
        paramDownloadParams = a(localDownloadData, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      localDownloadData.jdField_b_of_type_JavaLangString = ((String)paramDownloadParams.tag);
      return localDownloadData;
    }
    if (paramDownloadParams.tag == null) {
      a(localDownloadData, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      a(localDownloadData, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
    }
  }
  
  static String a(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default: 
      str = "C2C";
    case 6000: 
      return str;
    case 1: 
      return "Troup";
    case 3000: 
      return "Disscussion";
    }
    return "C2C";
  }
  
  private String a(ChatImageDownloader.DownloadData paramDownloadData, String paramString)
  {
    String str2;
    if (PicContants.f)
    {
      String str1;
      if (paramString != null)
      {
        str1 = paramString;
        if (!"".equals(paramString)) {}
      }
      else
      {
        str1 = ImageUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
      }
      str2 = str1;
      if (!FileUtils.a(str1))
      {
        str2 = str1;
        if (FileUtils.a(paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g))
        {
          ImageUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g, str1);
          str2 = str1;
        }
      }
    }
    do
    {
      do
      {
        return str2;
        str2 = paramString;
      } while (FileUtils.a(paramString));
      str2 = paramString;
    } while (!FileUtils.a(paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g));
    paramString = new CompressInfo();
    paramString.jdField_c_of_type_JavaLangString = paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
    paramString.jdField_a_of_type_JavaLangString = paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString;
    CompressOperator.b(paramString);
    return paramString.e;
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = a(paramMessageRecord.istroop);
        Object localObject = new TranDbRecord.PicDbRecord();
        ((TranDbRecord.PicDbRecord)localObject).a(paramMessageRecord.msg);
        if (((TranDbRecord.PicDbRecord)localObject).jdField_b_of_type_Int == 1)
        {
          String str2 = ((TranDbRecord.PicDbRecord)localObject).jdField_c_of_type_JavaLangString;
          localObject = ((TranDbRecord.PicDbRecord)localObject).d;
          if ((ActionMsgUtil.a(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = URLDrawableHelper.a((MessageForPic)paramMessageRecord, 65537, null);
            if (a(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              a(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = URLDrawableHelper.a((MessageForPic)paramMessageRecord, 65537, null);
          if (a(localURL.toString()) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatImageDownloader", 2, "reportClientExist bigURL:" + localURL);
            }
            a(paramMessageRecord, str1, str2, (String)localObject, false);
          }
        }
        return;
      }
      catch (Exception paramMessageRecord)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("reportClientExist", 2, "error", paramMessageRecord);
        return;
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool1 = paramString1.equals("C2C");
    boolean bool2 = paramString1.equals("Troup");
    boolean bool3 = paramString1.equals("Disscussion");
    if (bool1) {
      if (paramBoolean)
      {
        paramString1 = "dim.buddy_thumbpic_down";
        if (!paramBoolean) {
          break label105;
        }
        localObject1 = "actC2CPicSmallDownV1";
      }
    }
    for (;;)
    {
      paramString1 = new AbstractImageDownloader.ReportData(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
      paramString1.jdField_a_of_type_Boolean = true;
      paramString1.jdField_a_of_type_Long = paramMessageRecord.time;
      a(paramString1, true, (int)0L, 0, "", null, null, null);
      return;
      paramString1 = "dim.buddy_pic_down";
      break;
      label105:
      localObject1 = "actC2CPicDownloadV1";
      continue;
      if (bool2)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.group_thumbpic_down";
          label127:
          if (!paramBoolean) {
            break label147;
          }
        }
        label147:
        for (localObject1 = "actGroupPicSmallDownV1";; localObject1 = "actGroupPicDownloadV1")
        {
          break;
          paramString1 = "dim.group_pic_down";
          break label127;
        }
      }
      if (bool3)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.discuss_thumbpic_down";
          label169:
          if (!paramBoolean) {
            break label189;
          }
        }
        label189:
        for (localObject1 = "actDiscussPicSmallDown";; localObject1 = "actDiscussPicDown")
        {
          break;
          paramString1 = "dim.discuss_pic_down";
          break label169;
        }
      }
      Object localObject2 = null;
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof ChatImageDownloader.DownloadData)) {
      if (QLog.isColorLevel())
      {
        paramObject = (ChatImageDownloader.DownloadData)paramObject;
        if (paramObject.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null) {
          break label58;
        }
        i = RichMediaUtil.a(paramObject.jdField_a_of_type_Int);
        RichMediaUtil.c(paramObject.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Long), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
        {
          i = RichMediaUtil.a(paramObject.jdField_a_of_type_Int);
          RichMediaUtil.c(paramObject.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
      return;
    }
    QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
  }
  
  TransferResult a(ChatImageDownloader.DownloadData paramDownloadData)
  {
    if (paramDownloadData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    try
    {
      paramDownloadData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramDownloadData.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_JavaLangString));
      label28:
      if (paramDownloadData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        a(paramDownloadData, "stepDownload", "params.app == null ,selfuin:" + paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_JavaLangString);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_JavaLangString, false, false);
      }
      AioPicOperator localAioPicOperator = new AioPicOperator(paramDownloadData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localAioPicOperator.jdField_a_of_type_ComTencentMobileqqPicPicReq = new PicReq();
      localAioPicOperator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramDownloadData.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      localAioPicOperator.jdField_b_of_type_JavaLangString = "PIC_TAG";
      localAioPicOperator.jdField_a_of_type_JavaLangString = paramDownloadData.jdField_c_of_type_JavaLangString;
      paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = paramDownloadData.jdField_a_of_type_JavaNetURL.getProtocol();
      Logger.a("PIC_TAG", paramDownloadData.jdField_c_of_type_JavaLangString, "stepDownload", "url:" + paramDownloadData.jdField_a_of_type_JavaNetURL + ",info:" + paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      return localAioPicOperator.a(paramDownloadData.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo, paramDownloadData.jdField_a_of_type_ComTencentImageURLDrawableHandler, paramDownloadData.jdField_a_of_type_JavaNetURL.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = SystemClock.uptimeMillis();
    if ((paramDownloadParams.urlStr != null) && (paramDownloadParams.urlStr.startsWith("chatimg"))) {}
    for (int i = 1;; i = 0)
    {
      paramDownloadParams = a(paramDownloadParams);
      paramDownloadParams.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
      paramDownloadParams.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramDownloadParams.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null) || (paramDownloadParams.jdField_b_of_type_JavaLangString == null)) {
        break;
      }
      paramOutputStream = new File(paramDownloadParams.jdField_b_of_type_JavaLangString);
      if (!paramOutputStream.exists()) {
        break;
      }
      a(paramDownloadParams, "result", "success file(send) exist, copy file from:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      a(paramDownloadParams.jdField_a_of_type_JavaIoOutputStream, paramOutputStream, paramDownloadParams.jdField_a_of_type_ComTencentImageURLDrawableHandler);
      return null;
    }
    paramURLDrawableHandler.publishProgress(0);
    if (paramDownloadParams.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
    {
      a(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      a(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.jdField_b_of_type_JavaLangString + ",uniseq:" + paramDownloadParams.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((Utils.e()) && (Utils.b() < 20971520L)) {
      throw new IOException("SD card free space is " + Utils.b());
    }
    TransferResult localTransferResult = a(paramDownloadParams);
    int j;
    if (localTransferResult.d == 0)
    {
      j = 1;
      if (j == 0) {
        break label382;
      }
      paramOutputStream = "successed";
      label343:
      a(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label470;
      }
      if (localTransferResult.jdField_a_of_type_Long != 9037L) {
        break label410;
      }
      paramURLDrawableHandler.doCancel();
    }
    label382:
    while (i == 0)
    {
      return null;
      j = 0;
      break;
      paramOutputStream = "failed " + localTransferResult.jdField_a_of_type_JavaLangString;
      break label343;
      if ((localTransferResult.jdField_a_of_type_Long == -9527L) && ("H_404_-124".equals(localTransferResult.jdField_a_of_type_JavaLangString)))
      {
        a(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localTransferResult.jdField_a_of_type_Long, 0L, localTransferResult.jdField_a_of_type_JavaLangString, false, false);
    }
    label410:
    label470:
    if (paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (paramOutputStream = paramDownloadParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();; paramOutputStream = null)
    {
      PicReporter.a(paramOutputStream, paramDownloadParams.jdField_c_of_type_Int, paramDownloadParams.d, SystemClock.uptimeMillis() - l);
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader
 * JD-Core Version:    0.7.0.1
 */