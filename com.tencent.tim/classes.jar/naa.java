import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class naa
{
  private static naa a;
  
  public static naa a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new naa();
      }
      return a;
    }
    finally {}
  }
  
  private int aO(String paramString)
  {
    return Math.round(((Float)awit.f(eW(paramString), Float.valueOf(0.0F))).floatValue());
  }
  
  private boolean dZ(String paramString)
  {
    return Aladdin.getConfig(298).getIntegerFromString(paramString, 0) == 1;
  }
  
  private String eW(String paramString)
  {
    return paramString + "_watch_length";
  }
  
  public void aO(String paramString, int paramInt)
  {
    float f = ((Float)awit.f(eW(paramString), Float.valueOf(0.0F))).floatValue();
    if (f > 0.0F) {}
    for (f = f * 0.5F + paramInt * 0.5F;; f = paramInt)
    {
      awit.H(paramString + "_watch_length", Float.valueOf(f));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPreloadStrategyConoller", 2, "reoprt: currentPredition=" + f);
      }
      return;
    }
  }
  
  public boolean b(myi parammyi)
  {
    int j = 0;
    int i = j;
    if (parammyi != null)
    {
      i = j;
      if (parammyi.getDuration() > 0L) {
        i = parammyi.aVY;
      }
    }
    return dX(i);
  }
  
  public boolean dX(int paramInt)
  {
    long l1 = mzs.a().getCurrentPrediction();
    float f = Aladdin.getConfig(298).getFloatFromString("bitrate_weight", 2.0F);
    int i = Aladdin.getConfig(298).getIntegerFromString("idle_bandwith_threshold", 1500);
    long l2 = ((float)l1 - paramInt / 8 * f);
    if (QLog.isColorLevel()) {
      QLog.d("VideoPreloadStrategyConoller", 2, "checkPreloadEnable: bandwidth=" + l1 + ", birate=" + paramInt + ", weight=" + f + ", idleBandwidth=" + l2 + ", idleThreshold=" + i + ", enable=" + dZ("idle_preload_limit_enable"));
    }
    if ((l1 <= 50L) || (paramInt <= 0) || (!dZ("idle_preload_limit_enable"))) {
      return aqiw.isWifiConnected(BaseApplicationImpl.getContext());
    }
    return l2 > i;
  }
  
  public int qj()
  {
    return 1;
  }
  
  public int t(String paramString, int paramInt)
  {
    int k = aO(paramString);
    int j = Aladdin.getConfig(298).getIntegerFromString("default_predownload_count", 4);
    int m = Aladdin.getConfig(298).getIntegerFromString("max_predownload_count", 4);
    if (QLog.isColorLevel()) {
      QLog.d("VideoPreloadStrategyConoller", 2, "getForwardPredownloadCount: enable:true, prediction=" + k + ", curPosition=" + paramInt + ", maxPreloadCount = " + m + ", defaultPreloadCount=" + j);
    }
    int i = j;
    if (k > paramInt)
    {
      i = j;
      if (dZ("watch_length_predict_enable")) {
        i = Math.min(k - paramInt, m);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     naa
 * JD-Core Version:    0.7.0.1
 */