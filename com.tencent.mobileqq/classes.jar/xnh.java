import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xnh
  extends QQUIEventReceiver<xmx, xaa>
{
  public xnh(@NonNull xmx paramxmx)
  {
    super(paramxmx);
  }
  
  public void a(@NonNull xmx paramxmx, @NonNull xaa paramxaa)
  {
    if (!TextUtils.equals(paramxaa.b, String.valueOf(paramxmx.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxmx.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramxmx.l();
    if (paramxaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ykq.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramxaa.jdField_a_of_type_JavaLangString);
      if (paramxaa.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        wzy.a().a(paramxmx.b(), paramxaa.jdField_a_of_type_JavaLangString);
        return;
      }
      wzy.a().a(paramxmx.b(), paramxaa.jdField_a_of_type_JavaLangString, paramxaa.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxmx.hashCode());
      return;
    }
    ykq.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131700672), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return xaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnh
 * JD-Core Version:    0.7.0.1
 */