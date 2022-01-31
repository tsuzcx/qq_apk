import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugx
  extends QQUIEventReceiver<ugn, ttk>
{
  public ugx(@NonNull ugn paramugn)
  {
    super(paramugn);
  }
  
  public void a(@NonNull ugn paramugn, @NonNull ttk paramttk)
  {
    if (!TextUtils.equals(paramttk.b, String.valueOf(paramugn.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramugn.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramugn.l();
    if (paramttk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      veg.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramttk.jdField_a_of_type_JavaLangString);
      if (paramttk.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        tti.a().a(paramugn.b(), paramttk.jdField_a_of_type_JavaLangString);
        return;
      }
      tti.a().a(paramugn.b(), paramttk.jdField_a_of_type_JavaLangString, paramttk.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramugn.hashCode());
      return;
    }
    veg.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131701163), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return ttk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugx
 * JD-Core Version:    0.7.0.1
 */