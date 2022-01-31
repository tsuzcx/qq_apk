import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class wea
  extends ParallelJobSegment<String, Integer>
{
  public wea(wds paramwds)
  {
    this(paramwds, "RequestViewCountSegment");
  }
  
  public wea(wds paramwds, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    vba localvba = new vba();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localvba.a = localArrayList;
    ung.a().a(localvba, new web(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wea
 * JD-Core Version:    0.7.0.1
 */