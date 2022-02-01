package com.tencent.av.ui.beauty;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import ixq;

public abstract class BeautyBaseView
  extends RelativeLayout
  implements View.OnClickListener, BeautySeekView.a, ixq
{
  VideoAppInterface mApp;
  long oK = 0L;
  
  public BeautyBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void K(long paramLong, boolean paramBoolean) {}
  
  public void L(long paramLong, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.oK) > 200L))
    {
      this.oK = l;
      EffectSettingUi.a(this.mApp, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    if (this.mApp != paramVideoAppInterface) {
      this.mApp = paramVideoAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyBaseView
 * JD-Core Version:    0.7.0.1
 */