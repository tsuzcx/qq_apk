import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class aomd
  extends aojr
{
  public static int bxx;
  private Transaction a;
  public String clS;
  public String mUrl;
  public String uuid;
  public String yc;
  
  public aomd(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Aoko.a = this;
    this.jdField_b_of_type_Aoko.fL = paramaool.gb;
    this.jdField_b_of_type_Aoko.fileKey = paramaool.AO();
  }
  
  private boolean aAc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start uniseq:" + this.h.mUniseq + " src:" + this.h.dQ);
    }
    Object localObject = new CompressInfo(this.h.dQ, 0);
    ((CompressInfo)localObject).picType = 0;
    akyj.b((CompressInfo)localObject);
    if (TextUtils.isEmpty(((CompressInfo)localObject).destPath)) {
      onError();
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start compress dst:" + ((CompressInfo)localObject).destPath);
      }
      if (TextUtils.equals(((CompressInfo)localObject).destPath, ((CompressInfo)localObject).srcPath)) {
        break;
      }
      aoko localaoko = this.jdField_b_of_type_Aoko;
      aool localaool = this.h;
      localObject = ((CompressInfo)localObject).destPath;
      localaool.dQ = ((String)localObject);
      localaoko.filePath = ((String)localObject);
    } while (KH() != 0);
    return false;
  }
  
  private void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    while (!azR()) {
      return;
    }
    diB();
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.resume()");
    }
    bme();
    sendRequest();
    return 0;
  }
  
  public int KH()
  {
    String str = this.h.dQ;
    if (TextUtils.isEmpty(str))
    {
      dN(9302, f(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      dN(9042, f(new Exception("sendFile not exist " + str)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      dN(9070, f(new Exception("sendFile not readable " + this.jdField_b_of_type_Aoko.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.jdField_b_of_type_Aoko.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      dN(9071, f(new Exception("file size 0 " + str)));
      onError();
      return -1;
    }
    return super.KH();
  }
  
  protected long U(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.cMc) {}
    for (paramLong = Math.min(paramLong, this.jdField_b_of_type_Auyc.a(BaseApplication.getContext(), this.mFileSize, this.bz, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  byte[] b(int paramInt1, int paramInt2)
  {
    return super.b(paramInt1, paramInt2);
  }
  
  public void bme()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.app.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
  
  public void diB()
  {
    int i = 21;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    aome localaome = new aome(this, SystemClock.uptimeMillis());
    if ((this.jdField_b_of_type_Aoko.fileType == 8) || (this.jdField_b_of_type_Aoko.fileType == 64)) {
      i = 3;
    }
    for (;;)
    {
      this.jdField_b_of_type_Aoko.commandId = i;
      try
      {
        if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session().length;
          this.de = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getHttpconn_sig_session(), 0, this.de, 0, j);
        }
        if (SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey().length;
          this.fH = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.app.getCurrentAccountUin()).getSessionKey(), 0, this.fH, 0, j);
        }
        if (((this.de == null) || (this.de.length == 0) || (this.fH == null) || (this.fH.length == 0)) && (!TextUtils.isEmpty(this.app.getCurrentAccountUin()))) {
          HwServlet.getConfig(this.app, this.app.getCurrentAccountUin());
        }
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.app.getCurrentAccountUin(), i, this.h.dQ, (int)this.apw, this.bL, localaome, this.jdField_b_of_type_Aoko.fL, false);
        int j = this.app.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
        }
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
          onError();
        }
        return;
      }
      finally {}
      if (this.jdField_b_of_type_Aoko.fileType == 21) {
        i = 6;
      } else if (this.jdField_b_of_type_Aoko.fileType == 22) {
        i = 5;
      } else if (this.jdField_b_of_type_Aoko.fileType == 34) {
        i = 13;
      } else if (this.jdField_b_of_type_Aoko.fileType != 35) {
        if ((this.jdField_b_of_type_Aoko.fileType == 36) || (this.jdField_b_of_type_Aoko.fileType == 37) || (this.jdField_b_of_type_Aoko.fileType == 38))
        {
          i = 23;
        }
        else if ((this.jdField_b_of_type_Aoko.fileType == 39) || (this.jdField_b_of_type_Aoko.fileType == 40) || (this.jdField_b_of_type_Aoko.fileType == 41))
        {
          i = 22;
        }
        else if (this.jdField_b_of_type_Aoko.fileType == 48)
        {
          i = 24;
        }
        else if (this.jdField_b_of_type_Aoko.fileType == 23)
        {
          i = 59;
          Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
          localCommFileExtReq.uint32_action_type.set(0);
          localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.app.getCurrentAccountUin()));
          this.jdField_b_of_type_Aoko.fL = localCommFileExtReq.toByteArray();
        }
        else if ((this.jdField_b_of_type_Aoko.fileType == 50) || (this.jdField_b_of_type_Aoko.fileType == 51))
        {
          i = 35;
        }
        else if (this.jdField_b_of_type_Aoko.fileType == 56)
        {
          i = 39;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {}
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    String str1;
    label100:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      str1 = "";
      if ((this.jdField_b_of_type_Aoko.fileType != 8) && (this.jdField_b_of_type_Aoko.fileType != 64)) {
        break label190;
      }
      str1 = "actNearbyPeoplePicUpload";
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mM;
      if (this.fH != null) {
        break label442;
      }
      str2 = "null";
      label139:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label454;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label190:
      if (this.jdField_b_of_type_Aoko.fileType == 21)
      {
        str1 = "actFreshNewsPicUpload";
        break label100;
      }
      if (this.jdField_b_of_type_Aoko.fileType == 22)
      {
        str1 = "actFriendAvatarUpload";
        break label100;
      }
      if (this.jdField_b_of_type_Aoko.fileType == 34)
      {
        str1 = "C2BUploadFile";
        break label100;
      }
      if (this.jdField_b_of_type_Aoko.fileType == 35)
      {
        str1 = "actProfileCoverPicUpload";
        break label100;
      }
      if ((this.jdField_b_of_type_Aoko.fileType == 36) || (this.jdField_b_of_type_Aoko.fileType == 37) || (this.jdField_b_of_type_Aoko.fileType == 38) || (this.jdField_b_of_type_Aoko.fileType == 48))
      {
        str1 = "actBaseDynamicAvatarUpload";
        break label100;
      }
      if ((this.jdField_b_of_type_Aoko.fileType == 39) || (this.jdField_b_of_type_Aoko.fileType == 40) || (this.jdField_b_of_type_Aoko.fileType == 41))
      {
        str1 = "actNearbyDynamicAvatarUpload";
        break label100;
      }
      if ((this.jdField_b_of_type_Aoko.fileType == 50) || (this.jdField_b_of_type_Aoko.fileType == 51))
      {
        str1 = "actHongbaoStarPhotoUpload";
        break label100;
      }
      if (this.jdField_b_of_type_Aoko.fileType == 56)
      {
        str1 = "actPersonalityLabelPhotoUpload";
        break label100;
      }
      if (this.jdField_b_of_type_Aoko.fileType != 23) {
        break label100;
      }
      str1 = "actExtendFriendSoundUpload";
      break label100;
      label442:
      str2 = aqoj.C(this.fH);
      break label139;
      label454:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, false, l, this.mFileSize, this.mM, "");
    }
  }
  
  protected void e(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.app.countFlow(true, 1, this.jdField_b_of_type_Aoko.fileType, this.h.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.app.countFlow(true, 1, this.jdField_b_of_type_Aoko.fileType, this.h.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.app.countFlow(true, 0, this.jdField_b_of_type_Aoko.fileType, this.h.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.app.countFlow(true, 0, this.jdField_b_of_type_Aoko.fileType, this.h.mUinType, paramLong4);
    }
  }
  
  protected void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramString);
    }
  }
  
  void onError()
  {
    super.onError();
    VR(1005);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onError()---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    }
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = -1;
      locala.errCode = this.errCode;
      locala.errStr = this.errDesc;
      this.h.b.b(locala);
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    super.onResp(paramaomh);
  }
  
  void onSuccess()
  {
    super.onSuccess();
    VR(1003);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = 0;
      this.h.b.b(locala);
    }
  }
  
  public void start()
  {
    super.start();
    VR(1001);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.start()");
    }
    if ((this.jdField_b_of_type_Aoko.fileType == 56) && (aAc())) {
      return;
    }
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return;
    }
    sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomd
 * JD-Core Version:    0.7.0.1
 */