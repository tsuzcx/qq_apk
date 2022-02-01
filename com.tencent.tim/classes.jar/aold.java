import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class aold
  extends aokv
{
  public aold(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  protected int KL()
  {
    boolean bool = true;
    int j = 0;
    hM("uiParam", this.h.toString());
    int i;
    switch (this.h.mUinType)
    {
    default: 
      this.mIsGroup = false;
      if (2 == this.h.mFileType) {
        bool = false;
      }
      this.cMB = bool;
      if ((!this.cMB) && (this.h.F == null))
      {
        dN(9302, f(new Exception("message null")));
        onError();
        i = -1;
      }
      break;
    }
    label192:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.mIsGroup = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((aool)localObject).cNC)) {
              break label192;
            }
            i = j;
          } while (this.h.en == null);
          i = j;
        } while (!(this.h.en instanceof aool.d));
        this.cLX = ((aool.d)this.h.en).cNJ;
        return 0;
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
        Object localObject = this.b;
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
        i = j;
      } while (this.h.en == null);
      i = j;
    } while (!(this.h.en instanceof aool.d));
    this.cLX = ((aool.d)this.h.en).cNJ;
    return 0;
  }
  
  protected void QZ(boolean paramBoolean)
  {
    if (!paramBoolean) {
      VR(1001);
    }
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
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
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
    this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    sendRequest();
  }
  
  protected void c(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      while (i < paramb.Hf.size())
      {
        parama = (aoql.b.m)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.cLU);
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if ((parama instanceof aoql.b.e))
        {
          parama = (aoql.b.e)parama;
          if (parama.result != 0) {
            break label274;
          }
          if (parama.isExist)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + parama.groupFileID + ", mFileSize:" + this.b.fileSize);
            }
            this.cMe = true;
            this.b.transferedSize = this.b.fileSize;
            this.jdField_app_of_type_Long = parama.groupFileID;
            this.xp = parama.xp;
            dDP();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        log("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + parama.isExist + " ,select HTTP channel");
        this.dPg = 2;
        onError();
      }
    }
    return;
    label274:
    log("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parama.result + " ,select HTTP channel");
    this.dPg = 2;
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
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.mStartTime) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    locali.cMs = this.cLX;
    locali.busiType = this.h.mBusiType;
    locali.dRm = 3;
    locali.cmB = this.h.c.rawDownloadUrl;
    MessageRecord localMessageRecord = this.h.F;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      locali.picType = ((MessageForPic)localMessageRecord).imageType;
      this.dPe = ((MessageForPic)localMessageRecord).imageType;
    }
    locali.selfUin = this.h.mSelfUin;
    locali.peerUin = this.h.mPeerUin;
    locali.cmC = this.h.cmn;
    locali.uinType = this.h.mUinType;
    locala.b = this;
    locala.cmy = "grp_pic_up";
    locala.He.add(locali);
    locala.a = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
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
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aold
 * JD-Core Version:    0.7.0.1
 */