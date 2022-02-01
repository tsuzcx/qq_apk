import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxb
  extends QQUIEventReceiver<xwr, xjp>
{
  public xxb(@NonNull xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull xjp paramxjp)
  {
    if (!TextUtils.equals(paramxjp.b, String.valueOf(paramxwr.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramxwr.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramxwr.l();
    if (paramxjp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yuk.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramxjp.jdField_a_of_type_JavaLangString);
      if (paramxjp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        xjn.a().a(paramxwr.b(), paramxjp.jdField_a_of_type_JavaLangString);
        return;
      }
      xjn.a().a(paramxwr.b(), paramxjp.jdField_a_of_type_JavaLangString, paramxjp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxwr.hashCode());
      return;
    }
    yuk.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131700086), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return xjp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxb
 * JD-Core Version:    0.7.0.1
 */