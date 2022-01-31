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

public class ulc
  extends JobSegment<List<String>, List<String>>
  implements tkm
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public ulc(String paramString) {}
  
  private Pair<List<String>, Boolean> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    tdo localtdo = (tdo)tdc.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localtdo.b((String)paramList.next());
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
    ukm.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new tej(null, (String)paramList.next()));
    }
    new tkl(this).a(1, localArrayList);
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
      ukm.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    ukm.a(this.a, "fireRefreshUserInfo");
    b(paramJobContext);
  }
  
  protected void a(List<String> paramList)
  {
    ukm.a(this.a, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      ukm.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
  
  public void a(tkn paramtkn)
  {
    if ((paramtkn == null) || (paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtkn.jdField_a_of_type_JavaUtilList == null))
    {
      ukm.b(this.a, "refresh user info fail %s", paramtkn);
      if (paramtkn == null) {}
      for (paramtkn = new ErrorMessage(-1, "event is null");; paramtkn = paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        notifyError(paramtkn);
        return;
      }
    }
    ukm.a(this.a, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramtkn = paramtkn.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtkn.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramtkn.next()).headUrl);
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulc
 * JD-Core Version:    0.7.0.1
 */