package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Observable;

class o
  extends Observable
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static String a = "cc_c_t_m_l_";
  private static volatile o b = null;
  private static volatile SharedPreferences c = null;
  
  private o()
  {
    c = am.a(a);
  }
  
  /* Error */
  protected static o a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	c/t/m/g/o:b	Lc/t/m/g/o;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	c/t/m/g/o
    //   15: dup
    //   16: invokespecial 33	c/t/m/g/o:<init>	()V
    //   19: putstatic 20	c/t/m/g/o:b	Lc/t/m/g/o;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 20	c/t/m/g/o:b	Lc/t/m/g/o;
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	5	0	localo	o
    //   34	5	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   35	38	34	finally
    //   3	12	40	finally
    //   25	29	40	finally
    //   38	40	40	finally
  }
  
  protected static void a(String paramString)
  {
    a = "cc_c_t_m_l_".concat(String.valueOf(paramString));
  }
  
  protected final SharedPreferences b()
  {
    try
    {
      if (c == null) {
        c = am.a(a);
      }
      SharedPreferences localSharedPreferences = c;
      return localSharedPreferences;
    }
    finally {}
  }
  
  protected final void c()
  {
    try
    {
      if (c != null)
      {
        addObserver(n.a());
        c.registerOnSharedPreferenceChangeListener(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void d()
  {
    try
    {
      if (c != null)
      {
        c.unregisterOnSharedPreferenceChangeListener(this);
        deleteObserver(n.a());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    setChanged();
    notifyObservers(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.o
 * JD-Core Version:    0.7.0.1
 */