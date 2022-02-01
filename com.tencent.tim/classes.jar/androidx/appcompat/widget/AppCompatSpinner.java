package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
  int mDropDownWidth;
  private ForwardingListener mForwardingListener;
  private SpinnerPopup mPopup;
  private final Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  final Rect mTempRect;
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, 2131035280, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035280);
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
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 76	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 78	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 80	android/graphics/Rect:<init>	()V
    //   15: putfield 82	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 87	b$a:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 93	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   28: astore 10
    //   30: aload_0
    //   31: new 95	androidx/appcompat/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 98	androidx/appcompat/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 100	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +191 -> 235
    //   47: aload_0
    //   48: new 102	androidx/appcompat/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 105	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 107	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: iload 4
    //   63: istore 7
    //   65: iload 4
    //   67: iconst_m1
    //   68: if_icmpne +63 -> 131
    //   71: aload_1
    //   72: aload_2
    //   73: getstatic 56	androidx/appcompat/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   76: iload_3
    //   77: iconst_0
    //   78: invokevirtual 112	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   81: astore 8
    //   83: iload 4
    //   85: istore 6
    //   87: aload 8
    //   89: astore 5
    //   91: aload 8
    //   93: iconst_0
    //   94: invokevirtual 118	android/content/res/TypedArray:hasValue	(I)Z
    //   97: ifeq +16 -> 113
    //   100: aload 8
    //   102: astore 5
    //   104: aload 8
    //   106: iconst_0
    //   107: iconst_0
    //   108: invokevirtual 122	android/content/res/TypedArray:getInt	(II)I
    //   111: istore 6
    //   113: iload 6
    //   115: istore 7
    //   117: aload 8
    //   119: ifnull +12 -> 131
    //   122: aload 8
    //   124: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   127: iload 6
    //   129: istore 7
    //   131: iload 7
    //   133: tableswitch	default:+23 -> 156, 0:+199->332, 1:+231->364
    //   157: lconst_1
    //   158: getstatic 128	b$a:Spinner_android_entries	I
    //   161: invokevirtual 132	androidx/appcompat/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   164: astore 5
    //   166: aload 5
    //   168: ifnull +27 -> 195
    //   171: new 134	android/widget/ArrayAdapter
    //   174: dup
    //   175: aload_1
    //   176: ldc 135
    //   178: aload 5
    //   180: invokespecial 138	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   183: astore_1
    //   184: aload_1
    //   185: ldc 139
    //   187: invokevirtual 143	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 147	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   195: aload 10
    //   197: invokevirtual 148	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   200: aload_0
    //   201: iconst_1
    //   202: putfield 150	androidx/appcompat/widget/AppCompatSpinner:mPopupSet	Z
    //   205: aload_0
    //   206: getfield 152	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   209: ifnull +16 -> 225
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 152	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   217: invokevirtual 147	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 152	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   225: aload_0
    //   226: getfield 100	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   229: aload_2
    //   230: iload_3
    //   231: invokevirtual 156	androidx/appcompat/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   234: return
    //   235: aload 10
    //   237: getstatic 159	b$a:Spinner_popupTheme	I
    //   240: iconst_0
    //   241: invokevirtual 162	androidx/appcompat/widget/TintTypedArray:getResourceId	(II)I
    //   244: istore 6
    //   246: iload 6
    //   248: ifeq +20 -> 268
    //   251: aload_0
    //   252: new 102	androidx/appcompat/view/ContextThemeWrapper
    //   255: dup
    //   256: aload_1
    //   257: iload 6
    //   259: invokespecial 164	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   262: putfield 107	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   265: goto -204 -> 61
    //   268: aload_0
    //   269: aload_1
    //   270: putfield 107	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   273: goto -212 -> 61
    //   276: astore 9
    //   278: aconst_null
    //   279: astore 8
    //   281: aload 8
    //   283: astore 5
    //   285: ldc 36
    //   287: ldc 166
    //   289: aload 9
    //   291: invokestatic 172	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   294: pop
    //   295: iload 4
    //   297: istore 7
    //   299: aload 8
    //   301: ifnull -170 -> 131
    //   304: aload 8
    //   306: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   309: iload 4
    //   311: istore 7
    //   313: goto -182 -> 131
    //   316: astore_1
    //   317: aconst_null
    //   318: astore 5
    //   320: aload 5
    //   322: ifnull +8 -> 330
    //   325: aload 5
    //   327: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   330: aload_1
    //   331: athrow
    //   332: aload_0
    //   333: new 8	androidx/appcompat/widget/AppCompatSpinner$DialogPopup
    //   336: dup
    //   337: aload_0
    //   338: invokespecial 175	androidx/appcompat/widget/AppCompatSpinner$DialogPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   341: putfield 177	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   344: aload_0
    //   345: getfield 177	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   348: aload 10
    //   350: getstatic 180	b$a:Spinner_android_prompt	I
    //   353: invokevirtual 184	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   356: invokeinterface 188 2 0
    //   361: goto -205 -> 156
    //   364: new 14	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup
    //   367: dup
    //   368: aload_0
    //   369: aload_0
    //   370: getfield 107	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   373: aload_2
    //   374: iload_3
    //   375: invokespecial 191	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   378: astore 5
    //   380: aload_0
    //   381: getfield 107	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   384: aload_2
    //   385: getstatic 87	b$a:Spinner	[I
    //   388: iload_3
    //   389: iconst_0
    //   390: invokestatic 93	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   393: astore 8
    //   395: aload_0
    //   396: aload 8
    //   398: getstatic 194	b$a:Spinner_android_dropDownWidth	I
    //   401: bipush 254
    //   403: invokevirtual 197	androidx/appcompat/widget/TintTypedArray:getLayoutDimension	(II)I
    //   406: putfield 199	androidx/appcompat/widget/AppCompatSpinner:mDropDownWidth	I
    //   409: aload 5
    //   411: aload 8
    //   413: getstatic 202	b$a:Spinner_android_popupBackground	I
    //   416: invokevirtual 206	androidx/appcompat/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   419: invokevirtual 210	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   422: aload 5
    //   424: aload 10
    //   426: getstatic 180	b$a:Spinner_android_prompt	I
    //   429: invokevirtual 184	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   432: invokevirtual 211	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   435: aload 8
    //   437: invokevirtual 148	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   440: aload_0
    //   441: aload 5
    //   443: putfield 177	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   446: aload_0
    //   447: new 213	androidx/appcompat/widget/AppCompatSpinner$1
    //   450: dup
    //   451: aload_0
    //   452: aload_0
    //   453: aload 5
    //   455: invokespecial 216	androidx/appcompat/widget/AppCompatSpinner$1:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$DropdownPopup;)V
    //   458: putfield 218	androidx/appcompat/widget/AppCompatSpinner:mForwardingListener	Landroidx/appcompat/widget/ForwardingListener;
    //   461: goto -305 -> 156
    //   464: astore_1
    //   465: goto -145 -> 320
    //   468: astore 9
    //   470: goto -189 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	AppCompatSpinner
    //   0	473	1	paramContext	Context
    //   0	473	2	paramAttributeSet	AttributeSet
    //   0	473	3	paramInt1	int
    //   0	473	4	paramInt2	int
    //   0	473	5	paramTheme	Resources.Theme
    //   85	173	6	i	int
    //   63	249	7	j	int
    //   81	355	8	localObject	Object
    //   276	14	9	localException1	java.lang.Exception
    //   468	1	9	localException2	java.lang.Exception
    //   28	397	10	localTintTypedArray	TintTypedArray
    // Exception table:
    //   from	to	target	type
    //   71	83	276	java/lang/Exception
    //   71	83	316	finally
    //   91	100	464	finally
    //   104	113	464	finally
    //   285	295	464	finally
    //   91	100	468	java/lang/Exception
    //   104	113	468	java/lang/Exception
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
  
  @VisibleForTesting
  final SpinnerPopup getInternalPopup()
  {
    return this.mPopup;
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
    return this.mPopupContext;
  }
  
  public CharSequence getPrompt()
  {
    if (this.mPopup != null) {
      return this.mPopup.getHintText();
    }
    return super.getPrompt();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.mShowDropdown)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new AppCompatSpinner.2(this));
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {}
    for (boolean bool = true;; bool = false)
    {
      localSavedState.mShowDropdown = bool;
      return localSavedState;
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
        showPopup();
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
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext.getTheme()));
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
    if (this.mPopup != null)
    {
      this.mPopup.setHorizontalOriginalOffset(paramInt);
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
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  void showPopup()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.mPopup.show(getTextDirection(), getTextAlignment());
      return;
    }
    this.mPopup.show(-1, -1);
  }
  
  @VisibleForTesting
  class DialogPopup
    implements DialogInterface.OnClickListener, AppCompatSpinner.SpinnerPopup
  {
    private ListAdapter mListAdapter;
    @VisibleForTesting
    AlertDialog mPopup;
    private CharSequence mPrompt;
    
    DialogPopup() {}
    
    public void dismiss()
    {
      if (this.mPopup != null)
      {
        this.mPopup.dismiss();
        this.mPopup = null;
      }
    }
    
    public Drawable getBackground()
    {
      return null;
    }
    
    public CharSequence getHintText()
    {
      return this.mPrompt;
    }
    
    public int getHorizontalOffset()
    {
      return 0;
    }
    
    public int getHorizontalOriginalOffset()
    {
      return 0;
    }
    
    public int getVerticalOffset()
    {
      return 0;
    }
    
    public boolean isShowing()
    {
      if (this.mPopup != null) {
        return this.mPopup.isShowing();
      }
      return false;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppCompatSpinner.this.setSelection(paramInt);
      if (AppCompatSpinner.this.getOnItemClickListener() != null) {
        AppCompatSpinner.this.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
      }
      dismiss();
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      this.mListAdapter = paramListAdapter;
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOriginalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mPrompt = paramCharSequence;
    }
    
    public void setVerticalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      if (this.mListAdapter == null) {
        return;
      }
      Object localObject = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
      if (this.mPrompt != null) {
        ((AlertDialog.Builder)localObject).setTitle(this.mPrompt);
      }
      this.mPopup = ((AlertDialog.Builder)localObject).setSingleChoiceItems(this.mListAdapter, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
      localObject = this.mPopup.getListView();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((ListView)localObject).setTextDirection(paramInt1);
        ((ListView)localObject).setTextAlignment(paramInt2);
      }
      this.mPopup.show();
    }
  }
  
  static class DropDownAdapter
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
      if (paramTheme != null)
      {
        if ((Build.VERSION.SDK_INT < 23) || (!(paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter))) {
          break label66;
        }
        paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      label66:
      do
      {
        do
        {
          return;
        } while (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter));
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      } while (paramSpinnerAdapter.getDropDownViewTheme() != null);
      paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
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
      if (this.mAdapter == null) {
        return 0;
      }
      return this.mAdapter.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.mAdapter == null) {
        return null;
      }
      return this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      if (this.mAdapter == null) {
        return null;
      }
      return this.mAdapter.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (this.mAdapter == null) {
        return -1L;
      }
      return this.mAdapter.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = getDropDownView(paramInt, paramView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return (this.mAdapter != null) && (this.mAdapter.hasStableIds());
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
      if (this.mAdapter != null) {
        this.mAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  @VisibleForTesting
  class DropdownPopup
    extends ListPopupWindow
    implements AppCompatSpinner.SpinnerPopup
  {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mOriginalHorizontalOffset;
    private final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AppCompatSpinner.DropdownPopup.1(this, AppCompatSpinner.this));
    }
    
    void computeContentWidth()
    {
      Object localObject = getBackground();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this))
        {
          i = AppCompatSpinner.this.mTempRect.right;
          m = AppCompatSpinner.this.getPaddingLeft();
          n = AppCompatSpinner.this.getPaddingRight();
          i1 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.this.mDropDownWidth != -2) {
            break label245;
          }
          j = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
          int k = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
          if (j <= k) {
            break label298;
          }
          j = k;
        }
      }
      label165:
      label298:
      for (;;)
      {
        setContentWidth(Math.max(j, i1 - m - n));
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {}
        for (i = i1 - n - getWidth() - getHorizontalOriginalOffset() + i;; i = getHorizontalOriginalOffset() + m + i)
        {
          setHorizontalOffset(i);
          return;
          i = -AppCompatSpinner.this.mTempRect.left;
          break;
          localObject = AppCompatSpinner.this.mTempRect;
          AppCompatSpinner.this.mTempRect.right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          label245:
          if (AppCompatSpinner.this.mDropDownWidth == -1)
          {
            setContentWidth(i1 - m - n);
            break label165;
          }
          setContentWidth(AppCompatSpinner.this.mDropDownWidth);
          break label165;
        }
      }
    }
    
    public CharSequence getHintText()
    {
      return this.mHintText;
    }
    
    public int getHorizontalOriginalOffset()
    {
      return this.mOriginalHorizontalOffset;
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
    
    public void setHorizontalOriginalOffset(int paramInt)
    {
      this.mOriginalHorizontalOffset = paramInt;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      Object localObject = getListView();
      ((ListView)localObject).setChoiceMode(1);
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((ListView)localObject).setTextDirection(paramInt1);
        ((ListView)localObject).setTextAlignment(paramInt2);
      }
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {}
      do
      {
        return;
        localObject = AppCompatSpinner.this.getViewTreeObserver();
      } while (localObject == null);
      AppCompatSpinner.DropdownPopup.2 local2 = new AppCompatSpinner.DropdownPopup.2(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
      setOnDismissListener(new AppCompatSpinner.DropdownPopup.3(this, local2));
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new AppCompatSpinner.SavedState.1();
    boolean mShowDropdown;
    
    SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.mShowDropdown = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.mShowDropdown) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
  
  @VisibleForTesting
  static abstract interface SpinnerPopup
  {
    public abstract void dismiss();
    
    public abstract Drawable getBackground();
    
    public abstract CharSequence getHintText();
    
    public abstract int getHorizontalOffset();
    
    public abstract int getHorizontalOriginalOffset();
    
    public abstract int getVerticalOffset();
    
    public abstract boolean isShowing();
    
    public abstract void setAdapter(ListAdapter paramListAdapter);
    
    public abstract void setBackgroundDrawable(Drawable paramDrawable);
    
    public abstract void setHorizontalOffset(int paramInt);
    
    public abstract void setHorizontalOriginalOffset(int paramInt);
    
    public abstract void setPromptText(CharSequence paramCharSequence);
    
    public abstract void setVerticalOffset(int paramInt);
    
    public abstract void show(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */