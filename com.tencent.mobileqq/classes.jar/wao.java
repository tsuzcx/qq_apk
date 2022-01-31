import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class wao
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, vag>
{
  public wao(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull vag paramvag)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {}
    wbb localwbb;
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localwbb = paramQQStoryShareGroupProfileActivity.a.a;
      Iterator localIterator = paramQQStoryShareGroupProfileActivity.a.a.a.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (HotSortVideoEntry)localIterator.next();
      } while (!((HotSortVideoEntry)localObject1).storyId.equals(paramvag.a));
    } while (localObject1 == null);
    ((HotSortVideoEntry)localObject1).viewCount += 1;
    ((uqy)urr.a(25)).a((HotSortVideoEntry)localObject1);
    localwbb.a((HotSortVideoEntry)localObject1);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return vag.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wao
 * JD-Core Version:    0.7.0.1
 */