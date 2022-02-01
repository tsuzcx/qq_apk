import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wun
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public long d;
  public long e;
  
  public static wun a(qqstory_service.PromoteTask paramPromoteTask)
  {
    wun localwun = new wun();
    localwun.jdField_a_of_type_Long = paramPromoteTask.uint64_taskid.get();
    localwun.jdField_a_of_type_Int = paramPromoteTask.uint32_promote_type.get();
    localwun.jdField_a_of_type_JavaLangString = paramPromoteTask.bytes_union_id.get().toStringUtf8();
    localwun.jdField_b_of_type_JavaLangString = paramPromoteTask.bytes_feed_id.get().toStringUtf8();
    localwun.jdField_b_of_type_Long = paramPromoteTask.uint64_limit_count.get();
    localwun.c = paramPromoteTask.uint64_minimal_video_count.get();
    localwun.d = paramPromoteTask.uint64_expire_time.get();
    return localwun;
  }
  
  public PromoteTaskEntry a()
  {
    PromoteTaskEntry localPromoteTaskEntry = new PromoteTaskEntry();
    localPromoteTaskEntry.taskId = this.jdField_a_of_type_Long;
    localPromoteTaskEntry.type = this.jdField_a_of_type_Int;
    localPromoteTaskEntry.unionId = this.jdField_a_of_type_JavaLangString;
    localPromoteTaskEntry.feedId = this.jdField_b_of_type_JavaLangString;
    localPromoteTaskEntry.limitPromoteCount = this.jdField_b_of_type_Long;
    localPromoteTaskEntry.minimalVideoCount = this.c;
    localPromoteTaskEntry.expireTime = this.d;
    localPromoteTaskEntry.promoteCount = this.e;
    return localPromoteTaskEntry;
  }
  
  public String toString()
  {
    return "PromoteTaskItem{taskId=" + this.jdField_a_of_type_Long + ", type=" + this.jdField_a_of_type_Int + ", unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", limitPromoteCount=" + this.jdField_b_of_type_Long + ", minimalVideoCount=" + this.c + ", expireTime=" + this.d + ", promoteCount=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */