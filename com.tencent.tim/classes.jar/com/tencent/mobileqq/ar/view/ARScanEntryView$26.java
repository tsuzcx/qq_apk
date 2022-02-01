package com.tencent.mobileqq.ar.view;

import adda;
import adlg;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;

public class ARScanEntryView$26
  implements Runnable
{
  ARScanEntryView$26(ARScanEntryView paramARScanEntryView, adda paramadda, ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void run()
  {
    ARScanEntryView.d(this.this$0);
    this.this$0.ip.setVisibility(8);
    this.this$0.bv.setVisibility(0);
    this.this$0.bv.setOnClickListener(new adlg(this));
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARScanEntryView", 2, "onMultiARAnimationInteraction 请点击屏幕进入下一动画片段！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.26
 * JD-Core Version:    0.7.0.1
 */