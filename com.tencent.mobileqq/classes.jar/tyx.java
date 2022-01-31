import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tyx
  extends QQUIEventReceiver<IEventReceiver, syb>
{
  public tyx(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull syb paramsyb)
  {
    if (paramsyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      bbmy.a(tfy.a(), 2, ajjy.a(2131645244), 0).a();
      urp.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramsyb.jdField_a_of_type_Int), "5" });
      return;
    }
    bbmy.a(tfy.a(), 1, ajjy.a(2131645239), 0).a();
    urp.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return syb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyx
 * JD-Core Version:    0.7.0.1
 */