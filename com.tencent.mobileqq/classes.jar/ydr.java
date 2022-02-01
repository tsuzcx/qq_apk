import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ydr
  extends QQUIEventReceiver<ydd, wrx>
{
  public ydr(ydd paramydd1, @NonNull ydd paramydd2)
  {
    super(paramydd2);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull wrx paramwrx)
  {
    if ((TextUtils.isEmpty(paramwrx.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwrx.jdField_b_of_type_JavaLangString)) || (paramwrx.c == 0) || (paramwrx.jdField_b_of_type_Long == 0L) || (paramwrx.jdField_a_of_type_Int < 1))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwrx.jdField_a_of_type_JavaLangString, paramwrx.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwrx.c), Long.valueOf(paramwrx.jdField_b_of_type_Long), Integer.valueOf(paramwrx.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramydd.a(paramwrx.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof yeb)))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwrx.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (yeb)localObject1;
    ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwrx.jdField_a_of_type_JavaLangString, paramwrx.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwrx.c), Long.valueOf(paramwrx.jdField_b_of_type_Long), Integer.valueOf(paramwrx.jdField_a_of_type_Int) });
    localObject1 = xwr.a(paramwrx.jdField_a_of_type_JavaLangString, paramwrx.c, paramwrx.jdField_b_of_type_Long, 2, String.valueOf(paramwrx.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((yeb)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((yeb)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (ydd.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      ydd.a(paramydd).b(paramwrx.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      ydd.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return wrx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydr
 * JD-Core Version:    0.7.0.1
 */