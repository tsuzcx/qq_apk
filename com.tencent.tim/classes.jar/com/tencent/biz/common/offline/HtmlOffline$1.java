package com.tencent.biz.common.offline;

import android.content.Context;
import joy;
import jpa;
import jpa.b;
import jpj;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, joy paramjoy) {}
  
  public void run()
  {
    if (jpa.a.isColorLevel()) {
      jpa.a.i("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new jpa.b(this.I, this.val$url, this.a).ayS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */