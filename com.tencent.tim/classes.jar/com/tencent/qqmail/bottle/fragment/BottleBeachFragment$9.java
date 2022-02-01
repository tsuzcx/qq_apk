package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class BottleBeachFragment$9
  implements View.OnClickListener
{
  BottleBeachFragment$9(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onClick(View paramView)
  {
    BottleBeachFragment.access$500(this.this$0).setVisibility(8);
    SharedPreferenceUtil.setBottleSpamHashClose(BottleBeachFragment.access$600(this.this$0), BottleBeachFragment.access$700(this.this$0), true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.9
 * JD-Core Version:    0.7.0.1
 */