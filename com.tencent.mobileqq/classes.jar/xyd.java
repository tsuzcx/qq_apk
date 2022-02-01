import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyd
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wii>
{
  public xyd(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wii paramwii)
  {
    paramwii = paramwii.a;
    if (paramwii == null) {}
    while (ykw.a(paramwii.mUploadStatus) != 3) {
      return;
    }
    paramQQStoryShareGroupProfileActivity.b = true;
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyd
 * JD-Core Version:    0.7.0.1
 */