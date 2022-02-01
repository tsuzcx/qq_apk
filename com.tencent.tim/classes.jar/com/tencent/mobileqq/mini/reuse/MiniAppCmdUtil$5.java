package com.tencent.mobileqq.mini.reuse;

import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppCmdUtil$5
  implements HttpCmdResult
{
  MiniAppCmdUtil$5(MiniAppCmdUtil paramMiniAppCmdUtil, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.val$listener != null)
    {
      this.val$listener.onCmdListener(paramBoolean, paramJSONObject);
      return;
    }
    QLog.e(MiniAppCmdUtil.TAG, 1, "checkNavigateRight, listener is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.5
 * JD-Core Version:    0.7.0.1
 */