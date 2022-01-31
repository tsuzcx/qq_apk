import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class uph
  extends ParallelJobSegment<uvr, upe>
{
  public uph(upd paramupd)
  {
    this(paramupd, "RequestCommentListSegment");
  }
  
  public uph(upd paramupd, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, uvr paramuvr)
  {
    tmj localtmj = new tmj();
    localtmj.a = paramuvr;
    syr.a().a(localtmj, new upi(this, paramJobContext, paramuvr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */