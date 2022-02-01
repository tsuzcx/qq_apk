package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.base.item.BriefDescItem;

class AttrsDialog$Adapter$BriefDescViewHolder$1
  implements View.OnClickListener
{
  AttrsDialog$Adapter$BriefDescViewHolder$1(AttrsDialog.Adapter.BriefDescViewHolder paramBriefDescViewHolder, AttrsDialog.AttrDialogCallback paramAttrDialogCallback) {}
  
  public void onClick(View paramView)
  {
    if (this.val$callback != null) {
      this.val$callback.selectView(((BriefDescItem)this.this$0.item).getElement());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.BriefDescViewHolder.1
 * JD-Core Version:    0.7.0.1
 */