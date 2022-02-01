import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.Stream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

class qpd
  extends Drawable.ConstantState
{
  private long Bg;
  private String TAG = "story.icon.ShareGroupDrawableState";
  private Error jdField_a_of_type_JavaLangError;
  @NonNull
  private qpd.c<Bitmap> jdField_a_of_type_Qpd$c;
  private volatile boolean aEC;
  private AtomicBoolean aV = new AtomicBoolean(false);
  private final CopyOnWriteArraySet<qpd.b> c = new CopyOnWriteArraySet();
  @NonNull
  public final String cacheKey;
  @NonNull
  private Context context;
  private Bitmap cs;
  @NonNull
  private Drawable defaultDrawable;
  
  public qpd(String paramString, Context paramContext, Drawable paramDrawable)
  {
    if ((paramString == null) || (paramContext == null) || (paramDrawable == null)) {
      throw new IllegalArgumentException("params should not be null");
    }
    this.cacheKey = paramString;
    this.context = paramContext;
    this.defaultDrawable = paramDrawable;
    this.TAG = (this.TAG + "[" + System.identityHashCode(this) + "]");
  }
  
  private void sV(boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        qpd.b localb = (qpd.b)localIterator.next();
        if (qpd.b.a(localb))
        {
          if (paramBoolean) {
            localb.a(this);
          } else {
            localb.b(this);
          }
        }
        else
        {
          qpb.b(this.TAG, "remove invalid callback %s", this.c);
          this.c.remove(localb);
        }
      }
    }
    throw new IllegalStateException("notifyCallBack should be at Main-Thread");
  }
  
  private void sW(boolean paramBoolean)
  {
    if ((!this.aV.getAndSet(true)) || (paramBoolean))
    {
      qpb.d(this.TAG, "startLoad");
      this.jdField_a_of_type_Qpd$c.a(this).subscribe(new qpe(this));
    }
    while ((this.jdField_a_of_type_JavaLangError == null) || (Math.abs(this.Bg - SystemClock.uptimeMillis()) <= 10000L)) {
      return;
    }
    qpb.c(this.TAG, "load again, oldError=%s", this.jdField_a_of_type_JavaLangError);
    this.jdField_a_of_type_JavaLangError = null;
    sW(true);
  }
  
  Bitmap T()
  {
    return this.cs;
  }
  
  Error a()
  {
    return this.jdField_a_of_type_JavaLangError;
  }
  
  public void a(qpd.a parama)
  {
    this.c.add(new qpd.b(parama));
  }
  
  void a(@NonNull qpd.c<Bitmap> paramc)
  {
    this.jdField_a_of_type_Qpd$c = paramc;
  }
  
  public Drawable as()
  {
    if (this.cs != null) {
      return new BitmapDrawable(this.context.getResources(), this.cs);
    }
    return null;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new qpf(this, this.defaultDrawable);
  }
  
  public void recycle()
  {
    qpb.w(this.TAG, "recycle");
    this.aEC = true;
  }
  
  public void startLoad()
  {
    sW(false);
  }
  
  static abstract interface a
  {
    public abstract void a(@NonNull qpd paramqpd);
    
    public abstract void b(@NonNull qpd paramqpd);
  }
  
  static class b
    implements qpd.a
  {
    private final int bnu;
    @NonNull
    private final WeakReference<qpd.a> cY;
    
    public b(@NonNull qpd.a parama)
    {
      this.bnu = System.identityHashCode(parama);
      this.cY = new WeakReference(parama);
    }
    
    private boolean isValid()
    {
      return this.cY.get() != null;
    }
    
    public void a(@NonNull qpd paramqpd)
    {
      qpd.a locala = (qpd.a)this.cY.get();
      if (locala != null) {
        locala.a(paramqpd);
      }
    }
    
    public void b(@NonNull qpd paramqpd)
    {
      qpd.a locala = (qpd.a)this.cY.get();
      if (locala != null) {
        locala.b(paramqpd);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (((b)paramObject).bnu == this.bnu);
    }
    
    public int hashCode()
    {
      return this.bnu;
    }
  }
  
  static abstract interface c<T>
  {
    @NonNull
    public abstract Stream<T> a(qpd paramqpd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpd
 * JD-Core Version:    0.7.0.1
 */