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
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.s;
import gameloginsdk.CallbackAppidTypeStruct;
import gameloginsdk.CallbackGameConfirmStruct;
import gameloginsdk.CallbackPushStruct;
import gameloginsdk.GameLoginConst;
import gameloginsdk.IGameLoginCallback;

final class t
  implements IGameLoginCallback
{
  t(r paramr) {}
  
  public final void onPush(int paramInt, Object paramObject)
  {
    e.d("game login push rsp callback: info=" + paramInt + ", obj=" + paramObject);
    s.h();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    paramObject = (CallbackPushStruct)paramObject;
    e.c(paramObject.toString() + ", foreground=" + BaseActivity.getIsAppForeground());
    r.a(this.a, paramObject);
    r.a(this.a, ag.c().r());
    if (BaseActivity.getIsAppForeground())
    {
      this.a.b.sendEmptyMessage(0);
      return;
    }
    IndexActivity.s_ShowGameLoginPushInfo = true;
    paramObject = "QQ" + s.b(r.a(this.a).uin) + RqdApplication.i().getResources().getString(2131362447);
    Object localObject = new Intent(RqdApplication.i(), IndexActivity.class);
    ((Intent)localObject).putExtra("index_from", 24);
    localObject = PendingIntent.getActivity(RqdApplication.i(), 0, (Intent)localObject, 134217728);
    ((NotificationManager)RqdApplication.i().getSystemService("notification")).notify(3, new NotificationCompat.Builder(RqdApplication.i()).setDefaults(1).setAutoCancel(true).setContentTitle(RqdApplication.i().getResources().getString(2131361792)).setSmallIcon(2130837686).setContentIntent((PendingIntent)localObject).addAction(2130837686, RqdApplication.i().getResources().getString(2131361792), (PendingIntent)localObject).setContentText(paramObject).build());
  }
  
  public final void onRespCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    e.d("game login rsp callback: ret=" + paramInt1 + ", respno=" + paramInt2 + ", info=" + paramInt3 + ", obj=" + paramObject);
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
          GameLoginConst.filterNormalCode(paramInt1);
          s.h();
        }
        e.a("game login getflowtype: appidtype=" + paramObject.appidType);
        r.b(this.a);
        if (paramObject.appidType == 1)
        {
          r.a(this.a, true);
          return;
        }
        r.a(this.a, false);
        return;
      } while (paramInt1 == 0);
      GameLoginConst.filterNormalCode(paramInt1);
      s.h();
      return;
      paramObject = (CallbackGameConfirmStruct)paramObject;
      e.b("game login confirm:" + paramObject);
      paramInt2 = paramInt1;
      if (paramInt1 != 0)
      {
        paramInt2 = GameLoginConst.filterNormalCode(paramInt1);
        e.b("game login confirm: code=" + paramInt2);
      }
    } while ((r.a(this.a) == null) || (r.c(this.a) == null));
    Message localMessage = r.c(this.a).obtainMessage(3040);
    localMessage.arg1 = r.d(this.a);
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    r.c(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.t
 * JD-Core Version:    0.7.0.1
 */