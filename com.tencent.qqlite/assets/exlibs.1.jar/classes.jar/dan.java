import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.util.concurrent.Executor;

public class dan
  implements Executor
{
  final dap jdField_a_of_type_Dap = new dap(30);
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Dap.a();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Dap.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Dap.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_Dap.a(new dao(this, paramRunnable));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dan
 * JD-Core Version:    0.7.0.1
 */