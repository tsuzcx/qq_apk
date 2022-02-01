import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;

public class mie
{
  public UrlJumpInfo a;
  public int duration;
  public long id;
  public String picUrl;
  public int playCount;
  public String rowKey;
  public String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.id).append("\n").append("rowKey=").append(this.rowKey).append("\n").append("title=").append(this.title).append("\n").append("picUrl=").append(this.picUrl).append("\n").append("jumpUrl=").append(this.a).append("\n").append("playCount=").append(this.playCount).append("\n").append("duration=").append(this.duration);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mie
 * JD-Core Version:    0.7.0.1
 */