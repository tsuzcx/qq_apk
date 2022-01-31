package com.tencent.token.ui;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TabHost;
import com.tencent.token.ui.base.SlidingMenuView;
import com.tencent.token.ui.base.ct;

class mu
  implements ct
{
  mu(IndexActivity paramIndexActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (IndexActivity.access$1400(this.a).getCurrentTab() == 1)
    {
      Intent localIntent = new Intent("com.tencent.token.siderbar.statechanged");
      localIntent.putExtra("cscreen", this.a.slidingMenuView.getCurrentScreen());
      localIntent.putExtra("nscreen", this.a.slidingMenuView.getNextScreen());
      localIntent.putExtra("cstate", paramBoolean);
      LocalBroadcastManager.getInstance(this.a).sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mu
 * JD-Core Version:    0.7.0.1
 */