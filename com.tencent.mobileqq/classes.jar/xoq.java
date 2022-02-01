import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class xoq
  extends QQUIEventReceiver<xoi, vsl>
{
  public xoq(@NonNull xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull vsl paramvsl)
  {
    if ((TextUtils.isEmpty(paramvsl.jdField_a_of_type_JavaLangString)) || (paramvsl.jdField_a_of_type_Int == 0) || (paramvsl.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramvsl.b)))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramvsl.jdField_a_of_type_JavaLangString, Integer.valueOf(paramvsl.jdField_a_of_type_Int), Long.valueOf(paramvsl.jdField_a_of_type_Long), paramvsl.b });
      return;
    }
    Object localObject1 = paramxoi.a(paramvsl.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof xpg)))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramvsl.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (xpg)localObject1;
    localObject1 = xhw.a(paramvsl.jdField_a_of_type_JavaLangString, paramvsl.jdField_a_of_type_Int, paramvsl.jdField_a_of_type_Long, paramvsl.b, paramvsl.c, paramvsl.d, paramvsl.e, paramvsl.f);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((xpg)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((xpg)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (xoi.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      xoi.a(paramxoi).b(paramvsl.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramvsl), 5, null, false);
      xoi.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return vsl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoq
 * JD-Core Version:    0.7.0.1
 */