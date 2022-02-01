package com.tencent.qqmail.ftn.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.media.QMMediaBottom;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.view.QMListItemView;
import java.util.List;

class ComposeFtnListActivity$5
  implements AdapterView.OnItemClickListener
{
  ComposeFtnListActivity$5(ComposeFtnListActivity paramComposeFtnListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QMListItemView localQMListItemView = (QMListItemView)paramView;
    FileInfo localFileInfo = ComposeFtnListActivity.access$300(this.this$0).getItem(paramInt);
    if (localQMListItemView.isChecked())
    {
      ComposeFtnListActivity.access$400(this.this$0).add(FtnCommonUtils.fileInfo2BigAttach(localFileInfo));
      ComposeFtnListActivity.access$500(this.this$0).add(localFileInfo.fid);
      ComposeFtnListActivity.access$600(this.this$0).setItemChecked(paramInt, true);
    }
    for (;;)
    {
      ComposeFtnListActivity.access$800(this.this$0).updateAddButton(ComposeFtnListActivity.access$700(this.this$0), ComposeFtnListActivity.access$400(this.this$0).size());
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      ComposeFtnListActivity.access$400(this.this$0).remove(FtnCommonUtils.fileInfo2BigAttach(localFileInfo));
      ComposeFtnListActivity.access$500(this.this$0).remove(localFileInfo.fid);
      ComposeFtnListActivity.access$600(this.this$0).setItemChecked(paramInt, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity.5
 * JD-Core Version:    0.7.0.1
 */