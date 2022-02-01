import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class xgw
  extends ParallelJobSegment<xng, xgt>
{
  public xgw(xgs paramxgs)
  {
    this(paramxgs, "RequestCommentListSegment");
  }
  
  public xgw(xgs paramxgs, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, xng paramxng)
  {
    wee localwee = new wee();
    localwee.a = paramxng;
    vqn.a().a(localwee, new xgx(this, paramJobContext, paramxng));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgw
 * JD-Core Version:    0.7.0.1
 */