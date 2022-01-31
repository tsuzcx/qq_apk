import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uin
  extends QQUIEventReceiver<uhz, ttk>
{
  public uin(@NonNull uhz paramuhz)
  {
    super(paramuhz);
  }
  
  public void a(@NonNull uhz paramuhz, @NonNull ttk paramttk)
  {
    if (!TextUtils.equals(paramttk.b, String.valueOf(paramuhz.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramuhz.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramuhz.l();
    if (paramttk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      veg.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramttk.jdField_a_of_type_JavaLangString);
      if (paramttk.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        tti.a().a(paramuhz.b(), paramttk.jdField_a_of_type_JavaLangString);
        return;
      }
      tti.a().a(paramuhz.b(), paramttk.jdField_a_of_type_JavaLangString, paramttk.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramuhz.hashCode());
      return;
    }
    veg.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131706877), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return ttk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uin
 * JD-Core Version:    0.7.0.1
 */