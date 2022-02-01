package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import aquz;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;
import zxt;
import zxu;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(zxu paramzxu, aquz paramaquz) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Aquz.GP.size();
    Bundle localBundle = this.jdField_a_of_type_Aquz.getParams();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Aquz.GP.get(i);
      zxt.a(this.jdField_a_of_type_Zxu.this$0, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */