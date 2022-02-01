package com.tencent.qqmini.sdk.plugins;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class ShareJsPlugin$4$3
  implements ActionSheet.OnButtonClickListener
{
  ShareJsPlugin$4$3(ShareJsPlugin.4 param4, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("tapIndex", paramInt);
      this.this$1.val$req.ok(paramView);
      this.val$actionSheet.dismiss();
      return;
    }
    catch (JSONException paramView)
    {
      QMLog.e("ShareJsPlugin", this.this$1.val$req.event + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4.3
 * JD-Core Version:    0.7.0.1
 */