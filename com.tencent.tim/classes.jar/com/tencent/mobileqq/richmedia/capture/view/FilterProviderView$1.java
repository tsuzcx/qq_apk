package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FilterProviderView$1
  implements Runnable
{
  FilterProviderView$1(FilterProviderView paramFilterProviderView) {}
  
  public void run()
  {
    FilterProviderView.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "FilterProviderView onCaptureVideoFilterRefresh size=" + this.this$0.lI.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FilterProviderView.1
 * JD-Core Version:    0.7.0.1
 */