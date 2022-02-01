import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.OperationCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class yis
{
  private qqstory_struct.OperationCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo;
  private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  
  public yis(qqstory_struct.OperationCardInfo paramOperationCardInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo = paramOperationCardInfo;
  }
  
  public yis(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo = new qqstory_struct.OperationCardInfo();
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
  
  public CardItem.CardVideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.card_info.story_video_info.size() == 0) {
        return null;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$OperationCardInfo.card_info.story_video_info.get(0));
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yis
 * JD-Core Version:    0.7.0.1
 */