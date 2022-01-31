import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wai
  extends QQUIEventReceiver<IEventReceiver, uzm>
{
  public wai(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull uzm paramuzm)
  {
    if (paramuzm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(vhj.a(), 2, alpo.a(2131711415), 0).a();
      wta.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramuzm.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(vhj.a(), 1, alpo.a(2131711410), 0).a();
    wta.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return uzm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wai
 * JD-Core Version:    0.7.0.1
 */