package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;

class AttrsDialog$Adapter$AddMinusEditViewHolder$1
  implements View.OnClickListener
{
  AttrsDialog$Adapter$AddMinusEditViewHolder$1(AttrsDialog.Adapter.AddMinusEditViewHolder paramAddMinusEditViewHolder) {}
  
  public void onClick(View paramView)
  {
    try
    {
      float f = Float.valueOf(this.this$0.vDetail.getText().toString()).floatValue();
      this.this$0.vDetail.setText(String.valueOf(AttrsDialog.Adapter.AddMinusEditViewHolder.access$200(this.this$0).add((int)f)));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.AddMinusEditViewHolder.1
 * JD-Core Version:    0.7.0.1
 */