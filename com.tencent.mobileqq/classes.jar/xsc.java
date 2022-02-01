import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xsc
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xgg>
{
  public xsc(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xgg paramxgg)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramxgg.jdField_a_of_type_JavaLangString)) && ((paramxgg.jdField_a_of_type_Xcy instanceof xdj)))
    {
      paramxgg = ((xdj)paramxgg.jdField_a_of_type_Xcy).a;
      if (paramxgg != null) {
        paramQQStoryShareGroupProfileActivity.a(paramxgg.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xgg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsc
 * JD-Core Version:    0.7.0.1
 */