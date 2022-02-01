package com.tencent.mobileqq.forward;

import ahgq;
import ahgu;
import android.content.res.Resources;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ForwardBaseOption$2$3
  implements Runnable
{
  public ForwardBaseOption$2$3(ahgu paramahgu) {}
  
  public void run()
  {
    if (aqiw.getSystemNetwork(BaseApplication.getContext()) != 0) {
      QQToast.a(this.a.this$0.app.getApp(), 2, 2131693980, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.2.3
 * JD-Core Version:    0.7.0.1
 */