import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class ujj
  extends JobSegment<List<uiz>, List<uiz>>
{
  private ujn a;
  
  public ujj(ujn paramujn)
  {
    this.a = paramujn;
  }
  
  protected void a(JobContext paramJobContext, List<uiz> paramList)
  {
    int i = 1;
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((uiz)paramJobContext.next()).a(this.a);
    }
    uio.a(paramList);
    uio localuio = (uio)uwa.a(30);
    uig localuig = localuio.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localuig.a())
      {
        wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localuig.a());
        paramJobContext = paramList.subList(0, localuig.a());
      }
    }
    if (localuio.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((uiz)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((uiz)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((uiz)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujj
 * JD-Core Version:    0.7.0.1
 */