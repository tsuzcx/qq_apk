import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

public class zkg
  implements Runnable
{
  public zkg(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, this.jdField_a_of_type_Boolean);
    if (localJob == null)
    {
      QLog.e("ThreadManager", 1, "post 3:w == null" + this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_Int >= 8)
    {
      localJob.b = 1;
      ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).execute(localJob);
      return;
    }
    localJob.b = 2;
    ThreadExcutor.b(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).a();
    ThreadExcutor.b(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).execute(localJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkg
 * JD-Core Version:    0.7.0.1
 */