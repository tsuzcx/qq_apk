package android.support.v4.app;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveData.LifecycleBoundObserver;
import android.arch.lifecycle.LiveData.a;
import android.os.Bundle;
import com.tencent.token.ar;
import com.tencent.token.av;
import com.tencent.token.av.b;
import com.tencent.token.ay;
import com.tencent.token.bd;
import com.tencent.token.be;
import com.tencent.token.bj;
import com.tencent.token.bk;
import com.tencent.token.bk.a;
import com.tencent.token.bl;
import com.tencent.token.cl;
import com.tencent.token.cl.a;
import com.tencent.token.cw;
import com.tencent.token.cw.a;
import com.tencent.token.eb;
import com.tencent.token.ek;
import java.io.PrintWriter;
import java.util.HashMap;

public final class LoaderManagerImpl
  extends cl
{
  static boolean a = false;
  public final LoaderViewModel b;
  private final ay c;
  
  LoaderManagerImpl(ay paramay, bl parambl)
  {
    this.c = paramay;
    this.b = LoaderViewModel.a(parambl);
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
    eb.a(this.c, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class LoaderViewModel
    extends bj
  {
    private static final bk.a a = new bk.a()
    {
      public final <T extends bj> T a()
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    private ek<LoaderManagerImpl.a> b = new ek();
    
    static LoaderViewModel a(bl parambl)
    {
      bk localbk = new bk(parambl, a);
      parambl = LoaderViewModel.class.getCanonicalName();
      if (parambl != null)
      {
        String str = "android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(parambl));
        parambl = (bj)localbk.b.a.get(str);
        if (!LoaderViewModel.class.isInstance(parambl))
        {
          parambl = localbk.a.a();
          localbk.b.a(str, parambl);
        }
        return (LoaderViewModel)parambl;
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
      ek localek = this.b;
      j = localek.d;
      Object[] arrayOfObject = localek.c;
      i = 0;
      while (i < j)
      {
        arrayOfObject[i] = null;
        i += 1;
      }
      localek.d = 0;
      localek.a = false;
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
    extends bd<D>
    implements cw.a<D>
  {
    private final int e;
    private final Bundle f;
    private final cw<D> g;
    private ay h;
    private LoaderManagerImpl.b<D> i;
    private cw<D> j;
    
    public final void a()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Starting: ").append(this);
      }
      cw localcw = this.g;
      localcw.c = true;
      localcw.e = false;
      localcw.d = false;
    }
    
    public final void a(be<D> parambe)
    {
      super.a(parambe);
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
      paramPrintWriter.print(((cw)localObject1).a);
      paramPrintWriter.print(" mListener=");
      paramPrintWriter.println(((cw)localObject1).b);
      if ((((cw)localObject1).c) || (((cw)localObject1).f) || (((cw)localObject1).g))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(((cw)localObject1).c);
        paramPrintWriter.print(" mContentChanged=");
        paramPrintWriter.print(((cw)localObject1).f);
        paramPrintWriter.print(" mProcessingChange=");
        paramPrintWriter.println(((cw)localObject1).g);
      }
      if ((((cw)localObject1).d) || (((cw)localObject1).e))
      {
        paramPrintWriter.print((String)localObject2);
        paramPrintWriter.print("mAbandoned=");
        paramPrintWriter.print(((cw)localObject1).d);
        paramPrintWriter.print(" mReset=");
        paramPrintWriter.println(((cw)localObject1).e);
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
      paramPrintWriter.println(cw.a(localObject1));
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
      ay localay = this.h;
      Object localObject = this.i;
      if ((localay != null) && (localObject != null))
      {
        super.a((be)localObject);
        if (localay.getLifecycle().a() != av.b.a)
        {
          LiveData.LifecycleBoundObserver localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, localay, (be)localObject);
          localObject = (LiveData.a)this.b.a(localObject, localLifecycleBoundObserver);
          if ((localObject != null) && (!((LiveData.a)localObject).a(localay))) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
          }
          if (localObject == null) {
            localay.getLifecycle().a(localLifecycleBoundObserver);
          }
        }
      }
    }
    
    final cw<D> d()
    {
      if (LoaderManagerImpl.a) {
        new StringBuilder("  Destroying: ").append(this);
      }
      this.g.d = true;
      Object localObject = this.i;
      if (localObject != null)
      {
        a((be)localObject);
        if ((((LoaderManagerImpl.b)localObject).b) && (LoaderManagerImpl.a)) {
          new StringBuilder("  Resetting: ").append(((LoaderManagerImpl.b)localObject).a);
        }
      }
      localObject = this.g;
      if (((cw)localObject).b != null)
      {
        if (((cw)localObject).b == this)
        {
          ((cw)localObject).b = null;
          localObject = this.g;
          ((cw)localObject).e = true;
          ((cw)localObject).c = false;
          ((cw)localObject).d = false;
          ((cw)localObject).f = false;
          ((cw)localObject).g = false;
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
      eb.a(this.g, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements be<D>
  {
    final cw<D> a;
    boolean b;
    private final cl.a<D> c;
    
    public final void a(D paramD)
    {
      if (LoaderManagerImpl.a)
      {
        StringBuilder localStringBuilder = new StringBuilder("  onLoadFinished in ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(": ");
        localStringBuilder.append(cw.a(paramD));
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