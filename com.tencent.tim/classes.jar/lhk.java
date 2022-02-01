import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.d;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ReqBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.RspBody;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class lhk
  extends lir
{
  private final ConcurrentHashMap<Integer, TopBannerInfo> bl = new ConcurrentHashMap();
  
  public lhk(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler, lhf paramlhf)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    if (paramlhf != null) {
      paramlhf.a(new lhl(this));
    }
  }
  
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    paramToServiceMsg = new oidb_cmd0xbc9.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ReadInJoyEngineModule", 2, new Object[] { "handle0xbc9BannerInfo result = ", Integer.valueOf(i) });
    if ((i == 0) && (paramToServiceMsg.msg_banner_round_rsp_body.has()))
    {
      paramObject = (oidb_cmd0xbc9.BannerRoundRspBody)paramToServiceMsg.msg_banner_round_rsp_body.get();
      if ((!paramObject.uint32_need_update.has()) || (paramObject.uint32_need_update.get() != 1)) {
        break label453;
      }
      paramFromServiceMsg = new TopBannerInfo();
      if ((paramObject.rpt_msg_banner_list.has()) && (paramObject.rpt_msg_banner_list.size() > 0))
      {
        i = 0;
        if (i < paramObject.rpt_msg_banner_list.size())
        {
          paramToServiceMsg = (oidb_cmd0xbc9.BannerItem)paramObject.rpt_msg_banner_list.get(i);
          if (paramToServiceMsg.uint32_banner_type.has())
          {
            if (paramToServiceMsg.uint32_banner_type.get() != 2) {
              break label199;
            }
            if (!paramToServiceMsg.msg_video_banner_item.has()) {
              break label462;
            }
            paramToServiceMsg = TopBannerInfo.f.a(paramToServiceMsg);
          }
        }
      }
    }
    label453:
    for (;;)
    {
      if (paramToServiceMsg != null) {
        paramFromServiceMsg.addItem(paramToServiceMsg);
      }
      i += 1;
      break;
      label199:
      if (paramToServiceMsg.msg_article_content_item.has())
      {
        paramToServiceMsg = TopBannerInfo.d.a(paramToServiceMsg);
        continue;
        if (paramObject.bytes_cookie.has()) {
          paramFromServiceMsg.mCookie = paramObject.bytes_cookie.get().toStringUtf8();
        }
        if (paramObject.uint32_channel_id.has()) {
          paramFromServiceMsg.mChannelId = paramObject.uint32_channel_id.get();
        }
        if ((paramObject.rpt_msg_dynamic_banner_list.has()) && (paramObject.rpt_msg_dynamic_banner_list.size() > 0))
        {
          i = j;
          while (i < paramObject.rpt_msg_dynamic_banner_list.size())
          {
            if ((((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i)).has()) && (paramObject.rpt_msg_dynamic_banner_list.get(i) != null))
            {
              paramToServiceMsg = TopBannerInfo.c.a((oidb_cmd0xbc9.DynamicBannerItem)paramObject.rpt_msg_dynamic_banner_list.get(i));
              if (paramToServiceMsg != null)
              {
                paramToServiceMsg = paramToServiceMsg.iterator();
                while (paramToServiceMsg.hasNext()) {
                  paramFromServiceMsg.addDynamicItem((TopBannerInfo.c)paramToServiceMsg.next());
                }
              }
            }
            i += 1;
          }
        }
        if (paramObject.msg_more_channel_item.has())
        {
          paramToServiceMsg = TopBannerInfo.e.a((oidb_cmd0xbc9.MoreChannelItem)paramObject.msg_more_channel_item.get());
          if (paramToServiceMsg != null) {
            paramFromServiceMsg.setMoreChannelItem(paramToServiceMsg);
          }
        }
        b(paramFromServiceMsg);
        QLog.d("ReadInJoyEngineModule", 2, "handle0xbc9BannerInfo bannerInfo = " + paramFromServiceMsg);
        return;
        QLog.d("ReadInJoyEngineModule", 2, "handle0xbc9BannerInfo uint32_need_update = 0");
      }
      else
      {
        label462:
        paramToServiceMsg = null;
      }
    }
  }
  
  private void b(TopBannerInfo paramTopBannerInfo)
  {
    c(paramTopBannerInfo);
    this.bl.put(Integer.valueOf(paramTopBannerInfo.mChannelId), paramTopBannerInfo);
    this.mMainThreadHandler.post(new BannerInfoModule.2(this, paramTopBannerInfo));
  }
  
  private void c(TopBannerInfo paramTopBannerInfo)
  {
    a(paramTopBannerInfo);
  }
  
  public TopBannerInfo a(int paramInt)
  {
    return (TopBannerInfo)this.bl.get(Integer.valueOf(paramInt));
  }
  
  public void aEL() {}
  
  public void cL(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1);
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((TopBannerInfo)localObject1).mCookie)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = new oidb_cmd0xbc9.ReqBody();
      oidb_cmd0xbc9.BannerRoundReqBody localBannerRoundReqBody = new oidb_cmd0xbc9.BannerRoundReqBody();
      localBannerRoundReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localBannerRoundReqBody.uint32_channel_id.set(paramInt1);
      ((oidb_cmd0xbc9.ReqBody)localObject1).msg_banner_round_req_body.set(localBannerRoundReqBody);
      sendPbReq(lup.makeOIDBPkg("OidbSvc.0xbc9", 3017, paramInt2, ((oidb_cmd0xbc9.ReqBody)localObject1).toByteArray()));
      QLog.d("ReadInJoyEngineModule", 2, "req banner info cookies: " + (String)localObject2 + "  channelId: " + paramInt1);
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbc9")) {
      U(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void rj(int paramInt)
  {
    cL(paramInt, 1);
  }
  
  public void rk(int paramInt)
  {
    List localList = this.mEntityManager.query(TopBannerInfo.class, true, "mChannelId IS NOT NULL AND mChannelId == ?", new String[] { "" + paramInt }, null, null, null, "1");
    if ((localList == null) || (localList.isEmpty()))
    {
      this.bl.putIfAbsent(Integer.valueOf(paramInt), new TopBannerInfo());
      return;
    }
    this.bl.putIfAbsent(Integer.valueOf(paramInt), localList.get(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhk
 * JD-Core Version:    0.7.0.1
 */