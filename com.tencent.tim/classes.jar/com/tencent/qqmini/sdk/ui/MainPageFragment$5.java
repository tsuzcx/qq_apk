package com.tencent.qqmini.sdk.ui;

import NS_COMM.COMM.StCommonExt;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class MainPageFragment$5
  implements AsyncResult
{
  MainPageFragment$5(MainPageFragment paramMainPageFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = (COMM.StCommonExt)paramJSONObject.opt("ext");
      if (paramJSONObject != null) {
        MainPageFragment.access$802(this.this$0, paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.5
 * JD-Core Version:    0.7.0.1
 */