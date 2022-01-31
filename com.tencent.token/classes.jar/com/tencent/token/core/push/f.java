package com.tencent.token.core.push;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.av;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.base.DualMsgShowDialog;
import org.json.JSONException;
import org.json.JSONObject;

final class f
  extends Handler
{
  f(PushService paramPushService) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMessage.arg1 != 0);
        try
        {
          paramMessage = new JSONObject((String)paramMessage.obj);
          PushService.a(this.a, paramMessage.getString("auto_fill_vfy_code_sms_prefix"));
          e.b("auto sms prefrix" + PushService.e(this.a));
          return;
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
      } while ((paramMessage.arg1 != 0) || (av.a().b() <= 0));
      e.b("push:getIsAppForeground" + BaseActivity.getIsAppForeground());
      if (!BaseActivity.getIsAppForeground()) {
        break;
      }
    } while (RqdApplication.b);
    try
    {
      new DualMsgShowDialog(BaseActivity.sTopActivity, false, 0L).show();
      return;
    }
    catch (Exception paramMessage)
    {
      return;
    }
    IndexActivity.setFromWhere(19);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.f
 * JD-Core Version:    0.7.0.1
 */