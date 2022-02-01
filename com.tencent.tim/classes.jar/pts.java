import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pts
{
  public long expireTime;
  public String feedId;
  public long limitPromoteCount;
  public long minimalVideoCount;
  public long promoteCount;
  public long taskId;
  public int type;
  public String unionId;
  
  public static pts a(qqstory_service.PromoteTask paramPromoteTask)
  {
    pts localpts = new pts();
    localpts.taskId = paramPromoteTask.uint64_taskid.get();
    localpts.type = paramPromoteTask.uint32_promote_type.get();
    localpts.unionId = paramPromoteTask.bytes_union_id.get().toStringUtf8();
    localpts.feedId = paramPromoteTask.bytes_feed_id.get().toStringUtf8();
    localpts.limitPromoteCount = paramPromoteTask.uint64_limit_count.get();
    localpts.minimalVideoCount = paramPromoteTask.uint64_minimal_video_count.get();
    localpts.expireTime = paramPromoteTask.uint64_expire_time.get();
    return localpts;
  }
  
  public PromoteTaskEntry a()
  {
    PromoteTaskEntry localPromoteTaskEntry = new PromoteTaskEntry();
    localPromoteTaskEntry.taskId = this.taskId;
    localPromoteTaskEntry.type = this.type;
    localPromoteTaskEntry.unionId = this.unionId;
    localPromoteTaskEntry.feedId = this.feedId;
    localPromoteTaskEntry.limitPromoteCount = this.limitPromoteCount;
    localPromoteTaskEntry.minimalVideoCount = this.minimalVideoCount;
    localPromoteTaskEntry.expireTime = this.expireTime;
    localPromoteTaskEntry.promoteCount = this.promoteCount;
    return localPromoteTaskEntry;
  }
  
  public String toString()
  {
    return "PromoteTaskItem{taskId=" + this.taskId + ", type=" + this.type + ", unionId='" + this.unionId + '\'' + ", feedId='" + this.feedId + '\'' + ", limitPromoteCount=" + this.limitPromoteCount + ", minimalVideoCount=" + this.minimalVideoCount + ", expireTime=" + this.expireTime + ", promoteCount=" + this.promoteCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pts
 * JD-Core Version:    0.7.0.1
 */