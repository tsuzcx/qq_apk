import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class xvv
  extends ParallelJobSegment<String, Integer>
{
  public xvv(xvn paramxvn)
  {
    this(paramxvn, "RequestViewCountSegment");
  }
  
  public xvv(xvn paramxvn, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    wtb localwtb = new wtb();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localwtb.a = localArrayList;
    wfi.a().a(localwtb, new xvw(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvv
 * JD-Core Version:    0.7.0.1
 */