import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class tjx
  implements syq<tnb, top>
{
  tjx(List paramList) {}
  
  public void a(@NonNull tnb paramtnb, @Nullable top paramtop, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    tjy localtjy = new tjy();
    localtjy.jdField_a_of_type_JavaUtilList = new ArrayList(paramtnb.jdField_a_of_type_JavaUtilList);
    localtjy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtop == null))
    {
      ved.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      stb.a().dispatch(localtjy);
      return;
    }
    ved.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramtop.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (tcw)tcz.a(5);
    paramtnb = paramtnb.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtnb.hasNext())
    {
      Object localObject = (String)paramtnb.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = tjw.a((String)localObject, paramtop.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = teo.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((tnc)localObject).jdField_a_of_type_Vve;
          localStoryVideoItem.mCompInfoBase = ((tnc)localObject).jdField_a_of_type_Vuw;
          localStoryVideoItem.mOALinkInfoJson = ((tnc)localObject).b;
        }
      }
    }
    localtjy.b = new ArrayList(paramtop.jdField_a_of_type_JavaUtilList);
    stb.a().dispatch(localtjy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjx
 * JD-Core Version:    0.7.0.1
 */