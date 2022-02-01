import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vxr
  extends JobSegment<List<vxh>, List<vxg>>
  implements vxc
{
  private ArrayList<vxg> jdField_a_of_type_JavaUtilArrayList;
  private List<vxa> jdField_a_of_type_JavaUtilList;
  private vxu jdField_a_of_type_Vxu;
  
  public vxr(vxu paramvxu)
  {
    this.jdField_a_of_type_Vxu = paramvxu;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<vxa> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((vwv)wjs.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new vxe(i, this.jdField_a_of_type_Vxu));
    return localArrayList;
  }
  
  private void a(List<vxh> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      vxa localvxa = (vxa)this.jdField_a_of_type_JavaUtilList.remove(0);
      localvxa.a(paramList);
      localvxa.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      vwv.a((vxg)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<vxh> paramList)
  {
    ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    vwv.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((vxh)paramList.get(0)).b, ((vxh)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<vxg> paramList, List<vxh> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        vxg localvxg = (vxg)localIterator.next();
        ykq.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localvxg.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxr
 * JD-Core Version:    0.7.0.1
 */