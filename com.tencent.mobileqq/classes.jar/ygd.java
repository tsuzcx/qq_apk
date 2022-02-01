import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ygd
  extends ygi
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<ygl> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public ygl a;
  
  public ygd(Handler paramHandler)
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
  
  public ygd a(ygj paramygj)
  {
    this.jdField_a_of_type_Ygj = paramygj;
    return this;
  }
  
  public ygd a(ygk paramygk)
  {
    this.jdField_a_of_type_Ygk = paramygk;
    return this;
  }
  
  public ygd a(ygl paramygl)
  {
    ykq.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramygl.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramygl);
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
    if (this.jdField_a_of_type_Ygk != null) {
      this.jdField_a_of_type_Ygk.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Ygl.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Ygl.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        ykq.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Ygl.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Ygl.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        ykq.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Ygl.a() + ",return null result");
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
      ykq.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Ygl != null)
      {
        this.jdField_a_of_type_Ygl.c();
        this.jdField_a_of_type_Ygl.a(null);
        this.jdField_a_of_type_Ygl.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Ygk = null;
      this.jdField_a_of_type_Ygj = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygd
 * JD-Core Version:    0.7.0.1
 */