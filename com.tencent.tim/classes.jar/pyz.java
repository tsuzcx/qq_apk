import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pyz
  extends ppw<qak>
{
  public final int coordinate;
  public final int latitude;
  public final int longitude;
  
  public pyz(int paramInt1, int paramInt2)
  {
    this.longitude = paramInt1;
    this.latitude = paramInt2;
    this.coordinate = 1;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPOIPosters localRspGetPOIPosters = new qqstory_service.RspGetPOIPosters();
    try
    {
      localRspGetPOIPosters.mergeFrom(paramArrayOfByte);
      return new qak(localRspGetPOIPosters);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetPOIPosters localReqGetPOIPosters = new qqstory_service.ReqGetPOIPosters();
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.lng.set(this.longitude);
    localGpsMsg.lat.set(this.latitude);
    localReqGetPOIPosters.coordinate.set(this.coordinate);
    localReqGetPOIPosters.gps.set(localGpsMsg);
    return localReqGetPOIPosters.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.video_poi_posters_get");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyz
 * JD-Core Version:    0.7.0.1
 */