import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vxc
  extends QQUIEventReceiver<vwo, vhz>
{
  public vxc(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull vhz paramvhz)
  {
    if (!TextUtils.equals(paramvhz.b, String.valueOf(paramvwo.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramvwo.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramvwo.l();
    if (paramvhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wsv.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramvhz.jdField_a_of_type_JavaLangString);
      if (paramvhz.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        vhx.a().a(paramvwo.b(), paramvhz.jdField_a_of_type_JavaLangString);
        return;
      }
      vhx.a().a(paramvwo.b(), paramvhz.jdField_a_of_type_JavaLangString, paramvhz.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvwo.hashCode());
      return;
    }
    wsv.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131707260), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return vhz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */