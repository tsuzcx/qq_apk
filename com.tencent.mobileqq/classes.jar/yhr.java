import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class yhr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final List<yhs> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public yhr(View paramView)
  {
    this(paramView, false);
  }
  
  public yhr(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yhs localyhs = (yhs)localIterator.next();
      if (localyhs != null) {
        localyhs.a(paramInt);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yhs localyhs = (yhs)localIterator.next();
      if (localyhs != null) {
        localyhs.a();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  public void a(yhs paramyhs)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramyhs);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    if (this.b == 0) {
      this.b = i;
    }
    do
    {
      return;
      i = this.b - i;
      if ((!this.jdField_a_of_type_Boolean) && (i >= 250))
      {
        this.jdField_a_of_type_Boolean = true;
        a(i);
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) || (i >= 100));
    this.jdField_a_of_type_Boolean = false;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhr
 * JD-Core Version:    0.7.0.1
 */