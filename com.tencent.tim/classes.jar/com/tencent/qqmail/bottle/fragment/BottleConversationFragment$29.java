package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import com.tencent.qqmail.bottle.fragment.adapter.OnDetailClickBridge.OnDetailClickListener;
import com.tencent.qqmail.bottle.model.Bottler;

class BottleConversationFragment$29
  implements OnDetailClickBridge.OnDetailClickListener
{
  BottleConversationFragment$29(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onDetailClickListener(Bottler paramBottler, View paramView)
  {
    CommonUI.showBottlerDetail(this.this$0.getActivity(), BottleConversationFragment.access$600(this.this$0), paramBottler.getName(), paramBottler.isMale(), paramBottler.getAvatar(), paramBottler.getBigAvatar(), paramBottler.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.29
 * JD-Core Version:    0.7.0.1
 */