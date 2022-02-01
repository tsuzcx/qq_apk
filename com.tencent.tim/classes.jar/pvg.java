import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pvg
  extends ppw<pvg.a>
{
  static final String CMD = ppf.fQ("StorySvc.get_tab_node_vid_list");
  puh b;
  String mCookie = "";
  String mStartVid = "";
  
  public pvg(puh parampuh, String paramString1, String paramString2)
  {
    this.b = parampuh;
    this.mCookie = paramString1;
    this.mStartVid = paramString2;
  }
  
  public static pvg.a a(puh parampuh, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
    if (paramArrayOfByte != null) {}
    try
    {
      localRspMsgTabNodeVideoList.mergeFrom(paramArrayOfByte);
      return new pvg.a(parampuh, localRspMsgTabNodeVideoList, paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException parampuh)
    {
      ram.w("Q.qqstory:ReqMsgTabNodeVideoList", "" + parampuh);
    }
    return null;
  }
  
  public pvg.a a(byte[] paramArrayOfByte)
  {
    return a(this.b, paramArrayOfByte);
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.b.unionId));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.b.reqTimeStamp);
    localReqMsgTabNodeVideoList.node_type.set(this.b.nodeType);
    localReqMsgTabNodeVideoList.recommend_id.set(this.b.recommendId);
    localReqMsgTabNodeVideoList.source.set(this.b.source);
    if (this.b.nodeType == 12)
    {
      if ((TextUtils.isEmpty(this.mCookie)) && (!TextUtils.isEmpty(this.mStartVid))) {
        localReqMsgTabNodeVideoList.start_vid.set(this.mStartVid);
      }
      if (!TextUtils.isEmpty(this.mCookie)) {
        localReqMsgTabNodeVideoList.cookie.set(this.mCookie);
      }
      localReqMsgTabNodeVideoList.page_size.set(20);
    }
    Long localLong = rpb.c();
    if (localLong != null) {
      localReqMsgTabNodeVideoList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeVideoList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    if (!TextUtils.isEmpty(this.b.passthrough)) {
      localReqMsgTabNodeVideoList.passthrough.set(ByteStringMicro.copyFromUtf8(this.b.passthrough));
    }
    return localReqMsgTabNodeVideoList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "MsgTabNodeVidListRequest{nodeInfo.unionId=" + this.b.unionId + ", mCookie='" + this.mCookie + '\'' + ", mStartVid='" + this.mStartVid + '\'' + "} " + super.toString();
  }
  
  public static class a
    extends ppu
  {
    public qqstory_service.RspMsgTabNodeVideoList a;
    public puh b;
    public byte[] bB;
    public List<pux> mD = new ArrayList();
    
    public a(puh parampuh, qqstory_service.RspMsgTabNodeVideoList paramRspMsgTabNodeVideoList, byte[] paramArrayOfByte)
    {
      super();
      this.b = parampuh;
      this.a = paramRspMsgTabNodeVideoList;
      this.bB = paramArrayOfByte;
      if (paramRspMsgTabNodeVideoList.video_list != null)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        label158:
        Object localObject4;
        if (parampuh.nodeType == 12)
        {
          ram.a("Q.qqstory:ReqMsgTabNodeVideoList", "new video list receive cookie:%s nodeInfo old size=%d, rsp.video_list size=%d", paramRspMsgTabNodeVideoList.cookie.get(), Integer.valueOf(parampuh.iO.size()), Integer.valueOf(paramRspMsgTabNodeVideoList.video_list.size()));
          paramArrayOfByte = new HashSet();
          paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
          if (paramRspMsgTabNodeVideoList.hasNext())
          {
            localObject1 = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
            localObject2 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).feed_id.get().toStringUtf8();
            localObject3 = ((qqstory_service.MsgTabNodeVidInfo)localObject1).video_index_list.get().iterator();
            i = 0;
            pux localpux;
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Long)((Iterator)localObject3).next();
              localpux = pux.a(parampuh.iO, ((Long)localObject4).longValue());
              if ((localpux != null) && (!paramArrayOfByte.contains(localObject4))) {
                break label339;
              }
              localpux = new pux();
              localpux.feedId = ((String)localObject2);
              localpux.vid = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              localpux.Ak = parampuh.iO.size();
              localpux.aBR = false;
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localpux.Av = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
              parampuh.iO.add(localpux);
              this.mD.add(localpux);
              paramArrayOfByte.add(localObject4);
            }
            for (;;)
            {
              i += 1;
              break label158;
              break;
              label339:
              localpux.feedId = ((String)localObject2);
              localpux.vid = ((ByteStringMicro)((qqstory_service.MsgTabNodeVidInfo)localObject1).vid_list.get(i)).toStringUtf8();
              if (((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.has()) {
                localpux.Av = ((Integer)((qqstory_service.MsgTabNodeVidInfo)localObject1).recommand_id_list.get(i)).intValue();
              }
            }
          }
        }
        else
        {
          paramRspMsgTabNodeVideoList = paramRspMsgTabNodeVideoList.video_list.get().iterator();
          if (paramRspMsgTabNodeVideoList.hasNext())
          {
            paramArrayOfByte = (qqstory_service.MsgTabNodeVidInfo)paramRspMsgTabNodeVideoList.next();
            localObject1 = paramArrayOfByte.feed_id.get().toStringUtf8();
            localObject2 = paramArrayOfByte.video_index_list.get().iterator();
            i = 0;
            label464:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Long)((Iterator)localObject2).next();
              localObject4 = pux.a(parampuh.iO, ((Long)localObject3).longValue());
              if (localObject4 != null) {
                break label537;
              }
              ram.e("Q.qqstory:ReqMsgTabNodeVideoList", "find index %d return null!, videoList is = %s", new Object[] { localObject3, parampuh.iO });
            }
            for (;;)
            {
              i += 1;
              break label464;
              break;
              label537:
              ((pux)localObject4).feedId = ((String)localObject1);
              ((pux)localObject4).vid = ((ByteStringMicro)paramArrayOfByte.vid_list.get(i)).toStringUtf8();
              if (paramArrayOfByte.recommand_id_list.has()) {
                ((pux)localObject4).Av = ((Integer)paramArrayOfByte.recommand_id_list.get(i)).intValue();
              }
            }
          }
          this.mD = parampuh.iO;
        }
        if (!parampuh.Ja()) {
          ram.w("Q.qqstory:ReqMsgTabNodeVideoList", "node info is not ok, %s", new Object[] { parampuh.iO });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvg
 * JD-Core Version:    0.7.0.1
 */