import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer;
import java.util.List;

public class upn
  implements upq
{
  public upn(LoadDataJob paramLoadDataJob, List paramList) {}
  
  public void a(PathDrawer paramPathDrawer)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramPathDrawer);
      if (this.jdField_a_of_type_JavaUtilList.size() == LoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob)) {
        this.jdField_a_of_type_JavaUtilList.notifyAll();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upn
 * JD-Core Version:    0.7.0.1
 */