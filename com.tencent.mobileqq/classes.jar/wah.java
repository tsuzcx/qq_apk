import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wah
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, vol>
{
  public wah(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull vol paramvol)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramvol.jdField_a_of_type_JavaLangString)) && ((paramvol.jdField_a_of_type_Vld instanceof vlo)))
    {
      paramvol = ((vlo)paramvol.jdField_a_of_type_Vld).a;
      if (paramvol != null) {
        paramQQStoryShareGroupProfileActivity.a(paramvol.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vol.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wah
 * JD-Core Version:    0.7.0.1
 */