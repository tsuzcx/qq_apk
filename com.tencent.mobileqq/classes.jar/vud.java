import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;

public class vud
{
  private vud()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
    UserAction.registerTunnel(new TunnelInfo("00000VCDPV3YVLO1"));
    UserAction.setAppKey("00000VCDPV3YVLO1");
    UserAction.setLogAble(false, false);
    QLog.d("QCircleDengTaReporter", 1, "getQIMEI , qimei:" + UserAction.getQIMEI());
  }
  
  private bdmc a()
  {
    return bdmc.a(BaseApplicationImpl.getContext());
  }
  
  public static vud a()
  {
    return vug.a();
  }
  
  public void a(vuf paramvuf)
  {
    if (paramvuf == null)
    {
      QLog.e("QCircleDengTaReporter", 1, "DataBuilder == null");
      return;
    }
    Object localObject1;
    String str;
    StringBuilder localStringBuilder;
    label67:
    Object localObject2;
    if (uzg.a() == 0L)
    {
      localObject1 = "";
      str = String.valueOf(localObject1);
      UserAction.setUserID(str);
      localStringBuilder = new StringBuilder();
      if (vuf.a(paramvuf) != null)
      {
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getPageIdStr())) {
          break label914;
        }
        localObject1 = "main";
        localObject2 = localStringBuilder.append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getModuleIdStr())) {
          break label925;
        }
        localObject1 = "main";
        label96:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vuf.b(paramvuf))) {
          break label936;
        }
        localObject1 = "main";
        label122:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vuf.a(paramvuf))) {
          break label944;
        }
        localObject1 = "main";
        label148:
        ((StringBuilder)localObject2).append((String)localObject1);
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("event_code", localStringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        ((HashMap)localObject2).put("qq_uin", str);
      }
      ((HashMap)localObject2).put("network_type", vuh.a() + "");
      if (vuf.c(paramvuf) != null) {
        ((HashMap)localObject2).put("qq_touin", vuf.c(paramvuf));
      }
      if (vuf.a(paramvuf) != -1) {
        ((HashMap)localObject2).put("position_index", String.valueOf(vuf.a(paramvuf)));
      }
      if (vuf.b(paramvuf) != -1) {
        ((HashMap)localObject2).put("feed_index", String.valueOf(vuf.b(paramvuf) + 1));
      }
      ((HashMap)localObject2).put("isreaded", "1");
      if (vuf.d(paramvuf) != null) {
        ((HashMap)localObject2).put("video_total_time", vuf.d(paramvuf));
      }
      if (vuf.e(paramvuf) != null) {
        ((HashMap)localObject2).put("video_play_time", vuf.e(paramvuf));
      }
      if (vuf.a(paramvuf) != null)
      {
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getPageIdStr())) {
          break label952;
        }
        localObject1 = "main";
        label362:
        ((HashMap)localObject2).put("page_id", localObject1);
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getModuleIdStr())) {
          break label963;
        }
        localObject1 = "main";
        label387:
        ((HashMap)localObject2).put("module_id", localObject1);
        if (!TextUtils.isEmpty(vuf.b(paramvuf))) {
          break label974;
        }
        localObject1 = "main";
        label409:
        ((HashMap)localObject2).put("element_id", localObject1);
        ((HashMap)localObject2).put("action_id", vuf.a(paramvuf));
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getFromPageIdStr())) {
          break label982;
        }
        localObject1 = "main";
        label446:
        ((HashMap)localObject2).put("fpage_id", localObject1);
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getFromModuleIdStr())) {
          break label993;
        }
        localObject1 = "main";
        label471:
        ((HashMap)localObject2).put("fmodule_id", localObject1);
        if (!TextUtils.isEmpty(vuf.a(paramvuf).getFromElementIdStr())) {
          break label1004;
        }
        localObject1 = "main";
        label496:
        ((HashMap)localObject2).put("felement_id", localObject1);
      }
      if (vuf.a(paramvuf) != null)
      {
        ((HashMap)localObject2).put("feedid", vuf.a(paramvuf).id.get());
        ((HashMap)localObject2).put("feed_tag", vur.a(vuf.a(paramvuf)));
        ((HashMap)localObject2).put("author_uin", vuf.a(paramvuf).poster.id.get());
        if (!vuf.a(paramvuf).reportInfoForClient.has()) {
          break label1025;
        }
        localObject1 = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StReportInfoForClient)localObject1).mergeFrom(vuf.a(paramvuf).reportInfoForClient.get().toByteArray());
        ((HashMap)localObject2).put("feedtype1", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype1.get()));
        ((HashMap)localObject2).put("feedtype2", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype2.get()));
        ((HashMap)localObject2).put("feedtype3", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype3.get()));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label914:
        label925:
        label936:
        label944:
        label952:
        label963:
        label974:
        label982:
        label993:
        label1004:
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0)
      {
        localObject1 = vur.a(vuf.a(paramvuf));
        ((HashMap)localObject2).put("feedtype1", String.valueOf(localObject1[0]));
        ((HashMap)localObject2).put("feedtype2", String.valueOf(localObject1[1]));
      }
      if (vuf.f(paramvuf) != null) {
        ((HashMap)localObject2).put("ext1", vuf.f(paramvuf));
      }
      if (vuf.g(paramvuf) != null) {
        ((HashMap)localObject2).put("ext2", vuf.g(paramvuf));
      }
      if (vuf.h(paramvuf) != null) {
        ((HashMap)localObject2).put("ext3", vuf.h(paramvuf));
      }
      if (vuf.i(paramvuf) != null) {
        ((HashMap)localObject2).put("ext4", vuf.i(paramvuf));
      }
      if (vuf.j(paramvuf) != null) {
        ((HashMap)localObject2).put("ext5", vuf.j(paramvuf));
      }
      if (vuf.k(paramvuf) != null) {
        ((HashMap)localObject2).put("ext6", vuf.k(paramvuf));
      }
      if (vuf.l(paramvuf) != null) {
        ((HashMap)localObject2).put("ext7", vuf.l(paramvuf));
      }
      if (vuf.m(paramvuf) != null) {
        ((HashMap)localObject2).put("ext8", vuf.m(paramvuf));
      }
      vuh.a(localStringBuilder.toString(), (HashMap)localObject2);
      a().a("00000VCDPV3YVLO1", str, localStringBuilder.toString(), true, -1L, -1L, (HashMap)localObject2, "");
      return;
      localObject1 = Long.valueOf(uzg.a());
      break;
      localObject1 = vuf.a(paramvuf).getPageIdStr();
      break label67;
      localObject1 = vuf.a(paramvuf).getModuleIdStr();
      break label96;
      localObject1 = vuf.b(paramvuf);
      break label122;
      localObject1 = vuf.a(paramvuf);
      break label148;
      localObject1 = vuf.a(paramvuf).getPageIdStr();
      break label362;
      localObject1 = vuf.a(paramvuf).getModuleIdStr();
      break label387;
      localObject1 = vuf.b(paramvuf);
      break label409;
      localObject1 = vuf.a(paramvuf).getFromPageIdStr();
      break label446;
      localObject1 = vuf.a(paramvuf).getFromModuleIdStr();
      break label471;
      localObject1 = vuf.a(paramvuf).getFromElementIdStr();
      break label496;
      label1025:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vud
 * JD-Core Version:    0.7.0.1
 */