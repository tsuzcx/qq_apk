import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class tka
  implements syt<tne, tos>
{
  tka(List paramList) {}
  
  public void a(@NonNull tne paramtne, @Nullable tos paramtos, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    tkb localtkb = new tkb();
    localtkb.jdField_a_of_type_JavaUtilList = new ArrayList(paramtne.jdField_a_of_type_JavaUtilList);
    localtkb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtos == null))
    {
      veg.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      ste.a().dispatch(localtkb);
      return;
    }
    veg.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramtos.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (tcz)tdc.a(5);
    paramtne = paramtne.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtne.hasNext())
    {
      Object localObject = (String)paramtne.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = tjz.a((String)localObject, paramtos.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = ter.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((tnf)localObject).jdField_a_of_type_Vvh;
          localStoryVideoItem.mCompInfoBase = ((tnf)localObject).jdField_a_of_type_Vuz;
          localStoryVideoItem.mOALinkInfoJson = ((tnf)localObject).b;
        }
      }
    }
    localtkb.b = new ArrayList(paramtos.jdField_a_of_type_JavaUtilList);
    ste.a().dispatch(localtkb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tka
 * JD-Core Version:    0.7.0.1
 */