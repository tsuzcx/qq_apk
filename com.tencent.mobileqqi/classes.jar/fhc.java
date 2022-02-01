import com.tencent.mobileqq.app.ThreadManager;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class fhc
  implements Executor
{
  Runnable jdField_a_of_type_JavaLangRunnable;
  final Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        ThreadManager.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(new fhd(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fhc
 * JD-Core Version:    0.7.0.1
 */