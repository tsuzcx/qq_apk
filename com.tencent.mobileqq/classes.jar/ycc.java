import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ycc
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, ycr>
{
  public ycc(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull ycr paramycr)
  {
    if (paramycr.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.g = true;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Ycq.a();
      paramQQStoryShareGroupProfileActivity.b(true);
      paramycr = paramQQStoryShareGroupProfileActivity.b;
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label82;
      }
    }
    label82:
    for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
    {
      yup.a("share_story", "clk_rank", 0, 0, new String[] { paramycr, paramQQStoryShareGroupProfileActivity });
      return;
      if (paramycr.a != 0) {
        break;
      }
      paramQQStoryShareGroupProfileActivity.g = false;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return ycr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */