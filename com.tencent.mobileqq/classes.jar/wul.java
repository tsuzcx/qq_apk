import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class wul
  extends wsr<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = weg.a("StorySvc.get_promote_tasklist");
  
  public wul(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    return new wum(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    ykq.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return zel.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wul
 * JD-Core Version:    0.7.0.1
 */