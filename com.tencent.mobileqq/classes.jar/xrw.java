import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xrw
  extends wag<QQStoryShareGroupProfileActivity, wgy>
{
  public xrw(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wgy paramwgy)
  {
    if ((paramwgy.b != 3) || (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {}
    ArrayList localArrayList;
    label68:
    do
    {
      return;
      int i;
      xsw localxsw;
      HotSortVideoEntry localHotSortVideoEntry;
      if (paramwgy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
      {
        i = 1;
        localxsw = paramQQStoryShareGroupProfileActivity.a.a;
        Object localObject = paramQQStoryShareGroupProfileActivity.a.a.a;
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        } while (!localHotSortVideoEntry.feedId.equals(paramwgy.jdField_a_of_type_JavaLangString));
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
        localxsw.a(localHotSortVideoEntry);
        localArrayList.add(localHotSortVideoEntry);
        break label68;
        i = 0;
        break;
      }
    } while (localArrayList.size() <= 0);
    label164:
    ((wiz)wjs.a(25)).a(localArrayList);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrw
 * JD-Core Version:    0.7.0.1
 */