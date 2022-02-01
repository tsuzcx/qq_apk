package com.tencent.mobileqq.widget;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.HashMap;

class ProfileCardMoreInfoView$6$1
  implements Runnable
{
  ProfileCardMoreInfoView$6$1(ProfileCardMoreInfoView.6 param6) {}
  
  public void run()
  {
    if (!this.a.this$0.mActivity.isResume()) {}
    View localView;
    do
    {
      return;
      localView = (View)this.a.this$0.pH.get("map_key_troop_mem_recent_said");
    } while ((!this.a.this$0.isPluginInstalled) || (localView == null));
    ProfileCardMoreInfoView.b(localView, this.a.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.6.1
 * JD-Core Version:    0.7.0.1
 */