import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class wcv
  extends JobSegment<List<wcl>, List<wcl>>
{
  private wcz a;
  
  public wcv(wcz paramwcz)
  {
    this.a = paramwcz;
  }
  
  protected void a(JobContext paramJobContext, List<wcl> paramList)
  {
    int i = 1;
    yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((wcl)paramJobContext.next()).a(this.a);
    }
    wca.a(paramList);
    wca localwca = (wca)wpm.a(30);
    wbs localwbs = localwca.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localwbs.a())
      {
        yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localwbs.a());
        paramJobContext = paramList.subList(0, localwbs.a());
      }
    }
    if (localwca.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((wcl)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((wcl)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((wcl)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcv
 * JD-Core Version:    0.7.0.1
 */