import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class xjc
  extends vll<xin, voc>
{
  public xjc(xin paramxin)
  {
    super(paramxin);
  }
  
  private void c(@NonNull xin paramxin, @NonNull voc paramvoc)
  {
    if ((xin.a(paramxin) == null) || (!xin.a(paramxin).a.date.equals(paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      xvv.b(this.TAG, "ignore this upload status event. %s.", paramvoc.toString());
      return;
    }
    xvv.a(this.TAG, "receive upload status change event. %s.", paramvoc.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < xin.a(paramxin).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)xin.a(paramxin).a().get(i);
        if (!localStoryVideoItem.equals(paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramvoc.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramxin.a();
        xvv.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        xin.a(paramxin).a(localStoryVideoItem);
        xin.a(paramxin).a(paramvoc.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull xin paramxin, @NonNull voc paramvoc)
  {
    if (paramvoc.a()) {
      xvv.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramvoc.c())
      {
        xvv.a(this.TAG, "receive share group video upload status change event. %s.", paramvoc.toString());
        return;
      }
    } while (!paramvoc.b());
    xvv.a(this.TAG, "receive personal video upload status change event. %s.", paramvoc.toString());
    c(paramxin, paramvoc);
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
  
  public void b(@NonNull xin paramxin, @NonNull voc paramvoc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */