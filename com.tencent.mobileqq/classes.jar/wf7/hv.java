package wf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public class hv
{
  private static final String TAG = "hv";
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
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt == 8) {
                hk.az(500173);
              }
            }
            else {
              hk.az(398610);
            }
          }
          else {
            hk.az(398664);
          }
        }
        else {
          hk.az(398537);
        }
      }
      else {
        hk.az(398522);
      }
      return;
    }
  }
  
  private void b(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {
      hl.a(paramContext, "11993112", 0);
    } else {
      hl.H(paramContext);
    }
    if (paramInt != 5)
    {
      if (paramInt != 8) {
        return;
      }
      hk.az(500175);
      return;
    }
    hk.az(398612);
  }
  
  private void c(Context paramContext, int paramInt, String paramString)
  {
    hl.b(paramContext, paramInt, paramString);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 8) {
              return;
            }
            hk.az(500174);
            return;
          }
          hk.az(398611);
          return;
        }
        hk.az(398665);
        return;
      }
      hk.az(398539);
      return;
    }
    hk.az(398524);
  }
  
  public static hv fD()
  {
    if (uk == null) {
      try
      {
        if (uk == null) {
          uk = new hv();
        }
      }
      finally {}
    }
    return uk;
  }
  
  private hc.b fE()
  {
    WeakReference localWeakReference = this.uo;
    if (localWeakReference != null) {
      return (hc.b)localWeakReference.get();
    }
    return null;
  }
  
  public static boolean fF()
  {
    Object localObject = fm.dL().dO();
    if (localObject != null) {
      localObject = ((fm.a)localObject).qu;
    } else {
      localObject = null;
    }
    return hl.i("com.tencent.wifimanager", (String)localObject) != 1;
  }
  
  private String fG()
  {
    int i = this.un;
    if ((i != 4) && (i != 5))
    {
      if ((i != 1) && (i != 2) && (i != 3))
      {
        if (i == 6) {
          return "https://tools.3g.qq.com/j/102832";
        }
        return fq.ep();
      }
      return "https://tools.3g.qq.com/j/102803";
    }
    return "https://tools.3g.qq.com/j/102804";
  }
  
  public void a(Context paramContext, int paramInt)
  {
    fm.a locala = fm.dL().dO();
    String str;
    if (locala != null) {
      str = locala.qu;
    } else {
      str = null;
    }
    int i = hl.i("com.tencent.wifimanager", str);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        b(paramContext, paramInt);
        return;
      }
      c(paramContext, paramInt, locala.qu);
      if (locala.qv) {
        hk.az(500171);
      }
    }
    else
    {
      aC(paramInt);
    }
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
    Object localObject = this.nQ;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.up;
    if (localObject != null) {
      ((hc)localObject).release();
    }
    this.un = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hv
 * JD-Core Version:    0.7.0.1
 */