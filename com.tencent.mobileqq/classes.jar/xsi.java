import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xsi
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xsx>
{
  public xsi(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xsx paramxsx)
  {
    if (paramxsx.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.g = true;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Xsw.a();
      paramQQStoryShareGroupProfileActivity.b(true);
      paramxsx = paramQQStoryShareGroupProfileActivity.b;
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label82;
      }
    }
    label82:
    for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
    {
      ykv.a("share_story", "clk_rank", 0, 0, new String[] { paramxsx, paramQQStoryShareGroupProfileActivity });
      return;
      if (paramxsx.a != 0) {
        break;
      }
      paramQQStoryShareGroupProfileActivity.g = false;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return xsx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsi
 * JD-Core Version:    0.7.0.1
 */