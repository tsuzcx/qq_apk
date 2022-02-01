import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wgk
  extends vqm
{
  public long a;
  public String a;
  public ArrayList<ShareGroupCollectionItem> a;
  public boolean a;
  public int b;
  
  public wgk(String paramString, qqstory_service.RspShareVideoCollectionList paramRspShareVideoCollectionList)
  {
    super(paramRspShareVideoCollectionList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = paramRspShareVideoCollectionList.total_share_group_count.get();
    this.jdField_a_of_type_JavaLangString = paramRspShareVideoCollectionList.next_cookie.get().toStringUtf8();
    this.jdField_a_of_type_Long = paramRspShareVideoCollectionList.seqno.get();
    if (paramRspShareVideoCollectionList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramRspShareVideoCollectionList = paramRspShareVideoCollectionList.collection_list.get().iterator();
      while (paramRspShareVideoCollectionList.hasNext())
      {
        qqstory_struct.ShareGroupFeed localShareGroupFeed = (qqstory_struct.ShareGroupFeed)paramRspShareVideoCollectionList.next();
        ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem();
        localShareGroupCollectionItem.convertFrom(paramString, localShareGroupFeed);
        this.jdField_a_of_type_JavaUtilArrayList.add(localShareGroupCollectionItem);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgk
 * JD-Core Version:    0.7.0.1
 */