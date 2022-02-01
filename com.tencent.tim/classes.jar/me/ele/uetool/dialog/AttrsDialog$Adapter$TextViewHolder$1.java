package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.util.Util;

class AttrsDialog$Adapter$TextViewHolder$1
  implements View.OnClickListener
{
  AttrsDialog$Adapter$TextViewHolder$1(AttrsDialog.Adapter.TextViewHolder paramTextViewHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    Util.clipText(this.val$detail);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.TextViewHolder.1
 * JD-Core Version:    0.7.0.1
 */