import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ahyj
{
  public String bMq;
  protected boolean cgg;
  public boolean isHit;
  public HashMap<String, String> mHashMap = new HashMap();
  public String processName;
  public String sessionType;
  
  public ahyj(String paramString1, String paramString2)
  {
    this("default", paramString1, paramString2);
  }
  
  protected ahyj(String paramString1, String paramString2, String paramString3)
  {
    this.sessionType = paramString1;
    this.bMq = paramString2;
    this.processName = paramString3;
    reset();
  }
  
  public static boolean isProcessExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public void begin()
  {
    if (this.cgg) {
      end();
    }
    ahyg.a(this);
    this.cgg = true;
    if (!(this instanceof ahyi)) {
      ahyg.KR(this.processName);
    }
  }
  
  public void dqV()
  {
    if (!this.cgg) {}
    do
    {
      return;
      this.isHit = true;
    } while ((this instanceof ahyi));
    ahyg.KQ(this.processName);
  }
  
  public void end()
  {
    if (!this.cgg) {
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication();
    HashMap localHashMap1 = new HashMap();
    for (;;)
    {
      String str;
      synchronized (this.mHashMap)
      {
        localHashMap1.putAll(this.mHashMap);
        if (localObject2 != null)
        {
          ??? = ((BaseApplicationImpl)localObject2).getApplicationContext();
          localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
          if (localObject2 != null)
          {
            localObject2 = ((AppRuntime)localObject2).getAccount();
            str = this.bMq;
            if (!this.isHit) {
              break label98;
            }
            anpc.a((Context)???).collectPerformance((String)localObject2, str, true, 0L, 0L, localHashMap1, null);
          }
        }
        reset();
        return;
      }
      label98:
      anpc.a((Context)???).collectPerformance((String)localObject2, str, false, 0L, 0L, localHashMap2, null);
    }
  }
  
  protected String getKey()
  {
    return this.processName + this.sessionType;
  }
  
  void reset()
  {
    synchronized (this.mHashMap)
    {
      this.mHashMap.put("loss", "0");
      this.mHashMap.put("benefit", "0");
      this.cgg = false;
      this.isHit = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahyj
 * JD-Core Version:    0.7.0.1
 */