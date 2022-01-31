import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class xlm
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList;
  
  public xlm(DragFrameLayout paramDragFrameLayout, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    this.jdField_a_of_type_Int = -1;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Int >= 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int >= DragFrameLayout.a().length) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getResources(), DragFrameLayout.a()[this.jdField_a_of_type_Int]);
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + localOutOfMemoryError, localOutOfMemoryError);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getGlobalVisibleRect(localRect);
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
      if (this == DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout)) {
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
      }
      DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.invalidate();
      return;
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(0);
      if (this.jdField_a_of_type_Int == DragFrameLayout.a().length)
      {
        this.jdField_a_of_type_JavaUtilList.remove(0);
        this.jdField_a_of_type_Int = -1;
      }
      else
      {
        localView.setVisibility(4);
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlm
 * JD-Core Version:    0.7.0.1
 */