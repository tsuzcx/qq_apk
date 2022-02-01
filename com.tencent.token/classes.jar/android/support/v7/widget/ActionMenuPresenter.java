package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.token.dy;
import com.tencent.token.fa;
import com.tencent.token.fa.a;
import com.tencent.token.hg.a;
import com.tencent.token.hg.g;
import com.tencent.token.hn;
import com.tencent.token.hx;
import com.tencent.token.id;
import com.tencent.token.id.a;
import com.tencent.token.if;
import com.tencent.token.ij;
import com.tencent.token.ik.a;
import com.tencent.token.il;
import com.tencent.token.il.a;
import com.tencent.token.io;
import com.tencent.token.iq;
import com.tencent.token.jl;
import com.tencent.token.jy;
import java.util.ArrayList;

public final class ActionMenuPresenter
  extends hx
  implements fa.a
{
  private final SparseBooleanArray A = new SparseBooleanArray();
  private View B;
  private b C;
  d i;
  Drawable j;
  boolean k;
  public boolean l;
  e m;
  a n;
  public c o;
  final f p = new f();
  int q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private boolean y;
  private int z;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, hg.g.abc_action_menu_layout, hg.g.abc_action_menu_item_layout);
  }
  
  public final View a(if paramif, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramif.getActionView();
    if ((localView == null) || (paramif.j())) {
      localView = super.a(paramif, paramView, paramViewGroup);
    }
    int i1;
    if (paramif.isActionViewExpanded()) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localView.setVisibility(i1);
    paramif = (ActionMenuView)paramViewGroup;
    paramView = localView.getLayoutParams();
    if (!paramif.checkLayoutParams(paramView)) {
      localView.setLayoutParams(ActionMenuView.a(paramView));
    }
    return localView;
  }
  
  public final il a(ViewGroup paramViewGroup)
  {
    il localil = this.g;
    paramViewGroup = super.a(paramViewGroup);
    if (localil != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, id paramid)
  {
    super.a(paramContext, paramid);
    paramid = paramContext.getResources();
    paramContext = hn.a(paramContext);
    if (!this.s)
    {
      i1 = Build.VERSION.SDK_INT;
      boolean bool = true;
      if ((i1 < 19) && (ViewConfiguration.get(paramContext.a).hasPermanentMenuKey())) {
        bool = false;
      }
      this.r = bool;
    }
    if (!this.y) {
      this.t = (paramContext.a.getResources().getDisplayMetrics().widthPixels / 2);
    }
    if (!this.w) {
      this.v = paramContext.a();
    }
    int i1 = this.t;
    if (this.r)
    {
      if (this.i == null)
      {
        this.i = new d(this.a);
        if (this.k)
        {
          this.i.setImageDrawable(this.j);
          this.j = null;
          this.k = false;
        }
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.i.measure(i2, i2);
      }
      i1 -= this.i.getMeasuredWidth();
    }
    else
    {
      this.i = null;
    }
    this.u = i1;
    this.z = ((int)(paramid.getDisplayMetrics().density * 56.0F));
    this.B = null;
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.g = paramActionMenuView;
    paramActionMenuView.a = this.c;
  }
  
  public final void a(id paramid, boolean paramBoolean)
  {
    f();
    super.a(paramid, paramBoolean);
  }
  
  public final void a(if paramif, il.a parama)
  {
    parama.a(paramif);
    paramif = (ActionMenuView)this.g;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramif);
    if (this.C == null) {
      this.C = new b();
    }
    parama.setPopupCallback(this.C);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(null);
      return;
    }
    if (this.c != null) {
      this.c.a(false);
    }
  }
  
  public final boolean a()
  {
    Object localObject1 = this;
    ArrayList localArrayList;
    int i4;
    if (((ActionMenuPresenter)localObject1).c != null)
    {
      localArrayList = ((ActionMenuPresenter)localObject1).c.h();
      i4 = localArrayList.size();
    }
    else
    {
      localArrayList = null;
      i4 = 0;
    }
    int i1 = ((ActionMenuPresenter)localObject1).v;
    int i8 = ((ActionMenuPresenter)localObject1).u;
    int i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)((ActionMenuPresenter)localObject1).g;
    int i5 = 0;
    int i6 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i5 < i4)
    {
      localObject2 = (if)localArrayList.get(i5);
      if (((if)localObject2).h()) {
        i2 += 1;
      } else if (((if)localObject2).g()) {
        i3 += 1;
      } else {
        i6 = 1;
      }
      i7 = i1;
      if (((ActionMenuPresenter)localObject1).l)
      {
        i7 = i1;
        if (((if)localObject2).isActionViewExpanded()) {
          i7 = 0;
        }
      }
      i5 += 1;
      i1 = i7;
    }
    i5 = i1;
    if (((ActionMenuPresenter)localObject1).r) {
      if (i6 == 0)
      {
        i5 = i1;
        if (i3 + i2 <= i1) {}
      }
      else
      {
        i5 = i1 - 1;
      }
    }
    i3 = i5 - i2;
    Object localObject2 = ((ActionMenuPresenter)localObject1).A;
    ((SparseBooleanArray)localObject2).clear();
    if (((ActionMenuPresenter)localObject1).x)
    {
      i1 = ((ActionMenuPresenter)localObject1).z;
      i2 = i8 / i1;
      i6 = i1 + i8 % i1 / i2;
    }
    else
    {
      i6 = 0;
      i2 = 0;
    }
    i5 = i8;
    i8 = 0;
    i1 = 0;
    int i7 = i4;
    for (;;)
    {
      localObject1 = this;
      if (i8 >= i7) {
        break;
      }
      if localif = (if)localArrayList.get(i8);
      View localView;
      if (localif.h())
      {
        localView = ((ActionMenuPresenter)localObject1).a(localif, ((ActionMenuPresenter)localObject1).B, localViewGroup);
        if (((ActionMenuPresenter)localObject1).B == null) {
          ((ActionMenuPresenter)localObject1).B = localView;
        }
        if (((ActionMenuPresenter)localObject1).x) {
          i2 -= ActionMenuView.a(localView, i6, i2, i10, 0);
        } else {
          localView.measure(i10, i10);
        }
        i4 = localView.getMeasuredWidth();
        i5 -= i4;
        if (i1 == 0) {
          i1 = i4;
        }
        i4 = localif.getGroupId();
        if (i4 != 0) {
          ((SparseBooleanArray)localObject2).put(i4, true);
        }
        localif.c(true);
      }
      else if (localif.g())
      {
        int i11 = localif.getGroupId();
        boolean bool = ((SparseBooleanArray)localObject2).get(i11);
        int i12;
        if (((i3 > 0) || (bool)) && (i5 > 0) && ((!((ActionMenuPresenter)localObject1).x) || (i2 > 0))) {
          i12 = 1;
        } else {
          i12 = 0;
        }
        int i9;
        if (i12 != 0)
        {
          localView = ((ActionMenuPresenter)localObject1).a(localif, ((ActionMenuPresenter)localObject1).B, localViewGroup);
          if (((ActionMenuPresenter)localObject1).B == null) {
            ((ActionMenuPresenter)localObject1).B = localView;
          }
          if (((ActionMenuPresenter)localObject1).x)
          {
            i9 = ActionMenuView.a(localView, i6, i2, i10, 0);
            i4 = i2 - i9;
            i2 = i4;
            if (i9 == 0)
            {
              i12 = 0;
              i2 = i4;
            }
          }
          else
          {
            localView.measure(i10, i10);
          }
          i9 = localView.getMeasuredWidth();
          i5 -= i9;
          i4 = i1;
          if (i1 == 0) {
            i4 = i9;
          }
          if (((ActionMenuPresenter)localObject1).x)
          {
            if (i5 >= 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            i12 &= i1;
            i1 = i4;
          }
          else
          {
            if (i5 + i4 > 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            i12 &= i1;
            i1 = i4;
          }
        }
        if ((i12 != 0) && (i11 != 0))
        {
          ((SparseBooleanArray)localObject2).put(i11, true);
          i4 = i3;
        }
        else
        {
          i4 = i3;
          if (bool)
          {
            ((SparseBooleanArray)localObject2).put(i11, false);
            i9 = 0;
            for (;;)
            {
              i4 = i3;
              if (i9 >= i8) {
                break;
              }
              localObject1 = (if)localArrayList.get(i9);
              i4 = i3;
              if (((if)localObject1).getGroupId() == i11)
              {
                i4 = i3;
                if (((if)localObject1).f()) {
                  i4 = i3 + 1;
                }
                ((if)localObject1).c(false);
              }
              i9 += 1;
              i3 = i4;
            }
          }
        }
        i3 = i4;
        if (i12 != 0) {
          i3 = i4 - 1;
        }
        localif.c(i12);
      }
      else
      {
        localif.c(false);
      }
      i8 += 1;
    }
    return true;
  }
  
  public final boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.i) {
      return false;
    }
    return super.a(paramViewGroup, paramInt);
  }
  
  public final boolean a(if paramif)
  {
    return paramif.f();
  }
  
  public final boolean a(iq paramiq)
  {
    boolean bool1 = paramiq.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramiq; ((iq)localObject).l != this.c; localObject = (iq)((iq)localObject).l) {}
    MenuItem localMenuItem = ((iq)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.g;
    if (localViewGroup != null)
    {
      i2 = localViewGroup.getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = localViewGroup.getChildAt(i1);
        if (((localObject instanceof il.a)) && (((il.a)localObject).getItemData() == localMenuItem)) {
          break label122;
        }
        i1 += 1;
      }
    }
    localObject = null;
    label122:
    if (localObject == null) {
      return false;
    }
    this.q = paramiq.getItem().getItemId();
    int i2 = paramiq.size();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      localMenuItem = paramiq.getItem(i1);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
      i1 += 1;
    }
    this.n = new a(this.b, paramiq, (View)localObject);
    this.n.a(bool1);
    if (this.n.b())
    {
      super.a(paramiq);
      return true;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public final void b()
  {
    if (!this.w) {
      this.v = hn.a(this.b).a();
    }
    if (this.c != null) {
      this.c.b(true);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    ((View)this.g).requestLayout();
    Object localObject = this.c;
    int i2 = 0;
    int i3;
    if (localObject != null)
    {
      localObject = this.c;
      ((id)localObject).i();
      localObject = ((id)localObject).d;
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        fa localfa = ((if)((ArrayList)localObject).get(i1)).c;
        if (localfa != null) {
          localfa.a = this;
        }
        i1 += 1;
      }
    }
    if (this.c != null) {
      localObject = this.c.j();
    } else {
      localObject = null;
    }
    int i1 = i2;
    boolean bool;
    if (this.r)
    {
      i1 = i2;
      if (localObject != null)
      {
        i3 = ((ArrayList)localObject).size();
        if (i3 == 1)
        {
          bool = ((if)((ArrayList)localObject).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = i2;
          if (i3 > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (this.i == null) {
        this.i = new d(this.a);
      }
      localObject = (ViewGroup)this.i.getParent();
      if (localObject != this.g)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.i);
        }
        ((ActionMenuView)this.g).addView(this.i, ActionMenuView.a());
      }
    }
    else
    {
      localObject = this.i;
      if ((localObject != null) && (((d)localObject).getParent() == this.g)) {
        ((ViewGroup)this.g).removeView(this.i);
      }
    }
    ((ActionMenuView)this.g).setOverflowReserved(this.r);
  }
  
  public final void c()
  {
    this.r = true;
    this.s = true;
  }
  
  public final boolean d()
  {
    if ((this.r) && (!h()) && (this.c != null) && (this.g != null) && (this.o == null) && (!this.c.j().isEmpty()))
    {
      this.o = new c(new e(this.b, this.c, this.i));
      ((View)this.g).post(this.o);
      super.a(null);
      return true;
    }
    return false;
  }
  
  public final boolean e()
  {
    if ((this.o != null) && (this.g != null))
    {
      ((View)this.g).removeCallbacks(this.o);
      this.o = null;
      return true;
    }
    e locale = this.m;
    if (locale != null)
    {
      locale.c();
      return true;
    }
    return false;
  }
  
  public final boolean f()
  {
    return e() | g();
  }
  
  public final boolean g()
  {
    a locala = this.n;
    if (locala != null)
    {
      locala.c();
      return true;
    }
    return false;
  }
  
  public final boolean h()
  {
    e locale = this.m;
    return (locale != null) && (locale.e());
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int a;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
    }
  }
  
  final class a
    extends ij
  {
    public a(Context paramContext, iq paramiq, View paramView)
    {
      super(paramiq, paramView, false, hg.a.actionOverflowMenuStyle);
      if (!((if)paramiq.getItem()).f())
      {
        if (ActionMenuPresenter.this.i == null) {
          paramContext = (View)ActionMenuPresenter.this.g;
        } else {
          paramContext = ActionMenuPresenter.this.i;
        }
        this.a = paramContext;
      }
      a(ActionMenuPresenter.this.p);
    }
    
    public final void d()
    {
      ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
      localActionMenuPresenter.n = null;
      localActionMenuPresenter.q = 0;
      super.d();
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final io a()
    {
      if (ActionMenuPresenter.this.n != null) {
        return ActionMenuPresenter.this.n.a();
      }
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e b;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.b = parame;
    }
    
    public final void run()
    {
      if (ActionMenuPresenter.this.c != null)
      {
        localObject = ActionMenuPresenter.this.c;
        if (((id)localObject).b != null) {
          ((id)localObject).b.a((id)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.this.g;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.b.b())) {
        ActionMenuPresenter.this.m = this.b;
      }
      ActionMenuPresenter.this.o = null;
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] b = new float[2];
    
    public d(Context paramContext)
    {
      super(null, hg.a.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      jy.a(this, getContentDescription());
      setOnTouchListener(new jl(this)
      {
        public final io a()
        {
          if (ActionMenuPresenter.this.m == null) {
            return null;
          }
          return ActionMenuPresenter.this.m.a();
        }
        
        public final boolean b()
        {
          ActionMenuPresenter.this.d();
          return true;
        }
        
        public final boolean c()
        {
          if (ActionMenuPresenter.this.o != null) {
            return false;
          }
          ActionMenuPresenter.this.e();
          return true;
        }
      });
    }
    
    public final boolean c()
    {
      return false;
    }
    
    public final boolean d()
    {
      return false;
    }
    
    public final boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.d();
      return true;
    }
    
    protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        dy.a(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  final class e
    extends ij
  {
    public e(Context paramContext, id paramid, View paramView)
    {
      super(paramid, paramView, true, hg.a.actionOverflowMenuStyle);
      this.b = 8388613;
      a(ActionMenuPresenter.this.p);
    }
    
    public final void d()
    {
      if (ActionMenuPresenter.this.c != null) {
        ActionMenuPresenter.this.c.close();
      }
      ActionMenuPresenter.this.m = null;
      super.d();
    }
  }
  
  final class f
    implements ik.a
  {
    f() {}
    
    public final void a(id paramid, boolean paramBoolean)
    {
      if ((paramid instanceof iq)) {
        paramid.k().a(false);
      }
      ik.a locala = ActionMenuPresenter.this.f;
      if (locala != null) {
        locala.a(paramid, paramBoolean);
      }
    }
    
    public final boolean a(id paramid)
    {
      if (paramid == null) {
        return false;
      }
      ActionMenuPresenter.this.q = ((iq)paramid).getItem().getItemId();
      ik.a locala = ActionMenuPresenter.this.f;
      if (locala != null) {
        return locala.a(paramid);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */