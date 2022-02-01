package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMBottomDialog$BottomListSheetBuilder$ListAdapter$1
  implements View.OnClickListener
{
  QMBottomDialog$BottomListSheetBuilder$ListAdapter$1(QMBottomDialog.BottomListSheetBuilder.ListAdapter paramListAdapter, QMBottomDialog.BottomListSheetBuilder.BottomSheetListItemData paramBottomSheetListItemData, QMBottomDialog.BottomListSheetBuilder.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.val$data.hasRedPoint)
    {
      this.val$data.hasRedPoint = false;
      this.val$holder.redPoint.setVisibility(8);
    }
    if (QMBottomDialog.BottomListSheetBuilder.access$900(this.this$1.this$0))
    {
      this.this$1.this$0.setCheckedIndex(this.val$position);
      this.this$1.notifyDataSetChanged();
    }
    if (QMBottomDialog.BottomListSheetBuilder.access$1000(this.this$1.this$0) != null) {
      QMBottomDialog.BottomListSheetBuilder.access$1000(this.this$1.this$0).onClick(QMBottomDialog.BottomListSheetBuilder.access$1100(this.this$1.this$0), paramView, this.val$position, this.val$data.tag);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.ListAdapter.1
 * JD-Core Version:    0.7.0.1
 */