import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class ucp
  extends ParallelJobSegment<String, Integer>
{
  public ucp(uch paramuch)
  {
    this(paramuch, "RequestViewCountSegment");
  }
  
  public ucp(uch paramuch, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    szp localszp = new szp();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localszp.a = localArrayList;
    slv.a().a(localszp, new ucq(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */