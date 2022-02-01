import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class yjq
  extends QQUIEventReceiver<yjc, wxr>
{
  public yjq(yjc paramyjc1, @NonNull yjc paramyjc2)
  {
    super(paramyjc2);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wxr paramwxr)
  {
    if ((TextUtils.isEmpty(paramwxr.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwxr.jdField_b_of_type_JavaLangString)) || (paramwxr.c == 0) || (paramwxr.jdField_b_of_type_Long == 0L) || (paramwxr.jdField_a_of_type_Int < 1))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwxr.jdField_a_of_type_JavaLangString, paramwxr.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwxr.c), Long.valueOf(paramwxr.jdField_b_of_type_Long), Integer.valueOf(paramwxr.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramyjc.a(paramwxr.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof yka)))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwxr.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (yka)localObject1;
    yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwxr.jdField_a_of_type_JavaLangString, paramwxr.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwxr.c), Long.valueOf(paramwxr.jdField_b_of_type_Long), Integer.valueOf(paramwxr.jdField_a_of_type_Int) });
    localObject1 = ycq.a(paramwxr.jdField_a_of_type_JavaLangString, paramwxr.c, paramwxr.jdField_b_of_type_Long, 2, String.valueOf(paramwxr.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((yka)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((yka)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (yjc.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      yjc.a(paramyjc).b(paramwxr.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      yjc.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return wxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjq
 * JD-Core Version:    0.7.0.1
 */