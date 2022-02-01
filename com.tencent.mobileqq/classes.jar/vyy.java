import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqQQStoryGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspQQStoryGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class vyy
  extends vqr
{
  public static String a = vpl.a("StorySvc.new_user_guide");
  public String b;
  public String c;
  
  public vyy(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public String a()
  {
    return a;
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspQQStoryGuide localRspQQStoryGuide = new qqstory_service.RspQQStoryGuide();
    try
    {
      localRspQQStoryGuide.mergeFrom(paramArrayOfByte);
      return new vyz(localRspQQStoryGuide);
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
    qqstory_service.ReqQQStoryGuide localReqQQStoryGuide = new qqstory_service.ReqQQStoryGuide();
    try
    {
      localReqQQStoryGuide.to_uid.set(Long.valueOf(this.b).longValue());
      localReqQQStoryGuide.version.set(this.c);
      return localReqQQStoryGuide.toByteArray();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localReqQQStoryGuide.to_uid.set(0L);
      }
    }
  }
  
  public String toString()
  {
    return "QQStoryGuideRequest{toUid='" + this.b + '\'' + "version='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyy
 * JD-Core Version:    0.7.0.1
 */