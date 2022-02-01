package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.token.cb.a;
import com.tencent.token.cb.b;
import com.tencent.token.cb.c;
import com.tencent.token.dj;
import com.tencent.token.dy;
import com.tencent.token.ev.a;
import com.tencent.token.ev.c;
import com.tencent.token.ex;
import com.tencent.token.fb;
import com.tencent.token.fj;
import com.tencent.token.fk;
import com.tencent.token.fl;
import com.tencent.token.fo;
import com.tencent.token.fv;
import com.tencent.token.gj;
import com.tencent.token.gt;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CoordinatorLayout
  extends ViewGroup
  implements fj
{
  static final String a;
  static final Class<?>[] b = { Context.class, AttributeSet.class };
  static final ThreadLocal<Map<String, Constructor<Behavior>>> c = new ThreadLocal();
  static final Comparator<View> d;
  private static final ev.a<Rect> h = new ev.c();
  fv e;
  boolean f;
  ViewGroup.OnHierarchyChangeListener g;
  private final List<View> i = new ArrayList();
  private final gj<View> j = new gj();
  private final List<View> k = new ArrayList();
  private final List<View> l = new ArrayList();
  private final int[] m = new int[2];
  private boolean n;
  private boolean o;
  private int[] p;
  private View q;
  private View r;
  private e s;
  private boolean t;
  private Drawable u;
  private fl v;
  private final fk w = new fk(this);
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    a = (String)localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      d = new f();
    } else {
      d = null;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, cb.a.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i1 = 0;
    if (paramInt == 0) {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, cb.c.CoordinatorLayout, 0, cb.b.Widget_Support_CoordinatorLayout);
    } else {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, cb.c.CoordinatorLayout, paramInt, 0);
    }
    paramInt = paramAttributeSet.getResourceId(cb.c.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      this.p = paramContext.getIntArray(paramInt);
      float f1 = paramContext.getDisplayMetrics().density;
      int i2 = this.p.length;
      paramInt = i1;
      while (paramInt < i2)
      {
        paramContext = this.p;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f1));
        paramInt += 1;
      }
    }
    this.u = paramAttributeSet.getDrawable(cb.c.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    d();
    super.setOnHierarchyChangeListener(new c());
  }
  
  private static Rect a()
  {
    Rect localRect2 = (Rect)h.a();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (paramString.startsWith("."))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramString;
      if (paramString.indexOf('.') < 0)
      {
        localObject1 = paramString;
        if (!TextUtils.isEmpty(a))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(a);
          ((StringBuilder)localObject1).append('.');
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    try
    {
      Object localObject2 = (Map)c.get();
      paramString = (String)localObject2;
      if (localObject2 == null)
      {
        paramString = new HashMap();
        c.set(paramString);
      }
      Constructor localConstructor = (Constructor)paramString.get(localObject1);
      localObject2 = localConstructor;
      if (localConstructor == null)
      {
        localObject2 = paramContext.getClassLoader().loadClass((String)localObject1).getConstructor(b);
        ((Constructor)localObject2).setAccessible(true);
        paramString.put(localObject1, localObject2);
      }
      paramContext = (Behavior)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(localObject1)), paramContext);
    }
  }
  
  private static d a(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    if (!locald.b)
    {
      if ((paramView instanceof a))
      {
        locald.a(((a)paramView).a());
        locald.b = true;
        return locald;
      }
      localObject = paramView.getClass();
      b localb;
      for (paramView = null; localObject != null; paramView = localb)
      {
        localb = (b)((Class)localObject).getAnnotation(b.class);
        paramView = localb;
        if (localb != null) {
          break;
        }
        localObject = ((Class)localObject).getSuperclass();
      }
      if (paramView == null) {}
    }
    try
    {
      locald.a((Behavior)paramView.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    catch (Exception localException)
    {
      label113:
      break label113;
    }
    Object localObject = new StringBuilder("Default behavior class ");
    ((StringBuilder)localObject).append(paramView.a().getName());
    ((StringBuilder)localObject).append(" could not be instantiated. Did you forget a default constructor?");
    locald.b = true;
    return locald;
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, d paramd, int paramInt2, int paramInt3)
  {
    int i1 = fb.a(h(paramd.c), paramInt1);
    paramInt1 = fb.a(f(paramd.d), paramInt1);
    int i4 = i1 & 0x7;
    int i3 = i1 & 0x70;
    int i2 = paramInt1 & 0x7;
    i1 = paramInt1 & 0x70;
    if (i2 != 1)
    {
      if (i2 != 5) {
        paramInt1 = paramRect1.left;
      } else {
        paramInt1 = paramRect1.right;
      }
    }
    else {
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    }
    if (i1 != 16)
    {
      if (i1 != 80) {
        i1 = paramRect1.top;
      } else {
        i1 = paramRect1.bottom;
      }
    }
    else {
      i1 = paramRect1.top + paramRect1.height() / 2;
    }
    if (i4 != 1)
    {
      i2 = paramInt1;
      if (i4 != 5) {
        i2 = paramInt1 - paramInt2;
      }
    }
    else
    {
      i2 = paramInt1 - paramInt2 / 2;
    }
    if (i3 != 16)
    {
      paramInt1 = i1;
      if (i3 != 80) {
        paramInt1 = i1 - paramInt3;
      }
    }
    else
    {
      paramInt1 = i1 - paramInt3 / 2;
    }
    paramRect2.set(i2, paramInt1, paramInt2 + i2, paramInt3 + paramInt1);
  }
  
  private static void a(Rect paramRect)
  {
    paramRect.setEmpty();
    h.a(paramRect);
  }
  
  private void a(d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i2 = getWidth();
    int i1 = getHeight();
    i2 = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, i2 - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i1 = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i1 - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(i2, i1, paramInt1 + i2, paramInt2 + i1);
  }
  
  private void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean)
      {
        gt.a(this, paramView, paramRect);
        return;
      }
      paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      return;
    }
    paramRect.setEmpty();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i4 = paramMotionEvent.getActionMasked();
    List localList = this.k;
    localList.clear();
    boolean bool1 = isChildrenDrawingOrderEnabled();
    int i3 = getChildCount();
    int i1 = i3 - 1;
    while (i1 >= 0)
    {
      if (bool1) {
        i2 = getChildDrawingOrder(i3, i1);
      } else {
        i2 = i1;
      }
      localList.add(getChildAt(i2));
      i1 -= 1;
    }
    paramMotionEvent = d;
    if (paramMotionEvent != null) {
      Collections.sort(localList, paramMotionEvent);
    }
    int i5 = localList.size();
    paramMotionEvent = null;
    int i2 = 0;
    i1 = 0;
    while (i2 < i5)
    {
      Object localObject = (d)((View)localList.get(i2)).getLayoutParams();
      Behavior localBehavior = ((d)localObject).a;
      if ((i1 != 0) && (i4 != 0))
      {
        i3 = i1;
        localObject = paramMotionEvent;
        if (localBehavior != null)
        {
          i3 = i1;
          localObject = paramMotionEvent;
          if (paramMotionEvent == null)
          {
            long l1 = SystemClock.uptimeMillis();
            localObject = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            i3 = i1;
          }
        }
      }
      else
      {
        if (((d)localObject).a == null) {
          ((d)localObject).m = false;
        }
        boolean bool2 = ((d)localObject).m;
        bool1 = ((d)localObject).m;
        i1 = 1;
        if (bool1)
        {
          bool1 = true;
        }
        else
        {
          bool1 = ((d)localObject).m | false;
          ((d)localObject).m = bool1;
        }
        if ((!bool1) || (bool2)) {
          i1 = 0;
        }
        if ((bool1) && (i1 == 0)) {
          break;
        }
        localObject = paramMotionEvent;
        i3 = i1;
      }
      i2 += 1;
      i1 = i3;
      paramMotionEvent = (MotionEvent)localObject;
    }
    localList.clear();
    return false;
  }
  
  private void b()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((d)getChildAt(i1).getLayoutParams()).a != null)
      {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0).recycle();
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < i2)
    {
      ((d)getChildAt(i1).getLayoutParams()).m = false;
      i1 += 1;
    }
    this.q = null;
    this.n = false;
  }
  
  private static void b(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.i != paramInt)
    {
      fo.c(paramView, paramInt - locald.i);
      locald.i = paramInt;
    }
  }
  
  private void c()
  {
    this.i.clear();
    Object localObject1 = this.j;
    int i2 = ((gj)localObject1).b.size();
    int i1 = 0;
    Object localObject2;
    while (i1 < i2)
    {
      localObject2 = (ArrayList)((gj)localObject1).b.c(i1);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((gj)localObject1).a.a(localObject2);
      }
      i1 += 1;
    }
    ((gj)localObject1).b.clear();
    int i4 = getChildCount();
    i2 = 0;
    while (i2 < i4)
    {
      View localView1 = getChildAt(i2);
      d locald = a(localView1);
      if (locald.f == -1)
      {
        locald.l = null;
        locald.k = null;
      }
      else if (locald.k != null)
      {
        if (locald.k.getId() != locald.f)
        {
          i1 = 0;
        }
        else
        {
          localObject2 = locald.k;
          localObject1 = locald.k.getParent();
          while (localObject1 != this) {
            if ((localObject1 != null) && (localObject1 != localView1))
            {
              if ((localObject1 instanceof View)) {
                localObject2 = (View)localObject1;
              }
              localObject1 = ((ViewParent)localObject1).getParent();
            }
            else
            {
              locald.l = null;
              locald.k = null;
              i1 = 0;
              break label255;
            }
          }
          locald.l = ((View)localObject2);
          i1 = 1;
        }
        label255:
        if (i1 != 0) {}
      }
      else
      {
        locald.k = findViewById(locald.f);
        if (locald.k != null)
        {
          if (locald.k == this)
          {
            if (isInEditMode())
            {
              locald.l = null;
              locald.k = null;
            }
            else
            {
              throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
          }
          else
          {
            localObject2 = locald.k;
            for (localObject1 = locald.k.getParent(); (localObject1 != this) && (localObject1 != null); localObject1 = ((ViewParent)localObject1).getParent())
            {
              if (localObject1 == localView1)
              {
                if (isInEditMode())
                {
                  locald.l = null;
                  locald.k = null;
                  break label447;
                }
                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
              }
              if ((localObject1 instanceof View)) {
                localObject2 = (View)localObject1;
              }
            }
            locald.l = ((View)localObject2);
          }
        }
        else
        {
          if (!isInEditMode()) {
            break label721;
          }
          locald.l = null;
          locald.k = null;
        }
      }
      label447:
      this.j.a(localView1);
      i1 = 0;
      while (i1 < i4)
      {
        if (i1 != i2)
        {
          View localView2 = getChildAt(i1);
          if (localView2 != locald.l)
          {
            i3 = fo.c(this);
            int i5 = fb.a(((d)localView2.getLayoutParams()).g, i3);
            if ((i5 != 0) && ((fb.a(locald.h, i3) & i5) == i5)) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            if (i3 == 0)
            {
              localObject1 = locald.a;
              i3 = 0;
              break label555;
            }
          }
          int i3 = 1;
          label555:
          if (i3 != 0)
          {
            if (!this.j.b.containsKey(localView2)) {
              this.j.a(localView2);
            }
            gj localgj = this.j;
            if ((localgj.b.containsKey(localView2)) && (localgj.b.containsKey(localView1)))
            {
              localObject2 = (ArrayList)localgj.b.get(localView2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = (ArrayList)localgj.a.a();
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = new ArrayList();
                }
                localgj.b.put(localView2, localObject1);
              }
              ((ArrayList)localObject1).add(localView1);
            }
            else
            {
              throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
            }
          }
        }
        i1 += 1;
      }
      i2 += 1;
      continue;
      label721:
      localObject1 = new StringBuilder("Could not find CoordinatorLayout descendant view with id ");
      ((StringBuilder)localObject1).append(getResources().getResourceName(locald.f));
      ((StringBuilder)localObject1).append(" to anchor view ");
      ((StringBuilder)localObject1).append(localView1);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    this.i.addAll(this.j.a());
    Collections.reverse(this.i);
  }
  
  private static void c(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.j != paramInt)
    {
      fo.b(paramView, paramInt - locald.j);
      locald.j = paramInt;
    }
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (fo.k(this))
    {
      if (this.v == null) {
        this.v = new fl()
        {
          public final fv a(View paramAnonymousView, fv paramAnonymousfv)
          {
            CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
            paramAnonymousView = localCoordinatorLayout.e;
            int j = Build.VERSION.SDK_INT;
            int i = 0;
            boolean bool2 = true;
            boolean bool1;
            if (j >= 19) {
              bool1 = Objects.equals(paramAnonymousView, paramAnonymousfv);
            } else if ((paramAnonymousView != paramAnonymousfv) && ((paramAnonymousView == null) || (!paramAnonymousView.equals(paramAnonymousfv)))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            paramAnonymousView = paramAnonymousfv;
            if (!bool1)
            {
              localCoordinatorLayout.e = paramAnonymousfv;
              if ((paramAnonymousfv != null) && (paramAnonymousfv.b() > 0)) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              localCoordinatorLayout.f = bool1;
              if ((!localCoordinatorLayout.f) && (localCoordinatorLayout.getBackground() == null)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
              localCoordinatorLayout.setWillNotDraw(bool1);
              paramAnonymousView = paramAnonymousfv;
              if (!paramAnonymousfv.e())
              {
                j = localCoordinatorLayout.getChildCount();
                for (;;)
                {
                  paramAnonymousView = paramAnonymousfv;
                  if (i >= j) {
                    break;
                  }
                  View localView = localCoordinatorLayout.getChildAt(i);
                  paramAnonymousView = paramAnonymousfv;
                  if (fo.k(localView))
                  {
                    paramAnonymousView = paramAnonymousfv;
                    if (((CoordinatorLayout.d)localView.getLayoutParams()).a != null)
                    {
                      paramAnonymousfv = CoordinatorLayout.Behavior.a(paramAnonymousfv);
                      paramAnonymousView = paramAnonymousfv;
                      if (paramAnonymousfv.e()) {
                        break;
                      }
                      paramAnonymousView = paramAnonymousfv;
                    }
                  }
                  i += 1;
                  paramAnonymousfv = paramAnonymousView;
                }
              }
              localCoordinatorLayout.requestLayout();
            }
            return paramAnonymousView;
          }
        };
      }
      fo.a(this, this.v);
      setSystemUiVisibility(1280);
      return;
    }
    fo.a(this, null);
  }
  
  private int e(int paramInt)
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      localObject = new StringBuilder("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      return 0;
    }
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      return localObject[paramInt];
    }
    localObject = new StringBuilder("Keyline index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of range for ");
    ((StringBuilder)localObject).append(this);
    return 0;
  }
  
  private static int f(int paramInt)
  {
    int i1 = paramInt;
    if ((paramInt & 0x7) == 0) {
      i1 = paramInt | 0x800003;
    }
    paramInt = i1;
    if ((i1 & 0x70) == 0) {
      paramInt = i1 | 0x30;
    }
    return paramInt;
  }
  
  private static int g(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 8388661;
    }
    return i1;
  }
  
  private static int h(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 17;
    }
    return i1;
  }
  
  final void a(int paramInt)
  {
    int i6 = fo.c(this);
    int i1 = this.i.size();
    Rect localRect1 = a();
    Rect localRect2 = a();
    Rect localRect3 = a();
    int i5;
    for (int i2 = 0; i2 < i1; i2 = i5 + 1)
    {
      View localView = (View)this.i.get(i2);
      d locald = (d)localView.getLayoutParams();
      if ((paramInt == 0) && (localView.getVisibility() == 8))
      {
        i5 = i2;
      }
      else
      {
        int i3 = 0;
        Object localObject;
        Rect localRect4;
        int i7;
        while (i3 < i2)
        {
          localObject = (View)this.i.get(i3);
          if (locald.l == localObject)
          {
            localObject = (d)localView.getLayoutParams();
            if (((d)localObject).k != null)
            {
              localRect4 = a();
              Rect localRect5 = a();
              Rect localRect6 = a();
              gt.a(this, ((d)localObject).k, localRect4);
              a(localView, false, localRect5);
              i4 = localView.getMeasuredWidth();
              i5 = localView.getMeasuredHeight();
              a(i6, localRect4, localRect6, (d)localObject, i4, i5);
              if (localRect6.left == localRect5.left)
              {
                i7 = localRect6.top;
                i7 = localRect5.top;
              }
              a((d)localObject, localRect6, i4, i5);
              i4 = localRect6.left - localRect5.left;
              i5 = localRect6.top - localRect5.top;
              if (i4 != 0) {
                fo.c(localView, i4);
              }
              if (i5 != 0) {
                fo.b(localView, i5);
              }
              a(localRect4);
              a(localRect5);
              a(localRect6);
            }
            else {}
          }
          i3 += 1;
        }
        i3 = i2;
        a(localView, true, localRect2);
        if ((locald.g != 0) && (!localRect2.isEmpty()))
        {
          i2 = fb.a(locald.g, i6);
          i4 = i2 & 0x70;
          if (i4 != 48)
          {
            if (i4 == 80) {
              localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
            }
          }
          else {
            localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          }
          i2 &= 0x7;
          if (i2 != 3)
          {
            if (i2 == 5) {
              localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
            }
          }
          else {
            localRect1.left = Math.max(localRect1.left, localRect2.right);
          }
        }
        if ((locald.h != 0) && (localView.getVisibility() == 0)) {
          if (fo.q(localView))
          {
            if ((localView.getWidth() > 0) && (localView.getHeight() > 0))
            {
              locald = (d)localView.getLayoutParams();
              localObject = a();
              localRect4 = a();
              localRect4.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
              ((Rect)localObject).set(localRect4);
              a(localRect4);
              if (!((Rect)localObject).isEmpty())
              {
                i5 = fb.a(locald.h, i6);
                if ((i5 & 0x30) == 48)
                {
                  i2 = ((Rect)localObject).top - locald.topMargin - locald.j;
                  if (i2 < localRect1.top)
                  {
                    c(localView, localRect1.top - i2);
                    i2 = 1;
                    break label666;
                  }
                }
                i2 = 0;
                label666:
                i4 = i2;
                if ((i5 & 0x50) == 80)
                {
                  i7 = getHeight() - ((Rect)localObject).bottom - locald.bottomMargin + locald.j;
                  i4 = i2;
                  if (i7 < localRect1.bottom)
                  {
                    c(localView, i7 - localRect1.bottom);
                    i4 = 1;
                  }
                }
                if (i4 == 0) {
                  c(localView, 0);
                }
                if ((i5 & 0x3) == 3)
                {
                  i2 = ((Rect)localObject).left - locald.leftMargin - locald.i;
                  if (i2 < localRect1.left)
                  {
                    b(localView, localRect1.left - i2);
                    i2 = 1;
                    break label797;
                  }
                }
                i2 = 0;
                label797:
                if ((i5 & 0x5) == 5)
                {
                  i4 = getWidth() - ((Rect)localObject).right - locald.rightMargin + locald.i;
                  if (i4 < localRect1.right)
                  {
                    b(localView, i4 - localRect1.right);
                    i2 = 1;
                  }
                }
                if (i2 == 0) {
                  b(localView, 0);
                } else {}
              }
              a((Rect)localObject);
            }
          }
          else {}
        }
        if (paramInt != 2)
        {
          localRect3.set(((d)localView.getLayoutParams()).o);
          if (!localRect3.equals(localRect2))
          {
            ((d)localView.getLayoutParams()).o.set(localRect2);
          }
          else
          {
            i5 = i3;
            continue;
          }
        }
        int i4 = i3 + 1;
        i2 = i1;
        for (;;)
        {
          i1 = i2;
          i5 = i3;
          if (i4 >= i2) {
            break;
          }
          ((View)this.i.get(i4)).getLayoutParams();
          i4 += 1;
        }
      }
    }
    a(localRect1);
    a(localRect2);
    a(localRect3);
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i8 = getChildCount();
    int i3 = 0;
    int i6 = 0;
    int i2 = 0;
    int i4;
    for (int i1 = 0; i3 < i8; i1 = i4)
    {
      Object localObject = getChildAt(i3);
      int i7 = i6;
      int i5 = i2;
      i4 = i1;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (d)((View)localObject).getLayoutParams();
        i7 = i6;
        i5 = i2;
        i4 = i1;
        if (((d)localObject).b(paramInt3))
        {
          i7 = i6;
          i5 = i2;
          i4 = i1;
          if (((d)localObject).a != null)
          {
            localObject = this.m;
            localObject[1] = 0;
            localObject[0] = 0;
            if (paramInt1 > 0) {
              i1 = Math.max(i6, localObject[0]);
            } else {
              i1 = Math.min(i6, localObject[0]);
            }
            if (paramInt2 > 0) {
              i2 = Math.max(i2, this.m[1]);
            } else {
              i2 = Math.min(i2, this.m[1]);
            }
            i4 = 1;
            i5 = i2;
            i7 = i1;
          }
        }
      }
      i3 += 1;
      i6 = i7;
      i2 = i5;
    }
    paramArrayOfInt[0] = i6;
    paramArrayOfInt[1] = i2;
    if (i1 != 0) {
      a(1);
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    this.w.a = paramInt;
    this.r = paramView;
    int i1 = getChildCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      getChildAt(paramInt).getLayoutParams();
      paramInt += 1;
    }
  }
  
  public final boolean b(int paramInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8) {
        ((d)localView.getLayoutParams()).a(paramInt);
      }
      i1 += 1;
    }
    return false;
  }
  
  public final void c(int paramInt)
  {
    this.w.a = 0;
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      d locald = (d)getChildAt(i1).getLayoutParams();
      if (locald.b(paramInt))
      {
        locald.a(paramInt);
        locald.n = false;
      }
      i1 += 1;
    }
    this.r = null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public final void d(int paramInt)
  {
    int i4 = getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      Object localObject = getChildAt(i1);
      i3 = i2;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (d)((View)localObject).getLayoutParams();
        i3 = i2;
        if (((d)localObject).b(paramInt))
        {
          i3 = i2;
          if (((d)localObject).a != null) {
            i3 = 1;
          }
        }
      }
      i1 += 1;
    }
    if (i2 != 0) {
      a(1);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramView.getLayoutParams();
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.u;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  final List<View> getDependencySortedChildren()
  {
    c();
    return Collections.unmodifiableList(this.i);
  }
  
  public final fv getLastWindowInsets()
  {
    return this.e;
  }
  
  public int getNestedScrollAxes()
  {
    return this.w.a;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.u;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
    if (this.t)
    {
      if (this.s == null) {
        this.s = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.s);
    }
    if ((this.e == null) && (fo.k(this))) {
      fo.j(this);
    }
    this.o = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    if ((this.t) && (this.s != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.s);
    }
    View localView = this.r;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    this.o = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.f) && (this.u != null))
    {
      fv localfv = this.e;
      int i1;
      if (localfv != null) {
        i1 = localfv.b();
      } else {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.u.setBounds(0, 0, getWidth(), i1);
        this.u.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      b();
    }
    a(paramMotionEvent);
    if ((i1 == 1) || (i1 == 3)) {
      b();
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = fo.c(this);
    int i1 = this.i.size();
    paramInt3 = 0;
    while (paramInt3 < i1)
    {
      View localView1 = (View)this.i.get(paramInt3);
      if (localView1.getVisibility() != 8)
      {
        localView1.getLayoutParams();
        Object localObject1 = (d)localView1.getLayoutParams();
        if ((((d)localObject1).k == null) && (((d)localObject1).f != -1)) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 == 0)
        {
          if (((d)localObject1).k != null)
          {
            localObject2 = ((d)localObject1).k;
            localView1.getLayoutParams();
            localObject1 = a();
            localRect = a();
          }
          try
          {
            gt.a(this, (View)localObject2, (Rect)localObject1);
            localObject2 = (d)localView1.getLayoutParams();
            paramInt1 = localView1.getMeasuredWidth();
            paramInt2 = localView1.getMeasuredHeight();
            a(paramInt4, (Rect)localObject1, localRect, (d)localObject2, paramInt1, paramInt2);
            a((d)localObject2, localRect, paramInt1, paramInt2);
            localView1.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
            a((Rect)localObject1);
            a(localRect);
          }
          finally
          {
            a((Rect)localObject1);
            a(localRect);
          }
          localObject1 = (d)localView2.getLayoutParams();
          paramInt1 = fb.a(g(((d)localObject1).c), paramInt4);
          int i7 = paramInt1 & 0x7;
          int i6 = paramInt1 & 0x70;
          int i5 = getWidth();
          int i4 = getHeight();
          int i2 = localView2.getMeasuredWidth();
          int i3 = localView2.getMeasuredHeight();
          paramInt1 = paramInt2;
          if (paramInt4 == 1) {
            paramInt1 = i5 - paramInt2;
          }
          paramInt1 = e(paramInt1) - i2;
          if (i7 != 1)
          {
            if (i7 == 5) {
              paramInt1 += i2;
            }
          }
          else {
            paramInt1 += i2 / 2;
          }
          if (i6 != 16)
          {
            if (i6 != 80) {
              paramInt2 = 0;
            } else {
              paramInt2 = i3 + 0;
            }
          }
          else {
            paramInt2 = i3 / 2 + 0;
          }
          paramInt1 = Math.max(getPaddingLeft() + ((d)localObject1).leftMargin, Math.min(paramInt1, i5 - getPaddingRight() - i2 - ((d)localObject1).rightMargin));
          paramInt2 = Math.max(getPaddingTop() + ((d)localObject1).topMargin, Math.min(paramInt2, i4 - getPaddingBottom() - i3 - ((d)localObject1).bottomMargin));
          localView2.layout(paramInt1, paramInt2, i2 + paramInt1, i3 + paramInt2);
          break label757;
          localObject1 = (d)localView2.getLayoutParams();
          Rect localRect = a();
          localRect.set(getPaddingLeft() + ((d)localObject1).leftMargin, getPaddingTop() + ((d)localObject1).topMargin, getWidth() - getPaddingRight() - ((d)localObject1).rightMargin, getHeight() - getPaddingBottom() - ((d)localObject1).bottomMargin);
          if ((this.e != null) && (fo.k(this)) && (!fo.k(localView2)))
          {
            localRect.left += this.e.a();
            localRect.top += this.e.b();
            localRect.right -= this.e.c();
            localRect.bottom -= this.e.d();
          }
          Object localObject2 = a();
          paramInt1 = f(((d)localObject1).c);
          paramInt2 = localView2.getMeasuredWidth();
          i2 = localView2.getMeasuredHeight();
          if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(paramInt1, paramInt2, i2, localRect, (Rect)localObject2, paramInt4);
          } else {
            Gravity.apply(paramInt1, paramInt2, i2, localRect, (Rect)localObject2);
          }
          localView2.layout(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom);
          a(localRect);
          a((Rect)localObject2);
        }
        else
        {
          throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
      }
      label757:
      paramInt3 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    int i3 = getChildCount();
    int i1 = 0;
    View localView;
    Object localObject;
    int i4;
    while (i1 < i3)
    {
      localView = getChildAt(i1);
      localObject = this.j;
      i4 = ((gj)localObject).b.size();
      i2 = 0;
      while (i2 < i4)
      {
        ArrayList localArrayList = (ArrayList)((gj)localObject).b.c(i2);
        if ((localArrayList != null) && (localArrayList.contains(localView)))
        {
          i2 = 1;
          break label99;
        }
        i2 += 1;
      }
      i2 = 0;
      label99:
      if (i2 != 0)
      {
        i22 = 1;
        break label120;
      }
      i1 += 1;
    }
    int i22 = 0;
    label120:
    if (i22 != this.t) {
      if (i22 != 0)
      {
        if (this.o)
        {
          if (this.s == null) {
            this.s = new e();
          }
          getViewTreeObserver().addOnPreDrawListener(this.s);
        }
        this.t = true;
      }
      else
      {
        if ((this.o) && (this.s != null)) {
          getViewTreeObserver().removeOnPreDrawListener(this.s);
        }
        this.t = false;
      }
    }
    int i11 = getPaddingLeft();
    int i12 = getPaddingTop();
    int i13 = getPaddingRight();
    int i14 = getPaddingBottom();
    int i15 = fo.c(this);
    if (i15 == 1) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i16 = View.MeasureSpec.getMode(paramInt1);
    int i17 = View.MeasureSpec.getSize(paramInt1);
    int i18 = View.MeasureSpec.getMode(paramInt2);
    int i19 = View.MeasureSpec.getSize(paramInt2);
    int i8 = getSuggestedMinimumWidth();
    int i2 = getSuggestedMinimumHeight();
    int i5;
    if ((this.e != null) && (fo.k(this))) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i6 = this.i.size();
    i1 = 0;
    int i7 = 0;
    while (i7 < i6)
    {
      localView = (View)this.i.get(i7);
      if (localView.getVisibility() != 8)
      {
        localObject = (d)localView.getLayoutParams();
        int i9;
        if ((((d)localObject).e >= 0) && (i16 != 0))
        {
          i3 = e(((d)localObject).e);
          i9 = fb.a(g(((d)localObject).c), i15) & 0x7;
          if (((i9 == 3) && (i4 == 0)) || ((i9 == 5) && (i4 != 0)))
          {
            i3 = Math.max(0, i17 - i13 - i3);
            break label495;
          }
          if (((i9 == 5) && (i4 == 0)) || ((i9 == 3) && (i4 != 0)))
          {
            i3 = Math.max(0, i3 - i11);
            break label495;
          }
        }
        i3 = 0;
        label495:
        int i10;
        if ((i5 != 0) && (!fo.k(localView)))
        {
          i9 = this.e.a();
          int i21 = this.e.c();
          i10 = this.e.b();
          int i20 = this.e.d();
          i9 = View.MeasureSpec.makeMeasureSpec(i17 - (i9 + i21), i16);
          i10 = View.MeasureSpec.makeMeasureSpec(i19 - (i10 + i20), i18);
        }
        else
        {
          i9 = paramInt1;
          i10 = paramInt2;
        }
        measureChildWithMargins(localView, i9, i3, i10, 0);
        i8 = Math.max(i8, i11 + i13 + localView.getMeasuredWidth() + ((d)localObject).leftMargin + ((d)localObject).rightMargin);
        i2 = Math.max(i2, i12 + i14 + localView.getMeasuredHeight() + ((d)localObject).topMargin + ((d)localObject).bottomMargin);
        i1 = View.combineMeasuredStates(i1, localView.getMeasuredState());
      }
      i7 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(i8, paramInt1, 0xFF000000 & i1), View.resolveSizeAndState(i2, paramInt2, i1 << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramView = getChildAt(i1);
      if (paramView.getVisibility() != 8) {
        paramView.getLayoutParams();
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramView = getChildAt(i1);
      if (paramView.getVisibility() != 8) {
        paramView.getLayoutParams();
      }
      i1 += 1;
    }
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d(0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    a(paramView2, paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.c);
    paramParcelable = paramParcelable.a;
    int i1 = 0;
    int i2 = getChildCount();
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      int i3 = ((View)localObject).getId();
      localObject = a((View)localObject).a;
      if ((i3 != -1) && (localObject != null)) {
        paramParcelable.get(i3);
      }
      i1 += 1;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      int i3 = ((View)localObject).getId();
      localObject = ((d)((View)localObject).getLayoutParams()).a;
      if ((i3 != -1) && (localObject != null))
      {
        localObject = Behavior.a();
        if (localObject != null) {
          localSparseArray.append(i3, localObject);
        }
      }
      i1 += 1;
    }
    localSavedState.a = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return b(0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    c(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    Object localObject = this.q;
    if (localObject == null) {
      a(paramMotionEvent);
    } else {
      localObject = ((d)((View)localObject).getLayoutParams()).a;
    }
    localObject = this.q;
    boolean bool = false;
    if (localObject == null) {
      bool = false | super.onTouchEvent(paramMotionEvent);
    }
    if ((i1 == 1) || (i1 == 3)) {
      b();
    }
    return bool;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramView.getLayoutParams();
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.n))
    {
      b();
      this.n = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    d();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.g = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.u;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.u = localDrawable1;
      paramDrawable = this.u;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.u.setState(getDrawableState());
        }
        dy.b(this.u, fo.c(this));
        paramDrawable = this.u;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.u.setCallback(this);
      }
      fo.a(this);
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = dj.a(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.u;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.u.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.u);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static Parcelable a()
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    public static fv a(fv paramfv)
    {
      return paramfv;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    SparseArray<Parcelable> a;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.a = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.a.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.a;
      int j = 0;
      int i;
      if (localObject != null) {
        i = ((SparseArray)localObject).size();
      } else {
        i = 0;
      }
      paramParcel.writeInt(i);
      localObject = new int[i];
      Parcelable[] arrayOfParcelable = new Parcelable[i];
      while (j < i)
      {
        localObject[j] = this.a.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)this.a.valueAt(j));
        j += 1;
      }
      paramParcel.writeIntArray((int[])localObject);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract CoordinatorLayout.Behavior a();
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface b
  {
    Class<? extends CoordinatorLayout.Behavior> a();
  }
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      if (CoordinatorLayout.this.g != null) {
        CoordinatorLayout.this.g.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout.this.a(2);
      if (CoordinatorLayout.this.g != null) {
        CoordinatorLayout.this.g.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    CoordinatorLayout.Behavior a;
    boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = -1;
    int f = -1;
    public int g = 0;
    public int h = 0;
    int i;
    int j;
    View k;
    View l;
    boolean m;
    boolean n;
    final Rect o = new Rect();
    Object p;
    private boolean q;
    private boolean r;
    
    public d()
    {
      super(-2);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, cb.c.CoordinatorLayout_Layout);
      this.c = localTypedArray.getInteger(cb.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.f = localTypedArray.getResourceId(cb.c.CoordinatorLayout_Layout_layout_anchor, -1);
      this.d = localTypedArray.getInteger(cb.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.e = localTypedArray.getInteger(cb.c.CoordinatorLayout_Layout_layout_keyline, -1);
      this.g = localTypedArray.getInt(cb.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.h = localTypedArray.getInt(cb.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      this.b = localTypedArray.hasValue(cb.c.CoordinatorLayout_Layout_layout_behavior);
      if (this.b) {
        this.a = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(cb.c.CoordinatorLayout_Layout_layout_behavior));
      }
      localTypedArray.recycle();
    }
    
    public d(d paramd)
    {
      super();
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    final void a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.r = false;
        return;
      }
      this.q = false;
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      if (this.a != paramBehavior)
      {
        this.a = paramBehavior;
        this.p = null;
        this.b = true;
      }
    }
    
    final boolean b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        return this.r;
      }
      return this.q;
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      CoordinatorLayout.this.a(0);
      return true;
    }
  }
  
  static final class f
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */