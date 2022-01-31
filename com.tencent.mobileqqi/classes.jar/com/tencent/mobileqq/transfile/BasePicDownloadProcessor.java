package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo a;
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  public void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 / paramInt2 * 10000.0F);
    if (paramInt1 > this.am)
    {
      this.am = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.a.publishProgress(paramInt1);
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = 2002;
      }
      paramNetReq = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramNetReq.hasNext()) {
        ((DownCallBack)paramNetReq.next()).a(paramInt1);
      }
    }
    finally {}
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" result:");
    if (paramNetResp.d == 0)
    {
      bool1 = true;
      a("onHttpResp", bool1);
      if (!this.jdField_a_of_type_Boolean) {
        break label153;
      }
      localObject = this.d;
      label75:
      if (paramNetResp.d != 0) {
        break label162;
      }
    }
    label153:
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.ak = paramNetResp.f;
      if (this.ak <= 0) {
        this.ak = (paramNetResp.g + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.k);
      }
      this.al += paramNetResp.h;
      if (paramNetResp.d != 0) {
        break label167;
      }
      e();
      return;
      bool1 = false;
      break;
      localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      break label75;
    }
    label167:
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      return;
    }
    if ((paramNetResp.jdField_a_of_type_Long == 9364L) && (this.av < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.av += 1;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = -1;
      ((TransferResult)localObject1).jdField_a_of_type_Long = this.at;
      ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = this.J;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.at;
        localDownResult.jdField_a_of_type_JavaLangString = this.J;
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
  }
  
  void e()
  {
    super.e();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = 0;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = 2003;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = 0;
        localDownResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
        localDownCallBack.a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onSuccess ");
        }
      }
      a("notify", "start");
    }
    finally {}
    notifyAll();
    a("notify", "end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */