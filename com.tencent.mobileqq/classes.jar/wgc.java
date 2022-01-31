import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class wgc
  extends uhw<wfn, ukn>
{
  public wgc(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  private void c(@NonNull wfn paramwfn, @NonNull ukn paramukn)
  {
    if ((wfn.a(paramwfn) == null) || (!wfn.a(paramwfn).a.date.equals(paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      wsv.b(this.TAG, "ignore this upload status event. %s.", paramukn.toString());
      return;
    }
    wsv.a(this.TAG, "receive upload status change event. %s.", paramukn.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < wfn.a(paramwfn).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)wfn.a(paramwfn).a().get(i);
        if (!localStoryVideoItem.equals(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramukn.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramwfn.a();
        wsv.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        wfn.a(paramwfn).a(localStoryVideoItem);
        wfn.a(paramwfn).a(paramukn.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull ukn paramukn)
  {
    if (paramukn.a()) {
      wsv.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramukn.c())
      {
        wsv.a(this.TAG, "receive share group video upload status change event. %s.", paramukn.toString());
        return;
      }
    } while (!paramukn.b());
    wsv.a(this.TAG, "receive personal video upload status change event. %s.", paramukn.toString());
    c(paramwfn, paramukn);
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull ukn paramukn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgc
 * JD-Core Version:    0.7.0.1
 */