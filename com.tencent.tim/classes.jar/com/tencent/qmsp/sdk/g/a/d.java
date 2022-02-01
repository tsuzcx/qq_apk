package com.tencent.qmsp.sdk.g.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.qmsp.sdk.base.c;

public class d
{
  public boolean a = false;
  public Context b;
  public a c;
  public b d;
  public ServiceConnection e = new d.a(this);
  
  public d(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        this.d.a(this.c);
        return;
      }
      catch (Exception localException)
      {
        c.b("HSDID notify did bind status error :" + localException.getMessage());
        return;
      }
    }
    this.d.g();
  }
  
  public void a()
  {
    try
    {
      if ((this.a) && (this.e != null))
      {
        Context localContext = this.b;
        if (localContext != null)
        {
          c.a("HSDID start to unbind did service");
          this.a = false;
          this.b.unbindService(this.e);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      c.b("HSDID error:" + localException.getMessage());
    }
  }
  
  public void a(b paramb)
  {
    try
    {
      this.d = paramb;
      Intent localIntent = new Intent("com.asus.msa.action.ACCESS_DID");
      paramb = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
      localIntent = new Intent(localIntent);
      localIntent.setComponent(paramb);
      c.a("HSDID start to bind did service");
      this.a = this.b.bindService(localIntent, this.e, 1);
      if (!this.a) {
        this.d.g();
      }
      return;
    }
    catch (Exception paramb)
    {
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.d
 * JD-Core Version:    0.7.0.1
 */