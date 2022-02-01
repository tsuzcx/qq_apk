package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import aobw;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10$1
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10$1(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10 param10, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.this$0.getActivity(), QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.val$url)) {}
    for (String str = this.val$url;; str = "https://docs.qq.com/desktop/m/index.html?_from=1")
    {
      str = aobw.bD(str, "s_qq_myfile");
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
      this.a.this$0.startActivity(localIntent.putExtra("url", str));
      this.a.this$0.getActivity().overridePendingTransition(2130772000, 2130772001);
      this.a.this$0.getActivity().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10.1
 * JD-Core Version:    0.7.0.1
 */