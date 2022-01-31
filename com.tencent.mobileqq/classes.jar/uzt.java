import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class uzt
  extends uzy
{
  private volatile int jdField_a_of_type_Int = 0;
  protected Handler a;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "SerialStepExecutor";
  private ConcurrentLinkedQueue<vab> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public vab a;
  
  public uzt(Handler paramHandler)
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
  
  public uzt a(uzz paramuzz)
  {
    this.jdField_a_of_type_Uzz = paramuzz;
    return this;
  }
  
  public uzt a(vaa paramvaa)
  {
    this.jdField_a_of_type_Vaa = paramvaa;
    return this;
  }
  
  public uzt a(vab paramvab)
  {
    veg.a("Q.qqstory.home.SerialStepExecutor", "add Step:%s", paramvab.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramvab);
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
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(paramErrorMessage);
    }
    if (this.jdField_a_of_type_Vab.a())
    {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Vab.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        veg.e("Q.qqstory.home.SerialStepExecutor", "error step:" + this.jdField_a_of_type_Vab.a() + ",return null result");
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
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Vab.a();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        veg.e("Q.qqstory.home.SerialStepExecutor", "done step:" + this.jdField_a_of_type_Vab.a() + ",return null result");
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
      veg.b("Q.qqstory.home.SerialStepExecutor", "reset");
      if (this.jdField_a_of_type_Vab != null)
      {
        this.jdField_a_of_type_Vab.c();
        this.jdField_a_of_type_Vab.a(null);
        this.jdField_a_of_type_Vab.a(null);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Vaa = null;
      this.jdField_a_of_type_Uzz = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */