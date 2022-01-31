import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulp
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tlo>
{
  public ulp(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tlo paramtlo)
  {
    if (paramtlo.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramtlo);
    }
  }
  
  public Class acceptEventClass()
  {
    return tlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulp
 * JD-Core Version:    0.7.0.1
 */