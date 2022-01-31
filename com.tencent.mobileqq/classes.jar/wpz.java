import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wpz
  extends QQUIEventReceiver<wpr, utn>
{
  public wpz(@NonNull wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull utn paramutn)
  {
    if ((TextUtils.isEmpty(paramutn.jdField_a_of_type_JavaLangString)) || (paramutn.jdField_a_of_type_Int == 0) || (paramutn.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramutn.b)))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramutn.jdField_a_of_type_JavaLangString, Integer.valueOf(paramutn.jdField_a_of_type_Int), Long.valueOf(paramutn.jdField_a_of_type_Long), paramutn.b });
      return;
    }
    Object localObject1 = paramwpr.a(paramutn.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wqp)))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramutn.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wqp)localObject1;
    localObject1 = wjf.a(paramutn.jdField_a_of_type_JavaLangString, paramutn.jdField_a_of_type_Int, paramutn.jdField_a_of_type_Long, paramutn.b, paramutn.c, paramutn.d, paramutn.e, paramutn.f);
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
      wpr.a(paramwpr).b(paramutn.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramutn), 5, null, false);
      wpr.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return utn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpz
 * JD-Core Version:    0.7.0.1
 */