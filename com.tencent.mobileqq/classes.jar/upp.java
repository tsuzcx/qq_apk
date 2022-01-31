import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer;
import com.tencent.qphone.base.util.QLog;

public class upp
  implements Runnable
{
  private upq jdField_a_of_type_Upq;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public upp(LoadDataJob paramLoadDataJob, byte[] paramArrayOfByte, upq paramupq)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Upq = paramupq;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Upq == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_a_of_type_Upq.a(null);
      return;
    }
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a(this.jdField_a_of_type_ArrayOfByte);
      if (localObject != null)
      {
        localObject = (PathDrawer)PathDrawer.a.a((MyParcel)localObject);
        this.jdField_a_of_type_Upq.a((PathDrawer)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnmarshallJob", 2, "unmarshall  exception:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a);
      }
      this.jdField_a_of_type_Upq.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upp
 * JD-Core Version:    0.7.0.1
 */