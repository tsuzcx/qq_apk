package com.tencent.token.ui;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TabHost;
import com.tencent.token.ui.base.SlidingMenuView;
import com.tencent.token.ui.base.da;

final class mq
  implements da
{
  mq(IndexActivity paramIndexActivity) {}
  
  public final void a(boolean paramBoolean)
  {
    if (IndexActivity.access$1000(this.a).getCurrentTab() == 1)
    {
      Intent localIntent = new Intent("com.tencent.token.siderbar.statechanged");
      localIntent.putExtra("cscreen", this.a.slidingMenuView.a());
      localIntent.putExtra("nscreen", this.a.slidingMenuView.b());
      localIntent.putExtra("cstate", paramBoolean);
      LocalBroadcastManager.getInstance(this.a).sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mq
 * JD-Core Version:    0.7.0.1
 */