import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckActivity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pvd
  extends ppw
{
  public static String CMD = ppf.fQ("StorySvc.check_activity");
  public final String avA;
  public String value;
  
  public pvd(String paramString)
  {
    this.avA = paramString;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckActivity localRspCheckActivity = new qqstory_service.RspCheckActivity();
    try
    {
      localRspCheckActivity.mergeFrom(paramArrayOfByte);
      return new pvd.a(localRspCheckActivity);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqCheckActivity localReqCheckActivity = new qqstory_service.ReqCheckActivity();
    if (!TextUtils.isEmpty(this.avA)) {
      localReqCheckActivity.adcode.set(Long.valueOf(this.avA).longValue());
    }
    ram.b("MsgTabCheckActiveRequest", "client version=%s", "3.4.4");
    localReqCheckActivity.version.set("3.4.4");
    return localReqCheckActivity.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "MsgTabCheckActiveRequest{value='" + this.value + '\'' + ", adCode='" + this.avA + '\'' + '}';
  }
  
  public static class a
    extends ppu
  {
    public long Aw;
    public int active;
    
    public a(qqstory_service.RspCheckActivity paramRspCheckActivity)
    {
      super();
      this.active = paramRspCheckActivity.is_activity.get();
      this.Aw = paramRspCheckActivity.next_check_time.get();
    }
    
    public String toString()
    {
      return "MsgTabCheckActiveResponse{active=" + this.active + ", nextCheckTime=" + this.Aw + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvd
 * JD-Core Version:    0.7.0.1
 */