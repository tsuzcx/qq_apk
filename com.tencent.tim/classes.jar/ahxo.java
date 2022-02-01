import android.os.Handler.Callback;
import android.os.Message;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import mqq.app.AppRuntime;

public class ahxo
  implements Handler.Callback
{
  private static ahxo a;
  public static final String bLX = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".hiboom_font/");
  public static final String bLY = bLX + "font/";
  public static final String bLZ = bLX + "config/";
  public static final String bMa = bLX + "tags/";
  private static ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, ahxp>> fz = new ConcurrentHashMap();
  public AtomicBoolean H = new AtomicBoolean(false);
  public AtomicBoolean I = new AtomicBoolean(false);
  public ETEngine e;
  public ETEngine f;
  
  public static ahxo a()
  {
    if (a == null) {
      a = new ahxo();
    }
    return a;
  }
  
  private ahxp a(int paramInt1, int paramInt2, ahxo.a parama)
  {
    parama = new ahxp(paramInt1, parama);
    ((ConcurrentHashMap)fz.get(Integer.valueOf(paramInt2))).put(Integer.valueOf(paramInt1), parama);
    return parama;
  }
  
  public static boolean jX(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = new File(bLY + paramInt);
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).list(ChatFontJsPlugin.mHiBoomFontFilter);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (localObject.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public ahxp b(int paramInt1, int paramInt2, @Nonnull ahxo.a parama)
  {
    try
    {
      if ((ConcurrentHashMap)fz.get(Integer.valueOf(paramInt2)) == null) {
        fz.put(Integer.valueOf(paramInt2), new ConcurrentHashMap());
      }
      ahxp localahxp2 = (ahxp)((ConcurrentHashMap)fz.get(Integer.valueOf(paramInt2))).get(Integer.valueOf(paramInt1));
      ahxp localahxp1 = localahxp2;
      if (localahxp2 == null) {
        localahxp1 = a(paramInt1, paramInt2, parama);
      }
      return localahxp1;
    }
    finally {}
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "clearCache");
    }
    BaseApplicationImpl.getApplication().waitAppRuntime(null);
    if (this.H.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont", 2, "clearCache clearHY Engine");
      }
      this.e.native_resetEngine();
      this.f.native_resetEngine();
    }
    fz.clear();
    HiBoomTextView.dqR();
    i.a().clearAllCache();
  }
  
  public void dqG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "onEngineReady");
    }
    Iterator localIterator1 = fz.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        ((ahxp)((Map.Entry)localIterator2.next()).getValue()).KE(false);
      }
    }
  }
  
  public void dqH()
  {
    int j = 1048576;
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont", 2, "initHYEngine");
        }
        if ((!lb.aD()) && (ETEngine.getInstanceForAnimation().isEngineInited.compareAndSet(false, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "initHYEngine load so");
          }
          lb.aF();
        }
        if (lb.aD())
        {
          this.e = ETEngine.getInstance();
          this.f = ETEngine.getInstanceForAnimation();
        }
        try
        {
          if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            break label318;
          }
          i = ChatTextSizeSettingActivity.ag(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp());
          i = i * i * 240 * 18 * 2;
        }
        catch (Exception localException)
        {
          boolean bool2;
          boolean bool1;
          boolean bool3;
          AtomicBoolean localAtomicBoolean;
          QLog.e("HiBoomFont", 1, "initEngine error", localException);
          continue;
        }
        bool2 = this.e.isEngineReady.get();
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = this.e.initEngine(18, j);
          this.e.isEngineReady.set(bool1);
        }
        bool3 = this.f.isEngineReady.get();
        bool2 = bool3;
        if (!bool3)
        {
          bool2 = this.f.initEngine(10, 3145728);
          this.f.isEngineReady.set(bool2);
        }
        localAtomicBoolean = this.H;
        if ((bool1) && (bool2))
        {
          bool3 = true;
          localAtomicBoolean.set(bool3);
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "initHYEngine ret = " + bool1 + " ret2=" + bool2);
          }
          this.I.set(true);
          return;
        }
        bool3 = false;
        continue;
        i = 0;
      }
      finally {}
      label318:
      if (i > 1048576) {
        j = i;
      }
    }
  }
  
  public void dqI()
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = i.a().n.get();
        if (bool) {
          return;
        }
        i.a().n.set(true);
        i = aqnl.af(aqnl.getSoDir(), "libFounderColorFont_818.so");
        if (!QLog.isColorLevel()) {
          break label131;
        }
        QLog.d("HiBoomFont", 2, "tryInitFZEngine: loadSoRes=" + i);
      }
      finally {}
      i.a().p.set(true);
      continue;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "libColorFont_818", "HiBoomFont_initFZEngine");
        continue;
        label131:
        switch (i)
        {
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof HiBoomTextView)) {
        ((HiBoomTextView)paramMessage.obj).invalidate();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Pw(int paramInt);
    
    public abstract String getFontPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxo
 * JD-Core Version:    0.7.0.1
 */