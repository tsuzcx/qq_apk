import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class vcy
  implements urr<vgc, vhq>
{
  vcy(List paramList) {}
  
  public void a(@NonNull vgc paramvgc, @Nullable vhq paramvhq, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    vcz localvcz = new vcz();
    localvcz.jdField_a_of_type_JavaUtilList = new ArrayList(paramvgc.jdField_a_of_type_JavaUtilList);
    localvcz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvhq == null))
    {
      wxe.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      umc.a().dispatch(localvcz);
      return;
    }
    wxe.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramvhq.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (uvx)uwa.a(5);
    paramvgc = paramvgc.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvgc.hasNext())
    {
      Object localObject = (String)paramvgc.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = vcx.a((String)localObject, paramvhq.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = uxp.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((vgd)localObject).jdField_a_of_type_Xof;
          localStoryVideoItem.mCompInfoBase = ((vgd)localObject).jdField_a_of_type_Xnx;
          localStoryVideoItem.mOALinkInfoJson = ((vgd)localObject).b;
        }
      }
    }
    localvcz.b = new ArrayList(paramvhq.jdField_a_of_type_JavaUtilList);
    umc.a().dispatch(localvcz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcy
 * JD-Core Version:    0.7.0.1
 */