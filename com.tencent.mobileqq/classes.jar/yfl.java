import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class yfl
  extends ParallelJobSegment<ylv, yfi>
{
  public yfl(yfh paramyfh)
  {
    this(paramyfh, "RequestCommentListSegment");
  }
  
  public yfl(yfh paramyfh, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, ylv paramylv)
  {
    xco localxco = new xco();
    localxco.a = paramylv;
    wow.a().a(localxco, new yfm(this, paramJobContext, paramylv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfl
 * JD-Core Version:    0.7.0.1
 */