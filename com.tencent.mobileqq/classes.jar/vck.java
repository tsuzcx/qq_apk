import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class vck
  extends vaq<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = ume.a("StorySvc.get_promote_tasklist");
  
  public vck(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    return new vcl(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    wsv.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return xnh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */