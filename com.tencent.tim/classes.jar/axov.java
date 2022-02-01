import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class axov
{
  public final axon[] a = new axon[20];
  private final HashMap<Integer, Object> rm = new HashMap();
  
  public static axon a(int paramInt)
  {
    return axov.a.a.c(paramInt);
  }
  
  public static axov a()
  {
    return axov.a.a;
  }
  
  private void a(int paramInt, axon paramaxon)
  {
    this.a[paramInt] = paramaxon;
  }
  
  private boolean aPp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static axon b(int paramInt)
  {
    return axov.a.a.a[paramInt];
  }
  
  public static AppInterface d()
  {
    return (AppInterface)f();
  }
  
  public static AppRuntime f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  public axon c(int paramInt)
  {
    ??? = this.a[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.a)
      {
        if (!this.rm.containsKey(Integer.valueOf(paramInt))) {
          this.rm.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.rm.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.a[paramInt];
      if (localObject4 != null)
      {
        return localObject4;
        localObject5 = finally;
        throw localObject5;
      }
      if (!aPp()) {
        throw new RuntimeException("invalid process");
      }
    }
    finally {}
    Object localObject3 = localObject5;
    switch (paramInt)
    {
    default: 
      localObject3 = localObject5;
    }
    for (;;)
    {
      a(paramInt, (axon)localObject3);
      if (localObject3 != null)
      {
        ((axon)localObject3).onInit();
        ram.d("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new axtd();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new ayzs();
      continue;
      localObject3 = new axsu();
      continue;
      localObject3 = new axpr();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new axph();
      continue;
      localObject3 = new axro();
      continue;
      localObject3 = new axsf();
      continue;
      localObject3 = new axsz();
      continue;
      localObject3 = new awrz();
      continue;
      localObject3 = new axtq();
      continue;
      localObject3 = new axpx();
      continue;
      localObject3 = new ayci();
      continue;
      localObject3 = new axbr();
      continue;
      localObject3 = new axgs();
    }
  }
  
  public void destroy()
  {
    int i = 0;
    while (i < this.a.length)
    {
      axon localaxon = this.a[i];
      ram.d("QIMManager", "destroy manager : %s", localaxon);
      Object localObject2;
      synchronized (this.a)
      {
        if (!this.rm.containsKey(Integer.valueOf(i))) {
          this.rm.put(Integer.valueOf(i), new Object());
        }
        localObject2 = this.rm.get(Integer.valueOf(i));
        if (localaxon == null) {}
      }
      try
      {
        localaxon.onDestroy();
        this.a[i] = null;
        i += 1;
      }
      finally {}
    }
    localObject3 = finally;
    throw localObject3;
  }
  
  public boolean oq(int paramInt)
  {
    return this.a[paramInt] != null;
  }
  
  static class a
  {
    public static final axov a = new axov(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axov
 * JD-Core Version:    0.7.0.1
 */