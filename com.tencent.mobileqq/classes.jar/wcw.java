import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wcw
  extends JobSegment<List<wcm>, List<wcl>>
  implements wch
{
  private ArrayList<wcl> jdField_a_of_type_JavaUtilArrayList;
  private List<wcf> jdField_a_of_type_JavaUtilList;
  private wcz jdField_a_of_type_Wcz;
  
  public wcw(wcz paramwcz)
  {
    this.jdField_a_of_type_Wcz = paramwcz;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<wcf> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((wca)wpm.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new wcj(i, this.jdField_a_of_type_Wcz));
    return localArrayList;
  }
  
  private void a(List<wcm> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      wcf localwcf = (wcf)this.jdField_a_of_type_JavaUtilList.remove(0);
      localwcf.a(paramList);
      localwcf.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      wca.a((wcl)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<wcm> paramList)
  {
    yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    wca.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((wcm)paramList.get(0)).b, ((wcm)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<wcl> paramList, List<wcm> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        wcl localwcl = (wcl)localIterator.next();
        yqp.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localwcl.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcw
 * JD-Core Version:    0.7.0.1
 */