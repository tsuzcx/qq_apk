import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class anpf
{
  public static anpf a = new anpf("qzone");
  private String TAG;
  public Map<String, Boolean> nl = new ConcurrentHashMap();
  public Map<String, Boolean> nm = new ConcurrentHashMap();
  
  public anpf(String paramString)
  {
    this.TAG = ("StatisticHitRateCollector_" + paramString);
  }
  
  public static anpf a()
  {
    return a;
  }
  
  public static String getUin()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public void Rd(String paramString)
  {
    hA(paramString, "actQZLoadHitRateRed");
  }
  
  public void Re(String paramString)
  {
    hA(paramString, "actQZLoadHitRateLeba");
  }
  
  public void Rf(String paramString)
  {
    hA(paramString, "actQZLoadHitRateProfile");
  }
  
  public void Rg(String paramString)
  {
    Iterator localIterator = new ArrayList(this.nm.keySet()).iterator();
    while (localIterator.hasNext()) {
      hB(paramString, (String)localIterator.next());
    }
  }
  
  public void cS(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "preloadMark preloadAction = " + paramString + " , flag = " + paramBoolean);
    }
    if (paramBoolean) {
      hB(getUin(), paramString);
    }
    this.nl.put(paramString, Boolean.valueOf(false));
    this.nm.put(paramString, Boolean.valueOf(true));
  }
  
  public void hA(String paramString1, String paramString2)
  {
    Boolean localBoolean = (Boolean)this.nl.get(paramString2);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localBoolean = (Boolean)this.nm.get(paramString2);
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        this.nl.put(paramString2, Boolean.valueOf(true));
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "hitEnd sucess action = " + paramString2 + " , hit = true, uin = " + paramString1);
        }
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, null, null);
        this.nl.remove(paramString2);
        this.nm.remove(paramString2);
      }
    }
  }
  
  public void hB(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Boolean localBoolean = (Boolean)this.nl.get(paramString2);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        localBoolean = (Boolean)this.nm.get(paramString2);
        if ((localBoolean != null) && (localBoolean.booleanValue()))
        {
          this.nl.put(paramString2, Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "hitEnd action = " + paramString2 + " , hit = false, uin = " + paramString1);
          }
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramString2, false, 0L, 0L, null, null);
          this.nl.remove(paramString2);
          this.nm.remove(paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpf
 * JD-Core Version:    0.7.0.1
 */