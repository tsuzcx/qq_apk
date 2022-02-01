package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import com.tencent.qqmail.bottle.fragment.adapter.OnDetailClickBridge.OnDetailClickListener;
import com.tencent.qqmail.bottle.model.Bottler;

class BottleBeachFragment$14
  implements OnDetailClickBridge.OnDetailClickListener
{
  BottleBeachFragment$14(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onDetailClickListener(Bottler paramBottler, View paramView)
  {
    CommonUI.showBottlerDetail(this.this$0.getActivity(), BottleBeachFragment.access$1600(this.this$0), paramBottler.getName(), paramBottler.isMale(), paramBottler.getAvatar(), paramBottler.getBigAvatar(), paramBottler.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.14
 * JD-Core Version:    0.7.0.1
 */