import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class ybu
  extends ParallelJobSegment<String, Integer>
{
  public ybu(ybm paramybm)
  {
    this(paramybm, "RequestViewCountSegment");
  }
  
  public ybu(ybm paramybm, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wyv localwyv = new wyv();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localwyv.a = localArrayList;
    wlb.a().a(localwyv, new ybv(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybu
 * JD-Core Version:    0.7.0.1
 */