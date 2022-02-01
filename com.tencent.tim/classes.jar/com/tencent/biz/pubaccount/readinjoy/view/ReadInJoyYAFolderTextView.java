package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
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
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aofk;
import aofk.a;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import kys;

public class ReadInJoyYAFolderTextView
  extends TextView
{
  private static final String alq = new String(i);
  private static final char[] i = { '…' };
  private String ELLIPSIS = "...";
  private TextView.BufferType a;
  private Object aR;
  private int acA = 5;
  private String alp = "";
  private boolean asj;
  public boolean ask;
  private boolean dirty;
  @Nullable
  private Pair<Integer, Reflect> h;
  private Vector<ClickableSpan> k = new Vector();
  private int lines = -1;
  private int mEnd = -1;
  private int mStart = -1;
  private CharSequence s;
  
  public ReadInJoyYAFolderTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
  
  private void a(DynamicLayout paramDynamicLayout)
  {
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        int j = paramDynamicLayout.hashCode();
        if ((this.h != null) && (this.h.first != null) && (this.h.second != null) && (((Integer)this.h.first).intValue() == j)) {
          paramDynamicLayout = (Reflect)this.h.second;
        }
        for (;;)
        {
          paramDynamicLayout.set("sStaticLayout", null);
          return;
          paramDynamicLayout = Reflect.on(paramDynamicLayout);
          this.h = new Pair(Integer.valueOf(j), paramDynamicLayout);
        }
        return;
      }
      catch (Exception paramDynamicLayout)
      {
        QLog.e("ReadInJoyYAFolderTextView", 2, paramDynamicLayout.getMessage());
      }
    }
  }
  
  private void a(DynamicLayout paramDynamicLayout, int paramInt)
  {
    int j = paramDynamicLayout.getLineStart(paramInt - 1);
    paramInt = paramDynamicLayout.getLineEnd(paramInt - 1);
    paramDynamicLayout.getText().subSequence(j, paramInt).toString();
    new SpannableStringBuilder();
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.ELLIPSIS);
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
    if (this.k.size() > 0)
    {
      Iterator localIterator = this.k.iterator();
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
  
  public int l(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    long l;
    do
    {
      return 7;
      l = paramArticleInfo.mChannelID;
      if (paramArticleInfo.isPGCShortContent())
      {
        if ((l == 0L) || (kys.dv((int)l)))
        {
          AladdinConfig localAladdinConfig = Aladdin.getConfig(168);
          int j = localAladdinConfig.getIntegerFromString("main_channel_textlines", 3);
          switch (paramArticleInfo.mResolvedFeedType)
          {
          default: 
            return j;
          case 109: 
            return localAladdinConfig.getIntegerFromString("main_channel_pure_textlines", j);
          case 110: 
            return localAladdinConfig.getIntegerFromString("main_channel_single_image_textlines", j);
          case 111: 
          case 132: 
          case 133: 
            return localAladdinConfig.getIntegerFromString("main_channel_multiple_image_textlines", j);
          }
          return 2147483647;
        }
        return Aladdin.getConfig(168).getIntegerFromString("channel_textlines", 7);
      }
    } while (l != 0L);
    return 3;
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
    label272:
    do
    {
      do
      {
        return;
        this.dirty = false;
      } while ((this.lines >= 0) && (this.lines <= this.acA));
      localObject3 = getPaint();
      localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(this.ELLIPSIS).append(this.alp);
      if (this.aR != null) {
        localSpannableStringBuilder.setSpan(this.aR, localSpannableStringBuilder.length() - this.alp.length(), localSpannableStringBuilder.length(), 33);
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
    label389:
    label461:
    int m;
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
          b(localSpannableStringBuilder);
          super.setText(localSpannableStringBuilder, this.a);
          return;
          m = j + 1;
          localObject1 = (CharSequence)localArrayList.get(paramInt2);
          localCharSequence1 = ((CharSequence)localObject1).subSequence(paramInt4, ((CharSequence)localObject1).length());
          localObject1 = TextUtils.ellipsize(localCharSequence1, (TextPaint)localObject3, f2, TextUtils.TruncateAt.END);
          if ((((CharSequence)localObject1).length() <= 4) || (!(localObject1 instanceof SpannableStringBuilder))) {
            break label1665;
          }
          localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3);
          localCharSequence2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
          if ((((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') && (((TextPaint)localObject3).measureText(((CharSequence)localObject2).toString()) > paramInt3 - paramInt1)) {
            localObject1 = a((SpannableStringBuilder)localObject2).append(alq);
          }
        }
      }
    }
    label1665:
    for (;;)
    {
      label762:
      if (((localObject1 instanceof Spanned)) && (m > 1)) {}
      for (localObject2 = (ClickableSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), ClickableSpan.class);; localObject2 = null)
      {
        int n;
        int i1;
        if (localObject1.equals(localCharSequence1))
        {
          n = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject1).append('\n');
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            paramInt4 = localSpannableStringBuilder.getSpanStart(localObject2[0]);
            j = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
            if ((paramInt4 >= 0) && (j >= paramInt4) && (j < n))
            {
              n = ((Spanned)localObject1).getSpanStart(localObject2[0]);
              i1 = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
              if ((n == 0) && (i1 >= n))
              {
                j = Math.min(j + i1 + 1, localSpannableStringBuilder.length());
                localSpannableStringBuilder.setSpan(localObject2[0], paramInt4, j, 33);
              }
            }
          }
          paramInt4 = 0;
          paramInt2 += 1;
          j = m;
          break label272;
          if (((TextPaint)localObject3).measureText(localCharSequence2.toString()) <= paramInt3 - paramInt1) {
            break label1665;
          }
          localObject1 = a((SpannableStringBuilder)localCharSequence2).append(alq);
          break label762;
        }
        j = paramInt4;
        if (((CharSequence)localObject1).length() > 0)
        {
          n = localSpannableStringBuilder.length();
          if (((CharSequence)localObject1).charAt(((CharSequence)localObject1).length() - 1) != '…') {
            break label1266;
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
              i1 = localSpannableStringBuilder.getSpanStart(localObject2[0]);
              int i2 = localSpannableStringBuilder.getSpanEnd(localObject2[0]);
              j = paramInt4;
              if (i1 >= 0)
              {
                j = paramInt4;
                if (i2 >= i1)
                {
                  j = paramInt4;
                  if (i2 < n)
                  {
                    n = ((Spanned)localObject1).getSpanStart(localObject2[0]);
                    int i3 = ((Spanned)localObject1).getSpanEnd(localObject2[0]);
                    j = paramInt4;
                    if (n == 0)
                    {
                      j = paramInt4;
                      if (i3 >= n)
                      {
                        j = Math.min(i2 + i3 + 1, localSpannableStringBuilder.length());
                        localSpannableStringBuilder.setSpan(localObject2[0], i1, j, 33);
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
          label1266:
          localSpannableStringBuilder.append(((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 3)).append('\n');
          paramInt4 += ((CharSequence)localObject1).length() - 3;
        }
        localSpannableStringBuilder.append(((CharSequence)localObject3).subSequence(0, ((CharSequence)localObject3).length() - 3));
        break label461;
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
          b(localSpannableStringBuilder);
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
        break label389;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.acA > 0)
    {
      Object localObject = getLayout();
      if ((localObject instanceof DynamicLayout))
      {
        localObject = (DynamicLayout)localObject;
        a((DynamicLayout)localObject);
        this.lines = ((DynamicLayout)localObject).getLineCount();
        paramInt2 = getCompoundPaddingTop() + getCompoundPaddingBottom() + this.acA * getLineHeight();
        paramInt1 = paramInt2;
        if (Build.VERSION.SDK_INT >= 16) {
          paramInt1 = (int)(paramInt2 - getLineSpacingExtra());
        }
        if ((this.lines >= this.acA) && (paramInt1 > 0)) {
          setMeasuredDimension(getMeasuredWidth(), paramInt1);
        }
        if (this.ask) {
          a((DynamicLayout)localObject, this.lines);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    int j;
    ClickableSpan[] arrayOfClickableSpan;
    boolean bool1;
    try
    {
      j = paramMotionEvent.getActionMasked();
      int m = (int)paramMotionEvent.getX();
      int n = (int)paramMotionEvent.getY();
      int i1 = getTotalPaddingLeft();
      int i2 = getTotalPaddingTop();
      int i3 = getScrollX();
      int i4 = getScrollY();
      paramMotionEvent = getLayout();
      m = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(n - i2 + i4), m - i1 + i3);
      paramMotionEvent = getText();
      if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
        break label447;
      }
      paramMotionEvent = (Spannable)getText();
      arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(m, m, ClickableSpan.class);
      if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
        break label348;
      }
      if (j == 0)
      {
        clearSpans();
        this.aR = arrayOfClickableSpan[0];
        this.mStart = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.mEnd = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        bool1 = bool3;
        if (this.mStart < 0) {
          break label451;
        }
        bool1 = bool3;
        if (this.mEnd < this.mStart) {
          break label451;
        }
        bool1 = bool3;
        if (!(arrayOfClickableSpan[0] instanceof b)) {
          break label451;
        }
        ((b)arrayOfClickableSpan[0]).setPressed(true);
        this.k.add(arrayOfClickableSpan[0]);
        return true;
      }
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isDevelopLevel()) {
        paramMotionEvent.printStackTrace();
      }
      return bool2;
    }
    if ((j != 1) && (j != 3))
    {
      bool1 = bool3;
      if (j != 4) {}
    }
    else
    {
      this.aR = null;
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
      return true;
      label348:
      if ((this.mStart >= 0) && (this.mEnd >= this.mStart))
      {
        if ((this.aR != null) && ((this.aR instanceof b)))
        {
          ((b)this.aR).setPressed(false);
          this.aR = null;
        }
        Selection.removeSelection(paramMotionEvent);
        this.mStart = -1;
        this.mEnd = -1;
      }
      clearSpans();
      bool1 = this.asj;
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      label447:
      bool1 = bool2;
    }
    label451:
    return bool1;
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
  
  public void setShouldCallClick(boolean paramBoolean)
  {
    this.asj = paramBoolean;
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
        if (j >= paramTextView.getText().length()) {
          return true;
        }
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView
 * JD-Core Version:    0.7.0.1
 */