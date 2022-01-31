import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class tzd
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, syv>
{
  public tzd(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull syv paramsyv)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {}
    tzq localtzq;
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localtzq = paramQQStoryShareGroupProfileActivity.a.a;
      Iterator localIterator = paramQQStoryShareGroupProfileActivity.a.a.a.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (HotSortVideoEntry)localIterator.next();
      } while (!((HotSortVideoEntry)localObject1).storyId.equals(paramsyv.a));
    } while (localObject1 == null);
    ((HotSortVideoEntry)localObject1).viewCount += 1;
    ((spn)sqg.a(25)).a((HotSortVideoEntry)localObject1);
    localtzq.a((HotSortVideoEntry)localObject1);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return syv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzd
 * JD-Core Version:    0.7.0.1
 */