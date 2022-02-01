import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class xaf
  extends wyl<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = wjz.a("StorySvc.get_promote_tasklist");
  
  public xaf(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public wla a(byte[] paramArrayOfByte)
  {
    return new xag(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    yqp.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return zlb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaf
 * JD-Core Version:    0.7.0.1
 */