import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybw
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xqa>
{
  public ybw(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xqa paramxqa)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramxqa.jdField_a_of_type_JavaLangString)) && ((paramxqa.jdField_a_of_type_Xms instanceof xnd)))
    {
      paramxqa = ((xnd)paramxqa.jdField_a_of_type_Xms).a;
      if (paramxqa != null) {
        paramQQStoryShareGroupProfileActivity.a(paramxqa.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xqa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybw
 * JD-Core Version:    0.7.0.1
 */