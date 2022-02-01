package com.tencent.mobileqq.haoliyou;

import acfp;
import ahwk;
import ahwl;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      aqha.b(localBaseActivity, 0, null, acfp.m(2131707514), localBaseActivity.getString(2131721058), localBaseActivity.getString(2131721079), new ahwk(this), new ahwl(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */