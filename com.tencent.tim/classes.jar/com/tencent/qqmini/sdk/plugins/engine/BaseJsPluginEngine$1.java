package com.tencent.qqmini.sdk.plugins.engine;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import java.util.ArrayList;
import java.util.List;

class BaseJsPluginEngine$1
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$1(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (AuthDialog)paramDialogInterface;
    Object localObject1 = paramDialogInterface.getData();
    boolean bool1 = paramDialogInterface.isConfirm();
    boolean bool2 = paramDialogInterface.isRefuse();
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    Object localObject2;
    ArrayList localArrayList;
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      bool3 = ((Bundle)localObject1).getBoolean("key_once_sub_cb_maintain");
      bool4 = ((Bundle)localObject1).getBoolean("key_once_sub_cb1");
      bool5 = ((Bundle)localObject1).getBoolean("key_once_sub_cb2");
      bool6 = ((Bundle)localObject1).getBoolean("key_once_sub_cb3");
      localObject1 = ((Bundle)localObject1).getByteArray("key_once_sub_rsp_data");
      paramDialogInterface = new INTERFACE.StGetUserSettingRsp();
      if (localObject1 != null) {}
      try
      {
        paramDialogInterface.mergeFrom((byte[])localObject1);
        if (paramDialogInterface.setting == null) {
          break label706;
        }
        localObject2 = paramDialogInterface.setting.subItems.get();
        paramDialogInterface = new ArrayList();
        localArrayList = new ArrayList();
        localObject1 = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject2).size()) {
            break label229;
          }
          localObject3 = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
          if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() != 0) {
            break;
          }
          paramDialogInterface.add(localObject3);
          i += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
          continue;
          if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 1) {
            localThrowable.add(localObject3);
          }
        }
        label229:
        localObject2 = new BaseJsPluginEngine.1.1(this, bool1, (List)localObject2, paramDialogInterface, localArrayList, bool2);
        localObject3 = MiniAppEnv.g().getAuthSate(this.this$0.getAppId());
        if (!bool1) {
          break label630;
        }
      }
      switch (paramDialogInterface.size())
      {
      }
    }
    for (;;)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(paramDialogInterface);
      localArrayList.addAll(localThrowable);
      ((AuthState)localObject3).updateOnceSubMsgSetting(true, localArrayList, (AsyncResult)localObject2);
      return;
      INTERFACE.StSubscribeMessage localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
      if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool4, localStSubscribeMessage1))
      {
        paramDialogInterface.remove(localStSubscribeMessage1);
        localArrayList.add(localStSubscribeMessage1);
        continue;
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
        INTERFACE.StSubscribeMessage localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(1);
        if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool4, localStSubscribeMessage1))
        {
          paramDialogInterface.remove(localStSubscribeMessage1);
          localArrayList.add(localStSubscribeMessage1);
        }
        if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool5, localStSubscribeMessage2))
        {
          paramDialogInterface.remove(localStSubscribeMessage2);
          localArrayList.add(localStSubscribeMessage2);
          continue;
          localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
          localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(1);
          INTERFACE.StSubscribeMessage localStSubscribeMessage3 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(2);
          if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool4, localStSubscribeMessage1))
          {
            paramDialogInterface.remove(localStSubscribeMessage1);
            localArrayList.add(localStSubscribeMessage1);
          }
          if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool5, localStSubscribeMessage2))
          {
            paramDialogInterface.remove(localStSubscribeMessage2);
            localArrayList.add(localStSubscribeMessage2);
          }
          if (!BaseJsPluginEngine.access$100(this.this$0, bool3, bool6, localStSubscribeMessage3))
          {
            paramDialogInterface.remove(localStSubscribeMessage3);
            localArrayList.add(localStSubscribeMessage3);
          }
        }
      }
    }
    label630:
    if (bool2)
    {
      if (bool3)
      {
        i = 0;
        while (i < paramDialogInterface.size())
        {
          ((INTERFACE.StSubscribeMessage)paramDialogInterface.get(i)).authState.set(4);
          i += 1;
        }
        ((AuthState)localObject3).updateOnceSubMsgSetting(false, paramDialogInterface, (AsyncResult)localObject2);
        return;
      }
      ((AsyncResult)localObject2).onReceiveResult(true, null);
      return;
    }
    ((AsyncResult)localObject2).onReceiveResult(true, null);
    return;
    label706:
    this.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$000(this.this$0), "Request list fail", 10002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */