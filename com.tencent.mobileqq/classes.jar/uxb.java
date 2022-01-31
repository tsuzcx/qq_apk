import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class uxb
  extends QQUIEventReceiver<uwt, tap>
{
  public uxb(@NonNull uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull tap paramtap)
  {
    if ((TextUtils.isEmpty(paramtap.jdField_a_of_type_JavaLangString)) || (paramtap.jdField_a_of_type_Int == 0) || (paramtap.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramtap.b)))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramtap.jdField_a_of_type_JavaLangString, Integer.valueOf(paramtap.jdField_a_of_type_Int), Long.valueOf(paramtap.jdField_a_of_type_Long), paramtap.b });
      return;
    }
    Object localObject1 = paramuwt.a(paramtap.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof uxr)))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramtap.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (uxr)localObject1;
    localObject1 = uqh.a(paramtap.jdField_a_of_type_JavaLangString, paramtap.jdField_a_of_type_Int, paramtap.jdField_a_of_type_Long, paramtap.b, paramtap.c, paramtap.d, paramtap.e, paramtap.f);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((uxr)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((uxr)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (uwt.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      uwt.a(paramuwt).b(paramtap.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramtap), 5, null, false);
      uwt.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return tap.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxb
 * JD-Core Version:    0.7.0.1
 */