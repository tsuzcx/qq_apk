import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wwa
  extends JobSegment<List<xiw>, List<xiw>>
{
  private final xiv a;
  
  public wwa()
  {
    this(new wwb());
  }
  
  public wwa(xiv paramxiv)
  {
    this.a = paramxiv;
  }
  
  protected void a(JobContext paramJobContext, List<xiw> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "list empty");
      }
      notifyResult(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info start");
    }
    paramJobContext = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      paramJobContext.add(((xiw)localIterator.next()).b);
    }
    paramJobContext = new xiq(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new wwc(this, paramList));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwa
 * JD-Core Version:    0.7.0.1
 */