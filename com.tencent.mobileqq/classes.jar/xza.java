import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xza
  extends QQUIEventReceiver<xyd, wsm>
{
  public xza(@NonNull xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull wsm paramwsm)
  {
    paramxyd.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxyd.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    yuk.b(this.TAG, "delete onEvent");
    if ((!paramwsm.jdField_a_of_type_Boolean) && (paramwsm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        yuk.d(this.TAG, "删除失败：%s", new Object[] { paramwsm.a() });
      }
      QQToast.a(paramxyd.b(), 1, anzj.a(2131705769), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xza
 * JD-Core Version:    0.7.0.1
 */