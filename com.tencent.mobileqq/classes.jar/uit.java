import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uit
  extends QQUIEventReceiver<uhw, tce>
{
  public uit(@NonNull uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull tce paramtce)
  {
    paramuhw.l();
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramuhw.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    ved.b(this.TAG, "delete onEvent");
    if ((!paramtce.jdField_a_of_type_Boolean) && (paramtce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
    {
      if (QLog.isColorLevel()) {
        ved.d(this.TAG, "删除失败：%s", new Object[] { paramtce.a() });
      }
      bcql.a(paramuhw.b(), 1, ajya.a(2131706887), 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return tce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uit
 * JD-Core Version:    0.7.0.1
 */