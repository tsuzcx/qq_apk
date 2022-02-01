import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aokd
  extends aojv
{
  public aokd(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  public int KH()
  {
    Object localObject = a();
    if ((localObject != null) && (((aool)localObject).cNC))
    {
      if ((this.h.en != null) && ((this.h.en instanceof aool.d))) {
        this.cLX = ((aool.d)this.h.en).cNJ;
      }
      return 0;
    }
    hM("uiParam", this.h.toString());
    if (TextUtils.isEmpty(this.h.mMd5))
    {
      dN(9042, f(new Exception("qzonePic md5 null!")));
      onError();
      return -1;
    }
    if ((this.h.c == null) || (TextUtils.isEmpty(this.h.c.rawDownloadUrl)) || (TextUtils.isEmpty(this.h.c.rawMd5)))
    {
      dN(9302, f(new Exception("qzonePic param_check error!")));
      onError();
      return -1;
    }
    localObject = this.b;
    long l = this.h.c.fileSize;
    ((aoko)localObject).fileSize = l;
    this.mFileSize = l;
    if (this.mFileSize <= 0L)
    {
      dN(9071, f(new Exception("qzonePic file size 0 ")));
      onError();
      return -1;
    }
    if (this.mFileSize >= aopb.hm())
    {
      dN(9063, f(new Exception("qzonePic file size TooBig! ")));
      onError();
      return -1;
    }
    if ((this.h.en != null) && ((this.h.en instanceof aool.d))) {
      this.cLX = ((aool.d)this.h.en).cNJ;
    }
    return 0;
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    super.a(parama, paramb);
  }
  
  protected void b(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.b)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result != 0) {
          break label386;
        }
        if (parama.isExist)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + parama.mResid + ", mUuid:" + parama.mUuid + ", fileSize:" + this.b.fileSize);
          }
          this.cMe = true;
          this.b.transferedSize = this.b.fileSize;
          aoko localaoko = this.b;
          String str = parama.mResid;
          localaoko.serverPath = str;
          this.mResid = str;
          localaoko = this.b;
          parama = parama.mUuid;
          localaoko.cls = parama;
          this.mUuid = parama;
          if ((this.cMl) && (this.mTrans != null)) {
            if ((!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
            {
              this.mTrans.cancelTransaction();
              dDP();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            dDP();
          }
        }
        log("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + parama.isExist + " ,select HTTP channel");
        this.dPg = 2;
        if ((!this.cMl) || (this.mTrans == null) || (!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
        {
          if ((this.cMl) && (this.mTrans != null)) {
            this.app.getHwEngine().cancelTransactionTask(this.mTrans);
          }
          onError();
        }
      }
    }
    label386:
    do
    {
      return;
      log("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parama.result + " ,select HTTP channel");
      this.dPg = 2;
    } while ((this.cMl) && (this.mTrans != null) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get()));
    if ((this.cMl) && (this.mTrans != null)) {
      this.app.getHwEngine().cancelTransactionTask(this.mTrans);
    }
    onError();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    super.doReport(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.errCode));
      localHashMap.put("fail_url", this.h.c.rawDownloadUrl);
    }
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.mStartTime) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void doStart()
  {
    VR(1000);
    this.b.dVw();
    VR(1001);
    aool localaool = a();
    if ((localaool != null) && (localaool.cNC))
    {
      this.mWidth = localaool.dQJ;
      this.mHeight = localaool.dQK;
      this.mFileSize = localaool.aqp;
      this.bL = aqhs.hexStr2Bytes(localaool.mMd5);
      this.mFileName = localaool.mMd5;
      this.clf = this.mFileName;
      this.b.fileMd5 = this.mFileName;
      this.mFileName = (this.mFileName + "." + this.clg);
      this.app.getHwEngine().preConnect();
      sendRequest();
      return;
    }
    if (this.h.c != null)
    {
      this.mWidth = this.h.c.rawWidth;
      this.mHeight = this.h.c.rawHeight;
      this.bL = aqhs.hexStr2Bytes(this.h.c.rawMd5);
      this.mFileName = HexUtil.bytes2HexStr(this.bL);
      this.clf = this.mFileName;
      this.b.fileMd5 = this.mFileName;
      this.clg = "jpg";
      this.mFileName = (this.mFileName + "." + this.clg);
    }
    this.app.getHwEngine().preConnect();
    if (this.cMl)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.cMl);
      }
      this.fI = au();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.fJ = av();
      if ((this.fI != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.fI + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        sendRequest();
        diB();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.cMl = false;
      sendRequest();
      return;
    }
    sendRequest();
  }
  
  protected void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.selfUin = this.h.mSelfUin;
    locali.peerUin = this.h.mPeerUin;
    locali.cmC = this.h.cmn;
    locali.uinType = this.h.mUinType;
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    boolean bool;
    if (this.h.mUinType == 1006)
    {
      bool = true;
      locali.cNW = bool;
      locali.cMs = this.cLX;
      locali.dRm = 3;
      locali.cmB = this.h.c.rawDownloadUrl;
      locala.b = this;
      locala.cmy = "c2c_pic_up";
      locala.He.add(locali);
      locala.a = this.app.getProtoReqManager();
      MessageRecord localMessageRecord = this.h.F;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        locali.picType = ((MessageForPic)localMessageRecord).imageType;
        this.dPe = ((MessageForPic)localMessageRecord).imageType;
      }
      if (azQ()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokd
 * JD-Core Version:    0.7.0.1
 */