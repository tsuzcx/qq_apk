import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class apuk
  implements Manager
{
  QQAppInterface mApp = null;
  protected Handler mUiHandler;
  public Map<String, Integer> nS = new ConcurrentHashMap();
  
  public apuk(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mUiHandler = new Handler(Looper.getMainLooper());
    ebT();
  }
  
  public void TY(String paramString)
  {
    if (eV(paramString) == 1)
    {
      this.nS.put(paramString, Integer.valueOf(2));
      ebS();
    }
  }
  
  public int eV(String paramString)
  {
    paramString = (Integer)this.nS.get(String.valueOf(paramString));
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void ebS()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.nS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Integer)this.nS.get(str)).intValue() == 1) {
        ((StringBuilder)localObject).append(str).append(";");
      }
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1).toString();
      aqfe.J(this.mApp.getApp(), "TroopVideoNotify", (String)localObject);
      return;
    }
    aqfe.J(this.mApp.getApp(), "TroopVideoNotify", "");
  }
  
  public void ebT()
  {
    Object localObject = aqfe.get(this.mApp.getApp(), "TroopVideoNotify");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          this.nS.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
  }
  
  public void lT(long paramLong)
  {
    int j = 0;
    Integer localInteger = (Integer)this.nS.get(String.valueOf(paramLong));
    if (localInteger != null) {}
    for (int i = localInteger.intValue();; i = 0)
    {
      boolean bool = this.mApp.a().au(paramLong);
      if ((bool) && (i == 0)) {
        j = 1;
      }
      for (;;)
      {
        this.nS.put(String.valueOf(paramLong), Integer.valueOf(j));
        if (j != i) {
          ebS();
        }
        return;
        if (bool) {
          j = i;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuk
 * JD-Core Version:    0.7.0.1
 */