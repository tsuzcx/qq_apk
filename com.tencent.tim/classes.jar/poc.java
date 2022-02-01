import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class poc
  extends Job<Object, Object, Object>
{
  poc(pnx parampnx, String paramString1, String paramString2, StoryVideoItem paramStoryVideoItem)
  {
    super(paramString1);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    paramJobContext = new psg(new ErrorMessage(), this.val$vid, true);
    if (this.a != null)
    {
      paramJobContext.uid = this.a.mOwnerUid;
      paramJobContext.groupId = this.a.shareGroupId;
      paramJobContext.Ak = this.a.mVideoIndex;
      if (paramJobContext.Ak == 0L) {
        paramJobContext.Ak = this.a.mCreateTime;
      }
    }
    pmi.a().dispatch(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poc
 * JD-Core Version:    0.7.0.1
 */