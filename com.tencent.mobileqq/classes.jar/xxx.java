import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class xxx
  extends wag<xxi, wcx>
{
  public xxx(xxi paramxxi)
  {
    super(paramxxi);
  }
  
  private void c(@NonNull xxi paramxxi, @NonNull wcx paramwcx)
  {
    if ((xxi.a(paramxxi) == null) || (!xxi.a(paramxxi).a.date.equals(paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      ykq.b(this.TAG, "ignore this upload status event. %s.", paramwcx.toString());
      return;
    }
    ykq.a(this.TAG, "receive upload status change event. %s.", paramwcx.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < xxi.a(paramxxi).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)xxi.a(paramxxi).a().get(i);
        if (!localStoryVideoItem.equals(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramwcx.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramxxi.a();
        ykq.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        xxi.a(paramxxi).a(localStoryVideoItem);
        xxi.a(paramxxi).a(paramwcx.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wcx paramwcx)
  {
    if (paramwcx.a()) {
      ykq.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramwcx.c())
      {
        ykq.a(this.TAG, "receive share group video upload status change event. %s.", paramwcx.toString());
        return;
      }
    } while (!paramwcx.b());
    ykq.a(this.TAG, "receive personal video upload status change event. %s.", paramwcx.toString());
    c(paramxxi, paramwcx);
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
  
  public void b(@NonNull xxi paramxxi, @NonNull wcx paramwcx) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxx
 * JD-Core Version:    0.7.0.1
 */