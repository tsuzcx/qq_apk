import com.tencent.mobileqq.app.ThreadOptimizer;
import java.util.concurrent.ThreadFactory;

public class zjv
  implements ThreadFactory
{
  public int a;
  public String a;
  public volatile int b;
  
  public zjv(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    this.b += 1;
    if (this.b > 10000) {
      this.b = 0;
    }
    paramRunnable = new Thread(paramRunnable, this.jdField_a_of_type_JavaLangString + "-" + this.b);
    if (ThreadOptimizer.a().c())
    {
      paramRunnable.setPriority(1);
      return paramRunnable;
    }
    paramRunnable.setPriority(this.jdField_a_of_type_Int);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjv
 * JD-Core Version:    0.7.0.1
 */