package android.arch.lifecycle;

import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.bf;
import com.tencent.token.bj;
import com.tencent.token.bj.a;
import com.tencent.token.bj.b;
import com.tencent.token.bm;
import com.tencent.token.bs;

public abstract class LiveData<T>
{
  protected static final Object a = new Object();
  protected bf<bs<T>, LiveData<T>.a> b;
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
  
  public void a(bs<T> parambs)
  {
    if (bb.a().a.b())
    {
      parambs = (a)this.b.b(parambs);
      if (parambs == null) {
        return;
      }
      parambs.b();
      parambs.a(false);
      return;
    }
    parambs = new StringBuilder("Cannot invoke ");
    parambs.append("removeObserver");
    parambs.append(" on a background thread");
    throw new IllegalStateException(parambs.toString());
  }
  
  protected void b() {}
  
  public class LifecycleBoundObserver
    extends LiveData<T>.a
    implements GenericLifecycleObserver
  {
    final bm a;
    
    public LifecycleBoundObserver(bs<T> parambs)
    {
      super(localbs);
      this.a = parambs;
    }
    
    public final void a(bm parambm, bj.a parama)
    {
      if (this.a.getLifecycle().a() == bj.b.a)
      {
        LiveData.this.a(this.c);
        return;
      }
      a(a());
    }
    
    final boolean a()
    {
      return this.a.getLifecycle().a().a(bj.b.d);
    }
    
    final boolean a(bm parambm)
    {
      return this.a == parambm;
    }
    
    final void b()
    {
      this.a.getLifecycle().b(this);
    }
  }
  
  public abstract class a
  {
    final bs<T> c;
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
    
    public boolean a(bm parambm)
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