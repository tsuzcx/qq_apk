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

public class wqe
  extends QQUIEventReceiver<wpr, ved>
{
  public wqe(wpr paramwpr1, @NonNull wpr paramwpr2)
  {
    super(paramwpr2);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull ved paramved)
  {
    if ((TextUtils.isEmpty(paramved.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramved.jdField_b_of_type_JavaLangString)) || (paramved.jdField_a_of_type_Int == 0) || (paramved.jdField_a_of_type_Long == 0L))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramved.jdField_a_of_type_JavaLangString, paramved.jdField_b_of_type_JavaLangString, Integer.valueOf(paramved.jdField_a_of_type_Int), Long.valueOf(paramved.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramwpr.a(paramved.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wqp)))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramved.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wqp)localObject1;
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramved.jdField_a_of_type_JavaLangString, paramved.jdField_b_of_type_JavaLangString, Integer.valueOf(paramved.jdField_a_of_type_Int), Integer.valueOf(paramved.jdField_b_of_type_Int));
    localObject1 = ((wqp)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramved.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((uxk)localObject1).a.length > paramved.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramved.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = wjf.a(paramved.jdField_a_of_type_JavaLangString, paramved.jdField_a_of_type_Int, paramved.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((wqp)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((wqp)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (wpr.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          wpr.a(paramwpr).b(paramved.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          wpr.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((uxk)localObject1).a.length)
          {
            wxe.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramved.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      wxe.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return ved.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */