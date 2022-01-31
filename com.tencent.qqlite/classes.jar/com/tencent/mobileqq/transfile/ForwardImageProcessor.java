package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import ehc;
import java.io.File;

public class ForwardImageProcessor
  implements IHttpCommunicatorListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ehc(this);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public ForwardImageProcessor(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.e = paramString4;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void c()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    Message localMessage = new Message();
    localMessage.what = 1005;
    FileMsg localFileMsg = new FileMsg(this.jdField_b_of_type_JavaLangString, this.c, 0);
    localFileMsg.e = 1;
    localFileMsg.c = this.jdField_a_of_type_Long;
    localMessage.obj = localFileMsg;
    localMessage.arg1 = 0;
    BaseTransProcessor.a(localMessage, ForwardImageProcessor.class, 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.e, this.d, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_Int == 1001) {}
      for (long l = AppSetting.d;; l = 19922944L)
      {
        int i = (int)l;
        if (new File(this.c).length() > i)
        {
          ImageUtil.a(-1L, this.jdField_a_of_type_Int, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.c = ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getBaseContext(), this.c, i);
        }
        if (ImageUtil.a(null, this.c, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.c, this.jdField_a_of_type_Long);
      return;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.d = 1009;
    localTransferRequest.h = this.c;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardImageProcessor
 * JD-Core Version:    0.7.0.1
 */