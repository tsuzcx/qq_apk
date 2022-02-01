package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadNoteActivity$39
  implements View.OnLongClickListener
{
  ReadNoteActivity$39(ReadNoteActivity paramReadNoteActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    CommUtils.copyText(((TextView)paramView).getText().toString());
    this.this$0.getTips().setCallback(new ReadNoteActivity.39.1(this, paramView));
    this.this$0.getTips().showSuccess(2131718608);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.39
 * JD-Core Version:    0.7.0.1
 */