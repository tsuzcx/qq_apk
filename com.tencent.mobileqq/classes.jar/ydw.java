import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class ydw
  extends wfr<ydh, wii>
{
  public ydw(ydh paramydh)
  {
    super(paramydh);
  }
  
  private void c(@NonNull ydh paramydh, @NonNull wii paramwii)
  {
    if ((ydh.a(paramydh) == null) || (!ydh.a(paramydh).a.date.equals(paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      yqp.b(this.TAG, "ignore this upload status event. %s.", paramwii.toString());
      return;
    }
    yqp.a(this.TAG, "receive upload status change event. %s.", paramwii.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < ydh.a(paramydh).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)ydh.a(paramydh).a().get(i);
        if (!localStoryVideoItem.equals(paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramwii.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramydh.a();
        yqp.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        ydh.a(paramydh).a(localStoryVideoItem);
        ydh.a(paramydh).a(paramwii.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wii paramwii)
  {
    if (paramwii.a()) {
      yqp.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramwii.c())
      {
        yqp.a(this.TAG, "receive share group video upload status change event. %s.", paramwii.toString());
        return;
      }
    } while (!paramwii.b());
    yqp.a(this.TAG, "receive personal video upload status change event. %s.", paramwii.toString());
    c(paramydh, paramwii);
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull wii paramwii) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydw
 * JD-Core Version:    0.7.0.1
 */