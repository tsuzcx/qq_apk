import com.tencent.mobileqq.activity.aio.doodle.DoodleParam;
import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class uxo
  implements Runnable
{
  public uxo(LoadDataJob paramLoadDataJob, DoodleParam paramDoodleParam, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel begin:");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam, LoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a, false));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a(this.jdField_a_of_type_JavaUtilList, LoadDataJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob.a, false)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((PathDrawer)localIterator.next()).b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel end:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxo
 * JD-Core Version:    0.7.0.1
 */