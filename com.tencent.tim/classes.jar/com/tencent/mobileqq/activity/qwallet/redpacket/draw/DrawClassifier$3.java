package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaeh;
import aaeh.b;
import aafa;
import aagd;
import com.tencent.qphone.base.util.QLog;
import wrb;

public class DrawClassifier$3
  implements Runnable
{
  public DrawClassifier$3(aaeh paramaaeh, aaeh.b paramb, wrb paramwrb) {}
  
  public void run()
  {
    try
    {
      if (!aaeh.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_Aaeh$b != null) {
          this.jdField_a_of_type_Aaeh$b.Cf(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = aaeh.a(this.this$0).a(this.jdField_a_of_type_Wrb, aaeh.b(this.this$0), this.this$0.threshold, aaeh.a(this.this$0));
      if (this.jdField_a_of_type_Aaeh$b != null) {
        this.jdField_a_of_type_Aaeh$b.Cf(bool);
      }
      if (QLog.isColorLevel()) {
        QLog.i("DrawClassifier", 2, "recognize cost:" + (System.currentTimeMillis() - l));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "recognition throwable:" + aagd.c(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_Aaeh$b == null);
      this.jdField_a_of_type_Aaeh$b.Cf(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */