import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ulp
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public ulq a;
  
  public ulp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(ulq paramulq)
  {
    this.jdField_a_of_type_Ulq = paramulq;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ulq != null) {
      this.jdField_a_of_type_Ulq.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ulp
 * JD-Core Version:    0.7.0.1
 */