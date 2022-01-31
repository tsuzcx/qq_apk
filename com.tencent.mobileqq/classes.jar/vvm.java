import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vvm
  extends QQUIEventReceiver<vvc, vhz>
{
  public vvm(@NonNull vvc paramvvc)
  {
    super(paramvvc);
  }
  
  public void a(@NonNull vvc paramvvc, @NonNull vhz paramvhz)
  {
    if (!TextUtils.equals(paramvhz.b, String.valueOf(paramvvc.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramvvc.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramvvc.l();
    if (paramvhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wsv.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramvhz.jdField_a_of_type_JavaLangString);
      if (paramvhz.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        vhx.a().a(paramvvc.b(), paramvhz.jdField_a_of_type_JavaLangString);
        return;
      }
      vhx.a().a(paramvvc.b(), paramvhz.jdField_a_of_type_JavaLangString, paramvhz.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvvc.hashCode());
      return;
    }
    wsv.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131701543), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return vhz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvm
 * JD-Core Version:    0.7.0.1
 */