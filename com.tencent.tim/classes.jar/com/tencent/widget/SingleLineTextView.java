package com.tencent.widget;

import ajns;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import annt;
import aofk.a;
import aqho;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import com.tencent.theme.SkinnableColorStateList;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleLineTextView
  extends View
  implements Handler.Callback, ISkinSetTypeface
{
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  private float Db = 1.0F;
  private float Dc = 0.0F;
  ArrayList<f> EG;
  private BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private a jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
  private final b[] jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b;
  private e[] jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
  private CharSequence aI;
  private int ccv = -16777216;
  private boolean dkV;
  private boolean dkW = true;
  private boolean dkX;
  private int dpa;
  private int euu;
  private int euv;
  private int euw;
  private int eux;
  private boolean mBlockRelayout;
  private BoringLayout.Metrics mBoring;
  private int mCurTextColor;
  private TextUtils.TruncateAt mEllipsize;
  private int mGravity = 16;
  private final Handler mHandler;
  protected Layout mLayout;
  private int mMaxWidth = 2147483647;
  private CharSequence mText;
  private final TextPaint mTextPaint;
  private ColorStateList o;
  
  public SingleLineTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.mText = "";
    this.aI = "";
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
    this.mTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
    this.mEllipsize = TextUtils.TruncateAt.END;
    this.dkV = true;
    this.euw = -1;
    this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b = new b[3];
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.euu = 0;
    this.euv = 0;
    this.o = ColorStateList.valueOf(-16777216);
    this.mCurTextColor = this.o.getDefaultColor();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sf);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)aqho.convertDpToPixel(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(1);
      localObject = paramAttributeSet.getString(3);
      this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(2, 2147483647);
      this.mTextPaint.setTextSize(paramInt);
      setTextColor(paramContext);
      setText((CharSequence)localObject);
      this.dkW = paramAttributeSet.getBoolean(4, true);
      paramAttributeSet.recycle();
    }
  }
  
  private int OW()
  {
    int j = 0;
    int i = 0;
    e[] arrayOfe = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
    if (arrayOfe != null)
    {
      int i1 = arrayOfe.length;
      j = 0;
      int k = 0;
      while (j < i1)
      {
        e locale = arrayOfe[j];
        int n = k;
        int m = i;
        if (locale.mDrawable != null)
        {
          n = k;
          m = i;
          if (locale.bsd > 0)
          {
            m = i + (this.dpa + locale.bsd);
            n = 1;
          }
        }
        j += 1;
        k = n;
        i = m;
      }
      j = i;
      if (k != 0) {
        j = i + this.eux;
      }
    }
    return j;
  }
  
  public static Drawable a(Context paramContext, f paramf)
  {
    Object localObject2 = null;
    ajns localajns = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (paramf != null)
      {
        if (TextUtils.isEmpty(paramf.icon_static_url)) {
          break label82;
        }
        localajns = new ajns(paramContext, paramf.icon_static_url);
      }
    }
    for (;;)
    {
      localObject1 = localajns;
      if (localajns != null)
      {
        localObject1 = localajns.mutate();
        ((Drawable)localObject1).setAlpha((int)(paramf.Dd * 255.0F));
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      }
      return localObject1;
      label82:
      if (paramf.iconResId != 0) {
        localajns = new ajns(paramContext, paramf.iconResId);
      }
    }
  }
  
  private void baW()
  {
    this.mHandler.removeMessages(1);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.width != -2)
    {
      int i = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if (i > 0)
      {
        int j = this.mLayout.getHeight();
        a(this.mLayout.getWidth(), UNKNOWN_BORING, i);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.mLayout.getHeight() == j)
        {
          invalidate();
          return;
        }
        requestLayout();
        invalidate();
        return;
      }
    }
    exn();
    requestLayout();
    invalidate();
  }
  
  private void cnB()
  {
    int[] arrayOfInt = getDrawableState();
    int i = this.o.getColorForState(arrayOfInt, this.ccv);
    if (QLog.isColorLevel()) {
      QLog.i("SingleLineTextView", 2, "updateTextColors, color=" + i + ", cur=" + this.mCurTextColor);
    }
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      invalidate();
    }
  }
  
  private void exn()
  {
    if (((this.mLayout instanceof BoringLayout)) && (this.jdField_a_of_type_AndroidTextBoringLayout == null)) {
      this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.mLayout);
    }
    this.mLayout = null;
  }
  
  private int getDesiredWidth()
  {
    if (this.euw < 0) {
      this.euw = ((int)Math.ceil(Layout.getDesiredWidth(this.aI, this.mTextPaint)));
    }
    return this.euw;
  }
  
  private int getVerticalOffset()
  {
    int j = 0;
    int k = this.mGravity & 0x70;
    Layout localLayout = this.mLayout;
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m)
      {
        if (k != 80) {
          break label70;
        }
        i = m - n;
      }
    }
    return i;
    label70:
    return m - n >> 1;
  }
  
  private void invlidateSpan(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < m)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("SingleLineTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean ng(int paramInt)
  {
    boolean bool2 = false;
    int i = OW();
    boolean bool1 = bool2;
    int k;
    e[] arrayOfe;
    if (i > 0)
    {
      bool1 = bool2;
      if (i > (int)aqho.convertDpToPixel(getContext(), 105.0F))
      {
        k = Math.min(getDesiredWidth(), getResources().getDimensionPixelSize(2131296994));
        bool1 = bool2;
        if (paramInt < k)
        {
          arrayOfe = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
          bool1 = bool2;
          if (arrayOfe != null) {
            i = 0;
          }
        }
      }
    }
    for (int j = paramInt;; j = paramInt)
    {
      bool1 = bool2;
      if (i < arrayOfe.length)
      {
        e locale = arrayOfe[i];
        paramInt = j;
        if (locale != null)
        {
          paramInt = j;
          if (locale.mDrawable != null)
          {
            paramInt = j;
            if (!locale.dkZ)
            {
              paramInt = j;
              if (locale.bsd > 0)
              {
                j += locale.bsd;
                locale.bsd = 0;
                paramInt = j;
                if (j >= k) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected void a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.mGravity & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
      while ((this.mText instanceof Spannable))
      {
        this.mLayout = new c(this.mText, this.aI, this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, this.dkW, this.mEllipsize, paramInt2);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      if (paramMetrics == UNKNOWN_BORING)
      {
        BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.aI, this.mTextPaint, this.mBoring);
        paramMetrics = localMetrics;
        if (localMetrics != null)
        {
          this.mBoring = localMetrics;
          paramMetrics = localMetrics;
        }
      }
      for (;;)
      {
        if (paramMetrics != null)
        {
          if ((paramMetrics.width <= paramInt1) && (paramMetrics.width <= paramInt2))
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null) {}
            for (this.mLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.aI, this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, paramMetrics, this.dkW);; this.mLayout = BoringLayout.make(this.aI, this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, paramMetrics, this.dkW))
            {
              this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.mLayout);
              return;
            }
          }
          if (paramMetrics.width <= paramInt1)
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null)
            {
              this.mLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.aI, this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, paramMetrics, this.dkW, this.mEllipsize, paramInt2);
              return;
            }
            this.mLayout = BoringLayout.make(this.aI, this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, paramMetrics, this.dkW, this.mEllipsize, paramInt2);
            return;
          }
          this.mLayout = new d(this.aI, 0, this.aI.length(), this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, this.dkW, this.mEllipsize, paramInt2);
          return;
        }
        this.mLayout = new d(this.aI, 0, this.aI.length(), this.mTextPaint, paramInt1, localAlignment, this.Db, this.Dc, this.dkW, this.mEllipsize, paramInt2);
        return;
      }
    }
  }
  
  public void ai(Drawable paramDrawable)
  {
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (aofk.a[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), aofk.a.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.mBlockRelayout = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getDrawable() == paramDrawable) {
            invlidateSpan(localObject2);
          }
          i += 1;
        }
        this.mBlockRelayout = false;
      }
    }
  }
  
  public Drawable bg()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a != null) {
      return this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.gM;
    }
    return null;
  }
  
  protected void drawableStateChanged()
  {
    int j = 0;
    super.drawableStateChanged();
    if ((this.o != null) && (this.o.isStateful())) {
      cnB();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    if (localObject1 != null)
    {
      if ((((a)localObject1).cK != null) && (((a)localObject1).cK.isStateful())) {
        ((a)localObject1).cK.setState(arrayOfInt);
      }
      if ((((a)localObject1).gM != null) && (((a)localObject1).gM.isStateful())) {
        ((a)localObject1).gM.setState(arrayOfInt);
      }
      if ((((a)localObject1).gN != null) && (((a)localObject1).gN.isStateful())) {
        ((a)localObject1).gN.setState(arrayOfInt);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
    if (localObject1 != null)
    {
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2.mDrawable != null) && (localObject2.mDrawable.isStateful())) {
          localObject2.mDrawable.setState(arrayOfInt);
        }
        i += 1;
      }
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[i];
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (((b)localObject1).c(arrayOfInt)) {
          j = 1;
        }
      }
    }
    if (j != 0) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingBottom()
  {
    return getPaddingBottom();
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = getPaddingLeft();
    Object localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((a)localObject).cK != null)
      {
        i = ((a)localObject).aYi;
        i = j + (((a)localObject).euy + i);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[1];
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((b)localObject).Bq)
      {
        j = ((b)localObject).mPadding;
        j = i + (((b)localObject).OX() + j);
      }
    }
    return j;
  }
  
  public int getCompoundPaddingRight()
  {
    int i = getPaddingRight();
    Object localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (((a)localObject).gM != null) {
        j = i + (((a)localObject).aYi + ((a)localObject).euz + ((a)localObject).aYi);
      }
    }
    i = j;
    if (localObject != null)
    {
      i = j;
      if (((a)localObject).gN != null)
      {
        if (((a)localObject).gM == null) {
          break label178;
        }
        i = ((a)localObject).euA;
      }
    }
    label178:
    int k;
    for (i = j + (((a)localObject).aYi + i);; i = j + (((a)localObject).aYi + (i + k)))
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[2];
      j = i;
      if (localObject != null)
      {
        j = i;
        if (!((b)localObject).Bq)
        {
          j = ((b)localObject).mPadding;
          j = i + (((b)localObject).OX() + j);
        }
      }
      localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[0];
      i = j;
      if (localObject != null)
      {
        i = j;
        if (!((b)localObject).Bq)
        {
          i = ((b)localObject).mPadding;
          i = j + (((b)localObject).OX() + i);
        }
      }
      return i + OW();
      i = ((a)localObject).aYi;
      k = ((a)localObject).euA;
    }
  }
  
  public int getCompoundPaddingTop()
  {
    return getPaddingTop();
  }
  
  public int getExtendedPaddingBottom()
  {
    int i;
    if (this.mLayout.getLineCount() <= 1) {
      i = getCompoundPaddingBottom();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        k = getHeight() - i - j;
        m = this.mLayout.getLineTop(1);
        i = j;
      } while (m >= k);
      n = this.mGravity & 0x70;
      if (n == 48) {
        return j + k - m;
      }
      i = j;
    } while (n == 80);
    return j + (k - m) / 2;
  }
  
  public int getExtendedPaddingTop()
  {
    int i;
    if (this.mLayout.getLineCount() <= 1) {
      i = getCompoundPaddingTop();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        j = getCompoundPaddingTop();
        i = getCompoundPaddingBottom();
        k = getHeight() - j - i;
        m = this.mLayout.getLineTop(1);
        i = j;
      } while (m >= k);
      n = this.mGravity & 0x70;
      i = j;
    } while (n == 48);
    if (n == 80) {
      return j + k - m;
    }
    return j + (k - m) / 2;
  }
  
  public final Paint getPaint()
  {
    return this.mTextPaint;
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public float getTextSize()
  {
    return this.mTextPaint.getTextSize();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.mLayout != null)
      {
        baW();
        continue;
        ai((Drawable)paramMessage.obj);
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i2 = 0;
    Object localObject1;
    int m;
    if (verifyDrawable(paramDrawable))
    {
      localObject1 = paramDrawable.getBounds();
      m = getScrollX();
      int k = getScrollY();
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
      int j = k;
      int i = m;
      if (localObject2 != null)
      {
        if (paramDrawable != ((a)localObject2).cK) {
          break label368;
        }
        j = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getHeight();
        i = m + getPaddingLeft();
        j = k + ((i1 - n - j - ((a)localObject2).euB) / 2 + j);
      }
      int i3;
      int i4;
      for (;;)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
        i1 = j;
        n = i;
        if (localObject2 == null) {
          break label496;
        }
        Object localObject3 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[0];
        n = getWidth() - getPaddingRight() - this.eux;
        k = n;
        m = i2;
        if (localObject3 != null)
        {
          k = n;
          m = i2;
          if (!((b)localObject3).Bq)
          {
            k = ((b)localObject3).OX();
            k = n - (((b)localObject3).mPadding + k);
            m = i2;
          }
        }
        i1 = j;
        n = i;
        if (m >= localObject2.length) {
          break label496;
        }
        if (paramDrawable != localObject2[m].mDrawable) {
          break label580;
        }
        localObject3 = localObject2[m].de;
        paramDrawable.copyBounds((Rect)localObject3);
        localObject2[m].bsd = ((Rect)localObject3).width();
        localObject2[m].mDrawableHeight = ((Rect)localObject3).height();
        i2 = getCompoundPaddingTop();
        i3 = getCompoundPaddingBottom();
        i4 = getHeight();
        i1 = m + 1;
        n = k;
        k = i1;
        while (k < localObject2.length)
        {
          i1 = n;
          if (localObject2[k].mDrawable != null) {
            i1 = n - (localObject2[k].bsd - this.dpa);
          }
          i += i1 - localObject2[m].bsd - this.dpa;
          k += 1;
          n = i1;
        }
        label368:
        if (paramDrawable == ((a)localObject2).gM)
        {
          i = m + this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.tx[0];
          j = k + this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.tx[1];
        }
        else
        {
          j = k;
          i = m;
          if (paramDrawable == ((a)localObject2).gN)
          {
            i = m + this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.ty[0];
            j = k + this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.ty[1];
          }
        }
      }
      int n = n - localObject2[m].bsd - this.dpa + i;
      int i1 = j + ((i4 - i3 - i2 - localObject2[m].mDrawableHeight) / 2 + i2);
      label496:
      if ((n == 0) && (i1 == 0)) {
        break label589;
      }
      invalidate(((Rect)localObject1).left + n, ((Rect)localObject1).top + i1, n + ((Rect)localObject1).right, i1 + ((Rect)localObject1).bottom);
    }
    for (;;)
    {
      localObject1 = this.mHandler.obtainMessage(2);
      ((Message)localObject1).obj = paramDrawable;
      this.mHandler.removeMessages(2);
      this.mHandler.sendMessageDelayed((Message)localObject1, 100L);
      return;
      label580:
      m += 1;
      break;
      label589:
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getCompoundPaddingLeft();
    int i1 = getCompoundPaddingTop();
    int i9 = getCompoundPaddingRight();
    int k = getCompoundPaddingBottom();
    int i4 = getScrollX();
    int i2 = getScrollY();
    int i5 = getRight();
    int i6 = getLeft();
    int n = getBottom();
    int i10 = getTop();
    int i;
    if (this.mLayout == null)
    {
      j = i5 - i6 - m - i9;
      i = j;
      if (j < 1) {
        i = 0;
      }
      if (!this.dkV) {
        break label1228;
      }
    }
    label1207:
    label1214:
    label1221:
    label1228:
    for (int j = 16384;; j = i)
    {
      a(j, UNKNOWN_BORING, i);
      int i7 = getExtendedPaddingTop();
      int i11 = getExtendedPaddingBottom();
      int i3 = n - i10 - k - i1;
      int i8 = this.mLayout.getLineTop(1) - this.mLayout.getLineDescent(0);
      k = 0;
      j = 0;
      i = 0;
      if ((this.mGravity & 0x70) != 48)
      {
        j = getVerticalOffset();
        i = getVerticalOffset();
      }
      Object localObject1 = getDrawableState();
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
      if ((localObject2 != null) && (((a)localObject2).cK != null))
      {
        paramCanvas.save();
        int i12 = getPaddingLeft();
        int i13 = (i3 - ((a)localObject2).euB) / 2;
        paramCanvas.translate(i12 + i4, i2 + i1 + i13);
        ((a)localObject2).cK.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject3 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject3 != null) && (!((b)localObject3).Bq))
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + m - ((b)localObject3).OX(), i7 + j);
        localFontMetrics = ((b)localObject3).getFontMetrics();
        f2 = i8;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((b)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject3 = this.mLayout;
      this.mTextPaint.setColor(this.mCurTextColor);
      this.mTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(m + i4, i7 + i2, i5 - i6 - i9 + i4, n - i10 - i11 + i2);
      paramCanvas.translate(m, i7 + j);
      ((Layout)localObject3).draw(paramCanvas, null, null, i - j);
      paramCanvas.restore();
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[2];
      i = k;
      if (localObject3 != null)
      {
        i = k;
        if (!((b)localObject3).Bq)
        {
          paramCanvas.save();
          i = getDesiredWidth() + 0 + ((b)localObject3).mPadding;
          m = i4 + i5 - i6 - i9 + 0;
          k = 0 + (((b)localObject3).OX() + ((b)localObject3).mPadding);
          if (m <= i) {
            break label1221;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(i, i7 + j);
        localFontMetrics = ((b)localObject3).getFontMetrics();
        f2 = i8;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((b)localObject3).getDesiredHeight() - localFontMetrics.bottom);
          }
        }
        ((b)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
        i = k;
        k = i;
        if (localObject2 != null)
        {
          k = i;
          if (((a)localObject2).gN != null)
          {
            paramCanvas.save();
            m = getDesiredWidth() + i + ((a)localObject2).aYi;
            n = i4 + i5 - i6 - i9 + i + ((a)localObject2).aYi;
            k = i + (((a)localObject2).euA + ((a)localObject2).aYi);
            if (n <= m) {
              break label1214;
            }
          }
        }
        for (i = m;; i = n)
        {
          m = i2 + i1 + (i3 - ((a)localObject2).euD) / 2;
          paramCanvas.translate(i, m);
          ((a)localObject2).ty[0] = i;
          ((a)localObject2).ty[1] = m;
          ((a)localObject2).gN.draw(paramCanvas);
          paramCanvas.restore();
          if ((localObject2 != null) && (((a)localObject2).gM != null))
          {
            paramCanvas.save();
            i = getDesiredWidth() + k + ((a)localObject2).aYi;
            k = i4 + i5 - i6 - i9 + k + ((a)localObject2).aYi;
            m = ((a)localObject2).euz;
            m = ((a)localObject2).aYi;
            if (k <= i) {
              break label1207;
            }
          }
          for (;;)
          {
            k = i2 + i1 + (i3 - ((a)localObject2).euC) / 2;
            paramCanvas.translate(i, k);
            ((a)localObject2).tx[0] = i;
            ((a)localObject2).tx[1] = k;
            ((a)localObject2).gM.draw(paramCanvas);
            paramCanvas.restore();
            localObject2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[0];
            k = 0;
            i = k;
            if (localObject2 != null)
            {
              i = k;
              if (!((b)localObject2).Bq)
              {
                paramCanvas.save();
                paramCanvas.translate(i4 + i5 - i6 - ((b)localObject2).OX() - getPaddingRight(), j + i7);
                ((b)localObject2).a(paramCanvas, (int[])localObject1, 0.0F, i8);
                paramCanvas.restore();
                i = ((b)localObject2).OX();
              }
            }
            localObject1 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
            if (localObject1 != null)
            {
              j = getPaddingRight();
              m = this.eux;
              k = localObject1.length;
              j = i4 + i5 - i6 - i - j - m;
              i = k - 1;
              while (i >= 0)
              {
                k = j;
                if (localObject1[i].mDrawable != null)
                {
                  k = j;
                  if (localObject1[i].bsd != 0)
                  {
                    paramCanvas.save();
                    k = j - this.dpa - localObject1[i].bsd;
                    j = (i3 - localObject1[i].mDrawableHeight) / 2;
                    paramCanvas.translate(k, i2 + i1 + j);
                    localObject1[i].mDrawable.draw(paramCanvas);
                    paramCanvas.restore();
                  }
                }
                i -= 1;
                j = k;
              }
            }
            return;
            i = k;
          }
        }
        i = m;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.mHandler.removeMessages(1);
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    Object localObject = UNKNOWN_BORING;
    if (n == 1073741824) {}
    for (;;)
    {
      paramInt2 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if ((this.dkX) && (ng(paramInt2))) {
        paramInt2 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
      }
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
      {
        if (this.dkV) {
          paramInt1 = 16384;
        }
        if (this.mLayout == null) {
          a(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
        }
        for (;;)
        {
          if (m != 1073741824) {
            break label271;
          }
          paramInt1 = j;
          setMeasuredDimension(i, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.aI, this.mTextPaint, this.mBoring);
          if (localObject != null) {
            this.mBoring = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == UNKNOWN_BORING)) {}
          for (paramInt1 = getDesiredWidth();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt1 = Math.max(Math.min(paramInt1 + (getCompoundPaddingLeft() + getCompoundPaddingRight()), this.mMaxWidth), getSuggestedMinimumWidth());
            if (n != -2147483648) {
              break label498;
            }
            i = Math.min(i, paramInt1);
            break;
          }
          if ((this.mLayout.getWidth() != paramInt1) || (this.mLayout.getEllipsizedWidth() != paramInt2)) {
            a(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
          }
        }
        label271:
        m = getCompoundPaddingTop() + getCompoundPaddingBottom();
        if (this.mLayout != null)
        {
          paramInt2 = this.mLayout.getLineCount();
          paramInt1 = paramInt2;
          if (paramInt2 > 1) {
            paramInt1 = 1;
          }
        }
        for (paramInt1 = this.mLayout.getLineTop(paramInt1);; paramInt1 = 0)
        {
          paramInt1 += m;
          localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
          paramInt2 = paramInt1;
          if (localObject != null) {
            paramInt2 = Math.max(Math.max(paramInt1, ((a)localObject).euB), ((a)localObject).euC);
          }
          localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
          paramInt1 = paramInt2;
          if (localObject != null)
          {
            n = localObject.length;
            j = 0;
            for (;;)
            {
              paramInt1 = paramInt2;
              if (j >= n) {
                break;
              }
              paramInt2 = Math.max(paramInt2, localObject[j].mDrawableHeight);
              j += 1;
            }
          }
          j = paramInt1;
          if (paramInt1 == m)
          {
            paramInt2 = k;
            for (;;)
            {
              j = paramInt1;
              if (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length) {
                break;
              }
              localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt2];
              j = paramInt1;
              if (localObject != null)
              {
                j = paramInt1;
                if (!((b)localObject).Bq) {
                  j = Math.max(paramInt1, ((b)localObject).getDesiredHeight());
                }
              }
              paramInt2 += 1;
              paramInt1 = j;
            }
          }
          paramInt1 = Math.max(j, getSuggestedMinimumHeight());
          break;
        }
      }
      label498:
      i = paramInt1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockRelayout) {
      super.requestLayout();
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    a locala2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    if (paramInt == 0) {
      if (locala2 == null) {}
    }
    a locala1;
    for (locala2.aYi = paramInt;; locala1.aYi = paramInt)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a(null);
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a = locala1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label137;
      }
      if (localObject2 != null)
      {
        if (((a)localObject2).aYi != 0) {
          break label64;
        }
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a = null;
      }
    }
    for (;;)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      i = 0;
      break;
      label64:
      if (((a)localObject2).cK != null) {
        ((a)localObject2).cK.setCallback(null);
      }
      ((a)localObject2).cK = null;
      if (((a)localObject2).gM != null) {
        ((a)localObject2).gM.setCallback(null);
      }
      ((a)localObject2).gM = null;
      ((a)localObject2).euB = 0;
      ((a)localObject2).euy = 0;
      ((a)localObject2).euC = 0;
      ((a)localObject2).euz = 0;
      continue;
      label137:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a(null);
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a = ((a)localObject1);
      }
      if ((((a)localObject1).cK != paramDrawable1) && (((a)localObject1).cK != null)) {
        ((a)localObject1).cK.setCallback(null);
      }
      ((a)localObject1).cK = paramDrawable1;
      if ((((a)localObject1).gM != paramDrawable1) && (((a)localObject1).gM != null)) {
        ((a)localObject1).gM.setCallback(null);
      }
      ((a)localObject1).gM = paramDrawable2;
      localObject2 = ((a)localObject1).de;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((a)localObject1).euy = ((Rect)localObject2).width();
        ((a)localObject1).euB = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable2 == null) {
          break label341;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((a)localObject1).euz = ((Rect)localObject2).width();
        ((a)localObject1).euC = ((Rect)localObject2).height();
        break;
        ((a)localObject1).euB = 0;
        ((a)localObject1).euy = 0;
      }
      label341:
      ((a)localObject1).euC = 0;
      ((a)localObject1).euz = 0;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = null;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a != null) && ((this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.cK != null) || (this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a.gM != null)))
    {
      this.euu = 0;
      this.euv = 0;
      setCompoundDrawablesWithIntrinsicBounds(null, null);
    }
    while ((this.euu == paramInt1) && (this.euv == paramInt2)) {
      return;
    }
    this.euu = paramInt1;
    this.euv = paramInt2;
    Resources localResources = getContext().getResources();
    if (paramInt1 != 0) {}
    for (Drawable localDrawable1 = localResources.getDrawable(paramInt1);; localDrawable1 = null)
    {
      if (paramInt2 != 0) {
        localDrawable2 = localResources.getDrawable(paramInt2);
      }
      setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2);
      return;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
    }
    if (paramDrawable2 != null) {
      paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth(), paramDrawable2.getIntrinsicHeight());
    }
    setCompoundDrawables(paramDrawable1, paramDrawable2);
  }
  
  public void setDefaultTextColor(int paramInt)
  {
    this.ccv = paramInt;
    cnB();
  }
  
  public void setDrawableRight2(Drawable paramDrawable)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a;
    if (paramDrawable == null) {
      if (localObject2 != null)
      {
        if (((a)localObject2).gN != null) {
          ((a)localObject2).gN.setCallback(null);
        }
        ((a)localObject2).gN = null;
        ((a)localObject2).euD = 0;
        ((a)localObject2).euA = 0;
      }
    }
    for (;;)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a(null);
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView$a = ((a)localObject1);
      }
      if ((((a)localObject1).gN != paramDrawable) && (((a)localObject1).gN != null)) {
        ((a)localObject1).gN.setCallback(null);
      }
      ((a)localObject1).gN = paramDrawable;
      localObject2 = ((a)localObject1).de;
      paramDrawable.setState(getDrawableState());
      paramDrawable.copyBounds((Rect)localObject2);
      paramDrawable.setCallback(this);
      ((a)localObject1).euA = ((Rect)localObject2).width();
      ((a)localObject1).euD = ((Rect)localObject2).height();
    }
  }
  
  public void setDrawableRight2WithIntrinsicBounds(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    setDrawableRight2(paramDrawable);
  }
  
  public void setExtendText(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length)) {}
    b localb2;
    boolean bool;
    do
    {
      return;
      localb2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localb2 == null) || (localb2.Bq)));
    int i;
    if ((bool) && (localb2 != null) && (!localb2.Bq))
    {
      localb2.reset();
      i = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i != 0)) {
        postInvalidate();
      }
      if ((i == 0) || (this.mHandler.hasMessages(1))) {
        break;
      }
      this.mHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new b(getResources());
          this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt] = localb1;
        }
        if (!paramString.equals(localb1.mText))
        {
          localb1.mText = paramString;
          localb1.euE = -1;
          localb1.Bq = false;
          i = 1;
          continue;
        }
      }
      i = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length)) {}
    b localb1;
    do
    {
      return;
      b localb2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt];
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(getResources());
        this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt] = localb1;
      }
    } while (!localb1.a(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length)) {}
    b localb2;
    do
    {
      return;
      localb2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt2];
    } while ((paramInt1 <= 0) && ((localb2 == null) || (localb2.Bq)));
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(getResources());
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt2] = localb1;
    }
    localb1.mPadding = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b.length)) {}
    b localb1;
    do
    {
      return;
      b localb2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt];
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(getResources());
        this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b[paramInt] = localb1;
      }
    } while ((!localb1.a(paramFloat, getContext())) || (this.mHandler.hasMessages(1)));
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      paramInt = 0;
      if ((i & 0x7) != (this.mGravity & 0x7)) {
        paramInt = 1;
      }
      if (i != this.mGravity) {
        invalidate();
      }
      this.mGravity = i;
      if ((this.mLayout != null) && (paramInt != 0))
      {
        paramInt = this.mLayout.getWidth();
        i = getWidth();
        int j = getCompoundPaddingLeft();
        int k = getCompoundPaddingRight();
        a(paramInt, UNKNOWN_BORING, i - j - k);
      }
      return;
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.dpa) && (paramInt2 == this.eux)) {}
    do
    {
      return;
      this.dpa = paramInt1;
      this.eux = paramInt2;
    } while (this.mHandler.hasMessages(1));
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
    int i;
    if ((!paramBoolean) || (paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0)) {
      if (localObject2 != null)
      {
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramArrayOfDrawable = localObject2[i];
          if (paramArrayOfDrawable.mDrawable != null) {
            paramArrayOfDrawable.mDrawable.setCallback(null);
          }
          paramArrayOfDrawable.mDrawable = null;
          paramArrayOfDrawable.bsd = 0;
          paramArrayOfDrawable.mDrawableHeight = 0;
          paramArrayOfDrawable.dkZ = false;
          i += 1;
        }
      }
    }
    Object localObject1;
    for (this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e = null;; this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e = ((e[])localObject1))
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length == paramArrayOfDrawable.length) {}
      }
      else
      {
        localObject1 = new e[paramArrayOfDrawable.length];
        i = 0;
        while (i < localObject1.length)
        {
          localObject1[i] = new e(null);
          i += 1;
        }
      }
      localObject2 = getDrawableState();
      i = 0;
      if (i < localObject1.length)
      {
        if ((localObject1[i].mDrawable != null) && (localObject1[i].mDrawable != paramArrayOfDrawable[i])) {
          localObject1[i].mDrawable.setCallback(null);
        }
        localObject1[i].mDrawable = paramArrayOfDrawable[i];
        localObject1[i].dkZ = false;
        Rect localRect = localObject1[i].de;
        if (paramArrayOfDrawable[i] != null)
        {
          paramArrayOfDrawable[i].setState((int[])localObject2);
          paramArrayOfDrawable[i].copyBounds(localRect);
          paramArrayOfDrawable[i].setCallback(this);
          localObject1[i].bsd = localRect.width();
          localObject1[i].mDrawableHeight = localRect.height();
        }
        for (;;)
        {
          i += 1;
          break;
          localRect = localObject1[i];
          localObject1[i].mDrawableHeight = 0;
          localRect.bsd = 0;
        }
      }
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(ArrayList<f> paramArrayList)
  {
    int k = 0;
    if (paramArrayList != null) {}
    for (int j = paramArrayList.size();; j = 0)
    {
      if (this.EG != null) {}
      for (int i = this.EG.size();; i = 0)
      {
        if (j == i)
        {
          if ((j <= 0) || (paramArrayList == null) || (this.EG == null)) {
            break label261;
          }
          i = 0;
          if (i >= j) {
            break label261;
          }
          if (!((f)this.EG.get(i)).a((f)paramArrayList.get(i))) {
            i = 1;
          }
        }
        for (;;)
        {
          label81:
          Object localObject;
          boolean bool;
          if (i != 0)
          {
            localObject = null;
            if (j <= 0) {
              break label255;
            }
            localObject = new Drawable[j];
            i = 0;
            bool = false;
            for (;;)
            {
              if (i < j)
              {
                f localf = (f)paramArrayList.get(i);
                localObject[i] = a(getContext(), localf);
                if (localObject[i] == null) {
                  break label252;
                }
                bool = true;
                i += 1;
                continue;
                i += 1;
                break;
                i = 1;
                break label81;
              }
            }
          }
          for (;;)
          {
            this.EG = paramArrayList;
            setIconDrawables((Drawable[])localObject, bool);
            localObject = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$e;
            if ((localObject != null) && (paramArrayList != null))
            {
              i = k;
              while ((i < localObject.length) && (i < paramArrayList.size()))
              {
                if ((localObject[i] != null) && (paramArrayList.get(i) != null)) {
                  localObject[i].dkZ = ((f)paramArrayList.get(i)).dkZ;
                }
                i += 1;
              }
            }
            this.dkX = true;
            return;
            label252:
            break;
            label255:
            bool = false;
          }
          label261:
          i = 0;
        }
      }
    }
  }
  
  public final void setMaxWidth(int paramInt)
  {
    if (this.mMaxWidth != paramInt)
    {
      this.mMaxWidth = paramInt;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    int i = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject.equals(this.mText)) {
      return;
    }
    if (((CharSequence)localObject).length() > 168) {}
    for (;;)
    {
      try
      {
        paramCharSequence = ((CharSequence)localObject).subSequence(0, 168);
        this.mText = paramCharSequence;
        this.aI = this.jdField_a_of_type_AndroidTextMethodTransformationMethod.getTransformation(paramCharSequence, this);
        if ((paramCharSequence instanceof Spannable))
        {
          int j = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.jdField_a_of_type_AndroidTextMethodTransformationMethod, 0, j, 18);
        }
        this.euw = -1;
        if (this.mLayout != null) {
          baW();
        }
        getText();
        if (!(getText() instanceof Spannable)) {
          break;
        }
        paramCharSequence = (Spannable)getText();
        paramCharSequence = (aofk.a[])paramCharSequence.getSpans(0, paramCharSequence.length(), aofk.a.class);
        if (i >= paramCharSequence.length) {
          break;
        }
        localObject = paramCharSequence[i].getDrawable();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        i += 1;
        continue;
        paramCharSequence = (CharSequence)localObject;
      }
      catch (Exception paramCharSequence)
      {
        if (QLog.isDevelopLevel()) {
          paramCharSequence.printStackTrace();
        }
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.o = ColorStateList.valueOf(paramInt);
    cnB();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return;
    }
    this.o = paramColorStateList;
    cnB();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.mTextPaint.getTextSize())
      {
        this.mTextPaint.setTextSize(paramFloat);
        this.euw = -1;
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
      }
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.mTextPaint.getTypeface() != paramTypeface)
    {
      this.mTextPaint.setTypeface(paramTypeface);
      b[] arrayOfb = this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView$b;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        b localb = arrayOfb[i];
        if (localb != null) {
          localb.mTextPaint.setTypeface(paramTypeface);
        }
        i += 1;
      }
      requestLayout();
      invalidate();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
  
  static class a
  {
    int aYi;
    Drawable cK;
    final Rect de = new Rect();
    int euA;
    int euB;
    int euC;
    int euD;
    int euy;
    int euz;
    Drawable gM;
    Drawable gN;
    int[] tx = new int[2];
    int[] ty = new int[2];
  }
  
  static class b
  {
    private static boolean dkY;
    boolean Bq;
    private Method X;
    private Paint.FontMetrics d;
    int euE;
    int euF;
    int mCurTextColor;
    int mPadding;
    String mText;
    final TextPaint mTextPaint = new TextPaint(1);
    float mTextSize;
    ColorStateList o;
    
    b(Resources paramResources)
    {
      this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
      this.mTextPaint.density = paramResources.getDisplayMetrics().density;
      this.mPadding = 0;
      this.o = ColorStateList.valueOf(-7829368);
      this.mCurTextColor = this.o.getDefaultColor();
      reset();
    }
    
    public int OX()
    {
      if (this.Bq) {
        return 0;
      }
      if (this.euE < 0) {
        this.euE = ((int)Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint)));
      }
      return this.euE;
    }
    
    public void a(Canvas paramCanvas, int[] paramArrayOfInt, float paramFloat1, float paramFloat2)
    {
      if (paramCanvas != null)
      {
        this.mTextPaint.setColor(this.mCurTextColor);
        this.mTextPaint.drawableState = paramArrayOfInt;
        paramCanvas.drawText(this.mText, paramFloat1, paramFloat2, this.mTextPaint);
      }
    }
    
    public boolean a(float paramFloat, Context paramContext)
    {
      if (Math.abs(this.mTextSize - paramFloat) > 0.01F)
      {
        this.mTextSize = paramFloat;
        if (paramContext == null) {}
        for (paramContext = Resources.getSystem();; paramContext = paramContext.getResources())
        {
          paramFloat = TypedValue.applyDimension(1, paramFloat, paramContext.getDisplayMetrics());
          if (paramFloat == this.mTextPaint.getTextSize()) {
            break;
          }
          this.mTextPaint.setTextSize(paramFloat);
          this.euE = -1;
          this.euF = -1;
          this.d = null;
          return true;
        }
      }
      return false;
    }
    
    public boolean a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
    {
      if (paramColorStateList == null) {
        return false;
      }
      this.o = paramColorStateList;
      return c(paramArrayOfInt);
    }
    
    public boolean c(int[] paramArrayOfInt)
    {
      int j = this.o.getColorForState(paramArrayOfInt, 0);
      int i;
      if (j == 0) {
        if (this.X == null)
        {
          try
          {
            this.X = SkinnableColorStateList.class.getMethod("getColorForState", new Class[] { [I.class, Integer.TYPE });
            i = 0;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            for (;;)
            {
              label94:
              String str;
              localNoSuchMethodException.printStackTrace();
              i = 1;
            }
          }
          try
          {
            k = ((Integer)this.X.invoke(this.o, new Object[] { paramArrayOfInt, Integer.valueOf(0) })).intValue();
            j = k;
            k = i;
            i = j;
            j = k;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            k = 1;
            i = j;
            j = k;
            break label94;
          }
          k = i;
          if (!dkY)
          {
            k = i;
            if (j != 0)
            {
              str = "get color from state list fail, state is " + Arrays.toString(paramArrayOfInt) + " but the state list is " + this.o + " curTs: " + SystemClock.uptimeMillis();
              str = str + " colorFromReflect: " + i;
              QLog.e("SingleLineTextView", 1, str);
              annt.e(new IllegalStateException(str), str);
              dkY = true;
            }
          }
        }
      }
      for (int k = i;; k = j)
      {
        if ((this.o instanceof SkinnableColorStateList)) {
          ((SkinnableColorStateList)this.o).reset();
        }
        if (k != this.mCurTextColor)
        {
          this.mCurTextColor = k;
          this.mTextPaint.setColor(this.mCurTextColor);
          this.mTextPaint.drawableState = paramArrayOfInt;
          return true;
        }
        return false;
        i = 0;
        break;
      }
    }
    
    public int getDesiredHeight()
    {
      if (this.Bq) {
        return 0;
      }
      if (this.euF < 0) {
        this.euF = Math.round(this.mTextPaint.getFontMetricsInt(null));
      }
      return this.euF;
    }
    
    public Paint.FontMetrics getFontMetrics()
    {
      if (this.d == null) {
        this.d = this.mTextPaint.getFontMetrics();
      }
      return this.d;
    }
    
    public void reset()
    {
      this.Bq = true;
      this.mText = "";
      this.euE = 0;
      this.mPadding = 0;
    }
    
    public String toString()
    {
      if (this.mText == null) {
        return "";
      }
      return this.mText;
    }
  }
  
  public static class c
    extends DynamicLayout
  {
    public c(CharSequence paramCharSequence1, CharSequence paramCharSequence2, TextPaint paramTextPaint, int paramInt1, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt2)
    {
      super(paramCharSequence2, paramTextPaint, paramInt1, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt2);
    }
    
    public int getParagraphDirection(int paramInt)
    {
      return 1;
    }
  }
  
  public static class d
    extends StaticLayout
  {
    public d(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4)
    {
      super(paramInt1, paramInt2, paramTextPaint, paramInt3, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt4);
    }
    
    public int getParagraphDirection(int paramInt)
    {
      return 1;
    }
  }
  
  static class e
  {
    int bsd;
    final Rect de = new Rect();
    boolean dkZ;
    Drawable mDrawable;
    int mDrawableHeight;
  }
  
  public static class f
  {
    public float Dd = 1.0F;
    public boolean dkZ;
    public int iconResId;
    public String icon_static_url;
    
    public boolean a(f paramf)
    {
      return (paramf != null) && (this.iconResId == paramf.iconResId) && (TextUtils.equals(this.icon_static_url, paramf.icon_static_url)) && (Math.abs(this.Dd - paramf.Dd) < 0.001F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */