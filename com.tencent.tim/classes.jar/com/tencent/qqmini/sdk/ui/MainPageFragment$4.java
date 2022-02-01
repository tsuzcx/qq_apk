package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import org.json.JSONObject;

class MainPageFragment$4
  implements AsyncResult
{
  MainPageFragment$4(MainPageFragment paramMainPageFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    boolean bool = true;
    int i;
    MainPageFragment localMainPageFragment;
    if (paramBoolean)
    {
      i = paramJSONObject.optInt("likeNum");
      int j = paramJSONObject.optInt("doLike");
      paramJSONObject = paramJSONObject.opt("mini_app_info_data");
      MainPageFragment.access$302(this.this$0, i);
      localMainPageFragment = this.this$0;
      if (j != 1) {
        break label74;
      }
    }
    label74:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      MainPageFragment.access$402(localMainPageFragment, paramBoolean);
      AppBrandTask.runTaskOnUiThread(new MainPageFragment.4.1(this, i, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.4
 * JD-Core Version:    0.7.0.1
 */