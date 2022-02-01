import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ptk
  extends plt
{
  public long Ak;
  public String unionId;
  public String vid;
  
  public ptk(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.unionId = paramString;
    this.Ak = paramStoryVideoItem.mVideoIndex;
    this.vid = paramStoryVideoItem.mVid;
    if (this.Ak == 0L) {
      this.Ak = paramStoryVideoItem.mCreateTime;
    }
  }
  
  public String toString()
  {
    return "ReadStoryVideoEvent{unionId='" + this.unionId + '\'' + ", videoIndex=" + this.Ak + ", vid='" + this.vid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptk
 * JD-Core Version:    0.7.0.1
 */