import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class tth
  extends QQUIEventReceiver<AbsVideoInfoWidget, syp>
{
  public tth(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    super(paramAbsVideoInfoWidget);
  }
  
  public void a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget, @NonNull syp paramsyp)
  {
    if ((paramsyp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramsyp.jdField_a_of_type_JavaUtilList == null)) {}
    String str;
    StoryVideoItem localStoryVideoItem;
    do
    {
      do
      {
        return;
        while (paramAbsVideoInfoWidget.a == null) {}
        str = paramAbsVideoInfoWidget.a.a;
        paramsyp = paramsyp.jdField_a_of_type_JavaUtilList.iterator();
      } while (!paramsyp.hasNext());
      localStoryVideoItem = (StoryVideoItem)paramsyp.next();
    } while ((!TextUtils.equals(str, localStoryVideoItem.mVid)) || (!localStoryVideoItem.isBasicInfoOK()));
    paramAbsVideoInfoWidget.i();
  }
  
  public Class acceptEventClass()
  {
    return syp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tth
 * JD-Core Version:    0.7.0.1
 */