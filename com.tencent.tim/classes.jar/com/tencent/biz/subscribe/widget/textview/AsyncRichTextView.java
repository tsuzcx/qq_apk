package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import aofk;
import atau.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.ISkinIgnoreTypeface;
import com.tencent.theme.TextHook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sdy;
import sjs.a;
import sjt.a;
import sju.a;
import sjv;
import sjw;
import skb;
import skb.a;
import skb.b;

public class AsyncRichTextView
  extends SafeTextView
  implements Handler.Callback, ISkinIgnoreTypeface
{
  private a a;
  protected URLDrawable.URLDrawableListener a;
  protected sjt.a a;
  protected sju.a a;
  private String aEp;
  private boolean aLL = true;
  private boolean aLM;
  private boolean aLN;
  private int atColorRes;
  protected sjs.a b;
  public sju.a b;
  private double bt = 1.0D;
  private int bxq = -2147483648;
  protected int bxr;
  protected int bxs = Color.parseColor("#CFB027");
  protected int bxt = -1;
  protected sju.a c = new sjv(this);
  private Drawable.Callback callback;
  private CharSequence currentText;
  private ColorStateList g;
  protected ColorStateList h = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167474);
  private Handler handler = new Handler(Looper.getMainLooper(), this);
  private Context mContext;
  private boolean mNeedLayout;
  protected View.OnClickListener onClickListener;
  private int urlColorRes = -2147483648;
  
  public AsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new sjw(this);
    b(paramContext, null);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new sjw(this);
    b(paramContext, paramAttributeSet);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new sjw(this);
    b(paramContext, paramAttributeSet);
  }
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, sju.a parama, Drawable.Callback paramCallback)
  {
    this.currentText = paramCharSequence;
    this.g = paramColorStateList;
    this.atColorRes = paramInt1;
    this.jdField_a_of_type_Sju$a = parama;
    this.callback = paramCallback;
    paramCallback = new skb.b();
    paramCallback.oj = ((int)(getTextSize() * this.bt));
    paramCallback.verticalAlignment = this.bxr;
    paramCallback.D = getText();
    paramCharSequence = skb.a(paramCallback, getContext(), paramCharSequence, paramColorStateList, paramInt1, this.urlColorRes, paramInt2, parama, this.jdField_a_of_type_Sjt$a, this.jdField_b_of_type_Sjs$a, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.aLL, this.aLM);
    if ((paramCharSequence != null) && (paramCharSequence.aLP)) {
      if (parama != null) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
    for (;;)
    {
      super.setText(new aofk(a(paramCharSequence), 3, 16), null);
      return;
      if ((paramCharSequence != null) && (paramCharSequence.aLQ) && (this.jdField_b_of_type_Sjs$a != null)) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mContext = paramContext;
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.ql);
    try
    {
      this.bt = paramContext.getFloat(1, 1.0F);
      if ((this.bt <= 0.1D) || (this.bt >= 10.0D)) {
        this.bt = 1.0D;
      }
      this.bxr = paramContext.getInt(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected Spannable a(Spannable paramSpannable)
  {
    return paramSpannable;
  }
  
  public void bxX()
  {
    setTypeface(TextHook.getInstance().getSystemDefaultFont());
  }
  
  @RequiresApi(api=16)
  protected void bzg()
  {
    if (Build.VERSION.SDK_INT < 16) {
      break label8;
    }
    label8:
    while ((getEllipsize() != TextUtils.TruncateAt.END) || (getLayout() == null) || (getLineCount() <= getMaxLines()) || (getMaxLines() <= 0)) {
      return;
    }
    int m = getLayout().getLineStart(getMaxLines() - 1);
    Object localObject1 = TextUtils.ellipsize(getText().subSequence(m, getText().length()), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END);
    Object localObject2;
    int i;
    int j;
    label239:
    int k;
    if (this.aLN)
    {
      localObject2 = new SpannableStringBuilder(getText());
      localObject2 = (ImageSpan[])((SpannableStringBuilder)localObject2).getSpans(((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), ImageSpan.class);
      if ((localObject2.length > 0) && (localObject2[0].getDrawable() != null))
      {
        i = localObject2[0].getDrawable().getIntrinsicWidth();
        int n = 0 + i;
        if (n <= 0) {
          break label538;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
        int i1 = (int)Math.ceil(getPaint().measureText("...".toString()));
        j = ((CharSequence)localObject1).length();
        i = 0;
        if (i >= n + i1) {
          break label394;
        }
        if (!((CharSequence)localObject1).toString().endsWith("[/em]")) {
          break label346;
        }
        Matcher localMatcher = sdy.N.matcher((CharSequence)localObject1);
        int i2;
        do
        {
          if (!localMatcher.find()) {
            break;
          }
          k = localMatcher.start();
          i2 = localMatcher.end();
        } while ((k >= j) || (i2 != j));
        j = (int)(i + getTextSize());
        i = k;
      }
      for (;;)
      {
        label317:
        if (i < 0) {
          break label520;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, i);
        k = j;
        j = i;
        i = k;
        break label239;
        i = 0;
        break;
        label346:
        if (j <= 0) {
          break label529;
        }
        k = (int)Math.floor(getPaint().measureText(((CharSequence)localObject1).subSequence(j - 1, j).toString()));
        j -= 1;
        k = i + k;
        i = j;
        j = k;
      }
      label394:
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).append("...");
      ((SpannableStringBuilder)localObject1).append(" ");
      ((SpannableStringBuilder)localObject1).setSpan(localObject2[0], ((SpannableStringBuilder)localObject1).length() - 1, ((SpannableStringBuilder)localObject1).length(), 33);
    }
    label520:
    label529:
    label538:
    for (;;)
    {
      localObject2 = new SpannableStringBuilder();
      if (m > 0) {
        ((SpannableStringBuilder)localObject2).append(getText().subSequence(0, m));
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      super.setText(new aofk((CharSequence)localObject2, 3, 16), null);
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView$a == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView$a.bkt();
      return;
      k = j;
      j = i;
      i = k;
      break label239;
      k = i;
      i = j;
      j = k;
      break label317;
    }
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (CharSequence)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.equals(this.currentText))) {
        a(paramMessage, this.g, this.atColorRes, this.bxq, this.jdField_a_of_type_Sju$a, this.callback);
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CharSequence localCharSequence = getText();
    if ((localCharSequence instanceof SpannableStringBuilder)) {
      ((SpannableStringBuilder)localCharSequence).clearSpans();
    }
  }
  
  @RequiresApi(api=16)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mNeedLayout) && (Build.VERSION.SDK_INT > 16))
    {
      bzg();
      this.mNeedLayout = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setFocusable(false);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBoldText(boolean paramBoolean)
  {
    TextPaint localTextPaint = getPaint();
    if (localTextPaint != null) {
      localTextPaint.setFakeBoldText(paramBoolean);
    }
  }
  
  public void setDefaultAtColor(int paramInt)
  {
    this.bxs = paramInt;
  }
  
  public void setDefaultAtColor(String paramString)
  {
    this.bxs = Color.parseColor(paramString);
  }
  
  public void setDefaultUserNameClickListener(sju.a parama)
  {
    this.c = parama;
  }
  
  public void setNeedParseColor(boolean paramBoolean)
  {
    this.aLL = paramBoolean;
  }
  
  public void setNoNeedAtOrSchema(boolean paramBoolean)
  {
    this.aLM = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomSchemaClickListener(sjs.a parama)
  {
    this.jdField_b_of_type_Sjs$a = parama;
  }
  
  public void setOnCustomUrlClickListener(sjt.a parama)
  {
    this.jdField_a_of_type_Sjt$a = parama;
  }
  
  public void setOnTriggerEllipseListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView$a = parama;
  }
  
  public void setOnUserNewClickListener(sju.a parama)
  {
    this.jdField_b_of_type_Sju$a = parama;
  }
  
  public void setOrgText(String paramString)
  {
    this.aEp = paramString;
  }
  
  public void setSchemaColorRes(int paramInt)
  {
    this.bxq = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.mNeedLayout = true;
    a(paramCharSequence, this.h, this.bxs, this.bxt, this.c, null);
  }
  
  public void setUrlColorRes(int paramInt)
  {
    this.urlColorRes = paramInt;
  }
  
  public void uO(boolean paramBoolean)
  {
    this.aLN = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void bkt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */