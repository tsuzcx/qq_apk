package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;

class NameListMainFragment$13$1
  implements Runnable
{
  NameListMainFragment$13$1(NameListMainFragment.13 param13) {}
  
  public void run()
  {
    if (NameListMainFragment.access$1500(this.this$1.this$0) != null)
    {
      QMSettingManager.sharedInstance().setLastLoadBlackWhiteNameListTime(NameListMainFragment.access$000(this.this$1.this$0), 0L);
      NameListMainFragment.access$1500(this.this$1.this$0).refresh(true, new NameListMainFragment.13.1.1(this));
      return;
    }
    NameListMainFragment.access$1600(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.13.1
 * JD-Core Version:    0.7.0.1
 */