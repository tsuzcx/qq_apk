import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class uwy
  extends QQUIEventReceiver<uwq, tam>
{
  public uwy(@NonNull uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull tam paramtam)
  {
    if ((TextUtils.isEmpty(paramtam.jdField_a_of_type_JavaLangString)) || (paramtam.jdField_a_of_type_Int == 0) || (paramtam.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramtam.b)))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramtam.jdField_a_of_type_JavaLangString, Integer.valueOf(paramtam.jdField_a_of_type_Int), Long.valueOf(paramtam.jdField_a_of_type_Long), paramtam.b });
      return;
    }
    Object localObject1 = paramuwq.a(paramtam.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof uxo)))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramtam.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (uxo)localObject1;
    localObject1 = uqe.a(paramtam.jdField_a_of_type_JavaLangString, paramtam.jdField_a_of_type_Int, paramtam.jdField_a_of_type_Long, paramtam.b, paramtam.c, paramtam.d, paramtam.e, paramtam.f);
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
      uwq.a(paramuwq).b(paramtam.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramtam), 5, null, false);
      uwq.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return tam.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwy
 * JD-Core Version:    0.7.0.1
 */