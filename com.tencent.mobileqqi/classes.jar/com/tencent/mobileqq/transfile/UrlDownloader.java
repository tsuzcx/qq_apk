package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  protected TransferRequest.PicDownExtraInfo a;
  
  public UrlDownloader(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.al = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramNetResp.d == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a("onHttpResp", bool);
      this.al += paramNetResp.h;
      if (paramNetResp.d != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
  
  void c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
    localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
    localHttpNetReq.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localHttpNetReq.k = this.al;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Boolean)
    {
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.k + "-");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    }
    localHttpNetReq.l = 4;
    localHttpNetReq.jdField_b_of_type_Long = 90000L;
    a("httpDown", " url:" + str + ",downOffset:" + localHttpNetReq.k);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localTransferResult != null)
    {
      localTransferResult.d = -1;
      localTransferResult.jdField_a_of_type_Long = this.at;
      localTransferResult.jdField_a_of_type_JavaLangString = this.J;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
  
  void e()
  {
    super.e();
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.d(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    if (localTransferResult != null)
    {
      localTransferResult.d = 0;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.UrlDownloader
 * JD-Core Version:    0.7.0.1
 */