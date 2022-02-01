import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.util.Pair;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class qpl
  extends JobSegment<List<String>, List<String>>
  implements pxs.a
{
  private String TAG = "story.icon.UidListToUrlListSegment";
  
  public qpl(String paramString) {}
  
  private Pair<List<String>, Boolean> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ptf localptf = (ptf)psx.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localptf.b((String)paramList.next());
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
  
  private void ev(List<String> paramList)
  {
    qpb.b(this.TAG, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new QQUserUIItem.a(null, (String)paramList.next()));
    }
    new pxs(this).B(1, localArrayList);
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
      paramList = b(paramJobContext);
      qpb.b(this.TAG, "getUnionIdListFromCache ok=%s", paramList.second);
      ew((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    qpb.d(this.TAG, "fireRefreshUserInfo");
    ev(paramJobContext);
  }
  
  public void c(pxs.b paramb)
  {
    if ((paramb == null) || (paramb.b.isFail()) || (paramb.mX == null))
    {
      qpb.c(this.TAG, "refresh user info fail %s", paramb);
      if (paramb == null) {}
      for (paramb = new ErrorMessage(-1, "event is null");; paramb = paramb.b)
      {
        notifyError(paramb);
        return;
      }
    }
    qpb.d(this.TAG, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramb = paramb.mX.iterator();
    while (paramb.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramb.next()).headUrl);
    }
    ew(localArrayList);
  }
  
  protected void ew(List<String> paramList)
  {
    qpb.d(this.TAG, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      qpb.w(this.TAG, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */