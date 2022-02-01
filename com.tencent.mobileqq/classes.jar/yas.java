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

class yas
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
  private final CopyOnWriteArraySet<yav> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  @NonNull
  private yaw<Bitmap> jdField_a_of_type_Yaw;
  private volatile boolean jdField_a_of_type_Boolean;
  private String b = "story.icon.ShareGroupDrawableState";
  
  public yas(String paramString, Context paramContext, Drawable paramDrawable)
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
        yav localyav = (yav)localIterator.next();
        if (yav.a(localyav))
        {
          if (paramBoolean) {
            localyav.a(this);
          } else {
            localyav.b(this);
          }
        }
        else
        {
          yaq.a(this.b, "remove invalid callback %s", this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localyav);
        }
      }
    }
    throw new IllegalStateException("notifyCallBack should be at Main-Thread");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) || (paramBoolean))
    {
      yaq.a(this.b, "startLoad");
      this.jdField_a_of_type_Yaw.a(this).subscribe(new yat(this));
    }
    while ((this.jdField_a_of_type_JavaLangError == null) || (Math.abs(this.jdField_a_of_type_Long - SystemClock.uptimeMillis()) <= 10000L)) {
      return;
    }
    yaq.b(this.b, "load again, oldError=%s", this.jdField_a_of_type_JavaLangError);
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
    yaq.b(this.b, "recycle");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(yau paramyau)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new yav(paramyau));
  }
  
  void a(@NonNull yaw<Bitmap> paramyaw)
  {
    this.jdField_a_of_type_Yaw = paramyaw;
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
    return new yax(this, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yas
 * JD-Core Version:    0.7.0.1
 */