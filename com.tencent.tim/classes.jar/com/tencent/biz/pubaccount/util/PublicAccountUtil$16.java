package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import kbp;

public final class PublicAccountUtil$16
  implements Runnable
{
  public PublicAccountUtil$16(Uri paramUri, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        String str = this.f.getQueryParameter("article_id");
        int i = this.bem;
        if (this.bem == 0)
        {
          i = 100;
          kbp.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", this.ben, 0, str, this.apL, "" + i, "", false);
          kbp.d("0X8006DF8", "", str, this.apL, "" + i, "" + this.ben);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.16
 * JD-Core Version:    0.7.0.1
 */