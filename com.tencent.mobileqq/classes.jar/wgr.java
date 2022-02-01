import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wgr
  extends JobSegment<List<wgh>, List<wgg>>
  implements wgc
{
  private ArrayList<wgg> jdField_a_of_type_JavaUtilArrayList;
  private List<wga> jdField_a_of_type_JavaUtilList;
  private wgu jdField_a_of_type_Wgu;
  
  public wgr(wgu paramwgu)
  {
    this.jdField_a_of_type_Wgu = paramwgu;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<wga> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((wfv)wth.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new wge(i, this.jdField_a_of_type_Wgu));
    return localArrayList;
  }
  
  private void a(List<wgh> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      wga localwga = (wga)this.jdField_a_of_type_JavaUtilList.remove(0);
      localwga.a(paramList);
      localwga.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      wfv.a((wgg)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<wgh> paramList)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    wfv.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((wgh)paramList.get(0)).b, ((wgh)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<wgg> paramList, List<wgh> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        wgg localwgg = (wgg)localIterator.next();
        yuk.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localwgg.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */