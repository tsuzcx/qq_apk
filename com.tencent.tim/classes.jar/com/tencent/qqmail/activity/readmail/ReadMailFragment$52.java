package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.view.FolderLockDialog;

class ReadMailFragment$52
  implements View.OnClickListener
{
  ReadMailFragment$52(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadMailFragment.access$9000(this.this$0) != null)
    {
      ReadMailFragment.access$9000(this.this$0).showDialog();
      ReadMailFragment.access$11602(this.this$0, -2L);
      if (ReadMailFragment.access$9000(this.this$0).getEditText() != null) {
        KeyBoardHelper.showSoftInputDelay(ReadMailFragment.access$9000(this.this$0).getEditText(), 20L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.52
 * JD-Core Version:    0.7.0.1
 */