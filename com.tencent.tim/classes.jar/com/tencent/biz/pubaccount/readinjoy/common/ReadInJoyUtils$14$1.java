package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;
import kxm;
import kxn;

public class ReadInJoyUtils$14$1
  implements Runnable
{
  public ReadInJoyUtils$14$1(kxn paramkxn) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.val$activity, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_dian_dian", true);
    localIntent.putExtra("support_topic", true);
    this.this$0.val$activity.startActivity(localIntent);
    kxm.bA("3", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.14.1
 * JD-Core Version:    0.7.0.1
 */