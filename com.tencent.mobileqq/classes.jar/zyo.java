import com.tencent.mobileqq.ar.ObjectBaseData;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class zyo
  implements Runnable
{
  public zyo(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData) {}
  
  public void run()
  {
    if (ObjectSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView).size() > 0)
    {
      ObjectSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView, this.jdField_a_of_type_ComTencentMobileqqArObjectBaseData.c);
      return;
    }
    QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyo
 * JD-Core Version:    0.7.0.1
 */