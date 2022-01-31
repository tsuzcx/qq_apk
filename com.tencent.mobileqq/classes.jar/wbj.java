import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wbj
  extends QQUIEventReceiver<wax, vmb>
{
  public wbj(@NonNull wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull vmb paramvmb)
  {
    if (TextUtils.equals(String.valueOf(paramwax.hashCode()), paramvmb.jdField_a_of_type_JavaLangString)) {
      b(paramwax, paramvmb);
    }
  }
  
  public Class acceptEventClass()
  {
    return vmb.class;
  }
  
  public void b(wax paramwax, vmb paramvmb)
  {
    paramwax = ((StoryPlayerGroupHolder)paramwax.a()).a();
    if (paramwax != null) {
      paramwax.c(false);
    }
    if (paramvmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = vls.a(paramvmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramvmb.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131707274), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramwax = "2";; paramwax = "1")
      {
        wxj.a("play_video", "down_suc", 0, 0, new String[] { paramwax, "", "", paramvmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, uqn.a(2131700100), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramwax = "2";; paramwax = "1")
    {
      wxj.a("play_video", "down_fail", 0, 0, new String[] { paramwax, "", "", paramvmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131707278), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbj
 * JD-Core Version:    0.7.0.1
 */