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

public class ydq
  extends QQUIEventReceiver<ydd, wrv>
{
  public ydq(ydd paramydd1, @NonNull ydd paramydd2)
  {
    super(paramydd2);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull wrv paramwrv)
  {
    if ((TextUtils.isEmpty(paramwrv.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwrv.jdField_b_of_type_JavaLangString)) || (paramwrv.jdField_a_of_type_Int == 0) || (paramwrv.jdField_a_of_type_Long == 0L))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramwrv.jdField_a_of_type_JavaLangString, paramwrv.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwrv.jdField_a_of_type_Int), Long.valueOf(paramwrv.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramydd.a(paramwrv.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof yeb)))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwrv.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (yeb)localObject1;
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramwrv.jdField_a_of_type_JavaLangString, paramwrv.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwrv.jdField_a_of_type_Int), Integer.valueOf(paramwrv.jdField_b_of_type_Int));
    localObject1 = ((yeb)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramwrv.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((wlc)localObject1).a.length > paramwrv.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramwrv.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = xwr.a(paramwrv.jdField_a_of_type_JavaLangString, paramwrv.jdField_a_of_type_Int, paramwrv.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((yeb)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((yeb)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (ydd.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          ydd.a(paramydd).b(paramwrv.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          ydd.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((wlc)localObject1).a.length)
          {
            ykq.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramwrv.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      ykq.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return wrv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydq
 * JD-Core Version:    0.7.0.1
 */