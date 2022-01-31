package com.tencent.token;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.w;
import gameloginsdk.CallbackAppidTypeStruct;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLoginConst;
import gameloginsdk.IGameLoginCallback;

class cl
  implements IGameLoginCallback
{
  cl(cj paramcj) {}
  
  public void onPush(int paramInt, Object paramObject)
  {
    h.d("game login push rsp callback: info=" + paramInt + ", obj=" + paramObject);
    w.j();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    paramObject = (CallbackPushStruct)paramObject;
    h.c(paramObject.toString() + ", foreground=" + BaseActivity.getIsAppForeground());
    cj.a(this.a, paramObject);
    cj.a(this.a, cx.c().s());
    if (BaseActivity.getIsAppForeground())
    {
      this.a.b.sendEmptyMessage(0);
      return;
    }
    IndexActivity.s_ShowGameLoginPushInfo = true;
    paramObject = "QQ" + w.a(cj.a(this.a).uin) + RqdApplication.l().getResources().getString(2131231083);
    Object localObject = new Intent(RqdApplication.l(), IndexActivity.class);
    ((Intent)localObject).putExtra("index_from", 24);
    localObject = PendingIntent.getActivity(RqdApplication.l(), 0, (Intent)localObject, 134217728);
    Context localContext = RqdApplication.l();
    RqdApplication.l();
    ((NotificationManager)localContext.getSystemService("notification")).notify(3, new NotificationCompat.Builder(RqdApplication.l()).setDefaults(1).setAutoCancel(true).setContentTitle(RqdApplication.l().getResources().getString(2131230844)).setSmallIcon(2130837767).setContentIntent((PendingIntent)localObject).addAction(2130837767, RqdApplication.l().getResources().getString(2131230844), (PendingIntent)localObject).setContentText(paramObject).build());
  }
  
  public void onRespCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    h.d("game login rsp callback: ret=" + paramInt1 + ", respno=" + paramInt2 + ", info=" + paramInt3 + ", obj=" + paramObject);
    switch (paramInt3)
    {
    }
    do
    {
      do
      {
        return;
        paramObject = (CallbackAppidTypeStruct)paramObject;
        if (paramInt1 != 0)
        {
          switch (GameLoginConst.filterNormalCode(paramInt1))
          {
          }
          w.j();
        }
        h.a("game login getflowtype: appidtype=" + paramObject.appidType);
        cj.a(this.a, true);
        if (paramObject.appidType == 1)
        {
          cj.b(this.a, true);
          return;
        }
        cj.b(this.a, false);
        return;
      } while (paramInt1 == 0);
      switch (GameLoginConst.filterNormalCode(paramInt1))
      {
      }
      w.j();
      return;
      paramObject = (CallbackGameConfirmStruct)paramObject;
      h.b("game login confirm:" + paramObject);
      paramInt2 = paramInt1;
      if (paramInt1 != 0)
      {
        paramInt1 = GameLoginConst.filterNormalCode(paramInt1);
        h.b("game login confirm: code=" + paramInt1);
        paramInt2 = paramInt1;
        switch (paramInt1)
        {
        default: 
          paramInt2 = paramInt1;
        }
      }
    } while ((cj.a(this.a) == null) || (cj.b(this.a) == null));
    Message localMessage = cj.b(this.a).obtainMessage(3040);
    localMessage.arg1 = cj.c(this.a);
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    cj.b(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */