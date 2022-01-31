import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yqj
{
  public View a;
  private WeakReference<yqk> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<yqk>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private int a(WeakReference<yqk> paramWeakReference)
  {
    int j;
    if ((paramWeakReference == null) || (paramWeakReference.get() == null))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label71;
      }
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localWeakReference != null)
      {
        j = i;
        if (localWeakReference.get() == paramWeakReference.get()) {
          break;
        }
      }
      i += 1;
    }
    label71:
    return -1;
  }
  
  private yqk a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (yqk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private void a()
  {
    if (a() != null) {
      a().b();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  private boolean b(WeakReference<yqk> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    while (a(paramWeakReference) != -1) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramWeakReference);
    return true;
  }
  
  private boolean c(WeakReference<yqk> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    int i;
    do
    {
      return false;
      i = a(paramWeakReference);
    } while (i == -1);
    this.jdField_a_of_type_JavaUtilList.remove(i);
    return true;
  }
  
  public void a(WeakReference<yqk> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == a()))
    {
      yny.a("GdtVideoCommonView", "MutiVideoManager play return: " + paramWeakReference);
      return;
    }
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    b(paramWeakReference);
  }
  
  public boolean a(WeakReference<yqk> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    do
    {
      return false;
      c(paramWeakReference);
    } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
    paramWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.iterator().next();
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((yqk)paramWeakReference.get()).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */