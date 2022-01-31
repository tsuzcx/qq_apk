import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class twa
  extends QQUIEventReceiver<tvd, spl>
{
  public twa(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull spl paramspl)
  {
    paramtvd.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramtvd.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    urk.b(this.TAG, "delete onEvent");
    if ((!paramspl.jdField_a_of_type_Boolean) && (paramspl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        urk.d(this.TAG, "删除失败：%s", new Object[] { paramspl.a() });
      }
      bbmy.a(paramtvd.b(), 1, ajjy.a(2131641091), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return spl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twa
 * JD-Core Version:    0.7.0.1
 */