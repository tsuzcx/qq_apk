import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

class ukl
  extends Drawable.ConstantState
{
  private long jdField_a_of_type_Long;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NonNull
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Error jdField_a_of_type_JavaLangError;
  @NonNull
  public final String a;
  private final CopyOnWriteArraySet<uko> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  @NonNull
  private ukp<Bitmap> jdField_a_of_type_Ukp;
  private volatile boolean jdField_a_of_type_Boolean;
  private String b = "story.icon.ShareGroupDrawableState";
  
  public ukl(String paramString, Context paramContext, Drawable paramDrawable)
  {
    if ((paramString == null) || (paramContext == null) || (paramDrawable == null)) {
      throw new IllegalArgumentException("params should not be null");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.b = (this.b + "[" + System.identityHashCode(this) + "]");
  }
  
  private void a(boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        uko localuko = (uko)localIterator.next();
        if (uko.a(localuko))
        {
          if (paramBoolean) {
            localuko.a(this);
          } else {
            localuko.b(this);
          }
        }
        else
        {
          ukj.a(this.b, "remove invalid callback %s", this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localuko);
        }
      }
    }
    throw new IllegalStateException("notifyCallBack should be at Main-Thread");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) || (paramBoolean))
    {
      ukj.a(this.b, "startLoad");
      this.jdField_a_of_type_Ukp.a(this).subscribe(new ukm(this));
    }
    while ((this.jdField_a_of_type_JavaLangError == null) || (Math.abs(this.jdField_a_of_type_Long - SystemClock.uptimeMillis()) <= 10000L)) {
      return;
    }
    ukj.b(this.b, "load again, oldError=%s", this.jdField_a_of_type_JavaLangError);
    this.jdField_a_of_type_JavaLangError = null;
    b(true);
  }
  
  Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    return null;
  }
  
  Error a()
  {
    return this.jdField_a_of_type_JavaLangError;
  }
  
  public void a()
  {
    ukj.b(this.b, "recycle");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ukn paramukn)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new uko(paramukn));
  }
  
  void a(@NonNull ukp<Bitmap> paramukp)
  {
    this.jdField_a_of_type_Ukp = paramukp;
  }
  
  public void b()
  {
    b(false);
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new ukq(this, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukl
 * JD-Core Version:    0.7.0.1
 */