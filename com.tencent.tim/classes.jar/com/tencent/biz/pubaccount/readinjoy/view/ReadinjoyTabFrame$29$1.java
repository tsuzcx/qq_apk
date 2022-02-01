package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import kxm;
import nin;

public class ReadinjoyTabFrame$29$1
  implements Runnable
{
  public ReadinjoyTabFrame$29$1(nin paramnin) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.val$activity, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    this.a.val$activity.startActivity(localIntent);
    kxm.bA("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.29.1
 * JD-Core Version:    0.7.0.1
 */