package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.EditText;
import aurd;
import com.tencent.qphone.base.util.QLog;

class SubmitHomeWorkFragment$6
  implements Runnable
{
  SubmitHomeWorkFragment$6(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void run()
  {
    EditText localEditText = this.this$0.a(this.this$0.mRoot);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "弹起键盘");
    }
    if (localEditText != null) {
      aurd.aO(localEditText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.6
 * JD-Core Version:    0.7.0.1
 */