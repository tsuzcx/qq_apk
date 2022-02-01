import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class vow
  extends JobSegment<ErrorMessage, ErrorMessage>
{
  protected AtomicInteger a;
  public vox a;
  
  public vow()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  protected abstract void a();
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void a(vox paramvox)
  {
    this.jdField_a_of_type_Vox = paramvox;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vox != null) {
      this.jdField_a_of_type_Vox.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vow
 * JD-Core Version:    0.7.0.1
 */