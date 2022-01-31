import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

public class zkh
  implements Runnable
{
  public zkh(ThreadExcutor paramThreadExcutor, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean) {}
  
  public void run()
  {
    Job localJob = ThreadExcutor.a(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, this.jdField_a_of_type_Boolean);
    if (localJob == null)
    {
      QLog.e("ThreadManager", 1, "postDownLoadTask -1:w == null" + this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    localJob.b = 5;
    ThreadExcutor.c(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).a();
    ThreadExcutor.c(this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor).execute(localJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkh
 * JD-Core Version:    0.7.0.1
 */