import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vdc
  extends unf
{
  public long a;
  public String a;
  public ArrayList<VideoCollectionItem> a;
  public boolean a;
  
  public vdc(String paramString, qqstory_service.RspGroupDateVideoList paramRspGroupDateVideoList)
  {
    super(paramRspGroupDateVideoList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramRspGroupDateVideoList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramRspGroupDateVideoList.next_cookie.get().toStringUtf8();
      this.jdField_a_of_type_Long = paramRspGroupDateVideoList.seqno.get();
      paramRspGroupDateVideoList = paramRspGroupDateVideoList.group_node_info.get().iterator();
      while (paramRspGroupDateVideoList.hasNext())
      {
        qqstory_struct.GroupNodeInfo localGroupNodeInfo = (qqstory_struct.GroupNodeInfo)paramRspGroupDateVideoList.next();
        VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
        localVideoCollectionItem.convertFrom("Q.qqstory.shareGroup:GetDateCollectionListResponse", paramString, localGroupNodeInfo);
        this.jdField_a_of_type_JavaUtilArrayList.add(localVideoCollectionItem);
      }
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetShareGroupDateListResponse{errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.b + '\'' + ", isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", seq=" + this.jdField_a_of_type_Long + ", mCollectionItemList=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */