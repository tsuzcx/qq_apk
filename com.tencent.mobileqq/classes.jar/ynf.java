import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ynf
  extends QQUIEventReceiver<ymx, wqu>
{
  public ynf(@NonNull ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull wqu paramwqu)
  {
    if ((TextUtils.isEmpty(paramwqu.jdField_a_of_type_JavaLangString)) || (paramwqu.jdField_a_of_type_Int == 0) || (paramwqu.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty(paramwqu.b)))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramwqu.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwqu.jdField_a_of_type_Int), Long.valueOf(paramwqu.jdField_a_of_type_Long), paramwqu.b });
      return;
    }
    Object localObject1 = paramymx.a(paramwqu.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof ynv)))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwqu.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (ynv)localObject1;
    localObject1 = ygl.a(paramwqu.jdField_a_of_type_JavaLangString, paramwqu.jdField_a_of_type_Int, paramwqu.jdField_a_of_type_Long, paramwqu.b, paramwqu.c, paramwqu.d, paramwqu.e, paramwqu.f);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((ynv)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((ynv)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (ymx.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      ymx.a(paramymx).b(paramwqu.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramwqu), 5, null, false);
      ymx.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return wqu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynf
 * JD-Core Version:    0.7.0.1
 */