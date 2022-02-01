import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class aoni
  extends aojr
{
  public aoni(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
  }
  
  private final void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = a();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while ((!azR()) || (locala == null));
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  protected aoql.a a()
  {
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    locali.cMs = this.cLX;
    locali.selfUin = this.app.getCurrentAccountUin();
    locali.cNY = this.h.cNE;
    locali.peerUin = this.h.mPeerUin;
    locala.b = this;
    locala.cmy = "share_pic_to_wx";
    locala.He.add(locali);
    locala.a = this.app.getProtoReqManager();
    return locala;
  }
  
  public final void a(aoql.a parama, aoql.b paramb)
  {
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.b)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("onBusiProtoResp", parama.toString());
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (QLog.isColorLevel()) {
          QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parama.result);
        }
        if (parama.result == 0)
        {
          this.mUkey = parama.mUkey;
          this.jdField_b_of_type_Aoko.clv = parama.cmD;
          if (parama.isExist)
          {
            this.jdField_b_of_type_Aoko.dVw();
            onSuccess();
            if (QLog.isColorLevel()) {
              QLog.d("ShareToWXUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.h.dQ);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.apw = parama.startOffset;
          dVn();
          continue;
          onError();
        }
      }
    }
  }
  
  public final void dVn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "sendFileBDH");
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    Object localObject = new aonj(this, SystemClock.uptimeMillis());
    byte[] arrayOfByte = aqhs.hexStr2Bytes(this.mUkey);
    localObject = new Transaction(this.app.getCurrentAccountUin(), 73, this.h.dQ, (int)this.apw, arrayOfByte, this.bL, (ITransactionCallback)localObject);
    int i = this.app.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + ((Transaction)localObject).getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " Path:" + ((Transaction)localObject).filePath + " Cmd:" + 73);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.mFileSize + " errorCode:" + this.errCode);
    }
    if (paramBoolean) {
      this.mM.put("param_succ_flag", "1");
    }
    for (;;)
    {
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_time_cost", String.valueOf(l));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWXUpload", paramBoolean, l, this.mFileSize, this.mM, null);
      return;
      this.mM.put("param_succ_flag", "0");
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = 0;
      locala.size = this.mFileSize;
      locala.md5 = this.clf;
      locala.downUrl = this.jdField_b_of_type_Aoko.clv;
      this.h.b.b(locala);
    }
    for (;;)
    {
      VR(1003);
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
      return;
      QV(true);
    }
  }
  
  public final void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "start()");
    }
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return;
    }
    String str = this.h.dQ;
    long l = new File(str).length();
    this.jdField_b_of_type_Aoko.fileSize = l;
    this.mFileSize = l;
    str = aqhq.estimateFileType(str);
    if (!TextUtils.isEmpty(str)) {
      this.clg = str;
    }
    sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoni
 * JD-Core Version:    0.7.0.1
 */