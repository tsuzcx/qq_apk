package com.tencent.biz.qqstory.msgTabNode.view;

import android.view.View;
import com.tencent.widget.ARMapHongBaoListView;
import pvz;
import pwg;

public class MsgTabStoryNodeListManager$7$1
  implements Runnable
{
  public MsgTabStoryNodeListManager$7$1(pwg parampwg) {}
  
  public void run()
  {
    int i = this.a.this$0.mListView.getFirstVisiblePosition();
    if (i < this.a.this$0.mListView.getHeaderViewsCount())
    {
      View localView = this.a.this$0.mListView.getChildAt(0);
      if (localView == this.a.this$0.a)
      {
        int j = localView.getTop();
        if ((j < 0) && (j > -localView.getHeight())) {
          this.a.this$0.mListView.setSelection(i + 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.7.1
 * JD-Core Version:    0.7.0.1
 */