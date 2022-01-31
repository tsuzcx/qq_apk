import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulq
  extends QQUIEventReceiver<IEventReceiver, tku>
{
  public ulq(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull tku paramtku)
  {
    if (paramtku.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      bcql.a(tsr.a(), 2, ajya.a(2131711043), 0).a();
      vei.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramtku.jdField_a_of_type_Int), "5" });
      return;
    }
    bcql.a(tsr.a(), 1, ajya.a(2131711038), 0).a();
    vei.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return tku.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulq
 * JD-Core Version:    0.7.0.1
 */