import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class rmq
{
  public final boolean aBD;
  public final String comparedVid;
  public final String iconUrl;
  public final String linkUrl;
  public final int taskId;
  public final String title;
  
  public rmq(qqstory_struct.CompInfoBase paramCompInfoBase)
  {
    this.title = paramCompInfoBase.title.get();
    this.linkUrl = paramCompInfoBase.backgroud_url.get();
    this.comparedVid = paramCompInfoBase.compared_vid.get();
    if (paramCompInfoBase.is_compared_able.get() == 1) {}
    for (;;)
    {
      this.aBD = bool;
      this.iconUrl = paramCompInfoBase.icon_url.get();
      this.taskId = paramCompInfoBase.oa_task_id.get();
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "CompInfoBase{title='" + this.title + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", comparedVid='" + this.comparedVid + '\'' + ", isComparedAble=" + this.aBD + ", iconUrl='" + this.iconUrl + '\'' + ", taskId=" + this.taskId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmq
 * JD-Core Version:    0.7.0.1
 */