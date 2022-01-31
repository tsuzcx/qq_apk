import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wae
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, vad>
{
  public wae(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull vad paramvad)
  {
    if (paramvad.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramvad);
    }
  }
  
  public Class acceptEventClass()
  {
    return vad.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wae
 * JD-Core Version:    0.7.0.1
 */