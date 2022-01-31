import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import java.util.List;

public class uer
  extends sgl<uec, sjc>
{
  public uer(uec paramuec)
  {
    super(paramuec);
  }
  
  private void c(@NonNull uec paramuec, @NonNull sjc paramsjc)
  {
    if ((uec.a(paramuec) == null) || (!uec.a(paramuec).a.date.equals(paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date)))
    {
      urk.b(this.TAG, "ignore this upload status event. %s.", paramsjc.toString());
      return;
    }
    urk.a(this.TAG, "receive upload status change event. %s.", paramsjc.toString());
    int i = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      if (i < uec.a(paramuec).a().size())
      {
        localStoryVideoItem = (StoryVideoItem)uec.a(paramuec).a().get(i);
        if (!localStoryVideoItem.equals(paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)) {
          break label159;
        }
        if (paramsjc.b != null) {
          break label135;
        }
        localStoryVideoItem.copy(paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      for (;;)
      {
        paramuec.a();
        urk.d(this.TAG, "can't find the video whose state has been changed.");
        return;
        label135:
        uec.a(paramuec).a(localStoryVideoItem);
        uec.a(paramuec).a(paramsjc.b, i);
      }
      label159:
      i += 1;
    }
  }
  
  public void a(@NonNull uec paramuec, @NonNull sjc paramsjc)
  {
    if (paramsjc.a()) {
      urk.b(this.TAG, "ignore this upload status event, because it's a troop video.");
    }
    do
    {
      return;
      if (paramsjc.c())
      {
        urk.a(this.TAG, "receive share group video upload status change event. %s.", paramsjc.toString());
        return;
      }
    } while (!paramsjc.b());
    urk.a(this.TAG, "receive personal video upload status change event. %s.", paramsjc.toString());
    c(paramuec, paramsjc);
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull sjc paramsjc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uer
 * JD-Core Version:    0.7.0.1
 */