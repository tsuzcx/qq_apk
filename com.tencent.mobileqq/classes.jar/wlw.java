import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wlw
  extends QQUIEventReceiver<wli, uzw>
{
  public wlw(wli paramwli1, @NonNull wli paramwli2)
  {
    super(paramwli2);
  }
  
  public void a(@NonNull wli paramwli, @NonNull uzw paramuzw)
  {
    if ((TextUtils.isEmpty(paramuzw.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramuzw.jdField_b_of_type_JavaLangString)) || (paramuzw.c == 0) || (paramuzw.jdField_b_of_type_Long == 0L) || (paramuzw.jdField_a_of_type_Int < 1))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramuzw.jdField_a_of_type_JavaLangString, paramuzw.jdField_b_of_type_JavaLangString, Integer.valueOf(paramuzw.c), Long.valueOf(paramuzw.jdField_b_of_type_Long), Integer.valueOf(paramuzw.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramwli.a(paramuzw.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wmg)))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramuzw.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wmg)localObject1;
    wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramuzw.jdField_a_of_type_JavaLangString, paramuzw.jdField_b_of_type_JavaLangString, Integer.valueOf(paramuzw.c), Long.valueOf(paramuzw.jdField_b_of_type_Long), Integer.valueOf(paramuzw.jdField_a_of_type_Int) });
    localObject1 = wew.a(paramuzw.jdField_a_of_type_JavaLangString, paramuzw.c, paramuzw.jdField_b_of_type_Long, 2, String.valueOf(paramuzw.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((wmg)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((wmg)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (wli.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      wli.a(paramwli).b(paramuzw.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      wli.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return uzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlw
 * JD-Core Version:    0.7.0.1
 */