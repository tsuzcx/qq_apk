import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class mra
  extends miu
  implements mqs.b
{
  private String Dh;
  private WeakReference<Context> Y;
  angp.a jdField_a_of_type_Angp$a = new mrd(this);
  ShortVideoResourceManager.c jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$c = new mre(this);
  private mqv jdField_a_of_type_Mqv;
  private String ajB;
  private String ajc;
  private String ajd;
  private String ajy;
  private boolean anf;
  private boolean ang;
  private QQAppInterface app;
  private mqs jdField_b_of_type_Mqs;
  private mqv jdField_b_of_type_Mqv;
  private mqv.a c = new mrb(this);
  private WeakReference<miu.a> cj;
  private mqv.a d = new mrc(this);
  private boolean isCanceled;
  private boolean isPaused;
  public Bundle mBundle;
  private Context mContext;
  private String mImageUrl;
  private long wd;
  private long wr;
  private long ws;
  private long wt;
  private long wu;
  private long wv;
  private long ww;
  private long wx;
  
  public mra(Context paramContext, miu.a parama, Intent paramIntent)
  {
    this.Y = new WeakReference(paramContext);
    this.cj = new WeakReference(parama);
    this.mBundle = paramIntent.getExtras();
    this.mContext = paramContext;
    initData(this.mBundle);
    mit.aC(this.mBundle);
    this.jdField_a_of_type_Mqv = new mqw(paramContext, this.app, this.c);
    this.jdField_b_of_type_Mqv = new mrf(paramContext, this.app, this.d, this.ajc);
  }
  
  private void Q(float paramFloat)
  {
    this.mProgress = (50.0F * (1.0F + paramFloat / 100.0F));
    if ((this.cj != null) && (this.cj.get() != null) && (!this.isCanceled)) {
      ((miu.a)this.cj.get()).e(this.ajb, this.mProgress);
    }
  }
  
  private void R(float paramFloat)
  {
    this.mProgress = (50.0F * paramFloat / 100.0F);
    if ((this.cj != null) && (this.cj.get() != null) && (!this.isCanceled)) {
      ((miu.a)this.cj.get()).e(this.ajb, this.mProgress);
    }
  }
  
  private void a(mqt parammqt)
  {
    this.mBundle.putString("compressPath", this.Dh);
    a(false, this.mContext, this.mBundle, parammqt, (miu.a)this.cj.get());
  }
  
  private void aPv()
  {
    this.anf = VideoEnvironment.p(this.app);
    this.ang = VideoEnvironment.r(this.app);
    if (!this.anf) {}
    do
    {
      return;
      if (this.ang)
      {
        VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
        return;
      }
      VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    } while (!aqiw.isNetworkAvailable(null));
    ShortVideoResourceManager.b(this.app, this.jdField_a_of_type_Angp$a);
  }
  
  private void aRw()
  {
    this.jdField_b_of_type_Mqs = new mqs((Context)this.Y.get(), this.anf, this.ang, this);
    this.jdField_b_of_type_Mqs.execute(new String[] { this.ajc });
    this.wv = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.cj != null) && (this.cj.get() != null)) {
      ((miu.a)this.cj.get()).a(this.ajb, paramInt, mqt.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a(this.ws).b(this.wt).a());
    }
  }
  
  private void initData(Bundle paramBundle)
  {
    this.app = ((QQAppInterface)kxm.getAppRuntime());
    this.ajb = paramBundle.getString("mTaskID");
    this.anf = paramBundle.getBoolean("supportShortVideo", false);
    this.ang = paramBundle.getBoolean("shortVideoSoReady", false);
    if (!this.ang) {
      aPv();
    }
    this.ajc = paramBundle.getString("arg_video_path");
    this.ajd = paramBundle.getString("arg_video_cover");
    paramBundle.putString("mTaskID", this.ajb);
  }
  
  private void rS(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.wd;
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
  
  private void sn(int paramInt)
  {
    QLog.d("VideoDeliverController", 1, "transitState: from " + this.aTq + " to " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.aTq = paramInt;
      return;
      this.jdField_a_of_type_Mqv.ah(this.ajd, true);
      continue;
      R(100.0F);
      if (!this.isCanceled)
      {
        this.jdField_b_of_type_Mqv.ah(this.Dh, true);
        continue;
        Q(100.0F);
      }
    }
  }
  
  public void O(float paramFloat)
  {
    R(paramFloat);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.wu = NetConnInfoCenter.getServerTimeMillis();
      this.wr = paramLong1;
      this.ws = paramLong2;
      this.wt = paramLong3;
      return;
      sm(1);
      continue;
      sm(2);
      continue;
      sm(3);
      rS(1003);
      continue;
      sm(4);
      rS(1005);
      continue;
      this.Dh = paramString1;
      this.ajy = paramString2;
      sn(2);
    }
  }
  
  public void aPf()
  {
    this.wc = System.currentTimeMillis();
    this.isCanceled = false;
    this.isPaused = false;
    aRw();
    sn(1);
    this.wd = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void aPg()
  {
    this.jdField_a_of_type_Mqv.onDestroy();
    this.jdField_b_of_type_Mqv.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mra
 * JD-Core Version:    0.7.0.1
 */