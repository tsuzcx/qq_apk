package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPttDownloadProcessor
  extends BaseDownloadProcessor
{
  byte[] a;
  long f;
  boolean g = true;
  
  public GroupPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  public void a()
  {
    d(2001);
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
    if (paramNetResp.d == 0)
    {
      bool1 = true;
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.d != 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a("onHttpResp", bool1);
      this.ak = paramNetResp.f;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      if (this.ak <= 0) {
        this.ak = (paramNetResp.g + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.k);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a.e = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramNetResp.d != 0) {
        break label143;
      }
      e();
      return;
      bool1 = false;
      break;
    }
    label143:
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.d = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          r();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  void c()
  {
    d(2001);
    q();
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.at))) {}
    while ((this.jdField_b_of_type_Boolean) || ((paramBoolean) && ((this.aw & 0x2) > 0)) || ((!paramBoolean) && ((this.aw & 0x1) > 0))) {
      return;
    }
    int j = this.aw;
    int i;
    String str1;
    label81:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.aw = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label236;
      }
      str1 = "actGrpPttDown";
      l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      if (!paramBoolean) {
        break label243;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.ak, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label236:
      str1 = "actDisscusPttDown";
      break label81;
      label243:
      if (this.at != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.at));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.J);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void d()
  {
    super.d();
    d(2005);
  }
  
  public int e()
  {
    boolean bool = true;
    int i = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http://")))
    {
      a(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f = a("group", str);
    }
    if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) {}
    for (;;)
    {
      this.g = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      this.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)));
      d();
      return -1;
      bool = false;
    }
  }
  
  void e()
  {
    super.e();
    s();
    d(2003);
  }
  
  protected void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (this.g) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localGroupPttDownReq.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPttDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPttDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPttDownReq.jdField_a_of_type_Long = this.f;
    localGroupPttDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPttDownReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  void r()
  {
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.d != null)) {
      str = "http://" + this.d;
    }
    for (;;)
    {
      str = str + this.jdField_c_of_type_JavaLangString;
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject).k = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_Boolean = true;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      a("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject).k);
      if (!e())
      {
        return;
        localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        str = "http://" + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
        if (((ServerAddr)localObject).jdField_b_of_type_Int != 80) {
          str = str + ":" + ((ServerAddr)localObject).jdField_b_of_type_Int;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
        p();
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
        return;
      }
    }
  }
  
  public void s()
  {
    Object localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null)
    {
      ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      ((MessageForPtt)localObject).fileSize = this.ak;
      ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      ((MessageForPtt)localObject).serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForPtt)localObject).uniseq, ((MessageForPtt)localObject).msgData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */