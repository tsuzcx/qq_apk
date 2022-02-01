package android.support.v4.app;

import android.animation.Animator;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import com.tencent.token.av;
import com.tencent.token.av.a;
import com.tencent.token.ay;
import com.tencent.token.az;
import com.tencent.token.bl;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.cf;
import com.tencent.token.cg;
import com.tencent.token.cs;
import com.tencent.token.ct;
import com.tencent.token.eb;
import com.tencent.token.ej;
import com.tencent.token.eo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, ay
{
  private static final ej<String, Class<?>> V = new ej();
  static final Object a = new Object();
  public String A;
  public boolean B;
  public boolean C;
  public boolean D;
  public boolean E;
  public boolean F;
  public boolean G = true;
  public boolean H;
  public ViewGroup I;
  public View J;
  public View K;
  public boolean L;
  public boolean M = true;
  public LoaderManagerImpl N;
  a O;
  public boolean P;
  public boolean Q;
  public float R;
  public LayoutInflater S;
  public boolean T;
  public az U = new az(this);
  public int b = 0;
  public Bundle c;
  public SparseArray<Parcelable> d;
  public Boolean e;
  public int f = -1;
  public String g;
  public Bundle h;
  public Fragment i;
  public int j = -1;
  public int k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public int r;
  public cf s;
  public cd t;
  public cf u;
  public cg v;
  public bl w;
  public Fragment x;
  public int y;
  public int z;
  
  private void G()
  {
    Object localObject = this.O;
    if (localObject == null)
    {
      localObject = null;
    }
    else
    {
      ((a)localObject).q = false;
      localObject = ((a)localObject).r;
      this.O.r = null;
    }
    if (localObject != null) {
      ((c)localObject).a();
    }
  }
  
  private void H()
  {
    if (this.t != null)
    {
      this.u = new cf();
      this.u.a(this.t, new cb()
      {
        public final Fragment a(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          return Fragment.this.t.a(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
        }
        
        public final View a(int paramAnonymousInt)
        {
          if (Fragment.this.J != null) {
            return Fragment.this.J.findViewById(paramAnonymousInt);
          }
          throw new IllegalStateException("Fragment does not have a view");
        }
        
        public final boolean a()
        {
          return Fragment.this.J != null;
        }
      }, this);
      return;
    }
    throw new IllegalStateException("Fragment has not been attached yet.");
  }
  
  private a I()
  {
    if (this.O == null) {
      this.O = new a();
    }
    return this.O;
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        Class localClass2 = (Class)V.get(paramString);
        Class localClass1 = localClass2;
        if (localClass2 == null)
        {
          localClass1 = paramContext.getClassLoader().loadClass(paramString);
          V.put(paramString, localClass1);
        }
        bool = false;
        paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
        if (paramBundle != null)
        {
          paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
          if (paramContext.f >= 0)
          {
            if (paramContext.s != null)
            {
              bool = paramContext.s.e();
              break label308;
              throw new IllegalStateException("Fragment already active and state has been saved");
            }
          }
          else {
            paramContext.h = paramBundle;
          }
        }
        else
        {
          return paramContext;
        }
      }
      catch (InvocationTargetException paramContext)
      {
        paramBundle = new StringBuilder("Unable to instantiate fragment ");
        paramBundle.append(paramString);
        paramBundle.append(": calling Fragment constructor caused an exception");
        throw new b(paramBundle.toString(), paramContext);
      }
      catch (NoSuchMethodException paramContext)
      {
        paramBundle = new StringBuilder("Unable to instantiate fragment ");
        paramBundle.append(paramString);
        paramBundle.append(": could not find Fragment constructor");
        throw new b(paramBundle.toString(), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        paramBundle = new StringBuilder("Unable to instantiate fragment ");
        paramBundle.append(paramString);
        paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
        throw new b(paramBundle.toString(), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        paramBundle = new StringBuilder("Unable to instantiate fragment ");
        paramBundle.append(paramString);
        paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
        throw new b(paramBundle.toString(), paramContext);
      }
      catch (ClassNotFoundException paramContext)
      {
        paramBundle = new StringBuilder("Unable to instantiate fragment ");
        paramBundle.append(paramString);
        paramBundle.append(": make sure class name exists, is public, and has an empty constructor that is public");
        throw new b(paramBundle.toString(), paramContext);
      }
      label308:
      if (bool) {}
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)V.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        V.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  public final cs A()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.p;
  }
  
  public final View B()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.a;
  }
  
  public final Animator C()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.b;
  }
  
  public final int D()
  {
    a locala = this.O;
    if (locala == null) {
      return 0;
    }
    return locala.c;
  }
  
  public final boolean E()
  {
    a locala = this.O;
    if (locala == null) {
      return false;
    }
    return locala.q;
  }
  
  public final boolean F()
  {
    a locala = this.O;
    if (locala == null) {
      return false;
    }
    return locala.s;
  }
  
  public final Fragment a(String paramString)
  {
    if (paramString.equals(this.g)) {
      return this;
    }
    cf localcf = this.u;
    if (localcf != null) {
      return localcf.b(paramString);
    }
    return null;
  }
  
  public void a()
  {
    this.H = true;
  }
  
  public final void a(int paramInt)
  {
    if ((this.O == null) && (paramInt == 0)) {
      return;
    }
    I().d = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.O == null) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    I();
    a locala = this.O;
    locala.e = paramInt1;
    locala.f = paramInt2;
  }
  
  public final void a(int paramInt, Fragment paramFragment)
  {
    this.f = paramInt;
    if (paramFragment != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFragment.g);
      localStringBuilder.append(":");
      localStringBuilder.append(this.f);
      this.g = localStringBuilder.toString();
      return;
    }
    paramFragment = new StringBuilder("android:fragment:");
    paramFragment.append(this.f);
    this.g = paramFragment.toString();
  }
  
  public final void a(Animator paramAnimator)
  {
    I().b = paramAnimator;
  }
  
  public final void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    cf localcf = this.u;
    if (localcf != null) {
      localcf.a(paramConfiguration);
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.u == null) {
          H();
        }
        this.u.a(paramBundle, this.v);
        this.v = null;
        this.u.k();
      }
    }
  }
  
  public final void a(c paramc)
  {
    I();
    if (paramc == this.O.r) {
      return;
    }
    if ((paramc != null) && (this.O.r != null)) {
      throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on ".concat(String.valueOf(this)));
    }
    if (this.O.q) {
      this.O.r = paramc;
    }
    if (paramc != null) {
      paramc.b();
    }
  }
  
  public final void a(View paramView)
  {
    I().a = paramView;
  }
  
  public final void a(boolean paramBoolean)
  {
    cf localcf = this.u;
    if (localcf != null) {
      localcf.a(paramBoolean);
    }
  }
  
  public final boolean a(Menu paramMenu)
  {
    boolean bool2 = this.B;
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      bool2 = bool3;
      if (this.F)
      {
        bool2 = bool3;
        if (this.G) {
          bool2 = true;
        }
      }
      cf localcf = this.u;
      bool1 = bool2;
      if (localcf != null) {
        bool1 = bool2 | localcf.a(paramMenu);
      }
    }
    return bool1;
  }
  
  public final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = this.B;
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      bool2 = bool3;
      if (this.F)
      {
        bool2 = bool3;
        if (this.G) {
          bool2 = true;
        }
      }
      cf localcf = this.u;
      bool1 = bool2;
      if (localcf != null) {
        bool1 = bool2 | localcf.a(paramMenu, paramMenuInflater);
      }
    }
    return bool1;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (!this.B)
    {
      cf localcf = this.u;
      if ((localcf != null) && (localcf.a(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.H = true;
  }
  
  public final void b(int paramInt)
  {
    I().c = paramInt;
  }
  
  public final void b(Bundle paramBundle)
  {
    cf localcf = this.u;
    if (localcf != null) {
      localcf.j();
    }
    this.b = 1;
    int i1 = 0;
    this.H = false;
    this.H = true;
    a(paramBundle);
    paramBundle = this.u;
    if (paramBundle != null)
    {
      if (paramBundle.l > 0) {
        i1 = 1;
      }
      if (i1 == 0) {
        this.u.k();
      }
    }
    this.T = true;
    if (this.H)
    {
      this.U.a(av.a.ON_CREATE);
      return;
    }
    paramBundle = new StringBuilder("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onCreate()");
    throw new ct(paramBundle.toString());
  }
  
  public final void b(Menu paramMenu)
  {
    if (!this.B)
    {
      cf localcf = this.u;
      if (localcf != null) {
        localcf.b(paramMenu);
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    cf localcf = this.u;
    if (localcf != null) {
      localcf.b(paramBoolean);
    }
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    if (!this.B)
    {
      cf localcf = this.u;
      if ((localcf != null) && (localcf.b(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    this.H = true;
    if ((this.w != null) && (!this.t.f.s)) {
      this.w.a();
    }
  }
  
  public final void c(Bundle paramBundle)
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = ((cf)localObject).i();
      if (localObject != null) {
        paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
      }
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    I().s = paramBoolean;
  }
  
  public final boolean d()
  {
    return this.r > 0;
  }
  
  public final ce e()
  {
    if (this.u == null)
    {
      H();
      int i1 = this.b;
      if (i1 >= 5) {
        this.u.n();
      } else if (i1 >= 4) {
        this.u.m();
      } else if (i1 >= 2) {
        this.u.l();
      } else if (i1 > 0) {
        this.u.k();
      }
    }
    return this.u;
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public final LayoutInflater f()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      localObject = ((cd)localObject).c();
      e();
      eo.b((LayoutInflater)localObject, this.u);
      this.S = ((LayoutInflater)localObject);
      return this.S;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public final void g()
  {
    this.H = true;
    Object localObject = this.t;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((cd)localObject).b;
    }
    if (localObject != null)
    {
      this.H = false;
      this.H = true;
    }
  }
  
  public av getLifecycle()
  {
    return this.U;
  }
  
  public final Object h()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.g;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final Object i()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    if (locala.h == a) {
      return h();
    }
    return this.O.h;
  }
  
  public final Object j()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.i;
  }
  
  public final Object k()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    if (locala.j == a) {
      return j();
    }
    return this.O.j;
  }
  
  public final Object l()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.k;
  }
  
  public final Object m()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    if (locala.l == a) {
      return l();
    }
    return this.O.l;
  }
  
  public final boolean n()
  {
    a locala = this.O;
    if ((locala != null) && (locala.n != null)) {
      return this.O.n.booleanValue();
    }
    return true;
  }
  
  public final boolean o()
  {
    a locala = this.O;
    if ((locala != null) && (locala.m != null)) {
      return this.O.m.booleanValue();
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.H = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = this.t;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FragmentActivity)((cd)localObject).b;
    }
    ((FragmentActivity)localObject).onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onLowMemory()
  {
    this.H = true;
  }
  
  public final void p()
  {
    cf localcf = this.s;
    if ((localcf != null) && (localcf.m != null))
    {
      if (Looper.myLooper() != this.s.m.d.getLooper())
      {
        this.s.m.d.postAtFrontOfQueue(new Runnable()
        {
          public final void run()
          {
            Fragment.a(Fragment.this);
          }
        });
        return;
      }
      G();
      return;
    }
    I().q = false;
  }
  
  public final View q()
  {
    cf localcf = this.u;
    if (localcf != null) {
      localcf.j();
    }
    this.q = true;
    return null;
  }
  
  public final void r()
  {
    Object localObject = this.u;
    if (localObject != null) {
      ((cf)localObject).j();
    }
    this.b = 2;
    this.H = false;
    this.H = true;
    if (this.H)
    {
      localObject = this.u;
      if (localObject != null) {
        ((cf)localObject).l();
      }
      return;
    }
    localObject = new StringBuilder("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onActivityCreated()");
    throw new ct(((StringBuilder)localObject).toString());
  }
  
  public final void s()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      ((cf)localObject).j();
      this.u.h();
    }
    this.b = 4;
    this.H = false;
    this.H = true;
    if (this.H)
    {
      localObject = this.u;
      if (localObject != null) {
        ((cf)localObject).m();
      }
      this.U.a(av.a.ON_START);
      return;
    }
    localObject = new StringBuilder("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onStart()");
    throw new ct(((StringBuilder)localObject).toString());
  }
  
  public final void t()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      ((cf)localObject).j();
      this.u.h();
    }
    this.b = 5;
    this.H = false;
    this.H = true;
    if (this.H)
    {
      localObject = this.u;
      if (localObject != null)
      {
        ((cf)localObject).n();
        this.u.h();
      }
      this.U.a(av.a.ON_RESUME);
      return;
    }
    localObject = new StringBuilder("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" did not call through to super.onResume()");
    throw new ct(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    eb.a(this, localStringBuilder);
    if (this.f >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.f);
    }
    if (this.y != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.y));
    }
    if (this.A != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.A);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final void u()
  {
    cf localcf = this.u;
    if (localcf != null) {
      localcf.j();
    }
  }
  
  public final void v()
  {
    onLowMemory();
    cf localcf = this.u;
    if (localcf != null) {
      localcf.q();
    }
  }
  
  public final int w()
  {
    a locala = this.O;
    if (locala == null) {
      return 0;
    }
    return locala.d;
  }
  
  public final int x()
  {
    a locala = this.O;
    if (locala == null) {
      return 0;
    }
    return locala.e;
  }
  
  public final int y()
  {
    a locala = this.O;
    if (locala == null) {
      return 0;
    }
    return locala.f;
  }
  
  public final cs z()
  {
    a locala = this.O;
    if (locala == null) {
      return null;
    }
    return locala.o;
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    final Bundle a;
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readBundle();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.a);
    }
  }
  
  static final class a
  {
    View a;
    Animator b;
    int c;
    int d;
    int e;
    int f;
    Object g = null;
    Object h = Fragment.a;
    Object i = null;
    Object j = Fragment.a;
    Object k = null;
    Object l = Fragment.a;
    Boolean m;
    Boolean n;
    cs o = null;
    cs p = null;
    boolean q;
    Fragment.c r;
    boolean s;
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.7.0.1
 */