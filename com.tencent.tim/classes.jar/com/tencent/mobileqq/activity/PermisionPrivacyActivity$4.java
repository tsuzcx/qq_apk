package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class PermisionPrivacyActivity$4
  implements Runnable
{
  PermisionPrivacyActivity$4(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((acff)this.this$0.app.getManager(51)).cn();
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (int i = 0;; i = localArrayList.size())
    {
      PermisionPrivacyActivity.a(this.this$0, i);
      this.this$0.runOnUiThread(new PermisionPrivacyActivity.4.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.4
 * JD-Core Version:    0.7.0.1
 */