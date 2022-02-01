import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ynl
  extends QQUIEventReceiver<ymx, xbm>
{
  public ynl(ymx paramymx1, @NonNull ymx paramymx2)
  {
    super(paramymx2);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull xbm paramxbm)
  {
    if ((TextUtils.isEmpty(paramxbm.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramxbm.jdField_b_of_type_JavaLangString)) || (paramxbm.c == 0) || (paramxbm.jdField_b_of_type_Long == 0L) || (paramxbm.jdField_a_of_type_Int < 1))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramxbm.jdField_a_of_type_JavaLangString, paramxbm.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxbm.c), Long.valueOf(paramxbm.jdField_b_of_type_Long), Integer.valueOf(paramxbm.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramymx.a(paramxbm.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof ynv)))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramxbm.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (ynv)localObject1;
    yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramxbm.jdField_a_of_type_JavaLangString, paramxbm.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxbm.c), Long.valueOf(paramxbm.jdField_b_of_type_Long), Integer.valueOf(paramxbm.jdField_a_of_type_Int) });
    localObject1 = ygl.a(paramxbm.jdField_a_of_type_JavaLangString, paramxbm.c, paramxbm.jdField_b_of_type_Long, 2, String.valueOf(paramxbm.jdField_a_of_type_Int));
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
      ymx.a(paramymx).b(paramxbm.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      ymx.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return xbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynl
 * JD-Core Version:    0.7.0.1
 */