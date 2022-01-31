import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulu
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, svy>
{
  public ulu(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull svy paramsvy)
  {
    paramsvy = paramsvy.a;
    if (paramsvy == null) {}
    while (uyn.a(paramsvy.mUploadStatus) != 3) {
      return;
    }
    paramQQStoryShareGroupProfileActivity.b = true;
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */