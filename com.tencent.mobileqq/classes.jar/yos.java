import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class yos
{
  private static yos jdField_a_of_type_Yos;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static yos a()
  {
    if (jdField_a_of_type_Yos == null) {
      jdField_a_of_type_Yos = new yos();
    }
    return jdField_a_of_type_Yos;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yos
 * JD-Core Version:    0.7.0.1
 */