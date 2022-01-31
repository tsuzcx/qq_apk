import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uls
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tzw>
{
  public uls(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tzw paramtzw)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramtzw.jdField_a_of_type_JavaLangString)) && ((paramtzw.jdField_a_of_type_Two instanceof twz)))
    {
      paramtzw = ((twz)paramtzw.jdField_a_of_type_Two).a;
      if (paramtzw != null) {
        paramQQStoryShareGroupProfileActivity.a(paramtzw.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uls
 * JD-Core Version:    0.7.0.1
 */