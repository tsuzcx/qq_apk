import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class zrt
{
  static String baK = aqmj.bo(BaseApplication.getContext());
  static String[] cX;
  Context Q;
  private String TAG = "MediaPlayHelperUI";
  ztn a;
  long ap;
  xuh b;
  private String baJ = "MediaPlayHelper";
  private boolean bsQ = true;
  private boolean bsR = true;
  private boolean bsS = true;
  boolean bsT;
  private int ceI;
  int ceJ = 0;
  int ceK = 1;
  Handler cg;
  private int mStatus = -1;
  private PowerManager.WakeLock mWakeLock;
  
  static
  {
    if ((baK != null) && (baK.length() > 0)) {
      cX = baK.split("\\|");
    }
  }
  
  private boolean VK()
  {
    return true;
  }
  
  public void V(String paramString, long paramLong) {}
  
  public boolean VL()
  {
    return false;
  }
  
  public View a(Context paramContext, Handler paramHandler, ztn paramztn, xuh paramxuh)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "#onCreateVideoSdkView  ");
    }
    this.Q = paramContext;
    this.cg = paramHandler;
    this.a = paramztn;
    this.b = paramxuh;
    this.ap = paramztn.ap;
    if ((this.mWakeLock == null) && (this.Q != null))
    {
      this.mWakeLock = ((PowerManager)this.Q.getSystemService("power")).newWakeLock(536870922, this.TAG);
      this.mWakeLock.setReferenceCounted(false);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "init mWakeLock");
      }
    }
    paramHandler = localObject;
    try
    {
      if (VK()) {
        paramHandler = m(paramContext);
      }
      return paramHandler;
    }
    catch (Exception paramContext)
    {
      paramHandler = new HashMap();
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "previewVideoViewCreateSuc", false, 0L, 0L, paramHandler, null);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext) {}
  
  public void azR()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, " releaseMediaPlayer");
    }
    if (this.mWakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " releaseMediaPlayer, mWakeLock.release()");
      }
      this.mWakeLock.release();
    }
    this.Q = null;
    this.a = null;
    if (this.cg != null) {
      this.cg.removeCallbacksAndMessages(null);
    }
    this.cg = null;
  }
  
  public void crv()
  {
    this.bsT = true;
  }
  
  public void crw() {}
  
  public long eE()
  {
    return this.ceI;
  }
  
  public long eF()
  {
    return this.ap;
  }
  
  public long getDuration()
  {
    return 0L;
  }
  
  public long getProgress()
  {
    return 0L;
  }
  
  public View m(Context paramContext)
  {
    return null;
  }
  
  public void pause() {}
  
  public void pauseDownload() {}
  
  public void seek(int paramInt)
  {
    this.ceJ += 1;
  }
  
  public void setDownloadNetworkChange(int paramInt) {}
  
  public void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrt
 * JD-Core Version:    0.7.0.1
 */