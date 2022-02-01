package com.tencent.mobileqq.activity.weather;

import abcm;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;

public class SessionClearFragment$1$1
  implements Runnable
{
  public SessionClearFragment$1$1(abcm paramabcm, List paramList) {}
  
  public void run()
  {
    this.a.a.vL = this.val$itemInfoList;
    this.a.a.dismissProgressDialog();
    SessionClearFragment.a(this.a.a).setVisibility(0);
    if ((this.val$itemInfoList == null) || (this.val$itemInfoList.size() == 0))
    {
      SessionClearFragment.a(this.a.a).setVisibility(0);
      return;
    }
    this.a.a.hP(this.val$itemInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */