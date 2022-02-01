package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aofk;
import aofk.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;

public class ReadInJoyYAFolderTextViewExt
  extends ReadInJoyYAFolderTextView
{
  private static final String alq = new String(i);
  private static final char[] i = { '…' };
  private String ELLIPSIS = "...";
  private TextView.BufferType a;
  private Object aR;
  private int aYM = 0;
  private int acA = 5;
  private String alp = "";
  private boolean asl;
  private boolean dirty;
  private List<ClickableSpan> ka = new ArrayList();
  private int lines = -1;
  private int mEnd = -1;
  private int mStart = -1;
  private CharSequence s;
  
  public ReadInJoyYAFolderTextViewExt(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyYAFolderTextViewExt(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyYAFolderTextViewExt(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = (aofk.a[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), aofk.a.class);
    int j = paramSpannableStringBuilder.length();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[(localObject.length - 1)];
      if (paramSpannableStringBuilder.getSpanEnd(localObject) == j) {
        return new SpannableStringBuilder(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.getSpanStart(localObject));
      }
    }
    return new SpannableStringBuilder(paramSpannableStringBuilder, 0, j - 1);
  }
  
  private void c(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.ELLIPSIS);
    if (this.aYM == 1) {
      paramSpannableStringBuilder.append("\n");
    }
    paramSpannableStringBuilder.append(this.alp);
    if (this.aR != null) {
      paramSpannableStringBuilder.setSpan(this.aR, paramSpannableStringBuilder.length() - this.alp.length(), paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void init()
  {
    setMovementMethod(a.a());
  }
  
  public void clearSpans()
  {
    if (this.ka.size() > 0)
    {
      Iterator localIterator = this.ka.iterator();
      if (localIterator.hasNext())
      {
        ClickableSpan localClickableSpan = (ClickableSpan)localIterator.next();
        if ((localClickableSpan instanceof b)) {
          ((b)localClickableSpan).setPressed(false);
        }
        localIterator.remove();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.acA <= 0) || (!this.dirty)) {}
    SpannableStringBuilder localSpannableStringBuilder;
    float f1;
    ArrayList localArrayList;
    int j;
    float f2;
    label283:
    do
    {
      do
      {
        return;
        this.dirty = false;
      } while ((this.lines >= 0) && (this.lines <= this.acA));
      localObject3 = getPaint();
      localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(this.ELLIPSIS);
      if (this.aYM != 1)
      {
        localSpannableStringBuilder.append(this.alp);
        if (this.aR != null) {
          localSpannableStringBuilder.setSpan(this.aR, localSpannableStringBuilder.length() - this.alp.length(), localSpannableStringBuilder.length(), 33);
        }
      }
      f1 = ((TextPaint)localObject3).measureText(localSpannableStringBuilder, 0, localSpannableStringBuilder.length());
      localSpannableStringBuilder.clear();
      localArrayList = new ArrayList();
      paramInt4 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.s.length())
      {
        j = paramInt4;
        if (this.s.charAt(paramInt2) == '\n')
        {
          localArrayList.add(this.s.subSequence(paramInt4, paramInt2));
          j = paramInt2 + 1;
        }
        paramInt2 += 1;
        paramInt4 = j;
      }
      if (paramInt4 != this.s.length()) {
        localArrayList.add(this.s.subSequence(paramInt4, this.s.length()));
      }
      f2 = paramInt3 - paramInt1;
      paramInt2 = 0;
      j = 0;
      paramInt4 = 0;
      if ((j < this.acA - 1) && (paramInt2 < localArrayList.size())) {
        break;
      }
    } while (paramInt2 >= localArrayList.size());
    Object localObject1 = (CharSequence)localArrayList.get(paramInt2);
    Object localObject2 = ((CharSequence)localObject1).subSequence(paramInt4, ((CharSequence)localObject1).length());
    Object localObject3 = TextUtils.ellipsize((CharSequence)localObject2, (TextPaint)localObject3, paramInt3 - paramInt1 - f1, TextUtils.TruncateAt.END);
    label400:
    label472:
    int k;
    CharSequence localCharSequence1;
    CharSequence localCharSequence2;
    if (((localObject3 instanceof Spanned)) && (j > 1))
    {
      localObject1 = (ClickableSpan[])((Spanned)localObject3).getSpans(0, ((CharSequence)localObject3).length(), ClickableSpan.class);
      if ((!localObject3.equals(localObject2)) && (((CharSequence)localObject3).length() > 0))
      {
        paramInt3 = localSpannableStringBuilder.length();
        if (((CharSequence)localObject3).charAt(((CharSequence)localObject3).length() - 1) == '…')
        {
          localSpannableStringBuilder.append(((CharSequence)localObject3).subSequence(0, ((CharSequence)localObject3).length() - 1));
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
            paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
            if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
            {
              paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
              paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
              if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
              {
                paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
              }
            }
          }
          c(localSpannableStringBuilder);
          super.setText(localSpannableStringBuilder, this.a);
          return;
          k = j + 1;
          localObject1 = (CharSequence)localArrayList.get(paramInt2);
          localCharSequence1 = ((CharSequence)localObject1).subSequence(paramInt4, ((CharSequence)localObject1).length());
          localObject1 = TextUtils.ellipsize(localCharSequence1, (TextPaint)localObject3, f2, TextUtils.TruncateAt.END);
          if ((((CharSequence)localObject1).length() <= 4) || (!(localObject1 instanceof SpannableStringBuilder))) {
            break label1676;
          }
          localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3);
          localCharSequence2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
          if ((((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') && (((TextPaint)localObject3).measureText(((CharSequence)localObject2).toString()) > paramInt3 - paramInt1)) {
            localObject1 = a((SpannableStringBuilder)localObject2).append(alq);
          }
        }
      }
    }
    label773:
    label1676:
    for (;;)
    {
      if (((localObject1 instanceof Spanned)) && (k > 1)) {}
      for (localObject2 = (ClickableSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), ClickableSpan.class);; localObject2 = null)
      {
        int m;
        int n;
        if (localObject1.equals(localCharSequence1))
        {
          m = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject1).append('\n');
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            paramInt4 = localSpannableStringBuilder.getSpanStart(localObject2[0]);
            j = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
            if ((paramInt4 >= 0) && (j >= paramInt4) && (j < m))
            {
              m = ((Spanned)localObject1).getSpanStart(localObject2[0]);
              n = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
              if ((m == 0) && (n >= m))
              {
                j = Math.min(j + n + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject2[0], paramInt4, j, 33);
              }
            }
          }
          paramInt4 = 0;
          paramInt2 += 1;
          j = k;
          break label283;
          if (((TextPaint)localObject3).measureText(localCharSequence2.toString()) <= paramInt3 - paramInt1) {
            break label1676;
          }
          localObject1 = a((SpannableStringBuilder)localCharSequence2).append(alq);
          break label773;
        }
        j = paramInt4;
        if (((CharSequence)localObject1).length() > 0)
        {
          m = localSpannableStringBuilder.length();
          if (((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') {
            break label1277;
          }
          localSpannableStringBuilder.append(((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1)).append('\n');
          paramInt4 += ((CharSequence)localObject1).length() - 1;
        }
        for (;;)
        {
          j = paramInt4;
          if (localObject2 != null)
          {
            j = paramInt4;
            if (localObject2.length > 0)
            {
              n = localSpannableStringBuilder.getSpanStart(localObject2[0]);
              int i1 = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
              j = paramInt4;
              if (n >= 0)
              {
                j = paramInt4;
                if (i1 >= n)
                {
                  j = paramInt4;
                  if (i1 < m)
                  {
                    m = ((Spanned)localObject1).getSpanStart(localObject2[0]);
                    int i2 = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
                    j = paramInt4;
                    if (m == 0)
                    {
                      j = paramInt4;
                      if (i2 >= m)
                      {
                        j = Math.min(i1 + i2 + 1, localSpannableStringBuilder.length());
                        localSpannableStringBuilder.setSpan(localObject2[0], n, j, 33);
                        j = paramInt4;
                      }
                    }
                  }
                }
              }
            }
          }
          paramInt4 = j;
          break;
          label1277:
          localSpannableStringBuilder.append(((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3)).append('\n');
          paramInt4 += ((CharSequence)localObject1).length() - 3;
        }
        localSpannableStringBuilder.append(((CharSequence)localObject3).subSequence(0, ((CharSequence)localObject3).length() - 3));
        break label472;
        if (paramInt2 != localArrayList.size() - 1)
        {
          paramInt3 = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject3);
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
            paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
            if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
            {
              paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
              paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
              if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
              {
                paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
              }
            }
          }
          c(localSpannableStringBuilder);
          super.setText(localSpannableStringBuilder, this.a);
          return;
        }
        if (this.lines <= this.acA) {
          break;
        }
        paramInt3 = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append((CharSequence)localObject3);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramInt1 = localSpannableStringBuilder.getSpanStart(localObject1[0]);
          paramInt2 = localSpannableStringBuilder.getSpanEnd(localObject1[0]);
          if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 < paramInt3))
          {
            paramInt3 = ((Spanned)localObject3).getSpanStart(localObject1[0]);
            paramInt4 = ((Spanned)localObject3).getSpanEnd(localObject1[0]);
            if ((paramInt3 == 0) && (paramInt4 >= paramInt3))
            {
              paramInt2 = Math.min(paramInt2 + paramInt4 + 1, localSpannableStringBuilder.length());
              localSpannableStringBuilder.setSpan(localObject1[0], paramInt1, paramInt2, 33);
            }
          }
        }
        super.setText(localSpannableStringBuilder, this.a);
        return;
        localObject1 = null;
        break label400;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.acA > 0)
    {
      Layout localLayout = getLayout();
      if ((localLayout instanceof DynamicLayout))
      {
        this.lines = ((DynamicLayout)localLayout).getLineCount();
        paramInt1 = getCompoundPaddingTop();
        int j = getCompoundPaddingBottom() + paramInt1;
        paramInt2 = getMeasuredHeight();
        if (this.lines >= this.acA)
        {
          paramInt1 = this.acA * getLineHeight() + j + wja.dp2px(8.5F, getResources());
          if (this.aYM != 0) {
            paramInt1 = (this.acA + 1) * getLineHeight() + j + wja.dp2px(8.5F, getResources());
          }
          if ((paramInt2 > 0) && (paramInt1 > paramInt2))
          {
            if (this.aYM != 0) {
              break label156;
            }
            setMeasuredDimension(getMeasuredWidth(), paramInt1);
            super.setMaxLines(this.acA);
          }
        }
      }
    }
    return;
    label156:
    setMeasuredDimension(getMeasuredWidth(), paramInt1);
    super.setMaxLines(this.acA + 1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    for (;;)
    {
      int j;
      try
      {
        j = paramMotionEvent.getActionMasked();
        int k = (int)paramMotionEvent.getX();
        int m = (int)paramMotionEvent.getY();
        int n = getTotalPaddingLeft();
        int i1 = getTotalPaddingTop();
        int i2 = getScrollX();
        int i3 = getScrollY();
        paramMotionEvent = getLayout();
        k = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(m - i1 + i3), k - n + i2);
        paramMotionEvent = getText();
        if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
          break label343;
        }
        paramMotionEvent = (Spannable)getText();
        arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(k, k, ClickableSpan.class);
        if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
          break label305;
        }
        if (j != 0) {
          break label348;
        }
        clearSpans();
        this.ka.add(arrayOfClickableSpan[0]);
        this.mStart = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.mEnd = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        if ((this.mStart < 0) || (this.mEnd < this.mStart) || (!(arrayOfClickableSpan[0] instanceof b))) {
          break label346;
        }
        ((b)arrayOfClickableSpan[0]).setPressed(true);
      }
      catch (Exception paramMotionEvent)
      {
        ClickableSpan[] arrayOfClickableSpan;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramMotionEvent.printStackTrace();
        return bool;
      }
      if ((this.mStart >= 0) && (this.mEnd >= this.mStart))
      {
        if ((arrayOfClickableSpan[0] instanceof b)) {
          ((b)arrayOfClickableSpan[0]).setPressed(false);
        }
        Selection.removeSelection(paramMotionEvent);
        this.mStart = -1;
        this.mEnd = -1;
      }
      clearSpans();
      break label346;
      label305:
      if ((this.mStart >= 0) && (this.mEnd >= this.mStart))
      {
        Selection.removeSelection(paramMotionEvent);
        this.mStart = -1;
        this.mEnd = -1;
      }
      clearSpans();
      return false;
      label343:
      return bool;
      label346:
      label348:
      do
      {
        return true;
        if ((j == 1) || (j == 3)) {
          break;
        }
      } while (j != 4);
    }
  }
  
  public void setAlwaysShowTailSpan(boolean paramBoolean)
  {
    this.asl = paramBoolean;
    invalidate();
  }
  
  public void setEllipsis(String paramString)
  {
    this.ELLIPSIS = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.acA = paramInt;
  }
  
  public void setMoreSpan(Object paramObject)
  {
    this.aR = paramObject;
  }
  
  public void setSpanStrategy(int paramInt)
  {
    this.aYM = paramInt;
    invalidate();
  }
  
  public void setSpanText(String paramString)
  {
    this.alp = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof aofk)) {
      localObject = new SpannableStringBuilder(paramCharSequence);
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.lines = -1;
    this.dirty = true;
    this.s = ((CharSequence)localObject);
    this.a = paramBufferType;
  }
  
  @TargetApi(11)
  static class a
    extends BaseMovementMethod
  {
    private static a a;
    
    public static a a()
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    
    public void initialize(TextView paramTextView, Spannable paramSpannable)
    {
      Selection.removeSelection(paramSpannable);
    }
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getActionMasked();
      if ((i == 1) || (i == 0))
      {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramTextView.getTotalPaddingLeft();
        int n = paramTextView.getTotalPaddingTop();
        int i1 = paramTextView.getScrollX();
        int i2 = paramTextView.getScrollY();
        paramMotionEvent = paramTextView.getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
        if (paramMotionEvent.length > 0)
        {
          if (i == 1) {
            paramMotionEvent[0].onClick(paramTextView);
          }
          for (;;)
          {
            return true;
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramMotionEvent[0]), paramSpannable.getSpanEnd(paramMotionEvent[0]));
          }
        }
        Selection.removeSelection(paramSpannable);
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void setPressed(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextViewExt
 * JD-Core Version:    0.7.0.1
 */