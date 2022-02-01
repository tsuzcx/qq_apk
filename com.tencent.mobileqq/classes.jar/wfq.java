import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class wfq
  extends wdw<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String b = vpl.a("StorySvc.get_promote_tasklist");
  
  public wfq(String paramString)
  {
    super(b, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.a).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    return new wfr(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    xvv.a("GetPromoteTaskRequest", "encode: %s", this);
    return super.a();
  }
  
  public String toString()
  {
    return yps.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfq
 * JD-Core Version:    0.7.0.1
 */