import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class mqy
  extends miu
{
  private WeakReference<Context> Y;
  aool a;
  private String ajB;
  private String ajc;
  private String ajd;
  private QQAppInterface app;
  aook c = new mqz(this);
  private WeakReference<miu.a> cj;
  public Bundle mBundle;
  private Context mContext;
  private String mImagePath;
  private String mImageUrl;
  
  public mqy(Context paramContext, miu.a parama, Intent paramIntent)
  {
    this.cj = new WeakReference(parama);
    this.Y = new WeakReference(paramContext);
    this.app = ((QQAppInterface)kxm.getAppRuntime());
    this.mBundle = paramIntent.getExtras();
    this.mContext = paramContext;
    initData();
    mit.aC(this.mBundle);
  }
  
  private void P(float paramFloat)
  {
    this.mProgress = paramFloat;
    if ((this.cj != null) && (this.cj.get() != null)) {
      ((miu.a)this.cj.get()).e(this.ajb, paramFloat);
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = mqt.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a();
    if (paramInt == 0) {
      a(true, this.mContext, this.mBundle, paramString1, (miu.a)this.cj.get());
    }
    if ((this.cj != null) && (this.cj.get() != null)) {
      ((miu.a)this.cj.get()).a(this.ajb, paramInt, paramString1);
    }
  }
  
  private void initData()
  {
    this.ajc = this.mBundle.getString("arg_video_path");
    this.ajd = this.mBundle.getString("arg_video_cover");
    this.ajb = this.mBundle.getString("mTaskID");
  }
  
  private void rS(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.wc;
    anpc localanpc = anpc.a((Context)this.Y.get());
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void sm(int paramInt)
  {
    b(paramInt, null, null, null, null, null);
  }
  
  public void aPf()
  {
    mw(this.ajd);
    this.wc = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void aPg()
  {
    mit.delete(this.mImagePath);
  }
  
  public void mw(String paramString)
  {
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic path=" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic empty path!");
      sm(10);
      return;
    }
    if (!new File(paramString).exists())
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic file not exist, path=" + paramString);
      sm(5);
      return;
    }
    if (!jqi.isNetworkAvailable((Context)this.Y.get()))
    {
      sm(1003);
      return;
    }
    this.mImagePath = "";
    this.ajB = "";
    this.mImageUrl = "";
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.picType = 0;
    if (!akyj.b(localCompressInfo)) {
      rS(1001);
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic compressPath=" + localCompressInfo.destPath + ", originPath=" + paramString + ", outWidth=" + localCompressInfo.dpx + ", outHeight=" + localCompressInfo.dpy);
    if (TextUtils.isEmpty(localCompressInfo.destPath)) {}
    for (;;)
    {
      this.mImagePath = paramString;
      paramString = this.app.a();
      this.c.addFilter(new Class[] { aojg.class });
      paramString.a(this.c);
      this.a = new aool();
      this.a.cNy = true;
      this.a.dOM = 10;
      this.a.dQ = this.mImagePath;
      this.a.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.a.mPeerUin = "0";
      this.a.mFileType = 24;
      this.a.ckW = "KandianUGCPicUpload";
      paramString.a(this.a);
      return;
      paramString = localCompressInfo.destPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */