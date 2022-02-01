package com.tencent.qqmail.bottle.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

class ReplyListView$1
  implements TextWatcher
{
  ReplyListView$1(ReplyListView paramReplyListView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = paramEditable.toString().trim().length();
    if (i == 0)
    {
      if (ReplyListView.access$100(this.this$0) != null) {
        ReplyListView.access$100(this.this$0).onEmpty();
      }
      ReplyListView.access$200(this.this$0).setVisibility(8);
    }
    do
    {
      return;
      if (i >= 100) {
        break;
      }
      ReplyListView.access$200(this.this$0).setVisibility(8);
    } while (ReplyListView.access$100(this.this$0) == null);
    ReplyListView.access$100(this.this$0).onHasContent();
    return;
    if (i <= 140)
    {
      if (ReplyListView.access$100(this.this$0) != null) {
        ReplyListView.access$100(this.this$0).onHasContent();
      }
      ReplyListView.access$200(this.this$0).setText(this.this$0.getContext().getString(2131691016, new Object[] { Integer.valueOf(i), Integer.valueOf(140) }));
      ReplyListView.access$200(this.this$0).setTextColor(this.this$0.getResources().getColor(2131167531));
      ReplyListView.access$200(this.this$0).setVisibility(0);
      return;
    }
    if (ReplyListView.access$100(this.this$0) != null) {
      ReplyListView.access$100(this.this$0).onOverContent();
    }
    ReplyListView.access$200(this.this$0).setText(this.this$0.getContext().getString(2131691016, new Object[] { Integer.valueOf(i), Integer.valueOf(140) }));
    ReplyListView.access$200(this.this$0).setTextColor(this.this$0.getResources().getColor(2131167539));
    ReplyListView.access$200(this.this$0).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.v(ReplyListView.access$000(), "ReplyListView word number: " + paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.ReplyListView.1
 * JD-Core Version:    0.7.0.1
 */