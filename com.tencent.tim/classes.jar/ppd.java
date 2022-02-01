import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ppd
  implements ppv.b<pzo, qav>
{
  public ppd(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull pzo parampzo, @Nullable qav paramqav, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramqav == null))
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.a });
    }
    label541:
    do
    {
      return;
      ((pox)this.a.a).createTime = (paramqav.createTime * 1000L);
      paramErrorMessage = ((pox)this.a.a).a();
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramqav.feedId });
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramqav.date });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((pox)this.a.a).rd(paramqav.feedId);
        paramErrorMessage.setDate(paramqav.date);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramqav.storyId))
        {
          ((pox)this.a.a).vid = paramqav.storyId;
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramqav.storyId });
        }
        if (!TextUtils.isEmpty(paramqav.vid))
        {
          ((pox)this.a.a).vid = paramqav.vid;
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramqav.vid });
        }
        ((pox)this.a.a).mt = paramqav.nF;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((pox)this.a.a).mt);
        ((pox)this.a.a).Ak = paramqav.Ak;
        if (!this.a.isStop()) {
          break label541;
        }
        this.a.a(this.a.bjI, new ErrorMessage());
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.a });
        if (this.a.bjI != 7) {
          break;
        }
        new pxj().qV(((pox)this.a.a).vid);
        if (paramqav.nF == null) {
          break;
        }
        parampzo = paramqav.nF.iterator();
        while (parampzo.hasNext())
        {
          paramqav = ((pzx.a)parampzo.next()).fN.values().iterator();
          while (paramqav.hasNext())
          {
            paramErrorMessage = (String)paramqav.next();
            new pxj().qV(paramErrorMessage);
          }
        }
        break;
        if (!paramErrorMessage.feedId.equals(paramqav.feedId)) {
          ram.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramqav.feedId });
        }
      }
      this.a.a(5, new ErrorMessage());
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.a });
    } while ((parampzo.b == null) || (parampzo.b.styleType != 1));
    int i;
    int j;
    switch (((pox)this.a.a).bjK)
    {
    case 3: 
    case 4: 
    default: 
      i = 0;
      if (TextUtils.isEmpty(parampzo.b.avn))
      {
        j = 2;
        label667:
        paramqav = parampzo.b.aL();
        if (parampzo.isPicture != 1) {
          break label745;
        }
      }
      break;
    }
    label745:
    for (parampzo = "2";; parampzo = "1")
    {
      rar.a("video_edit", "pub_url", j, i, new String[] { paramqav, "", parampzo });
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      j = 1;
      break label667;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppd
 * JD-Core Version:    0.7.0.1
 */