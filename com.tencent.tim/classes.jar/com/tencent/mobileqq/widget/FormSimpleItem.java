package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arft;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.MultiImageTextView;

public class FormSimpleItem
  extends RelativeLayout
  implements arft
{
  protected static boolean daf;
  private CharSequence aC;
  protected CharSequence aD;
  protected MultiImageTextView b;
  protected int efQ;
  protected int efR;
  protected int efS;
  private int egd;
  private int ege;
  private int egf;
  protected Drawable ge;
  private int mBgType;
  private int mItemHeight;
  private Drawable mLeftIcon;
  private int mLeftIconHeight;
  private int mLeftIconWidth;
  protected boolean mNeedSetHeight;
  private int mPadding;
  private final Paint mPaint;
  private final Rect mRect;
  protected Drawable mRightIcon;
  protected int mRightIconHeight;
  protected int mRightIconWidth;
  protected boolean mShowArrow;
  protected TextView xt;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public FormSimpleItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 48	android/widget/RelativeLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: new 50	android/graphics/Rect
    //   10: dup
    //   11: invokespecial 53	android/graphics/Rect:<init>	()V
    //   14: putfield 55	com/tencent/mobileqq/widget/FormSimpleItem:mRect	Landroid/graphics/Rect;
    //   17: aload_0
    //   18: new 57	android/graphics/Paint
    //   21: dup
    //   22: invokespecial 58	android/graphics/Paint:<init>	()V
    //   25: putfield 60	com/tencent/mobileqq/widget/FormSimpleItem:mPaint	Landroid/graphics/Paint;
    //   28: aload_0
    //   29: invokevirtual 64	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   32: ldc 65
    //   34: invokevirtual 71	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   37: istore_3
    //   38: aload_0
    //   39: aload_0
    //   40: invokevirtual 64	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   43: invokevirtual 75	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   46: getfield 81	android/util/DisplayMetrics:density	F
    //   49: ldc 82
    //   51: fmul
    //   52: f2d
    //   53: ldc2_w 83
    //   56: dadd
    //   57: d2i
    //   58: putfield 86	com/tencent/mobileqq/widget/FormSimpleItem:ege	I
    //   61: aload_0
    //   62: aload_0
    //   63: invokevirtual 64	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   66: invokevirtual 75	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   69: getfield 81	android/util/DisplayMetrics:density	F
    //   72: ldc 87
    //   74: fmul
    //   75: f2d
    //   76: ldc2_w 83
    //   79: dadd
    //   80: d2i
    //   81: putfield 89	com/tencent/mobileqq/widget/FormSimpleItem:egf	I
    //   84: aload_0
    //   85: aload_0
    //   86: invokevirtual 64	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   89: ldc 90
    //   91: invokevirtual 94	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   94: putfield 96	com/tencent/mobileqq/widget/FormSimpleItem:ge	Landroid/graphics/drawable/Drawable;
    //   97: aconst_null
    //   98: astore 4
    //   100: aload_1
    //   101: aload_2
    //   102: getstatic 102	atau$a:qB	[I
    //   105: invokevirtual 108	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   108: astore_1
    //   109: aload_1
    //   110: astore 4
    //   112: aload_0
    //   113: aload_1
    //   114: iconst_2
    //   115: aload_0
    //   116: invokevirtual 64	com/tencent/mobileqq/widget/FormSimpleItem:getResources	()Landroid/content/res/Resources;
    //   119: ldc 109
    //   121: invokevirtual 71	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   124: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   127: putfield 116	com/tencent/mobileqq/widget/FormSimpleItem:mPadding	I
    //   130: aload_1
    //   131: astore 4
    //   133: aload_0
    //   134: aload_1
    //   135: iconst_1
    //   136: iload_3
    //   137: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   140: putfield 118	com/tencent/mobileqq/widget/FormSimpleItem:mItemHeight	I
    //   143: aload_1
    //   144: astore 4
    //   146: aload_0
    //   147: aload_1
    //   148: bipush 9
    //   150: invokevirtual 122	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   153: putfield 124	com/tencent/mobileqq/widget/FormSimpleItem:aC	Ljava/lang/CharSequence;
    //   156: aload_1
    //   157: astore 4
    //   159: aload_0
    //   160: aload_1
    //   161: bipush 10
    //   163: iconst_0
    //   164: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   167: putfield 129	com/tencent/mobileqq/widget/FormSimpleItem:egd	I
    //   170: aload_1
    //   171: astore 4
    //   173: aload_0
    //   174: aload_1
    //   175: bipush 6
    //   177: invokevirtual 130	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   180: putfield 132	com/tencent/mobileqq/widget/FormSimpleItem:mLeftIcon	Landroid/graphics/drawable/Drawable;
    //   183: aload_1
    //   184: astore 4
    //   186: aload_0
    //   187: aload_1
    //   188: bipush 8
    //   190: iconst_0
    //   191: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   194: putfield 134	com/tencent/mobileqq/widget/FormSimpleItem:mLeftIconWidth	I
    //   197: aload_1
    //   198: astore 4
    //   200: aload_0
    //   201: aload_1
    //   202: bipush 7
    //   204: iconst_0
    //   205: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   208: putfield 136	com/tencent/mobileqq/widget/FormSimpleItem:mLeftIconHeight	I
    //   211: aload_1
    //   212: astore 4
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 118	com/tencent/mobileqq/widget/FormSimpleItem:mItemHeight	I
    //   219: aload_0
    //   220: getfield 136	com/tencent/mobileqq/widget/FormSimpleItem:mLeftIconHeight	I
    //   223: invokestatic 141	java/lang/Math:min	(II)I
    //   226: putfield 136	com/tencent/mobileqq/widget/FormSimpleItem:mLeftIconHeight	I
    //   229: aload_1
    //   230: astore 4
    //   232: aload_0
    //   233: aload_1
    //   234: bipush 17
    //   236: invokevirtual 122	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   239: putfield 143	com/tencent/mobileqq/widget/FormSimpleItem:aD	Ljava/lang/CharSequence;
    //   242: aload_1
    //   243: astore 4
    //   245: aload_0
    //   246: aload_1
    //   247: bipush 18
    //   249: iconst_3
    //   250: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   253: putfield 145	com/tencent/mobileqq/widget/FormSimpleItem:efQ	I
    //   256: aload_1
    //   257: astore 4
    //   259: aload_0
    //   260: aload_1
    //   261: bipush 14
    //   263: invokevirtual 130	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   266: putfield 147	com/tencent/mobileqq/widget/FormSimpleItem:mRightIcon	Landroid/graphics/drawable/Drawable;
    //   269: aload_1
    //   270: astore 4
    //   272: aload_0
    //   273: aload_1
    //   274: bipush 16
    //   276: iconst_0
    //   277: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   280: putfield 149	com/tencent/mobileqq/widget/FormSimpleItem:mRightIconWidth	I
    //   283: aload_1
    //   284: astore 4
    //   286: aload_0
    //   287: aload_1
    //   288: bipush 15
    //   290: iconst_0
    //   291: invokevirtual 114	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   294: putfield 151	com/tencent/mobileqq/widget/FormSimpleItem:mRightIconHeight	I
    //   297: aload_1
    //   298: astore 4
    //   300: aload_0
    //   301: aload_0
    //   302: getfield 118	com/tencent/mobileqq/widget/FormSimpleItem:mItemHeight	I
    //   305: aload_0
    //   306: getfield 151	com/tencent/mobileqq/widget/FormSimpleItem:mRightIconHeight	I
    //   309: invokestatic 141	java/lang/Math:min	(II)I
    //   312: putfield 151	com/tencent/mobileqq/widget/FormSimpleItem:mRightIconHeight	I
    //   315: aload_1
    //   316: astore 4
    //   318: aload_0
    //   319: aload_1
    //   320: bipush 20
    //   322: iconst_0
    //   323: invokevirtual 155	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   326: putfield 157	com/tencent/mobileqq/widget/FormSimpleItem:mShowArrow	Z
    //   329: aload_1
    //   330: astore 4
    //   332: aload_0
    //   333: aload_1
    //   334: iconst_0
    //   335: iconst_0
    //   336: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   339: putfield 159	com/tencent/mobileqq/widget/FormSimpleItem:mBgType	I
    //   342: aload_1
    //   343: astore 4
    //   345: aload_1
    //   346: bipush 11
    //   348: iconst_1
    //   349: invokevirtual 155	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   352: putstatic 161	com/tencent/mobileqq/widget/FormSimpleItem:daf	Z
    //   355: aload_1
    //   356: astore 4
    //   358: aload_0
    //   359: aload_1
    //   360: bipush 12
    //   362: iconst_1
    //   363: invokevirtual 155	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   366: putfield 163	com/tencent/mobileqq/widget/FormSimpleItem:mNeedSetHeight	Z
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 166	android/content/res/TypedArray:recycle	()V
    //   377: aload_0
    //   378: getfield 60	com/tencent/mobileqq/widget/FormSimpleItem:mPaint	Landroid/graphics/Paint;
    //   381: iconst_1
    //   382: invokevirtual 170	android/graphics/Paint:setAntiAlias	(Z)V
    //   385: aload_0
    //   386: getfield 60	com/tencent/mobileqq/widget/FormSimpleItem:mPaint	Landroid/graphics/Paint;
    //   389: getstatic 173	com/tencent/mobileqq/widget/FormSimpleItem:COLOR_DEFAULT_BG_DIVIDER	I
    //   392: invokevirtual 177	android/graphics/Paint:setColor	(I)V
    //   395: aload_0
    //   396: invokevirtual 180	com/tencent/mobileqq/widget/FormSimpleItem:initViews	()V
    //   399: return
    //   400: astore_1
    //   401: aload 4
    //   403: ifnull -26 -> 377
    //   406: aload 4
    //   408: invokevirtual 166	android/content/res/TypedArray:recycle	()V
    //   411: goto -34 -> 377
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 4
    //   418: aload_1
    //   419: astore_2
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 166	android/content/res/TypedArray:recycle	()V
    //   430: aload_2
    //   431: athrow
    //   432: astore_2
    //   433: aload_1
    //   434: astore 4
    //   436: goto -16 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	FormSimpleItem
    //   0	439	1	paramContext	Context
    //   0	439	2	paramAttributeSet	android.util.AttributeSet
    //   37	100	3	i	int
    //   98	337	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   100	109	400	java/lang/Throwable
    //   112	130	400	java/lang/Throwable
    //   133	143	400	java/lang/Throwable
    //   146	156	400	java/lang/Throwable
    //   159	170	400	java/lang/Throwable
    //   173	183	400	java/lang/Throwable
    //   186	197	400	java/lang/Throwable
    //   200	211	400	java/lang/Throwable
    //   214	229	400	java/lang/Throwable
    //   232	242	400	java/lang/Throwable
    //   245	256	400	java/lang/Throwable
    //   259	269	400	java/lang/Throwable
    //   272	283	400	java/lang/Throwable
    //   286	297	400	java/lang/Throwable
    //   300	315	400	java/lang/Throwable
    //   318	329	400	java/lang/Throwable
    //   332	342	400	java/lang/Throwable
    //   345	355	400	java/lang/Throwable
    //   358	369	400	java/lang/Throwable
    //   100	109	414	finally
    //   112	130	432	finally
    //   133	143	432	finally
    //   146	156	432	finally
    //   159	170	432	finally
    //   173	183	432	finally
    //   186	197	432	finally
    //   200	211	432	finally
    //   214	229	432	finally
    //   232	242	432	finally
    //   245	256	432	finally
    //   259	269	432	finally
    //   272	283	432	finally
    //   286	297	432	finally
    //   300	315	432	finally
    //   318	329	432	finally
    //   332	342	432	finally
    //   345	355	432	finally
    //   358	369	432	finally
  }
  
  public static Drawable c(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (daf) {
        return paramResources.getDrawable(2130839682);
      }
      return paramResources.getDrawable(2130851351);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839682);
    case 0: 
      if (daf) {
        return paramResources.getDrawable(2130839682);
      }
      return paramResources.getDrawable(2130851351);
    case 1: 
      if (daf) {
        return paramResources.getDrawable(2130839695);
      }
      return paramResources.getDrawable(2130851365);
    case 2: 
      if (daf) {
        return paramResources.getDrawable(2130839695);
      }
      return paramResources.getDrawable(2130851365);
    case 3: 
      if (daf) {
        return paramResources.getDrawable(2130839689);
      }
      return paramResources.getDrawable(2130851356);
    case 4: 
      return paramResources.getDrawable(2130839693);
    }
    return null;
  }
  
  public static ColorStateList d(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131167304);
    case 0: 
      return paramResources.getColorStateList(2131167304);
    case 2: 
      return paramResources.getColorStateList(2131167379);
    case 1: 
      return paramResources.getColorStateList(2131167312);
    }
    return paramResources.getColorStateList(2131167393);
  }
  
  private boolean isDefTheme()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  public static void setNeedFocusBg(boolean paramBoolean)
  {
    daf = paramBoolean;
  }
  
  public MultiImageTextView a()
  {
    return this.b;
  }
  
  protected void aXn()
  {
    if (this.b == null) {}
    label81:
    label354:
    do
    {
      int i;
      int j;
      int k;
      int m;
      do
      {
        return;
        cVP();
        if (this.xt != null) {
          this.xt.setMaxWidth(this.efR);
        }
        if (isDefTheme()) {
          if (this.mRightIcon != null)
          {
            i = this.mRightIcon.getIntrinsicWidth();
            j = this.mRightIcon.getIntrinsicHeight();
            k = efW;
            int n = efX;
            m = i;
            i = k;
            k = j;
            j = i;
            i = n;
            if (TextUtils.isEmpty(this.aD)) {
              break;
            }
            this.b.setVisibility(0);
            this.b.setText(this.aD);
            this.b.setTextColor(b(getResources(), this.efQ));
            this.b.setContentDescription(this.aD);
            this.b.setMaxWidth(this.efS);
            if ((this.mRightIcon == null) || (!this.mShowArrow)) {
              break label354;
            }
            if ((this.mRightIconWidth <= 0) || (this.mRightIconHeight <= 0)) {
              break label284;
            }
            this.ge.setBounds(0, 0, j, i);
            this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
            this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
          }
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(8);
          return;
          j = 0;
          i = 0;
          break;
          if (this.ge != null)
          {
            j = this.ge.getIntrinsicWidth();
            i = this.ge.getIntrinsicHeight();
            k = 0;
            m = 0;
            break label81;
          }
          i = 0;
          j = 0;
          k = 0;
          m = 0;
          break label81;
          if (isDefTheme())
          {
            this.ge.setBounds(0, 0, j, i);
            this.mRightIcon.setBounds(0, 0, m, k);
            this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
          }
          else
          {
            this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, this.ge, null);
          }
        }
        if ((this.mRightIcon != null) && (!this.mShowArrow))
        {
          if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
          {
            this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
            this.b.setCompoundDrawables(this.mRightIcon, null, null, null);
          }
          for (;;)
          {
            this.b.setCompoundDrawablePadding(8);
            return;
            this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, null, null);
          }
        }
        if ((this.mRightIcon == null) && (this.mShowArrow))
        {
          if (isDefTheme())
          {
            this.ge.setBounds(0, 0, j, i);
            this.b.setCompoundDrawables(null, null, this.ge, null);
          }
          for (;;)
          {
            this.b.setCompoundDrawablePadding(8);
            return;
            this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.ge, null);
          }
        }
      } while ((this.mRightIcon != null) || (this.mShowArrow));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.b.setCompoundDrawablePadding(0);
      return;
      this.b.setText("");
      if ((this.mRightIcon != null) && (this.mShowArrow))
      {
        this.b.setVisibility(0);
        if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
        {
          this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
          this.ge.setBounds(0, 0, j, i);
          this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(8);
          return;
          if (isDefTheme())
          {
            this.ge.setBounds(0, 0, j, i);
            this.mRightIcon.setBounds(0, 0, m, k);
            this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
          }
          else
          {
            this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, this.ge, null);
          }
        }
      }
      if ((this.mRightIcon != null) && (!this.mShowArrow))
      {
        this.b.setVisibility(0);
        if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
        {
          this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
          this.b.setCompoundDrawables(this.mRightIcon, null, null, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(0);
          return;
          this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, null, null);
        }
      }
      if ((this.mRightIcon == null) && (this.mShowArrow))
      {
        this.b.setVisibility(0);
        if (isDefTheme())
        {
          this.ge.setBounds(0, 0, j, i);
          this.b.setCompoundDrawables(null, null, this.ge, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(0);
          return;
          this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.ge, null);
        }
      }
    } while ((this.mRightIcon != null) || (this.mShowArrow));
    label284:
    this.b.setVisibility(8);
  }
  
  public TextView ac()
  {
    return this.xt;
  }
  
  protected ColorStateList b(Resources paramResources, int paramInt)
  {
    return d(paramResources, paramInt);
  }
  
  protected void cVP()
  {
    int k = 0;
    int j = getResources().getDisplayMetrics().widthPixels - this.mPadding * 2;
    int i;
    if (this.aD == null)
    {
      if ((this.mRightIcon != null) && (this.mShowArrow)) {
        i = this.ege + this.mPadding + this.egf;
      }
      for (;;)
      {
        this.efR = (j - i);
        this.efS = 0;
        return;
        if ((this.mRightIcon != null) && (!this.mShowArrow)) {
          i = this.ege;
        } else if ((this.mRightIcon == null) && (this.mShowArrow)) {
          i = this.egf;
        } else {
          i = 0;
        }
      }
    }
    int n = j - this.mPadding;
    if (this.mLeftIcon != null) {
      if (this.mLeftIconWidth == 0)
      {
        i = this.mLeftIcon.getIntrinsicWidth();
        i += this.mPadding;
      }
    }
    for (;;)
    {
      Object localObject = this.xt.getPaint();
      if (this.aC != null) {}
      for (j = i + (int)((Paint)localObject).measureText(this.aC.toString());; j = 0)
      {
        if (this.mRightIcon != null) {
          if (this.mRightIconWidth == 0) {
            i = this.mRightIcon.getIntrinsicWidth();
          }
        }
        label211:
        for (i = i + 0 + this.mPadding;; i = 0)
        {
          if (this.mShowArrow) {
            i = i + this.ge.getIntrinsicWidth() + this.mPadding;
          }
          for (;;)
          {
            localObject = this.b.getPaint();
            localObject = new StaticLayout(this.aD, (TextPaint)localObject, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            int i1 = ((StaticLayout)localObject).getLineCount();
            int m = 0;
            for (;;)
            {
              if (k < i1)
              {
                m = (int)((StaticLayout)localObject).getLineWidth(k) + (int)((StaticLayout)localObject).getLineWidth(k);
                k += 1;
                continue;
                i = this.mLeftIconWidth;
                break;
                i = this.mRightIconWidth;
                break label211;
              }
            }
            k = this.b.getPaddingLeft() + (i + m);
            i = n / 2;
            if ((j >= i) && (k >= i)) {
              j = i;
            }
            for (;;)
            {
              this.efR = j;
              this.efS = i;
              return;
              if ((j > i) && (k < i))
              {
                j = n - k;
                i = k;
              }
              else if ((j < i) && (k > i))
              {
                i = n - j;
              }
              else
              {
                i = k;
              }
            }
          }
        }
      }
      i = 0;
    }
  }
  
  protected Drawable d(Resources paramResources, int paramInt)
  {
    return c(paramResources, paramInt, isDefTheme());
  }
  
  protected void initViews()
  {
    setFocusable(true);
    setClickable(true);
    this.xt = new TextView(getContext());
    if (!TextUtils.isEmpty(this.aC))
    {
      this.xt.setText(this.aC);
      this.xt.setContentDescription(this.aC);
    }
    this.xt.setId(2131367515);
    if (this.mNeedSetHeight)
    {
      this.xt.setSingleLine(true);
      this.xt.setEllipsize(TextUtils.TruncateAt.END);
      this.xt.setDuplicateParentStateEnabled(true);
    }
    this.xt.setTextColor(b(getResources(), this.egd));
    int i = getContext().getResources().getDimensionPixelSize(2131296925);
    this.xt.setTextSize(0, i);
    this.xt.setGravity(19);
    setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.mPadding;
    if (!this.mNeedSetHeight)
    {
      localLayoutParams.topMargin = this.mPadding;
      localLayoutParams.bottomMargin = this.mPadding;
      setMinimumHeight(this.mItemHeight);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    this.xt.setMaxWidth(this.efR);
    addView(this.xt, localLayoutParams);
    this.b = new MultiImageTextView(getContext());
    this.b.setId(2131367517);
    this.b.setSingleLine(true);
    this.b.setTextColor(b(getResources(), this.efQ));
    i = getContext().getResources().getDimensionPixelSize(2131296934);
    this.b.setTextSize(0, i);
    this.b.setGravity(19);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.b.setDuplicateParentStateEnabled(true);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.mPadding;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.b, localLayoutParams);
    aXn();
    setBackgroundDrawable(d(getResources(), this.mBgType));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mBgType == 1) || (this.mBgType == 2))
    {
      if (!isDefTheme()) {
        break label73;
      }
      this.mPaint.setColor(COLOR_DEFAULT_BG_DIVIDER);
    }
    for (;;)
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.mRect.set(PADDING_DEFAULT_BG_DIVIDER, j - HEIGHT_DEFAULT_BG_DIVIDER, i, j);
      paramCanvas.drawRect(this.mRect, this.mPaint);
      return;
      label73:
      this.mPaint.setColor(0);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mNeedSetHeight)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.ge = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.mBgType = paramInt;
    setBackgroundDrawable(d(getResources(), this.mBgType));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.mNeedSetHeight))
    {
      this.mItemHeight = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.xt != null)
    {
      this.mLeftIcon = paramDrawable;
      if (paramDrawable == null) {
        this.xt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.mItemHeight)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.mItemHeight);
      this.xt.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.xt.setCompoundDrawablePadding(this.mPadding);
      return;
      this.xt.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.xt == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.mLeftIcon = paramDrawable;
        this.mLeftIconWidth = paramInt1;
        this.mLeftIconHeight = Math.min(this.mItemHeight, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.mLeftIconHeight);
        this.xt.setCompoundDrawables(paramDrawable, null, null, null);
        this.xt.setCompoundDrawablePadding(this.mPadding);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.xt != null))
    {
      this.aC = paramCharSequence;
      this.xt.setText(this.aC);
      this.xt.setTextColor(b(getResources(), this.egd));
      this.xt.setContentDescription(this.aC);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.aC != null)
    {
      this.egd = paramInt;
      this.xt.setTextColor(b(getResources(), this.egd));
    }
  }
  
  public void setLeftTextNoColor(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.xt != null))
    {
      this.aC = paramCharSequence;
      this.xt.setText(this.aC);
      this.xt.setContentDescription(this.aC);
    }
  }
  
  public void setLeftTextSize(float paramFloat)
  {
    if (this.xt != null) {
      this.xt.setTextSize(paramFloat);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    this.mRightIconWidth = paramInt1;
    this.mRightIconHeight = Math.min(this.mItemHeight, paramInt2);
    this.mRightIcon = paramDrawable;
    aXn();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.aD = paramCharSequence;
    aXn();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.b != null)
    {
      this.efQ = paramInt;
      this.b.setVisibility(0);
      this.b.setTextColor(b(getResources(), this.efQ));
    }
  }
  
  public void showArrow(boolean paramBoolean)
  {
    this.mShowArrow = paramBoolean;
    aXn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */