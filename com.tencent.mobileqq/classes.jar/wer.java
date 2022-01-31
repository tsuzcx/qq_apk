import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wer
  extends QQUIEventReceiver<IEventReceiver, vdv>
{
  public wer(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull vdv paramvdv)
  {
    if (paramvdv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(vls.a(), 2, alud.a(2131711427), 0).a();
      wxj.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramvdv.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(vls.a(), 1, alud.a(2131711422), 0).a();
    wxj.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return vdv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wer
 * JD-Core Version:    0.7.0.1
 */