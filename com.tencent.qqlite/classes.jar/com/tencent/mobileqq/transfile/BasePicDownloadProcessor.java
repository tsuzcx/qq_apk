package com.tencent.mobileqq.transfile;

import android.support.v4.util.MQLruCache;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.ProxyIpManager;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo a;
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    if (i > this.ap)
    {
      this.ap = i;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.a.publishProgress(i);
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.B = 2002;
      }
      paramNetReq = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramNetReq.hasNext()) {
        ((DownCallBack)paramNetReq.next()).a(i);
      }
    }
    finally {}
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_b_of_type_Boolean).append(" result:");
    if (paramNetResp.d == 0)
    {
      bool1 = true;
      a("onHttpResp", bool1);
      if (!this.jdField_b_of_type_Boolean) {
        break label155;
      }
      localObject = this.d;
      label75:
      if (paramNetResp.d != 0) {
        break label164;
      }
    }
    label155:
    label164:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramNetResp.c;
      if (paramNetResp.d != 0) {
        break label169;
      }
      e();
      return;
      bool1 = false;
      break;
      localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      break label75;
    }
    label169:
    if (this.jdField_b_of_type_Boolean)
    {
      c();
      return;
    }
    if ((paramNetResp.e == 9364) && (this.ay < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.ay += 1;
      o();
      c();
      return;
    }
    d();
  }
  
  void c() {}
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = -1;
      ((TransferResult)localObject1).jdField_a_of_type_Long = this.aw;
      ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = this.L;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.B = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.aw;
        localDownResult.jdField_a_of_type_JavaLangString = this.L;
        localDownCallBack.a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      a("notify", "start");
    }
    finally {}
    notifyAll();
    a("notify", "end");
    d(2005);
  }
  
  void e()
  {
    super.e();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = 0;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    label618:
    label621:
    label623:
    label626:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject5;
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        continue;
        localObject4 = localObject5;
        if (!(localObject5 instanceof MessageForStructing)) {
          continue;
        }
        Object localObject6 = (MessageForStructing)localObject5;
        localObject4 = localObject5;
        if (!(((MessageForStructing)localObject6).structingMsg instanceof StructMsgForImageShare)) {
          continue;
        }
        localObject6 = ((StructMsgForImageShare)((MessageForStructing)localObject6).structingMsg).getFirstImageElement();
        localObject4 = localObject5;
        if (localObject6 == null) {
          continue;
        }
        localObject4 = localObject5;
        if (((StructMsgItemImage)localObject6).a == null) {
          continue;
        }
        localObject4 = ((StructMsgItemImage)localObject6).a;
        continue;
        bool = false;
        continue;
        a("notify", "start");
        notifyAll();
        a("notify", "end");
        d(2003);
        return;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.B = 2003;
        }
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject5 = (DownCallBack)((Iterator)localObject1).next();
        localObject6 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Int = 0;
        ((DownCallBack.DownResult)localObject6).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
        ((DownCallBack.DownResult)localObject6).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
        ((DownCallBack)localObject5).a((DownCallBack.DownResult)localObject6);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 1) {}
      }
      finally {}
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 131075) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
      {
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject5 instanceof MessageForMixedMsg))
        {
          localObject3 = ((MessageForMixedMsg)localObject5).getSubMessage(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long);
          if ((localObject3 == null) || (!(localObject3 instanceof MessageForPic))) {
            break label623;
          }
          localObject3 = (MessageForPic)localObject3;
          if (localObject3 == null) {
            break label626;
          }
          if (((MessageForPic)localObject3).fileSizeFlag != 1) {
            continue;
          }
          bool = true;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != URLDrawableHelper.a("chatimg", bool)) {
            continue;
          }
          localObject5 = new CompressInfo();
          localObject3 = URLDrawableHelper.a((PicUiInterface)localObject3, 65537);
          ((CompressInfo)localObject5).g = true;
          ((CompressInfo)localObject5).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
          ((CompressInfo)localObject5).e = (AbsDownloader.d(((URL)localObject3).toString()) + "_hd");
          CompressOperator.b((CompressInfo)localObject5);
          if (((CompressInfo)localObject5).e == null) {
            continue;
          }
          localObject6 = new File(AbsDownloader.d(((URL)localObject3).toString()) + "_hd");
          if (!((CompressInfo)localObject5).e.equals(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString)) {
            break label618;
          }
          bool = FileUtil.a(new File(((CompressInfo)localObject5).e), (File)localObject6);
          if ((!bool) || (BaseApplicationImpl.a.get(((URL)localObject3).toString()) == null)) {
            break label621;
          }
          BaseApplicationImpl.a.remove(((URL)localObject3).toString());
          localObject3 = URLDrawable.getDrawable((URL)localObject3);
          if (localObject3 == null) {
            continue;
          }
          ((URLDrawable)localObject3).downloadImediatly(true);
        }
        boolean bool = true;
        continue;
        continue;
        Object localObject4 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */