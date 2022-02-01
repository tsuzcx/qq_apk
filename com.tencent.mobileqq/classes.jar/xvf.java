import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xvf
  extends QQUIEventReceiver<xui, wor>
{
  public xvf(@NonNull xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull wor paramwor)
  {
    paramxui.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxui.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    yqp.b(this.TAG, "delete onEvent");
    if ((!paramwor.jdField_a_of_type_Boolean) && (paramwor.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        yqp.d(this.TAG, "删除失败：%s", new Object[] { paramwor.a() });
      }
      QQToast.a(paramxui.b(), 1, anni.a(2131705662), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvf
 * JD-Core Version:    0.7.0.1
 */