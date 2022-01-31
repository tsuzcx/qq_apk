package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.Date;

final class ng
  extends bo
{
  ng(JLFindItems paramJLFindItems)
  {
    super(paramJLFindItems);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this.a, JLFinditemsResult.class);
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (Bundle)paramMessage.obj;
      localIntent.putExtra("result", paramMessage.getInt("result"));
      localIntent.putExtra("title", paramMessage.getString("title"));
      localIntent.putExtra("desc", paramMessage.getString("desc"));
    }
    for (;;)
    {
      this.a.startActivity(localIntent);
      return;
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      e.c("jl get appeal failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      localIntent.putExtra("result", -1);
      localIntent.putExtra("title", "");
      localIntent.putExtra("desc", paramMessage.c);
      localIntent.putExtra("roleID", JLFindItems.access$500(this.a));
      localIntent.putExtra("roleName", JLFindItems.access$600(this.a));
      localIntent.putExtra("zoneID", JLFindItems.access$700(this.a));
      localIntent.putExtra("zoneName", JLFindItems.access$1100(this.a));
      localIntent.putExtra("serverID", JLFindItems.access$800(this.a));
      localIntent.putExtra("serverName", JLFindItems.access$900(this.a));
      localIntent.putExtra("lastLoginTime", this.a.lastLoginTime.getTime());
      localIntent.putExtra("getStealTime", this.a.getStealTime.getTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ng
 * JD-Core Version:    0.7.0.1
 */