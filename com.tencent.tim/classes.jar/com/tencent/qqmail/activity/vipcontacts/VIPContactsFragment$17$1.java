package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;

class VIPContactsFragment$17$1
  implements TextChangeTimer.OnTextChangeListener
{
  VIPContactsFragment$17$1(VIPContactsFragment.17 param17) {}
  
  public void onTextChange()
  {
    Threads.runInBackground(new VIPContactsFragment.17.1.1(this));
    VIPContactsFragment.access$2700(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.17.1
 * JD-Core Version:    0.7.0.1
 */