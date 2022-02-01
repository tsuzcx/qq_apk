import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyc
  extends QQUIEventReceiver<IEventReceiver, wxh>
{
  public xyc(@NonNull IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull wxh paramwxh)
  {
    if (paramwxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      QQToast.a(xfe.a(), 2, anni.a(2131709803), 0).a();
      yqu.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(paramwxh.jdField_a_of_type_Int), "5" });
      return;
    }
    QQToast.a(xfe.a(), 1, anni.a(2131709798), 0).a();
    yqu.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
  }
  
  public Class acceptEventClass()
  {
    return wxh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyc
 * JD-Core Version:    0.7.0.1
 */