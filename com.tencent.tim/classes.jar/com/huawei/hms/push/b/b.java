package com.huawei.hms.push.b;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.a.a;
import com.huawei.hms.push.c.d;
import java.util.concurrent.Callable;

public class b
  implements Callable<Void>
{
  private Context a;
  private Intent b;
  private String c;
  
  public b(Context paramContext, Intent paramIntent, String paramString)
  {
    this.a = paramContext;
    this.b = paramIntent;
    this.c = paramString;
  }
  
  public Void call()
    throws Exception
  {
    this.a.sendBroadcast(this.b);
    d.a(this.a, "push.setNotifyFlag", this.c, a.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.b.b
 * JD-Core Version:    0.7.0.1
 */