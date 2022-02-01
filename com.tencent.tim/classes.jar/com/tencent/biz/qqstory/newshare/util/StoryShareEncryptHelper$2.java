package com.tencent.biz.qqstory.newshare.util;

import acfp;
import android.app.Activity;
import android.content.Context;
import arhz;
import com.tencent.qphone.base.util.QLog;
import ppv;
import pzs;
import qdy.a;
import qdz;

public final class StoryShareEncryptHelper$2
  implements Runnable
{
  public StoryShareEncryptHelper$2(String paramString, arhz paramarhz, Context paramContext, qdy.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt params:" + this.val$params);
    }
    long l = System.currentTimeMillis();
    pzs localpzs = new pzs();
    localpzs.type = 2;
    localpzs.awo = this.val$params;
    arhz localarhz1;
    if (this.o != null)
    {
      arhz localarhz2 = this.o;
      localarhz1 = localarhz2;
      if (!localarhz2.isShowing())
      {
        localarhz2.show();
        localarhz1 = localarhz2;
      }
    }
    for (;;)
    {
      ppv.a().a(localpzs, new qdz(this, l, localarhz1));
      return;
      if ((this.val$context instanceof Activity))
      {
        localarhz1 = new arhz(this.val$context);
        localarhz1.setMessage(acfp.m(2131714978));
        localarhz1.show();
      }
      else
      {
        localarhz1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2
 * JD-Core Version:    0.7.0.1
 */