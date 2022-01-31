import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class upl
  extends ParallelJobSegment<String, Integer>
{
  public upl(upd paramupd)
  {
    this(paramupd, "RequestViewCountSegment");
  }
  
  public upl(upd paramupd, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    tml localtml = new tml();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localtml.a = localArrayList;
    syr.a().a(localtml, new upm(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upl
 * JD-Core Version:    0.7.0.1
 */