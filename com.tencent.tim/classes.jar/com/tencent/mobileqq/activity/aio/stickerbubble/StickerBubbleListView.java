package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import anot;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import xks;
import yfw;
import yfx;
import yfy;
import ygb;
import ygb.a;
import yge;
import ygf;
import ygg;
import ygg.a;

public class StickerBubbleListView
  extends ListView
  implements ygb.a, ygg.a
{
  private boolean aoO = true;
  private ygg b;
  private Rect bo;
  private BaseChatPie c;
  private WeakReference<StickerBubbleImageView> ex;
  
  public StickerBubbleListView(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.b = new ygg(this, this, xks.A(paramBaseChatPie.app));
    this.c = paramBaseChatPie;
  }
  
  private void a(float paramFloat1, float paramFloat2, a parama)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!f(localView, paramFloat1, paramFloat2)) {
          break label101;
        }
        if ((localView instanceof StickerBubbleLinearLayout))
        {
          localView = ((StickerBubbleLinearLayout)localView).a(paramFloat1 - localView.getLeft(), paramFloat2 - localView.getTop());
          if (((localView instanceof LinearLayout)) && (((LinearLayout)localView).getChildAt(0) != null)) {
            parama.fE(((LinearLayout)localView).getChildAt(0));
          }
        }
      }
      return;
      label101:
      i += 1;
    }
  }
  
  private boolean f(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < paramView.getLeft()) || (paramFloat1 > paramView.getRight())) {}
    while ((paramFloat2 < paramView.getTop()) || (paramFloat2 > paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public boolean D(float paramFloat1, float paramFloat2)
  {
    return !this.bo.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public void I(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, new ygf(this));
  }
  
  public void Um()
  {
    yfy.b(this, this.c.cL);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Object localObject = yfx.a(paramInt1);
    if (localObject == null) {}
    StickerBubbleAnimationView localStickerBubbleAnimationView;
    do
    {
      return;
      localObject = ((yfw)localObject).localPath;
      localStickerBubbleAnimationView = ygb.a().a(this.c.cL, getContext());
      if (this.aoO)
      {
        localStickerBubbleAnimationView.bringToFront();
        ygb.a().b(this);
        this.aoO = false;
      }
    } while (localObject == null);
    localStickerBubbleAnimationView.a(yfy.a(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, paramInt2));
  }
  
  public void cia() {}
  
  public void cib()
  {
    cie();
    this.b.cih();
  }
  
  public void cie()
  {
    yfy.a(this, this.c.cL);
  }
  
  public void cif()
  {
    if (this.ex != null)
    {
      StickerBubbleImageView localStickerBubbleImageView = (StickerBubbleImageView)this.ex.get();
      if (localStickerBubbleImageView != null) {
        localStickerBubbleImageView.cid();
      }
    }
  }
  
  public int e(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    a(paramFloat1, paramFloat2, new yge(this, arrayOfInt));
    return arrayOfInt[0];
  }
  
  public void fN(int paramInt1, int paramInt2)
  {
    ygb.a().d(getContext()).KO();
    yfw localyfw = yfx.a(paramInt1);
    if (localyfw != null)
    {
      yfy.a(localyfw, this.c.app.getCurrentUin());
      this.c.ve(null);
      ThreadManager.post(new StickerBubbleListView.2(this, localyfw, paramInt2), 10, null, false);
      anot.a(this.c.getApp(), "dc00898", "", this.c.sessionInfo.aTl, "0X8009222", "0X8009222", localyfw.pokeemoId, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.b.n(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public int wG()
  {
    return xks.c(this.c.app, 10);
  }
  
  public static abstract interface a
  {
    public abstract void fE(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView
 * JD-Core Version:    0.7.0.1
 */