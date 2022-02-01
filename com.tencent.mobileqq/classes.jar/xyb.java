import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyb
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xmf>
{
  public xyb(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xmf paramxmf)
  {
    if ((paramQQStoryShareGroupProfileActivity.a().equals(paramxmf.jdField_a_of_type_JavaLangString)) && ((paramxmf.jdField_a_of_type_Xix instanceof xji)))
    {
      paramxmf = ((xji)paramxmf.jdField_a_of_type_Xix).a;
      if (paramxmf != null) {
        paramQQStoryShareGroupProfileActivity.a(paramxmf.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyb
 * JD-Core Version:    0.7.0.1
 */