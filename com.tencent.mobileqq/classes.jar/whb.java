import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class whb
{
  private qqstory_struct.NearbyCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo;
  private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  
  public whb(qqstory_struct.NearbyCardInfo paramNearbyCardInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = paramNearbyCardInfo;
  }
  
  public whb(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = new qqstory_struct.NearbyCardInfo();
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
  
  public CardItem.CardVideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.size() == 0) {
        return null;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.get(0));
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whb
 * JD-Core Version:    0.7.0.1
 */