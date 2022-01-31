import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulp
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tzt>
{
  public ulp(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tzt paramtzt)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramtzt.jdField_a_of_type_JavaLangString)) && ((paramtzt.jdField_a_of_type_Twl instanceof tww)))
    {
      paramtzt = ((tww)paramtzt.jdField_a_of_type_Twl).a;
      if (paramtzt != null) {
        paramQQStoryShareGroupProfileActivity.a(paramtzt.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulp
 * JD-Core Version:    0.7.0.1
 */