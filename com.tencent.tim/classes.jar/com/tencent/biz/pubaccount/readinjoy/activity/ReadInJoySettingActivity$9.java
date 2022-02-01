package com.tencent.biz.pubaccount.readinjoy.activity;

import arhz;

class ReadInJoySettingActivity$9
  implements Runnable
{
  ReadInJoySettingActivity$9(ReadInJoySettingActivity paramReadInJoySettingActivity, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.aDG > 0) && (this.this$0.mProgress != null))
    {
      this.this$0.mProgress.setMessage(this.aDL);
      if (!this.this$0.mProgress.isShowing()) {
        this.this$0.mProgress.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.9
 * JD-Core Version:    0.7.0.1
 */