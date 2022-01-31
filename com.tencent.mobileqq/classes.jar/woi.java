import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class woi
  extends won
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<woq> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public woq a;
  
  public woi(Handler paramHandler)
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
  
  public woi a(woo paramwoo)
  {
    this.jdField_a_of_type_Woo = paramwoo;
    return this;
  }
  
  public woi a(wop paramwop)
  {
    this.jdField_a_of_type_Wop = paramwop;
    return this;
  }
  
  public woi a(woq paramwoq)
  {
    wsv.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramwoq.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramwoq);
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
    if (this.jdField_a_of_type_Wop != null) {
      this.jdField_a_of_type_Wop.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Woq.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Woq.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        wsv.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Woq.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Woq.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        wsv.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Woq.a() + ",return null result");
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
      wsv.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Woq != null)
      {
        this.jdField_a_of_type_Woq.c();
        this.jdField_a_of_type_Woq.a(null);
        this.jdField_a_of_type_Woq.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Wop = null;
      this.jdField_a_of_type_Woo = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woi
 * JD-Core Version:    0.7.0.1
 */