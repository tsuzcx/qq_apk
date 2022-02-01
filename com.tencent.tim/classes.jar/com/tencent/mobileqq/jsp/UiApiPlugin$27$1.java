package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.res.Resources;
import anot;
import com.tencent.mobileqq.widget.QQToast;

class UiApiPlugin$27$1
  implements Runnable
{
  UiApiPlugin$27$1(UiApiPlugin.27 param27, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (this.val$success)
    {
      str = UiApiPlugin.h("0", null, null, this.a.bOS);
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int i = 2131700054;; i = 2131700053)
    {
      QQToast.a(this.a.val$activity, i, 0).show(this.a.val$activity.getResources().getDimensionPixelSize(2131299627));
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      this.a.this$0.callJs(this.a.afp, new String[] { str });
      return;
      str = UiApiPlugin.h("-3", null, "createShortcut failed, iconUrl is invalide: " + this.a.val$iconUrl, this.a.bOS);
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27.1
 * JD-Core Version:    0.7.0.1
 */