import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class wij
  extends ParallelJobSegment<String, Integer>
{
  public wij(wib paramwib)
  {
    this(paramwib, "RequestViewCountSegment");
  }
  
  public wij(wib paramwib, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    vfj localvfj = new vfj();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localvfj.a = localArrayList;
    urp.a().a(localvfj, new wik(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wij
 * JD-Core Version:    0.7.0.1
 */