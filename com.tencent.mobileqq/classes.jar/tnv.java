import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class tnv
  extends tmb<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = sxp.a("StorySvc.get_promote_tasklist");
  
  public tnv(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public syq a(byte[] paramArrayOfByte)
  {
    return new tnw(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    veg.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return vys.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnv
 * JD-Core Version:    0.7.0.1
 */