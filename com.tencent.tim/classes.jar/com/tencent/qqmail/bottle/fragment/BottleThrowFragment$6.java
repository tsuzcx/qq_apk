package com.tencent.qqmail.bottle.fragment;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.view.QMTopBar;

class BottleThrowFragment$6
  implements TextWatcher
{
  BottleThrowFragment$6(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = paramEditable.toString().trim().length();
    if (i == 0)
    {
      if ((this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
        this.this$0.getTopBar().getButtonRight().setEnabled(false);
      }
      BottleThrowFragment.access$900(this.this$0).setVisibility(8);
      return;
    }
    if (i < 100)
    {
      if ((this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
        this.this$0.getTopBar().getButtonRight().setEnabled(true);
      }
      BottleThrowFragment.access$900(this.this$0).setVisibility(8);
      return;
    }
    if (i <= 140)
    {
      if ((this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
        this.this$0.getTopBar().getButtonRight().setEnabled(true);
      }
      BottleThrowFragment.access$900(this.this$0).setText(this.this$0.getString(2131691016, new Object[] { Integer.valueOf(i), Integer.valueOf(140) }));
      BottleThrowFragment.access$900(this.this$0).setTextColor(this.this$0.getResources().getColor(2131167531));
      BottleThrowFragment.access$900(this.this$0).setVisibility(0);
      return;
    }
    if ((this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
      this.this$0.getTopBar().getButtonRight().setEnabled(false);
    }
    BottleThrowFragment.access$900(this.this$0).setText(this.this$0.getString(2131691016, new Object[] { Integer.valueOf(i), Integer.valueOf(140) }));
    BottleThrowFragment.access$900(this.this$0).setTextColor(this.this$0.getResources().getColor(2131167539));
    BottleThrowFragment.access$900(this.this$0).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.6
 * JD-Core Version:    0.7.0.1
 */