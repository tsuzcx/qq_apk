import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tyq
  extends sgl<QQStoryShareGroupProfileActivity, snl>
{
  public tyq(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull snl paramsnl)
  {
    if ((paramsnl.b != 3) || (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {}
    ArrayList localArrayList;
    label68:
    do
    {
      return;
      int i;
      tzq localtzq;
      HotSortVideoEntry localHotSortVideoEntry;
      if (paramsnl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
      {
        i = 1;
        localtzq = paramQQStoryShareGroupProfileActivity.a.a;
        Object localObject = paramQQStoryShareGroupProfileActivity.a.a.a;
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        } while (!localHotSortVideoEntry.feedId.equals(paramsnl.jdField_a_of_type_JavaLangString));
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
        localtzq.a(localHotSortVideoEntry);
        localArrayList.add(localHotSortVideoEntry);
        break label68;
        i = 0;
        break;
      }
    } while (localArrayList.size() <= 0);
    label164:
    ((spn)sqg.a(25)).a(localArrayList);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyq
 * JD-Core Version:    0.7.0.1
 */