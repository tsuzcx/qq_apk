import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vvk
  extends QQUIEventReceiver<vvc, vhs>
{
  public vvk(@NonNull vvc paramvvc)
  {
    super(paramvvc);
  }
  
  public void a(@NonNull vvc paramvvc, @NonNull vhs paramvhs)
  {
    if (TextUtils.equals(String.valueOf(paramvvc.hashCode()), paramvhs.jdField_a_of_type_JavaLangString)) {
      b(paramvvc, paramvhs);
    }
  }
  
  public Class acceptEventClass()
  {
    return vhs.class;
  }
  
  public void b(vvc paramvvc, vhs paramvhs)
  {
    paramvvc = ((StoryPlayerGroupHolder)paramvvc.a()).a();
    if (paramvvc != null) {
      paramvvc.c(false);
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
      QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131701544), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramvvc = "2";; paramvvc = "1")
      {
        wta.a("play_video", "down_suc", 0, 0, new String[] { paramvvc, "", "", paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, ume.a(2131700088), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramvvc = "2";; paramvvc = "1")
    {
      wta.a("play_video", "down_fail", 0, 0, new String[] { paramvvc, "", "", paramvhs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131701545), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */