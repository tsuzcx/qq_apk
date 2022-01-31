import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class upy
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public upz a;
  
  public upy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(upz paramupz)
  {
    this.jdField_a_of_type_Upz = paramupz;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Upz != null) {
      this.jdField_a_of_type_Upz.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upy
 * JD-Core Version:    0.7.0.1
 */