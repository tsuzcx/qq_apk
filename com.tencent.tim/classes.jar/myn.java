import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class myn
{
  public static int aWa;
  public static int aWb = 1;
  public static int aWc = 2;
  public static int aWd = 3;
  public static int aWe = 4;
  public static int aWf = 1;
  public int aWg;
  public int aWh;
  public int aWi;
  public int aWj;
  public int aWk;
  public int hitCount;
  public int mSceneType;
  public int mStrategy;
  
  public myn(int paramInt1, int paramInt2)
  {
    this.mSceneType = paramInt1;
    this.mStrategy = paramInt2;
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_hitCount", String.valueOf(this.hitCount));
    localHashMap.put("param_notHitCount", String.valueOf(this.aWg));
    localHashMap.put("param_triggerCount", String.valueOf(this.aWh));
    localHashMap.put("param_triggerHitCount", String.valueOf(this.aWi));
    localHashMap.put("param_distinctTriggerHitCount", String.valueOf(this.aWj));
    localHashMap.put("param_realTriggerHitCount", String.valueOf(this.aWk));
    localHashMap.put("param_sceneType", String.valueOf(this.mSceneType));
    localHashMap.put("param_strategy", String.valueOf(this.mStrategy));
    if (QLog.isColorLevel()) {
      QLog.i("wgs", 2, "VideoPreloadReportData getReportMap " + localHashMap.toString());
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myn
 * JD-Core Version:    0.7.0.1
 */