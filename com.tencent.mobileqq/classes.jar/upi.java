import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class upi
  extends ParallelJobSegment<String, Integer>
{
  public upi(upa paramupa)
  {
    this(paramupa, "RequestViewCountSegment");
  }
  
  public upi(upa paramupa, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    tmi localtmi = new tmi();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localtmi.a = localArrayList;
    syo.a().a(localtmi, new upj(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upi
 * JD-Core Version:    0.7.0.1
 */