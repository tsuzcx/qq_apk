import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xdi
  extends QQUIEventReceiver<IEventReceiver, wcs>
{
  public xdi(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull wcs paramwcs)
  {
    if (paramwcs.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(wkp.a(), 2, amtj.a(2131710144), 0).a();
      xwa.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramwcs.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(wkp.a(), 1, amtj.a(2131710139), 0).a();
    xwa.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return wcs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdi
 * JD-Core Version:    0.7.0.1
 */