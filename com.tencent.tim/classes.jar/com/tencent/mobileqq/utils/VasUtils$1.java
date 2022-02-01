package com.tencent.mobileqq.utils;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.widget.QQToast;

public final class VasUtils$1
  implements Runnable
{
  public VasUtils$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    if ((this.val$context != null) && ((this.val$context instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.val$context;
      if ((localFragmentActivity.getChatFragment() != null) && (localFragmentActivity.getChatFragment().a() != null))
      {
        localFragmentActivity.getChatFragment().a().bHJ();
        if (!TextUtils.isEmpty(this.kd)) {
          QQToast.a(this.val$context, 0, this.kd, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils.1
 * JD-Core Version:    0.7.0.1
 */