import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.IDragViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class eoz
  implements Runnable
{
  public static final int a = 50;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private int b;
  
  public eoz(DragRelativeLayout paramDragRelativeLayout, PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
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
  
  public void run()
  {
    if (this.b == DragRelativeLayout.a().length)
    {
      if (this == DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout)) {
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
      }
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
      if (DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout) == 2)
      {
        List localList = DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout).a();
        if ((DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout) != null) && (localList.size() > 0))
        {
          DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, 5);
          DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, new eoy(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, localList));
          DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.invalidate();
      return;
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, true);
      break;
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, true);
      break;
      this.b += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoz
 * JD-Core Version:    0.7.0.1
 */