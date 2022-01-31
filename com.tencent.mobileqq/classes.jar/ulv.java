import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulv
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, umk>
{
  public ulv(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull umk paramumk)
  {
    if (paramumk.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.g = true;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Umj.a();
      paramQQStoryShareGroupProfileActivity.b(true);
      paramumk = paramQQStoryShareGroupProfileActivity.b;
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label82;
      }
    }
    label82:
    for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
    {
      vei.a("share_story", "clk_rank", 0, 0, new String[] { paramumk, paramQQStoryShareGroupProfileActivity });
      return;
      if (paramumk.a != 0) {
        break;
      }
      paramQQStoryShareGroupProfileActivity.g = false;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return umk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulv
 * JD-Core Version:    0.7.0.1
 */