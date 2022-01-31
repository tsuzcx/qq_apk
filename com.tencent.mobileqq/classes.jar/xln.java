import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class xln
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  
  public xln(DragFrameLayout paramDragFrameLayout, PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
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
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == DragFrameLayout.a().length)
    {
      if (this == DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout)) {
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
      }
      DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
      if (DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout) == 2) {
        if (DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout) == null) {
          break label221;
        }
      }
    }
    label221:
    for (List localList = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout).a();; localList = null)
    {
      if ((DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout) != null) && (localList != null) && (localList.size() > 0))
      {
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, 5);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, new xlm(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, localList));
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.invalidate();
        return;
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, true);
        break;
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, true);
        break;
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xln
 * JD-Core Version:    0.7.0.1
 */