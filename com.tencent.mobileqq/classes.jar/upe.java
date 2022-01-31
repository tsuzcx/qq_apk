import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

class upe
  extends ParallelJobSegment<uvo, upb>
{
  public upe(upa paramupa)
  {
    this(paramupa, "RequestCommentListSegment");
  }
  
  public upe(upa paramupa, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, uvo paramuvo)
  {
    tmg localtmg = new tmg();
    localtmg.a = paramuvo;
    syo.a().a(localtmg, new upf(this, paramJobContext, paramuvo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upe
 * JD-Core Version:    0.7.0.1
 */