import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class yfr
{
  private static yfr jdField_a_of_type_Yfr;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static yfr a()
  {
    if (jdField_a_of_type_Yfr == null) {
      jdField_a_of_type_Yfr = new yfr();
    }
    return jdField_a_of_type_Yfr;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfr
 * JD-Core Version:    0.7.0.1
 */