import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tyw
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tna>
{
  public tyw(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tna paramtna)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramtna.jdField_a_of_type_JavaLangString)) && ((paramtna.jdField_a_of_type_Tjs instanceof tkd)))
    {
      paramtna = ((tkd)paramtna.jdField_a_of_type_Tjs).a;
      if (paramtna != null) {
        paramQQStoryShareGroupProfileActivity.a(paramtna.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyw
 * JD-Core Version:    0.7.0.1
 */