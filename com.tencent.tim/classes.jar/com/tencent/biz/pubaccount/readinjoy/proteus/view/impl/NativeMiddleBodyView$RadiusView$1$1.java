package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import ltj;

public class NativeMiddleBodyView$RadiusView$1$1
  implements Runnable
{
  public NativeMiddleBodyView$RadiusView$1$1(ltj paramltj, int paramInt1, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    QLog.i(NativeMiddleBodyView.access$000(), 1, "setLayoutParams width:" + this.val$width + " height:" + this.val$height + " old: " + this.p.width + ":" + this.p.height);
    this.a.b.setLayoutParams(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView.RadiusView.1.1
 * JD-Core Version:    0.7.0.1
 */