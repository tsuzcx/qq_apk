package android.support.v4.app;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveData.LifecycleBoundObserver;
import android.arch.lifecycle.LiveData.a;
import android.os.Bundle;
import com.tencent.token.ar;
import com.tencent.token.au;
import com.tencent.token.au.b;
import com.tencent.token.aw;
import com.tencent.token.bb;
import com.tencent.token.bc;
import com.tencent.token.bf;
import com.tencent.token.bg;
import com.tencent.token.bg.a;
import com.tencent.token.bh;
import com.tencent.token.ci;
import com.tencent.token.ci.a;
import com.tencent.token.ct;
import com.tencent.token.ct.a;
import com.tencent.token.dy;
import com.tencent.token.eh;
import java.io.PrintWriter;
import java.util.HashMap;

public final class LoaderManagerImpl
  extends ci
{
  static boolean a = false;
  public final LoaderViewModel b;
  private final aw c;
  
  LoaderManagerImpl(aw paramaw, bh parambh)
  {
    this.c = paramaw;
    this.b = LoaderViewModel.a(parambh);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    this.b.a(paramString, paramPrintWriter);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    dy.a(this.c, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class LoaderViewModel
    extends bf
  {
    private static final bg.a a = new bg.a()
    {
      public final <T extends bf> T a()
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    private eh<LoaderManagerImpl.a> b = new eh();
    
    static LoaderViewModel a(bh parambh)
    {
      bg localbg = new bg(parambh, a);
      parambh = LoaderViewModel.class.getCanonicalName();
      if (parambh != null)
      {
        String str = "android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(parambh));
        parambh = (bf)localbg.b.a.get(str);
        if (!LoaderViewModel.class.isInstance(parambh))
        {
          parambh = localbg.a.a();
          localbg.b.a(str, parambh);
        }
        return (LoaderViewModel)parambh;
      }
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    
    public final void a()
    {
      super.a();
      int j = this.b.b();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.a)this.b.d(i)).d();
        i += 1;
      }
      eh localeh = this.b;
      j = localeh.d;
      Object[] arrayOfObject = localeh.c;
      i = 0;
      while (i < j)
      {
        arrayOfObject[i] = null;
        i += 1;
      }
      localeh.d = 0;
      localeh.a = false;
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter)
    {
      if (this.b.b() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("    ");
        localObject = ((StringBuilder)localObject).toString();
        int i = 0;
        while (i < this.b.b())
        {
          LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.b.d(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.b.c(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(locala.toString());
          locala.a((String)localObject, paramPrintWriter);
          i += 1;
        }
      }
    }
    
    public final void b()
    {
      int j = this.b.b();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.a)this.b.d(i)).c();
        i += 1;
      }
    }
  }
  
  public static final class a<D>
    extends bb<D>
    implements ct.a<D>
  {
    private final int e;
    private final Bundle f;
    private final ct<D> g;
    private aw h;
    private LoaderManagerImpl.b<D> i;
    private ct<D> j;
    
    public final void a()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Starting: ").append(this);
      }
      ct localct = this.g;
      localct.c = true;
      localct.e = false;
      localct.d = false;
    }
    
    public final void a(bc<D> parambc)
    {
      super.a(parambc);
      this.h = null;
      this.i = null;
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.f);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.g);
      Object localObject1 = this.g;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("  ");
      localObject2 = ((StringBuilder)localObject2).toString();
      paramPrintWriter.print((String)localObject2);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(((ct)localObject1).a);
      paramPrintWriter.print(" mListener=");
      paramPrintWriter.println(((ct)localObject1).b);
      if ((((ct)localObject1).c) || (((ct)localObject1).f) || (((ct)localObject1).g))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(((ct)localObject1).c);
        paramPrintWriter.print(" mContentChanged=");
        paramPrintWriter.print(((ct)localObject1).f);
        paramPrintWriter.print(" mProcessingChange=");
        paramPrintWriter.println(((ct)localObject1).g);
      }
      if ((((ct)localObject1).d) || (((ct)localObject1).e))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mAbandoned=");
        paramPrintWriter.print(((ct)localObject1).d);
        paramPrintWriter.print(" mReset=");
        paramPrintWriter.println(((ct)localObject1).e);
      }
      if (this.i != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(this.i);
        localObject1 = this.i;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("  ");
        paramPrintWriter.print(((StringBuilder)localObject2).toString());
        paramPrintWriter.print("mDeliveredData=");
        paramPrintWriter.println(((LoaderManagerImpl.b)localObject1).b);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      localObject1 = this.d;
      if (localObject1 == LiveData.a) {
        localObject1 = null;
      }
      paramPrintWriter.println(ct.a(localObject1));
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      boolean bool;
      if (this.c > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramPrintWriter.println(bool);
    }
    
    public final void b()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.g.c = false;
    }
    
    final void c()
    {
      aw localaw = this.h;
      Object localObject = this.i;
      if ((localaw != null) && (localObject != null))
      {
        super.a((bc)localObject);
        if (localaw.getLifecycle().a() != au.b.a)
        {
          LiveData.LifecycleBoundObserver localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, localaw, (bc)localObject);
          localObject = (LiveData.a)this.b.a(localObject, localLifecycleBoundObserver);
          if ((localObject != null) && (!((LiveData.a)localObject).a(localaw))) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
          }
          if (localObject == null) {
            localaw.getLifecycle().a(localLifecycleBoundObserver);
          }
        }
      }
    }
    
    final ct<D> d()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Destroying: ").append(this);
      }
      this.g.d = true;
      Object localObject = this.i;
      if (localObject != null)
      {
        a((bc)localObject);
        if ((((LoaderManagerImpl.b)localObject).b) && (LoaderManagerImpl.a)) {
          new StringBuilder("  Resetting: ").append(((LoaderManagerImpl.b)localObject).a);
        }
      }
      localObject = this.g;
      if (((ct)localObject).b != null)
      {
        if (((ct)localObject).b == this)
        {
          ((ct)localObject).b = null;
          localObject = this.g;
          ((ct)localObject).e = true;
          ((ct)localObject).c = false;
          ((ct)localObject).d = false;
          ((ct)localObject).f = false;
          ((ct)localObject).g = false;
          return this.j;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
      }
      throw new IllegalStateException("No listener register");
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" : ");
      dy.a(this.g, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements bc<D>
  {
    final ct<D> a;
    boolean b;
    private final ci.a<D> c;
    
    public final void a(D paramD)
    {
      if (LoaderManagerImpl.a)
      {
        StringBuilder localStringBuilder = new StringBuilder("  onLoadFinished in ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(": ");
        localStringBuilder.append(ct.a(paramD));
      }
      this.b = true;
    }
    
    public final String toString()
    {
      return this.c.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */