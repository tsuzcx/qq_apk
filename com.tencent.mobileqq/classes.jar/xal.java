import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xal
  extends QQUIEventReceiver<wzo, vuc>
{
  public xal(@NonNull wzo paramwzo)
  {
    super(paramwzo);
  }
  
  public void a(@NonNull wzo paramwzo, @NonNull vuc paramvuc)
  {
    paramwzo.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramwzo.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    xvv.b(this.TAG, "delete onEvent");
    if ((!paramvuc.jdField_a_of_type_Boolean) && (paramvuc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        xvv.d(this.TAG, "删除失败：%s", new Object[] { paramvuc.a() });
      }
      QQToast.a(paramwzo.b(), 1, amtj.a(2131705999), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xal
 * JD-Core Version:    0.7.0.1
 */