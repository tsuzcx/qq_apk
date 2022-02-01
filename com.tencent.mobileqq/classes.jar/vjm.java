import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class vjm
{
  private final HashMap<View, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      return;
    }
    c();
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localView, Integer.valueOf(localView.getVisibility()));
        localView.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(localView) != null)) {
        localView.setVisibility(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localView)).intValue());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        b();
        if (!this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          return;
          bool = false;
        }
      } while (this.jdField_a_of_type_Boolean);
      c();
      this.jdField_a_of_type_Boolean = true;
      return;
    } while (!this.jdField_a_of_type_Boolean);
    d();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramView, Integer.valueOf(paramView.getVisibility()));
  }
  
  public void a(QCircleContentImmersiveEvent paramQCircleContentImmersiveEvent)
  {
    a(paramQCircleContentImmersiveEvent.getState());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjm
 * JD-Core Version:    0.7.0.1
 */