package com.tencent.android.tpush.stat;

import android.content.Context;

class ServiceStat$a$1
  implements Runnable
{
  ServiceStat$a$1(ServiceStat.a parama, Context paramContext) {}
  
  public void run()
  {
    ServiceStat.sendLocalMsg(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.ServiceStat.a.1
 * JD-Core Version:    0.7.0.1
 */