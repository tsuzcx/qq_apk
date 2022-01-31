import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wwf
  extends QQUIEventReceiver<wvq, uvf>
{
  public wwf(@NonNull wvq paramwvq)
  {
    super(paramwvq);
  }
  
  public void a(@NonNull wvq paramwvq, @NonNull uvf paramuvf)
  {
    if (paramuvf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wxe.d(this.TAG, "deleted story failed");
      paramwvq.a(5, paramuvf.jdField_a_of_type_JavaLangString);
      return;
    }
    paramwvq.a(paramuvf.jdField_a_of_type_JavaLangString);
    paramwvq.a(new wsz[] { new wsu(wsc.a(wvq.a(paramwvq).a.jdField_a_of_type_JavaLangString)), (wsz)paramwvq.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return uvf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwf
 * JD-Core Version:    0.7.0.1
 */