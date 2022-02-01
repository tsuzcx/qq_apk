import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ydl
  extends QQUIEventReceiver<ydd, whg>
{
  public ydl(@NonNull ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull whg paramwhg)
  {
    if ((TextUtils.isEmpty(paramwhg.jdField_a_of_type_JavaLangString)) || (paramwhg.jdField_a_of_type_Int == 0) || (paramwhg.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramwhg.b)))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramwhg.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwhg.jdField_a_of_type_Int), Long.valueOf(paramwhg.jdField_a_of_type_Long), paramwhg.b });
      return;
    }
    Object localObject1 = paramydd.a(paramwhg.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof yeb)))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwhg.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (yeb)localObject1;
    localObject1 = xwr.a(paramwhg.jdField_a_of_type_JavaLangString, paramwhg.jdField_a_of_type_Int, paramwhg.jdField_a_of_type_Long, paramwhg.b, paramwhg.c, paramwhg.d, paramwhg.e, paramwhg.f);
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
      ydd.a(paramydd).b(paramwhg.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramwhg), 5, null, false);
      ydd.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return whg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydl
 * JD-Core Version:    0.7.0.1
 */