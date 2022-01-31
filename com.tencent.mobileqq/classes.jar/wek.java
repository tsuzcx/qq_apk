import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wek
  extends umf<QQStoryShareGroupProfileActivity, utf>
{
  public wek(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull utf paramutf)
  {
    if ((paramutf.b != 3) || (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {}
    ArrayList localArrayList;
    label68:
    do
    {
      return;
      int i;
      wfk localwfk;
      HotSortVideoEntry localHotSortVideoEntry;
      if (paramutf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
      {
        i = 1;
        localwfk = paramQQStoryShareGroupProfileActivity.a.a;
        Object localObject = paramQQStoryShareGroupProfileActivity.a.a.a;
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        } while (!localHotSortVideoEntry.feedId.equals(paramutf.jdField_a_of_type_JavaLangString));
        if (i == 0) {
          break label164;
        }
      }
      for (int j = localHotSortVideoEntry.likeCount + 1;; j = localHotSortVideoEntry.likeCount - 1)
      {
        localHotSortVideoEntry.likeCount = j;
        if (localHotSortVideoEntry.likeCount < 0) {
          localHotSortVideoEntry.likeCount = 0;
        }
        localwfk.a(localHotSortVideoEntry);
        localArrayList.add(localHotSortVideoEntry);
        break label68;
        i = 0;
        break;
      }
    } while (localArrayList.size() <= 0);
    label164:
    ((uvh)uwa.a(25)).a(localArrayList);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wek
 * JD-Core Version:    0.7.0.1
 */