import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.i;
import java.io.File;

public class qkt
  implements pmq.c
{
  public qkt(VideoViewVideoHolder.i parami, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(pmq.a parama)
  {
    if (this.a.isCanceled())
    {
      ram.w(this.a.this$0.TAG, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(parama.vid, this.val$storyVideoItem.mVid))
    {
      ram.e(this.a.this$0.TAG, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { parama.vid, this.val$storyVideoItem.mVid });
      return;
    }
    if (!this.a.this$0.JN())
    {
      VideoViewVideoHolder.i.c(this.a, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    if (parama.aAJ)
    {
      File localFile = new File(this.axJ);
      if ((localFile.exists()) && (!pnh.s(localFile)))
      {
        boolean bool = localFile.delete();
        ram.w(this.a.this$0.TAG, "%s - %d found orphan tmp , delete it. %s", new Object[] { parama.vid, Integer.valueOf(parama.fileType), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(parama.url))
    {
      VideoViewVideoHolder.i.d(this.a, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    VideoViewVideoHolder.a(this.a.this$0, pmq.fL(parama.url));
    this.a.this$0.videoUrl = parama.url;
    VideoViewVideoHolder.a(this.a.this$0, "SP", SystemClock.uptimeMillis());
    VideoViewVideoHolder.b(this.a.this$0, SystemClock.uptimeMillis());
    this.a.this$0.a.a(this.val$storyVideoItem.mVid, this.axJ, parama.url, this.val$storyVideoItem.mVideoBytes, (int)this.val$storyVideoItem.mVideoDuration, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */