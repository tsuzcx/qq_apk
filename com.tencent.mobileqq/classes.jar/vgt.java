import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class vgt
  extends vez<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = uqn.a("StorySvc.get_promote_tasklist");
  
  public vgt(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    return new vgu(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    wxe.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return xrq.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgt
 * JD-Core Version:    0.7.0.1
 */