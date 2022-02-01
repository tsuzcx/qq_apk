package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class SubMsgPermissionSettingFragment$3
  implements MiniAppCmdInterface
{
  SubMsgPermissionSettingFragment$3(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    SubMsgPermissionSettingFragment.access$300(this.this$0, paramBoolean, paramJSONObject);
    this.this$0.getActivity().runOnUiThread(new SubMsgPermissionSettingFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */