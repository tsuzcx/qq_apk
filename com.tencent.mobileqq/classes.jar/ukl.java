import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ukl
  extends QQUIEventReceiver<ujx, syl>
{
  public ukl(ujx paramujx1, @NonNull ujx paramujx2)
  {
    super(paramujx2);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull syl paramsyl)
  {
    if ((TextUtils.isEmpty(paramsyl.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramsyl.jdField_b_of_type_JavaLangString)) || (paramsyl.c == 0) || (paramsyl.jdField_b_of_type_Long == 0L) || (paramsyl.jdField_a_of_type_Int < 1))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramsyl.jdField_a_of_type_JavaLangString, paramsyl.jdField_b_of_type_JavaLangString, Integer.valueOf(paramsyl.c), Long.valueOf(paramsyl.jdField_b_of_type_Long), Integer.valueOf(paramsyl.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramujx.a(paramsyl.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof ukv)))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramsyl.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (ukv)localObject1;
    urk.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramsyl.jdField_a_of_type_JavaLangString, paramsyl.jdField_b_of_type_JavaLangString, Integer.valueOf(paramsyl.c), Long.valueOf(paramsyl.jdField_b_of_type_Long), Integer.valueOf(paramsyl.jdField_a_of_type_Int) });
    localObject1 = udl.a(paramsyl.jdField_a_of_type_JavaLangString, paramsyl.c, paramsyl.jdField_b_of_type_Long, 2, String.valueOf(paramsyl.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((ukv)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((ukv)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (ujx.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      ujx.a(paramujx).b(paramsyl.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      ujx.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return syl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukl
 * JD-Core Version:    0.7.0.1
 */