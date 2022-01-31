import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class ucl
  extends ParallelJobSegment<uiv, uci>
{
  public ucl(uch paramuch)
  {
    this(paramuch, "RequestCommentListSegment");
  }
  
  public ucl(uch paramuch, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, uiv paramuiv)
  {
    szn localszn = new szn();
    localszn.a = paramuiv;
    slv.a().a(localszn, new ucm(this, paramJobContext, paramuiv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucl
 * JD-Core Version:    0.7.0.1
 */