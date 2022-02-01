import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class yfp
  extends ParallelJobSegment<String, Integer>
{
  public yfp(yfh paramyfh)
  {
    this(paramyfh, "RequestViewCountSegment");
  }
  
  public yfp(yfh paramyfh, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    xcq localxcq = new xcq();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localxcq.a = localArrayList;
    wow.a().a(localxcq, new yfq(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfp
 * JD-Core Version:    0.7.0.1
 */