import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class xri
  extends xrn
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<xrq> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public xrq a;
  
  public xri(Handler paramHandler)
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
  
  public xri a(xro paramxro)
  {
    this.jdField_a_of_type_Xro = paramxro;
    return this;
  }
  
  public xri a(xrp paramxrp)
  {
    this.jdField_a_of_type_Xrp = paramxrp;
    return this;
  }
  
  public xri a(xrq paramxrq)
  {
    xvv.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramxrq.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramxrq);
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
    if (this.jdField_a_of_type_Xrp != null) {
      this.jdField_a_of_type_Xrp.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Xrq.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Xrq.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        xvv.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Xrq.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Xrq.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        xvv.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Xrq.a() + ",return null result");
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
      xvv.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Xrq != null)
      {
        this.jdField_a_of_type_Xrq.c();
        this.jdField_a_of_type_Xrq.a(null);
        this.jdField_a_of_type_Xrq.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Xrp = null;
      this.jdField_a_of_type_Xro = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */