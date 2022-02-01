package com.tencent.mobileqq.activity.richmedia.view;

import aavd;
import aave;
import aavn;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class ExtendEditText
  extends EditText
{
  private static final a b = new aavd();
  public static final a c = new aave();
  protected float[] A;
  private int MAX_LINE = 4;
  private boolean Mf;
  protected aavn a;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  protected GradientDrawable.Orientation a;
  private a jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$a;
  private c jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$c;
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
  
  private void a(d paramd)
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
      i = d.parseColor(paramd.strTextColor);
      setTextColor(i);
      setHintTextColor(i);
      if ((paramd.lSparkleFlag & 0x2) == 0L) {
        break label271;
      }
      setShadowLayer(wja.dp2px(paramd.iShadowBlurRadius, getResources()), wja.dp2px(paramd.iShadowOffsetX, getResources()), wja.dp2px(paramd.iShadowOffsetY, getResources()), d.parseColor(paramd.strShadowColor));
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
            ((ArrayList)localObject).add(Integer.valueOf(d.parseColor((String)paramd.vecTextColorAnimation.get(i))));
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
          localObject[i] = d.parseColor((String)paramd.vecGradientColor.get(i));
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
    switch (aavf.ck[this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation.ordinal()])
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
      setFilters(new InputFilter[] { new b(this.maxLength) });
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
  
  public void setLimitListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$c = paramc;
  }
  
  public void setMaxLengthConvertor(a parama)
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
    a(d.a(paramString));
  }
  
  public static abstract interface a
  {
    public abstract int a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
    
    public abstract int b(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }
  
  class b
    implements InputFilter
  {
    private int mMax;
    
    public b(int paramInt)
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
      ExtendEditText.a locala = ExtendEditText.a(ExtendEditText.this);
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
  
  public static abstract interface c
  {
    public abstract void jR(int paramInt);
  }
  
  public static class d
  {
    public String actId = "";
    public String coverUrl = "";
    public String fontUsedTips = "";
    public int iGradientDirection;
    public int iShadowBlurRadius;
    public int iShadowOffsetX;
    public int iShadowOffsetY;
    public int iTextColorSpanTime;
    public int id = -1;
    public long lSparkleFlag;
    public String ruleId = "";
    public String strShadowColor = "";
    public String strTextColor = "";
    public ArrayList<String> vecGradientColor;
    public ArrayList<Double> vecGradientPosition;
    public ArrayList<String> vecTextColorAnimation;
    
    public static d a(String paramString)
    {
      d locald = new d();
      locald.fillData(paramString);
      return locald;
    }
    
    public static int parseColor(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      String str = paramString.trim();
      paramString = str;
      if (!str.startsWith("#")) {
        paramString = "#" + str;
      }
      try
      {
        i = Color.parseColor(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = 0;
        }
      }
    }
    
    /* Error */
    public void fillData(String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 4
      //   3: new 98	org/json/JSONObject
      //   6: dup
      //   7: aload_1
      //   8: invokespecial 100	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   11: astore_1
      //   12: aload_0
      //   13: aload_1
      //   14: ldc 102
      //   16: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   19: putfield 45	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:id	I
      //   22: aload_0
      //   23: aload_1
      //   24: ldc 106
      //   26: invokevirtual 110	org/json/JSONObject:optLong	(Ljava/lang/String;)J
      //   29: putfield 112	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:lSparkleFlag	J
      //   32: aload_0
      //   33: aload_1
      //   34: ldc 113
      //   36: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   39: putfield 47	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:strTextColor	Ljava/lang/String;
      //   42: aload_0
      //   43: aload_1
      //   44: ldc 118
      //   46: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   49: putfield 120	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:iShadowOffsetX	I
      //   52: aload_0
      //   53: aload_1
      //   54: ldc 121
      //   56: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   59: putfield 123	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:iShadowOffsetY	I
      //   62: aload_0
      //   63: aload_1
      //   64: ldc 124
      //   66: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   69: putfield 126	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:iShadowBlurRadius	I
      //   72: aload_0
      //   73: aload_1
      //   74: ldc 127
      //   76: invokevirtual 117	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   79: putfield 49	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:strShadowColor	Ljava/lang/String;
      //   82: aload_1
      //   83: ldc 128
      //   85: invokevirtual 132	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   88: astore 5
      //   90: aload 5
      //   92: ifnonnull +44 -> 136
      //   95: iconst_0
      //   96: istore_2
      //   97: aload_0
      //   98: new 134	java/util/ArrayList
      //   101: dup
      //   102: invokespecial 135	java/util/ArrayList:<init>	()V
      //   105: putfield 137	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecGradientColor	Ljava/util/ArrayList;
      //   108: iconst_0
      //   109: istore_3
      //   110: iload_3
      //   111: iload_2
      //   112: if_icmpge +40 -> 152
      //   115: aload_0
      //   116: getfield 137	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecGradientColor	Ljava/util/ArrayList;
      //   119: aload 5
      //   121: iload_3
      //   122: invokevirtual 143	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   125: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   128: pop
      //   129: iload_3
      //   130: iconst_1
      //   131: iadd
      //   132: istore_3
      //   133: goto -23 -> 110
      //   136: aload 5
      //   138: invokevirtual 151	org/json/JSONArray:length	()I
      //   141: istore_2
      //   142: goto -45 -> 97
      //   145: astore 5
      //   147: aload 5
      //   149: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   152: aload_0
      //   153: new 134	java/util/ArrayList
      //   156: dup
      //   157: invokespecial 135	java/util/ArrayList:<init>	()V
      //   160: putfield 153	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecGradientPosition	Ljava/util/ArrayList;
      //   163: aload_1
      //   164: ldc 154
      //   166: invokevirtual 132	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   169: astore 5
      //   171: aload 5
      //   173: ifnonnull +37 -> 210
      //   176: iconst_0
      //   177: istore_2
      //   178: goto +149 -> 327
      //   181: iload_3
      //   182: iload_2
      //   183: if_icmpge +43 -> 226
      //   186: aload_0
      //   187: getfield 153	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecGradientPosition	Ljava/util/ArrayList;
      //   190: aload 5
      //   192: iload_3
      //   193: invokevirtual 158	org/json/JSONArray:getDouble	(I)D
      //   196: invokestatic 164	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   199: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   202: pop
      //   203: iload_3
      //   204: iconst_1
      //   205: iadd
      //   206: istore_3
      //   207: goto -26 -> 181
      //   210: aload 5
      //   212: invokevirtual 151	org/json/JSONArray:length	()I
      //   215: istore_2
      //   216: goto +111 -> 327
      //   219: astore 5
      //   221: aload 5
      //   223: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   226: aload_0
      //   227: aload_1
      //   228: ldc 165
      //   230: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   233: putfield 167	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:iGradientDirection	I
      //   236: aload_0
      //   237: new 134	java/util/ArrayList
      //   240: dup
      //   241: invokespecial 135	java/util/ArrayList:<init>	()V
      //   244: putfield 169	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecTextColorAnimation	Ljava/util/ArrayList;
      //   247: aload_1
      //   248: ldc 170
      //   250: invokevirtual 132	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   253: astore 5
      //   255: aload 5
      //   257: ifnonnull +34 -> 291
      //   260: iconst_0
      //   261: istore_2
      //   262: iload 4
      //   264: istore_3
      //   265: iload_3
      //   266: iload_2
      //   267: if_icmpge +43 -> 310
      //   270: aload_0
      //   271: getfield 169	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:vecTextColorAnimation	Ljava/util/ArrayList;
      //   274: aload 5
      //   276: iload_3
      //   277: invokevirtual 143	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   280: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   283: pop
      //   284: iload_3
      //   285: iconst_1
      //   286: iadd
      //   287: istore_3
      //   288: goto -23 -> 265
      //   291: aload 5
      //   293: invokevirtual 151	org/json/JSONArray:length	()I
      //   296: istore_2
      //   297: iload 4
      //   299: istore_3
      //   300: goto -35 -> 265
      //   303: astore 5
      //   305: aload 5
      //   307: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   310: aload_0
      //   311: aload_1
      //   312: ldc 171
      //   314: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   317: putfield 173	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$d:iTextColorSpanTime	I
      //   320: return
      //   321: astore_1
      //   322: aload_1
      //   323: invokevirtual 96	java/lang/Exception:printStackTrace	()V
      //   326: return
      //   327: iconst_0
      //   328: istore_3
      //   329: goto -148 -> 181
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	d
      //   0	332	1	paramString	String
      //   96	201	2	i	int
      //   109	220	3	j	int
      //   1	297	4	k	int
      //   88	49	5	localJSONArray1	org.json.JSONArray
      //   145	3	5	localException1	Exception
      //   169	42	5	localJSONArray2	org.json.JSONArray
      //   219	3	5	localException2	Exception
      //   253	39	5	localJSONArray3	org.json.JSONArray
      //   303	3	5	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   82	90	145	java/lang/Exception
      //   97	108	145	java/lang/Exception
      //   115	129	145	java/lang/Exception
      //   136	142	145	java/lang/Exception
      //   163	171	219	java/lang/Exception
      //   186	203	219	java/lang/Exception
      //   210	216	219	java/lang/Exception
      //   247	255	303	java/lang/Exception
      //   270	284	303	java/lang/Exception
      //   291	297	303	java/lang/Exception
      //   3	82	321	java/lang/Exception
      //   147	152	321	java/lang/Exception
      //   152	163	321	java/lang/Exception
      //   221	226	321	java/lang/Exception
      //   226	247	321	java/lang/Exception
      //   305	310	321	java/lang/Exception
      //   310	320	321	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */