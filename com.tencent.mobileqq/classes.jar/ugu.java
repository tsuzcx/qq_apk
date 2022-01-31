import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugu
  extends QQUIEventReceiver<ugk, tth>
{
  public ugu(@NonNull ugk paramugk)
  {
    super(paramugk);
  }
  
  public void a(@NonNull ugk paramugk, @NonNull tth paramtth)
  {
    if (!TextUtils.equals(paramtth.b, String.valueOf(paramugk.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramugk.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramugk.l();
    if (paramtth.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ved.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramtth.jdField_a_of_type_JavaLangString);
      if (paramtth.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        ttf.a().a(paramugk.b(), paramtth.jdField_a_of_type_JavaLangString);
        return;
      }
      ttf.a().a(paramugk.b(), paramtth.jdField_a_of_type_JavaLangString, paramtth.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramugk.hashCode());
      return;
    }
    ved.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131701174), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return tth.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugu
 * JD-Core Version:    0.7.0.1
 */