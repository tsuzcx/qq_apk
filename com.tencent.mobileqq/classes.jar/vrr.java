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

public class vrr
{
  private bctj a;
  
  private vrr()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
    UserAction.registerTunnel(new TunnelInfo("00000VCDPV3YVLO1"));
    UserAction.setAppKey("00000VCDPV3YVLO1");
    UserAction.setLogAble(false, false);
    QLog.d("QCircleDengTaReporter", 1, "getQIMEI , qimei:" + UserAction.getQIMEI());
    this.a = bctj.a(BaseApplicationImpl.getContext());
  }
  
  public static vrr a()
  {
    return vru.a();
  }
  
  public void a(vrt paramvrt)
  {
    if (paramvrt == null)
    {
      QLog.e("QCircleDengTaReporter", 1, "DataBuilder == null");
      return;
    }
    Object localObject1;
    String str;
    StringBuilder localStringBuilder;
    label67:
    Object localObject2;
    if (uxx.a() == 0L)
    {
      localObject1 = "";
      str = String.valueOf(localObject1);
      UserAction.setUserID(str);
      localStringBuilder = new StringBuilder();
      if (vrt.a(paramvrt) != null)
      {
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getPageIdStr())) {
          break label921;
        }
        localObject1 = "main";
        localObject2 = localStringBuilder.append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getModuleIdStr())) {
          break label932;
        }
        localObject1 = "main";
        label96:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vrt.b(paramvrt))) {
          break label943;
        }
        localObject1 = "main";
        label122:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("#");
        if (!TextUtils.isEmpty(vrt.a(paramvrt))) {
          break label951;
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
      ((HashMap)localObject2).put("network_type", vrv.a() + "");
      if (vrt.c(paramvrt) != null) {
        ((HashMap)localObject2).put("qq_touin", vrt.c(paramvrt));
      }
      if (vrt.a(paramvrt) != -1) {
        ((HashMap)localObject2).put("position_index", String.valueOf(vrt.a(paramvrt)));
      }
      if (vrt.b(paramvrt) != -1) {
        ((HashMap)localObject2).put("feed_index", String.valueOf(vrt.b(paramvrt) + 1));
      }
      ((HashMap)localObject2).put("isreaded", "1");
      if (vrt.d(paramvrt) != null) {
        ((HashMap)localObject2).put("video_total_time", vrt.d(paramvrt));
      }
      if (vrt.e(paramvrt) != null) {
        ((HashMap)localObject2).put("video_play_time", vrt.e(paramvrt));
      }
      if (vrt.a(paramvrt) != null)
      {
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getPageIdStr())) {
          break label959;
        }
        localObject1 = "main";
        label362:
        ((HashMap)localObject2).put("page_id", localObject1);
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getModuleIdStr())) {
          break label970;
        }
        localObject1 = "main";
        label387:
        ((HashMap)localObject2).put("module_id", localObject1);
        if (!TextUtils.isEmpty(vrt.b(paramvrt))) {
          break label981;
        }
        localObject1 = "main";
        label409:
        ((HashMap)localObject2).put("element_id", localObject1);
        ((HashMap)localObject2).put("action_id", vrt.a(paramvrt));
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getFromPageIdStr())) {
          break label989;
        }
        localObject1 = "main";
        label446:
        ((HashMap)localObject2).put("fpage_id", localObject1);
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getFromModuleIdStr())) {
          break label1000;
        }
        localObject1 = "main";
        label471:
        ((HashMap)localObject2).put("fmodule_id", localObject1);
        if (!TextUtils.isEmpty(vrt.a(paramvrt).getFromElementIdStr())) {
          break label1011;
        }
        localObject1 = "main";
        label496:
        ((HashMap)localObject2).put("felement_id", localObject1);
      }
      if (vrt.a(paramvrt) != null)
      {
        ((HashMap)localObject2).put("feedid", vrt.a(paramvrt).id.get());
        ((HashMap)localObject2).put("feed_tag", vse.a(vrt.a(paramvrt)));
        ((HashMap)localObject2).put("author_uin", vrt.a(paramvrt).poster.id.get());
        if (!vrt.a(paramvrt).reportInfoForClient.has()) {
          break label1032;
        }
        localObject1 = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StReportInfoForClient)localObject1).mergeFrom(vrt.a(paramvrt).reportInfoForClient.get().toByteArray());
        ((HashMap)localObject2).put("feedtype1", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype1.get()));
        ((HashMap)localObject2).put("feedtype2", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype2.get()));
        ((HashMap)localObject2).put("feedtype3", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject1).feedtype3.get()));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label921:
        label932:
        label943:
        label951:
        label959:
        label970:
        label981:
        label989:
        label1000:
        label1011:
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0)
      {
        localObject1 = vse.a(vrt.a(paramvrt));
        ((HashMap)localObject2).put("feedtype1", String.valueOf(localObject1[0]));
        ((HashMap)localObject2).put("feedtype2", String.valueOf(localObject1[1]));
      }
      if (vrt.f(paramvrt) != null) {
        ((HashMap)localObject2).put("ext1", vrt.f(paramvrt));
      }
      if (vrt.g(paramvrt) != null) {
        ((HashMap)localObject2).put("ext2", vrt.g(paramvrt));
      }
      if (vrt.h(paramvrt) != null) {
        ((HashMap)localObject2).put("ext3", vrt.h(paramvrt));
      }
      if (vrt.i(paramvrt) != null) {
        ((HashMap)localObject2).put("ext4", vrt.i(paramvrt));
      }
      if (vrt.j(paramvrt) != null) {
        ((HashMap)localObject2).put("ext5", vrt.j(paramvrt));
      }
      if (vrt.k(paramvrt) != null) {
        ((HashMap)localObject2).put("ext6", vrt.k(paramvrt));
      }
      if (vrt.l(paramvrt) != null) {
        ((HashMap)localObject2).put("ext7", vrt.l(paramvrt));
      }
      if (vrt.m(paramvrt) != null) {
        ((HashMap)localObject2).put("ext8", vrt.m(paramvrt));
      }
      vrv.a(localStringBuilder.toString(), (HashMap)localObject2);
      if (this.a == null) {
        break label1037;
      }
      this.a.a("00000VCDPV3YVLO1", str, localStringBuilder.toString(), true, -1L, -1L, (HashMap)localObject2, "");
      return;
      localObject1 = Long.valueOf(uxx.a());
      break;
      localObject1 = vrt.a(paramvrt).getPageIdStr();
      break label67;
      localObject1 = vrt.a(paramvrt).getModuleIdStr();
      break label96;
      localObject1 = vrt.b(paramvrt);
      break label122;
      localObject1 = vrt.a(paramvrt);
      break label148;
      localObject1 = vrt.a(paramvrt).getPageIdStr();
      break label362;
      localObject1 = vrt.a(paramvrt).getModuleIdStr();
      break label387;
      localObject1 = vrt.b(paramvrt);
      break label409;
      localObject1 = vrt.a(paramvrt).getFromPageIdStr();
      break label446;
      localObject1 = vrt.a(paramvrt).getFromModuleIdStr();
      break label471;
      localObject1 = vrt.a(paramvrt).getFromElementIdStr();
      break label496;
      label1032:
      int i = 0;
    }
    label1037:
    bctj.a(BaseApplicationImpl.getContext()).a("00000VCDPV3YVLO1", str, localStringBuilder.toString(), true, -1L, -1L, (HashMap)localObject2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrr
 * JD-Core Version:    0.7.0.1
 */