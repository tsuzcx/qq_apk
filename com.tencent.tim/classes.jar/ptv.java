import com.tencent.biz.qqstory.utils.JsonORM.a;

public class ptv
{
  @JsonORM.a(key="is_comp_able")
  public boolean aBD;
  @JsonORM.a(key="bg_url")
  public String bgUrl;
  @JsonORM.a(key="comp_vid")
  public String comparedVid;
  @JsonORM.a(key="icon_url")
  public String iconUrl;
  @JsonORM.a(key="oa_task_id")
  public int taskId;
  
  public String toString()
  {
    return "CompInfoBase{, comparedVid='" + this.comparedVid + '\'' + ", isComparedAble=" + this.aBD + ", iconUrl='" + this.iconUrl + '\'' + ", taskId=" + this.taskId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptv
 * JD-Core Version:    0.7.0.1
 */