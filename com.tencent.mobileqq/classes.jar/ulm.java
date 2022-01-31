import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulm
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tll>
{
  public ulm(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tll paramtll)
  {
    if (paramtll.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramtll);
    }
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulm
 * JD-Core Version:    0.7.0.1
 */