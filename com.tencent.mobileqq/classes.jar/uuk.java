import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uuk
  extends JobSegment<List<vhg>, List<vhg>>
{
  private final vhf a;
  
  public uuk()
  {
    this(new uul());
  }
  
  public uuk(vhf paramvhf)
  {
    this.a = paramvhf;
  }
  
  protected void a(JobContext paramJobContext, List<vhg> paramList)
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
      paramJobContext.add(((vhg)localIterator.next()).b);
    }
    paramJobContext = new vha(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new uum(this, paramList));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */