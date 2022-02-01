import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wml
  extends JobSegment<List<wzh>, List<wzh>>
{
  private final wzg a;
  
  public wml()
  {
    this(new wmm());
  }
  
  public wml(wzg paramwzg)
  {
    this.a = paramwzg;
  }
  
  protected void a(JobContext paramJobContext, List<wzh> paramList)
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
      paramJobContext.add(((wzh)localIterator.next()).b);
    }
    paramJobContext = new wzb(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new wmn(this, paramList));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wml
 * JD-Core Version:    0.7.0.1
 */