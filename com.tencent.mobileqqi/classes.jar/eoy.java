import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class eoy
  implements Runnable
{
  public static final int a = 40;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public eoy(DragRelativeLayout paramDragRelativeLayout, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    this.b = -1;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.b >= 0)
    {
      localObject1 = localObject2;
      if (this.b >= DragRelativeLayout.a().length) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.getResources(), DragRelativeLayout.a()[this.b]);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + localThrowable, localThrowable);
    }
    return null;
  }
  
  public PointF a()
  {
    PointF localPointF = new PointF();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(0);
      Rect localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.getGlobalVisibleRect(localRect);
      int i = localRect.left;
      int j = localRect.top;
      localView.getGlobalVisibleRect(localRect);
      localRect.left -= i;
      localRect.top -= j;
      localRect.right -= i;
      localRect.bottom -= j;
      localPointF.set(localRect.centerX(), localRect.centerY());
    }
    return localPointF;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      if (this == DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout)) {
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
      }
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.invalidate();
      return;
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(0);
      if (this.b == DragRelativeLayout.a().length)
      {
        this.jdField_a_of_type_JavaUtilList.remove(0);
        this.b = -1;
      }
      else
      {
        localView.setVisibility(4);
        this.b += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoy
 * JD-Core Version:    0.7.0.1
 */