import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class yov
{
  private static yov jdField_a_of_type_Yov;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static yov a()
  {
    if (jdField_a_of_type_Yov == null) {
      jdField_a_of_type_Yov = new yov();
    }
    return jdField_a_of_type_Yov;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yov
 * JD-Core Version:    0.7.0.1
 */