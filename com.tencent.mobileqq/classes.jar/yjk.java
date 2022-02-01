import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class yjk
  extends QQUIEventReceiver<yjc, wmz>
{
  public yjk(@NonNull yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wmz paramwmz)
  {
    if ((TextUtils.isEmpty(paramwmz.jdField_a_of_type_JavaLangString)) || (paramwmz.jdField_a_of_type_Int == 0) || (paramwmz.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramwmz.b)))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramwmz.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwmz.jdField_a_of_type_Int), Long.valueOf(paramwmz.jdField_a_of_type_Long), paramwmz.b });
      return;
    }
    Object localObject1 = paramyjc.a(paramwmz.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof yka)))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwmz.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (yka)localObject1;
    localObject1 = ycq.a(paramwmz.jdField_a_of_type_JavaLangString, paramwmz.jdField_a_of_type_Int, paramwmz.jdField_a_of_type_Long, paramwmz.b, paramwmz.c, paramwmz.d, paramwmz.e, paramwmz.f);
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
      yjc.a(paramyjc).b(paramwmz.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramwmz), 5, null, false);
      yjc.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return wmz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjk
 * JD-Core Version:    0.7.0.1
 */