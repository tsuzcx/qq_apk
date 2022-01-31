import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer;
import com.tencent.qphone.base.util.QLog;

public class usr
  implements Runnable
{
  private uss jdField_a_of_type_Uss;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public usr(LoadDataJob paramLoadDataJob, byte[] paramArrayOfByte, uss paramuss)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Uss = paramuss;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Uss == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_a_of_type_Uss.a(null);
      return;
    }
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a(this.jdField_a_of_type_ArrayOfByte);
      if (localObject != null)
      {
        localObject = (PathDrawer)PathDrawer.a.a((MyParcel)localObject);
        this.jdField_a_of_type_Uss.a((PathDrawer)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a);
      }
      this.jdField_a_of_type_Uss.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */