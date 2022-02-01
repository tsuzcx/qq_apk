import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class aokp
  implements aqoi
{
  private long apO;
  private QQAppInterface app;
  private String bvk;
  private String clG;
  private String clH;
  private int dPt;
  private int dPu;
  private String filepath;
  private aook m = new aokq(this);
  private String orgUrl;
  private long uniseq;
  
  public aokp(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    this.clG = paramString1;
    this.dPt = paramInt1;
    this.bvk = paramString2;
    this.filepath = paramString3;
    this.clH = paramString5;
    this.app = paramQQAppInterface;
    this.uniseq = paramLong1;
    this.orgUrl = paramString4;
    this.apO = paramLong2;
    this.dPu = paramInt2;
    this.m.addFilter(new Class[] { aojs.class, aojv.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    paramQQAppInterface.a().a(this.m);
  }
  
  private void dVx()
  {
    stopListening();
    this.app.a().oy(this.bvk + this.uniseq);
    Message localMessage = new Message();
    localMessage.what = 1005;
    aoko localaoko = new aoko(this.bvk, this.filepath, 0);
    localaoko.fileType = 1;
    localaoko.uniseq = this.uniseq;
    localMessage.obj = localaoko;
    localMessage.arg1 = 0;
    aojn.a(localMessage, aokp.class, 0L);
    this.app.b().a(this.bvk, this.dPt, this.uniseq, this.orgUrl, this.clH, this.apO, this.dPu);
  }
  
  private void dVy()
  {
    this.app.a().oy(this.bvk + this.uniseq);
    if ((this.dPt == 1) || (this.dPt == 1001) || (this.dPt == 10002) || (this.dPt == 3000))
    {
      if (this.dPt == 1001) {}
      for (long l = AppSetting.bAe;; l = aopb.hn())
      {
        int i = (int)l;
        if (new File(this.filepath).length() > i)
        {
          aqhu.a(-1L, this.dPt, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.filepath = aqhu.c(this.app.getApp().getBaseContext(), this.filepath, i);
        }
        if (aqhu.b(null, this.filepath, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    aool localaool = new aool();
    localaool.mSelfUin = this.app.getAccount();
    localaool.mPeerUin = this.bvk;
    localaool.mUinType = this.dPt;
    localaool.mFileType = 1;
    localaool.mUniseq = this.uniseq;
    localaool.cNy = true;
    localaool.mBusiType = 1009;
    localaool.dQ = this.filepath;
    this.app.a().a(localaool);
  }
  
  public void Hp(String paramString) {}
  
  public void a(aqog paramaqog1, aqog paramaqog2) {}
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return false;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2) {}
  
  public void stopListening()
  {
    this.app.a().b(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokp
 * JD-Core Version:    0.7.0.1
 */