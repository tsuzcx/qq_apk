import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class vus
  extends QQUIEventReceiver<AbsVideoInfoWidget, vaa>
{
  public vus(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    super(paramAbsVideoInfoWidget);
  }
  
  public void a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget, @NonNull vaa paramvaa)
  {
    if ((paramvaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramvaa.jdField_a_of_type_JavaUtilList == null)) {}
    String str;
    StoryVideoItem localStoryVideoItem;
    do
    {
      do
      {
        return;
        while (paramAbsVideoInfoWidget.a == null) {}
        str = paramAbsVideoInfoWidget.a.a;
        paramvaa = paramvaa.jdField_a_of_type_JavaUtilList.iterator();
      } while (!paramvaa.hasNext());
      localStoryVideoItem = (StoryVideoItem)paramvaa.next();
    } while ((!TextUtils.equals(str, localStoryVideoItem.mVid)) || (!localStoryVideoItem.isBasicInfoOK()));
    paramAbsVideoInfoWidget.i();
  }
  
  public Class acceptEventClass()
  {
    return vaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vus
 * JD-Core Version:    0.7.0.1
 */