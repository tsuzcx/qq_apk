package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.widget.EditText;
import aplj.a;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class XMediaEditor$2
  implements Runnable
{
  XMediaEditor$2(XMediaEditor paramXMediaEditor, aplj.a parama) {}
  
  public void run()
  {
    this.a.mEditText.clearFocus();
    ThreadManager.getUIHandler().post(new XMediaEditor.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.2
 * JD-Core Version:    0.7.0.1
 */