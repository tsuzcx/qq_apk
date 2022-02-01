package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public class hv
{
  private static final String TAG = hv.class.getSimpleName();
  private static hv uk;
  private Context mContext = fq.cr();
  private Handler nQ = new Handler(Looper.getMainLooper());
  private final byte[] ul = new byte[0];
  private volatile boolean um = false;
  private int un = 0;
  private WeakReference<hc.b> uo;
  private hc up;
  
  private void aC(int paramInt)
  {
    for (;;)
    {
      synchronized (this.ul)
      {
        if (this.um) {
          return;
        }
        this.um = true;
        this.up = new hc(this.mContext, fq.em());
        String str = fG();
        hk.y(398623, paramInt);
        this.up.a(str, "com.tencent.wifimanager", new hv.1(this, paramInt));
        switch (paramInt)
        {
        case 3: 
        case 6: 
        case 7: 
          return;
        }
      }
      hk.az(398522);
      continue;
      hk.az(398537);
      continue;
      hk.az(398664);
      continue;
      hk.az(398610);
      continue;
      hk.az(500173);
    }
  }
  
  private void b(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {
      hl.a(paramContext, "11993112", 0);
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 6: 
      case 7: 
      default: 
        return;
        hl.H(paramContext);
      }
    }
    hk.az(398612);
    return;
    hk.az(500175);
  }
  
  private void c(Context paramContext, int paramInt, String paramString)
  {
    hl.b(paramContext, paramInt, paramString);
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      hk.az(398524);
      return;
    case 2: 
      hk.az(398539);
      return;
    case 4: 
      hk.az(398665);
      return;
    case 5: 
      hk.az(398611);
      return;
    }
    hk.az(500174);
  }
  
  public static hv fD()
  {
    if (uk == null) {}
    try
    {
      if (uk == null) {
        uk = new hv();
      }
      return uk;
    }
    finally {}
  }
  
  private hc.b fE()
  {
    if (this.uo != null) {
      return (hc.b)this.uo.get();
    }
    return null;
  }
  
  public static boolean fF()
  {
    Object localObject = fm.dL().dO();
    if (localObject != null) {}
    for (localObject = ((fm.a)localObject).qu; hl.i("com.tencent.wifimanager", (String)localObject) != 1; localObject = null) {
      return true;
    }
    return false;
  }
  
  private String fG()
  {
    if ((this.un == 4) || (this.un == 5)) {
      return "https://tools.3g.qq.com/j/102804";
    }
    if ((this.un == 1) || (this.un == 2) || (this.un == 3)) {
      return "https://tools.3g.qq.com/j/102803";
    }
    if (this.un == 6) {
      return "https://tools.3g.qq.com/j/102832";
    }
    return fq.ep();
  }
  
  public void a(Context paramContext, int paramInt)
  {
    fm.a locala = fm.dL().dO();
    String str;
    if (locala != null) {
      str = locala.qu;
    }
    switch (hl.i("com.tencent.wifimanager", str))
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        str = null;
        break;
        aC(paramInt);
        return;
        c(paramContext, paramInt, locala.qu);
      } while (!locala.qv);
      hk.az(500171);
      return;
    }
    b(paramContext, paramInt);
  }
  
  public void a(hc.b paramb)
  {
    this.uo = new WeakReference(paramb);
  }
  
  public void aB(int paramInt)
  {
    this.un = paramInt;
  }
  
  public void onDestroy()
  {
    if (this.nQ != null) {
      this.nQ.removeCallbacksAndMessages(null);
    }
    if (this.up != null) {
      this.up.release();
    }
    this.un = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.hv
 * JD-Core Version:    0.7.0.1
 */