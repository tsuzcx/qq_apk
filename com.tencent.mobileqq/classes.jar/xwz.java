import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xwz
  extends QQUIEventReceiver<xwr, xji>
{
  public xwz(@NonNull xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull xji paramxji)
  {
    if (TextUtils.equals(String.valueOf(paramxwr.hashCode()), paramxji.jdField_a_of_type_JavaLangString)) {
      b(paramxwr, paramxji);
    }
  }
  
  public Class acceptEventClass()
  {
    return xji.class;
  }
  
  public void b(xwr paramxwr, xji paramxji)
  {
    paramxwr = ((StoryPlayerGroupHolder)paramxwr.a()).a();
    if (paramxwr != null) {
      paramxwr.c(false);
    }
    if (paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return;
    }
    boolean bool = xiz.a(paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    switch (paramxji.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131700087), 0).a();
      return;
    case 2: 
      if (bool) {}
      for (paramxwr = "2";; paramxwr = "1")
      {
        yup.a("play_video", "down_suc", 0, 0, new String[] { paramxwr, "", "", paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        QQToast.a(BaseApplicationImpl.getContext(), 2, wnu.a(2131698633), 0).a();
        return;
      }
    }
    if (bool) {}
    for (paramxwr = "2";; paramxwr = "1")
    {
      yup.a("play_video", "down_fail", 0, 0, new String[] { paramxwr, "", "", paramxji.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131700088), 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwz
 * JD-Core Version:    0.7.0.1
 */