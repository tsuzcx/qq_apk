import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wyk
  extends QQUIEventReceiver<wyc, wky>
{
  public wyk(@NonNull wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull wky paramwky)
  {
    if (TextUtils.equals(String.valueOf(paramwyc.hashCode()), paramwky.jdField_a_of_type_JavaLangString)) {
      b(paramwyc, paramwky);
    }
  }
  
  public Class acceptEventClass()
  {
    return wky.class;
  }
  
  public void b(wyc paramwyc, wky paramwky)
  {
    paramwyc = ((StoryPlayerGroupHolder)paramwyc.a()).a();
    if (paramwyc != null) {
      paramwyc.c(false);
    }
    if (paramwky.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = wkp.a(paramwky.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramwky.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131700322), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramwyc = "2";; paramwyc = "1")
      {
        xwa.a("play_video", "down_suc", 0, 0, new String[] { paramwyc, "", "", paramwky.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, vpl.a(2131698868), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramwyc = "2";; paramwyc = "1")
    {
      xwa.a("play_video", "down_fail", 0, 0, new String[] { paramwyc, "", "", paramwky.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131700323), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */