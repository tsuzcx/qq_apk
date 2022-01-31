import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class urn
  extends sth<uqy, svy>
{
  public urn(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  private void c(@NonNull uqy paramuqy, @NonNull svy paramsvy)
  {
    if ((uqy.a(paramuqy) == null) || (!uqy.a(paramuqy).a.date.equals(paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      veg.b(this.TAG, "ignore this upload status event. %s.", paramsvy.toString());
      return;
    }
    veg.a(this.TAG, "receive upload status change event. %s.", paramsvy.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < uqy.a(paramuqy).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)uqy.a(paramuqy).a().get(i);
        if (!localStoryVideoItem.equals(paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramsvy.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramuqy.a();
        veg.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        uqy.a(paramuqy).a(localStoryVideoItem);
        uqy.a(paramuqy).a(paramsvy.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull svy paramsvy)
  {
    if (paramsvy.a()) {
      veg.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramsvy.c())
      {
        veg.a(this.TAG, "receive share group video upload status change event. %s.", paramsvy.toString());
        return;
      }
    } while (!paramsvy.b());
    veg.a(this.TAG, "receive personal video upload status change event. %s.", paramsvy.toString());
    c(paramuqy, paramsvy);
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull svy paramsvy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urn
 * JD-Core Version:    0.7.0.1
 */