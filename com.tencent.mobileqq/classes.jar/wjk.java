import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class wjk
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public wjl a;
  
  public wjk()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(wjl paramwjl)
  {
    this.jdField_a_of_type_Wjl = paramwjl;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Wjl != null) {
      this.jdField_a_of_type_Wjl.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjk
 * JD-Core Version:    0.7.0.1
 */