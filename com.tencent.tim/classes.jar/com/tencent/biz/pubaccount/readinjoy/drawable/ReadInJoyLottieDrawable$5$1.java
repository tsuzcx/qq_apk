package com.tencent.biz.pubaccount.readinjoy.drawable;

import awcf;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lae;
import laj;
import mqq.util.WeakReference;

public class ReadInJoyLottieDrawable$5$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$5$1(laj paramlaj) {}
  
  public void run()
  {
    if (awcf.d(this.this$0.D, this.this$0.val$file)) {}
    try
    {
      lae locallae = (lae)this.this$0.v.get();
      if (locallae != null) {
        lae.a(locallae, this.this$0.val$file);
      }
      this.this$0.D.delete();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyLottieDrawable", 1, this.this$0.tk + " download lottie resource fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.5.1
 * JD-Core Version:    0.7.0.1
 */