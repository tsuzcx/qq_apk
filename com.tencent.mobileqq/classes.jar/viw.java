import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class viw
  extends JobSegment<List<vim>, List<vil>>
  implements vih
{
  private ArrayList<vil> jdField_a_of_type_JavaUtilArrayList;
  private List<vif> jdField_a_of_type_JavaUtilList;
  private viz jdField_a_of_type_Viz;
  
  public viw(viz paramviz)
  {
    this.jdField_a_of_type_Viz = paramviz;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<vif> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((via)vux.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new vij(i, this.jdField_a_of_type_Viz));
    return localArrayList;
  }
  
  private void a(List<vim> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      vif localvif = (vif)this.jdField_a_of_type_JavaUtilList.remove(0);
      localvif.a(paramList);
      localvif.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      via.a((vil)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<vim> paramList)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    via.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((vim)paramList.get(0)).b, ((vim)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<vil> paramList, List<vim> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        vil localvil = (vil)localIterator.next();
        xvv.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localvil.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viw
 * JD-Core Version:    0.7.0.1
 */