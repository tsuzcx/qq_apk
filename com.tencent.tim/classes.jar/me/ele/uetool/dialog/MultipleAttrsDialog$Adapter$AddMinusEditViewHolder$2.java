package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;

class MultipleAttrsDialog$Adapter$AddMinusEditViewHolder$2
  implements View.OnClickListener
{
  MultipleAttrsDialog$Adapter$AddMinusEditViewHolder$2(MultipleAttrsDialog.Adapter.AddMinusEditViewHolder paramAddMinusEditViewHolder) {}
  
  public void onClick(View paramView)
  {
    try
    {
      MultipleAttrsDialog.access$002(this.this$0.getAdapterPosition());
      int i = Float.valueOf(this.this$0.vDetail.getText().toString()).intValue();
      int j = MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.access$400(this.this$0).min(i);
      MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.access$500(this.this$0, j - i);
      this.this$0.vDetail.setText(j + "");
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
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.AddMinusEditViewHolder.2
 * JD-Core Version:    0.7.0.1
 */