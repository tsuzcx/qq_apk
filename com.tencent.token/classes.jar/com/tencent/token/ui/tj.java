package com.tencent.token.ui;

import android.util.Log;
import android.widget.Toast;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.TMSDKContext;
import tmsdk.common.module.pgsdk.RequestCallback;

class tj
  implements RequestCallback
{
  tj(ti paramti) {}
  
  public void onCallback(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt2[0] == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("permission_test", "申请存活权限结果:" + bool);
      if (bool) {
        break;
      }
      Toast.makeText(RqdApplication.l(), "授权失败", 0).show();
      return;
    }
    TMSDKContext.saveActionData(1150121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tj
 * JD-Core Version:    0.7.0.1
 */