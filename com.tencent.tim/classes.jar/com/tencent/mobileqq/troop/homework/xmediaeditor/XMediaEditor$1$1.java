package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import aplj.a;

class XMediaEditor$1$1
  implements Runnable
{
  XMediaEditor$1$1(XMediaEditor.1 param1) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.this$0.getContext().getSystemService("input_method")).showSoftInput(this.a.a.mEditText, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1.1
 * JD-Core Version:    0.7.0.1
 */