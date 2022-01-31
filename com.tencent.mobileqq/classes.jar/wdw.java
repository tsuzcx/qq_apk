import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class wdw
  extends ParallelJobSegment<wkg, wdt>
{
  public wdw(wds paramwds)
  {
    this(paramwds, "RequestCommentListSegment");
  }
  
  public wdw(wds paramwds, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, wkg paramwkg)
  {
    vay localvay = new vay();
    localvay.a = paramwkg;
    ung.a().a(localvay, new wdx(this, paramJobContext, paramwkg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdw
 * JD-Core Version:    0.7.0.1
 */