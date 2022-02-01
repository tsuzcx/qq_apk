import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class qzb
  extends SimpleJob<Object>
{
  qzb(qza paramqza, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (qza.a(this.b))
    {
      this.b.m = this.n;
      this.b.a = new qza.a(this.b.m.mVid);
      this.b.mFeedList = this.ov;
      this.b.brQ();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzb
 * JD-Core Version:    0.7.0.1
 */