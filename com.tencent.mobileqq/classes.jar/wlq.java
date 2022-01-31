import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wlq
  extends QQUIEventReceiver<wli, upe>
{
  public wlq(@NonNull wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull upe paramupe)
  {
    if ((TextUtils.isEmpty(paramupe.jdField_a_of_type_JavaLangString)) || (paramupe.jdField_a_of_type_Int == 0) || (paramupe.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramupe.b)))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramupe.jdField_a_of_type_JavaLangString, Integer.valueOf(paramupe.jdField_a_of_type_Int), Long.valueOf(paramupe.jdField_a_of_type_Long), paramupe.b });
      return;
    }
    Object localObject1 = paramwli.a(paramupe.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wmg)))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramupe.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wmg)localObject1;
    localObject1 = wew.a(paramupe.jdField_a_of_type_JavaLangString, paramupe.jdField_a_of_type_Int, paramupe.jdField_a_of_type_Long, paramupe.b, paramupe.c, paramupe.d, paramupe.e, paramupe.f);
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
      wli.a(paramwli).b(paramupe.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramupe), 5, null, false);
      wli.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return upe.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlq
 * JD-Core Version:    0.7.0.1
 */