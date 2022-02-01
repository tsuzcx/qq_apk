package com.tencent.mobileqq.richmediabrowser.view;

import amdw;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOFileVideoView$6
  implements Runnable
{
  public AIOFileVideoView$6(amdw paramamdw, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.zm.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      this.this$0.zl.add(this.this$0.zl.size() - 1, localActionSheetItem);
    }
    this.this$0.d.setActionSheetItems(this.this$0.zk, this.this$0.zl);
    if (this.this$0.d.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 0, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.d.refresh();
      return;
    }
    this.this$0.d.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.6
 * JD-Core Version:    0.7.0.1
 */