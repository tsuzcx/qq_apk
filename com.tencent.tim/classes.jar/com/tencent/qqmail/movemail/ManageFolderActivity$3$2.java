package com.tencent.qqmail.movemail;

import com.tencent.qqmail.utilities.ui.QMTips;

class ManageFolderActivity$3$2
  implements Runnable
{
  ManageFolderActivity$3$2(ManageFolderActivity.3 param3, String paramString) {}
  
  public void run()
  {
    ManageFolderActivity.access$1000(this.this$1.this$0, this.val$newFolderName, false);
    ManageFolderActivity.access$000(this.this$1.this$0).setCallback(new ManageFolderActivity.3.2.1(this));
    ManageFolderActivity.access$000(this.this$1.this$0).showLoading("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.3.2
 * JD-Core Version:    0.7.0.1
 */