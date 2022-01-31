import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class weq
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, vsu>
{
  public weq(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull vsu paramvsu)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramvsu.jdField_a_of_type_JavaLangString)) && ((paramvsu.jdField_a_of_type_Vpm instanceof vpx)))
    {
      paramvsu = ((vpx)paramvsu.jdField_a_of_type_Vpm).a;
      if (paramvsu != null) {
        paramQQStoryShareGroupProfileActivity.a(paramvsu.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vsu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     weq
 * JD-Core Version:    0.7.0.1
 */