import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vfq
  extends urt<vhk>
{
  public final int c;
  public final int d;
  public final int e;
  
  public vfq(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = 1;
  }
  
  public String a()
  {
    return uqn.a("StorySvc.video_poi_posters_get");
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPOIPosters localRspGetPOIPosters = new qqstory_service.RspGetPOIPosters();
    try
    {
      localRspGetPOIPosters.mergeFrom(paramArrayOfByte);
      return new vhk(localRspGetPOIPosters);
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
    qqstory_service.ReqGetPOIPosters localReqGetPOIPosters = new qqstory_service.ReqGetPOIPosters();
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.lng.set(this.c);
    localGpsMsg.lat.set(this.d);
    localReqGetPOIPosters.coordinate.set(this.e);
    localReqGetPOIPosters.gps.set(localGpsMsg);
    return localReqGetPOIPosters.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */