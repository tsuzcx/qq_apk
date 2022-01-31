import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class uxe
  extends QQUIEventReceiver<uwq, tle>
{
  public uxe(uwq paramuwq1, @NonNull uwq paramuwq2)
  {
    super(paramuwq2);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull tle paramtle)
  {
    if ((TextUtils.isEmpty(paramtle.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramtle.jdField_b_of_type_JavaLangString)) || (paramtle.c == 0) || (paramtle.jdField_b_of_type_Long == 0L) || (paramtle.jdField_a_of_type_Int < 1))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramtle.jdField_a_of_type_JavaLangString, paramtle.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtle.c), Long.valueOf(paramtle.jdField_b_of_type_Long), Integer.valueOf(paramtle.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramuwq.a(paramtle.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof uxo)))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramtle.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (uxo)localObject1;
    ved.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramtle.jdField_a_of_type_JavaLangString, paramtle.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtle.c), Long.valueOf(paramtle.jdField_b_of_type_Long), Integer.valueOf(paramtle.jdField_a_of_type_Int) });
    localObject1 = uqe.a(paramtle.jdField_a_of_type_JavaLangString, paramtle.c, paramtle.jdField_b_of_type_Long, 2, String.valueOf(paramtle.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((uxo)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((uxo)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (uwq.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      uwq.a(paramuwq).b(paramtle.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      uwq.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return tle.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */