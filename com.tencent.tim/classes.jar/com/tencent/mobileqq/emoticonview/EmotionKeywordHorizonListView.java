package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.widget.HorizontalListView;

public class EmotionKeywordHorizonListView
  extends HorizontalListView
{
  private a a;
  public int mType = 0;
  
  public EmotionKeywordHorizonListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.Ao(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((localView instanceof EmojiStickerManager.EmotionKeywordLayout)) && (((EmojiStickerManager.EmotionKeywordLayout)localView).bYJ)) {
        return localView.onTouchEvent(paramMotionEvent);
      }
      i += 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsFromRightToLeft(boolean paramBoolean)
  {
    this.isFromRightToLeft = paramBoolean;
    invalidate();
  }
  
  public void setTouchListener(a parama)
  {
    this.a = parama;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Ao(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView
 * JD-Core Version:    0.7.0.1
 */