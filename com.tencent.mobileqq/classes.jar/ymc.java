import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ymc
  extends ymh
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<ymk> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public ymk a;
  
  public ymc(Handler paramHandler)
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
  
  public ymc a(ymi paramymi)
  {
    this.jdField_a_of_type_Ymi = paramymi;
    return this;
  }
  
  public ymc a(ymj paramymj)
  {
    this.jdField_a_of_type_Ymj = paramymj;
    return this;
  }
  
  public ymc a(ymk paramymk)
  {
    yqp.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramymk.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramymk);
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
    if (this.jdField_a_of_type_Ymj != null) {
      this.jdField_a_of_type_Ymj.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Ymk.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Ymk.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        yqp.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Ymk.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Ymk.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        yqp.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Ymk.a() + ",return null result");
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
      yqp.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Ymk != null)
      {
        this.jdField_a_of_type_Ymk.c();
        this.jdField_a_of_type_Ymk.a(null);
        this.jdField_a_of_type_Ymk.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Ymj = null;
      this.jdField_a_of_type_Ymi = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymc
 * JD-Core Version:    0.7.0.1
 */