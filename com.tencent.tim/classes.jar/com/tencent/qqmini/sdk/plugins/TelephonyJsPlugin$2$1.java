package com.tencent.qqmini.sdk.plugins;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener;

class TelephonyJsPlugin$2$1
  implements ActionSheet.OnButtonClickListener
{
  TelephonyJsPlugin$2$1(TelephonyJsPlugin.2 param2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = this.this$1.this$0;
      String str1 = this.this$1.val$req.event;
      String str2 = this.this$1.val$req.jsonParams;
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        TelephonyJsPlugin.access$200(paramView, str1, str2, bool);
        this.val$actionSheet.dismiss();
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      QMLog.e("TelephonyJsPlugin", this.this$1.val$req.event + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */