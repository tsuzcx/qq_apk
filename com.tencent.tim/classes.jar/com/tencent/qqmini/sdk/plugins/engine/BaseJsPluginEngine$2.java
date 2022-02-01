package com.tencent.qqmini.sdk.plugins.engine;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import java.util.Map;

class BaseJsPluginEngine$2
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AuthDialog localAuthDialog = (AuthDialog)paramDialogInterface;
    Bundle localBundle = localAuthDialog.getData();
    Object localObject;
    int i;
    if (localBundle != null)
    {
      paramDialogInterface = localBundle.getString("key_event_name");
      localObject = localBundle.getString("key_params");
      i = localBundle.getInt("key_callback_id");
    }
    for (;;)
    {
      localObject = BaseJsPluginEngine.access$200(paramDialogInterface, (String)localObject);
      boolean bool1 = localAuthDialog.isConfirm();
      boolean bool2 = localAuthDialog.isRefuse();
      QMLog.d("JsPluginEngine[AuthGuard]", "onDismiss eventName=" + paramDialogInterface + ",scopeName=" + (String)localObject + ",isConfirm=" + bool1 + ",isRefuse=" + bool2);
      paramDialogInterface = BaseJsPluginEngine.access$300(this.this$0).obtainMessage(1);
      if (bool1)
      {
        paramDialogInterface.arg1 = 1;
        BaseJsPluginEngine.access$400(this.this$0, (String)localObject, true);
      }
      for (;;)
      {
        if ((i != -1) && (BaseJsPluginEngine.access$500(this.this$0).containsKey(Integer.valueOf(i))))
        {
          localObject = (PhoneNumberAction.PhoneNumberActionCallback)BaseJsPluginEngine.access$500(this.this$0).remove(Integer.valueOf(i));
          if (localObject != null) {
            ((PhoneNumberAction.PhoneNumberActionCallback)localObject).onGetAuthDialogRet(bool1, localAuthDialog.getSelectPhoneNumber());
          }
        }
        paramDialogInterface.sendToTarget();
        this.this$0.authDialog = null;
        return;
        if (bool2)
        {
          paramDialogInterface.arg1 = 2;
          paramDialogInterface.obj = localObject;
          BaseJsPluginEngine.access$400(this.this$0, (String)localObject, false);
        }
        else
        {
          paramDialogInterface.arg1 = 3;
          paramDialogInterface.obj = localObject;
        }
      }
      i = -1;
      localObject = null;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */