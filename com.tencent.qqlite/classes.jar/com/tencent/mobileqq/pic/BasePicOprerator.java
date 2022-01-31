package com.tencent.mobileqq.pic;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dzb;
import dzc;
import dzg;
import dzh;
import dzi;
import dzk;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BasePicOprerator
  implements DownCallBack, InfoBuilder, UpCallBack, dzk
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
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
      this.jdField_a_of_type_AndroidOsHandler = new dzb(this, Looper.getMainLooper());
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
      localTransferRequest.jdField_b_of_type_JavaLangString = paramPicDownloadInfo.jdField_c_of_type_JavaLangString;
      localTransferRequest.jdField_d_of_type_JavaLangString = paramPicDownloadInfo.g;
      localTransferRequest.h = null;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
      localTransferRequest.jdField_c_of_type_Boolean = false;
      localTransferRequest.g = paramPicDownloadInfo.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.g + "info.protocol:" + paramPicDownloadInfo.jdField_e_of_type_JavaLangString);
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
  
  private String a(PicFowardInfo paramPicFowardInfo)
  {
    Object localObject3 = null;
    int i;
    Object localObject1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.m == 1)
    {
      i = 1;
      if (!FileUtils.b(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g)) {
        break label383;
      }
      localObject1 = new CompressInfo();
      ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
      ((CompressInfo)localObject1).jdField_c_of_type_JavaLangString = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
      ((CompressInfo)localObject1).g = 0;
      CompressOperator.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = URLDrawableHelper.a(paramPicFowardInfo, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = AbsDownloader.d(((URL)localObject2).toString());; localObject2 = null)
        {
          if (!FileUtils.b((String)localObject2)) {
            break label187;
          }
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          localObject1 = localObject2;
          return localObject1;
          i = 0;
          break;
        }
        label187:
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = URLDrawableHelper.a(paramPicFowardInfo, 131075, null);
          if (localObject2 == null) {
            break label375;
          }
        }
        label375:
        for (String str = AbsDownloader.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (FileUtils.b(str))
          {
            localObject1 = new CompressInfo();
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            ((CompressInfo)localObject1).jdField_c_of_type_JavaLangString = str;
            ((CompressInfo)localObject1).g = 0;
            CompressOperator.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
            Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = URLDrawableHelper.a(paramPicFowardInfo, 65537, null);
          paramPicFowardInfo = localObject3;
          if (localObject1 != null) {
            paramPicFowardInfo = AbsDownloader.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!FileUtils.b(paramPicFowardInfo)) {
            break;
          }
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramPicFowardInfo);
          return paramPicFowardInfo;
        }
      }
      return localObject1;
      label383:
      localObject1 = null;
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
    if ((PicItemBuilder.jdField_f_of_type_Int == 1) || (PicItemBuilder.jdField_f_of_type_Int == 2)) {
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
    new dzg(this, paramPicFowardInfo).execute(new Void[0]);
  }
  
  private void b(PicUploadInfo paramPicUploadInfo)
  {
    new dzi(this, paramPicUploadInfo).execute(new Void[0]);
  }
  
  private boolean b(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1000) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1020) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1004)) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_JavaLangString == null))
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int + ",secondId:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_JavaLangString);
        return false;
      }
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h == -1)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h);
        return false;
      }
      if (a(paramPicFowardInfo) != null) {
        return true;
      }
      paramPicFowardInfo.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
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
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
    {
      if ((paramDownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramDownResult.jdField_b_of_type_JavaLangString != null) && (GifDrawable.isGifFile(new File(paramDownResult.jdField_b_of_type_JavaLangString))))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType = 3;
        this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.serial();
        if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label354;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
        if (!(localObject instanceof MessageForStructing)) {
          break label284;
        }
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))
        {
          StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
          if (localStructMsgItemImage != null)
          {
            Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq, ((MessageForStructing)localObject).structingMsg.getBytes());
          }
        }
      }
      ThreadManager.a().post(new dzh(this, paramDownResult));
      if (paramDownResult != null) {
        break label482;
      }
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
    }
    for (;;)
    {
      return;
      label284:
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.msgData);
      break;
      label354:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if (!(localObject instanceof MessageForMixedMsg)) {
        break;
      }
      localObject = ((MessageForMixedMsg)localObject).upateMessageForPic(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      if (localObject == null) {
        break;
      }
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq, (byte[])localObject);
      break;
      label482:
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
      localObject = new PicResult();
      ((PicResult)localObject).jdField_d_of_type_Int = paramDownResult.jdField_a_of_type_Int;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramDownResult;
      if (paramDownResult.jdField_a_of_type_Int == 0) {
        a(0, (PicResult)localObject);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_i_of_type_Int == 2)
      {
        if (paramDownResult.jdField_a_of_type_Int != 0) {
          break label677;
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
    label677:
    a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    if (a(paramPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramPicDownloadInfo.jdField_a_of_type_Long);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramPicDownloadInfo.jdField_e_of_type_JavaLangString = paramString;
      paramString = a(paramPicDownloadInfo, paramString);
      if (new File(paramString.g).exists())
      {
        localObject = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject).jdField_a_of_type_Int = 0;
        ((DownCallBack.DownResult)localObject).jdField_b_of_type_JavaLangString = paramString.g;
        ((DownCallBack.DownResult)localObject).jdField_c_of_type_JavaLangString = paramString.jdField_e_of_type_JavaLangString;
        ((DownCallBack.DownResult)localObject).jdField_c_of_type_Int = paramString.jdField_b_of_type_Int;
        ((DownCallBack.DownResult)localObject).jdField_d_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
        a((DownCallBack.DownResult)localObject);
        return;
      }
      ((TransFileController)localObject).b(paramString);
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
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((PicFowardInfo)paramArrayList.get(0));
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] start");
    }
    new dzc(this, paramArrayList, l).execute(new Void[0]);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_i_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_i_of_type_Int == 3))
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          a(paramSendResult);
          localObject = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
          if (localObject != null) {
            ((PicStatisticsManager)localObject).a(13057, paramSendResult.jdField_a_of_type_Long);
          }
          localObject = new PicResult();
          ((PicResult)localObject).jdField_d_of_type_Int = 0;
          ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
          a(3, (PicResult)localObject);
          return;
        }
        localObject = new PicInfoInterface.ErrInfo();
        ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
        a(3, (PicInfoInterface.ErrInfo)localObject);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_i_of_type_Int != 2);
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
      if (localObject != null) {
        ((PicStatisticsManager)localObject).a(13058, paramSendResult.jdField_a_of_type_Long);
      }
      localObject = new PicResult();
      ((PicResult)localObject).jdField_d_of_type_Int = 0;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(4, (PicResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    a(4, (PicInfoInterface.ErrInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator
 * JD-Core Version:    0.7.0.1
 */