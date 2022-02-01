import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class xow
  extends QQUIEventReceiver<xoi, wdc>
{
  public xow(xoi paramxoi1, @NonNull xoi paramxoi2)
  {
    super(paramxoi2);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull wdc paramwdc)
  {
    if ((TextUtils.isEmpty(paramwdc.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwdc.jdField_b_of_type_JavaLangString)) || (paramwdc.c == 0) || (paramwdc.jdField_b_of_type_Long == 0L) || (paramwdc.jdField_a_of_type_Int < 1))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwdc.jdField_a_of_type_JavaLangString, paramwdc.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwdc.c), Long.valueOf(paramwdc.jdField_b_of_type_Long), Integer.valueOf(paramwdc.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramxoi.a(paramwdc.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof xpg)))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwdc.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (xpg)localObject1;
    xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramwdc.jdField_a_of_type_JavaLangString, paramwdc.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwdc.c), Long.valueOf(paramwdc.jdField_b_of_type_Long), Integer.valueOf(paramwdc.jdField_a_of_type_Int) });
    localObject1 = xhw.a(paramwdc.jdField_a_of_type_JavaLangString, paramwdc.c, paramwdc.jdField_b_of_type_Long, 2, String.valueOf(paramwdc.jdField_a_of_type_Int));
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
      xoi.a(paramxoi).b(paramwdc.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      xoi.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return wdc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */