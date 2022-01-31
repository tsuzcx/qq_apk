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

public class uxd
  extends QQUIEventReceiver<uwq, tlc>
{
  public uxd(uwq paramuwq1, @NonNull uwq paramuwq2)
  {
    super(paramuwq2);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull tlc paramtlc)
  {
    if ((TextUtils.isEmpty(paramtlc.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramtlc.jdField_b_of_type_JavaLangString)) || (paramtlc.jdField_a_of_type_Int == 0) || (paramtlc.jdField_a_of_type_Long == 0L))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramtlc.jdField_a_of_type_JavaLangString, paramtlc.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtlc.jdField_a_of_type_Int), Long.valueOf(paramtlc.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramuwq.a(paramtlc.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof uxo)))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramtlc.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (uxo)localObject1;
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramtlc.jdField_a_of_type_JavaLangString, paramtlc.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtlc.jdField_a_of_type_Int), Integer.valueOf(paramtlc.jdField_b_of_type_Int));
    localObject1 = ((uxo)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramtlc.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((tej)localObject1).a.length > paramtlc.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramtlc.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = uqe.a(paramtlc.jdField_a_of_type_JavaLangString, paramtlc.jdField_a_of_type_Int, paramtlc.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((uxo)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((uxo)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (uwq.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          uwq.a(paramuwq).b(paramtlc.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          uwq.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((tej)localObject1).a.length)
          {
            ved.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramtlc.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      ved.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return tlc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxd
 * JD-Core Version:    0.7.0.1
 */