import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class ufa
  extends JobSegment<List<ueq>, List<ueq>>
{
  private ufe a;
  
  public ufa(ufe paramufe)
  {
    this.a = paramufe;
  }
  
  protected void a(JobContext paramJobContext, List<ueq> paramList)
  {
    int i = 1;
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((ueq)paramJobContext.next()).a(this.a);
    }
    uef.a(paramList);
    uef localuef = (uef)urr.a(30);
    udx localudx = localuef.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localudx.a())
      {
        wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localudx.a());
        paramJobContext = paramList.subList(0, localudx.a());
      }
    }
    if (localuef.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((ueq)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((ueq)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((ueq)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufa
 * JD-Core Version:    0.7.0.1
 */