package com.tencent.mobileqq.structmsg.view;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ante;
import ante.a;
import com.tencent.widget.SingleLineTextView;

public class StructMsgItemLayout20$1
  implements Runnable
{
  public StructMsgItemLayout20$1(ante paramante, int paramInt, ante.a parama) {}
  
  public void run()
  {
    int i = this.dMu;
    int j = this.a.Zw.getWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.F.getLayoutParams();
    localLayoutParams.rightMargin = (j + i);
    this.a.F.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1
 * JD-Core Version:    0.7.0.1
 */