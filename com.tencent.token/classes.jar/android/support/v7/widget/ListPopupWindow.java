package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.token.fo;
import com.tencent.token.gn;
import com.tencent.token.hg.a;
import com.tencent.token.hg.j;
import com.tencent.token.io;
import com.tencent.token.jj;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements io
{
  private static Method a;
  private static Method b;
  private static Method c;
  private boolean A = false;
  private View B;
  private DataSetObserver C;
  private Drawable D;
  private AdapterView.OnItemSelectedListener E;
  private final d F = new d();
  private final c G = new c();
  private final a H = new a();
  private Runnable I;
  private final Rect J = new Rect();
  private Context d;
  public jj e;
  int f = -2;
  public int g;
  public int h = 0;
  int i = 2147483647;
  int j = 0;
  public View k;
  public AdapterView.OnItemClickListener l;
  final e m = new e();
  final Handler n;
  public Rect o;
  public boolean p;
  public PopupWindow q;
  private ListAdapter r;
  private int s = -2;
  private int t;
  private int u = 1002;
  private boolean v;
  private boolean w = true;
  private boolean x;
  private boolean y;
  private boolean z = false;
  
  static
  {
    try
    {
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          try
          {
            label51:
            c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3) {}
          localNoSuchMethodException1 = localNoSuchMethodException1;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label51;
      }
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, hg.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.n = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, hg.j.ListPopupWindow, paramInt1, paramInt2);
    this.g = localTypedArray.getDimensionPixelOffset(hg.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.t = localTypedArray.getDimensionPixelOffset(hg.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.t != 0) {
      this.v = true;
    }
    localTypedArray.recycle();
    this.q = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.q.setInputMethodMode(1);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean)
  {
    Method localMethod = b;
    if (localMethod != null) {}
    try
    {
      int i1 = ((Integer)localMethod.invoke(this.q, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    return this.q.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void a()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.B);
      }
    }
  }
  
  protected jj a(Context paramContext, boolean paramBoolean)
  {
    return new jj(paramContext, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    this.t = paramInt;
    this.v = true;
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.q.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.C;
    if (localDataSetObserver == null)
    {
      this.C = new b();
    }
    else
    {
      ListAdapter localListAdapter = this.r;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.r = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.C);
    }
    paramListAdapter = this.e;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(this.r);
    }
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.q.setOnDismissListener(paramOnDismissListener);
  }
  
  public void b()
  {
    Object localObject1 = this.e;
    boolean bool2 = true;
    Object localObject2;
    int i1;
    int i2;
    if (localObject1 == null)
    {
      localObject2 = this.d;
      this.I = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.k;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.b();
          }
        }
      };
      this.e = a((Context)localObject2, this.p ^ true);
      localObject1 = this.D;
      if (localObject1 != null) {
        this.e.setSelector((Drawable)localObject1);
      }
      this.e.setAdapter(this.r);
      this.e.setOnItemClickListener(this.l);
      this.e.setFocusable(true);
      this.e.setFocusableInTouchMode(true);
      this.e.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt != -1)
          {
            paramAnonymousAdapterView = ListPopupWindow.this.e;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousAdapterView.setListSelectionHidden(false);
            }
          }
        }
        
        public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      this.e.setOnScrollListener(this.G);
      localObject1 = this.E;
      if (localObject1 != null) {
        this.e.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject1);
      }
      localObject1 = this.e;
      View localView = this.B;
      if (localView != null)
      {
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.j)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.j);
          break;
        case 1: 
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          ((LinearLayout)localObject2).addView(localView);
          break;
        case 0: 
          ((LinearLayout)localObject2).addView(localView);
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
        }
        i1 = this.f;
        if (i1 >= 0)
        {
          i2 = -2147483648;
        }
        else
        {
          i1 = 0;
          i2 = 0;
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i2), 0);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        i1 = localView.getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject1).topMargin + ((LinearLayout.LayoutParams)localObject1).bottomMargin;
        localObject1 = localObject2;
      }
      else
      {
        i1 = 0;
      }
      this.q.setContentView((View)localObject1);
    }
    else
    {
      this.q.getContentView();
      localObject1 = this.B;
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i1 = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      }
      else
      {
        i1 = 0;
      }
    }
    localObject1 = this.q.getBackground();
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.J);
      i2 = this.J.top + this.J.bottom;
      i3 = i2;
      if (!this.v)
      {
        this.t = (-this.J.top);
        i3 = i2;
      }
    }
    else
    {
      this.J.setEmpty();
      i3 = 0;
    }
    if (this.q.getInputMethodMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i4 = a(this.k, this.t, bool1);
    if ((!this.z) && (this.s != -1))
    {
      i2 = this.f;
      switch (i2)
      {
      default: 
        i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        break;
      case -1: 
        i2 = View.MeasureSpec.makeMeasureSpec(this.d.getResources().getDisplayMetrics().widthPixels - (this.J.left + this.J.right), 1073741824);
        break;
      case -2: 
        i2 = View.MeasureSpec.makeMeasureSpec(this.d.getResources().getDisplayMetrics().widthPixels - (this.J.left + this.J.right), -2147483648);
      }
      i4 = this.e.a(i2, 0, -1, i4 - i1, -1);
      i2 = i1;
      if (i4 > 0) {
        i2 = i1 + (i3 + (this.e.getPaddingTop() + this.e.getPaddingBottom()));
      }
      i1 = i4 + i2;
    }
    else
    {
      i1 = i4 + i3;
    }
    boolean bool1 = j();
    gn.a(this.q, this.u);
    if (this.q.isShowing())
    {
      if (!fo.s(this.k)) {
        return;
      }
      i3 = this.f;
      if (i3 == -1)
      {
        i2 = -1;
      }
      else
      {
        i2 = i3;
        if (i3 == -2) {
          i2 = this.k.getWidth();
        }
      }
      i3 = this.s;
      if (i3 == -1)
      {
        if (!bool1) {
          i1 = -1;
        }
        if (bool1)
        {
          localObject1 = this.q;
          if (this.f == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          ((PopupWindow)localObject1).setWidth(i3);
          this.q.setHeight(0);
        }
        else
        {
          localObject1 = this.q;
          if (this.f == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          ((PopupWindow)localObject1).setWidth(i3);
          this.q.setHeight(-1);
        }
      }
      else if (i3 != -2)
      {
        i1 = i3;
      }
      localObject1 = this.q;
      if ((!this.A) && (!this.z)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((PopupWindow)localObject1).setOutsideTouchable(bool1);
      localObject1 = this.q;
      localObject2 = this.k;
      i3 = this.g;
      i4 = this.t;
      if (i2 < 0) {
        i2 = -1;
      }
      if (i1 < 0) {
        i1 = -1;
      }
      ((PopupWindow)localObject1).update((View)localObject2, i3, i4, i2, i1);
      return;
    }
    int i3 = this.f;
    if (i3 == -1)
    {
      i2 = -1;
    }
    else
    {
      i2 = i3;
      if (i3 == -2) {
        i2 = this.k.getWidth();
      }
    }
    i3 = this.s;
    if (i3 == -1) {
      i1 = -1;
    } else if (i3 != -2) {
      i1 = i3;
    }
    this.q.setWidth(i2);
    this.q.setHeight(i1);
    localObject1 = a;
    if (localObject1 != null) {}
    try
    {
      ((Method)localObject1).invoke(this.q, new Object[] { Boolean.TRUE });
    }
    catch (Exception localException1)
    {
      label1083:
      break label1083;
    }
    localObject1 = this.q;
    if ((!this.A) && (!this.z)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
    this.q.setTouchInterceptor(this.F);
    if (this.y) {
      gn.a(this.q, this.x);
    }
    localObject1 = c;
    if (localObject1 != null) {}
    try
    {
      ((Method)localObject1).invoke(this.q, new Object[] { this.o });
    }
    catch (Exception localException2)
    {
      label1182:
      break label1182;
    }
    gn.a(this.q, this.k, this.g, this.t, this.h);
    this.e.setSelection(-1);
    if ((!this.p) || (this.e.isInTouchMode())) {
      i();
    }
    if (!this.p) {
      this.n.post(this.H);
    }
  }
  
  public final void b(int paramInt)
  {
    Drawable localDrawable = this.q.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.J);
      this.f = (this.J.left + this.J.right + paramInt);
      return;
    }
    this.f = paramInt;
  }
  
  public final void c()
  {
    this.q.dismiss();
    a();
    this.q.setContentView(null);
    this.e = null;
    this.n.removeCallbacks(this.m);
  }
  
  public final boolean d()
  {
    return this.q.isShowing();
  }
  
  public final ListView e()
  {
    return this.e;
  }
  
  public final void f()
  {
    this.p = true;
    this.q.setFocusable(true);
  }
  
  public final int g()
  {
    if (!this.v) {
      return 0;
    }
    return this.t;
  }
  
  public final void h()
  {
    this.q.setInputMethodMode(2);
  }
  
  public final void i()
  {
    jj localjj = this.e;
    if (localjj != null)
    {
      localjj.setListSelectionHidden(true);
      localjj.requestLayout();
    }
  }
  
  public final boolean j()
  {
    return this.q.getInputMethodMode() == 2;
  }
  
  public final void k()
  {
    this.y = true;
    this.x = true;
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      ListPopupWindow.this.i();
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      if (ListPopupWindow.this.q.isShowing()) {
        ListPopupWindow.this.b();
      }
    }
    
    public final void onInvalidated()
    {
      ListPopupWindow.this.c();
    }
  }
  
  final class c
    implements AbsListView.OnScrollListener
  {
    c() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.j()) && (ListPopupWindow.this.q.getContentView() != null))
      {
        ListPopupWindow.this.n.removeCallbacks(ListPopupWindow.this.m);
        ListPopupWindow.this.m.run();
      }
    }
  }
  
  final class d
    implements View.OnTouchListener
  {
    d() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.q != null) && (ListPopupWindow.this.q.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.q.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.q.getHeight())) {
        ListPopupWindow.this.n.postDelayed(ListPopupWindow.this.m, 250L);
      } else if (i == 1) {
        ListPopupWindow.this.n.removeCallbacks(ListPopupWindow.this.m);
      }
      return false;
    }
  }
  
  final class e
    implements Runnable
  {
    e() {}
    
    public final void run()
    {
      if ((ListPopupWindow.this.e != null) && (fo.s(ListPopupWindow.this.e)) && (ListPopupWindow.this.e.getCount() > ListPopupWindow.this.e.getChildCount()) && (ListPopupWindow.this.e.getChildCount() <= ListPopupWindow.this.i))
      {
        ListPopupWindow.this.q.setInputMethodMode(2);
        ListPopupWindow.this.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */