package com.tencent.qqmail.folderlist;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderHasNewHelper$3
  implements PopupWindow.OnDismissListener
{
  FolderHasNewHelper$3(FolderHasNewHelper paramFolderHasNewHelper) {}
  
  public void onDismiss()
  {
    QMLog.log(4, FolderHasNewHelper.access$000(), "Dismiss popup window of has-new");
    FolderHasNewHelper.tipFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderHasNewHelper.3
 * JD-Core Version:    0.7.0.1
 */