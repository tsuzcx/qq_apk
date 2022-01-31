import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ufb
  extends JobSegment<List<uer>, List<ueq>>
  implements uem
{
  private ArrayList<ueq> jdField_a_of_type_JavaUtilArrayList;
  private List<uek> jdField_a_of_type_JavaUtilList;
  private ufe jdField_a_of_type_Ufe;
  
  public ufb(ufe paramufe)
  {
    this.jdField_a_of_type_Ufe = paramufe;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<uek> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((uef)urr.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new ueo(i, this.jdField_a_of_type_Ufe));
    return localArrayList;
  }
  
  private void a(List<uer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      uek localuek = (uek)this.jdField_a_of_type_JavaUtilList.remove(0);
      localuek.a(paramList);
      localuek.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      uef.a((ueq)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<uer> paramList)
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    uef.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((uer)paramList.get(0)).b, ((uer)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<ueq> paramList, List<uer> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ueq localueq = (ueq)localIterator.next();
        wsv.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localueq.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufb
 * JD-Core Version:    0.7.0.1
 */