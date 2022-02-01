package me.ele.uetool.dialog;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.util.Util;

class AttrsDialog$Adapter$EditTextViewHolder$2
  implements View.OnClickListener
{
  AttrsDialog$Adapter$EditTextViewHolder$2(AttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder, View paramView) {}
  
  public void onClick(View paramView)
  {
    Util.showColorPickerDialog(Color.parseColor(this.this$0.vDetail.getText().toString()), new AttrsDialog.Adapter.EditTextViewHolder.2.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.EditTextViewHolder.2
 * JD-Core Version:    0.7.0.1
 */