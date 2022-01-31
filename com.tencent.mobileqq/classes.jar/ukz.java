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

public class ukz
  extends JobSegment<List<String>, List<String>>
  implements tkj
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public ukz(String paramString) {}
  
  private Pair<List<String>, Boolean> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    tdl localtdl = (tdl)tcz.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localtdl.b((String)paramList.next());
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
    ukj.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new teg(null, (String)paramList.next()));
    }
    new tki(this).a(1, localArrayList);
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
      ukj.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    ukj.a(this.a, "fireRefreshUserInfo");
    b(paramJobContext);
  }
  
  protected void a(List<String> paramList)
  {
    ukj.a(this.a, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      ukj.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
  
  public void a(tkk paramtkk)
  {
    if ((paramtkk == null) || (paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramtkk.jdField_a_of_type_JavaUtilList == null))
    {
      ukj.b(this.a, "refresh user info fail %s", paramtkk);
      if (paramtkk == null) {}
      for (paramtkk = new ErrorMessage(-1, "event is null");; paramtkk = paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        notifyError(paramtkk);
        return;
      }
    }
    ukj.a(this.a, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramtkk = paramtkk.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtkk.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramtkk.next()).headUrl);
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukz
 * JD-Core Version:    0.7.0.1
 */