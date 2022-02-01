package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AuthorizeCenter$3
  implements MiniAppCmdInterface
{
  AuthorizeCenter$3(AuthorizeCenter paramAuthorizeCenter, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AuthorizeCenter", 2, "updateUserSetting() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
    }
    if (this.val$listener != null) {
      this.val$listener.onCmdListener(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.3
 * JD-Core Version:    0.7.0.1
 */