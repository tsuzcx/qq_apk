package android.arch.lifecycle;

import com.tencent.token.an;
import com.tencent.token.ap;
import com.tencent.token.ar;
import com.tencent.token.av;
import com.tencent.token.av.a;
import com.tencent.token.av.b;
import com.tencent.token.ay;
import com.tencent.token.be;

public abstract class LiveData<T>
{
  protected static final Object a = new Object();
  protected ar<be<T>, LiveData<T>.a> b;
  protected int c;
  protected volatile Object d;
  private int e;
  private boolean f;
  private boolean g;
  
  private void a(LiveData<T>.a paramLiveData)
  {
    if (!paramLiveData.d) {
      return;
    }
    if (!paramLiveData.a())
    {
      paramLiveData.a(false);
      return;
    }
    int i = paramLiveData.e;
    int j = this.e;
    if (i >= j) {
      return;
    }
    paramLiveData.e = j;
    paramLiveData.c.a(this.d);
  }
  
  protected void a() {}
  
  public void a(be<T> parambe)
  {
    if (an.a().a.b())
    {
      parambe = (a)this.b.b(parambe);
      if (parambe == null) {
        return;
      }
      parambe.b();
      parambe.a(false);
      return;
    }
    parambe = new StringBuilder("Cannot invoke ");
    parambe.append("removeObserver");
    parambe.append(" on a background thread");
    throw new IllegalStateException(parambe.toString());
  }
  
  protected void b() {}
  
  public class LifecycleBoundObserver
    extends LiveData<T>.a
    implements GenericLifecycleObserver
  {
    final ay a;
    
    public LifecycleBoundObserver(be<T> parambe)
    {
      super(localbe);
      this.a = parambe;
    }
    
    public final void a(ay paramay, av.a parama)
    {
      if (this.a.getLifecycle().a() == av.b.a)
      {
        LiveData.this.a(this.c);
        return;
      }
      a(a());
    }
    
    final boolean a()
    {
      return this.a.getLifecycle().a().a(av.b.d);
    }
    
    final boolean a(ay paramay)
    {
      return this.a == paramay;
    }
    
    final void b()
    {
      this.a.getLifecycle().b(this);
    }
  }
  
  public abstract class a
  {
    final be<T> c;
    boolean d;
    int e = -1;
    
    a()
    {
      Object localObject;
      this.c = localObject;
    }
    
    final void a(boolean paramBoolean)
    {
      if (paramBoolean == this.d) {
        return;
      }
      this.d = paramBoolean;
      int i = LiveData.a(LiveData.this);
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      LiveData localLiveData = LiveData.this;
      int k = LiveData.a(localLiveData);
      if (!this.d) {
        j = -1;
      }
      LiveData.a(localLiveData, k + j);
      if ((i != 0) && (this.d)) {
        LiveData.this.a();
      }
      if ((LiveData.a(LiveData.this) == 0) && (!this.d)) {
        LiveData.this.b();
      }
      if (this.d) {
        LiveData.a(LiveData.this, this);
      }
    }
    
    abstract boolean a();
    
    public boolean a(ay paramay)
    {
      return false;
    }
    
    void b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */