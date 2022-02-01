import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class ybq
  extends ParallelJobSegment<yia, ybn>
{
  public ybq(ybm paramybm)
  {
    this(paramybm, "RequestCommentListSegment");
  }
  
  public ybq(ybm paramybm, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, yia paramyia)
  {
    wyt localwyt = new wyt();
    localwyt.a = paramyia;
    wlb.a().a(localwyt, new ybr(this, paramJobContext, paramyia));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybq
 * JD-Core Version:    0.7.0.1
 */