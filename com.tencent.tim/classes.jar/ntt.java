import com.qq.ac.sdk.api.AcInterface;
import com.qq.ac.sdk.api.AcType.Gender;
import com.qq.ac.sdk.api.AcType.UidType;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.4.1;
import com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentHeader;
import com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentList;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.CacheModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.ComicModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.DtReportModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.NavigationModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QReportModule;
import com.tencent.biz.pubaccount.readinjoy.viola.redpacket.VKdRedPacketProgress;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKEngine.InitCallback;
import com.tencent.viola.ui.view.lottie.VLottieView.Factory;
import org.json.JSONObject;

public final class ntt
  implements ViolaSDKEngine.InitCallback
{
  ntt(AppInterface paramAppInterface, ntp.a parama) {}
  
  public void onFinish(int paramInt, long paramLong, String paramString)
  {
    JSONObject localJSONObject = null;
    QLog.e("ViolaAccessHelper", 2, new Object[] { "QViolaSDKEngine", "sdk initialize errCode:" + paramInt });
    if ((paramInt == 0) || (paramInt == 1)) {
      for (;;)
      {
        try
        {
          ViolaSDKEngine.registerModule("bridge", BridgeModule.class, false);
          ViolaSDKEngine.registerModule("navigation", NavigationModule.class, true);
          ViolaSDKEngine.registerModule("QReport", QReportModule.class, true);
          ViolaSDKEngine.registerModule("cache", CacheModule.class, true);
          ViolaSDKEngine.registerModule("comic", ComicModule.class, true);
          ViolaSDKEngine.registerModule("report", DtReportModule.class, true);
          ViolaSDKEngine.registerComponent(VVideo.class, false, new String[] { "video" });
          ViolaSDKEngine.registerComponent(VKdRedPacketProgress.class, false, new String[] { "kdredpacket-process" });
          ViolaSDKEngine.registerComponent(VTopicVideo.class, false, new String[] { "topic-video" });
          ViolaSDKEngine.registerComponent(KdCommentList.class, false, new String[] { "kdcomment" });
          ViolaSDKEngine.registerComponent(KdCommentHeader.class, false, new String[] { "kdcomment-header" });
          VLottieView.Factory.setVLottieViewCreater(new nup());
          if (this.b != null)
          {
            paramString = this.b.getApplication();
            AcInterface.init(paramString);
            AcInterface.setAppID("ac0632ab2c1e20593b52");
            AcInterface.setAppKey("zBWcxAx7HhqAj0pu2RaXm0T8QElpYiiLXMK4553L2uj");
            paramString = localJSONObject;
            if (this.b != null) {
              paramString = this.b.getAccount();
            }
            AcInterface.setUid(paramString, AcType.UidType.QQ, AcType.Gender.UNKNOWN);
            if (this.a != null) {
              this.b.runOnUiThread(new ViolaAccessHelper.4.1(this, paramLong));
            }
            return;
          }
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ViolaAccessHelper", 2, "SDKInitialize Exception e: " + paramString.getMessage());
          return;
        }
        paramString = null;
      }
    }
    if (this.a != null) {
      this.a.bbr();
    }
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("error_msg", paramString);
      kbp.a(null, null, "0X800AB6F", "0X800AB6F", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntt
 * JD-Core Version:    0.7.0.1
 */