package com.tencent.mobileqq.gamecenter.share;

import ahtt;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import ansr;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import mqq.util.WeakReference;
import wja;
import xtj;
import xuf;

public class GameShareUtil$2$1
  implements Runnable
{
  public GameShareUtil$2$1(ahtt paramahtt, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject1 = (Context)this.this$0.aD.get();
    TextView localTextView = (TextView)this.this$0.aE.get();
    Object localObject2 = (xtj)this.this$0.aF.get();
    if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()) && (localTextView != null) && (localObject2 != null) && (((xtj)localObject2).b() != null) && (((xtj)localObject2).b().e != null) && (((xtj)localObject2).b().e.id == this.this$0.val$id) && (((xtj)localObject2).b().e.subId == this.this$0.aaV))
    {
      localObject2 = this.val$d;
      localObject1 = ((Context)localObject1).getResources();
      localObject2 = new BitmapDrawable(ansr.e((Drawable)localObject2));
      localTextView.setCompoundDrawablePadding(wja.dp2px(3.0F, (Resources)localObject1));
      ((Drawable)localObject2).setBounds(0, 0, wja.dp2px(20.0F, (Resources)localObject1), wja.dp2px(20.0F, (Resources)localObject1));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareUtil.2.1
 * JD-Core Version:    0.7.0.1
 */