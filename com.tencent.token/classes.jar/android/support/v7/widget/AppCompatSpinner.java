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
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.tencent.token.ew;
import com.tencent.token.ex;
import com.tencent.token.gp.a;
import com.tencent.token.gr;
import com.tencent.token.hx;
import com.tencent.token.if;
import com.tencent.token.is;
import com.tencent.token.iu;
import com.tencent.token.jl;

public class AppCompatSpinner
  extends Spinner
  implements ew
{
  private static final int[] a = { 16843505 };
  private final if b;
  private final Context c;
  private iu d;
  private SpinnerAdapter e;
  private final boolean f;
  private b g;
  private int h;
  private final Rect i;
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gp.a.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  /* Error */
  private AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 61	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 63	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 65	android/graphics/Rect:<init>	()V
    //   15: putfield 67	android/support/v7/widget/AppCompatSpinner:i	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 72	com/tencent/token/gp$j:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 77	com/tencent/token/jf:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Lcom/tencent/token/jf;
    //   28: astore 8
    //   30: aload_0
    //   31: new 79	com/tencent/token/if
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 82	com/tencent/token/if:<init>	(Landroid/view/View;)V
    //   39: putfield 84	android/support/v7/widget/AppCompatSpinner:b	Lcom/tencent/token/if;
    //   42: aload 8
    //   44: getstatic 87	com/tencent/token/gp$j:Spinner_popupTheme	I
    //   47: iconst_0
    //   48: invokevirtual 90	com/tencent/token/jf:g	(II)I
    //   51: istore 5
    //   53: iload 5
    //   55: ifeq +18 -> 73
    //   58: new 92	com/tencent/token/gz
    //   61: dup
    //   62: aload_1
    //   63: iload 5
    //   65: invokespecial 95	com/tencent/token/gz:<init>	(Landroid/content/Context;I)V
    //   68: astore 7
    //   70: goto +20 -> 90
    //   73: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   76: bipush 23
    //   78: if_icmpge +9 -> 87
    //   81: aload_1
    //   82: astore 7
    //   84: goto +6 -> 90
    //   87: aconst_null
    //   88: astore 7
    //   90: aload_0
    //   91: aload 7
    //   93: putfield 102	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   96: aload_0
    //   97: getfield 102	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   100: ifnull +203 -> 303
    //   103: aload_1
    //   104: aload_2
    //   105: getstatic 41	android/support/v7/widget/AppCompatSpinner:a	[I
    //   108: iload_3
    //   109: iconst_0
    //   110: invokevirtual 108	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   113: astore 7
    //   115: iload 4
    //   117: istore 5
    //   119: aload 7
    //   121: iconst_0
    //   122: invokevirtual 114	android/content/res/TypedArray:hasValue	(I)Z
    //   125: ifeq +12 -> 137
    //   128: aload 7
    //   130: iconst_0
    //   131: iconst_0
    //   132: invokevirtual 117	android/content/res/TypedArray:getInt	(II)I
    //   135: istore 5
    //   137: iload 5
    //   139: istore 6
    //   141: aload 7
    //   143: ifnull +54 -> 197
    //   146: iload 5
    //   148: istore 4
    //   150: aload 7
    //   152: invokevirtual 120	android/content/res/TypedArray:recycle	()V
    //   155: iload 4
    //   157: istore 6
    //   159: goto +38 -> 197
    //   162: astore_1
    //   163: goto +7 -> 170
    //   166: astore_1
    //   167: aconst_null
    //   168: astore 7
    //   170: aload 7
    //   172: ifnull +8 -> 180
    //   175: aload 7
    //   177: invokevirtual 120	android/content/res/TypedArray:recycle	()V
    //   180: aload_1
    //   181: athrow
    //   182: aconst_null
    //   183: astore 7
    //   185: iload 4
    //   187: istore 6
    //   189: aload 7
    //   191: ifnull +6 -> 197
    //   194: goto -44 -> 150
    //   197: iload 6
    //   199: iconst_1
    //   200: if_icmpne +103 -> 303
    //   203: new 13	android/support/v7/widget/AppCompatSpinner$b
    //   206: dup
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 102	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   212: aload_2
    //   213: iload_3
    //   214: invokespecial 123	android/support/v7/widget/AppCompatSpinner$b:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   217: astore 7
    //   219: aload_0
    //   220: getfield 102	android/support/v7/widget/AppCompatSpinner:c	Landroid/content/Context;
    //   223: aload_2
    //   224: getstatic 72	com/tencent/token/gp$j:Spinner	[I
    //   227: iload_3
    //   228: iconst_0
    //   229: invokestatic 77	com/tencent/token/jf:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Lcom/tencent/token/jf;
    //   232: astore 9
    //   234: aload_0
    //   235: aload 9
    //   237: getstatic 126	com/tencent/token/gp$j:Spinner_android_dropDownWidth	I
    //   240: bipush 254
    //   242: invokevirtual 128	com/tencent/token/jf:f	(II)I
    //   245: putfield 130	android/support/v7/widget/AppCompatSpinner:h	I
    //   248: aload 7
    //   250: aload 9
    //   252: getstatic 133	com/tencent/token/gp$j:Spinner_android_popupBackground	I
    //   255: invokevirtual 136	com/tencent/token/jf:a	(I)Landroid/graphics/drawable/Drawable;
    //   258: invokevirtual 139	android/support/v7/widget/AppCompatSpinner$b:a	(Landroid/graphics/drawable/Drawable;)V
    //   261: aload 7
    //   263: aload 8
    //   265: getstatic 142	com/tencent/token/gp$j:Spinner_android_prompt	I
    //   268: invokevirtual 145	com/tencent/token/jf:d	(I)Ljava/lang/String;
    //   271: putfield 148	android/support/v7/widget/AppCompatSpinner$b:a	Ljava/lang/CharSequence;
    //   274: aload 9
    //   276: getfield 151	com/tencent/token/jf:a	Landroid/content/res/TypedArray;
    //   279: invokevirtual 120	android/content/res/TypedArray:recycle	()V
    //   282: aload_0
    //   283: aload 7
    //   285: putfield 153	android/support/v7/widget/AppCompatSpinner:g	Landroid/support/v7/widget/AppCompatSpinner$b;
    //   288: aload_0
    //   289: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   292: dup
    //   293: aload_0
    //   294: aload_0
    //   295: aload 7
    //   297: invokespecial 156	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$b;)V
    //   300: putfield 158	android/support/v7/widget/AppCompatSpinner:d	Lcom/tencent/token/iu;
    //   303: getstatic 161	com/tencent/token/gp$j:Spinner_android_entries	I
    //   306: istore 4
    //   308: aload 8
    //   310: getfield 151	com/tencent/token/jf:a	Landroid/content/res/TypedArray;
    //   313: iload 4
    //   315: invokevirtual 165	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   318: astore 7
    //   320: aload 7
    //   322: ifnull +28 -> 350
    //   325: new 167	android/widget/ArrayAdapter
    //   328: dup
    //   329: aload_1
    //   330: ldc 168
    //   332: aload 7
    //   334: invokespecial 171	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   337: astore_1
    //   338: aload_1
    //   339: getstatic 176	com/tencent/token/gp$g:support_simple_spinner_dropdown_item	I
    //   342: invokevirtual 180	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual 184	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   350: aload 8
    //   352: getfield 151	com/tencent/token/jf:a	Landroid/content/res/TypedArray;
    //   355: invokevirtual 120	android/content/res/TypedArray:recycle	()V
    //   358: aload_0
    //   359: iconst_1
    //   360: putfield 186	android/support/v7/widget/AppCompatSpinner:f	Z
    //   363: aload_0
    //   364: getfield 188	android/support/v7/widget/AppCompatSpinner:e	Landroid/widget/SpinnerAdapter;
    //   367: astore_1
    //   368: aload_1
    //   369: ifnull +13 -> 382
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual 184	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   377: aload_0
    //   378: aconst_null
    //   379: putfield 188	android/support/v7/widget/AppCompatSpinner:e	Landroid/widget/SpinnerAdapter;
    //   382: aload_0
    //   383: getfield 84	android/support/v7/widget/AppCompatSpinner:b	Lcom/tencent/token/if;
    //   386: aload_2
    //   387: iload_3
    //   388: invokevirtual 191	com/tencent/token/if:a	(Landroid/util/AttributeSet;I)V
    //   391: return
    //   392: astore 7
    //   394: goto -212 -> 182
    //   397: astore 9
    //   399: goto -214 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	AppCompatSpinner
    //   0	402	1	paramContext	Context
    //   0	402	2	paramAttributeSet	AttributeSet
    //   0	402	3	paramInt1	int
    //   0	402	4	paramInt2	int
    //   51	96	5	j	int
    //   139	62	6	k	int
    //   68	265	7	localObject	Object
    //   392	1	7	localException1	java.lang.Exception
    //   28	323	8	localjf1	com.tencent.token.jf
    //   232	43	9	localjf2	com.tencent.token.jf
    //   397	1	9	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   119	137	162	finally
    //   103	115	166	finally
    //   103	115	392	java/lang/Exception
    //   119	137	397	java/lang/Exception
  }
  
  final int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int m = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int j = Math.max(0, getSelectedItemPosition());
    int i4 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
    int k = Math.max(0, j - (15 - (i4 - j)));
    View localView = null;
    j = 0;
    while (k < i4)
    {
      int i1 = paramSpinnerAdapter.getItemViewType(k);
      int n = m;
      if (i1 != m)
      {
        localView = null;
        n = i1;
      }
      localView = paramSpinnerAdapter.getView(k, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i2, i3);
      j = Math.max(j, localView.getMeasuredWidth());
      k += 1;
      m = n;
    }
    k = j;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.i);
      k = j + (this.i.left + this.i.right);
    }
    return k;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if localif = this.b;
    if (localif != null) {
      localif.d();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    b localb = this.g;
    if (localb != null) {
      return localb.g;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    b localb = this.g;
    if (localb != null) {
      return localb.g();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.g != null) {
      return this.h;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    b localb = this.g;
    if (localb != null) {
      return localb.q.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.g != null) {
      return this.c;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    b localb = this.g;
    if (localb != null) {
      return localb.a;
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if localif = this.b;
    if (localif != null) {
      return localif.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if localif = this.b;
    if (localif != null) {
      return localif.c();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b localb = this.g;
    if ((localb != null) && (localb.q.isShowing())) {
      this.g.c();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.g != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    iu localiu = this.d;
    if ((localiu != null) && (localiu.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    b localb = this.g;
    if (localb != null)
    {
      if (!localb.q.isShowing()) {
        this.g.b();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.f)
    {
      this.e = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.g != null)
    {
      Context localContext2 = this.c;
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getContext();
      }
      this.g.a(new a(paramSpinnerAdapter, localContext1.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if localif = this.b;
    if (localif != null) {
      localif.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    b localb = this.g;
    if (localb != null)
    {
      localb.g = paramInt;
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    b localb = this.g;
    if (localb != null)
    {
      localb.a(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.g != null)
    {
      this.h = paramInt;
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    b localb = this.g;
    if (localb != null)
    {
      localb.a(paramDrawable);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(gr.b(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    b localb = this.g;
    if (localb != null)
    {
      localb.a = paramCharSequence;
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if localif = this.b;
    if (localif != null) {
      localif.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if localif = this.b;
    if (localif != null) {
      localif.a(paramMode);
    }
  }
  
  static final class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter a;
    private ListAdapter b;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.a = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.b = ((ListAdapter)paramSpinnerAdapter);
      }
      if ((paramTheme != null) && (Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
    }
    
    public final boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public final int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return 0;
      }
      return localSpinnerAdapter.getCount();
    }
    
    public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final Object getItem(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return null;
      }
      return localSpinnerAdapter.getItem(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter == null) {
        return -1L;
      }
      return localSpinnerAdapter.getItemId(paramInt);
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
    
    public final boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
    }
    
    public final boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.a;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  final class b
    extends ListPopupWindow
  {
    CharSequence a;
    ListAdapter b;
    final Rect c = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      this.k = AppCompatSpinner.this;
      f();
      this.j = 0;
      this.l = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.b.this.b.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.b.this.c();
        }
      };
    }
    
    final void a()
    {
      Object localObject = this.q.getBackground();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.b(AppCompatSpinner.this));
        if (jl.a(AppCompatSpinner.this)) {
          i = AppCompatSpinner.b(AppCompatSpinner.this).right;
        } else {
          i = -AppCompatSpinner.b(AppCompatSpinner.this).left;
        }
      }
      else
      {
        localObject = AppCompatSpinner.b(AppCompatSpinner.this);
        AppCompatSpinner.b(AppCompatSpinner.this).right = 0;
        ((Rect)localObject).left = 0;
      }
      int n = AppCompatSpinner.this.getPaddingLeft();
      int i1 = AppCompatSpinner.this.getPaddingRight();
      int i2 = AppCompatSpinner.this.getWidth();
      if (AppCompatSpinner.c(AppCompatSpinner.this) == -2)
      {
        int k = AppCompatSpinner.this.a((SpinnerAdapter)this.b, this.q.getBackground());
        int m = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.b(AppCompatSpinner.this).left - AppCompatSpinner.b(AppCompatSpinner.this).right;
        int j = k;
        if (k > m) {
          j = m;
        }
        b(Math.max(j, i2 - n - i1));
      }
      else if (AppCompatSpinner.c(AppCompatSpinner.this) == -1)
      {
        b(i2 - n - i1);
      }
      else
      {
        b(AppCompatSpinner.c(AppCompatSpinner.this));
      }
      if (jl.a(AppCompatSpinner.this)) {
        i += i2 - i1 - this.f;
      } else {
        i += n;
      }
      this.g = i;
    }
    
    public final void a(ListAdapter paramListAdapter)
    {
      super.a(paramListAdapter);
      this.b = paramListAdapter;
    }
    
    public final void b()
    {
      boolean bool = this.q.isShowing();
      a();
      h();
      super.b();
      this.e.setChoiceMode(1);
      int i = AppCompatSpinner.this.getSelectedItemPosition();
      Object localObject = this.e;
      if ((this.q.isShowing()) && (localObject != null))
      {
        ((is)localObject).setListSelectionHidden(false);
        ((is)localObject).setSelection(i);
        if (((is)localObject).getChoiceMode() != 0) {
          ((is)localObject).setItemChecked(i, true);
        }
      }
      if (bool) {
        return;
      }
      localObject = AppCompatSpinner.this.getViewTreeObserver();
      if (localObject != null)
      {
        final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppCompatSpinner.b localb = AppCompatSpinner.b.this;
            AppCompatSpinner localAppCompatSpinner = localb.d;
            int i;
            if ((ex.s(localAppCompatSpinner)) && (localAppCompatSpinner.getGlobalVisibleRect(localb.c))) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0)
            {
              AppCompatSpinner.b.this.c();
              return;
            }
            AppCompatSpinner.b.this.a();
            AppCompatSpinner.b.a(AppCompatSpinner.b.this);
          }
        };
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
        a(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
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