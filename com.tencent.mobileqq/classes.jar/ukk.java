import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ukk
  extends QQUIEventReceiver<ujx, syj>
{
  public ukk(ujx paramujx1, @NonNull ujx paramujx2)
  {
    super(paramujx2);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull syj paramsyj)
  {
    if ((TextUtils.isEmpty(paramsyj.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramsyj.jdField_b_of_type_JavaLangString)) || (paramsyj.jdField_a_of_type_Int == 0) || (paramsyj.jdField_a_of_type_Long == 0L))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramsyj.jdField_a_of_type_JavaLangString, paramsyj.jdField_b_of_type_JavaLangString, Integer.valueOf(paramsyj.jdField_a_of_type_Int), Long.valueOf(paramsyj.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramujx.a(paramsyj.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof ukv)))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramsyj.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (ukv)localObject1;
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramsyj.jdField_a_of_type_JavaLangString, paramsyj.jdField_b_of_type_JavaLangString, Integer.valueOf(paramsyj.jdField_a_of_type_Int), Integer.valueOf(paramsyj.jdField_b_of_type_Int));
    localObject1 = ((ukv)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramsyj.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((srq)localObject1).a.length > paramsyj.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramsyj.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = udl.a(paramsyj.jdField_a_of_type_JavaLangString, paramsyj.jdField_a_of_type_Int, paramsyj.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((ukv)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((ukv)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (ujx.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          ujx.a(paramujx).b(paramsyj.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          ujx.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((srq)localObject1).a.length)
          {
            urk.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramsyj.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      urk.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return syj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukk
 * JD-Core Version:    0.7.0.1
 */