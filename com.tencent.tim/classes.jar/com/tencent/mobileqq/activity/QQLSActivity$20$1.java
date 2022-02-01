package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import vof;

public class QQLSActivity$20$1
  implements Runnable
{
  public QQLSActivity$20$1(vof paramvof) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "do SmoothFinish at run");
    }
    QQLSActivity.g(this.a.this$0);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.20.1
 * JD-Core Version:    0.7.0.1
 */