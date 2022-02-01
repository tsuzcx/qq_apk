import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public abstract class pse
  implements IEventReceiver
{
  public static class a
    extends plt
  {
    public boolean HV;
    public LiveVideoEntry a;
    public boolean aBs;
    public String context;
    public boolean isEnd;
    public String label;
    public List<StoryVideoItem> mw = new ArrayList();
    public long topicId;
    public long totalTime;
    public String uid;
    public int videoCount;
    
    public String toString()
    {
      return "PlayerVideoListEvent{context='" + this.context + '\'' + ", uid='" + this.uid + '\'' + ", label='" + this.label + '\'' + ", topicId=" + this.topicId + ", mStoryVideoItems=" + this.mw + ", totalTime=" + this.totalTime + ", videoCount=" + this.videoCount + ", isFromCache=" + this.HV + ", isEnd=" + this.isEnd + ", interactStatus=" + this.aBs + ", liveVideoInfo=" + this.a + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pse
 * JD-Core Version:    0.7.0.1
 */