import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ujk
  extends JobSegment<List<uja>, List<uiz>>
  implements uiv
{
  private ArrayList<uiz> jdField_a_of_type_JavaUtilArrayList;
  private List<uit> jdField_a_of_type_JavaUtilList;
  private ujn jdField_a_of_type_Ujn;
  
  public ujk(ujn paramujn)
  {
    this.jdField_a_of_type_Ujn = paramujn;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<uit> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((uio)uwa.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new uix(i, this.jdField_a_of_type_Ujn));
    return localArrayList;
  }
  
  private void a(List<uja> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      uit localuit = (uit)this.jdField_a_of_type_JavaUtilList.remove(0);
      localuit.a(paramList);
      localuit.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      uio.a((uiz)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<uja> paramList)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    uio.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((uja)paramList.get(0)).b, ((uja)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<uiz> paramList, List<uja> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        uiz localuiz = (uiz)localIterator.next();
        wxe.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localuiz.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujk
 * JD-Core Version:    0.7.0.1
 */