package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.a;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import wko.a;

public class StickerGrayTipLayout
  extends LinearLayout
{
  public EmojiStickerManager.b a;
  private boolean amg;
  private int bOR;
  private boolean bdA;
  private MotionEvent i;
  MessageRecord message;
  private ArrayList<EmojiStickerManager.a> qb;
  
  public StickerGrayTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean B(float paramFloat1, float paramFloat2)
  {
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      Iterator localIterator = this.qb.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)localIterator.next();
        int k = locala.cRG;
        int m = this.bOR;
        int n = (int)((locala.scale - 1.0F) * locala.width);
        int j = (int)((locala.scale - 1.0F) * locala.height);
        k = k + m + locala.cRH - n / 2;
        j = locala.top - j / 2;
        if ((paramFloat1 > k) && (paramFloat1 < k + locala.scale * locala.width) && (paramFloat2 > j))
        {
          float f1 = j;
          float f2 = locala.scale;
          if (paramFloat2 < locala.height * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void bYR()
  {
    boolean bool;
    EmojiStickerManager.a locala;
    if ((this.amg) && (this.qb != null) && (this.qb.size() > 0))
    {
      Iterator localIterator = this.qb.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        locala = (EmojiStickerManager.a)localIterator.next();
        if (locala.cRG + this.bOR + locala.width / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(locala.cRH) > 200)
          {
            locala.cRH -= EmojiStickerManager.cRC;
            locala.alpha -= Math.abs(EmojiStickerManager.cRC / 2);
            locala.alpha = Math.min(255, Math.max(0, locala.alpha));
            label138:
            if (locala.cRH > 0)
            {
              locala.cRH = 0;
              locala.alpha = 255;
              this.amg = false;
              bool = false;
            }
            label164:
            if (locala.cRH < -400)
            {
              locala.cRH = -400;
              locala.alpha = 0;
              this.amg = false;
              bool = true;
            }
            if (locala.cRH <= 400) {
              break label434;
            }
            locala.cRH = 400;
            locala.alpha = 0;
            this.amg = false;
            bool = true;
          }
        }
      }
    }
    label412:
    label434:
    for (;;)
    {
      break;
      locala.alpha += Math.abs(EmojiStickerManager.cRC / 2);
      locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      locala.cRH += EmojiStickerManager.cRC;
      break label138;
      if (Math.abs(locala.cRH) < 200)
      {
        locala.alpha += Math.abs(EmojiStickerManager.cRC / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      }
      for (locala.cRH -= EmojiStickerManager.cRC;; locala.cRH += EmojiStickerManager.cRC)
      {
        if (locala.cRH >= 0) {
          break label412;
        }
        locala.cRH = 0;
        locala.alpha = 255;
        this.amg = false;
        bool = false;
        break;
        locala.alpha -= Math.abs(EmojiStickerManager.cRC / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      }
      break label164;
      if (this.message != null) {
        this.message.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  private boolean d(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int j;
    int k;
    do
    {
      return false;
      j = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      k = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (j * j + k * k >= 10000);
    return true;
  }
  
  public void Cj(int paramInt)
  {
    if (this.qb != null)
    {
      Iterator localIterator = this.qb.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)localIterator.next();
        locala.top += paramInt;
      }
    }
  }
  
  public boolean Rp()
  {
    return (this.qb != null) && (this.qb.size() > 0);
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString)
  {
    if (this.qb == null) {
      this.qb = new ArrayList();
    }
    if (this.qb.size() < EmojiStickerManager.cRB)
    {
      EmojiStickerManager.a locala = new EmojiStickerManager.a();
      if (paramDrawable != null)
      {
        locala.eD = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      locala.cRG = paramInt1;
      locala.top = paramInt2;
      locala.width = paramInt3;
      locala.height = paramInt4;
      locala.angle = paramDouble;
      locala.epId = paramString;
      this.qb.add(locala);
      return true;
    }
    return false;
  }
  
  public void bYS()
  {
    this.amg = true;
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Object localObject = getParent();
    if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getTag() instanceof wko.a))) {
      this.message = ((wko.a)((ViewGroup)localObject).getTag()).mMessage;
    }
    int j = getChildCount() - 1;
    while (j >= 0)
    {
      localObject = getChildAt(j);
      if (((View)localObject).getId() == 2131368123) {
        this.bOR = ((View)localObject).getLeft();
      }
      j -= 1;
    }
    if (this.qb != null)
    {
      j = 0;
      if (j <= this.qb.size() - 1)
      {
        localObject = (EmojiStickerManager.a)this.qb.get(j);
        if ((this.message != null) && (this.message.stickerHidden)) {
          if (((EmojiStickerManager.a)localObject).cRG + this.bOR + ((EmojiStickerManager.a)localObject).width / 2 >= getMeasuredWidth() / 2) {
            break label307;
          }
        }
        label307:
        for (int k = -400;; k = 400)
        {
          ((EmojiStickerManager.a)localObject).cRH = k;
          ((EmojiStickerManager.a)localObject).alpha = 0;
          k = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(((EmojiStickerManager.a)localObject).cRG + this.bOR + ((EmojiStickerManager.a)localObject).cRH, ((EmojiStickerManager.a)localObject).top);
          paramCanvas.rotate((float)((EmojiStickerManager.a)localObject).angle, ((EmojiStickerManager.a)localObject).width / 2, ((EmojiStickerManager.a)localObject).height / 2);
          ((EmojiStickerManager.a)localObject).eD.setAlpha(((EmojiStickerManager.a)localObject).alpha);
          ((EmojiStickerManager.a)localObject).eD.setBounds(0, 0, ((EmojiStickerManager.a)localObject).width, ((EmojiStickerManager.a)localObject).height);
          ((EmojiStickerManager.a)localObject).eD.draw(paramCanvas);
          paramCanvas.restoreToCount(k);
          j += 1;
          break;
        }
      }
    }
    bYR();
  }
  
  public void fl(int paramInt1, int paramInt2)
  {
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      int j;
      label45:
      EmojiStickerManager.a locala;
      int k;
      if ((this.message != null) && (this.message.stickerHidden))
      {
        j = 1;
        Iterator localIterator = this.qb.iterator();
        if (!localIterator.hasNext()) {
          break label447;
        }
        locala = (EmojiStickerManager.a)localIterator.next();
        if ((this.message != null) && (j != 0))
        {
          if (locala.cRG + this.bOR + locala.width / 2 >= getMeasuredWidth() / 2) {
            break label279;
          }
          k = -400;
          label110:
          locala.cRH = k;
          locala.alpha = 0;
        }
        if ((paramInt2 != EmojiStickerManager.DISMISS) || (locala.cRH != 0))
        {
          if (paramInt2 != EmojiStickerManager.DISPLAY) {
            break label302;
          }
          if (locala.cRG + this.bOR + locala.width / 2 >= getMeasuredWidth() / 2) {
            break label287;
          }
          locala.cRH -= paramInt1;
          locala.alpha -= Math.abs(paramInt1 / 2);
          locala.alpha = Math.min(255, Math.max(0, locala.alpha));
        }
      }
      label279:
      label287:
      label302:
      while (paramInt2 != EmojiStickerManager.DISMISS) {
        for (;;)
        {
          if (locala.cRH < -400)
          {
            locala.cRH = -400;
            locala.alpha = 0;
          }
          if (locala.cRH <= 400) {
            break label45;
          }
          locala.cRH = 400;
          locala.alpha = 0;
          break label45;
          j = 0;
          break;
          k = 400;
          break label110;
          locala.cRH += paramInt1;
        }
      }
      if (locala.cRG + this.bOR + locala.width / 2 < getMeasuredWidth() / 2)
      {
        locala.cRH += paramInt1;
        if (locala.cRH > 0)
        {
          locala.cRH = 0;
          locala.alpha = 255;
        }
      }
      for (;;)
      {
        locala.alpha += Math.abs(paramInt1 / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
        break;
        locala.cRH -= paramInt1;
        if (locala.cRH < 0)
        {
          locala.cRH = 0;
          locala.alpha = 255;
        }
      }
      label447:
      if ((j != 0) && (this.message != null)) {
        this.message.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (B(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      this.amg = false;
      paramInt2 = getMeasuredHeight();
      paramInt1 = 0;
      int k = 0;
      while (paramInt1 < this.qb.size())
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)this.qb.get(paramInt1);
        locala.alpha = 255;
        locala.cRH = 0;
        int j = paramInt2;
        if (locala.top + locala.height > paramInt2)
        {
          k = 1;
          j = locala.top + locala.height;
        }
        paramInt1 += 1;
        paramInt2 = j;
      }
      if (k != 0)
      {
        setMeasuredDimension(getMeasuredWidth(), paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("StickerGrayTipLayout", 2, "onMeasure bubbleBottm = " + paramInt2);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (B(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0) {
        if ((this.i != null) && (d(this.i, paramMotionEvent)))
        {
          this.bdA = true;
          if (this.a != null) {
            this.a.gt(this);
          }
        }
      }
      do
      {
        do
        {
          return true;
        } while (paramMotionEvent.getAction() != 1);
        this.i = MotionEvent.obtain(paramMotionEvent);
      } while (!this.bdA);
      this.bdA = false;
      this.i = null;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeAllStickers()
  {
    if (this.qb != null)
    {
      this.amg = false;
      this.qb.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */