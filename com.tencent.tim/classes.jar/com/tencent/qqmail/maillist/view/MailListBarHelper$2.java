package com.tencent.qqmail.maillist.view;

import android.widget.RelativeLayout;

final class MailListBarHelper$2
  implements Runnable
{
  MailListBarHelper$2(RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.val$folderTopOrShowHomeBar.getVisibility() == 0) {
      this.val$folderTopOrShowHomeBar.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.MailListBarHelper.2
 * JD-Core Version:    0.7.0.1
 */