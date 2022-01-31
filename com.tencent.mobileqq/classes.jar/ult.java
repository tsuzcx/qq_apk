import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ult
  extends QQUIEventReceiver<IEventReceiver, tkx>
{
  public ult(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull tkx paramtkx)
  {
    if (paramtkx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      bcpw.a(tsu.a(), 2, ajyc.a(2131711032), 0).a();
      vel.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramtkx.jdField_a_of_type_Int), "5" });
      return;
    }
    bcpw.a(tsu.a(), 1, ajyc.a(2131711027), 0).a();
    vel.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return tkx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ult
 * JD-Core Version:    0.7.0.1
 */