import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.util.Pair;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class ybg
  extends JobSegment<List<String>, List<String>>
  implements xar
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public ybg(String paramString) {}
  
  private Pair<List<String>, Boolean> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    wtt localwtt = (wtt)wth.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localwtt.b((String)paramList.next());
      if ((localQQUserUIItem != null) && (localQQUserUIItem.headUrl != null)) {
        localArrayList.add(localQQUserUIItem.headUrl);
      }
      for (;;)
      {
        break;
        localArrayList.add("stub_url");
        bool = false;
      }
    }
    return new Pair(localArrayList, Boolean.valueOf(bool));
  }
  
  private void b(List<String> paramList)
  {
    yaq.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new wuo(null, (String)paramList.next()));
    }
    new xaq(this).a(1, localArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      notifyError(new ErrorMessage(-1, ""));
    }
    do
    {
      return;
      paramJobContext = Collections.unmodifiableList(paramList);
      paramList = a(paramJobContext);
      yaq.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    yaq.a(this.a, "fireRefreshUserInfo");
    b(paramJobContext);
  }
  
  protected void a(List<String> paramList)
  {
    yaq.a(this.a, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      yaq.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
  
  public void a(xas paramxas)
  {
    if ((paramxas == null) || (paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramxas.jdField_a_of_type_JavaUtilList == null))
    {
      yaq.b(this.a, "refresh user info fail %s", paramxas);
      if (paramxas == null) {}
      for (paramxas = new ErrorMessage(-1, "event is null");; paramxas = paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        notifyError(paramxas);
        return;
      }
    }
    yaq.a(this.a, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramxas = paramxas.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxas.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramxas.next()).headUrl);
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybg
 * JD-Core Version:    0.7.0.1
 */