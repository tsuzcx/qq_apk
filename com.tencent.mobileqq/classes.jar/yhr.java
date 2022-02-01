import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class yhr
  extends wjm<yhc, wmd>
{
  public yhr(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  private void c(@NonNull yhc paramyhc, @NonNull wmd paramwmd)
  {
    if ((yhc.a(paramyhc) == null) || (!yhc.a(paramyhc).a.date.equals(paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      yuk.b(this.TAG, "ignore this upload status event. %s.", paramwmd.toString());
      return;
    }
    yuk.a(this.TAG, "receive upload status change event. %s.", paramwmd.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < yhc.a(paramyhc).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)yhc.a(paramyhc).a().get(i);
        if (!localStoryVideoItem.equals(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramwmd.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramyhc.a();
        yuk.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        yhc.a(paramyhc).a(localStoryVideoItem);
        yhc.a(paramyhc).a(paramwmd.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull wmd paramwmd)
  {
    if (paramwmd.a()) {
      yuk.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramwmd.c())
      {
        yuk.a(this.TAG, "receive share group video upload status change event. %s.", paramwmd.toString());
        return;
      }
    } while (!paramwmd.b());
    yuk.a(this.TAG, "receive personal video upload status change event. %s.", paramwmd.toString());
    c(paramyhc, paramwmd);
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull wmd paramwmd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhr
 * JD-Core Version:    0.7.0.1
 */