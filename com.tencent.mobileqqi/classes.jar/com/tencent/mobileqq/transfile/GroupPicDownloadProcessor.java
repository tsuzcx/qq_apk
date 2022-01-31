package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  byte[] a;
  long f;
  boolean g = true;
  
  public GroupPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    super.a();
    r();
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
          t();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  String b(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
  }
  
  void c()
  {
    s();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.c(this.at))) || (this.jdField_b_of_type_Boolean) || ((paramBoolean) && ((this.aw & 0x2) > 0)) || ((!paramBoolean) && ((this.aw & 0x1) > 0))) {
      return;
    }
    int j = this.aw;
    int i;
    String str1;
    label116:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.aw = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label369;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
        break label361;
      }
      str1 = "actGroupPicSmallDownV1";
      l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
      String str2 = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label397;
      }
      i = 1;
      label284:
      if (i != 0)
      {
        if (!TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString)) {
          break label402;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", "1");
      }
      label320:
      if (!paramBoolean) {
        break label418;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.ak, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label361:
      str1 = "actGroupPicDownloadV1";
      break label116;
      label369:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {}
      for (str1 = "actDiscussPicSmallDown";; str1 = "actDiscussPicDown") {
        break;
      }
      label397:
      i = 0;
      break label284;
      label402:
      this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", "0");
      break label320;
      label418:
      if (this.at != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.at));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.J);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int e()
  {
    int i = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (FileUtils.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label188;
      }
      String str2 = b(str1);
      if (str2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean)) {
        break label231;
      }
      a(9302, a(new Exception("no output stream")));
      d();
      i = -1;
      return i;
    }
    a(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label188:
    a(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label231:
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      a(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.al = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString);
      this.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString)));
      d();
      return -1;
    }
  }
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.g) {
        break label72;
      }
      if (i == 2) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
  
  void q()
  {
    this.jdField_a_of_type_JavaUtilArrayList = FMTSrvAddrProvider.a().a(2);
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
        t();
        return;
      }
    }
    c();
  }
  
  void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_a_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPicDownReq localGroupPicDownReq = new RichProto.RichProtoReq.GroupPicDownReq();
    localGroupPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localGroupPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPicDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPicDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Long = this.f;
    localGroupPicDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_pic_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPicDownReq);
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
  
  void t()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
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
      ((HttpNetReq)localObject).jdField_a_of_type_Boolean = true;
      ((HttpNetReq)localObject).k = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + ((HttpNetReq)localObject).k + "-");
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      ((HttpNetReq)localObject).m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        ((HttpNetReq)localObject).l = 0;
      }
      a("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " url:" + str + ",downOffset:" + ((HttpNetReq)localObject).k);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */