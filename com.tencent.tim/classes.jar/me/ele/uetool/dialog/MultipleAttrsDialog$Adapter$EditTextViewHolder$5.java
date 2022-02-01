package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultipleAttrsDialog$Adapter$EditTextViewHolder$5
  implements View.OnClickListener
{
  MultipleAttrsDialog$Adapter$EditTextViewHolder$5(MultipleAttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void onClick(View paramView)
  {
    MultipleAttrsDialog.access$002(this.this$0.getAdapterPosition());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.EditTextViewHolder.5
 * JD-Core Version:    0.7.0.1
 */