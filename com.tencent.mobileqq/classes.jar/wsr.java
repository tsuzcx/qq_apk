import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class wsr
  extends wsw
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<wsz> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public wsz a;
  
  public wsr(Handler paramHandler)
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
  
  public wsr a(wsx paramwsx)
  {
    this.jdField_a_of_type_Wsx = paramwsx;
    return this;
  }
  
  public wsr a(wsy paramwsy)
  {
    this.jdField_a_of_type_Wsy = paramwsy;
    return this;
  }
  
  public wsr a(wsz paramwsz)
  {
    wxe.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramwsz.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramwsz);
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
    if (this.jdField_a_of_type_Wsy != null) {
      this.jdField_a_of_type_Wsy.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Wsz.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Wsz.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        wxe.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Wsz.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Wsz.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        wxe.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Wsz.a() + ",return null result");
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
      wxe.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Wsz != null)
      {
        this.jdField_a_of_type_Wsz.c();
        this.jdField_a_of_type_Wsz.a(null);
        this.jdField_a_of_type_Wsz.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Wsy = null;
      this.jdField_a_of_type_Wsx = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsr
 * JD-Core Version:    0.7.0.1
 */