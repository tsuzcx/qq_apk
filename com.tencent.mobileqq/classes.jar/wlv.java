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

public class wlv
  extends QQUIEventReceiver<wli, uzu>
{
  public wlv(wli paramwli1, @NonNull wli paramwli2)
  {
    super(paramwli2);
  }
  
  public void a(@NonNull wli paramwli, @NonNull uzu paramuzu)
  {
    if ((TextUtils.isEmpty(paramuzu.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramuzu.jdField_b_of_type_JavaLangString)) || (paramuzu.jdField_a_of_type_Int == 0) || (paramuzu.jdField_a_of_type_Long == 0L))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramuzu.jdField_a_of_type_JavaLangString, paramuzu.jdField_b_of_type_JavaLangString, Integer.valueOf(paramuzu.jdField_a_of_type_Int), Long.valueOf(paramuzu.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramwli.a(paramuzu.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof wmg)))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramuzu.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (wmg)localObject1;
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramuzu.jdField_a_of_type_JavaLangString, paramuzu.jdField_b_of_type_JavaLangString, Integer.valueOf(paramuzu.jdField_a_of_type_Int), Integer.valueOf(paramuzu.jdField_b_of_type_Int));
    localObject1 = ((wmg)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramuzu.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((utb)localObject1).a.length > paramuzu.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramuzu.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = wew.a(paramuzu.jdField_a_of_type_JavaLangString, paramuzu.jdField_a_of_type_Int, paramuzu.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((wmg)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((wmg)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (wli.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          wli.a(paramwli).b(paramuzu.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          wli.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((utb)localObject1).a.length)
          {
            wsv.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramuzu.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      wsv.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return uzu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlv
 * JD-Core Version:    0.7.0.1
 */