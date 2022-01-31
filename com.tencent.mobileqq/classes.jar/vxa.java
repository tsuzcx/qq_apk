import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vxa
  extends QQUIEventReceiver<vwo, vhs>
{
  public vxa(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull vhs paramvhs)
  {
    if (TextUtils.equals(String.valueOf(paramvwo.hashCode()), paramvhs.jdField_a_of_type_JavaLangString)) {
      b(paramvwo, paramvhs);
    }
  }
  
  public Class acceptEventClass()
  {
    return vhs.class;
  }
  
  public void b(vwo paramvwo, vhs paramvhs)
  {
    paramvwo = ((StoryPlayerGroupHolder)paramvwo.a()).a();
    if (paramvwo != null) {
      paramvwo.c(false);
    }
    if (paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = vhj.a(paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramvhs.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131707262), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramvwo = "2";; paramvwo = "1")
      {
        wta.a("play_video", "down_suc", 0, 0, new String[] { paramvwo, "", "", paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, ume.a(2131700088), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramvwo = "2";; paramvwo = "1")
    {
      wta.a("play_video", "down_fail", 0, 0, new String[] { paramvwo, "", "", paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131707266), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */