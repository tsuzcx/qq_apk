package com.tencent.mobileqq.activity.bless;

import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import java.util.ArrayList;

class BlessSelectMemberActivity$4
  implements Runnable
{
  BlessSelectMemberActivity$4(BlessSelectMemberActivity paramBlessSelectMemberActivity, TextView paramTextView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = 0;
    String str1;
    if (this.val$tv.getLineCount() >= 4)
    {
      int j = this.val$tv.getLayout().getLineEnd(3);
      if (j < this.val$sb.length())
      {
        str1 = String.format(this.this$0.getString(2131690918), new Object[] { "...", Integer.valueOf(this.this$0.uinList.size()) });
        float f = this.val$tv.getPaint().measureText(str1);
        if (i < this.val$sb.length())
        {
          String str2 = this.val$sb.substring(j - i, j);
          if (this.val$tv.getPaint().measureText(str2) < f) {
            break label233;
          }
          this.val$sb.setLength(j - i);
        }
        BlessSelectMemberActivity.a(this.this$0, this.val$sb.toString());
        if (!BlessSelectMemberActivity.b(this.this$0).endsWith("、 ")) {
          break label240;
        }
        this.val$sb.setLength(this.val$sb.length() - 2);
      }
    }
    for (;;)
    {
      this.val$sb.append(str1);
      BlessSelectMemberActivity.a(this.this$0, this.val$sb.toString());
      this.val$tv.setEllipsize(null);
      this.val$tv.setText(BlessSelectMemberActivity.b(this.this$0));
      return;
      label233:
      i += 1;
      break;
      label240:
      if (BlessSelectMemberActivity.b(this.this$0).endsWith("、")) {
        this.val$sb.setLength(this.val$sb.length() - 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.4
 * JD-Core Version:    0.7.0.1
 */