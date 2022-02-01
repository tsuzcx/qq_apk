import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import java.lang.reflect.Field;

public class aqnc<T>
  extends Animation
{
  static final aqnc.b a;
  static final aqnc.b b = new aqne();
  static final aqnc.b jdField_c_of_type_Aqnc$b = new aqnf();
  static final aqnc.b d = new aqng();
  static final aqnc.b e = new aqnh();
  protected aqnc.a<T> a;
  private long ato;
  private Pair[] jdField_c_of_type_ArrayOfAndroidUtilPair;
  protected boolean cUF;
  protected boolean cUG;
  protected aqnc.b<T> f;
  protected T ft;
  protected T fu;
  protected boolean mIsCancelled;
  protected boolean mIsPaused;
  
  static
  {
    jdField_a_of_type_Aqnc$b = new aqnd();
  }
  
  public aqnc(T paramT1, T paramT2, aqnc.a<T> parama)
  {
    this(paramT1, paramT2, parama, false, false, null);
  }
  
  public aqnc(T paramT1, T paramT2, aqnc.a<T> parama, boolean paramBoolean1, boolean paramBoolean2, aqnc.b<T> paramb)
  {
    Class localClass = paramT1.getClass();
    if (paramb != null) {
      this.f = paramb;
    }
    for (;;)
    {
      this.ft = paramT1;
      this.fu = paramT2;
      a(parama);
      this.cUF = paramBoolean1;
      this.cUG = paramBoolean2;
      return;
      if (localClass == Integer.class)
      {
        this.f = jdField_a_of_type_Aqnc$b;
      }
      else if (Float.class == localClass)
      {
        this.f = b;
      }
      else if (Rect.class == localClass)
      {
        this.f = jdField_c_of_type_Aqnc$b;
      }
      else if (Point.class == localClass)
      {
        this.f = d;
      }
      else
      {
        if (PointF.class != localClass) {
          break;
        }
        this.f = e;
      }
    }
    throw new IllegalArgumentException("Can't support type " + paramT1.getClass().getSimpleName());
  }
  
  public void a(aqnc.a<T> parama)
  {
    this.jdField_a_of_type_Aqnc$a = parama;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_Aqnc$a != null) {
      this.jdField_a_of_type_Aqnc$a.a(this, paramFloat, this.f.evaluate(paramFloat, this.ft, this.fu), paramTransformation);
    }
  }
  
  public void cancel()
  {
    int i = 0;
    this.mIsCancelled = true;
    if (Build.VERSION.SDK_INT >= 8) {
      super.cancel();
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_ArrayOfAndroidUtilPair == null) {
        this.jdField_c_of_type_ArrayOfAndroidUtilPair = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
      }
      try
      {
        Object localObject1 = getClass().getDeclaredField("mListener");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        if ((localObject1 instanceof Animation.AnimationListener)) {
          ((Animation.AnimationListener)localObject1).onAnimationEnd(this);
        }
        localObject1 = getClass().getDeclaredField("mStartTime");
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).setLong(this, -9223372036854775808L);
        localObject1 = this.jdField_c_of_type_ArrayOfAndroidUtilPair;
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          Field localField = getClass().getDeclaredField((String)localObject2.first);
          localField.setAccessible(true);
          localField.setBoolean(this, ((Boolean)localObject2.second).booleanValue());
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.mIsPaused)
    {
      if (this.ato == 0L) {
        lZ(paramLong - getStartTime());
      }
      setStartTime(paramLong - this.ato);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void lZ(long paramLong)
  {
    this.ato = paramLong;
  }
  
  public void reset()
  {
    this.mIsCancelled = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.cUF;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.cUG;
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(aqnc<T> paramaqnc, float paramFloat, T paramT, Transformation paramTransformation);
  }
  
  static abstract interface b<T>
  {
    public abstract T evaluate(float paramFloat, T paramT1, T paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnc
 * JD-Core Version:    0.7.0.1
 */