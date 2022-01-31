import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class waj
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, ukn>
{
  public waj(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull ukn paramukn)
  {
    paramukn = paramukn.a;
    if (paramukn == null) {}
    while (wnc.a(paramukn.mUploadStatus) != 3) {
      return;
    }
    paramQQStoryShareGroupProfileActivity.b = true;
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */