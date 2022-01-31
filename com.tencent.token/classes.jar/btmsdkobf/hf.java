package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

class hf
  implements Runnable
{
  hf(he paramhe, Context paramContext, String paramString, Intent paramIntent) {}
  
  public void run()
  {
    String str3 = this.a.getPackageName();
    Object localObject1 = String.format("action.guid.got:%s", new Object[] { str3 });
    Object localObject2 = String.format("action.rsa.got:%s", new Object[] { str3 });
    String str1 = String.format("action.reg.guid:%s", new Object[] { str3 });
    String str2 = String.format("action.up.rsa:%s", new Object[] { str3 });
    str3 = String.format("action.d.a:%s", new Object[] { str3 });
    int i;
    if (((String)localObject1).equals(this.b))
    {
      db.b(this.d.a).removeMessages(7);
      i = this.c.getIntExtra("k.rc", -1);
      localObject1 = this.c.getStringExtra("k.g");
      if ((i == 0) && (!cx.ax()))
      {
        eh.f("SharkProtocolQueue", "[cu_guid] doOnRecv(), !sendProcess, refreshGuid on recv broadcast");
        this.d.a.x(true);
      }
      eh.f("SharkProtocolQueue", "[cu_guid] doOnRecv(), notifyGuidGot on recv broadcast: " + this.b);
      db.a(this.d.a, i, (String)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (((String)localObject2).equals(this.b))
            {
              i = this.c.getIntExtra("k.rc", -1);
              localObject1 = null;
              if (i == 0)
              {
                localObject2 = new cs.b();
                ((cs.b)localObject2).is = this.c.getStringExtra("k.r.k");
                ((cs.b)localObject2).ir = this.c.getStringExtra("k.r.s");
                localObject1 = localObject2;
                if (!cx.ax())
                {
                  eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), !sendProcess, refreshRsaKey on recv broadcast");
                  this.d.a.x(false);
                  localObject1 = localObject2;
                }
              }
              eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), notifyRsaKeyGot on recv broadcast: " + this.b);
              db.a(this.d.a, i, (cs.b)localObject1);
              return;
            }
            if (!str1.equals(this.b)) {
              break;
            }
          } while (!cx.ax());
          eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), triggerRegGuid on recv broadcast: " + this.b);
          this.d.a.bH();
          return;
          if (!str2.equals(this.b)) {
            break;
          }
        } while (!cx.ax());
        eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), triggerUpdateRsaKey on recv broadcast: " + this.b);
        this.d.a.ca();
        return;
      } while ((!str3.equals(this.b)) || (!cx.ax()));
      try
      {
        i = this.c.getIntExtra("k.sa", 0);
        if (i == 1)
        {
          localObject1 = this.c.getExtras();
          localObject2 = (dl)((Bundle)localObject1).getSerializable("v.r");
          long l = ((Bundle)localObject1).getLong("vt.m", 35000L);
          this.d.a.a((dl)localObject2, l);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        eh.a("SharkProtocolQueue", "[shark_vip] doOnRecv(), setVipRule: " + localThrowable, localThrowable);
        return;
      }
    } while (i != 2);
    this.d.a.bY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hf
 * JD-Core Version:    0.7.0.1
 */