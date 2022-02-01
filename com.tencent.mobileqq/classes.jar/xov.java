import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xov
  extends QQUIEventReceiver<xoj, wzt>
{
  public xov(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull wzt paramwzt)
  {
    if (TextUtils.equals(String.valueOf(paramxoj.hashCode()), paramwzt.jdField_a_of_type_JavaLangString)) {
      b(paramxoj, paramwzt);
    }
  }
  
  public Class acceptEventClass()
  {
    return wzt.class;
  }
  
  public void b(xoj paramxoj, wzt paramwzt)
  {
    paramxoj = ((StoryPlayerGroupHolder)paramxoj.a()).a();
    if (paramxoj != null) {
      paramxoj.c(false);
    }
    if (paramwzt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = wzk.a(paramwzt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramwzt.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131706353), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramxoj = "2";; paramxoj = "1")
      {
        ykv.a("play_video", "down_suc", 0, 0, new String[] { paramxoj, "", "", paramwzt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, weg.a(2131699219), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramxoj = "2";; paramxoj = "1")
    {
      ykv.a("play_video", "down_fail", 0, 0, new String[] { paramxoj, "", "", paramwzt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131706357), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xov
 * JD-Core Version:    0.7.0.1
 */