package dov.com.tencent.mobileqq.activity.richmedia.view;

import aavn;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import atau.a;
import ayvv;
import ayvw;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.c;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class ExtendEditText
  extends EditText
{
  private static final com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.a b = new ayvv();
  public static final com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.a c = new ayvw();
  protected float[] A;
  private int MAX_LINE = 4;
  private boolean Mf;
  protected aavn a;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  protected GradientDrawable.Orientation a;
  private com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.a jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$a;
  private ExtendEditText.c jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$c;
  private int ahA;
  protected int ahy;
  protected int ahz;
  protected int[] cj;
  private Transformation d = new Transformation();
  protected LinearGradient e;
  private String hintText;
  int maxLength = -1;
  
  public ExtendEditText(Context paramContext)
  {
    super(paramContext);
    initFilter();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qi);
    setClearFocusOnBack(paramContext.getBoolean(0, false));
    this.maxLength = paramContext.getInteger(1, -1);
    paramContext.recycle();
    initFilter();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initFilter();
  }
  
  private void a(ExtendEditText.d paramd)
  {
    int j = 0;
    if (paramd == null)
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      }
      setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      setTextColorAnimation(null, 0);
      setGradientColor(null, null, null);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
    }
    int i;
    if ((paramd.lSparkleFlag & 1L) != 0L)
    {
      i = ExtendEditText.d.parseColor(paramd.strTextColor);
      setTextColor(i);
      setHintTextColor(i);
      if ((paramd.lSparkleFlag & 0x2) == 0L) {
        break label271;
      }
      setShadowLayer(wja.dp2px(paramd.iShadowBlurRadius, getResources()), wja.dp2px(paramd.iShadowOffsetX, getResources()), wja.dp2px(paramd.iShadowOffsetY, getResources()), ExtendEditText.d.parseColor(paramd.strShadowColor));
    }
    label158:
    Object localObject;
    int k;
    for (;;)
    {
      if (((paramd.lSparkleFlag & 0x8) != 0L) && (paramd.vecTextColorAnimation != null) && (paramd.vecTextColorAnimation.size() >= 2))
      {
        localObject = new ArrayList(paramd.vecTextColorAnimation.size());
        k = paramd.vecTextColorAnimation.size();
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            ((ArrayList)localObject).add(Integer.valueOf(ExtendEditText.d.parseColor((String)paramd.vecTextColorAnimation.get(i))));
            i += 1;
            continue;
            setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
            setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
            break;
            label271:
            setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            break label158;
          }
        }
        setTextColorAnimation((ArrayList)localObject, paramd.iTextColorSpanTime * (k - 1));
      }
    }
    while (((paramd.lSparkleFlag & 0x4) != 0L) && (paramd.vecGradientColor != null) && (paramd.vecGradientColor.size() >= 2) && (paramd.vecGradientPosition != null) && (paramd.vecGradientPosition.size() >= 2))
    {
      k = paramd.vecGradientColor.size();
      localObject = new int[k];
      i = 0;
      for (;;)
      {
        if (i < k)
        {
          localObject[i] = ExtendEditText.d.parseColor((String)paramd.vecGradientColor.get(i));
          i += 1;
          continue;
          setTextColorAnimation(null, 0);
          break;
        }
      }
      k = paramd.vecGradientPosition.size();
      float[] arrayOfFloat = new float[k];
      i = j;
      while (i < k)
      {
        arrayOfFloat[i] = ((Double)paramd.vecGradientPosition.get(i)).floatValue();
        i += 1;
      }
      GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
      switch (paramd.iGradientDirection)
      {
      default: 
        paramd = GradientDrawable.Orientation.LEFT_RIGHT;
      }
      for (;;)
      {
        setGradientColor((int[])localObject, arrayOfFloat, paramd);
        return;
        paramd = GradientDrawable.Orientation.LEFT_RIGHT;
        continue;
        paramd = GradientDrawable.Orientation.BL_TR;
        continue;
        paramd = GradientDrawable.Orientation.TOP_BOTTOM;
        continue;
        paramd = GradientDrawable.Orientation.TL_BR;
      }
    }
    setGradientColor(null, null, null);
  }
  
  private void acM()
  {
    if ((this.cj == null) || (this.A == null)) {}
    int i;
    do
    {
      return;
      i = jR();
    } while ((this.e != null) && (i == this.ahz));
    this.ahz = i;
    Rect localRect = new Rect(0, 0, this.ahz, getMeasuredHeight());
    float f1;
    float f2;
    float f3;
    float f4;
    switch (ayvx.ck[this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation.ordinal()])
    {
    default: 
      f1 = localRect.left;
      f2 = localRect.top;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.bottom;
    }
    for (;;)
    {
      this.e = new LinearGradient(f1, f2, f3, f4, this.cj, this.A, Shader.TileMode.CLAMP);
      return;
      f3 = localRect.left;
      f2 = localRect.top;
      f4 = 1.0F * localRect.bottom;
      f1 = f3;
      continue;
      f1 = localRect.right;
      f2 = localRect.top;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.bottom;
      continue;
      f1 = localRect.right;
      f4 = localRect.top;
      f3 = 1.0F * localRect.left;
      f2 = f4;
      continue;
      f1 = localRect.right;
      f2 = localRect.bottom;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f3 = localRect.left;
      f2 = localRect.bottom;
      f4 = 1.0F * localRect.top;
      f1 = f3;
      continue;
      f1 = localRect.left;
      f2 = localRect.bottom;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f1 = localRect.left;
      f4 = localRect.top;
      f3 = 1.0F * localRect.right;
      f2 = f4;
    }
  }
  
  private void aiE()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  private void initFilter()
  {
    if (this.maxLength >= 0) {
      setFilters(new InputFilter[] { new a(this.maxLength) });
    }
  }
  
  private int jR()
  {
    int i = 0;
    int j = 0;
    Layout localLayout = getLayout();
    if (TextUtils.isEmpty(getText()))
    {
      CharSequence localCharSequence = getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (!localCharSequence.equals(this.hintText))
        {
          this.hintText = localCharSequence.toString();
          this.ahA = ((int)getPaint().measureText(localCharSequence.toString()));
        }
        j = this.ahA;
      }
    }
    int m;
    int k;
    do
    {
      do
      {
        return j;
      } while (localLayout == null);
      m = localLayout.getLineCount();
      k = 0;
      j = i;
    } while (k >= m);
    j = (int)localLayout.getLineRight(k);
    if (i < j) {
      i = j;
    }
    for (;;)
    {
      k += 1;
      break;
    }
  }
  
  protected void ahL()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i = localLayout.getLineBottom(jS());
    scrollTo(getScrollX(), i);
  }
  
  protected void ahM()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {}
    do
    {
      return;
      i = jS() - 1;
    } while (i < 0);
    int i = localLayout.getLineTop(i);
    scrollTo(getScrollX(), i);
  }
  
  protected void ahN()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int j = jS();
    int i = localLayout.getLineTop(j);
    j = localLayout.getLineBottom(j);
    int m = getScrollY();
    int k = getScrollX();
    if (Math.abs(m - i) <= Math.abs(j - m)) {}
    for (;;)
    {
      scrollTo(k, i);
      return;
      i = j;
    }
  }
  
  public boolean bringPointIntoView(int paramInt)
  {
    return false;
  }
  
  int f(float paramFloat)
  {
    if ((this == null) || (getLayout() == null)) {
      return 0;
    }
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  @TargetApi(14)
  int jS()
  {
    int j = 0;
    int i;
    try
    {
      if (getLayout() == null) {
        return 0;
      }
      i = Build.VERSION.SDK_INT;
      if (i > 13)
      {
        try
        {
          i = getOffsetForPosition(getX(), getY());
          i = getLayout().getLineForOffset(i);
          return i;
        }
        catch (Exception localException1)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            return i;
          }
        }
        QLog.w("ExtendEditText", 2, "", localException1);
        return 0;
      }
    }
    catch (Exception localException2)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("ExtendEditText", 2, "", localException2);
        return 0;
        if (i > 10) {
          return f(getY());
        }
        i = f(getTop());
      }
    }
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    if (this.jdField_a_of_type_Aavn != null)
    {
      boolean bool = this.jdField_a_of_type_Aavn.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.d);
      int i = this.jdField_a_of_type_Aavn.jm();
      setTextColor(i);
      setHintTextColor(i);
      if (bool) {
        postInvalidateOnAnimation();
      }
    }
    acM();
    if (this.e != null) {
      localTextPaint.setShader(this.e);
    }
    super.onDraw(paramCanvas);
    if (this.e != null) {
      localTextPaint.setShader(null);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.Mf) && (paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      aiE();
      clearFocus();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    ahN();
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramInt1 = getLineCount();
    if (this.ahy != paramInt1)
    {
      if (this.ahy < paramInt1)
      {
        if (paramInt1 > this.MAX_LINE) {
          ahL();
        }
        return;
      }
      ahM();
      return;
    }
    ahN();
  }
  
  public void postInvalidateOnAnimation()
  {
    super.postInvalidateDelayed(33L);
  }
  
  public void setBeforeChangeLineCount(int paramInt)
  {
    this.ahy = paramInt;
  }
  
  public void setClearFocusOnBack(boolean paramBoolean)
  {
    this.Mf = paramBoolean;
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.e = null;
    this.cj = paramArrayOfInt;
    this.A = paramArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation = paramOrientation;
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      setLayerType(0, null);
      setDrawingCacheEnabled(false);
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        paramArrayOfInt.printStackTrace();
      }
    }
  }
  
  public void setLimitListener(ExtendEditText.c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$c = paramc;
  }
  
  public void setMaxLengthConvertor(com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$a = parama;
  }
  
  public void setTextColorAnimation(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_Aavn != null) {
      this.jdField_a_of_type_Aavn.cancel();
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramInt == 0))
    {
      this.jdField_a_of_type_Aavn = null;
      return;
    }
    this.jdField_a_of_type_Aavn = new aavn(paramArrayList);
    this.jdField_a_of_type_Aavn.setFillAfter(true);
    this.jdField_a_of_type_Aavn.setRepeatCount(-1);
    this.jdField_a_of_type_Aavn.setRepeatMode(2);
    this.jdField_a_of_type_Aavn.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Aavn.setDuration(paramInt);
    this.jdField_a_of_type_Aavn.setStartTime(0L);
  }
  
  public void setTextEffect(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(null);
      return;
    }
    a(ExtendEditText.d.a(paramString));
  }
  
  class a
    implements InputFilter
  {
    private int mMax;
    
    public a(int paramInt)
    {
      this.mMax = paramInt;
    }
    
    private void aiF()
    {
      if (ExtendEditText.a(ExtendEditText.this) != null) {
        ExtendEditText.a(ExtendEditText.this).jR(this.mMax);
      }
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.a locala = ExtendEditText.a(ExtendEditText.this);
      if (locala == null)
      {
        paramInt3 = paramSpanned.length() - (paramInt4 - paramInt3);
        if (locala != null) {
          break label95;
        }
        paramInt2 -= paramInt1;
      }
      for (;;)
      {
        paramInt3 = this.mMax - paramInt3;
        if (paramInt3 > 0) {
          break label109;
        }
        aiF();
        return "";
        paramInt3 = locala.a(paramSpanned, 0, paramInt3) + locala.a(paramSpanned, paramInt4, paramSpanned.length());
        break;
        label95:
        paramInt2 = locala.a(paramCharSequence, paramInt1, paramInt2);
      }
      label109:
      if (paramInt3 >= paramInt2) {
        return null;
      }
      aiF();
      if (locala != null)
      {
        paramInt3 = locala.b(paramCharSequence, paramInt1, paramInt1 + paramInt3);
        paramInt2 = paramInt3;
        if (paramInt3 <= 0) {
          return "";
        }
      }
      else
      {
        paramInt2 = paramInt3;
      }
      paramInt3 = paramInt2 + paramInt1;
      paramInt2 = paramInt3;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
      {
        paramInt3 -= 1;
        paramInt2 = paramInt3;
        if (paramInt3 == paramInt1) {
          return "";
        }
      }
      return paramCharSequence.subSequence(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */