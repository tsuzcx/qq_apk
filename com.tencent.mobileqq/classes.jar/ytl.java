import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ytl
  extends QQUIEventReceiver<ysw, wsm>
{
  public ytl(@NonNull ysw paramysw)
  {
    super(paramysw);
  }
  
  public void a(@NonNull ysw paramysw, @NonNull wsm paramwsm)
  {
    if (paramwsm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yuk.d(this.TAG, "deleted story failed");
      paramysw.a(5, paramwsm.jdField_a_of_type_JavaLangString);
      return;
    }
    paramysw.a(paramwsm.jdField_a_of_type_JavaLangString);
    paramysw.a(new yqf[] { new yqa(ypi.a(ysw.a(paramysw).a.jdField_a_of_type_JavaLangString)), (yqf)paramysw.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */