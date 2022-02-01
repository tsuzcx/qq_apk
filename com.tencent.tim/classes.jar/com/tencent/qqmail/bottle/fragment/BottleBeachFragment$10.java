package com.tencent.qqmail.bottle.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PtrListView;
import moai.fragment.base.BaseFragment;

class BottleBeachFragment$10
  implements AdapterView.OnItemClickListener
{
  BottleBeachFragment$10(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (BottleBeach)BottleBeachFragment.access$300(this.this$0).getAdapter().getItem(paramInt);
    int i;
    if (localObject != null)
    {
      if (((BottleBeach)localObject).getType() != 9998) {
        break label121;
      }
      i = Integer.parseInt(((BottleBeach)localObject).getBottleid());
      localObject = PopularizeManager.sharedInstance().getPopularizeById(i);
      if (localObject == null) {
        break label91;
      }
      PopularizeUIHelper.handleActionAndGotoLink(this.this$0.getActivity(), (Popularize)localObject);
      DataCollector.logEvent("Event_Bottle_Ad_Enter");
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label91:
      QMLog.log(6, "BottleBeachFragment", "popularize not found: " + i);
    }
    label121:
    if (((BottleBeach)localObject).getType() == 32)
    {
      if (((BottleBeach)localObject).getAdUrl() == null) {
        break label262;
      }
      if ((((BottleBeach)localObject).getAdUrl().startsWith("http")) || (((BottleBeach)localObject).getAdUrl().startsWith("https"))) {
        localObject = ((BottleBeach)localObject).getAdUrl();
      }
    }
    for (;;)
    {
      localObject = SimpleWebViewExplorer.createIntent((String)localObject, SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
      this.this$0.startActivity((Intent)localObject);
      this.this$0.overridePendingTransition(2130772401, 2130772430);
      DataCollector.logEvent("Event_Bottle_Ad_Enter");
      break;
      localObject = "http://" + ((BottleBeach)localObject).getAdUrl();
      continue;
      localObject = new BottleConversationFragment((BottleBeach)localObject);
      this.this$0.startFragmentForResult((BaseFragment)localObject, 1);
      break;
      label262:
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.10
 * JD-Core Version:    0.7.0.1
 */