package com.tencent.mobileqq.activity.fling;

import afqm;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatFragment.b;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.concurrent.ConcurrentHashMap;
import xkx.a;
import xla;
import xwn;
import xyi;
import xys;

public class TopGestureLayout
  extends RelativeLayout
{
  public static final int FLAG_GESTURE_END = -1;
  public static final int FLAG_GESTURE_FLINE_RL = 2;
  public static final int FLAG_GESTURE_FLING_LR = 1;
  public static final int FLAG_GESTURE_IDLE = 0;
  public static final String TAG = "TopGestureLayout";
  InterceptTouchEventListener a;
  private int akk;
  private boolean bqQ = true;
  private boolean bqR;
  private boolean bqS = true;
  private boolean bqT;
  protected GestureDetector.SimpleOnGestureListener c;
  public GestureDetector defaultGestureDetector;
  public ChatFragment.b mMyDispatchDrawListener;
  public OnGestureListener mOnFlingGesture;
  public GestureDetector mTopGestureDetector;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, ChatFragment.b paramb, InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    init(paramContext);
    this.mMyDispatchDrawListener = paramb;
    this.a = paramInterceptTouchEventListener;
  }
  
  private void coF()
  {
    if (this.bqT) {
      QLog.e("TopGestureLayout", 1, "TGRemoveCatchedException ", new RuntimeException("TGRemoveCatchedException"));
    }
  }
  
  public boolean Vk()
  {
    if (this.mTopGestureDetector != null)
    {
      if ((this.mTopGestureDetector instanceof afqm)) {
        return ((afqm)this.mTopGestureDetector).isInTowFingerMode;
      }
      if ((this.mTopGestureDetector instanceof StickerDismissGestureDetector)) {
        return ((StickerDismissGestureDetector)this.mTopGestureDetector).isInTowFingerMode;
      }
    }
    return false;
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    coF();
    super.detachViewFromParent(paramInt);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    coF();
    super.detachViewFromParent(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      try
      {
        super.dispatchDraw(paramCanvas);
        if (this.mMyDispatchDrawListener == null) {
          continue;
        }
        this.mMyDispatchDrawListener.bJA();
        return;
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.OnDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public GestureDetector getGestureDetector()
  {
    return this.mTopGestureDetector;
  }
  
  public GestureDetector.SimpleOnGestureListener getGestureListener()
  {
    return this.c;
  }
  
  public int getPaddingTop()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ImmersiveUtils.getStatusBarHeight(getContext());
    }
    return super.getPaddingTop();
  }
  
  public boolean hasGestureFlag(int paramInt)
  {
    return (!isGestureEnd()) && ((this.akk & paramInt) == paramInt);
  }
  
  protected void init(Context paramContext)
  {
    this.c = new TopGestureDetector(paramContext);
    this.mTopGestureDetector = new StickerDismissGestureDetector(paramContext, this.c);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean isGestureEnd()
  {
    return this.akk == -1;
  }
  
  public boolean isGestureIdle()
  {
    return this.akk == 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bqQ) {}
    while ((this.a != null) && (!this.a.OnInterceptTouchEvent(paramMotionEvent))) {
      return false;
    }
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bqT = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.bqT = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void removeView(View paramView)
  {
    coF();
    super.removeView(paramView);
  }
  
  public void removeViewInLayout(View paramView)
  {
    coF();
    super.removeViewInLayout(paramView);
  }
  
  public void restoreGestureDetector()
  {
    if (this.defaultGestureDetector != null)
    {
      this.mTopGestureDetector = this.defaultGestureDetector;
      return;
    }
    this.mTopGestureDetector = new StickerDismissGestureDetector(getContext(), this.c);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mTopGestureDetector = paramGestureDetector;
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.akk = paramInt;
      return;
    }
    this.akk = (this.akk & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void setInterceptScrollLRFlag(boolean paramBoolean)
  {
    this.bqS = paramBoolean;
  }
  
  public void setInterceptScrollRLFlag(boolean paramBoolean)
  {
    this.bqR = paramBoolean;
  }
  
  public void setInterceptTouchEventListener(InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    this.a = paramInterceptTouchEventListener;
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    this.bqQ = paramBoolean;
  }
  
  public void setMyDispatchDrawListener(ChatFragment.b paramb)
  {
    this.mMyDispatchDrawListener = paramb;
  }
  
  public void setOnFlingGesture(OnGestureListener paramOnGestureListener)
  {
    this.mOnFlingGesture = paramOnGestureListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.setPadding(paramInt1, ImmersiveUtils.getStatusBarHeight(getContext()), paramInt3, paramInt4);
      return;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPadding2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static abstract interface InterceptTouchEventListener
  {
    public abstract void OnDispatchTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnChangeMultiScreenListener
  {
    public abstract void onChangeMultiScreen(boolean paramBoolean);
  }
  
  public static abstract interface OnGestureListener
  {
    public abstract void flingLToR();
    
    public abstract void flingRToL();
  }
  
  public class StickerDismissGestureDetector
    extends GestureDetector
  {
    private ChatXListView b;
    private int cdi;
    private int cdj = 1;
    private int cdk;
    public boolean isInTowFingerMode;
    private float qZ;
    private float ra;
    
    public StickerDismissGestureDetector(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      super(paramOnGestureListener);
    }
    
    void a(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
    {
      float f2 = paramMotionEvent.getX(this.cdi) - this.qZ;
      float f1 = paramMotionEvent.getX(this.cdj) - this.ra;
      this.qZ = paramMotionEvent.getX(this.cdi);
      this.ra = paramMotionEvent.getX(this.cdj);
      int i;
      if (f2 * f1 < 0.0F) {
        if (f2 < 0.0F)
        {
          i = EmojiStickerManager.DISPLAY;
          this.cdk = i;
          if (paramChatXListView == null) {
            break label410;
          }
          i = paramChatXListView.getChildCount() - 1;
          label92:
          if (i < 0) {
            break label418;
          }
          paramMotionEvent = paramChatXListView.getChildAt(i);
          if (!(paramMotionEvent instanceof BaseChatItemLayout)) {
            break label230;
          }
          paramMotionEvent = (BaseChatItemLayout)paramMotionEvent;
          if (this.cdk != EmojiStickerManager.DISPLAY) {
            break label187;
          }
          f2 = Math.min(0.0F, f2);
          f1 = Math.max(0.0F, f1);
          paramMotionEvent.fl((int)Math.abs(f2 - f1), this.cdk);
        }
      }
      label156:
      label418:
      label419:
      for (;;)
      {
        float f3 = f2;
        float f4 = f1;
        label187:
        label230:
        int j;
        do
        {
          do
          {
            i -= 1;
            f1 = f4;
            f2 = f3;
            break label92;
            i = EmojiStickerManager.DISMISS;
            break;
            if (this.cdk != EmojiStickerManager.DISMISS) {
              break label419;
            }
            f2 = Math.max(0.0F, f2);
            f1 = Math.min(0.0F, f1);
            paramMotionEvent.fl((int)Math.abs(f2 - f1), this.cdk);
            break label156;
            f4 = f1;
            f3 = f2;
          } while (!(paramMotionEvent instanceof LinearLayout));
          j = ((LinearLayout)paramMotionEvent).getChildCount() - 1;
          f4 = f1;
          f3 = f2;
        } while (j < 0);
        Object localObject = ((LinearLayout)paramMotionEvent).getChildAt(j);
        f4 = f1;
        f3 = f2;
        if ((localObject instanceof StickerGrayTipLayout))
        {
          localObject = (StickerGrayTipLayout)localObject;
          if (this.cdk == EmojiStickerManager.DISPLAY)
          {
            f2 = Math.min(0.0F, f2);
            f1 = Math.max(0.0F, f1);
            ((StickerGrayTipLayout)localObject).fl((int)Math.abs(f2 - f1), this.cdk);
          }
        }
        for (;;)
        {
          j -= 1;
          break;
          f4 = f1;
          f3 = f2;
          if (this.cdk == EmojiStickerManager.DISMISS)
          {
            f3 = Math.max(0.0F, f2);
            f4 = Math.min(0.0F, f1);
            ((StickerGrayTipLayout)localObject).fl((int)Math.abs(f3 - f4), this.cdk);
          }
          f1 = f4;
          f2 = f3;
        }
        QLog.e("TopGestureLayout", 1, "caclLeftAndRightOffset but list view is null");
        return;
      }
    }
    
    public boolean checkPttSlide(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
    {
      if (paramChatXListView != null)
      {
        int i = paramChatXListView.getChildCount() - 1;
        while (i >= 0)
        {
          View localView = paramChatXListView.getChildAt(i);
          if ((localView.getTag() != null) && ((localView.getTag() instanceof xkx.a)) && (((xkx.a)localView.getTag()).SB()))
          {
            Rect localRect = new Rect();
            localView.getGlobalVisibleRect(localRect);
            if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
              return true;
            }
          }
          i -= 1;
        }
      }
      QLog.e("TopGestureLayout", 1, "checkPttSlide but list view is null");
      return false;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      Object localObject1;
      if (EmojiStickerManager.bYD)
      {
        localObject1 = TopGestureLayout.this.findViewById(2131374792);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
      if (EmojiStickerManager.bYC)
      {
        localObject1 = TopGestureLayout.this.findViewById(2131374789);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
      int i = paramMotionEvent.getPointerCount();
      if (i == 2)
      {
        localObject1 = BaseActivity.sTopActivity;
        if ((localObject1 instanceof FragmentActivity))
        {
          localObject1 = (FragmentActivity)localObject1;
          if (((FragmentActivity)localObject1).getChatFragment() != null)
          {
            localObject1 = ((FragmentActivity)localObject1).getChatFragment().a();
            if ((((localObject1 instanceof xwn)) || ((localObject1 instanceof xys)) || ((localObject1 instanceof xyi))) && (EmojiStickerManager.a().fj.size() > 0))
            {
              this.isInTowFingerMode = true;
              switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
              {
              }
              for (;;)
              {
                return true;
                localObject1 = TopGestureLayout.this.findViewById(2131370537);
                if ((localObject1 instanceof ChatXListView)) {
                  this.b = ((ChatXListView)localObject1);
                }
                this.qZ = paramMotionEvent.getX(0);
                continue;
                localObject1 = TopGestureLayout.this.findViewById(2131370537);
                if ((localObject1 instanceof ChatXListView)) {
                  this.b = ((ChatXListView)localObject1);
                }
                if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                {
                  this.cdi = 0;
                  this.cdj = 1;
                  this.qZ = paramMotionEvent.getX(0);
                  this.ra = paramMotionEvent.getX(1);
                }
                else
                {
                  this.cdi = 1;
                  this.cdj = 0;
                  this.qZ = paramMotionEvent.getX(1);
                  this.ra = paramMotionEvent.getX(0);
                  continue;
                  if (this.b == null)
                  {
                    localObject1 = TopGestureLayout.this.findViewById(2131370537);
                    if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
                      this.b = ((ChatXListView)localObject1);
                    }
                  }
                  a(paramMotionEvent, this.b);
                  continue;
                  this.b = null;
                }
              }
            }
          }
        }
        return super.onTouchEvent(paramMotionEvent);
      }
      boolean bool1;
      if (i == 1)
      {
        if (paramMotionEvent.getAction() != 1) {
          break label777;
        }
        xla.bhw = false;
        if (this.b == null)
        {
          localObject1 = TopGestureLayout.this.findViewById(2131370537);
          if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
            this.b = ((ChatXListView)localObject1);
          }
        }
        if (this.b == null) {
          break label766;
        }
        bool1 = false;
        i = this.b.getChildCount() - 1;
        if (i >= 0)
        {
          localObject1 = this.b.getChildAt(i);
          if ((localObject1 instanceof BaseChatItemLayout))
          {
            localObject1 = (BaseChatItemLayout)localObject1;
            if (bool1) {
              break label972;
            }
            bool1 = ((BaseChatItemLayout)localObject1).Rp();
          }
        }
      }
      label706:
      label972:
      for (;;)
      {
        ((BaseChatItemLayout)localObject1).bYS();
        boolean bool2 = bool1;
        do
        {
          i -= 1;
          bool1 = bool2;
          break;
          bool2 = bool1;
        } while (!(localObject1 instanceof LinearLayout));
        int j = ((LinearLayout)localObject1).getChildCount() - 1;
        Object localObject2;
        for (;;)
        {
          bool2 = bool1;
          if (j < 0) {
            break;
          }
          localObject2 = ((LinearLayout)localObject1).getChildAt(j);
          bool2 = bool1;
          if ((localObject2 instanceof StickerGrayTipLayout))
          {
            localObject2 = (StickerGrayTipLayout)localObject2;
            bool2 = bool1;
            if (!bool1) {
              bool2 = ((StickerGrayTipLayout)localObject2).Rp();
            }
            ((StickerGrayTipLayout)localObject2).bYS();
          }
          j -= 1;
          bool1 = bool2;
        }
        if (bool1)
        {
          i = EmojiStickerManager.a().mCurType;
          localObject1 = "1";
          if (i == 1)
          {
            localObject1 = "2";
            if (this.cdk != EmojiStickerManager.DISPLAY) {
              break label731;
            }
            VasWebviewUtil.reportCommercialDrainage("", "Stick", "Hide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
        else
        {
          this.b = null;
        }
        for (;;)
        {
          return super.onTouchEvent(paramMotionEvent);
          if (i != 3000) {
            break;
          }
          localObject1 = "3";
          break;
          label731:
          VasWebviewUtil.reportCommercialDrainage("", "Stick", "CancelHide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          break label706;
          label766:
          QLog.e("TopGestureLayout", 1, "on on pointer touch up but list view is null");
          break label706;
          if (paramMotionEvent.getAction() == 0)
          {
            this.isInTowFingerMode = false;
            localObject2 = TopGestureLayout.this.findViewById(2131370537);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = TopGestureLayout.this.findViewById(2131370538);
            }
            if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
              this.b = ((ChatXListView)localObject1);
            }
          }
          else if (paramMotionEvent.getAction() == 2)
          {
            if ((xla.bhw) || (xla.bhx)) {
              return false;
            }
            if (this.b == null)
            {
              localObject2 = TopGestureLayout.this.findViewById(2131370537);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = TopGestureLayout.this.findViewById(2131370538);
              }
              if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
                this.b = ((ChatXListView)localObject1);
              }
            }
            if (checkPttSlide(paramMotionEvent, this.b))
            {
              xla.bhw = true;
              return false;
            }
          }
          else if (paramMotionEvent.getAction() == 3)
          {
            xla.bhw = false;
            this.b = null;
          }
          else
          {
            xla.bhw = false;
          }
        }
      }
    }
  }
  
  public class TopGestureDetector
    extends GestureDetector.SimpleOnGestureListener
  {
    private float lB;
    
    public TopGestureDetector(Context paramContext)
    {
      this.lB = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      TopGestureLayout.this.setGestureFlag(0);
      return super.onDown(paramMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((TopGestureLayout.this.isGestureIdle()) || (TopGestureLayout.this.isGestureEnd())) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      if (TopGestureLayout.this.hasGestureFlag(1)) {
        if ((f1 < 0.0F) && (f2 < 0.5F) && (TopGestureLayout.this.mOnFlingGesture != null))
        {
          TopGestureLayout.this.setGestureFlag(-1);
          if (!TopGestureLayout.this.Vk()) {
            TopGestureLayout.this.mOnFlingGesture.flingLToR();
          }
        }
      }
      for (;;)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        if ((TopGestureLayout.this.hasGestureFlag(2)) && (f1 > 0.0F) && (f2 < 0.5F) && (TopGestureLayout.this.mOnFlingGesture != null))
        {
          TopGestureLayout.this.setGestureFlag(-1);
          if (!TopGestureLayout.this.Vk()) {
            TopGestureLayout.this.mOnFlingGesture.flingRToL();
          }
        }
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (TopGestureLayout.this.isGestureEnd()) {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      if (TopGestureLayout.this.isGestureIdle())
      {
        if (Math.abs(f1) > this.lB) {
          if ((paramFloat1 < 0.0F) && (f2 < 0.5F))
          {
            if (TopGestureLayout.a(TopGestureLayout.this))
            {
              TopGestureLayout.this.setGestureFlag(1);
              return true;
            }
          }
          else if ((paramFloat1 > 0.0F) && (f2 < 0.5F) && (TopGestureLayout.b(TopGestureLayout.this)))
          {
            TopGestureLayout.this.setGestureFlag(2);
            return true;
          }
        }
      }
      else
      {
        if (!TopGestureLayout.this.hasGestureFlag(1)) {
          break label200;
        }
        if ((paramFloat1 > 0.0F) || (f2 >= 0.5F)) {
          TopGestureLayout.this.setGestureFlag(-1);
        }
      }
      for (;;)
      {
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label200:
        if ((TopGestureLayout.this.hasGestureFlag(2)) && ((paramFloat1 < 0.0F) || (f2 >= 0.5F))) {
          TopGestureLayout.this.setGestureFlag(-1);
        }
      }
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      TopGestureLayout.this.setGestureFlag(-1);
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout
 * JD-Core Version:    0.7.0.1
 */