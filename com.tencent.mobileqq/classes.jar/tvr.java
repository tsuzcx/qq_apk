import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tvr
  extends QQUIEventReceiver<tvd, tgo>
{
  public tvr(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull tgo paramtgo)
  {
    if (!TextUtils.equals(paramtgo.b, String.valueOf(paramtvd.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramtvd.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramtvd.l();
    if (paramtgo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      urk.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramtgo.jdField_a_of_type_JavaLangString);
      if (paramtgo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        tgm.a().a(paramtvd.b(), paramtgo.jdField_a_of_type_JavaLangString);
        return;
      }
      tgm.a().a(paramtvd.b(), paramtgo.jdField_a_of_type_JavaLangString, paramtgo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtvd.hashCode());
      return;
    }
    urk.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131641092), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return tgo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvr
 * JD-Core Version:    0.7.0.1
 */