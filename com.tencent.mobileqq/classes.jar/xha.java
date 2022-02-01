import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;
import java.util.ArrayList;

class xha
  extends ParallelJobSegment<String, Integer>
{
  public xha(xgs paramxgs)
  {
    this(paramxgs, "RequestViewCountSegment");
  }
  
  public xha(xgs paramxgs, String paramString)
  {
    super(paramString);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    weg localweg = new weg();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localweg.a = localArrayList;
    vqn.a().a(localweg, new xhb(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */