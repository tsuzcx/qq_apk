package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
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
  private DropdownPopup mPopup;
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
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 79	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 81	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 83	android/graphics/Rect:<init>	()V
    //   15: putfield 85	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 90	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 96	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore 10
    //   30: aload_0
    //   31: new 98	android/support/v7/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 101	android/support/v7/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 103	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +20 -> 64
    //   47: aload_0
    //   48: new 105	android/support/v7/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 108	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: goto +59 -> 120
    //   64: aload 10
    //   66: getstatic 113	android/support/v7/appcompat/R$styleable:Spinner_popupTheme	I
    //   69: iconst_0
    //   70: invokevirtual 117	android/support/v7/widget/TintTypedArray:getResourceId	(II)I
    //   73: istore 6
    //   75: iload 6
    //   77: ifeq +20 -> 97
    //   80: aload_0
    //   81: new 105	android/support/v7/view/ContextThemeWrapper
    //   84: dup
    //   85: aload_1
    //   86: iload 6
    //   88: invokespecial 119	android/support/v7/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   91: putfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   94: goto +26 -> 120
    //   97: getstatic 124	android/os/Build$VERSION:SDK_INT	I
    //   100: bipush 23
    //   102: if_icmpge +9 -> 111
    //   105: aload_1
    //   106: astore 5
    //   108: goto +6 -> 114
    //   111: aconst_null
    //   112: astore 5
    //   114: aload_0
    //   115: aload 5
    //   117: putfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   120: aload_0
    //   121: getfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   124: ifnull +239 -> 363
    //   127: iload 4
    //   129: istore 7
    //   131: iload 4
    //   133: iconst_m1
    //   134: if_icmpne +126 -> 260
    //   137: aload_1
    //   138: aload_2
    //   139: getstatic 55	android/support/v7/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   142: iload_3
    //   143: iconst_0
    //   144: invokevirtual 129	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   147: astore 5
    //   149: iload 4
    //   151: istore 6
    //   153: aload 5
    //   155: astore 8
    //   157: aload 5
    //   159: iconst_0
    //   160: invokevirtual 135	android/content/res/TypedArray:hasValue	(I)Z
    //   163: ifeq +16 -> 179
    //   166: aload 5
    //   168: astore 8
    //   170: aload 5
    //   172: iconst_0
    //   173: iconst_0
    //   174: invokevirtual 138	android/content/res/TypedArray:getInt	(II)I
    //   177: istore 6
    //   179: iload 6
    //   181: istore 7
    //   183: aload 5
    //   185: ifnull +75 -> 260
    //   188: iload 6
    //   190: istore 4
    //   192: aload 5
    //   194: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   197: iload 4
    //   199: istore 7
    //   201: goto +59 -> 260
    //   204: astore 9
    //   206: goto +15 -> 221
    //   209: astore_1
    //   210: aconst_null
    //   211: astore 8
    //   213: goto +35 -> 248
    //   216: astore 9
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: astore 8
    //   225: ldc 35
    //   227: ldc 143
    //   229: aload 9
    //   231: invokestatic 149	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   234: pop
    //   235: iload 4
    //   237: istore 7
    //   239: aload 5
    //   241: ifnull +19 -> 260
    //   244: goto -52 -> 192
    //   247: astore_1
    //   248: aload 8
    //   250: ifnull +8 -> 258
    //   253: aload 8
    //   255: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   258: aload_1
    //   259: athrow
    //   260: iload 7
    //   262: iconst_1
    //   263: if_icmpne +100 -> 363
    //   266: new 13	android/support/v7/widget/AppCompatSpinner$DropdownPopup
    //   269: dup
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   275: aload_2
    //   276: iload_3
    //   277: invokespecial 152	android/support/v7/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   280: astore 5
    //   282: aload_0
    //   283: getfield 110	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   286: aload_2
    //   287: getstatic 90	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   290: iload_3
    //   291: iconst_0
    //   292: invokestatic 96	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   295: astore 8
    //   297: aload_0
    //   298: aload 8
    //   300: getstatic 155	android/support/v7/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   303: bipush 254
    //   305: invokevirtual 158	android/support/v7/widget/TintTypedArray:getLayoutDimension	(II)I
    //   308: putfield 160	android/support/v7/widget/AppCompatSpinner:mDropDownWidth	I
    //   311: aload 5
    //   313: aload 8
    //   315: getstatic 163	android/support/v7/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   318: invokevirtual 167	android/support/v7/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   321: invokevirtual 171	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   324: aload 5
    //   326: aload 10
    //   328: getstatic 174	android/support/v7/appcompat/R$styleable:Spinner_android_prompt	I
    //   331: invokevirtual 178	android/support/v7/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   334: invokevirtual 182	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   337: aload 8
    //   339: invokevirtual 183	android/support/v7/widget/TintTypedArray:recycle	()V
    //   342: aload_0
    //   343: aload 5
    //   345: putfield 185	android/support/v7/widget/AppCompatSpinner:mPopup	Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    //   348: aload_0
    //   349: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   352: dup
    //   353: aload_0
    //   354: aload_0
    //   355: aload 5
    //   357: invokespecial 188	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
    //   360: putfield 190	android/support/v7/widget/AppCompatSpinner:mForwardingListener	Landroid/support/v7/widget/ForwardingListener;
    //   363: aload 10
    //   365: getstatic 193	android/support/v7/appcompat/R$styleable:Spinner_android_entries	I
    //   368: invokevirtual 197	android/support/v7/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   371: astore 5
    //   373: aload 5
    //   375: ifnull +28 -> 403
    //   378: new 199	android/widget/ArrayAdapter
    //   381: dup
    //   382: aload_1
    //   383: ldc 200
    //   385: aload 5
    //   387: invokespecial 203	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   390: astore_1
    //   391: aload_1
    //   392: getstatic 208	android/support/v7/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   395: invokevirtual 212	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   398: aload_0
    //   399: aload_1
    //   400: invokevirtual 216	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   403: aload 10
    //   405: invokevirtual 183	android/support/v7/widget/TintTypedArray:recycle	()V
    //   408: aload_0
    //   409: iconst_1
    //   410: putfield 218	android/support/v7/widget/AppCompatSpinner:mPopupSet	Z
    //   413: aload_0
    //   414: getfield 220	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   417: astore_1
    //   418: aload_1
    //   419: ifnull +13 -> 432
    //   422: aload_0
    //   423: aload_1
    //   424: invokevirtual 216	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   427: aload_0
    //   428: aconst_null
    //   429: putfield 220	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   432: aload_0
    //   433: getfield 103	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   436: aload_2
    //   437: iload_3
    //   438: invokevirtual 224	android/support/v7/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   441: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	AppCompatSpinner
    //   0	442	1	paramContext	Context
    //   0	442	2	paramAttributeSet	AttributeSet
    //   0	442	3	paramInt1	int
    //   0	442	4	paramInt2	int
    //   0	442	5	paramTheme	Resources.Theme
    //   73	116	6	i	int
    //   129	135	7	j	int
    //   155	183	8	localObject	Object
    //   204	1	9	localException1	java.lang.Exception
    //   216	14	9	localException2	java.lang.Exception
    //   28	376	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   157	166	204	java/lang/Exception
    //   170	179	204	java/lang/Exception
    //   137	149	209	finally
    //   137	149	216	java/lang/Exception
    //   157	166	247	finally
    //   170	179	247	finally
    //   225	235	247	finally
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int k = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i3 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i3 - i)));
    View localView = null;
    i = 0;
    while (j < i3)
    {
      int n = paramSpinnerAdapter.getItemViewType(j);
      int m = k;
      if (n != k)
      {
        localView = null;
        m = n;
      }
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i1, i2);
      i = Math.max(i, localView.getMeasuredWidth());
      j += 1;
      k = m;
    }
    j = i;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.mTempRect);
      j = i + (this.mTempRect.left + this.mTempRect.right);
    }
    return j;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getVerticalOffset();
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
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getBackground();
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
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null) {
      return localDropdownPopup.getHintText();
    }
    return super.getPrompt();
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DropdownPopup localDropdownPopup = this.mPopup;
    if ((localDropdownPopup != null) && (localDropdownPopup.isShowing())) {
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
    ForwardingListener localForwardingListener = this.mForwardingListener;
    if ((localForwardingListener != null) && (localForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null)
    {
      if (!localDropdownPopup.isShowing()) {
        this.mPopup.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet)
    {
      this.mTempAdapter = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null)
    {
      Context localContext2 = this.mPopupContext;
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setHorizontalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setVerticalOffset(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null)
    {
      this.mDropDownWidth = paramInt;
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setBackgroundDrawable(paramDrawable);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    DropdownPopup localDropdownPopup = this.mPopup;
    if (localDropdownPopup != null)
    {
      localDropdownPopup.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(@Nullable SpinnerAdapter paramSpinnerAdapter, @Nullable Resources.Theme paramTheme)
    {
      this.mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null) {
        if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
        {
          paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
        else if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter == null) {
        return 0;
      }
      return localSpinnerAdapter.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter == null) {
        return -1L;
      }
      return localSpinnerAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class DropdownPopup
    extends ListPopupWindow
  {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.DropdownPopup.this.mAdapter.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.DropdownPopup.this.dismiss();
        }
      });
    }
    
    void computeContentWidth()
    {
      Object localObject = getBackground();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
          i = AppCompatSpinner.this.mTempRect.right;
        } else {
          i = -AppCompatSpinner.this.mTempRect.left;
        }
      }
      else
      {
        localObject = AppCompatSpinner.this.mTempRect;
        AppCompatSpinner.this.mTempRect.right = 0;
        ((Rect)localObject).left = 0;
      }
      int n = AppCompatSpinner.this.getPaddingLeft();
      int i1 = AppCompatSpinner.this.getPaddingRight();
      int i2 = AppCompatSpinner.this.getWidth();
      if (AppCompatSpinner.this.mDropDownWidth == -2)
      {
        int k = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
        int m = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
        int j = k;
        if (k > m) {
          j = m;
        }
        setContentWidth(Math.max(j, i2 - n - i1));
      }
      else if (AppCompatSpinner.this.mDropDownWidth == -1)
      {
        setContentWidth(i2 - n - i1);
      }
      else
      {
        setContentWidth(AppCompatSpinner.this.mDropDownWidth);
      }
      if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
        i += i2 - i1 - getWidth();
      } else {
        i += n;
      }
      setHorizontalOffset(i);
    }
    
    public CharSequence getHintText()
    {
      return this.mHintText;
    }
    
    boolean isVisibleToUser(View paramView)
    {
      return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.mVisibleRect));
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.mAdapter = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }
    
    public void show()
    {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {
        return;
      }
      ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            AppCompatSpinner.DropdownPopup localDropdownPopup = AppCompatSpinner.DropdownPopup.this;
            if (!localDropdownPopup.isVisibleToUser(localDropdownPopup.this$0))
            {
              AppCompatSpinner.DropdownPopup.this.dismiss();
              return;
            }
            AppCompatSpinner.DropdownPopup.this.computeContentWidth();
            AppCompatSpinner.DropdownPopup.this.show();
          }
        };
        localViewTreeObserver.addOnGlobalLayoutListener(local2);
        setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (localViewTreeObserver != null) {
              localViewTreeObserver.removeGlobalOnLayoutListener(local2);
            }
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */