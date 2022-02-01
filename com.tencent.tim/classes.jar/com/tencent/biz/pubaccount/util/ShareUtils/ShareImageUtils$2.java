package com.tencent.biz.pubaccount.util.ShareUtils;

import android.content.Context;
import com.tencent.mobileqq.startup.step.CheckPermission;
import mqq.app.AppActivity;
import oeg;
import oei;

public final class ShareImageUtils$2
  implements Runnable
{
  public ShareImageUtils$2(Context paramContext) {}
  
  public void run()
  {
    if ((this.val$context instanceof AppActivity))
    {
      if (!CheckPermission.isHasStoragePermission(this.val$context)) {
        CheckPermission.requestSDCardPermission((AppActivity)this.val$context, new oei(this));
      }
      oeg.access$000();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.2
 * JD-Core Version:    0.7.0.1
 */