package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$1$1
  implements MiniAppCmdInterface
{
  SubMsgPermissionSettingFragment$1$1(SubMsgPermissionSettingFragment.1 param1, String paramString, CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = true;
    long l = -1L;
    if (paramJSONObject != null)
    {
      QLog.e(SubMsgPermissionSettingFragment.access$100(), 1, "onCheckedChanged, " + this.val$scopeName + "_setAuthorize:" + paramBoolean + ",ret" + paramJSONObject.toString());
      l = paramJSONObject.optLong("retCode");
    }
    String str;
    if ((!paramBoolean) || (l == -101510007L))
    {
      this.this$1.this$0.getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.1.1.1(this, l));
      SubMsgPermissionSettingFragment.access$002(this.this$1.this$0, true);
      paramJSONObject = this.val$buttonView;
      if (this.val$isChecked) {
        break label170;
      }
      paramBoolean = true;
      paramJSONObject.setChecked(paramBoolean);
      paramJSONObject = this.this$1.this$0.authorizeCenter;
      str = this.val$scopeName;
      if (this.val$isChecked) {
        break label175;
      }
    }
    label170:
    label175:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramJSONObject.setAuthorize(str, paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */