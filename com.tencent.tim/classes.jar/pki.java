import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class pki
  extends JobSegment<List<pkd>, List<pkd>>
{
  private pkm b;
  
  public pki(pkm parampkm)
  {
    this.b = parampkm;
  }
  
  protected void a(JobContext paramJobContext, List<pkd> paramList)
  {
    int i = 1;
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((pkd)paramJobContext.next()).b(this.b);
    }
    pju.dH(paramList);
    pju localpju = (pju)psx.a(30);
    pjp localpjp = localpju.a();
    paramJobContext = paramList;
    if (!this.b.Ih())
    {
      paramJobContext = paramList;
      if (paramList.size() > localpjp.sf())
      {
        ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localpjp.sf());
        paramJobContext = paramList.subList(0, localpjp.sf());
      }
    }
    if (localpju.b(paramJobContext, this.b.Ih()))
    {
      long l2;
      for (long l1 = ((pkd)paramJobContext.get(0)).dB(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((pkd)paramJobContext.get(i)).dB();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.b.fb(((pkd)paramJobContext.get(0)).dB());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pki
 * JD-Core Version:    0.7.0.1
 */