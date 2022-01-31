package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C2CPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  public C2CPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    super.a();
    try
    {
      r();
      return;
    }
    catch (Exception localException)
    {
      a("reportFailed", ChatImageDownloader.a(localException));
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_d_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          s();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_a_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq = new RichProto.RichProtoReq.C2CPicDownReq();
    localC2CPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localC2CPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localC2CPicDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localC2CPicDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localC2CPicDownReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_f_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localC2CPicDownReq.jdField_b_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      localC2CPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1006) {
        break label281;
      }
      bool = true;
      label194:
      localC2CPicDownReq.jdField_a_of_type_Boolean = bool;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localC2CPicDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label286;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label281:
    label286:
    do
    {
      return;
      this.jdField_f_of_type_JavaLangString = "picplatform";
      a("findDbRec", "not found");
      break;
      bool = false;
      break label194;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.c(this.at))) || (this.jdField_b_of_type_Boolean) || ((paramBoolean) && ((this.aw & 0x2) > 0)) || ((!paramBoolean) && ((this.aw & 0x1) > 0))) {
      return;
    }
    int j = this.aw;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.aw = (i | j);
      l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
      String str = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      if (!paramBoolean) {
        break label292;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), true, l, this.ak, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label292:
      if (this.at != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.at));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.J);
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int e()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http")))
    {
      a(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean))
    {
      a(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      a(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.al = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    return 0;
  }
  
  void q()
  {
    this.jdField_a_of_type_JavaUtilArrayList = FMTSrvAddrProvider.a().a(11);
  }
  
  void r()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_JavaLangString;
    if ((this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals("")))
    {
      q();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        s();
        return;
      }
    }
    c();
  }
  
  void s()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (this.e) {
      return;
    }
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_d_of_type_JavaLangString != null)) {
      str = "http://" + this.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      str = str + this.jdField_c_of_type_JavaLangString;
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
      }
      ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject).k = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_Boolean = true;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + ((HttpNetReq)localObject).k + "-");
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((HttpNetReq)localObject).m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
      if (this.jdField_a_of_type_Boolean) {
        ((HttpNetReq)localObject).jdField_b_of_type_Long = 0L;
      }
      a("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " url:" + str + ",downOffset:" + ((HttpNetReq)localObject).k);
      if (!e()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
      return;
      localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      str = "http://" + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
      if (((ServerAddr)localObject).jdField_b_of_type_Int != 80) {
        str = str + ":" + ((ServerAddr)localObject).jdField_b_of_type_Int;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */