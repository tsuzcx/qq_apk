import com.tencent.av.VideoController;
import com.tencent.av.thread.ThreadPool.Job;
import com.tencent.av.thread.ThreadPool.JobContext;

public class bgi
  implements ThreadPool.Job
{
  public bgi(VideoController paramVideoController, Runnable paramRunnable) {}
  
  public Boolean a(ThreadPool.JobContext paramJobContext)
  {
    this.jdField_a_of_type_JavaLangRunnable.run();
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgi
 * JD-Core Version:    0.7.0.1
 */