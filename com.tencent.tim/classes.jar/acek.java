import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class acek
{
  private boolean bHm;
  private List<acek.a> callbacks = new ArrayList();
  
  public static acek a()
  {
    return acek.b.b();
  }
  
  public void a(acek.a parama)
  {
    try
    {
      this.callbacks.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void b(acek.a parama)
  {
    try
    {
      this.callbacks.remove(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public List<acek.a> dT()
  {
    try
    {
      List localList = this.callbacks;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onAppBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    rwv.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    oop.a().bfT();
    aiur.onAppBackground();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((acek.a)localIterator.next()).onAppBackground();
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (swu.DI <= 0L)
    {
      swu.DI = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(swu.DI) });
    }
    aiur.onAppForeground();
    if ((TextUtils.equals("com.tencent.mobileqq:qzone", paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("mini")))) {
      if (!this.bHm) {
        this.bHm = true;
      }
    }
    for (;;)
    {
      QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
      paramString = this.callbacks.iterator();
      while (paramString.hasNext()) {
        ((acek.a)paramString.next()).onAppForeground();
      }
      paramString = new ForeBackgroundEvent(false);
      rwv.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      rwv.a().a(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAppBackground();
    
    public abstract void onAppForeground();
  }
  
  static class b
  {
    private static final acek a = new acek(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acek
 * JD-Core Version:    0.7.0.1
 */