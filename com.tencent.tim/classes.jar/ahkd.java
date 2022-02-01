import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public class ahkd
{
  private static final String bKK = acfp.m(2131720028);
  private Context J;
  private OpenSdkShareModel a;
  private MessageForArkApp f;
  private QQAppInterface mApp;
  private String mKey;
  private long uy = -1L;
  
  private boolean C(Bundle paramBundle)
  {
    if (!aeln.ahi()) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (ArkFullScreenAppActivity.t(paramBundle));
      i = paramBundle.getInt("uintype");
      if ("0".equals(ForwardUtils.cx(i)))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "toFakeMsg not support =", Integer.valueOf(i) });
        return false;
      }
      i = paramBundle.getInt("req_type");
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "toFakeMsg reqType=", Integer.valueOf(i) });
    } while ((i != 1) && (i != 2));
    return true;
  }
  
  private void a(akyf.a parama, Bundle paramBundle, long paramLong)
  {
    String str;
    Object localObject;
    if (System.currentTimeMillis() - paramLong > 10000L)
    {
      bool = true;
      str = paramBundle.getString("uin");
      HashMap localHashMap = new HashMap();
      if (!bool) {
        break label143;
      }
      localObject = "1";
      label41:
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label150;
      }
      localObject = "";
      label60:
      ahlw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(parama));
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "handleSendResult timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label157;
      }
      b(new Object[] { Integer.valueOf(0), "", acfp.m(2131706500), "" }, -3);
    }
    label143:
    label150:
    label157:
    do
    {
      return;
      bool = false;
      break;
      localObject = "0";
      break label41;
      localObject = str;
      break label60;
      i = parama.result;
      localObject = (String[])parama.data;
      if (i == 0)
      {
        if ((localObject != null) && (localObject.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend urls=" + localObject[0] + ", " + localObject[1]);
          a(paramBundle, localObject[0], localObject[1], paramLong);
          return;
        }
        QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = parama.errCode;
    boolean bool = ForwardUtils.aL(this.J);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed errCode=", i + ", hasSDPermission=", Boolean.valueOf(bool) });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed urls=", localObject[0], " ,", localObject[1] });
      a(paramBundle, localObject[0], localObject[1], paramLong);
      return;
    }
    b(new Object[] { Integer.valueOf(0), "", bKK, "" }, -4);
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, long paramLong)
  {
    if (this.f == null) {}
    for (long l = 0L;; l = this.f.uniseq)
    {
      paramString1 = ahlj.a(paramBundle, paramString1, paramString2, null, l);
      ahlj.a(this.a, paramBundle, paramString1);
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if (paramString2 != null) {
        break;
      }
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage send runtime = null ");
      b(new Object[] { Integer.valueOf(0), "", bKK, "" }, -5);
      return;
    }
    this.uy = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.uy);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage sendOIDBRequest");
    ahlw.Kj("KEY_STAGE_2_NORMAL_B77");
    jnm.a(paramString2, new ahkf(this, paramLong, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, AbsShareMsg paramAbsShareMsg, Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fake_key", this.mKey);
      localJSONObject.put("forward_type", paramAbsShareMsg.forwardType);
      localJSONObject.put("serviceType", paramAbsShareMsg.mMsgServiceID);
      localJSONObject.put("appId", paramAbsShareMsg.mSourceAppid);
      localJSONObject.put("pkg_name", paramAbsShareMsg.shareData.pkgName);
      localJSONObject.put("targetUrl", paramAbsShareMsg.mMsgUrl);
      localJSONObject.put("title", paramAbsShareMsg.mContentTitle);
      localJSONObject.put("summary", paramAbsShareMsg.mContentSummary);
      localJSONObject.put("image_url", paramAbsShareMsg.mContentCover);
      localJSONObject.put("audio_url", paramAbsShareMsg.mContentSrc);
      localJSONObject.put("imageUrlStatus", paramAbsShareMsg.shareData.imageUrlStatus);
      localJSONObject.put("shortUrlStatus", paramAbsShareMsg.shareData.shortUrlStatus);
      localJSONObject.put("appInfo_sourceName", paramAbsShareMsg.mSourceName);
      localJSONObject.put("appInfo_sourceIconSmall", paramAbsShareMsg.mSourceIcon);
      localJSONObject.put("appInfo_sourceIconBig", paramAbsShareMsg.shareData.sourceIconBig);
      localJSONObject.put("appInfo_sourceUrl", paramAbsShareMsg.mSourceUrl);
      localJSONObject.put("appInfo_packName", paramAbsShareMsg.mSource_A_ActionData);
      localJSONObject.put("appInfo_status", paramAbsShareMsg.shareData.appInfoStatus);
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("req_type", paramBundle.getInt("req_type"));
      localJSONObject.put("title", paramBundle.getString("title"));
      localJSONObject.put("uintype", paramBundle.getInt("uintype"));
      localJSONObject.put("share_comment_message_for_server", paramBundle.getString("share_comment_message_for_server"));
      localJSONObject.put("req_share_id", paramBundle.getLong("req_share_id"));
      localJSONObject.put("desc", paramBundle.getString("desc"));
      localJSONObject.put("detail_url", paramBundle.getString("detail_url"));
      localJSONObject.put("image_url_remote", paramBundle.getString("image_url_remote"));
      localJSONObject.put("res_pkg_name", paramBundle.getString("res_pkg_name"));
      localJSONObject.put("share_comment_message", paramBundle.getString("share_comment_message"));
      localJSONObject.put("forward_ark_app_name", paramBundle.getString("forward_ark_app_name"));
      localJSONObject.put("forward_ark_app_view", paramBundle.getString("forward_ark_app_view"));
      localJSONObject.put("forward_ark_app_ver", paramBundle.getString("forward_ark_app_ver"));
      localJSONObject.put("forward_ark_app_meta", paramBundle.getString("forward_ark_app_meta"));
      localJSONObject.put("forward_ark_app_config", paramBundle.getString("forward_ark_app_config"));
      localJSONObject.put("shareArkInfo", paramBundle.getString("shareArkInfo"));
      localJSONObject.put("forward_ark_app_desc", paramBundle.getString("forward_ark_app_desc"));
      localJSONObject.put("forward_ark_app_prompt", paramBundle.getString("forward_ark_app_prompt"));
      localJSONObject.put("forward_ark_app_compat", paramBundle.getString("forward_ark_app_compat"));
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("troop_uin", paramBundle.getString("troop_uin"));
      localJSONObject.put("phonenum", paramBundle.getString("phonenum"));
      localJSONObject.put("entrance", paramBundle.getInt("entrance", 0));
      localJSONObject.put("add_friend_source_id", paramBundle.getInt("add_friend_source_id", 3999));
      paramAbsShareMsg = localJSONObject.toString();
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "saveExtInfo jsonStr=", paramAbsShareMsg });
      paramMessageForArkApp.saveExtInfoToExtStr(anbb.cdf, Integer.toString(-1));
      paramMessageForArkApp.saveExtInfoToExtStr(anbb.cdh, paramAbsShareMsg);
      return;
    }
    catch (Exception paramMessageForArkApp)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "Exception", paramMessageForArkApp);
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("uintype");
    String str2 = paramBundle.getString("troop_uin");
    ahlw.Kj("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ahke localahke = new ahke(this, paramBundle, System.currentTimeMillis());
    if (C(paramBundle))
    {
      this.f = AbsShareMsg.sendSdkFakeMessage(paramBundle, localQQAppInterface, paramAbsShareMsg, str1, i, str2, localahke);
      a(this.f, paramAbsShareMsg, paramBundle);
      paramBundle.putString("fake_friend_uin", this.f.frienduin);
      paramBundle.putInt("fake_is_troop", this.f.istroop);
      paramBundle.putLong("fake_uinseq", this.f.uniseq);
      return;
    }
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, paramAbsShareMsg, str1, i, str2, localahke);
  }
  
  private void b(Object[] paramArrayOfObject, int paramInt)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyAIOActivity result[0]=", paramArrayOfObject[0], ", result[1]=", paramArrayOfObject[1], ", result[2]=", paramArrayOfObject[2], ", result[3]=", paramArrayOfObject[3], ", errorCode=", Integer.valueOf(paramInt) });
    c(paramArrayOfObject, paramInt);
    if ((-6 == paramInt) || (-3 == paramInt)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_b77_jump_result", paramArrayOfObject[0]);
    localHashMap.put("key_b77_jump_url", paramArrayOfObject[1]);
    localHashMap.put("key_b77_wording", paramArrayOfObject[2]);
    localHashMap.put("key_b77_develop_msg", paramArrayOfObject[3]);
    localHashMap.put("key_b77_error_code", Integer.valueOf(paramInt));
    paramArrayOfObject = new Intent("action_notify_aio_activity_by_b77");
    paramArrayOfObject.putExtra("key_b77_error_code", paramInt);
    BaseApplication.getContext().sendBroadcast(paramArrayOfObject);
    ((ahlc)this.mApp.getManager(350)).h(this.mKey, localHashMap);
  }
  
  private void c(Object[] paramArrayOfObject, int paramInt)
  {
    if (this.f == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "updateFakeArkMsg (null == mFakeArkMsg)");
      return;
    }
    if ((paramInt == 0) || (paramInt == -2))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "updateFakeArkMsg errorCode=", Integer.valueOf(paramInt) });
      this.f.extraflag = 32770;
      this.f.saveMsgExtStrAndFlag(this.mApp);
      this.mApp.a().e(this.f.frienduin, this.f.istroop, this.f.uniseq);
      this.mApp.a().notifyUI(6003, true, new String[] { this.f.frienduin, String.valueOf(this.f.uniseq) });
      return;
    }
    ahiy.a(this.mApp, this.f, paramInt, (String)paramArrayOfObject[2]);
  }
  
  private void cH(Bundle paramBundle)
  {
    String str = paramBundle.getString("share_comment_message_for_server");
    if ((this.J == null) || (TextUtils.isEmpty(str)))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg null");
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      paramBundle = ForwardUtils.a(paramBundle);
      jof.a().aaQ = true;
      ujt.e(localQQAppInterface, this.J, paramBundle, str);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg exception", paramBundle);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, Activity paramActivity, Bundle paramBundle, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mKey = paramString;
    this.J = paramActivity;
    this.a = ((OpenSdkShareModel)paramActivity.getIntent().getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
    if (paramAbsShareMsg == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "requestShareMessage error structMsg = null");
      return;
    }
    if (!aqiw.isNetSupport(this.J))
    {
      b(new Object[] { Integer.valueOf(0), "", acfp.m(2131706501), "" }, -2);
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " requestShareMessage net error");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { " forwardShare structMsg=", paramAbsShareMsg.getXml(), ", key=", paramString });
    anot.a(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, "", ForwardUtils.cz(paramBundle.getInt("req_type")), ForwardUtils.cx(paramBundle.getInt("uintype")), paramBundle.getString("title"));
    a(paramAbsShareMsg, paramBundle);
  }
  
  public void a(MessageForArkApp paramMessageForArkApp, Context paramContext, JSONObject paramJSONObject)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "resend message jsonObject=" + paramJSONObject.toString());
    if (!aqiw.isNetSupport(this.J))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " resend net error");
      ahhj.a((Activity)paramContext, acfp.m(2131706501), new ahkg(this));
      return;
    }
    this.J = paramContext;
    this.f = paramMessageForArkApp;
    this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.mKey = paramJSONObject.optString("fake_key");
    paramContext = new Bundle();
    paramContext.putInt("forward_type", paramJSONObject.optInt("forward_type"));
    paramContext.putInt("serviceType", paramJSONObject.optInt("serviceType"));
    paramContext.putLong("appId", paramJSONObject.optLong("appId"));
    paramContext.putString("pkg_name", paramJSONObject.optString("pkg_name"));
    paramContext.putString("targetUrl", paramJSONObject.optString("targetUrl"));
    paramContext.putString("title", paramJSONObject.optString("title"));
    paramContext.putString("summary", paramJSONObject.optString("summary"));
    paramContext.putString("image_url", paramJSONObject.optString("image_url"));
    paramContext.putString("audio_url", paramJSONObject.optString("audio_url"));
    paramContext.putInt("imageUrlStatus", paramJSONObject.optInt("imageUrlStatus"));
    paramContext.putInt("shortUrlStatus", paramJSONObject.optInt("shortUrlStatus"));
    paramContext.putString("appInfo_sourceName", paramJSONObject.optString("appInfo_sourceName"));
    paramContext.putString("appInfo_sourceIconSmall", paramJSONObject.optString("appInfo_sourceIconSmall"));
    paramContext.putString("appInfo_sourceIconBig", paramJSONObject.optString("appInfo_sourceIconBig"));
    paramContext.putString("appInfo_sourceUrl", paramJSONObject.optString("appInfo_sourceUrl"));
    paramContext.putString("appInfo_packName", paramJSONObject.optString("appInfo_packName"));
    paramContext.putInt("appInfo_status", paramJSONObject.optInt("appInfo_status"));
    paramContext.putString("uin", paramJSONObject.optString("uin"));
    paramContext.putInt("req_type", paramJSONObject.optInt("req_type"));
    paramContext.putString("title", paramJSONObject.optString("title"));
    paramContext.putInt("uintype", paramJSONObject.optInt("uintype"));
    paramContext.putString("share_comment_message_for_server", paramJSONObject.optString("share_comment_message_for_server"));
    paramContext.putLong("req_share_id", paramJSONObject.optLong("req_share_id"));
    paramContext.putString("desc", paramJSONObject.optString("desc"));
    paramContext.putString("detail_url", paramJSONObject.optString("detail_url"));
    paramContext.putString("image_url_remote", paramJSONObject.optString("image_url_remote"));
    paramContext.putString("res_pkg_name", paramJSONObject.optString("res_pkg_name"));
    paramContext.putString("share_comment_message", paramJSONObject.optString("share_comment_message"));
    paramContext.putString("forward_ark_app_name", paramJSONObject.optString("forward_ark_app_name"));
    paramContext.putString("forward_ark_app_view", paramJSONObject.optString("forward_ark_app_view"));
    paramContext.putString("forward_ark_app_ver", paramJSONObject.optString("forward_ark_app_ver"));
    paramContext.putString("forward_ark_app_meta", paramJSONObject.optString("forward_ark_app_meta"));
    paramContext.putString("forward_ark_app_config", paramJSONObject.optString("forward_ark_app_config"));
    paramContext.putString("shareArkInfo", paramJSONObject.optString("shareArkInfo"));
    paramContext.putString("forward_ark_app_desc", paramJSONObject.optString("forward_ark_app_desc"));
    paramContext.putString("forward_ark_app_prompt", paramJSONObject.optString("forward_ark_app_prompt"));
    paramContext.putString("forward_ark_app_compat", paramJSONObject.optString("forward_ark_app_compat"));
    paramContext.putString("uin", paramJSONObject.optString("uin"));
    paramContext.putString("troop_uin", paramJSONObject.optString("troop_uin"));
    paramContext.putString("phonenum", paramJSONObject.optString("phonenum"));
    paramContext.putInt("entrance", paramJSONObject.optInt("entrance", 0));
    paramContext.putInt("add_friend_source_id", paramJSONObject.optInt("add_friend_source_id", 3999));
    AbsShareMsg.resendSdkFakeMessage(paramMessageForArkApp, paramJSONObject, new ahkh(this, paramContext, System.currentTimeMillis()));
    this.f.extraflag = 32772;
    this.f.saveMsgData(this.mApp);
    this.f.saveMsgExtStrAndFlag(this.mApp);
    this.mApp.a().az(this.f);
    this.mApp.a().notifyUI(6003, false, new String[] { this.f.frienduin, String.valueOf(this.f.uniseq) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkd
 * JD-Core Version:    0.7.0.1
 */