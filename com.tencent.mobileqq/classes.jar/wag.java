import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wag
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, uyk>
{
  public wag(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull uyk paramuyk)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramuyk);
  }
  
  public Class acceptEventClass()
  {
    return uyk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wag
 * JD-Core Version:    0.7.0.1
 */