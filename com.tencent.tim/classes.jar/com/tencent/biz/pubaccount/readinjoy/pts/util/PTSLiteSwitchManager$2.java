package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.text.TextUtils;
import java.util.List;
import lvl;
import lvx;
import lvy;
import lwe;
import mix;

public class PTSLiteSwitchManager$2
  implements Runnable
{
  public PTSLiteSwitchManager$2(lvy paramlvy) {}
  
  public void run()
  {
    String[] arrayOfString = lvy.j();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ((TextUtils.equals(arrayOfString[i], "ugc_add_account")) && (mix.DH())) {
        lvy.a(this.this$0).add("ugc_add_account");
      }
      i += 1;
    }
    if ((lvy.a(this.this$0) != null) && (lvy.a(this.this$0).size() > 0) && (!lvy.a(this.this$0)))
    {
      lvx.aNJ();
      lvl.a().load("ptslite");
      lwe.a().aNN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager.2
 * JD-Core Version:    0.7.0.1
 */