import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vxl
  extends QQUIEventReceiver<vwo, uqw>
{
  public vxl(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull uqw paramuqw)
  {
    paramvwo.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramvwo.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    wsv.b(this.TAG, "delete onEvent");
    if ((!paramuqw.jdField_a_of_type_Boolean) && (paramuqw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        wsv.d(this.TAG, "删除失败：%s", new Object[] { paramuqw.a() });
      }
      QQToast.a(paramvwo.b(), 1, alpo.a(2131707259), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return uqw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */