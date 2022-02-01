import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class pvy
  extends SimpleJob<Object>
{
  pvy(pvv parampvv, String paramString1, puh parampuh, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = pvv.a(this.this$0, this.e, this.val$vid);
    if ((paramJobContext != null) && (!TextUtils.equals(this.e.nodeVid, paramJobContext.mVid)))
    {
      this.e.videoCover = paramJobContext.mVideoThumbnailUrl;
      this.e.nodeVid = paramJobContext.mVid;
      this.e.nodeFeedId = paramJobContext.mAttachedFeedId;
      this.e.ava = "";
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.4.1(this));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvy
 * JD-Core Version:    0.7.0.1
 */