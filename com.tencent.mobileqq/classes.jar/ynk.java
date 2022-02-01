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

public class ynk
  extends QQUIEventReceiver<ymx, xbk>
{
  public ynk(ymx paramymx1, @NonNull ymx paramymx2)
  {
    super(paramymx2);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull xbk paramxbk)
  {
    if ((TextUtils.isEmpty(paramxbk.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramxbk.jdField_b_of_type_JavaLangString)) || (paramxbk.jdField_a_of_type_Int == 0) || (paramxbk.jdField_a_of_type_Long == 0L))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramxbk.jdField_a_of_type_JavaLangString, paramxbk.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxbk.jdField_a_of_type_Int), Long.valueOf(paramxbk.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramymx.a(paramxbk.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof ynv)))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramxbk.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (ynv)localObject1;
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramxbk.jdField_a_of_type_JavaLangString, paramxbk.jdField_b_of_type_JavaLangString, Integer.valueOf(paramxbk.jdField_a_of_type_Int), Integer.valueOf(paramxbk.jdField_b_of_type_Int));
    localObject1 = ((ynv)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramxbk.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((wur)localObject1).a.length > paramxbk.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramxbk.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ygl.a(paramxbk.jdField_a_of_type_JavaLangString, paramxbk.jdField_a_of_type_Int, paramxbk.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((ynv)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((ynv)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (ymx.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          ymx.a(paramymx).b(paramxbk.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          ymx.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((wur)localObject1).a.length)
          {
            yuk.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramxbk.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      yuk.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return xbk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynk
 * JD-Core Version:    0.7.0.1
 */