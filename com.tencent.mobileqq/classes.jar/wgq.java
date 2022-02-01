import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class wgq
  extends JobSegment<List<wgg>, List<wgg>>
{
  private wgu a;
  
  public wgq(wgu paramwgu)
  {
    this.a = paramwgu;
  }
  
  protected void a(JobContext paramJobContext, List<wgg> paramList)
  {
    int i = 1;
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((wgg)paramJobContext.next()).a(this.a);
    }
    wfv.a(paramList);
    wfv localwfv = (wfv)wth.a(30);
    wfn localwfn = localwfv.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localwfn.a())
      {
        yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localwfn.a());
        paramJobContext = paramList.subList(0, localwfn.a());
      }
    }
    if (localwfv.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((wgg)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((wgg)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((wgg)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgq
 * JD-Core Version:    0.7.0.1
 */