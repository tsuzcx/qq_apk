package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleConversationController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.bottle.view.ReplyListView;

class BottleConversationFragment$5
  implements View.OnClickListener
{
  BottleConversationFragment$5(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onClick(View paramView)
  {
    String str = BottleConversationFragment.access$400(this.this$0).getEditTextContent();
    BottleConversationFragment.access$600(this.this$0).getBottleThrowController().replyBottle(BottleConversationFragment.access$500(this.this$0), str);
    BottleConversationFragment.access$700(this.this$0).setDraft(BottleConversationFragment.access$500(this.this$0), null);
    BottleConversationFragment.access$800(this.this$0, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.5
 * JD-Core Version:    0.7.0.1
 */