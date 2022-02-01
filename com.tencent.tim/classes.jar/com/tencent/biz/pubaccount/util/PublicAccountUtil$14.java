package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import kbp;

public final class PublicAccountUtil$14
  implements Runnable
{
  public PublicAccountUtil$14(Uri paramUri, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      kbp.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006510", "0X8006510", 0, 0, this.f.getQueryParameter("article_id"), this.bem + "", this.apK, "", false);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.14
 * JD-Core Version:    0.7.0.1
 */