import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class wdr
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public wds a;
  
  public wdr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(wds paramwds)
  {
    this.jdField_a_of_type_Wds = paramwds;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Wds != null) {
      this.jdField_a_of_type_Wds.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdr
 * JD-Core Version:    0.7.0.1
 */