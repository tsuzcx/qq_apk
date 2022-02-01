import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class xdh
  extends wpa
{
  public static final String a;
  public wuz a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = wnu.a("StorySvc.homepage_batch_feeds_720");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedIdList localRspStoryFeedIdList = new qqstory_service.RspStoryFeedIdList();
    try
    {
      localRspStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new xdi(localRspStoryFeedIdList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqStoryFeedIdList localReqStoryFeedIdList = new qqstory_service.ReqStoryFeedIdList();
    localReqStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    if (this.jdField_a_of_type_Wuz != null)
    {
      localReqStoryFeedIdList.coordinate.set(this.jdField_a_of_type_Wuz.c);
      localReqStoryFeedIdList.gps.setHasFlag(true);
      localReqStoryFeedIdList.gps.lat.set(this.jdField_a_of_type_Wuz.a);
      localReqStoryFeedIdList.gps.lng.set(this.jdField_a_of_type_Wuz.b);
    }
    localReqStoryFeedIdList.client_version.set(6);
    return localReqStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdh
 * JD-Core Version:    0.7.0.1
 */