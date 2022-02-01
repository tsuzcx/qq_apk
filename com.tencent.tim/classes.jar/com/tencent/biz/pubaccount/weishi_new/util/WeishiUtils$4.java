package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.net.URL;
import java.util.List;
import noy;
import noz;
import opn;
import opr;

public final class WeishiUtils$4
  implements Runnable
{
  public WeishiUtils$4(List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.ik.size())
    {
      Object localObject = opn.a((stSimpleMetaFeed)this.ik.get(i), this.axX);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = opn.b((String)localObject);
        noz localnoz = new noz();
        localnoz.url = ((URL)localObject);
        localnoz.isPreload = true;
        noy.a().a(localnoz, new opr(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4
 * JD-Core Version:    0.7.0.1
 */