package android.support.v4.app;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveData.LifecycleBoundObserver;
import android.arch.lifecycle.LiveData.a;
import android.os.Bundle;
import com.tencent.token.bf;
import com.tencent.token.bj;
import com.tencent.token.bj.b;
import com.tencent.token.bm;
import com.tencent.token.br;
import com.tencent.token.bs;
import com.tencent.token.bx;
import com.tencent.token.by;
import com.tencent.token.by.a;
import com.tencent.token.bz;
import com.tencent.token.cz;
import com.tencent.token.cz.a;
import com.tencent.token.dk;
import com.tencent.token.dk.a;
import com.tencent.token.ep;
import com.tencent.token.ey;
import java.io.PrintWriter;
import java.util.HashMap;

public final class LoaderManagerImpl
  extends cz
{
  static boolean a = false;
  public final LoaderViewModel b;
  private final bm c;
  
  LoaderManagerImpl(bm parambm, bz parambz)
  {
    this.c = parambm;
    this.b = LoaderViewModel.a(parambz);
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
    ep.a(this.c, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class LoaderViewModel
    extends bx
  {
    private static final by.a a = new by.a()
    {
      public final <T extends bx> T a()
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    private ey<LoaderManagerImpl.a> b = new ey();
    
    static LoaderViewModel a(bz parambz)
    {
      by localby = new by(parambz, a);
      parambz = LoaderViewModel.class.getCanonicalName();
      if (parambz != null)
      {
        String str = "android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(parambz));
        parambz = (bx)localby.b.a.get(str);
        if (!LoaderViewModel.class.isInstance(parambz))
        {
          parambz = localby.a.a();
          localby.b.a(str, parambz);
        }
        return (LoaderViewModel)parambz;
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
      ey localey = this.b;
      j = localey.d;
      Object[] arrayOfObject = localey.c;
      i = 0;
      while (i < j)
      {
        arrayOfObject[i] = null;
        i += 1;
      }
      localey.d = 0;
      localey.a = false;
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
    extends br<D>
    implements dk.a<D>
  {
    private final int e;
    private final Bundle f;
    private final dk<D> g;
    private bm h;
    private LoaderManagerImpl.b<D> i;
    private dk<D> j;
    
    public final void a()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Starting: ").append(this);
      }
      dk localdk = this.g;
      localdk.c = true;
      localdk.e = false;
      localdk.d = false;
    }
    
    public final void a(bs<D> parambs)
    {
      super.a(parambs);
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
      paramPrintWriter.print(((dk)localObject1).a);
      paramPrintWriter.print(" mListener=");
      paramPrintWriter.println(((dk)localObject1).b);
      if ((((dk)localObject1).c) || (((dk)localObject1).f) || (((dk)localObject1).g))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(((dk)localObject1).c);
        paramPrintWriter.print(" mContentChanged=");
        paramPrintWriter.print(((dk)localObject1).f);
        paramPrintWriter.print(" mProcessingChange=");
        paramPrintWriter.println(((dk)localObject1).g);
      }
      if ((((dk)localObject1).d) || (((dk)localObject1).e))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mAbandoned=");
        paramPrintWriter.print(((dk)localObject1).d);
        paramPrintWriter.print(" mReset=");
        paramPrintWriter.println(((dk)localObject1).e);
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
      paramPrintWriter.println(dk.a(localObject1));
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
      bm localbm = this.h;
      Object localObject = this.i;
      if ((localbm != null) && (localObject != null))
      {
        super.a((bs)localObject);
        if (localbm.getLifecycle().a() != bj.b.a)
        {
          LiveData.LifecycleBoundObserver localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, localbm, (bs)localObject);
          localObject = (LiveData.a)this.b.a(localObject, localLifecycleBoundObserver);
          if ((localObject != null) && (!((LiveData.a)localObject).a(localbm))) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
          }
          if (localObject == null) {
            localbm.getLifecycle().a(localLifecycleBoundObserver);
          }
        }
      }
    }
    
    final dk<D> d()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Destroying: ").append(this);
      }
      this.g.d = true;
      Object localObject = this.i;
      if (localObject != null)
      {
        a((bs)localObject);
        if ((((LoaderManagerImpl.b)localObject).b) && (LoaderManagerImpl.a)) {
          new StringBuilder("  Resetting: ").append(((LoaderManagerImpl.b)localObject).a);
        }
      }
      localObject = this.g;
      if (((dk)localObject).b != null)
      {
        if (((dk)localObject).b == this)
        {
          ((dk)localObject).b = null;
          localObject = this.g;
          ((dk)localObject).e = true;
          ((dk)localObject).c = false;
          ((dk)localObject).d = false;
          ((dk)localObject).f = false;
          ((dk)localObject).g = false;
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
      ep.a(this.g, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements bs<D>
  {
    final dk<D> a;
    boolean b;
    private final cz.a<D> c;
    
    public final void a(D paramD)
    {
      if (LoaderManagerImpl.a)
      {
        StringBuilder localStringBuilder = new StringBuilder("  onLoadFinished in ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(": ");
        localStringBuilder.append(dk.a(paramD));
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