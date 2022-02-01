package com.tencent.qqmail.activity.compose;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.ArrayList;

class MailAddrsViewControl$6
  implements View.OnKeyListener
{
  MailAddrsViewControl$6(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramInt == 66)
      {
        if (MailAddrsViewControl.access$100(this.this$0).getText().toString().length() <= 0) {
          MailAddrsViewControl.access$100(this.this$0).postDelayed(new MailAddrsViewControl.6.1(this), 200L);
        }
        return true;
      }
      if (paramInt == 67)
      {
        paramView = MailAddrsViewControl.access$100(this.this$0).getEditableText().toString();
        if ((paramView.length() == 0) && (MailAddrsViewControl.access$600(this.this$0) != null) && (MailAddrsViewControl.access$600(this.this$0).isSelected()))
        {
          this.this$0.removeMailAddr((MailContact)MailAddrsViewControl.access$600(this.this$0).getTag());
          this.this$0.setSelectedAddrBtn(null);
          MailAddrsViewControl.access$100(this.this$0).setCursorVisible(true);
          this.this$0.adjustinputATVWidth();
          this.this$0.postDelayed(new MailAddrsViewControl.6.2(this), 200L);
        }
      }
      for (;;)
      {
        return false;
        if ((paramView.length() == 0) && (MailAddrsViewControl.access$800(this.this$0).size() > 0))
        {
          paramInt = MailAddrsViewControl.access$800(this.this$0).size() - 1;
          if (MailAddrsViewControl.access$900(this.this$0) != null) {}
          for (paramView = MailAddrsViewControl.access$900(this.this$0).getChildAt(paramInt);; paramView = this.this$0.getChildAt(paramInt + 1))
          {
            if (paramView.isSelected()) {
              break label271;
            }
            this.this$0.setSelectedAddrBtn(paramView);
            MailAddrsViewControl.access$100(this.this$0).setCursorVisible(false);
            break;
          }
          label271:
          this.this$0.removeMailAddr((MailContact)MailAddrsViewControl.access$800(this.this$0).get(paramInt));
          this.this$0.setSelectedAddrBtn(null);
          MailAddrsViewControl.access$100(this.this$0).setCursorVisible(true);
          continue;
          if (paramInt == 66)
          {
            paramView = MailAddrsViewControl.access$100(this.this$0).getEditableText().toString();
            if ((paramView != null) && (paramView.length() > 0)) {
              MailAddrsViewControl.access$1000(this.this$0, paramView, true);
            } else if (MailAddrsViewControl.access$700(this.this$0) != null) {
              MailAddrsViewControl.access$700(this.this$0).enterForClearFocus(this.this$0, false);
            }
          }
          else if ((paramInt == 4) && (MailAddrsViewControl.access$700(this.this$0) != null))
          {
            MailAddrsViewControl.access$700(this.this$0).enterForClearFocus(this.this$0, true);
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.6
 * JD-Core Version:    0.7.0.1
 */