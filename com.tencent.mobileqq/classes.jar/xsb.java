import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xsb
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wql>
{
  public xsb(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wql paramwql)
  {
    if (!paramQQStoryShareGroupProfileActivity.g) {
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramwql);
  }
  
  public Class acceptEventClass()
  {
    return wql.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsb
 * JD-Core Version:    0.7.0.1
 */