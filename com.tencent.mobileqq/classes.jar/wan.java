import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wan
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wbc>
{
  public wan(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wbc paramwbc)
  {
    if (paramwbc.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.g = true;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Wbb.a();
      paramQQStoryShareGroupProfileActivity.b(true);
      paramwbc = paramQQStoryShareGroupProfileActivity.b;
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label82;
      }
    }
    label82:
    for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
    {
      wta.a("share_story", "clk_rank", 0, 0, new String[] { paramwbc, paramQQStoryShareGroupProfileActivity });
      return;
      if (paramwbc.a != 0) {
        break;
      }
      paramQQStoryShareGroupProfileActivity.g = false;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return wbc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wan
 * JD-Core Version:    0.7.0.1
 */