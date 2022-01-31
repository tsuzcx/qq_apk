import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class toe
  extends syq
{
  public long a;
  public String a;
  public ArrayList<VideoCollectionItem> a;
  public boolean a;
  public int b;
  public int c = -1;
  
  public toe(String paramString, qqstory_service.RspDateVideoCollectionList paramRspDateVideoCollectionList)
  {
    super(paramRspDateVideoCollectionList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramRspDateVideoCollectionList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramRspDateVideoCollectionList.next_cookie.get().toStringUtf8();
      this.b = paramRspDateVideoCollectionList.total_video_count.get();
      this.jdField_a_of_type_Long = paramRspDateVideoCollectionList.seqno.get();
      this.c = paramRspDateVideoCollectionList.is_friend.get();
      paramRspDateVideoCollectionList = paramRspDateVideoCollectionList.collection_list.get().iterator();
      while (paramRspDateVideoCollectionList.hasNext())
      {
        qqstory_struct.DateVideoCollection localDateVideoCollection = (qqstory_struct.DateVideoCollection)paramRspDateVideoCollectionList.next();
        VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
        localVideoCollectionItem.convertFrom("Q.qqstory.memories:GetDateCollectionListResponse", paramString, localDateVideoCollection);
        this.jdField_a_of_type_JavaUtilArrayList.add(localVideoCollectionItem);
      }
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetDateCollectionListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", seq=" + this.jdField_a_of_type_Long + ", mTotalVideoCount=" + this.b + ", mIsFriend=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     toe
 * JD-Core Version:    0.7.0.1
 */