package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import aobf;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

public class TeamWorkForceShare$2$1
  implements Runnable
{
  TeamWorkForceShare$2$1(TeamWorkForceShare.2 param2, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new aobf(this);
    WXShareHelper.a().a((WXShareHelper.a)localObject);
    TeamWorkForceShare.a(this.a.this$0, String.valueOf(System.currentTimeMillis()));
    localObject = WXShareHelper.a();
    String str = this.val$filePath;
    Bitmap localBitmap = this.val$bmp;
    if (this.a.cLb) {}
    for (int i = 0;; i = 1)
    {
      ((WXShareHelper)localObject).a(str, localBitmap, 280, i, TeamWorkForceShare.b(this.a.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1
 * JD-Core Version:    0.7.0.1
 */