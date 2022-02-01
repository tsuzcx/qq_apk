package com.tencent.mobileqq.activity;

import android.content.Intent;
import aqjn.a;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import ufr;

public class ArkFullScreenAppActivity$8$1
  implements Runnable
{
  public ArkFullScreenAppActivity$8$1(ufr paramufr) {}
  
  public void run()
  {
    Intent localIntent = this.a.this$0.a(ArkFullScreenAppActivity.a(this.a.this$0).e);
    ArkAppCenter.a().postToMainThread(new ArkFullScreenAppActivity.8.1.1(this, localIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1
 * JD-Core Version:    0.7.0.1
 */