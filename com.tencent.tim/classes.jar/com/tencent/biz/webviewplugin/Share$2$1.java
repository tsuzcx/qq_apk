package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import aqzv;
import ardm.o;
import arhz;
import java.lang.ref.WeakReference;
import svi;

class Share$2$1
  implements Runnable
{
  Share$2$1(Share.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    aqzv localaqzv = (aqzv)this.a.this$0.ds.get();
    if ((localaqzv != null) && ((localaqzv instanceof ardm.o)) && (((ardm.o)localaqzv).mc()) && (!this.a.this$0.activity.isFinishing()))
    {
      if ((this.a.this$0.s != null) && (this.a.this$0.s.isShowing())) {
        this.a.this$0.s.dismiss();
      }
      svi.a(this.a.this$0, this.a.bzp, this.a.this$0.zc, this.a.this$0.aue, this.a.this$0.mShareUrl, this.a.this$0.auf, this.df);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.2.1
 * JD-Core Version:    0.7.0.1
 */