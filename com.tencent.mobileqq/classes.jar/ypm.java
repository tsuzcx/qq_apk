import android.view.View;
import com.tencent.gdtad.views.GdtViewStatus.1;
import java.lang.ref.WeakReference;

public class ypm
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<ypn> b;
  
  public ypm(WeakReference<View> paramWeakReference, WeakReference<ypn> paramWeakReference1)
  {
    this(paramWeakReference, paramWeakReference1, 0.0F);
  }
  
  public ypm(WeakReference<View> paramWeakReference, WeakReference<ypn> paramWeakReference1, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.b = paramWeakReference1;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.b.get() == null) || (paramBoolean == this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ((ypn)this.b.get()).a();
      return;
    }
    ((ypn)this.b.get()).b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 3;
    d();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).postDelayed(new GdtViewStatus.1(this), 500L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 2;
    d();
  }
  
  public void d()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      a(bool2);
      return;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_Boolean = false;
      }
      else if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          if (ypk.a((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()) > this.jdField_a_of_type_Float) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Boolean = bool1;
            break;
          }
        }
        this.jdField_a_of_type_Boolean = false;
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ypm
 * JD-Core Version:    0.7.0.1
 */