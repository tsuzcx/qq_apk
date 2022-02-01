package com.tencent.biz.pubaccount.readinjoy.drawable;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import lae;
import lai;

public class ReadInJoyLottieDrawable$4
  implements Runnable
{
  public ReadInJoyLottieDrawable$4(lae paramlae, File[] paramArrayOfFile, File paramFile, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromInputStream(BaseApplication.getContext(), new FileInputStream(this.b[0]), new lai(this));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyLottieDrawable", 2, "loadFromFile", localFileNotFoundException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4
 * JD-Core Version:    0.7.0.1
 */