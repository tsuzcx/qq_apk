package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.qphone.base.remote.SimpleAccount;
import vvy;
import vvz;

public class SubAccountBindActivity$3$1$1
  implements Runnable
{
  public SubAccountBindActivity$3$1$1(vvz paramvvz) {}
  
  public void run()
  {
    this.a.a.a.ath();
    this.a.a.a.wz(this.a.a.a.getString(2131720605));
    Intent localIntent = new Intent(this.a.a.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.d.getUin());
    localIntent.putExtra("fromWhere", this.a.a.a.aOa);
    this.a.a.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */