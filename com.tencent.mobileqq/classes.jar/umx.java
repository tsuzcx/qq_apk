import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class umx
  extends unc
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<unf> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public unf a;
  
  public umx(Handler paramHandler)
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
  
  public umx a(und paramund)
  {
    this.jdField_a_of_type_Und = paramund;
    return this;
  }
  
  public umx a(une paramune)
  {
    this.jdField_a_of_type_Une = paramune;
    return this;
  }
  
  public umx a(unf paramunf)
  {
    urk.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramunf.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramunf);
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
    if (this.jdField_a_of_type_Une != null) {
      this.jdField_a_of_type_Une.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Unf.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Unf.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        urk.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Unf.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Unf.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        urk.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Unf.a() + ",return null result");
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
      urk.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Unf != null)
      {
        this.jdField_a_of_type_Unf.c();
        this.jdField_a_of_type_Unf.a(null);
        this.jdField_a_of_type_Unf.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Une = null;
      this.jdField_a_of_type_Und = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umx
 * JD-Core Version:    0.7.0.1
 */