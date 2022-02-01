import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsReq;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsRsp;
import tencent.im.oidb.cmd0xda2.content_vidurl_svr.UrlInfo;
import tencent.im.oidb.cmd0xda2.oidb_cmd0xda2.ReqBody;
import tencent.im.oidb.cmd0xda2.oidb_cmd0xda2.RspBody;

public class lfq
  extends lir
  implements lfp
{
  private static lfq a = new lfq();
  private AtomicInteger R = new AtomicInteger(0);
  private final String aeM = "gifvideo.KandianShortContentGifStrategy";
  private ConcurrentHashMap<Integer, Object> bf = new ConcurrentHashMap();
  
  public lfq()
  {
    super(null, null, null, lun.a(), null);
  }
  
  private Object a(Integer paramInteger)
  {
    return this.bf.remove(paramInteger);
  }
  
  public static lfq a()
  {
    return a;
  }
  
  private void a(Integer paramInteger, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.bf.put(paramInteger, paramObject);
  }
  
  public void a(String paramString, lfp.a parama)
  {
    a(new String[] { paramString }, parama);
  }
  
  public void a(String[] paramArrayOfString, lfp.a parama)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      content_vidurl_svr.GetVid2UrlsReq localGetVid2UrlsReq = new content_vidurl_svr.GetVid2UrlsReq();
      Object localObject = aqgz.getQQVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetVid2UrlsReq.app_version.set((String)localObject);
      }
      localGetVid2UrlsReq.appid.set("143193");
      localGetVid2UrlsReq.app_name.set("");
      localObject = lfn.getIpAddress(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetVid2UrlsReq.client_ip.set((String)localObject);
      }
      localObject = kxm.iT();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGetVid2UrlsReq.imei.set((String)localObject);
      }
      localGetVid2UrlsReq.net_type.set(aroc.getNetType(null));
      localGetVid2UrlsReq.system.set(1);
      localGetVid2UrlsReq.timestamp.set(System.currentTimeMillis() / 1000L + "");
      if (kxm.getAppRuntime() != null) {}
      for (localObject = kxm.getAppRuntime().getAccount();; localObject = "")
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localGetVid2UrlsReq.uid.set((String)localObject);
        }
        int j = paramArrayOfString.length;
        i = 0;
        while (i < j)
        {
          localObject = paramArrayOfString[i];
          localGetVid2UrlsReq.vids.add(localObject);
          i += 1;
        }
      }
      localObject = MD5.toMD5(localGetVid2UrlsReq.appid.get() + "|" + localGetVid2UrlsReq.timestamp.get() + "|" + localGetVid2UrlsReq.uid.get() + "|" + localGetVid2UrlsReq.system.get() + "|" + localGetVid2UrlsReq.app_name.get() + "|" + localGetVid2UrlsReq.app_version.get() + "|" + "MTQzMTkzYWRhZmdkaGg=");
      localGetVid2UrlsReq.sign.set((String)localObject);
      localObject = new oidb_cmd0xda2.ReqBody();
      ((oidb_cmd0xda2.ReqBody)localObject).msg_get_vid_to_url_req.set(localGetVid2UrlsReq);
      ((oidb_cmd0xda2.ReqBody)localObject).uint32_req_type.set(1);
      localObject = lup.makeOIDBPkg("OidbSvc.0xda2", 3490, 0, ((oidb_cmd0xda2.ReqBody)localObject).toByteArray());
      QLog.d("gifvideo.KandianShortContentGifStrategy", 2, "request vids " + paramArrayOfString);
      int i = this.R.incrementAndGet();
      ((ToServiceMsg)localObject).addAttribute("vidToUrlSeq", Integer.valueOf(i));
      a(Integer.valueOf(i), parama);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xda2.RspBody();
    Object localObject2 = (Boolean)paramToServiceMsg.getAttribute("compressFlag");
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, new Object[] { "convertVidToUrl resp result code ", Integer.valueOf(kxf.a(paramToServiceMsg, paramFromServiceMsg, paramObject, (MessageMicro)localObject1, bool)) });
      if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp != null) && (((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_code.has()))
      {
        int i = ((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_code.get();
        QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "ret code is " + i);
        if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp == null) || (!((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_msg.has())) {
          break label457;
        }
        paramFromServiceMsg = ((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.ret_msg.get();
        QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "ret msg is " + paramFromServiceMsg);
        label187:
        if ((((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp == null) || (!((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.urls.has())) {
          break label567;
        }
        paramObject = (ArrayList)((oidb_cmd0xda2.RspBody)localObject1).msg_get_vid_to_url_rsp.urls.get();
        localObject1 = new StringBuilder().append("urls result: ");
        if (paramObject == null) {
          break label469;
        }
      }
      label457:
      label469:
      for (paramFromServiceMsg = paramObject.toString();; paramFromServiceMsg = "null")
      {
        QLog.d("gifvideo.KandianShortContentGifStrategy", 1, paramFromServiceMsg);
        if ((paramObject == null) || (paramObject.size() <= 0)) {
          break label556;
        }
        paramFromServiceMsg = new ArrayList();
        localObject1 = new ArrayList();
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          localObject2 = (content_vidurl_svr.UrlInfo)paramObject.next();
          if (localObject2 != null)
          {
            paramFromServiceMsg.add(((content_vidurl_svr.UrlInfo)localObject2).url.get());
            ((List)localObject1).add(((content_vidurl_svr.UrlInfo)localObject2).vid.get());
            QLog.d("gifvideo.KandianShortContentGifStrategy", 2, "update vid: " + ((content_vidurl_svr.UrlInfo)localObject2).vid.get() + " url: " + ((content_vidurl_svr.UrlInfo)localObject2).url.get());
            kxz localkxz = new kxz();
            localkxz.vid = ((content_vidurl_svr.UrlInfo)localObject2).vid.get();
            localkxz.url = ((content_vidurl_svr.UrlInfo)localObject2).url.get();
            kxv.a(localkxz);
          }
        }
        QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no ret code");
        break;
        QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no ret msg");
        break label187;
      }
      paramToServiceMsg = (lfp.a)a(Integer.valueOf(((Integer)paramToServiceMsg.getAttribute("vidToUrlSeq")).intValue()));
      if (paramToServiceMsg != null)
      {
        QLog.d("gifvideo.KandianShortContentGifStrategy", 2, "has callback");
        paramToServiceMsg.a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), (String[])paramFromServiceMsg.toArray(new String[paramFromServiceMsg.size()]));
        label556:
        return;
      }
      QLog.d("gifvideo.KandianShortContentGifStrategy", 2, " call back is null");
      return;
      label567:
      QLog.d("gifvideo.KandianShortContentGifStrategy", 1, "no urls");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfq
 * JD-Core Version:    0.7.0.1
 */