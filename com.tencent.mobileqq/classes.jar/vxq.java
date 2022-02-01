import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class vxq
  extends JobSegment<List<vxg>, List<vxg>>
{
  private vxu a;
  
  public vxq(vxu paramvxu)
  {
    this.a = paramvxu;
  }
  
  protected void a(JobContext paramJobContext, List<vxg> paramList)
  {
    int i = 1;
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((vxg)paramJobContext.next()).a(this.a);
    }
    vwv.a(paramList);
    vwv localvwv = (vwv)wjs.a(30);
    vwo localvwo = localvwv.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localvwo.a())
      {
        ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localvwo.a());
        paramJobContext = paramList.subList(0, localvwo.a());
      }
    }
    if (localvwv.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((vxg)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((vxg)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((vxg)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxq
 * JD-Core Version:    0.7.0.1
 */