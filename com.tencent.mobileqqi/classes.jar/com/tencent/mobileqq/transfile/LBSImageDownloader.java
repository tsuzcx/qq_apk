package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class LBSImageDownloader
  extends AbstractImageDownloader
  implements ProtocolDownloader, ProtocolDownloaderConstants
{
  private static final String e = "lbs";
  
  public LBSImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("lbs", paramBaseApplicationImpl);
  }
  
  private String a(MessageForPic paramMessageForPic, String paramString)
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
        str1 = ImageUtil.a(this.a.getApplicationContext(), paramMessageForPic.path);
      }
      str2 = str1;
      if (!FileUtils.a(str1))
      {
        str2 = str1;
        if (FileUtils.a(paramMessageForPic.path))
        {
          ImageUtil.a(this.a.getApplicationContext(), paramMessageForPic.path, str1);
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
    } while (!FileUtils.a(paramMessageForPic.path));
    paramString = new CompressInfo();
    paramString.c = paramMessageForPic.path;
    CompressOperator.b(paramString);
    return paramString.e;
  }
  
  private void a(DownloadParams paramDownloadParams, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    Object localObject9 = paramDownloadParams.url;
    localObject1 = paramDownloadParams.headers;
    localObject1 = paramDownloadParams.cookies;
    String str2 = ((URL)localObject9).toString();
    if (QLog.isColorLevel()) {
      QLog.d("lbs", 2, "LBS Image download start, url:" + str2);
    }
    Object localObject8 = null;
    localObject4 = AbstractImageDownloader.Step.INIT;
    String str3 = ((URL)localObject9).getFile();
    Object localObject5;
    Object localObject3;
    String str1;
    Object localObject7;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localObject5 = (MessageForPic)paramDownloadParams.tag;
      localObject1 = ((MessageForPic)localObject5).selfuin;
      localObject3 = ((MessageForPic)localObject5).frienduin;
      l1 = ((MessageForPic)localObject5).time;
      str1 = String.valueOf(((MessageForPic)localObject5).uniseq);
      localObject2 = ((MessageForPic)localObject5).uuid;
      i = URLDrawableHelper.a(paramDownloadParams.url.getProtocol(), false);
      if (((MessageForPic)localObject5).isSendFromLocal()) {
        if (i == 65537) {
          if ((((MessageForPic)localObject5).isShareAppActionMsg) || (((MessageForPic)localObject5).msgtype == -3001))
          {
            paramDownloadParams = ((MessageForPic)localObject5).path;
            localObject5 = localObject3;
            localObject7 = localObject2;
            localObject3 = paramDownloadParams;
            localObject2 = localObject1;
            paramDownloadParams = (DownloadParams)localObject5;
            localObject1 = localObject7;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("lbs", 2, "[lbs_file][down][start]  ,localPath:" + (String)localObject3 + ",serverPath:" + (String)localObject1 + ",uniseq:" + str1 + ",msgTime:" + l1);
      }
      localObject7 = (QQAppInterface)this.a.getAppRuntime((String)localObject2);
      if (localObject3 != null) {}
      try
      {
        paramDownloadParams = new File((String)localObject3);
        if (paramDownloadParams.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("lbs", 2, "file exist, copy file from:" + (String)localObject3 + ", url:" + str2);
          }
          ChatImageDownloader.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        }
        return;
      }
      catch (Exception paramDownloadParams)
      {
        for (;;)
        {
          paramOutputStream = (OutputStream)localObject4;
          paramURLDrawableHandler = null;
          localObject1 = null;
          localObject2 = null;
          i = 1;
          continue;
          if ((paramDownloadParams != null) && (localObject2 != null)) {
            if (l1 == -1L)
            {
              continue;
              i = 1;
              continue;
              continue;
              continue;
              i += 1;
            }
          }
        }
      }
      if (((MessageForPic)localObject5).picExtraFlag == TranDbRecord.PicDbRecord.g)
      {
        paramDownloadParams = ((PicFowardDbRecordData)((MessageForPic)localObject5).picExtraObject).c;
        if ((paramDownloadParams != null) && (!"".equals(paramDownloadParams))) {
          break label2056;
        }
        paramDownloadParams = a((MessageForPic)localObject5, paramDownloadParams);
        break;
      }
      paramDownloadParams = a((MessageForPic)localObject5, null);
      break;
      localObject5 = ((MessageForPic)localObject5).path;
      paramDownloadParams = (DownloadParams)localObject3;
      localObject3 = localObject5;
      localObject5 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
      continue;
      if (str3.startsWith("http/"))
      {
        paramDownloadParams = str3.substring(5);
        localObject2 = localObject4;
        localObject1 = null;
        i = 1;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("lbs", 2, "CONVERT_URL success,@time:" + ((FileMsg.StepBaseInfo)localObject1).jdField_b_of_type_Long + ",uniseq=" + str1);
            }
            localObject4 = new FileMsg.StepTransInfo();
          }
          catch (Exception localException2)
          {
            int j;
            long l2;
            paramOutputStream = (OutputStream)localObject2;
            paramURLDrawableHandler = paramDownloadParams;
            localObject4 = null;
            localObject2 = localObject1;
            paramDownloadParams = localException2;
            localObject1 = localObject4;
            continue;
          }
          try
          {
            localObject5 = AbstractImageDownloader.Step.DOWNLOAD_FILE;
          }
          catch (Exception localException3)
          {
            paramOutputStream = (OutputStream)localObject2;
            paramURLDrawableHandler = paramDownloadParams;
            localObject2 = localObject1;
            localObject1 = localObject4;
            paramDownloadParams = localException3;
            continue;
          }
          try
          {
            ((FileMsg.StepTransInfo)localObject4).jdField_a_of_type_Long = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.i("lbs", 2, "DOWNLOAD_FILE start,@time:" + ((FileMsg.StepTransInfo)localObject4).jdField_a_of_type_Long + ",uniseq=" + str1);
            }
            paramURLDrawableHandler = new AbstractImageDownloader.ImageDownloaderProcesser(paramOutputStream, paramURLDrawableHandler, (QQAppInterface)localObject7);
            paramURLDrawableHandler.jdField_a_of_type_JavaLangString = "lbs";
            localObject2 = new AbstractImageDownloader.DownloaderHttpMsg(paramDownloadParams, null, paramURLDrawableHandler, true);
            paramOutputStream = "gprs";
            if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
              paramOutputStream = "wifi";
            }
            ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).a("Net-type", paramOutputStream);
            ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).b(5);
            ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).a(true);
            ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).a("Accept-Encoding", "identity");
            j = 0;
            if (i > 3) {
              continue;
            }
            try
            {
              ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).a("Range", "bytes=" + j + "-");
              paramURLDrawableHandler.jdField_a_of_type_Boolean = false;
              ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).jdField_a_of_type_Boolean = false;
              ((QQAppInterface)localObject7).a().b((HttpMsg)localObject2);
              j = paramURLDrawableHandler.jdField_a_of_type_Int;
              if (!paramURLDrawableHandler.jdField_a_of_type_Boolean) {
                continue;
              }
              ((FileMsg.StepTransInfo)localObject4).jdField_e_of_type_Int = ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).g;
              throw new FileDownloadFailedException(9301, 0L, "write to Cache failed", false);
            }
            catch (Exception localException5)
            {
              paramOutputStream = (OutputStream)localObject5;
              localObject2 = localObject1;
              localObject1 = localObject4;
              paramURLDrawableHandler = paramDownloadParams;
              paramDownloadParams = localException5;
            }
          }
          catch (Exception localException6)
          {
            paramOutputStream = localException3;
            localObject2 = localObject1;
            paramURLDrawableHandler = paramDownloadParams;
            localObject1 = localObject4;
            paramDownloadParams = localException6;
            continue;
            i = 1;
            localObject2 = paramDownloadParams;
            paramDownloadParams = localObject8;
          }
          j = 9001;
          l2 = 0L;
          if ((paramDownloadParams instanceof FileDownloadFailedException))
          {
            localObject4 = (FileDownloadFailedException)paramDownloadParams;
            j = ((FileDownloadFailedException)localObject4).errorCode;
            l2 = ((FileDownloadFailedException)localObject4).errorDetailCode;
            paramBoolean = ((FileDownloadFailedException)localObject4).needReport;
          }
          if (paramOutputStream == AbstractImageDownloader.Step.CONVERT_URL)
          {
            ((FileMsg.StepBaseInfo)localObject2).jdField_a_of_type_Boolean = false;
            ((FileMsg.StepBaseInfo)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
            ((FileMsg.StepBaseInfo)localObject2).jdField_b_of_type_Int = i;
            ((FileMsg.StepBaseInfo)localObject2).jdField_a_of_type_Int = j;
            ((FileMsg.StepBaseInfo)localObject2).c = l2;
            ((FileMsg.StepBaseInfo)localObject2).jdField_a_of_type_JavaLangString = paramDownloadParams.getMessage();
            paramOutputStream = new StringBuilder();
            paramOutputStream.append("msg.id=").append(str1).append(",actualUrl=").append(paramURLDrawableHandler).append(",errorCode=").append(j).append(",detailErrCode=").append(l2).append(",msg=").append(paramDownloadParams.getMessage());
            if (QLog.isColorLevel()) {
              QLog.e("lbs", 2, "[lbs_file][down][result] failed  ,localPath:" + (String)localObject3 + ",serverPath:" + str2 + ",msgTime:" + l1 + ",errStr:" + paramOutputStream.toString(), paramDownloadParams);
            }
            throw paramDownloadParams;
            if (str3.startsWith("file/"))
            {
              paramDownloadParams = new File(str3.substring(4));
              if (!paramDownloadParams.exists()) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("lbs", 2, "file exist, copy to catch, url:" + str2);
              }
              ChatImageDownloader.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
              paramDownloadParams.delete();
              return;
            }
            localObject5 = ((URL)localObject9).getPath();
            if (!QLog.isColorLevel()) {
              break label2126;
            }
            QLog.d("lbs", 2, "<--downloadLBSImage serverPath=" + (String)localObject5);
            break label2126;
            paramOutputStream = new StringBuffer("wrong argument(header) for LBS. ");
            if (paramDownloadParams == null) {
              paramOutputStream.append(" peerUin is not set. ");
            }
            if (localObject2 == null) {
              paramOutputStream.append(" myUin is not set. ");
            }
            if (l1 == -1L) {
              paramOutputStream.append(" msgTime is not set. ");
            }
            throw new FileDownloadFailedException(9302, 0L, paramOutputStream.toString(), false);
            if ((localException5 == null) || (!localException5.isLogin()))
            {
              paramDownloadParams = new FileDownloadFailedException(0, 0L, "Account is logout", false);
              paramDownloadParams.needReport = false;
              throw paramDownloadParams;
            }
            if (!NetworkUtil.e(BaseApplication.getContext()))
            {
              paramDownloadParams = new FileDownloadFailedException(0, 0L, "No alive Network.", false);
              paramDownloadParams.needReport = false;
              throw paramDownloadParams;
            }
            localObject1 = new FileMsg.StepBaseInfo();
          }
          try
          {
            paramDownloadParams = AbstractImageDownloader.Step.CONVERT_URL;
            localObject4 = paramDownloadParams;
            ((FileMsg.StepBaseInfo)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
            localObject4 = paramDownloadParams;
            if (QLog.isColorLevel())
            {
              localObject4 = paramDownloadParams;
              QLog.i("lbs", 2, "CONVERT_URL start @time:" + ((FileMsg.StepBaseInfo)localObject1).jdField_a_of_type_Long + ",uniseq=" + str1);
              break label2147;
              if (i <= 3)
              {
                localObject4 = paramDownloadParams;
                localObject9 = new AbstractImageDownloader.MessageObserverImpl();
                if (paramBoolean)
                {
                  j = 1;
                  byte b = (byte)j;
                  localObject4 = paramDownloadParams;
                  localException5.a().a((String)localObject2, (String)localObject5, b, (BusinessObserver)localObject9);
                  localObject4 = paramDownloadParams;
                }
                try
                {
                  if (!((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_a_of_type_Boolean) {
                    localObject9.wait(60000L);
                  }
                  localObject4 = paramDownloadParams;
                  if (((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Int == 0) {
                    continue;
                  }
                  localObject4 = paramDownloadParams;
                  if (((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Int != 1002)
                  {
                    localObject4 = paramDownloadParams;
                    j = ((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Int;
                    if (j != 1013) {
                      continue;
                    }
                  }
                  i += 1;
                  continue;
                }
                finally
                {
                  localObject4 = paramDownloadParams;
                }
                j = 0;
                continue;
                localObject4 = paramDownloadParams;
                ((FileMsg.StepBaseInfo)localObject1).jdField_b_of_type_Int = i;
                localObject4 = paramDownloadParams;
                i = ((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_a_of_type_Int;
              }
            }
          }
          catch (Exception paramDownloadParams)
          {
            Object localObject6;
            paramOutputStream = (OutputStream)localObject4;
            i = 1;
            paramURLDrawableHandler = null;
            localObject4 = null;
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          try
          {
            if (!((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_a_of_type_Boolean) {
              throw new FileDownloadFailedException(9006, 0L, "onGetTempChatPic Time out.", false);
            }
            if (!((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Boolean) {
              throw new FileDownloadFailedException(((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Int, ((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_b_of_type_Long, "onGetTempChatPic Time out.", false);
            }
            if (((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_a_of_type_JavaLangString == null) {
              throw new FileDownloadFailedException(9007, 0L, "onDownloadPicReqReturn downUrl is null", false);
            }
            localObject2 = ((AbstractImageDownloader.MessageObserverImpl)localObject9).jdField_a_of_type_JavaLangString;
            try
            {
              ((FileMsg.StepBaseInfo)localObject1).jdField_b_of_type_Long = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("lbs", 2, "<--downloadLBSImage actualUrl=" + (String)localObject2);
              }
              ((FileMsg.StepBaseInfo)localObject1).jdField_a_of_type_Boolean = true;
              localObject4 = localObject2;
              localObject2 = paramDownloadParams;
              paramDownloadParams = (DownloadParams)localObject4;
            }
            catch (Exception localException1)
            {
              paramOutputStream = paramDownloadParams;
              localObject4 = null;
              paramURLDrawableHandler = (URLDrawableHandler)localObject2;
              localObject2 = localObject1;
              paramDownloadParams = localException1;
              localObject1 = localObject4;
            }
            if ((paramURLDrawableHandler.jdField_a_of_type_Long > 0L) && (j >= paramURLDrawableHandler.jdField_a_of_type_Long)) {
              ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).jdField_a_of_type_Boolean = true;
            }
            if (!((AbstractImageDownloader.DownloaderHttpMsg)localObject2).jdField_a_of_type_Boolean) {
              break label2199;
            }
            if (QLog.isColorLevel()) {
              QLog.d("lbs", 2, "[lbs_file][down][result] success  ,localPath:" + (String)localObject3 + ",serverPath:" + str2 + ",msgTime:" + l1 + ",uniseq:" + str1);
            }
            if (!((AbstractImageDownloader.DownloaderHttpMsg)localObject2).jdField_a_of_type_Boolean)
            {
              ((FileMsg.StepTransInfo)localObject4).jdField_e_of_type_Int = ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).g;
              ((FileMsg.StepTransInfo)localObject4).jdField_a_of_type_Int = ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).h;
              ((FileMsg.StepTransInfo)localObject4).jdField_a_of_type_JavaLangString = ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).ae;
              throw new FileDownloadFailedException(((AbstractImageDownloader.DownloaderHttpMsg)localObject2).h, ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).c, ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).ae, false);
            }
            ((FileMsg.StepTransInfo)localObject4).jdField_a_of_type_Boolean = ((AbstractImageDownloader.DownloaderHttpMsg)localObject2).jdField_a_of_type_Boolean;
            ((FileMsg.StepTransInfo)localObject4).jdField_b_of_type_Long = System.currentTimeMillis();
            ((FileMsg.StepTransInfo)localObject4).jdField_e_of_type_Long = paramURLDrawableHandler.jdField_a_of_type_Int;
            ((FileMsg.StepTransInfo)localObject4).f = paramURLDrawableHandler.jdField_a_of_type_Long;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("lbs", 2, "DOWNLOAD_FILE success,@time:" + ((FileMsg.StepTransInfo)localObject4).jdField_b_of_type_Long + ",uniseq=" + str1);
            return;
          }
          catch (Exception localException4)
          {
            paramOutputStream = paramDownloadParams;
            paramURLDrawableHandler = null;
            localObject4 = null;
            localObject2 = localObject1;
            paramDownloadParams = localException4;
            localObject1 = localObject4;
          }
        }
        if (paramOutputStream == AbstractImageDownloader.Step.DOWNLOAD_FILE)
        {
          ((FileMsg.StepTransInfo)localObject1).jdField_a_of_type_Boolean = false;
          ((FileMsg.StepTransInfo)localObject1).jdField_b_of_type_Long = System.currentTimeMillis();
          ((FileMsg.StepTransInfo)localObject1).jdField_b_of_type_Int = i;
          ((FileMsg.StepTransInfo)localObject1).jdField_a_of_type_Int = j;
          ((FileMsg.StepTransInfo)localObject1).c = l2;
          ((FileMsg.StepTransInfo)localObject1).jdField_a_of_type_JavaLangString = paramDownloadParams.getMessage();
          continue;
        }
      }
      label2056:
      break;
      localObject6 = null;
      paramDownloadParams = (DownloadParams)localObject3;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject6;
      continue;
      l1 = -1L;
      str1 = "0";
      localObject2 = null;
      localObject1 = null;
      localObject3 = null;
      paramDownloadParams = null;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    a(paramDownloadParams, paramOutputStream, paramURLDrawableHandler, paramDownloadParams.url.getProtocol().equals("lbsthumb"));
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LBSImageDownloader
 * JD-Core Version:    0.7.0.1
 */