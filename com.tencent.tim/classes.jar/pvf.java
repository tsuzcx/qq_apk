import android.os.Build;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pvf
  extends ppw
{
  static final String CMD = ppf.fQ("StoryTabSvc.startpage_feeds_list_725");
  static boolean aCc;
  public String cookie;
  public boolean forceRefresh;
  public String seq;
  public int source;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeList localRspMsgTabNodeList = new qqstory_service.RspMsgTabNodeList();
    try
    {
      localRspMsgTabNodeList.mergeFrom(paramArrayOfByte);
      return new pvf.a(localRspMsgTabNodeList);
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
    if (aCc)
    {
      this.seq = null;
      this.cookie = null;
    }
    qqstory_service.ReqMsgTabNodeList localReqMsgTabNodeList = new qqstory_service.ReqMsgTabNodeList();
    if (this.seq != null) {
      localReqMsgTabNodeList.current_seq.set(ByteStringMicro.copyFromUtf8(this.seq));
    }
    localReqMsgTabNodeList.source.set(this.source);
    if (this.cookie != null) {
      localReqMsgTabNodeList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.cookie));
    }
    localReqMsgTabNodeList.version.set(4);
    Long localLong = rpb.c();
    if (localLong != null) {
      localReqMsgTabNodeList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    localReqMsgTabNodeList.force_refresh.set(this.forceRefresh);
    localReqMsgTabNodeList.client_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    return localReqMsgTabNodeList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "MsgTabNodeListRequest{cookie='" + this.cookie + '\'' + ", seq='" + this.seq + '\'' + ", source=" + this.source + '}';
  }
  
  public static class a
    extends ppu
  {
    public boolean aCd;
    public String cookie;
    public boolean isEnd;
    public ArrayList<puh> mL;
    public String seq;
    
    public a(qqstory_service.RspMsgTabNodeList paramRspMsgTabNodeList)
    {
      super();
      this.seq = paramRspMsgTabNodeList.list_seq.get().toStringUtf8();
      this.cookie = paramRspMsgTabNodeList.next_cookie.get().toStringUtf8();
      if (paramRspMsgTabNodeList.is_animate.get() > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.aCd = bool1;
        if (paramRspMsgTabNodeList.is_end.has())
        {
          bool1 = bool2;
          if (paramRspMsgTabNodeList.is_end.get() != 1) {}
        }
        else
        {
          bool1 = true;
        }
        this.isEnd = bool1;
        this.mL = new ArrayList(paramRspMsgTabNodeList.node_list.size());
        paramRspMsgTabNodeList = paramRspMsgTabNodeList.node_list.get().iterator();
        while (paramRspMsgTabNodeList.hasNext())
        {
          qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramRspMsgTabNodeList.next();
          puh localpuh = new puh();
          localpuh.a(localMsgTabNodeInfo);
          this.mL.add(localpuh);
        }
      }
    }
    
    public String toString()
    {
      return "MsgTabNodeListResponse{shouldAnimate=" + this.aCd + ", seq='" + this.seq + '\'' + ", cookie='" + this.cookie + '\'' + ", isEnd=" + this.isEnd + ", nodeList=" + this.mL + "} " + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvf
 * JD-Core Version:    0.7.0.1
 */