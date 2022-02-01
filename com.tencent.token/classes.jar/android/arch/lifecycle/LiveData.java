package android.arch.lifecycle;

import com.tencent.token.an;
import com.tencent.token.ap;
import com.tencent.token.ar;
import com.tencent.token.au;
import com.tencent.token.au.a;
import com.tencent.token.au.b;
import com.tencent.token.aw;
import com.tencent.token.bc;

public abstract class LiveData<T>
{
  protected static final Object a = new Object();
  protected ar<bc<T>, LiveData<T>.a> b;
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
  
  public void a(bc<T> parambc)
  {
    if (an.a().a.b())
    {
      parambc = (a)this.b.b(parambc);
      if (parambc == null) {
        return;
      }
      parambc.b();
      parambc.a(false);
      return;
    }
    parambc = new StringBuilder("Cannot invoke ");
    parambc.append("removeObserver");
    parambc.append(" on a background thread");
    throw new IllegalStateException(parambc.toString());
  }
  
  protected void b() {}
  
  public class LifecycleBoundObserver
    extends LiveData<T>.a
    implements GenericLifecycleObserver
  {
    final aw a;
    
    public LifecycleBoundObserver(bc<T> parambc)
    {
      super(localbc);
      this.a = parambc;
    }
    
    public final void a(aw paramaw, au.a parama)
    {
      if (this.a.getLifecycle().a() == au.b.a)
      {
        LiveData.this.a(this.c);
        return;
      }
      a(a());
    }
    
    final boolean a()
    {
      return this.a.getLifecycle().a().a(au.b.d);
    }
    
    final boolean a(aw paramaw)
    {
      return this.a == paramaw;
    }
    
    final void b()
    {
      this.a.getLifecycle().b(this);
    }
  }
  
  public abstract class a
  {
    final bc<T> c;
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
    
    public boolean a(aw paramaw)
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