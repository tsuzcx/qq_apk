package com.tencent.qqmail.folderlist;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderHasNewHelper$2
  implements View.OnClickListener
{
  FolderHasNewHelper$2(FolderHasNewHelper paramFolderHasNewHelper, FolderHasNewHelper.OutOfSightHasNewHint paramOutOfSightHasNewHint, ListView paramListView, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    int i = this.val$outOfSightHasNewHint.getFirstIndex() + this.val$parent.getHeaderViewsCount();
    DataCollector.logEvent("Event_New_Mail_tips_Click");
    QMLog.log(4, FolderHasNewHelper.access$000(), "click outOfSightHasNewHint scrollDest = " + i);
    this.val$parent.smoothScrollToPositionFromTop(i, 0);
    this.val$popupWindow.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderHasNewHelper.2
 * JD-Core Version:    0.7.0.1
 */