import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class urk
  extends ste<uqv, svv>
{
  public urk(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  private void c(@NonNull uqv paramuqv, @NonNull svv paramsvv)
  {
    if ((uqv.a(paramuqv) == null) || (!uqv.a(paramuqv).a.date.equals(paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      ved.b(this.TAG, "ignore this upload status event. %s.", paramsvv.toString());
      return;
    }
    ved.a(this.TAG, "receive upload status change event. %s.", paramsvv.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < uqv.a(paramuqv).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)uqv.a(paramuqv).a().get(i);
        if (!localStoryVideoItem.equals(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramsvv.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramuqv.a();
        ved.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        uqv.a(paramuqv).a(localStoryVideoItem);
        uqv.a(paramuqv).a(paramsvv.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull svv paramsvv)
  {
    if (paramsvv.a()) {
      ved.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramsvv.c())
      {
        ved.a(this.TAG, "receive share group video upload status change event. %s.", paramsvv.toString());
        return;
      }
    } while (!paramsvv.b());
    ved.a(this.TAG, "receive personal video upload status change event. %s.", paramsvv.toString());
    c(paramuqv, paramsvv);
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull svv paramsvv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urk
 * JD-Core Version:    0.7.0.1
 */