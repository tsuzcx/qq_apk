package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;

class NameListMainFragment$12$1
  implements TextChangeTimer.OnTextChangeListener
{
  NameListMainFragment$12$1(NameListMainFragment.12 param12) {}
  
  public void onTextChange()
  {
    Threads.runInBackground(new NameListMainFragment.12.1.1(this));
    NameListMainFragment.access$1100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.12.1
 * JD-Core Version:    0.7.0.1
 */