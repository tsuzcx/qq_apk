import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.2;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class lvg
{
  private static volatile lvg a;
  private static String afR;
  private final String afS = "3980";
  private final String afT = "readinjoy_pts_engine";
  private final String afU = "libpts.so";
  private final String afV = "pts_config.json";
  private final String afW = jpe.dO("3980") + "3980";
  private final String afX = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_engine";
  public final boolean alz = false;
  private volatile boolean hasLoaded;
  
  private boolean CI()
  {
    Object localObject = this.afX + "/" + "libpts.so";
    String str = this.afX + "/" + "pts_config.json";
    boolean bool1 = aqhq.fileExists((String)localObject);
    boolean bool2 = lvk.dO(str);
    afR = lvk.eN(str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSEngineIsValid]").append("\n").append(", ptsEngineVersion = ").append(afR).append("\n").append(", isSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  private boolean CJ()
  {
    return false;
  }
  
  public static lvg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lvg();
      }
      return a;
    }
    finally {}
  }
  
  private void aNE()
  {
    ThreadManager.excute(new PTSEngineLoader.3(this), 128, null, true);
  }
  
  private void aNF()
  {
    ThreadManager.excute(new PTSEngineLoader.4(this), 64, null, false);
  }
  
  private void aNG()
  {
    if (CJ()) {
      return;
    }
    if (BJ())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts engine is ready, do not load again.");
      return;
    }
    if (CI())
    {
      PTSEngineLoader.5 local5 = new PTSEngineLoader.5(this);
      lvi.a().H(local5);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], inner dir is not valid, load pts engine failed.");
    aNF();
  }
  
  public boolean BJ()
  {
    return this.hasLoaded;
  }
  
  public void aND()
  {
    PTSEngineLoader.1 local1 = new PTSEngineLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public void init()
  {
    try
    {
      this.hasLoaded = false;
      PTSEngineLoader.2 local2 = new PTSEngineLoader.2(this);
      ThreadManager.getFileThreadHandler().post(local2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String jz()
  {
    return afR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvg
 * JD-Core Version:    0.7.0.1
 */