package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  private static final int MAX_ITEMS_MEASURED = 15;
  private static final int MODE_DIALOG = 0;
  private static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "AppCompatSpinner";
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private int mDropDownWidth;
  private ForwardingListener mForwardingListener;
  private AppCompatSpinner.DropdownPopup mPopup;
  private final Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  private final Rect mTempRect;
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, android.content.res.Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 65	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 67	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 69	android/graphics/Rect:<init>	()V
    //   15: putfield 71	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 76	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 82	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore 10
    //   30: aload_0
    //   31: new 84	android/support/v7/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 87	android/support/v7/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 89	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +277 -> 321
    //   47: aload_0
    //   48: new 91	android/support/v7/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 94	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   65: ifnull +176 -> 241
    //   68: iload 4
    //   70: istore 7
    //   72: iload 4
    //   74: iconst_m1
    //   75: if_icmpne +63 -> 138
    //   78: aload_1
    //   79: aload_2
    //   80: getstatic 41	android/support/v7/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   83: iload_3
    //   84: iconst_0
    //   85: invokevirtual 101	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   88: astore 8
    //   90: iload 4
    //   92: istore 6
    //   94: aload 8
    //   96: astore 5
    //   98: aload 8
    //   100: iconst_0
    //   101: invokevirtual 107	android/content/res/TypedArray:hasValue	(I)Z
    //   104: ifeq +16 -> 120
    //   107: aload 8
    //   109: astore 5
    //   111: aload 8
    //   113: iconst_0
    //   114: iconst_0
    //   115: invokevirtual 111	android/content/res/TypedArray:getInt	(II)I
    //   118: istore 6
    //   120: iload 6
    //   122: istore 7
    //   124: aload 8
    //   126: ifnull +12 -> 138
    //   129: aload 8
    //   131: invokevirtual 114	android/content/res/TypedArray:recycle	()V
    //   134: iload 6
    //   136: istore 7
    //   138: iload 7
    //   140: iconst_1
    //   141: if_icmpne +100 -> 241
    //   144: new 116	android/support/v7/widget/AppCompatSpinner$DropdownPopup
    //   147: dup
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   153: aload_2
    //   154: iload_3
    //   155: invokespecial 119	android/support/v7/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   164: aload_2
    //   165: getstatic 76	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   168: iload_3
    //   169: iconst_0
    //   170: invokestatic 82	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   173: astore 8
    //   175: aload_0
    //   176: aload 8
    //   178: getstatic 122	android/support/v7/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   181: bipush 254
    //   183: invokevirtual 125	android/support/v7/widget/TintTypedArray:getLayoutDimension	(II)I
    //   186: putfield 127	android/support/v7/widget/AppCompatSpinner:mDropDownWidth	I
    //   189: aload 5
    //   191: aload 8
    //   193: getstatic 130	android/support/v7/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   196: invokevirtual 134	android/support/v7/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   199: invokevirtual 138	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   202: aload 5
    //   204: aload 10
    //   206: getstatic 141	android/support/v7/appcompat/R$styleable:Spinner_android_prompt	I
    //   209: invokevirtual 145	android/support/v7/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   212: invokevirtual 149	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   215: aload 8
    //   217: invokevirtual 150	android/support/v7/widget/TintTypedArray:recycle	()V
    //   220: aload_0
    //   221: aload 5
    //   223: putfield 152	android/support/v7/widget/AppCompatSpinner:mPopup	Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    //   226: aload_0
    //   227: new 154	android/support/v7/widget/AppCompatSpinner$1
    //   230: dup
    //   231: aload_0
    //   232: aload_0
    //   233: aload 5
    //   235: invokespecial 157	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
    //   238: putfield 159	android/support/v7/widget/AppCompatSpinner:mForwardingListener	Landroid/support/v7/widget/ForwardingListener;
    //   241: aload 10
    //   243: getstatic 162	android/support/v7/appcompat/R$styleable:Spinner_android_entries	I
    //   246: invokevirtual 166	android/support/v7/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   249: astore 5
    //   251: aload 5
    //   253: ifnull +28 -> 281
    //   256: new 168	android/widget/ArrayAdapter
    //   259: dup
    //   260: aload_1
    //   261: ldc 169
    //   263: aload 5
    //   265: invokespecial 172	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   268: astore_1
    //   269: aload_1
    //   270: getstatic 177	android/support/v7/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   273: invokevirtual 181	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   276: aload_0
    //   277: aload_1
    //   278: invokevirtual 185	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   281: aload 10
    //   283: invokevirtual 150	android/support/v7/widget/TintTypedArray:recycle	()V
    //   286: aload_0
    //   287: iconst_1
    //   288: putfield 187	android/support/v7/widget/AppCompatSpinner:mPopupSet	Z
    //   291: aload_0
    //   292: getfield 189	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   295: ifnull +16 -> 311
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 189	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   303: invokevirtual 185	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   306: aload_0
    //   307: aconst_null
    //   308: putfield 189	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   311: aload_0
    //   312: getfield 89	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   315: aload_2
    //   316: iload_3
    //   317: invokevirtual 193	android/support/v7/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   320: return
    //   321: aload 10
    //   323: getstatic 196	android/support/v7/appcompat/R$styleable:Spinner_popupTheme	I
    //   326: iconst_0
    //   327: invokevirtual 199	android/support/v7/widget/TintTypedArray:getResourceId	(II)I
    //   330: istore 6
    //   332: iload 6
    //   334: ifeq +20 -> 354
    //   337: aload_0
    //   338: new 91	android/support/v7/view/ContextThemeWrapper
    //   341: dup
    //   342: aload_1
    //   343: iload 6
    //   345: invokespecial 201	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   348: putfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   351: goto -290 -> 61
    //   354: getstatic 206	android/os/Build$VERSION:SDK_INT	I
    //   357: bipush 23
    //   359: if_icmpge +15 -> 374
    //   362: aload_1
    //   363: astore 5
    //   365: aload_0
    //   366: aload 5
    //   368: putfield 96	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   371: goto -310 -> 61
    //   374: aconst_null
    //   375: astore 5
    //   377: goto -12 -> 365
    //   380: astore 9
    //   382: aconst_null
    //   383: astore 8
    //   385: aload 8
    //   387: astore 5
    //   389: ldc 21
    //   391: ldc 208
    //   393: aload 9
    //   395: invokestatic 214	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   398: pop
    //   399: iload 4
    //   401: istore 7
    //   403: aload 8
    //   405: ifnull -267 -> 138
    //   408: aload 8
    //   410: invokevirtual 114	android/content/res/TypedArray:recycle	()V
    //   413: iload 4
    //   415: istore 7
    //   417: goto -279 -> 138
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 5
    //   424: aload 5
    //   426: ifnull +8 -> 434
    //   429: aload 5
    //   431: invokevirtual 114	android/content/res/TypedArray:recycle	()V
    //   434: aload_1
    //   435: athrow
    //   436: astore_1
    //   437: goto -13 -> 424
    //   440: astore 9
    //   442: goto -57 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	AppCompatSpinner
    //   0	445	1	paramContext	Context
    //   0	445	2	paramAttributeSet	AttributeSet
    //   0	445	3	paramInt1	int
    //   0	445	4	paramInt2	int
    //   0	445	5	paramTheme	android.content.res.Resources.Theme
    //   92	252	6	i	int
    //   70	346	7	j	int
    //   88	321	8	localObject	java.lang.Object
    //   380	14	9	localException1	java.lang.Exception
    //   440	1	9	localException2	java.lang.Exception
    //   28	294	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   78	90	380	java/lang/Exception
    //   78	90	420	finally
    //   98	107	436	finally
    //   111	120	436	finally
    //   389	399	436	finally
    //   98	107	440	java/lang/Exception
    //   111	120	440	java/lang/Exception
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i2 - i)));
    View localView = null;
    int k = 0;
    i = 0;
    if (j < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(j);
      if (m == i) {
        break label204;
      }
      localView = null;
      i = m;
    }
    label204:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        return this.mTempRect.left + this.mTempRect.right + k;
      }
      return k;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.mPopup != null) {
      return this.mPopup.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.mPopup != null) {
      return this.mPopup.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.mPopup != null) {
      return this.mDropDownWidth;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.mPopup != null) {
      return this.mPopup.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.mPopup != null) {
      return this.mPopupContext;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.mPopup != null) {
      return this.mPopup.getHintText();
    }
    return super.getPrompt();
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mForwardingListener != null) && (this.mForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.mPopup != null)
    {
      if (!this.mPopup.isShowing()) {
        this.mPopup.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet) {
      this.mTempAdapter = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.mPopup == null);
    if (this.mPopupContext == null) {}
    for (Context localContext = getContext();; localContext = this.mPopupContext)
    {
      this.mPopup.setAdapter(new AppCompatSpinner.DropDownAdapter(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.mPopup != null) {
      this.mPopup.setHorizontalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.mPopup != null) {
      this.mPopup.setVerticalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null) {
      this.mDropDownWidth = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mPopup != null) {
      this.mPopup.setBackgroundDrawable(paramDrawable);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.mPopup != null)
    {
      this.mPopup.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */