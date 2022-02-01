package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.widget.XListView;
import zaf;

class DeviceFragment$1
  implements Runnable
{
  DeviceFragment$1(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getCount() > 0))
    {
      int i = this.this$0.a.ya();
      if ((i >= 0) && (i < this.this$0.a.getCount())) {
        this.this$0.mListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.1
 * JD-Core Version:    0.7.0.1
 */