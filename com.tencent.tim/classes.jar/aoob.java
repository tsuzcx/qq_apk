import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.ReqStoryPic;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StoryUploadProcessor.2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;

public class aoob
  extends aojr
{
  public static String TAG = "Q.qqstory.publish.upload.StoryUploadProcessor";
  private Transaction a;
  private long aqn;
  private long aqo;
  public String clS;
  private byte[] de;
  private byte[] fH;
  private String mTag = "Q.qqstory.publish.upload";
  public String mVid;
  public String mVideoUrl;
  
  public aoob(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Aoko.a = this;
    this.jdField_b_of_type_Aoko.fL = paramaool.gb;
    this.aqn = System.currentTimeMillis();
    TAG = this.mTag + ".StoryUploadProcessor";
  }
  
  private String AN()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(rox.dY()), Boolean.valueOf(aqhq.fileExists(plr.atc)) });
  }
  
  public static void dWj()
  {
    Bosses.get().postLightWeightJob(new StoryUploadProcessor.2(), 0);
  }
  
  private int eH(String paramString)
  {
    String str = rox.gl(paramString);
    long l1 = 0L;
    try
    {
      l2 = Long.valueOf(str.substring(0, str.indexOf("_"))).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ram.e(TAG, "exception", localException);
      }
      if (l1 <= 0L) {
        break label173;
      }
      long l2 = (System.currentTimeMillis() - l1) / 24L / 60L / 60L / 1000L;
      l1 = l2;
      if (l2 <= 30L) {
        break label166;
      }
      l1 = 30L;
      return (int)(l1 + 999000L);
    }
    l2 = rox.O(plr.atc);
    ram.e(TAG, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 == 0L) || ((l1 > 0L) && (l2 > l1)))
    {
      ram.e(TAG, "your file delete by software %s", new Object[] { paramString });
      return 940017;
    }
    label166:
    label173:
    return 9071;
  }
  
  public static int jD(int paramInt)
  {
    return 95000000 + paramInt;
  }
  
  public int EN()
  {
    bme();
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
      dN(eH(str), AN() + "sendFile not exist " + str);
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
    ram.b(TAG, "upload file size %d, file %s", Long.valueOf(this.mFileSize), str);
    if (l <= 0L)
    {
      dN(eH(str), AN() + "sendFile size empty " + str);
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
    ram.w(TAG, "send file %s", new Object[] { this.h.dQ });
    this.jdField_b_of_type_Aojn$a.dVf();
    aooc localaooc = new aooc(this, SystemClock.uptimeMillis());
    int i = -1;
    if (this.jdField_b_of_type_Aoko.fileType == 196610)
    {
      i = 34;
      qqstory_bhd_upload_pic.ReqStoryPic localReqStoryPic = new qqstory_bhd_upload_pic.ReqStoryPic();
      localReqStoryPic.platform.set(2);
      localReqStoryPic.tojpg.set(0);
      localReqStoryPic.version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
      this.jdField_b_of_type_Aoko.fL = localReqStoryPic.toByteArray();
    }
    for (;;)
    {
      this.jdField_b_of_type_Aoko.commandId = i;
      try
      {
        if (SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session().length;
          this.de = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session(), 0, this.de, 0, j);
        }
        if (SessionInfo.getInstance(this.h.mSelfUin).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.h.mSelfUin).getSessionKey().length;
          this.fH = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getSessionKey(), 0, this.fH, 0, j);
        }
        if ((this.de == null) || (this.de.length == 0) || (this.fH == null) || (this.fH.length == 0)) {
          HwServlet.getConfig(this.app, this.h.mSelfUin);
        }
        this.a = new Transaction(this.app.getCurrentAccountUin(), i, this.h.dQ, (int)this.apw, this.bL, localaooc, this.jdField_b_of_type_Aoko.fL, false);
        this.a.setVideoSegmentMode(true);
        int j = this.app.getHwEngine().submitTransactionTask(this.a);
        ram.i(TAG, "Transaction submit RetCode:" + j + " T_ID:" + this.a.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.a.filePath + " Cmd:" + i);
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
          onError();
        }
        return;
      }
      finally {}
      if (this.jdField_b_of_type_Aoko.fileType == 196609) {
        i = 37;
      } else if (this.jdField_b_of_type_Aoko.fileType == 327681) {
        i = 57;
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {
      break label14;
    }
    label14:
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    label59:
    String str;
    label84:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      if (this.jdField_b_of_type_Aoko.fileType != 196610) {
        break label228;
      }
      str = "actStoryPicUpload";
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mM.put("param_sessionKey", "null");
      if (!paramBoolean) {
        break label301;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, true, l, this.mFileSize, this.mM, "");
      if (this.jdField_b_of_type_Aoko.fileType != 196609) {
        break label249;
      }
      rar.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.aqo), rar.getNetworkType(BaseApplication.getContext()), this.mVideoUrl });
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break label59;
      label228:
      if (this.jdField_b_of_type_Aoko.fileType != 196609) {
        break;
      }
      str = "actStoryVideoUpload";
      break label84;
      label249:
      rar.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.aqo), rar.getNetworkType(BaseApplication.getContext()) });
      continue;
      label301:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, false, l, this.mFileSize, this.mM, "");
      if (this.jdField_b_of_type_Aoko.fileType == 196609) {
        rar.b("publish_story", "publish_video", 0, jD(this.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.aqo), rar.getNetworkType(BaseApplication.getContext()), this.errDesc });
      } else {
        rar.b("publish_story", "publish_thumbnail", 0, jD(this.errCode), new String[] { String.valueOf(this.mFileSize), String.valueOf(this.mEndTime - this.aqo), rar.getNetworkType(BaseApplication.getContext()), this.errDesc });
      }
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
  
  void onError()
  {
    super.onError();
    VR(1005);
    ram.w(TAG, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.errCode), this.errDesc, this.h.dQ });
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = -1;
      locala.errCode = jD(this.errCode);
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
    ram.w(TAG, "success path:%s", new Object[] { this.h.dQ });
    akyf.a locala;
    if (this.h.b != null)
    {
      locala = new akyf.a();
      locala.result = 0;
      if (this.jdField_b_of_type_Aoko.fileType != 196610) {
        break label92;
      }
    }
    for (locala.path = this.clS;; locala.path = this.mVideoUrl)
    {
      this.h.b.b(locala);
      return;
      label92:
      locala.uuid = this.mVid;
    }
  }
  
  public void start()
  {
    super.start();
    ram.w(TAG, "start upload %s", new Object[] { this.h.dQ });
    if ((this.bL == null) && (!azT()))
    {
      dN(940006, "make md5 fail");
      onError();
      return;
    }
    if (!rpc.hasInternet(QQStoryContext.a().getApplication()))
    {
      dN(880001, "no network");
      onError();
      return;
    }
    diB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoob
 * JD-Core Version:    0.7.0.1
 */