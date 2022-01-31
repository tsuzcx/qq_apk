import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class tov
  extends syq
{
  public long a;
  public List<qqstory_struct.UserSimpleInfo> a;
  public long b;
  
  public tov(String paramString, qqstory_service.RspGetFeedVisitor paramRspGetFeedVisitor)
  {
    super(paramRspGetFeedVisitor.result);
    this.b = paramRspGetFeedVisitor.view_total_num.get();
    this.jdField_a_of_type_JavaUtilList = paramRspGetFeedVisitor.user_list.get();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String toString()
  {
    return "GetVideoWatcherListResponse{totalReadTime=" + this.b + "totalWatcherCount=" + this.jdField_a_of_type_Long + ", userList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tov
 * JD-Core Version:    0.7.0.1
 */