import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class pmx
  implements ppv.b<pzl, qas>
{
  pmx(pmq parampmq, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull pzl arg1, @Nullable qas paramqas, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramqas != null))
    {
      ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.val$vid });
      ??? = (psu)psx.a(5);
      if (paramqas.mVideoItemList != null)
      {
        paramErrorMessage = paramqas.mVideoItemList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramqas.mVideoItemList = ???.al(paramqas.mVideoItemList);
      ((pmq)psx.a(28)).updateList(paramqas.nx);
      this.a.bh(this.val$vid, 0);
    }
    synchronized (this.bk)
    {
      for (;;)
      {
        this.aF.set(true);
        try
        {
          if (this.aG.get()) {
            this.bk.notifyAll();
          }
          return;
          ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.val$vid });
        }
        catch (Exception paramqas)
        {
          for (;;)
          {
            ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */