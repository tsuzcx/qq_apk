import android.net.Uri;
import android.os.Build;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aamq
  implements qmc.b, qmc.c, qmc.d, qmc.e
{
  private static final String[] dh = { "N1T", "ZTE A2015", "MI 1S", "GT-S7568I", "ZTE N909" };
  private static final String[] di = { "SM-A7000", "HM NOTE 1S", "MI 2S" };
  private static final String[] dj = { "vivo X6D" };
  private static final String[] dk = { "MI 4" };
  private static final String[] dl = { "Nexus 5" };
  private static final String[] dm = { "Nexus 5" };
  private static final String[] dn = { "OPPO R7sm" };
  private aamq.a a;
  private TextureVideoView b;
  private volatile boolean bwm;
  private MqqHandler m;
  private BaseActivity mContext;
  private int mCurrentPosition;
  private boolean mIsPaused;
  private Uri mUri;
  private long startTime;
  
  private void handleError()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "handleError");
    }
    if (this.a != null) {
      this.a.cvr();
    }
  }
  
  public static boolean i(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "isNotSupportLoopVideo model=" + str);
    }
    boolean bool1 = bool2;
    int j;
    int i;
    if (str != null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a(qmc paramqmc)
  {
    if (this.mContext.app != null) {
      this.mContext.app.cKW();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onPrepared has been called. talkback=" + AppSetting.enableTalkBack + " videoPrepareTime=" + (System.currentTimeMillis() - this.startTime));
    }
  }
  
  public boolean a(qmc paramqmc, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "onInfo what===>" + paramInt1);
      }
      if (i(dm)) {
        this.m.sendEmptyMessage(103);
      }
    }
    return false;
  }
  
  public void b(qmc paramqmc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onCompletion has been called.   at " + paramqmc.getCurrentPosition() + " mIsPause" + this.mIsPaused);
    }
    this.mCurrentPosition = paramqmc.getCurrentPosition();
    if (!this.mIsPaused)
    {
      paramqmc.start();
      paramqmc.setLooping(true);
    }
    if ((i(dj)) && (!this.mIsPaused))
    {
      this.b.setVideoURI(this.mUri);
      this.b.start();
    }
  }
  
  public boolean b(qmc paramqmc, int paramInt1, int paramInt2)
  {
    paramqmc = new StringBuilder(64);
    paramqmc.append("bgVideo error-- what=");
    paramqmc.append(paramInt1);
    paramqmc.append(" extra=");
    paramqmc.append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramqmc.toString());
    }
    handleError();
    paramqmc = Build.MODEL;
    if (paramqmc != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("crashModel", paramqmc);
      anpc.a(this.mContext.getApplicationContext()).collectPerformance(null, "newHandGuide_error", true, 0L, 0L, localHashMap, "", false);
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void cvr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamq
 * JD-Core Version:    0.7.0.1
 */