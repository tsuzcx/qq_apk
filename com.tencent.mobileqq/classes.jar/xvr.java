import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class xvr
  extends ParallelJobSegment<ycb, xvo>
{
  public xvr(xvn paramxvn)
  {
    this(paramxvn, "RequestCommentListSegment");
  }
  
  public xvr(xvn paramxvn, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, ycb paramycb)
  {
    wsz localwsz = new wsz();
    localwsz.a = paramycb;
    wfi.a().a(localwsz, new xvs(this, paramJobContext, paramycb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvr
 * JD-Core Version:    0.7.0.1
 */