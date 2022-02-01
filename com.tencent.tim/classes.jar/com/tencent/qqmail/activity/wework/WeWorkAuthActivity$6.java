package com.tencent.qqmail.activity.wework;

import android.content.Intent;

class WeWorkAuthActivity$6
  implements Runnable
{
  WeWorkAuthActivity$6(WeWorkAuthActivity paramWeWorkAuthActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result_data", WeWorkAuthActivity.access$800(this.this$0, WeWorkAuthActivity.access$300(this.this$0), WeWorkAuthActivity.access$700(this.this$0)));
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.wework.WeWorkAuthActivity.6
 * JD-Core Version:    0.7.0.1
 */