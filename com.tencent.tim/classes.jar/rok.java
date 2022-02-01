import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rok
  extends pse
  implements ppv.b<pzl, qas>
{
  psl.a a;
  String aBw;
  boolean aIP;
  String mContext;
  
  public void U(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.a == null)
    {
      pse.a locala = new pse.a();
      locala.context = this.mContext;
      locala.HV = paramBoolean;
      locala.isEnd = true;
      locala.mw.addAll(paramList);
      locala.videoCount = paramList.size();
      pmi.a().dispatch(locala);
      return;
    }
    this.a.y(paramList, this.aIP);
    this.a = null;
  }
  
  public void a(@NonNull pzl parampzl, @Nullable qas paramqas, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    parampzl = new StoryVideoItem();
    parampzl.mVid = this.aBw;
    parampzl.mStoryType = 2;
    if ((paramqas != null) && (paramErrorMessage.isSuccess()))
    {
      parampzl = paramqas.mVideoItemList.iterator();
      while (parampzl.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)parampzl.next();
        if (this.aBw.equals(paramErrorMessage.mVid)) {
          if (paramErrorMessage.mErrorCode != 0) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((pmq)psx.a(28)).updateList(paramqas.nx);
        U(paramqas.mVideoItemList, false);
        return;
      }
      this.aIP = true;
      if (paramqas == null) {}
      for (parampzl = new ArrayList();; parampzl = paramqas.mVideoItemList)
      {
        U(parampzl, false);
        return;
      }
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rok
 * JD-Core Version:    0.7.0.1
 */