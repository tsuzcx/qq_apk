import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class uzq
  extends uzv
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<uzy> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public uzy a;
  
  public uzq(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SerialStepExecutor.1(this));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public uzq a(uzw paramuzw)
  {
    this.jdField_a_of_type_Uzw = paramuzw;
    return this;
  }
  
  public uzq a(uzx paramuzx)
  {
    this.jdField_a_of_type_Uzx = paramuzx;
    return this;
  }
  
  public uzq a(uzy paramuzy)
  {
    ved.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramuzy.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramuzy);
    return this;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Int = 1;
      e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_Uzx != null) {
      this.jdField_a_of_type_Uzx.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Uzy.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Uzy.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        ved.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Uzy.a() + ",return null result");
      }
      e();
      return;
    }
    c();
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Uzy.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        ved.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Uzy.a() + ",return null result");
      }
      e();
      return;
    }
    finally {}
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Int = 2;
      ved.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Uzy != null)
      {
        this.jdField_a_of_type_Uzy.c();
        this.jdField_a_of_type_Uzy.a(null);
        this.jdField_a_of_type_Uzy.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Uzx = null;
      this.jdField_a_of_type_Uzw = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzq
 * JD-Core Version:    0.7.0.1
 */