import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pyx
  extends ppw<qai>
{
  private static final String CMD = ppf.fQ("StorySvc.get_location");
  public final int blt;
  public final int blu;
  public final int mCoordinate;
  
  public pyx(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCoordinate = paramInt1;
    this.blt = paramInt2;
    this.blu = paramInt3;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetLocation localRspGetLocation = new qqstory_service.RspGetLocation();
    try
    {
      localRspGetLocation.mergeFrom(paramArrayOfByte);
      return new qai(localRspGetLocation);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetLocation localReqGetLocation = new qqstory_service.ReqGetLocation();
    localReqGetLocation.coordinate.set(this.mCoordinate);
    localReqGetLocation.gps.lng.set(this.blt);
    localReqGetLocation.gps.lat.set(this.blu);
    localReqGetLocation.gps.setHasFlag(true);
    return localReqGetLocation.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "GetLocationRequest{mCoordinate=" + this.mCoordinate + ", mLng=" + this.blt + ", mLat=" + this.blu + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyx
 * JD-Core Version:    0.7.0.1
 */