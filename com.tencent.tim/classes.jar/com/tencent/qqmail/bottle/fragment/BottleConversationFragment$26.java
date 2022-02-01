package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.view.ReplyListView.OnTextChangeWatcher;

class BottleConversationFragment$26
  implements ReplyListView.OnTextChangeWatcher
{
  BottleConversationFragment$26(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onEmpty()
  {
    BottleConversationFragment.access$800(this.this$0, false);
  }
  
  public void onHasContent()
  {
    BottleConversationFragment.access$800(this.this$0, true);
  }
  
  public void onOverContent()
  {
    BottleConversationFragment.access$800(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.26
 * JD-Core Version:    0.7.0.1
 */