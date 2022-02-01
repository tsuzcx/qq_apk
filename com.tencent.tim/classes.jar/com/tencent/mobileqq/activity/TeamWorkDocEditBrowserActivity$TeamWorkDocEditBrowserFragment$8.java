package com.tencent.mobileqq.activity;

import aobk;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$8
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$8(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mApp == null) {
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebLog_WebViewFragment", 2, "saveTempPadFromQQ: prvurl " + this.val$previewUrl);
      }
      ((JSONObject)localObject).put("prvurl", this.val$previewUrl);
      String str = String.format("https://%s.docs.qq.com/preview/imp/save_to_mylist", new Object[] { this.this$0.mApp.getCurrentAccountUin() });
      localObject = aobk.b((JSONObject)localObject, this.this$0.mApp.getCurrentAccountUin(), str, "docs.qq.com");
      this.this$0.wD((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.8
 * JD-Core Version:    0.7.0.1
 */