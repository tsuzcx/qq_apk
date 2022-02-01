package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.Iterator;
import java.util.List;

final class bc
{
  volatile boolean a;
  byte[] b = new byte[0];
  final ap c;
  bj d = null;
  ServiceState e = null;
  HandlerThread f;
  a g;
  b h;
  Handler i;
  SignalStrength j;
  private bj k = null;
  private bj l = null;
  private int m = 0;
  
  public bc(ap paramap)
  {
    this.c = paramap;
  }
  
  private void a(bj parambj)
  {
    if ((!this.a) || (parambj == null) || (this.c == null)) {
      return;
    }
    try
    {
      if (this.d != null) {
        parambj.a(this.d.a());
      }
      this.d = parambj;
      this.c.b(parambj);
      return;
    }
    finally {}
  }
  
  public final void a()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    synchronized (this.b)
    {
      if (this.h != null) {
        this.h.a(0);
      }
      if (this.g != null)
      {
        this.g.a = true;
        this.g.removeCallbacksAndMessages(null);
        this.g = null;
      }
      if (this.f != null)
      {
        this.f.quit();
        this.f = null;
      }
      this.d = null;
      this.e = null;
      this.h = null;
      this.j = null;
      return;
    }
  }
  
  final class a
    extends Handler
  {
    volatile boolean a = false;
    
    private a(Looper paramLooper)
    {
      super();
    }
    
    @SuppressLint({"NewApi", "MissingPermission"})
    public final void handleMessage(Message arg1)
    {
      int i = 0;
      if (!bc.this.a) {
        return;
      }
      Object localObject1 = bz.c(bc.this.c);
      ??? = bc.this.d;
      if (??? != null) {
        ???.a((List)localObject1);
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Iterator)localObject1).next();
        }
      }
      if (??? != null)
      {
        if (System.currentTimeMillis() - ???.i < 3000L) {
          i = 1;
        }
        if (i != 0) {}
      }
      else if (bc.this.c.f != null)
      {
        ??? = bz.b(bc.this.c);
        localObject1 = bj.a(bc.this.c, ???);
        if (localObject1 != null)
        {
          ??? = (Message)localObject1;
          if (((bj)localObject1).j) {}
        }
        else
        {
          ??? = bz.a(bc.this.c);
          ??? = bj.a(bc.this.c, ???, bc.this.j);
        }
        bc.a(bc.this, ???, 2);
      }
      synchronized (bc.this.b)
      {
        if ((bc.this.g != null) && (!this.a)) {
          ai.a(bc.this.g, 0, 30000L);
        }
        return;
      }
    }
  }
  
  final class b
    extends PhoneStateListener
  {
    public b()
    {
      a(1297);
    }
    
    final void a(int paramInt)
    {
      try
      {
        bc.this.c.f.listen(this, paramInt);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    @SuppressLint({"NewApi"})
    public final void onCellInfoChanged(List<CellInfo> paramList)
    {
      if (paramList != null) {
        paramList.size();
      }
      paramList = bj.a(bc.this.c, paramList);
      bc.a(bc.this, paramList, 0);
    }
    
    public final void onCellLocationChanged(CellLocation paramCellLocation)
    {
      super.onCellLocationChanged(paramCellLocation);
      paramCellLocation = bj.a(bc.this.c, paramCellLocation, bc.this.j);
      bc.a(bc.this, paramCellLocation, 1);
    }
    
    public final void onServiceStateChanged(ServiceState paramServiceState)
    {
      int j = 1;
      int m = 0;
      super.onServiceStateChanged(paramServiceState);
      if (paramServiceState == null) {}
      for (;;)
      {
        return;
        try
        {
          Object localObject = bc.this.e;
          if ((localObject != null) && (((ServiceState)localObject).getState() == paramServiceState.getState())) {
            continue;
          }
          bc.this.e = paramServiceState;
          paramServiceState = bc.this;
          if (!paramServiceState.a) {
            continue;
          }
          int i;
          boolean bool;
          if (paramServiceState.e != null) {
            if (paramServiceState.e.getState() == 0)
            {
              i = 1;
              localObject = paramServiceState.c.f;
              bool = bz.a(paramServiceState.c.a);
              if (localObject == null) {
                break label194;
              }
              if (((TelephonyManager)localObject).getSimState() != 5) {
                break label183;
              }
              break label196;
            }
          }
          for (;;)
          {
            localObject = new Message();
            ((Message)localObject).what = 12999;
            ((Message)localObject).arg1 = 12003;
            ((Message)localObject).arg2 = k;
            paramServiceState.c.b(localObject);
            return;
            i = paramServiceState.e.getState();
            if (i == 1)
            {
              i = 0;
              break;
            }
            i = -1;
            break;
            label183:
            j = 0;
            label194:
            label196:
            do
            {
              k = i;
              break;
              j = 0;
              k = m;
              if (bool) {
                break;
              }
            } while (j != 0);
            int k = m;
          }
          return;
        }
        catch (Throwable paramServiceState) {}
      }
    }
    
    public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      bc.this.j = paramSignalStrength;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bc
 * JD-Core Version:    0.7.0.1
 */