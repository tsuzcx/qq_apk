import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class lvi
{
  private static volatile lvi a;
  private static String afY;
  private final String afZ = "4044";
  private final String aga = "readinjoy_pts_jsc";
  private final String agb = "libjsc.so";
  private final String agc = "pts_jsc_config.json";
  private final String agd = jpe.dO("4044") + "4044";
  private final String age = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_jsc";
  private volatile boolean alA;
  
  private boolean CL()
  {
    Object localObject = this.age + "/" + "pts_jsc_config.json";
    boolean bool1 = aqhq.fileExists(this.age + "/" + "libjsc.so");
    boolean bool2 = lvk.dO((String)localObject);
    afY = lvk.eN((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSJSCIsValid]").append("\n").append(", ptsJSCVersion = ").append(afY).append("\n").append(", isJSCSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  public static lvi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lvi();
      }
      return a;
    }
    finally {}
  }
  
  private void aNH()
  {
    ThreadManager.excute(new PTSJSCLoader.3(this), 128, null, true);
  }
  
  private void aNI()
  {
    try
    {
      ThreadManager.excute(new PTSJSCLoader.4(this), 64, null, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean CK()
  {
    return this.alA;
  }
  
  public void H(Runnable paramRunnable)
  {
    if (CK())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (paramRunnable != null) {
        ThreadManager.getFileThreadHandler().post(paramRunnable);
      }
      return;
    }
    if (CL())
    {
      paramRunnable = new PTSJSCLoader.2(this, paramRunnable);
      ThreadManager.getFileThreadHandler().post(paramRunnable);
      return;
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], pts jsc is not valid, load jsc so failed.");
    aNI();
  }
  
  public void init()
  {
    try
    {
      this.alA = false;
      PTSJSCLoader.1 local1 = new PTSJSCLoader.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvi
 * JD-Core Version:    0.7.0.1
 */