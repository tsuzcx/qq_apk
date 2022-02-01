package com.tencent.qqmail.ftn.activity;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import java.util.ArrayList;

class FtnListActivity$27
  implements View.OnClickListener
{
  FtnListActivity$27(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(View paramView)
  {
    if (((Integer)paramView.getTag()).intValue() == 4)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < FtnListActivity.access$4500(this.this$0).size())
      {
        localArrayList.add(((FileInfo)FtnListActivity.access$4500(this.this$0).valueAt(i)).fid);
        i += 1;
      }
      if (localArrayList.size() == 0) {
        break label121;
      }
      FtnListActivity.access$500(this.this$0).delFile(localArrayList);
      FtnListActivity.access$5300(this.this$0, localArrayList.size());
      FtnListActivity.access$5400(this.this$0);
    }
    for (;;)
    {
      FtnListActivity.access$5600(this.this$0).dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      FtnListActivity.access$5500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.27
 * JD-Core Version:    0.7.0.1
 */