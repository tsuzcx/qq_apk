import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xdh
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wrl>
{
  public xdh(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wrl paramwrl)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramwrl.jdField_a_of_type_JavaLangString)) && ((paramwrl.jdField_a_of_type_Wod instanceof woo)))
    {
      paramwrl = ((woo)paramwrl.jdField_a_of_type_Wod).a;
      if (paramwrl != null) {
        paramQQStoryShareGroupProfileActivity.a(paramwrl.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wrl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdh
 * JD-Core Version:    0.7.0.1
 */