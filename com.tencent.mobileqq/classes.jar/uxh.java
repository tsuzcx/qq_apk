import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class uxh
  extends QQUIEventReceiver<uwt, tlh>
{
  public uxh(uwt paramuwt1, @NonNull uwt paramuwt2)
  {
    super(paramuwt2);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull tlh paramtlh)
  {
    if ((TextUtils.isEmpty(paramtlh.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramtlh.jdField_b_of_type_JavaLangString)) || (paramtlh.c == 0) || (paramtlh.jdField_b_of_type_Long == 0L) || (paramtlh.jdField_a_of_type_Int < 1))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramtlh.jdField_a_of_type_JavaLangString, paramtlh.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtlh.c), Long.valueOf(paramtlh.jdField_b_of_type_Long), Integer.valueOf(paramtlh.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramuwt.a(paramtlh.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof uxr)))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramtlh.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (uxr)localObject1;
    veg.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramtlh.jdField_a_of_type_JavaLangString, paramtlh.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtlh.c), Long.valueOf(paramtlh.jdField_b_of_type_Long), Integer.valueOf(paramtlh.jdField_a_of_type_Int) });
    localObject1 = uqh.a(paramtlh.jdField_a_of_type_JavaLangString, paramtlh.c, paramtlh.jdField_b_of_type_Long, 2, String.valueOf(paramtlh.jdField_a_of_type_Int));
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
      uwt.a(paramuwt).b(paramtlh.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      uwt.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return tlh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxh
 * JD-Core Version:    0.7.0.1
 */