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

public class xrm
  extends JobSegment<List<String>, List<String>>
  implements wrc
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public xrm(String paramString) {}
  
  private Pair<List<String>, Boolean> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    wke localwke = (wke)wjs.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localwke.b((String)paramList.next());
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
    xqw.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new wkz(null, (String)paramList.next()));
    }
    new wrb(this).a(1, localArrayList);
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
      xqw.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    xqw.a(this.a, "fireRefreshUserInfo");
    b(paramJobContext);
  }
  
  protected void a(List<String> paramList)
  {
    xqw.a(this.a, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      xqw.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
  
  public void a(wrd paramwrd)
  {
    if ((paramwrd == null) || (paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramwrd.jdField_a_of_type_JavaUtilList == null))
    {
      xqw.b(this.a, "refresh user info fail %s", paramwrd);
      if (paramwrd == null) {}
      for (paramwrd = new ErrorMessage(-1, "event is null");; paramwrd = paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        notifyError(paramwrd);
        return;
      }
    }
    xqw.a(this.a, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramwrd = paramwrd.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwrd.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramwrd.next()).headUrl);
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrm
 * JD-Core Version:    0.7.0.1
 */