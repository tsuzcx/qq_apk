import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ypx
  extends yqc
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<yqf> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public yqf a;
  
  public ypx(Handler paramHandler)
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
  
  public ypx a(yqd paramyqd)
  {
    this.jdField_a_of_type_Yqd = paramyqd;
    return this;
  }
  
  public ypx a(yqe paramyqe)
  {
    this.jdField_a_of_type_Yqe = paramyqe;
    return this;
  }
  
  public ypx a(yqf paramyqf)
  {
    yuk.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramyqf.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramyqf);
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
    if (this.jdField_a_of_type_Yqe != null) {
      this.jdField_a_of_type_Yqe.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Yqf.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Yqf.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        yuk.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Yqf.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Yqf.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        yuk.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Yqf.a() + ",return null result");
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
      yuk.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Yqf != null)
      {
        this.jdField_a_of_type_Yqf.c();
        this.jdField_a_of_type_Yqf.a(null);
        this.jdField_a_of_type_Yqf.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Yqe = null;
      this.jdField_a_of_type_Yqd = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypx
 * JD-Core Version:    0.7.0.1
 */