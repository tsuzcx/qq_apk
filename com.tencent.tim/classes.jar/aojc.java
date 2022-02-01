import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.C2CCommonExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterStyle;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterRequest;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestFilter;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aojc
  extends aojr
{
  long apg = 0L;
  long aph = 0L;
  long api = 0L;
  long apj = 0L;
  long apk = 0L;
  long apl = 0L;
  long apm = 0L;
  long apn = 0L;
  long apo = 0L;
  public rfg b;
  rfi b;
  boolean cLJ = false;
  boolean cLK;
  private int callbackId;
  String ckU;
  int dOL;
  long startDownloadTime = 0L;
  String styleName;
  public int taskId;
  int um;
  
  public aojc(aojm paramaojm, aool paramaool, String paramString)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Rfg = rfg.a();
    this.mUkey = paramString;
  }
  
  public void RU(String paramString)
  {
    if (this.cLJ) {
      return;
    }
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = paramString;
    localaoll.mHttpMethod = 0;
    localaoll.cMG = true;
    localaoll.atY = this.ckU;
    localaoll.dPo = 0;
    localaoll.a = jdField_b_of_type_Aolm$a;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "sendDownLoadRequest req:" + localaoll);
    }
    this.startDownloadTime = SystemClock.uptimeMillis();
    this.dOL = 4;
    this.c.a(localaoll);
    this.jdField_a_of_type_Aomg = localaoll;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, rfi paramrfi, boolean paramBoolean)
  {
    this.callbackId = paramInt1;
    this.um = paramInt2;
    this.styleName = paramString;
    this.taskId = paramInt3;
    this.jdField_b_of_type_Rfi = paramrfi;
    this.cLK = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "FilterUploadInfo:" + paramrfi);
    }
    if (paramrfi == null) {
      return;
    }
    this.mFileSize = paramrfi.mFileSize;
    this.bL = paramrfi.bL;
    this.mFileName = paramrfi.mFileName;
    this.ckU = (EditVideoArtFilter.azw + paramrfi.BW + "_" + paramInt2 + ".png");
    this.mHeight = paramrfi.mHeight;
    this.mWidth = paramrfi.mWidth;
    this.apn = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "start()  needUploadImg:" + paramBoolean + " mUky:" + this.mUkey);
    }
    if ((!paramBoolean) && (this.mUkey != null))
    {
      dUQ();
      return;
    }
    sendRequest();
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    if (this.cLJ) {}
    do
    {
      return;
      this.jdField_a_of_type_Aoql$a = null;
      this.aph = SystemClock.uptimeMillis();
    } while (paramb == null);
    int i = 0;
    label26:
    if (i < paramb.Hf.size())
    {
      parama = (aoql.b.b)paramb.Hf.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "getTransferResp:" + parama);
      }
      if (parama.result != 0) {
        break label141;
      }
      this.mUkey = parama.mUkey;
      if (this.jdField_b_of_type_Rfg.aAd.equals(this.jdField_b_of_type_Rfi.aAe))
      {
        this.jdField_b_of_type_Rfg.aAc = parama.mUkey;
        diB();
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label141:
      dM(parama.result, "getTransferError");
    }
  }
  
  public int cancel()
  {
    this.cLJ = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "cancelTask taskId:" + this.taskId + " mRichProtoReq:" + this.jdField_a_of_type_Aoql$a + " mTrans:" + this.mTrans + " mNetReq:" + this.jdField_a_of_type_Aomg);
    }
    if (this.jdField_a_of_type_Aoql$a != null)
    {
      aoqm.d(this.jdField_a_of_type_Aoql$a);
      this.jdField_a_of_type_Aoql$a = null;
    }
    if (this.mTrans != null)
    {
      this.mTrans.cancelTransaction();
      this.mTrans = null;
    }
    if (this.jdField_a_of_type_Aomg != null)
    {
      this.c.b(this.jdField_a_of_type_Aomg);
      this.jdField_a_of_type_Aomg = null;
    }
    return 0;
  }
  
  public void dM(int paramInt, String paramString)
  {
    if (this.cLJ) {
      return;
    }
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      bool = true;
      this.apo = SystemClock.uptimeMillis();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_art_filter_task_id", this.taskId);
      ((Bundle)localObject).putInt("param_art_filter_task_result", paramInt);
      ((Bundle)localObject).putInt("param_art_filter_style_id", this.um);
      ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_b_of_type_Rfi.aAe);
      ((Bundle)localObject).putString("param_art_filter_output_path", this.ckU);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ReturnFilterResult  callbackId:" + this.callbackId + " taskId:" + this.um + " styleId:" + this.taskId + " errorCode:" + paramInt + " errorFrom:" + paramString + " bundle:" + localObject);
      }
      this.jdField_b_of_type_Rfg.callbackResult(this.callbackId, EIPCResult.createSuccessResult((Bundle)localObject));
      this.jdField_b_of_type_Rfg.aZ.remove(this.um);
      this.mM.put("uploadFileSize", String.valueOf(this.mFileSize));
      this.mM.put("param_FailCode", String.valueOf(paramInt));
      this.mM.put("step", String.valueOf(this.dOL));
      this.mM.put("filterId", String.valueOf(this.um));
      localObject = this.mM;
      if (this.cLK != true) {
        break label587;
      }
    }
    label587:
    for (paramString = "1";; paramString = "0")
    {
      ((HashMap)localObject).put("isuploadOriginalPic", paramString);
      long l1 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      long l4 = 0L;
      if (this.aph > this.apg) {
        l1 = this.aph - this.apg;
      }
      if (this.apj > this.api) {
        l2 = this.apj - this.api;
      }
      if (this.apl > this.apk) {
        l3 = this.apl - this.apk;
      }
      if (this.apm > this.startDownloadTime) {
        l4 = this.apm - this.startDownloadTime;
      }
      this.mM.put("wup_Costtime", String.valueOf(l1));
      this.mM.put("original_Costtime", String.valueOf(l2));
      this.mM.put("filter_Costtime", String.valueOf(l3));
      this.mM.put("download_Costtime", String.valueOf(l4));
      if (!QLog.isColorLevel()) {
        break label604;
      }
      paramString = new StringBuilder();
      localObject = this.mM.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.mM.get(str) != null)
        {
          paramString.append("&");
          paramString.append(str);
          paramString.append("=");
          paramString.append((String)this.mM.get(str));
        }
      }
      bool = false;
      break;
    }
    QLog.d("ArtFilterUploadProcessor", 2, paramString.toString());
    label604:
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "afCosttimeAndFlowReport", bool, this.apo - this.apn, this.mFileSize, this.mM, "");
  }
  
  void dUQ()
  {
    if (this.cLJ) {
      return;
    }
    Object localObject1 = new aoje(this);
    Object localObject2 = new CSDataHighwayHead.FilterExtendinfo();
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).uint32_filter_flag.set(2);
    CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
    localC2CCommonExtendinfo.uint32_info_id.set(1);
    CSDataHighwayHead.FilterStyle localFilterStyle = new CSDataHighwayHead.FilterStyle();
    localFilterStyle.style_id.set(this.um);
    localFilterStyle.style_name.set(ByteStringMicro.copyFrom(aqhs.hexStr2Bytes(this.styleName)));
    CSDataHighwayHead.ImageFilterRequest localImageFilterRequest = new CSDataHighwayHead.ImageFilterRequest();
    String str = this.app.getCurrentAccountUin() + this.um + this.styleName + this.mFileName + SystemClock.uptimeMillis();
    localImageFilterRequest.session_id.set(ByteStringMicro.copyFromUtf8(str));
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "SendFilterFilter sessionId:" + str);
    }
    localImageFilterRequest.uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localImageFilterRequest.style.set(localFilterStyle);
    localImageFilterRequest.width.set(this.mWidth);
    localImageFilterRequest.height.set(this.mHeight);
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).msg_image_filter_request.set(localImageFilterRequest);
    localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject2);
    localObject2 = localC2CCommonExtendinfo.toByteArray();
    localObject1 = new RequestFilter(String.valueOf(this.app.getCurrentAccountUin()), 1, this.mUkey.getBytes(), 15000L, (IRequestCallback)localObject1, (byte[])localObject2, null, 0);
    this.app.getHwEngine().SubmitAckRequest((RequestAck)localObject1);
    this.apk = SystemClock.uptimeMillis();
    this.dOL = 3;
  }
  
  public final void diB()
  {
    if (this.cLJ) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ArtFilterUploadProcessor.sendFile()");
      }
      aojd localaojd = new aojd(this);
      byte[] arrayOfByte = aqhs.hexStr2Bytes(this.mUkey);
      Object localObject = new CSDataHighwayHead.FilterExtendinfo();
      ((CSDataHighwayHead.FilterExtendinfo)localObject).uint32_filter_flag.set(1);
      CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
      localC2CCommonExtendinfo.uint32_info_id.set(1);
      localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject);
      localObject = localC2CCommonExtendinfo.toByteArray();
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.jdField_b_of_type_Rfi.aAe, (int)this.apw, arrayOfByte, this.bL, localaojd, (byte[])localObject);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      this.api = SystemClock.uptimeMillis();
      this.dOL = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " MD5:" + this.jdField_b_of_type_Rfi.bL + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath);
      }
    } while (i == 0);
    dM(i, "submit transaction error");
  }
  
  public void hI(String paramString1, String paramString2)
  {
    this.mM.put(paramString1, paramString2);
  }
  
  public void onResp(aomh paramaomh)
  {
    if (this.cLJ) {
      return;
    }
    super.onResp(paramaomh);
    this.apm = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "getDownLoadResponse: " + paramaomh);
    }
    this.mM.put("downloadFileSize", String.valueOf(paramaomh.apU));
    if (paramaomh.mResult == 0)
    {
      this.dOL = 5;
      dM(0, null);
      return;
    }
    if (paramaomh.clO != null) {
      QLog.d("ArtFilterUploadProcessor", 1, "download dailed, mErrCode" + paramaomh.mErrCode + "mErrDesc:" + paramaomh.clO);
    }
    dM(paramaomh.mErrCode, paramaomh.clO);
  }
  
  public void sendRequest()
  {
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.selfUin = this.app.getCurrentAccountUin();
    locali.peerUin = this.h.mPeerUin;
    locali.cmC = "";
    locali.uinType = this.h.mUinType;
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    if (this.h.mUinType == 1006) {}
    for (boolean bool = true;; bool = false)
    {
      locali.cNW = bool;
      locali.cMs = this.cLX;
      locala.b = this;
      locala.cmy = "art_filter_up";
      locala.He.add(locali);
      locala.a = this.app.getProtoReqManager();
      this.app.getHwEngine().preConnect();
      this.jdField_a_of_type_Aojn$a.dVf();
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "sendTransferRequest:" + locala);
      }
      this.apg = SystemClock.uptimeMillis();
      this.dOL = 1;
      this.jdField_a_of_type_Aoql$a = locala;
      aoqm.c(locala);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojc
 * JD-Core Version:    0.7.0.1
 */