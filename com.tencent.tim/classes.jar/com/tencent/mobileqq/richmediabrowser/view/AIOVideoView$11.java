package com.tencent.mobileqq.richmediabrowser.view;

import amem;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOVideoView$11
  implements Runnable
{
  public AIOVideoView$11(amem paramamem, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.zm.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      amem.a(this.this$0).add(amem.a(this.this$0).size() - 1, localActionSheetItem);
    }
    this.this$0.d.setActionSheetItems(amem.b(this.this$0), amem.a(this.this$0));
    if (this.this$0.d.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.d.refresh();
      return;
    }
    this.this$0.d.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.11
 * JD-Core Version:    0.7.0.1
 */