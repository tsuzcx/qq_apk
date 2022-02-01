import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class pxo
  implements ppv.b<pzi, qaq>
{
  pxo(List paramList) {}
  
  public void a(@NonNull pzi parampzi, @Nullable qaq paramqaq, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    pxn.a locala = new pxn.a();
    locala.mS = new ArrayList(parampzi.mVidList);
    locala.b = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramqaq == null))
    {
      ram.e("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      pmi.a().dispatch(locala);
      return;
    }
    ram.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.mR, paramqaq.nC);
    paramErrorMessage = (psu)psx.a(5);
    parampzi = parampzi.mVidList.iterator();
    while (parampzi.hasNext())
    {
      Object localObject = (String)parampzi.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = pxn.a((String)localObject, paramqaq.nC);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = pty.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.updateTime = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((pzi.a)localObject).jdField_a_of_type_Rmw$a;
          localStoryVideoItem.mCompInfoBase = ((pzi.a)localObject).jdField_a_of_type_Rmq;
          localStoryVideoItem.mOALinkInfoJson = ((pzi.a)localObject).avW;
        }
      }
    }
    locala.mT = new ArrayList(paramqaq.nC);
    pmi.a().dispatch(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxo
 * JD-Core Version:    0.7.0.1
 */