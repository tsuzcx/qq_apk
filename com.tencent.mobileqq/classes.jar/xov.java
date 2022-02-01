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

public class xov
  extends QQUIEventReceiver<xoi, wda>
{
  public xov(xoi paramxoi1, @NonNull xoi paramxoi2)
  {
    super(paramxoi2);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull wda paramwda)
  {
    if ((TextUtils.isEmpty(paramwda.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwda.jdField_b_of_type_JavaLangString)) || (paramwda.jdField_a_of_type_Int == 0) || (paramwda.jdField_a_of_type_Long == 0L))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramwda.jdField_a_of_type_JavaLangString, paramwda.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwda.jdField_a_of_type_Int), Long.valueOf(paramwda.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramxoi.a(paramwda.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof xpg)))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramwda.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (xpg)localObject1;
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramwda.jdField_a_of_type_JavaLangString, paramwda.jdField_b_of_type_JavaLangString, Integer.valueOf(paramwda.jdField_a_of_type_Int), Integer.valueOf(paramwda.jdField_b_of_type_Int));
    localObject1 = ((xpg)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramwda.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((vwh)localObject1).a.length > paramwda.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramwda.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = xhw.a(paramwda.jdField_a_of_type_JavaLangString, paramwda.jdField_a_of_type_Int, paramwda.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((xpg)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((xpg)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (xoi.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          xoi.a(paramxoi).b(paramwda.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          xoi.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((vwh)localObject1).a.length)
          {
            xvv.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramwda.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      xvv.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return wda.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xov
 * JD-Core Version:    0.7.0.1
 */