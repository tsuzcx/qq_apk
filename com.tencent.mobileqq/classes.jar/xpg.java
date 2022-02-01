import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpg
  extends QQUIEventReceiver<xoj, wix>
{
  public xpg(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull wix paramwix)
  {
    paramxoj.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxoj.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    ykq.b(this.TAG, "delete onEvent");
    if ((!paramwix.jdField_a_of_type_Boolean) && (paramwix.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        ykq.d(this.TAG, "删除失败：%s", new Object[] { paramwix.a() });
      }
      QQToast.a(paramxoj.b(), 1, anvx.a(2131706350), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpg
 * JD-Core Version:    0.7.0.1
 */