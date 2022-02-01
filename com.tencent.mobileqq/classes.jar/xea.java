import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class xea
  extends xcg<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = wnu.a("StorySvc.get_promote_tasklist");
  
  public xea(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    return new xeb(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    yuk.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return zow.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xea
 * JD-Core Version:    0.7.0.1
 */