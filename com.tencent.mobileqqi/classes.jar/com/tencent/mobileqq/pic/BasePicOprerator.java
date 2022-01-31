package com.tencent.mobileqq.pic;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import gic;
import gid;
import gie;
import gig;
import java.io.File;
import java.net.URL;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BasePicOprerator
  implements DownCallBack, InfoBuilder, UpCallBack, gig
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  protected Handler a;
  public QQAppInterface a;
  public MessageRecord a;
  public PicReq a;
  public UiCallBack a;
  public String a;
  public String b;
  
  public BasePicOprerator() {}
  
  public BasePicOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new gic(this, Looper.getMainLooper());
    }
  }
  
  private TransferRequest a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    paramPicDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_a_of_type_Int = paramPicDownloadInfo.jdField_b_of_type_Int;
    boolean bool;
    if (paramPicDownloadInfo.jdField_f_of_type_Int == 1)
    {
      bool = true;
      localTransferRequest.jdField_b_of_type_Int = URLDrawableHelper.a(paramString, bool);
      localTransferRequest.jdField_a_of_type_Long = paramPicDownloadInfo.jdField_a_of_type_Long;
      localTransferRequest.jdField_b_of_type_Long = paramPicDownloadInfo.jdField_i_of_type_Int;
      localTransferRequest.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_b_of_type_JavaLangString;
      localTransferRequest.jdField_b_of_type_JavaLangString = paramPicDownloadInfo.c;
      localTransferRequest.jdField_d_of_type_JavaLangString = paramPicDownloadInfo.g;
      localTransferRequest.g = null;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
      localTransferRequest.jdField_c_of_type_Boolean = false;
      localTransferRequest.jdField_f_of_type_JavaLangString = paramPicDownloadInfo.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.jdField_f_of_type_JavaLangString + "info.protocol:" + paramPicDownloadInfo.jdField_e_of_type_JavaLangString);
      paramString = new TransferRequest.PicDownExtraInfo();
      localTransferRequest.jdField_a_of_type_JavaLangObject = paramString;
      if (localTransferRequest.jdField_b_of_type_Int != 65537) {
        break label358;
      }
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.h = paramPicDownloadInfo.jdField_j_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.g = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 1;
        PicReporter.a(paramPicDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.h;
    }
    for (;;)
    {
      localTransferRequest.jdField_e_of_type_JavaLangString = paramPicDownloadInfo.jdField_f_of_type_JavaLangString;
      localTransferRequest.jdField_c_of_type_Long = paramPicDownloadInfo.jdField_b_of_type_Long;
      localTransferRequest.jdField_c_of_type_Int = paramPicDownloadInfo.jdField_e_of_type_Int;
      localTransferRequest.jdField_d_of_type_Int = paramPicDownloadInfo.jdField_a_of_type_Int;
      localTransferRequest.jdField_f_of_type_Boolean = true;
      localTransferRequest.jdField_f_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
      return localTransferRequest;
      bool = false;
      break;
      label358:
      if (localTransferRequest.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_i_of_type_JavaLangString;
        if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_i_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_j_of_type_Int = PicPreDownloadUtils.a();
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 2;
          PicReporter.a(paramPicDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      else if (localTransferRequest.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_j_of_type_JavaLangString;
        if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_i_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_j_of_type_Int = PicPreDownloadUtils.a();
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 2;
          PicReporter.a(paramPicDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    int i = 1;
    if (paramMessageForPic.md5 == null) {}
    do
    {
      return;
      if (paramMessageForPic.fileSizeFlag == 1) {
        i = 131075;
      }
      str = URLDrawableHelper.a(paramMessageForPic.md5, i).toString();
    } while (AbsDownloader.a(str));
    String str = AbsDownloader.d(str);
    FileUtils.c(paramMessageForPic.path, str);
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramMessageRecord);
    if ((PicItemBuilder.jdField_e_of_type_Int == 1) || (PicItemBuilder.jdField_e_of_type_Int == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
  }
  
  private boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramPicDownloadInfo);
      return paramPicDownloadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      return paramPicFowardInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramPicUploadInfo);
      return paramPicUploadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  private void b(PicFowardInfo paramPicFowardInfo)
  {
    new gid(this, paramPicFowardInfo).execute(new Void[0]);
  }
  
  private void b(PicUploadInfo paramPicUploadInfo)
  {
    new gie(this, paramPicUploadInfo).execute(new Void[0]);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public TransferResult a(PicDownloadInfo paramPicDownloadInfo, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramPicDownloadInfo.jdField_a_of_type_Long);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramPicDownloadInfo.jdField_e_of_type_JavaLangString = paramString;
      paramPicDownloadInfo = a(paramPicDownloadInfo, paramString);
      paramPicDownloadInfo.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramPicDownloadInfo.jdField_a_of_type_JavaLangObject != null) && ((paramPicDownloadInfo.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo))) {
        ((TransferRequest.PicDownExtraInfo)paramPicDownloadInfo.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localTransFileController.a(paramPicDownloadInfo);
    }
    paramURLDrawableHandler = new DownCallBack.DownResult();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new TransferResult();
    paramURLDrawableHandler.jdField_d_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
      return paramURLDrawableHandler;
    }
    paramURLDrawableHandler.jdField_a_of_type_JavaLangString = "downloadPicSync param check error";
    return paramURLDrawableHandler;
  }
  
  public void a(int paramInt)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_d_of_type_Int = 0;
    localPicResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localPicResult);
  }
  
  protected void a(int paramInt1, int paramInt2, PicResult paramPicResult)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramPicResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localPicResult.jdField_d_of_type_Int = -1;
    a(paramInt, -1, localPicResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, PicResult paramPicResult)
  {
    PicResult localPicResult = paramPicResult;
    if (paramPicResult == null) {
      localPicResult = new PicResult();
    }
    localPicResult.jdField_d_of_type_Int = 0;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    a(paramInt, 0, localPicResult);
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    CompressOperator.a(paramCompressInfo);
    if (paramCompressInfo.jdField_a_of_type_Boolean)
    {
      a(2, null);
      return;
    }
    a(2, null);
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (PicPreDownloader.c.contains(this.jdField_a_of_type_ComTencentMobileqqPicPicReq)))
    {
      PicPreDownloader.c.remove(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
      PicPreDownloader.a.decrementAndGet();
      Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + ",cmd:" + this.jdField_a_of_type_ComTencentMobileqqPicPicReq.h + ",curHandingNum:" + PicPreDownloader.a.get());
      if ((paramDownResult != null) && (paramDownResult.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size == 0L))
      {
        long l = new File(paramDownResult.jdField_b_of_type_JavaLangString).length();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, l);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
    }
    if (paramDownResult == null)
    {
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
    }
    for (;;)
    {
      return;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
      Object localObject = new PicResult();
      ((PicResult)localObject).jdField_d_of_type_Int = paramDownResult.jdField_a_of_type_Int;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramDownResult;
      if (paramDownResult.jdField_a_of_type_Int == 0) {
        a(0, (PicResult)localObject);
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.h == 2))
      {
        if (paramDownResult.jdField_a_of_type_Int != 0) {
          break label429;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = paramDownResult.jdField_b_of_type_JavaLangString;
        b(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo);
        return;
        if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
        {
          localObject = new PicInfoInterface.ErrInfo();
          ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = (paramDownResult.jdField_b_of_type_Int + "_" + paramDownResult.jdField_a_of_type_JavaLangString);
          ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (PicInfoInterface.ErrInfo)localObject);
        }
        else
        {
          a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
        }
      }
    }
    label429:
    a(0, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(PicDownloadInfo paramPicDownloadInfo)
  {
    a(paramPicDownloadInfo, "chatthumb");
  }
  
  public void a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    if (a(paramPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramPicDownloadInfo.jdField_a_of_type_Long);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramPicDownloadInfo.jdField_e_of_type_JavaLangString = paramString;
      paramPicDownloadInfo = a(paramPicDownloadInfo, paramString);
      if (new File(paramPicDownloadInfo.jdField_f_of_type_JavaLangString).exists())
      {
        paramString = new DownCallBack.DownResult();
        paramString.jdField_a_of_type_Int = 0;
        paramString.jdField_b_of_type_JavaLangString = paramPicDownloadInfo.jdField_f_of_type_JavaLangString;
        a(paramString);
        return;
      }
      localTransFileController.b(paramPicDownloadInfo);
      return;
    }
    paramString = new DownCallBack.DownResult();
    paramString.jdField_a_of_type_Int = -1;
    paramString.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(paramString);
  }
  
  public void a(PicFowardInfo paramPicFowardInfo)
  {
    if (!a(paramPicFowardInfo))
    {
      a(4, paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    if (FileUtils.b(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g))
    {
      paramPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(paramPicFowardInfo);
      b(paramPicFowardInfo);
      return;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b())
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a().toString();
      paramPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(paramPicFowardInfo);
      b(paramPicFowardInfo);
      return;
    }
    paramPicFowardInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(paramPicFowardInfo);
    paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = 3;
    a(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo, "chatimg");
  }
  
  public void a(PicUploadInfo paramPicUploadInfo)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramPicUploadInfo))
    {
      b(paramPicUploadInfo);
      return;
    }
    a(3, paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
  }
  
  public void b(PicDownloadInfo paramPicDownloadInfo)
  {
    a(paramPicDownloadInfo, "chatimg");
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(3, null);
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = new PicResult();
      ((PicResult)localObject).jdField_d_of_type_Int = 0;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(3, (PicResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    a(3, (PicInfoInterface.ErrInfo)localObject);
  }
  
  public void c(PicDownloadInfo paramPicDownloadInfo)
  {
    a(paramPicDownloadInfo, "chatraw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator
 * JD-Core Version:    0.7.0.1
 */