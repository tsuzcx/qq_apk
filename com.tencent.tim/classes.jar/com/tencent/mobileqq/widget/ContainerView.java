package com.tencent.mobileqq.widget;

import aawd;
import aawe;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqnm;
import arey;
import arez;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import wja;
import wmw;
import wmw.a;

@SuppressLint({"NewApi", "ResourceAsColor", "Override"})
@TargetApi(11)
public class ContainerView
  extends LinearLayout
  implements aawd, wmw.a
{
  public static float Bg;
  private static final int bNP = aqnm.dpToPx(5.0F);
  private static final int bNQ = aqnm.dpToPx(2.0F);
  private static final int bNR = aqnm.dpToPx(28.0F);
  private Rect aW;
  private int bOF = -1;
  private int bOG = -1;
  private int bOH = -1;
  private int bOI = -1;
  private int bOJ = -1;
  private int bOK = -1;
  private int bOL;
  private int bOM = -1;
  private int bON = -1;
  private int bOO = -1;
  private boolean bdu;
  private boolean bdv;
  private boolean bdw;
  public boolean cZS = true;
  private boolean cZT;
  public AnimationTextView e;
  private ScrollView h;
  private boolean inited;
  protected Handler mHandler;
  private aawe mSelectDelegate;
  private Paint mSelectPaint;
  private int[] mTempLocation = new int[2];
  public int offset;
  
  public ContainerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void ar(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    int i;
    if (this.bOM == 1)
    {
      j = this.bON;
      i = this.mSelectDelegate.touchIndex(paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "updateCursorLocation, touchIndex=" + i + ", type=" + this.bOM);
      }
      if (paramInt3 == -1) {
        this.mSelectDelegate.bg(this.bOM, false);
      }
      if (i != -1) {
        break label106;
      }
    }
    label106:
    do
    {
      do
      {
        do
        {
          return;
          j = this.bOO;
          break;
          if (i == j) {
            break label556;
          }
          if (this.bOM == 1) {
            if (i < this.bON)
            {
              paramInt3 = this.bOO;
              this.bON = i;
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatItemLayout", 2, "update selection, s=" + i + ", e=" + paramInt3);
            }
            this.mSelectDelegate.selectContent(i, paramInt3);
            this.mSelectDelegate.gy(paramInt1, paramInt2);
            if (this.bOM != 1) {
              break label524;
            }
            if (this.bOJ == -1) {
              break;
            }
            this.mSelectDelegate.u(paramInt1, this.bOJ, true);
            return;
            if ((i > this.bON) && (i < this.bOO))
            {
              paramInt3 = this.bOO;
              this.bON = i;
            }
            else if (i == this.bON)
            {
              i = this.bON;
              paramInt3 = this.bOO;
            }
            else if (i == this.bOO)
            {
              i = this.bOO - 1;
              paramInt3 = this.bOO;
            }
            else
            {
              j = this.bOO;
              this.bON = this.bOO;
              this.bOO = i;
              this.bOM = 2;
              this.mSelectDelegate.GF(this.bOM);
              paramInt3 = i;
              i = j;
              continue;
              if (i > this.bOO)
              {
                j = this.bON;
                this.bOO = i;
                paramInt3 = i;
                i = j;
              }
              else if ((i < this.bOO) && (i > this.bON))
              {
                j = this.bON;
                this.bOO = i;
                paramInt3 = i;
                i = j;
              }
              else if (i == this.bOO)
              {
                i = this.bON;
                paramInt3 = this.bOO;
              }
              else if (i == this.bON)
              {
                i = this.bON;
                paramInt3 = this.bON + 1;
              }
              else
              {
                paramInt3 = this.bON;
                this.bOO = this.bON;
                this.bON = i;
                this.bOM = 1;
                this.mSelectDelegate.GF(this.bOM);
              }
            }
          }
        } while ((this.bOM != 2) || (this.bOK == -1));
        this.mSelectDelegate.u(paramInt1, this.bOK, true);
        return;
        if (this.bOM != 1) {
          break label588;
        }
      } while (this.bOJ == -1);
      this.mSelectDelegate.u(paramInt1, this.bOJ, false);
      return;
    } while ((this.bOM != 2) || (this.bOK == -1));
    label524:
    label556:
    label588:
    this.mSelectDelegate.u(paramInt1, this.bOK, false);
  }
  
  private float bL()
  {
    int i = this.h.getScrollY();
    Layout localLayout = this.e.getLayout();
    if (localLayout != null)
    {
      int j = -localLayout.getTopPadding();
      if (i <= j) {
        return (j - i) / this.e.getLineHeight();
      }
      int k = localLayout.getLineForVertical(i - 1) + 1;
      j = localLayout.getLineStart(k);
      k = localLayout.getLineTop(k);
      float f = j;
      return (k - i) / this.e.getLineHeight() + f;
    }
    return i / this.e.getLineHeight();
  }
  
  private void bf(float paramFloat)
  {
    if ((paramFloat == 0.0F) || (paramFloat == this.h.getScrollY())) {
      return;
    }
    int i = (int)paramFloat;
    int j = (int)((paramFloat - i) * this.e.getLineHeight());
    Layout localLayout = this.e.getLayout();
    if (localLayout != null)
    {
      i = localLayout.getLineForOffset(i);
      if (i == 0) {}
      for (i = -localLayout.getTopPadding();; i = localLayout.getLineTop(i))
      {
        new Handler().post(new ContainerView.3(this, i - j));
        return;
      }
    }
    j = this.e.getLineHeight();
    new Handler().post(new ContainerView.4(this, i * j));
  }
  
  private void checkDelegateBound()
  {
    if (this.mSelectDelegate == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
  }
  
  private int d(float paramFloat1, float paramFloat2)
  {
    int i = this.bOF;
    int j = bNP;
    int k = this.bOF;
    int m = bNP;
    int n = this.bOG;
    int i1 = bNR;
    int i2 = bNP;
    int i3 = this.bOG;
    if ((paramFloat1 >= i - j * 3) && (paramFloat1 <= k + m * 3) && (paramFloat2 >= n - i1 - i2 * 2) && (paramFloat2 <= i3) && (this.bdu)) {
      return 1;
    }
    i = this.bOH;
    j = bNP;
    k = this.bOH;
    m = bNP;
    n = this.bOI;
    i1 = bNR;
    i2 = this.bOI;
    i3 = bNP;
    if ((paramFloat1 >= i - j * 3) && (paramFloat1 <= k + m * 3) && (paramFloat2 >= n - i1) && (paramFloat2 <= i2 + i3 * 2) && (this.bdv)) {
      return 2;
    }
    return -1;
  }
  
  private void init(Context paramContext)
  {
    this.e = new AnimationTextView(paramContext);
    this.e.setBackgroundColor(17170445);
    this.e.setGravity(8388627);
    this.e.setScroller(null);
    this.e.setHighlightColor(1722605812);
    this.e.setTextSize(1, 32.0F);
    this.e.setTextColor(-16777216);
    int i = wja.dp2px(10.0F, getResources());
    this.e.setPadding(i, i, i, i);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    addView(this.e, paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new arey(this));
  }
  
  public void Ch(int paramInt)
  {
    if (paramInt == 1) {
      this.bdu = false;
    }
    for (;;)
    {
      invalidate();
      return;
      this.bdv = false;
    }
  }
  
  public void Ci(int paramInt)
  {
    this.bOL = paramInt;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.bdu) && (!this.bdv)) {
      return -1;
    }
    return new wmw(this, this.mSelectDelegate).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void ap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.bON = (paramInt1 - paramInt2);
      return;
    }
    this.bOO = (paramInt1 + paramInt2);
  }
  
  public void aq(int paramInt1, int paramInt2, int paramInt3)
  {
    checkDelegateBound();
    getLocationInWindow(this.mTempLocation);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      bool = true;
      if (paramInt3 != 1) {
        break label118;
      }
      this.bOF = (paramInt1 - this.mTempLocation[0]);
      this.bOG = (paramInt2 - this.mTempLocation[1]);
      this.bdu = bool;
      label60:
      if (this.mSelectPaint == null) {
        this.mSelectPaint = new Paint(1);
      }
      if (this.aW == null) {
        this.aW = new Rect();
      }
      if (paramInt3 != 1) {
        break label151;
      }
      this.bOJ = paramInt2;
    }
    for (;;)
    {
      invalidate();
      return;
      bool = false;
      break;
      label118:
      this.bOH = (paramInt1 - this.mTempLocation[0]);
      this.bOI = (paramInt2 - this.mTempLocation[1]);
      this.bdv = bool;
      break label60;
      label151:
      if (paramInt3 == 2)
      {
        this.bOK = paramInt2;
      }
      else
      {
        this.bOJ = -1;
        this.bOK = -1;
      }
    }
  }
  
  public void bind(aawe paramaawe)
  {
    this.mSelectDelegate = paramaawe;
  }
  
  public boolean cj(Context paramContext)
  {
    return this.e.getSelectionEnd() - this.e.getSelectionStart() > 0;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.bdu)
    {
      this.aW.set(this.bOF - bNQ, this.bOG - bNR, this.bOF, this.bOG);
      this.mSelectPaint.setColor(this.bOL);
      paramCanvas.drawRect(this.aW, this.mSelectPaint);
      paramCanvas.drawCircle(this.aW.centerX(), this.aW.top - bNP, bNP, this.mSelectPaint);
    }
    if (this.bdv)
    {
      this.aW.set(this.bOH, this.bOI - bNR, this.bOH + bNQ, this.bOI);
      this.mSelectPaint.setColor(this.bOL);
      paramCanvas.drawRect(this.aW, this.mSelectPaint);
      paramCanvas.drawCircle(this.aW.centerX(), this.aW.bottom + bNP, bNP, this.mSelectPaint);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {
      return this.e.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public int eX(int paramInt)
  {
    if (paramInt == 1) {
      return this.bOF;
    }
    return this.bOH;
  }
  
  public int eY(int paramInt)
  {
    if (paramInt == 1) {
      return this.bOG;
    }
    return this.bOI;
  }
  
  public String getText()
  {
    return this.e.getText().toString();
  }
  
  public boolean go(int paramInt)
  {
    if (paramInt == 1) {
      return this.bdu;
    }
    return this.bdv;
  }
  
  public boolean isScrollFinished()
  {
    return this.h.isScrollFinished();
  }
  
  protected void onDetachedFromWindow()
  {
    Bg = bL();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.offset == 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.offset);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((this.bdu) || (this.bdv)) && (d(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      checkDelegateBound();
      this.mSelectDelegate.czB();
      requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.h != null) && (this.h.getHeight() > getHeight())) {
      return;
    }
    paramInt4 = getHeight();
    int i = getWidth();
    paramInt2 = this.e.getHeight();
    paramInt3 = this.e.getWidth();
    if (paramInt2 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 0) {}
    }
    else
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648);
      this.e.measure(paramInt1, paramInt2);
      paramInt2 = this.e.getMeasuredHeight();
      paramInt1 = this.e.getMeasuredWidth();
    }
    if (paramInt2 < paramInt4 * 0.8F) {
      if (this.cZS)
      {
        if (paramInt1 < i) {
          setGravity(17);
        }
      }
      else {
        this.offset = (-this.e.getLineHeight());
      }
    }
    for (;;)
    {
      this.e.setVisibility(0);
      return;
      setGravity(19);
      break;
      if (this.cZS) {
        setGravity(51);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 2;
    if ((this.bdu) || (this.bdv))
    {
      int j = paramMotionEvent.getAction();
      if (!this.bdw)
      {
        i = d(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((i == -1) || (j != 0)) {
          break label515;
        }
        checkDelegateBound();
        this.bdw = true;
        this.bOM = i;
        this.bON = this.mSelectDelegate.startIndex();
        this.bOO = this.mSelectDelegate.endIndex();
        if (paramMotionEvent.getSource() != -1) {
          this.mSelectDelegate.bg(this.bOM, false);
        }
        if (this.mSelectDelegate.Xy()) {
          this.mSelectDelegate.czA();
        }
      }
      do
      {
        do
        {
          return true;
          checkDelegateBound();
          if ((j != 1) && (j != 3)) {
            break;
          }
          this.bdw = false;
          this.bOJ = -1;
          this.bOK = -1;
          this.mSelectDelegate.bg(-1, true);
          this.mSelectDelegate.czz();
        } while (j != 1);
        if (paramMotionEvent.getSource() == -1) {}
        for (;;)
        {
          anot.a(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i, 0, "", "", "", "");
          return true;
          i = 1;
        }
      } while (j != 2);
      int k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      if (this.bOM == 1)
      {
        m = this.bOF;
        n = bNP;
        i1 = this.bOF;
        i2 = bNP;
        i3 = this.bOG;
        i4 = bNR;
        i5 = bNP;
        int i6 = this.bOG;
        int i7 = bNR;
        i = j;
        if (k >= m - n * 3)
        {
          i = j;
          if (k <= i1 + i2 * 3)
          {
            i = j;
            if (j >= i3 - i4 - i5 * 2)
            {
              i = j;
              if (j <= i6 - i7)
              {
                i = j;
                if (this.bdu) {
                  i = j + bNP * 2;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        ar(k, i, paramMotionEvent.getSource());
        return true;
        i = j;
        if (this.bOM == 2)
        {
          m = this.bOH;
          n = bNP;
          i1 = this.bOH;
          i2 = bNP;
          i3 = this.bOI;
          i4 = this.bOI;
          i5 = bNP;
          i = j;
          if (k >= m - n * 3)
          {
            i = j;
            if (k <= i1 + i2 * 3)
            {
              i = j;
              if (j >= i3)
              {
                i = j;
                if (j <= i4 + i5 * 2)
                {
                  i = j;
                  if (this.bdv) {
                    i = j - bNP * 2;
                  }
                }
              }
            }
          }
        }
      }
    }
    label515:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMsgHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setOutScrollView(ScrollView paramScrollView)
  {
    this.h = paramScrollView;
    this.h.setOnScrollStateChangedListener(new arez(this));
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }
  
  public void setTextColor(int paramInt)
  {
    this.e.setTextColor(paramInt);
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
  
  public static class a
    extends LinkMovementMethod
  {
    private static a a;
    
    public static MovementMethod getInstance()
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 0))
      {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramTextView.getTotalPaddingLeft();
        int n = paramTextView.getTotalPaddingTop();
        int i1 = paramTextView.getScrollX();
        int i2 = paramTextView.getScrollY();
        Object localObject = paramTextView.getLayout();
        j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
        localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
        if (localObject.length != 0)
        {
          if (i == 1) {
            localObject[0].onClick(paramTextView);
          }
          for (;;)
          {
            return true;
            if (i == 0)
            {
              Rect localRect = new Rect();
              paramTextView.getGlobalVisibleRect(localRect);
              if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
                Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
              }
            }
          }
        }
      }
      return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView
 * JD-Core Version:    0.7.0.1
 */