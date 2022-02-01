package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.widget.EditText;
import apkt;
import aplj.a;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class XMediaEditor$1
  implements Runnable
{
  XMediaEditor$1(XMediaEditor paramXMediaEditor, aplj.a parama) {}
  
  public void run()
  {
    this.a.mEditText.requestFocus();
    this.a.mEditText.findFocus();
    EditText localEditText = this.a.mEditText;
    if (XMediaEditor.a(this.this$0).dUT >= 0) {}
    for (int i = XMediaEditor.a(this.this$0).dUT;; i = 0)
    {
      localEditText.setSelection(i);
      ThreadManager.getUIHandler().post(new XMediaEditor.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.1
 * JD-Core Version:    0.7.0.1
 */