import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class aone
  extends aojr
{
  private Transaction a;
  achq e = new aong(this);
  private byte[] fH;
  private byte[] fY;
  QQAppInterface mApp = (QQAppInterface)this.app;
  private String mPicUrl = "";
  
  public aone(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Aoko.a = this;
    this.jdField_b_of_type_Aoko.fL = paramaool.gb;
  }
  
  private void dDP()
  {
    if (!azR())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.dPg);
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)this.h.F;
    if (localMessageForScribble != null)
    {
      localMessageForScribble.combineFileUrl = this.mPicUrl;
      if (QLog.isColorLevel())
      {
        QLog.d("ScribblePicUploadProcessor", 2, "mPicUrl: " + this.mPicUrl);
        QLog.d("ScribblePicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
      }
      this.c.dVf();
      this.mApp.b().b(localMessageForScribble, this.e);
      QLog.i("SCRIBBLEMSG", 2, "!!!sendMessage uniseq:" + localMessageForScribble.uniseq);
      return;
    }
    a(-1, "MessageForScribble IS NULL", "", this.jdField_b_of_type_Aojn$a);
    onError();
  }
  
  private void dWd()
  {
    try
    {
      if (SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session().length;
        this.fH = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session(), 0, this.fH, 0, i);
      }
      if (this.fH == null) {
        HwServlet.getConfig(this.app, this.h.mSelfUin);
      }
      return;
    }
    finally {}
  }
  
  private void f(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.mApp.b().c(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor.resume()");
    }
    bme();
    diB();
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
    if (this.a != null) {
      this.app.getHwEngine().cancelTransactionTask(this.a);
    }
  }
  
  public void diB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    Object localObject = new aonf(this, SystemClock.uptimeMillis());
    this.jdField_b_of_type_Aoko.commandId = 41;
    this.a = new Transaction(this.app.getCurrentAccountUin(), this.jdField_b_of_type_Aoko.commandId, this.h.dQ, (int)this.apw, this.fH, this.bL, (ITransactionCallback)localObject, this.jdField_b_of_type_Aoko.fL);
    int i = this.app.getHwEngine().submitTransactionTask(this.a);
    localObject = HexUtil.bytes2HexStr(this.bL);
    String str = HexUtil.bytes2HexStr(this.fY);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.a.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD51:" + (String)localObject + " MD52:" + str + " uuid:" + this.mUuid + " Path:" + this.a.filePath + " Cmd:" + this.jdField_b_of_type_Aoko.commandId);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
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
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mM;
      if (this.fH != null) {
        break label156;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label168;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label156:
      str = aqoj.C(this.fH);
      break label105;
      label168:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", false, l, this.mFileSize, this.mM, "");
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
      QLog.i("ScribblePicUploadProcessor", 2, paramString);
    }
  }
  
  void onError()
  {
    super.onError();
    VR(1005);
    Object localObject = (MessageForScribble)this.h.F;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 2;
    }
    f((MessageForScribble)localObject);
    QLog.e("ScribblePicUploadProcessor", 2, "onError()---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    if (this.h.b != null)
    {
      localObject = new akyf.a();
      ((akyf.a)localObject).result = -1;
      ((akyf.a)localObject).errCode = this.errCode;
      ((akyf.a)localObject).errStr = this.errDesc;
      this.h.b.b((akyf.a)localObject);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    VR(1003);
    Object localObject = (MessageForScribble)this.h.F;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 1;
    }
    f((MessageForScribble)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "onSuccess().");
    }
    if (this.h.b != null)
    {
      localObject = new akyf.a();
      ((akyf.a)localObject).result = 0;
      this.h.b.b((akyf.a)localObject);
    }
  }
  
  public void start()
  {
    this.mPicUrl = "";
    super.start();
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScriblePicUploadProcessor.start()");
    }
    dWd();
    MessageForScribble localMessageForScribble = (MessageForScribble)this.h.F;
    if (this.bL == null)
    {
      this.fY = HexUtil.hexStr2Bytes(localMessageForScribble.combineFileMd5);
      if (!azT())
      {
        onError();
        return;
      }
      localMessageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.bL);
    }
    if (this.fH != null)
    {
      diB();
      return;
    }
    QLog.e("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor get null BDHsession key.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aone
 * JD-Core Version:    0.7.0.1
 */