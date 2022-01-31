import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ulj
  extends ste<QQStoryShareGroupProfileActivity, tae>
{
  public ulj(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tae paramtae)
  {
    if ((paramtae.b != 3) || (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {}
    ArrayList localArrayList;
    label68:
    do
    {
      return;
      int i;
      umj localumj;
      HotSortVideoEntry localHotSortVideoEntry;
      if (paramtae.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
      {
        i = 1;
        localumj = paramQQStoryShareGroupProfileActivity.a.a;
        Object localObject = paramQQStoryShareGroupProfileActivity.a.a.a;
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        } while (!localHotSortVideoEntry.feedId.equals(paramtae.jdField_a_of_type_JavaLangString));
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
        localumj.a(localHotSortVideoEntry);
        localArrayList.add(localHotSortVideoEntry);
        break label68;
        i = 0;
        break;
      }
    } while (localArrayList.size() <= 0);
    label164:
    ((tcg)tcz.a(25)).a(localArrayList);
    paramQQStoryShareGroupProfileActivity.d = true;
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */