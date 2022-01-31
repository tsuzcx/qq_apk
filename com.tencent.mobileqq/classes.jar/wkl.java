import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class wkl
  extends umf<wjw, uow>
{
  public wkl(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  private void c(@NonNull wjw paramwjw, @NonNull uow paramuow)
  {
    if ((wjw.a(paramwjw) == null) || (!wjw.a(paramwjw).a.date.equals(paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      wxe.b(this.TAG, "ignore this upload status event. %s.", paramuow.toString());
      return;
    }
    wxe.a(this.TAG, "receive upload status change event. %s.", paramuow.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < wjw.a(paramwjw).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)wjw.a(paramwjw).a().get(i);
        if (!localStoryVideoItem.equals(paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramuow.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramwjw.a();
        wxe.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        wjw.a(paramwjw).a(localStoryVideoItem);
        wjw.a(paramwjw).a(paramuow.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull uow paramuow)
  {
    if (paramuow.a()) {
      wxe.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramuow.c())
      {
        wxe.a(this.TAG, "receive share group video upload status change event. %s.", paramuow.toString());
        return;
      }
    } while (!paramuow.b());
    wxe.a(this.TAG, "receive personal video upload status change event. %s.", paramuow.toString());
    c(paramwjw, paramuow);
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkl
 * JD-Core Version:    0.7.0.1
 */