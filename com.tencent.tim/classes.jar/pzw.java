import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPromoteTaskList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pzw
  extends pyl<qqstory_service.ReqGetPromoteTaskList>
{
  public static final String CMD = ppf.fQ("StorySvc.get_promote_tasklist");
  
  public pzw(String paramString)
  {
    super(CMD, new qqstory_service.ReqGetPromoteTaskList(), null);
    ((qqstory_service.ReqGetPromoteTaskList)this.b).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    return new pzw.a(paramArrayOfByte);
  }
  
  protected byte[] encode()
  {
    ram.b("GetPromoteTaskRequest", "encode: %s", this);
    return super.encode();
  }
  
  public String toString()
  {
    return rpf.a(this.b);
  }
  
  public static class a
    extends pzy
  {
    public qqstory_service.RspGetPromoteTaskList a = new qqstory_service.RspGetPromoteTaskList();
    
    public a(byte[] paramArrayOfByte)
    {
      super();
      try
      {
        this.a.mergeFrom(paramArrayOfByte);
        this.errorMsg = this.a.result.error_desc.get().toStringUtf8();
        this.errorCode = this.a.result.error_code.get();
        ram.b("GetPromoteTaskResponse", "GetPromoteTaskResponse(): %s", rpf.a(this.a));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.e("GetPromoteTaskResponse", "Error GetPromoteTaskResponse()", paramArrayOfByte);
      }
    }
    
    public String toString()
    {
      return rpf.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzw
 * JD-Core Version:    0.7.0.1
 */