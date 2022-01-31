import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wqf
  extends QQUIEventReceiver<wpr, vef>
{
  public wqf(wpr paramwpr1, @NonNull wpr paramwpr2)
  {
    super(paramwpr2);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull vef paramvef)
  {
    if ((TextUtils.isEmpty(paramvef.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramvef.jdField_b_of_type_JavaLangString)) || (paramvef.c == 0) || (paramvef.jdField_b_of_type_Long == 0L) || (paramvef.jdField_a_of_type_Int < 1))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramvef.jdField_a_of_type_JavaLangString, paramvef.jdField_b_of_type_JavaLangString, Integer.valueOf(paramvef.c), Long.valueOf(paramvef.jdField_b_of_type_Long), Integer.valueOf(paramvef.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramwpr.a(paramvef.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wqp)))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramvef.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wqp)localObject1;
    wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramvef.jdField_a_of_type_JavaLangString, paramvef.jdField_b_of_type_JavaLangString, Integer.valueOf(paramvef.c), Long.valueOf(paramvef.jdField_b_of_type_Long), Integer.valueOf(paramvef.jdField_a_of_type_Int) });
    localObject1 = wjf.a(paramvef.jdField_a_of_type_JavaLangString, paramvef.c, paramvef.jdField_b_of_type_Long, 2, String.valueOf(paramvef.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((wqp)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((wqp)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (wpr.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      wpr.a(paramwpr).b(paramvef.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      wpr.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return vef.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqf
 * JD-Core Version:    0.7.0.1
 */