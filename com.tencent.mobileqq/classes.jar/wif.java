import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class wif
  extends ParallelJobSegment<wop, wic>
{
  public wif(wib paramwib)
  {
    this(paramwib, "RequestCommentListSegment");
  }
  
  public wif(wib paramwib, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, wop paramwop)
  {
    vfh localvfh = new vfh();
    localvfh.a = paramwop;
    urp.a().a(localvfh, new wig(this, paramJobContext, paramwop));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wif
 * JD-Core Version:    0.7.0.1
 */