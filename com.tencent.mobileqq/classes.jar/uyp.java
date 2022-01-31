import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class uyp
  implements uni<vbt, vdh>
{
  uyp(List paramList) {}
  
  public void a(@NonNull vbt paramvbt, @Nullable vdh paramvdh, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    uyq localuyq = new uyq();
    localuyq.jdField_a_of_type_JavaUtilList = new ArrayList(paramvbt.jdField_a_of_type_JavaUtilList);
    localuyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramvdh == null))
    {
      wsv.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      uht.a().dispatch(localuyq);
      return;
    }
    wsv.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramvdh.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (uro)urr.a(5);
    paramvbt = paramvbt.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvbt.hasNext())
    {
      Object localObject = (String)paramvbt.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = uyo.a((String)localObject, paramvdh.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = utg.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((vbu)localObject).jdField_a_of_type_Xjw;
          localStoryVideoItem.mCompInfoBase = ((vbu)localObject).jdField_a_of_type_Xjo;
          localStoryVideoItem.mOALinkInfoJson = ((vbu)localObject).b;
        }
      }
    }
    localuyq.b = new ArrayList(paramvdh.jdField_a_of_type_JavaUtilList);
    uht.a().dispatch(localuyq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyp
 * JD-Core Version:    0.7.0.1
 */