package com.tencent.mobileqq.location.ui;

import aiqs;
import aitg;
import com.tencent.mobileqq.app.BaseActivity;

class LocationShareFragment$4
  implements Runnable
{
  LocationShareFragment$4(LocationShareFragment paramLocationShareFragment, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    aiqs.a(this.val$activity.app).dtR();
    if (LocationShareFragment.a(this.this$0) != null)
    {
      LocationShareFragment.a(this.this$0).onStop();
      LocationShareFragment.a(this.this$0).onDestroy();
      LocationShareFragment.a(this.this$0, null);
    }
    if (LocationShareFragment.a(this.this$0) != null) {
      LocationShareFragment.a(this.this$0, null);
    }
    if (LocationShareFragment.a(this.this$0) != null)
    {
      LocationShareFragment.a(this.this$0).dum();
      LocationShareFragment.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment.4
 * JD-Core Version:    0.7.0.1
 */