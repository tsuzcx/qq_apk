import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xdj
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, voc>
{
  public xdj(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull voc paramvoc)
  {
    paramvoc = paramvoc.a;
    if (paramvoc == null) {}
    while (xqc.a(paramvoc.mUploadStatus) != 3) {
      return;
    }
    paramQQStoryShareGroupProfileActivity.b = true;
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdj
 * JD-Core Version:    0.7.0.1
 */