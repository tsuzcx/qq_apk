import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pkj
  extends JobSegment<List<pkd.a>, List<pkd>>
  implements pjz.a
{
  private pkm b;
  private List<pjy> mFilterList;
  private ArrayList<pkd> mx;
  
  public pkj(pkm parampkm)
  {
    this.b = parampkm;
    this.mx = new ArrayList();
  }
  
  private void dP(List<pkd.a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.mFilterList.size() > 0))
    {
      pjy localpjy = (pjy)this.mFilterList.remove(0);
      localpjy.dK(paramList);
      localpjy.a(this);
      return;
    }
    paramList = this.mx.iterator();
    while (paramList.hasNext()) {
      pju.a((pkd)paramList.next(), 10);
    }
    notifyResult(this.mx);
  }
  
  private List<pjy> h(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((pju)psx.a(30)).g(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new pkb(i, this.b));
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, List<pkd.a> paramList)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.mx);
      return;
    }
    pju.dI(paramList);
    this.mFilterList = h(((pkd.a)paramList.get(0)).mCreateTime, ((pkd.a)paramList.get(paramList.size() - 1)).mCreateTime);
    dP(paramList);
  }
  
  public void s(List<pkd> paramList, List<pkd.a> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        pkd localpkd = (pkd)localIterator.next();
        ram.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localpkd.toString());
      }
      this.mx.addAll(paramList);
    }
    dP(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkj
 * JD-Core Version:    0.7.0.1
 */