import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybx
  extends QQUIEventReceiver<IEventReceiver, xbc>
{
  public ybx(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull xbc paramxbc)
  {
    if (paramxbc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(xiz.a(), 2, anzj.a(2131709912), 0).a();
      yup.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramxbc.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(xiz.a(), 1, anzj.a(2131709907), 0).a();
    yup.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return xbc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybx
 * JD-Core Version:    0.7.0.1
 */