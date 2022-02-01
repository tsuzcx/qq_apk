package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import ybt;

public class NearbyChatPie$7
  implements Runnable
{
  public NearbyChatPie$7(ybt paramybt) {}
  
  public void run()
  {
    Intent localIntent = this.this$0.mActivity.getIntent();
    localIntent.putExtra("uintype", 0);
    ybt.a(this.this$0, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7
 * JD-Core Version:    0.7.0.1
 */