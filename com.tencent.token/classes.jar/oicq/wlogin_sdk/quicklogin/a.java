package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import oicq.wlogin_sdk.tools.util;

final class a
  implements View.OnClickListener
{
  a(Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    util.LOGI("close button clicked", "");
    this.a.finish();
    if ((QuickLoginWebViewLoader.finishAnimEnter != 0) || (QuickLoginWebViewLoader.finishAnimExit != 0)) {
      this.a.overridePendingTransition(QuickLoginWebViewLoader.finishAnimEnter, QuickLoginWebViewLoader.finishAnimExit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.a
 * JD-Core Version:    0.7.0.1
 */