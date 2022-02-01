package com.tencent.mobileqq.emoticonview;

import afnm;
import aiad;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;

public class EmotionPanelListView
  extends ListView
{
  private a b;
  private boolean bZW;
  
  public EmotionPanelListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmotionPanelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void abordFling()
  {
    super.abordFling();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.bZW) || (paramMotionEvent.getAction() != 0)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    AbsListView.e locale = getOnScrollListener();
    if ((locale instanceof afnm)) {
      ((afnm)locale).onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bZW) {
      return super.onTouchEvent(paramMotionEvent);
    }
    AbsListView.e locale = getOnScrollListener();
    if ((locale instanceof afnm)) {
      ((afnm)locale).onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEnableExtendPanle(boolean paramBoolean)
  {
    this.bZW = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    if ((this.bZW) && (!(parame instanceof afnm)) && (parame != null))
    {
      super.setOnScrollListener(new afnm(this, this.b, parame));
      return;
    }
    super.setOnScrollListener(parame);
  }
  
  public void setPullAndFastScrollListener(a parama)
  {
    this.b = parama;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    if (!this.bZW) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    AbsListView.e locale = getOnScrollListener();
    if ((!bool) && ((locale instanceof afnm)) && (paramInt2 < 0)) {
      ((afnm)locale).a().onMove(Math.abs(paramInt2));
    }
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean ajy();
    
    public abstract void cZu();
    
    public abstract void cZv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListView
 * JD-Core Version:    0.7.0.1
 */