package com.tencent.mobileqq.bubble;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.reflect.Field;
import xkx.a;
import xla;

public class ChatXListView
  extends FPSXListView
{
  private static int cLj = 100;
  private static int cLk = cLj;
  private a jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a;
  private b jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$b;
  public c a;
  private d jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d;
  private boolean bRO;
  private boolean bRP;
  private boolean bRQ;
  private boolean bRR = true;
  private DashPathEffect jdField_c_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(new float[] { 2.0F, 6.0F }, 0.0F);
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private int mMeasuredHeight;
  private int mMeasuredWidth;
  private Paint mPaint = new Paint(1);
  private Path mPath = new Path();
  private float startY = -1.0F;
  
  public ChatXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    eb(paramContext);
  }
  
  private int BX()
  {
    try
    {
      Field localField = AbsListView.class.getDeclaredField("mSelectionBottomPadding");
      localField.setAccessible(true);
      int i = localField.getInt(this);
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("XListView", 1, "getSelectionBottomPadding: ", localException);
    }
    return 0;
  }
  
  private void GP(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "onDisableLayoutChanged() called with: mHasPendingLayout = [" + this.bRQ + "]");
      }
      if (this.bRQ) {
        requestLayout();
      }
    }
  }
  
  private void aO(Canvas paramCanvas)
  {
    if (!this.bRO) {}
    label7:
    Object localObject1;
    do
    {
      break label7;
      do
      {
        return;
      } while ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!BaseChatItemLayout.bdx));
      localObject1 = (AIOLongShotHelper)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
    } while ((localObject1 == null) || (!((AIOLongShotHelper)localObject1).RS()));
    int i = 0;
    int j;
    Object localObject2;
    View localView;
    if (i < getChildCount())
    {
      j = getFirstVisiblePosition() + i;
      localObject2 = getAdapter().getItem(j);
      localView = getChildAt(i);
      if (!(localObject2 instanceof ChatMessage)) {
        b(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      for (;;)
      {
        label117:
        i += 1;
        break;
        if (((AIOLongShotHelper)localObject1).n((ChatMessage)localObject2)) {
          break label165;
        }
        b(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      label165:
      this.mPaint.setColor(-5196865);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(2.0F);
      this.mPaint.setPathEffect(this.jdField_c_of_type_AndroidGraphicsDashPathEffect);
      if (j - 1 < 0) {
        break label782;
      }
      localObject2 = getAdapter().getItem(j - 1);
      if (!(localObject2 instanceof ChatMessage)) {
        break label782;
      }
    }
    label782:
    for (boolean bool1 = ((AIOLongShotHelper)localObject1).n((ChatMessage)localObject2);; bool1 = false)
    {
      if (j + 1 < getAdapter().getCount())
      {
        localObject2 = getAdapter().getItem(j + 1);
        if (!(localObject2 instanceof ChatMessage)) {}
      }
      for (boolean bool2 = ((AIOLongShotHelper)localObject1).n((ChatMessage)localObject2);; bool2 = false)
      {
        this.mPath.reset();
        this.mPath.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
        this.mPath.lineTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        this.mPath.moveTo(localView.getRight() - 1, localView.getTop() + 1);
        this.mPath.lineTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        if (!bool1)
        {
          this.mPath.reset();
          this.mPath.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
          this.mPath.lineTo(localView.getRight() - 1, localView.getTop() + 1);
          paramCanvas.drawPath(this.mPath, this.mPaint);
        }
        this.mPath.reset();
        this.mPath.moveTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        this.mPath.lineTo(localView.getLeft() + 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        this.mPath.moveTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        this.mPath.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        if (bool2) {
          break label117;
        }
        this.mPath.reset();
        this.mPath.moveTo(localView.getLeft() + 1, localView.getBottom() - 1);
        this.mPath.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        break label117;
        if (getChildCount() <= 0) {
          break;
        }
        localObject1 = getChildAt(getChildCount() - 1);
        if (((View)localObject1).getBottom() >= getBottom()) {
          break;
        }
        b(paramCanvas, ((View)localObject1).getLeft(), ((View)localObject1).getBottom(), ((View)localObject1).getRight(), getBottom());
        return;
      }
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaint.setColor(1711474714);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setPathEffect(null);
    paramCanvas.drawRect(paramInt1, paramInt2, paramInt3, paramInt4, this.mPaint);
  }
  
  private void cVc()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (BaseChatItemLayout.bdx)
      {
        Object localObject = (AIOLongShotHelper)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
        if ((localObject == null) || (!((AIOLongShotHelper)localObject).RS())) {
          break;
        }
        int i = 0;
        while (i < getChildCount())
        {
          localObject = getAdapter().getItem(getFirstVisiblePosition() + i);
          if ((localObject instanceof ChatMessage))
          {
            View localView = getChildAt(i);
            ((ChatMessage)localObject).setViewHeight(localView.getHeight());
          }
          i += 1;
        }
      }
    }
  }
  
  private void eb(Context paramContext)
  {
    if ((cLk == cLj) && ((paramContext instanceof Activity))) {
      ThreadManager.post(new ChatXListView.1(this, paramContext), 5, null, true);
    }
  }
  
  public void GO(boolean paramBoolean)
  {
    this.bRO = paramBoolean;
  }
  
  public boolean ae(MotionEvent paramMotionEvent)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
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
    return false;
  }
  
  public boolean afP()
  {
    return this.bRR;
  }
  
  public void cVd()
  {
    this.mListPadding.bottom = (BX() + getPaddingBottom());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int k = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a != null)
    {
      if (k != 0) {
        break label57;
      }
      if ((this.startY != -1.0F) || (!this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a.Pa())) {}
    }
    for (this.startY = paramMotionEvent.getY();; this.startY = -1.0F)
    {
      label57:
      do
      {
        do
        {
          return super.dispatchTouchEvent(paramMotionEvent);
        } while ((k != 1) && (k != 3) && (k != 2));
        float f = paramMotionEvent.getY();
        if (this.startY - f > cLk)
        {
          int i = j;
          if ((paramMotionEvent.getFlags() & 0x2) != 0)
          {
            i = j;
            if (paramMotionEvent.getToolType(0) == 0) {
              i = 1;
            }
          }
          if ((!xla.bhw) && (i == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a.bIp();
            this.startY = -1.0F;
          }
        }
      } while ((k != 1) && (k != 3));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a.bIq();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    aO(paramCanvas);
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    super.offsetChildrenTopAndBottom(paramInt);
    if ((paramInt != 0) && (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.Ad(paramInt);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo.getBoundsInScreen(localRect);
    localRect.bottom -= this.mListPadding.bottom;
    paramAccessibilityNodeInfo.setBoundsInScreen(localRect);
    if (QLog.isColorLevel()) {
      QLog.d("XListView", 2, "onInitializeAccessibilityNodeInfo() called with: info = [" + paramAccessibilityNodeInfo + "]");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d.af(paramMotionEvent))) {
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if (xla.bhw) {
        return false;
      }
      if (ae(paramMotionEvent))
      {
        xla.bhw = true;
        return false;
      }
    }
    else
    {
      xla.bhw = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.bRP) {
      this.bRQ = true;
    }
    do
    {
      return;
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      cVc();
    } while (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$b == null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$b.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.bRP)
    {
      this.bRQ = true;
      setMeasuredDimension(this.mMeasuredWidth, this.mMeasuredHeight);
    }
    do
    {
      return;
      super.onMeasure(paramInt1, paramInt2);
    } while (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$c == null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$c.bJg();
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if ((paramInt1 != 0) && (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.Ad(-paramInt1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d.ag(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setDisableLayout(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.bRP != paramBoolean)
    {
      this.bRP = paramBoolean;
      this.mMeasuredWidth = paramInt1;
      this.mMeasuredHeight = paramInt2;
      GP(paramBoolean);
    }
  }
  
  public void setOnLayoutListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$b = paramb;
  }
  
  public void setOnMeasureListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$c = paramc;
  }
  
  public void setOnTouchEventConsumer(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$d = paramd;
  }
  
  public void setShouldPlayVideo(boolean paramBoolean)
  {
    this.bRR = paramBoolean;
  }
  
  public void setShowPanelListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean Pa();
    
    public abstract void bIp();
    
    public abstract void bIq();
  }
  
  public static abstract interface b
  {
    public abstract void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface c
  {
    public abstract void bJg();
  }
  
  public static abstract interface d
  {
    public abstract boolean af(MotionEvent paramMotionEvent);
    
    public abstract boolean ag(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */