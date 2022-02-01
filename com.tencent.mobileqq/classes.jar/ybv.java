import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybv
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xaa>
{
  public ybv(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xaa paramxaa)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramxaa);
  }
  
  public Class acceptEventClass()
  {
    return xaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybv
 * JD-Core Version:    0.7.0.1
 */