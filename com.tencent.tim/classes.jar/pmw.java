import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class pmw
  implements ppv.b<pzl, qas>
{
  pmw(pmq parampmq, pmq.b paramb, String paramString) {}
  
  public void a(@NonNull pzl parampzl, @Nullable qas paramqas, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramqas);
    if ((paramErrorMessage.isFail()) || (paramqas == null))
    {
      ram.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Pmq$b.aD(true);
      return;
    }
    parampzl = (psu)psx.a(5);
    if (paramqas.mVideoItemList != null)
    {
      paramErrorMessage = paramqas.mVideoItemList.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramqas.mVideoItemList = parampzl.al(paramqas.mVideoItemList);
    ((pmq)psx.a(28)).updateList(paramqas.nx);
    this.jdField_a_of_type_Pmq.bh(this.val$vid, 0);
    this.jdField_a_of_type_Pmq$b.aD(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmw
 * JD-Core Version:    0.7.0.1
 */