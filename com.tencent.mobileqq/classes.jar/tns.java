import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class tns
  extends tly<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = sxm.a("StorySvc.get_promote_tasklist");
  
  public tns(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    return new tnt(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    ved.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return vyp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tns
 * JD-Core Version:    0.7.0.1
 */