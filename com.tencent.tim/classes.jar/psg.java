import com.tencent.biz.qqstory.base.ErrorMessage;

public class psg
  extends plt
{
  public long Ak;
  public final boolean aBu;
  public boolean aBv;
  public String feedId;
  public String groupId;
  public String uid;
  public final String vid;
  
  public psg(ErrorMessage paramErrorMessage, String paramString, boolean paramBoolean)
  {
    this.b = paramErrorMessage;
    this.vid = paramString;
    this.aBu = paramBoolean;
  }
  
  public String toString()
  {
    return "DeleteStoryVideoEvent{vid='" + this.vid + '\'' + ", uid='" + this.uid + '\'' + ", groupId='" + this.groupId + '\'' + ", feedId='" + this.feedId + '\'' + ", videoIndex=" + this.Ak + ", localDelete=" + this.aBu + ", isRemoveMember=" + this.aBv + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psg
 * JD-Core Version:    0.7.0.1
 */