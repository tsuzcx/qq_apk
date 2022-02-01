import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper.4;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper.5;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ArkJsonBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ExtInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.MiniAppMsgBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RichMsgBody;

public class ahlj
  implements Handler.Callback, wvs
{
  public static final String bKK = acfp.m(2131720028);
  public final DialogInterface.OnClickListener P = new ahln(this);
  final akyf jdField_a_of_type_Akyf = new ahlk(this);
  private aqju jdField_a_of_type_Aqju;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  final long aaF = 10000L;
  private Dialog as;
  private aqju au;
  private final MqqHandler b = new aurf(Looper.getMainLooper(), this);
  private BroadcastReceiver bi;
  private int cZW;
  private volatile boolean chq;
  private volatile boolean isFirstShow;
  private boolean isTimeOut;
  private Activity mActivity;
  private BaseChatPie mBaseChatPie;
  private Bundle mExtra;
  private long mShareAppId;
  private long uy = -1L;
  
  public ahlj(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, " init ");
    }
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      this.mActivity = this.mBaseChatPie.mActivity;
      if (this.mActivity != null) {
        this.mExtra = this.mActivity.getIntent().getExtras();
      }
    }
  }
  
  private void Kh(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      l(paramString, this.mActivity);
    }
    ahlw.x("KEY_STAGE_2_TOTAL", false);
    a(this.mExtra, this.cZW, this.mShareAppId, false);
  }
  
  private void Kl(String paramString)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "showOtherErrorDialog ", paramString });
    this.b.post(new ForwardShareByServerHelper.5(this, paramString));
  }
  
  private void Km(String paramString)
  {
    if ((this.mActivity != null) && (!TextUtils.isEmpty(paramString))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        SessionInfo localSessionInfo = ForwardUtils.a(this.mActivity.getIntent());
        jof.a().aaQ = true;
        ujt.e(localQQAppInterface, this.mActivity, localSessionInfo, paramString);
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsg exception", paramString);
        return;
      }
    }
    QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsg null ");
  }
  
  private void O(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = this.mActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      anot.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    Q(paramInt, paramString1, paramString2);
    a(this.mExtra, this.cZW, this.mShareAppId, false);
  }
  
  public static aqju a(Activity paramActivity, aqju paramaqju, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, String paramString)
  {
    ahlw.report("KEY_STAGE_2_TOTAL");
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, " qbShowShareResultDialog error mActivity = null or finished");
      }
      paramActivity = null;
      return paramActivity;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getApplication().getString(2131720024);
    if (paramString != null) {}
    for (paramString = str + paramString;; paramString = str)
    {
      str = ((QQAppInterface)localObject).getApplication().getString(2131720030);
      localObject = ((QQAppInterface)localObject).getApplication().getString(2131720025);
      ahll localahll = new ahll(paramLong, paramInt, paramActivity);
      ahlm localahlm = new ahlm(paramLong, paramInt, paramActivity, paramBaseChatPie);
      paramBaseChatPie = paramaqju;
      if (paramaqju == null) {
        paramBaseChatPie = aqha.a(paramActivity, 232, null, str, paramString, (String)localObject, localahll, localahlm);
      }
      paramBaseChatPie.setNegativeButton(paramString, localahlm);
      paramBaseChatPie.setPositiveButton((String)localObject, localahll);
      try
      {
        paramBaseChatPie.show();
        return paramBaseChatPie;
      }
      catch (Throwable paramaqju)
      {
        paramActivity = paramBaseChatPie;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog: failed. ", paramaqju);
      return paramBaseChatPie;
    }
  }
  
  private AbsStructMsg a()
  {
    if (this.mActivity == null) {}
    Intent localIntent;
    do
    {
      return null;
      localIntent = this.mActivity.getIntent();
    } while (localIntent == null);
    return anre.a(localIntent.getByteArrayExtra("stuctmsg_bytes"));
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo)
  {
    return a(paramBundle, paramString1, paramString2, paramImageInfo, 0L);
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo, long paramLong)
  {
    int i = paramBundle.getInt("uintype");
    long l1 = paramBundle.getLong("req_share_id");
    int j = paramBundle.getInt("req_type");
    long l2 = ForwardUtils.parseLong(paramBundle.getString("uin"));
    String str4 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    String str2 = paramBundle.getString("detail_url");
    String str3 = paramBundle.getString("image_url_remote");
    Object localObject2 = paramBundle.getString("res_pkg_name");
    Object localObject1 = paramBundle.getString("share_comment_message");
    String str5 = paramBundle.getString("share_comment_message_for_server");
    boolean bool = ArkFullScreenAppActivity.t(paramBundle);
    paramBundle = paramBundle.getString("shareArkInfo");
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "buildcmd0xb77ReqBody picture_url =" + str3 + ", musicUrl=" + paramString2 + "\n, appId=" + l1 + ", reqType = " + j + ", uinType = " + i + ", uin =" + l2 + "\n, title = " + str4 + ", summary = " + str1 + ", url = " + str2 + "\n, mRemoteImgUrl = " + paramString1 + ", pkgName =" + (String)localObject2 + ", commentText = " + (String)localObject1 + ", commentTextExt =" + str5 + "\n, displayArkJson + " + bool + ", arkInfo = " + paramBundle + ", localUniSeq=" + paramLong);
    localObject1 = new oidb_cmd0xb77.ReqBody();
    ((oidb_cmd0xb77.ReqBody)localObject1).appid.set(l1);
    ((oidb_cmd0xb77.ReqBody)localObject1).app_type.set(1);
    ((oidb_cmd0xb77.ReqBody)localObject1).recv_uin.set(l2);
    if (i == 0)
    {
      ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(0);
      if (j != 1) {
        break label670;
      }
      label363:
      paramBundle = new oidb_cmd0xb77.ClientInfo();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramBundle.android_package_name.set((String)localObject2);
      }
      paramBundle.platform.set(1);
      localObject2 = z(BaseApplicationImpl.getContext(), (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramBundle.android_signature.set((String)localObject2);
      }
      paramBundle.sdk_version.set("0.0.0");
      ((oidb_cmd0xb77.ReqBody)localObject1).client_info.set(paramBundle);
      localObject2 = new oidb_cmd0xb77.RichMsgBody();
      if (paramImageInfo != null) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).image_info.set(paramImageInfo);
      }
      if (!TextUtils.isEmpty(str4)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).title.set(str4);
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramBundle = str1;
        if (str1.contains(acfp.m(2131706517))) {
          paramBundle = str1.replace(acfp.m(2131706544), "");
        }
        ((oidb_cmd0xb77.RichMsgBody)localObject2).summary.set(paramBundle);
      }
      if (!TextUtils.isEmpty(str2)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).url.set(str2);
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label737;
      }
      ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(paramString1);
    }
    for (;;)
    {
      if ((j == 2) && (!TextUtils.isEmpty(paramString2))) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).music_url.set(paramString2);
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).rich_msg_body.set((MessageMicro)localObject2);
      if (paramLong != 0L)
      {
        paramBundle = new oidb_cmd0xb77.ExtInfo();
        paramBundle.msg_seq.set(paramLong);
        ((oidb_cmd0xb77.ReqBody)localObject1).ext_info.set(paramBundle);
      }
      return localObject1;
      if (i == 1)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(1);
        break;
      }
      if (i != 3000) {
        break;
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(2);
      break;
      label670:
      if (j == 2)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(4);
        break label363;
      }
      if (j == 4)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(5);
        break label363;
      }
      if (j == 5)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(6);
        break label363;
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(0);
      break label363;
      label737:
      if (!TextUtils.isEmpty(str3)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(str3);
      } else {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "richMsgBody picture_url not set");
      }
    }
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    jqo.a((QQAppInterface)localObject1, "", "choose", paramLong, paramInt, "stay");
    arts.a().a(((QQAppInterface)localObject1).getAccount(), "", String.valueOf(paramLong), "1000", "52", "0", false, true);
    Object localObject2 = paramActivity.getIntent();
    Object localObject3 = "com.tencent.tauth.opensdk.SHARE_SUCCESS_AND_STAY_QQ_" + ((Intent)localObject2).getLongExtra("activity_finish_run_appId", 0L);
    localObject1 = ((Intent)localObject2).getStringExtra("res_pkg_name");
    localObject3 = new Intent((String)localObject3);
    localObject2 = (Uri)((Intent)localObject2).getParcelableExtra("activity_finish_run_uriData");
    ((Intent)localObject3).setPackage((String)localObject1);
    ((Intent)localObject3).putExtra("uriData", (Parcelable)localObject2);
    paramActivity.sendBroadcast((Intent)localObject3);
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    jqo.a(localQQAppInterface, "", "choose", paramLong, paramInt, "back");
    arts.a().a(localQQAppInterface.getAccount(), "", String.valueOf(paramLong), "1000", "51", "0", false, true);
    jqo.a(paramActivity, 0, "", "");
    if (paramBaseChatPie != null) {
      paramBaseChatPie.fV(1);
    }
    if (paramActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        paramBaseChatPie = (PendingIntent)paramActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramBaseChatPie != null) && (!paramActivity.getIntent().getBooleanExtra("share_from_aio", false))) {
          if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
          }
        }
        try
        {
          paramBaseChatPie.send();
          paramActivity.moveTaskToBack(true);
          return;
        }
        catch (PendingIntent.CanceledException paramBaseChatPie)
        {
          for (;;)
          {
            QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "failed to send PendingIntent", paramBaseChatPie);
          }
        }
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "qbShowShareResultDialog ", paramActivity);
      }
    }
  }
  
  private void a(akyf paramakyf, AbsStructMsg paramAbsStructMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new WeakReference(paramakyf);
    if ((this.mExtra == null) || (localQQAppInterface == null) || (this.mActivity == null))
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage error mExtra = " + this.mExtra + ", app=" + localQQAppInterface + ", mActivity =" + this.mActivity);
      return;
    }
    if (!aqiw.isNetSupport(this.mActivity))
    {
      Kl(acfp.m(2131706501));
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage net error");
      return;
    }
    paramakyf = this.mExtra.getString("uin");
    int i = this.mExtra.getInt("uintype");
    String str = this.mExtra.getString("troop_uin");
    this.mShareAppId = this.mExtra.getLong("req_share_id");
    if (paramAbsStructMsg == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage error structMsg = null ");
      return;
    }
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "requestShareMessage structMsg=" + paramAbsStructMsg.getXml());
    localObject = (akyf)((WeakReference)localObject).get();
    this.b.sendMessageDelayed(this.b.obtainMessage(93), 500L);
    ahlw.Kj("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, (AbsShareMsg)paramAbsStructMsg, paramakyf, i, str, (akyf)localObject);
  }
  
  public static void a(Activity paramActivity, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "sdk_share:sdk callback= appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
      if (paramActivity.getIntent() != null)
      {
        paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      try
      {
        paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString1);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, paramActivity.getMessage());
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  public static void a(Bundle paramBundle, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      anot.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "1", "", "", "");
    }
    if (paramBundle != null) {}
    for (;;)
    {
      int j;
      try
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        j = paramBundle.getInt("uintype");
        str2 = paramBundle.getString("uin");
        switch (j)
        {
        default: 
          aryb.a().b(0, "SHARE_TO_QQ", ((QQAppInterface)localObject).getCurrentAccountUin(), String.valueOf(paramLong), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
          if (paramInt != 1) {
            break label325;
          }
          paramBundle = "1";
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        String str2;
        label161:
        arts localarts;
        String str3;
        String str4;
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:", paramBundle);
        return;
      }
      localarts = arts.a();
      str3 = ((QQAppInterface)localObject).getAccount();
      str4 = paramLong + "";
      String str1;
      if (paramBoolean)
      {
        localObject = "0";
        localarts.a(str3, "", str4, "10", "12", (String)localObject, paramBundle, str2, str1, false, true);
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "shareToQQ success report:reportType=10,actType=12,result=0,type=", paramBundle, ",toType=", str1 });
        return;
      }
      localObject = "1";
      continue;
      int i = 1;
      continue;
      for (;;)
      {
        str1 = "1";
        if (j != 0) {
          break label355;
        }
        str1 = "1";
        break label161;
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        label325:
        if (paramInt == 2) {
          paramBundle = "3";
        } else if (paramInt == 5) {
          paramBundle = "2";
        } else {
          paramBundle = "4";
        }
      }
      label355:
      if (1 == j) {
        str1 = "2";
      } else if (3000 == j) {
        str1 = "3";
      }
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = a(paramBundle, paramString1, paramString2, null);
    a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, paramBundle, paramString1);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage send runtime = null ");
      Kl(bKK);
      return;
    }
    this.uy = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.uy);
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage sendOIDBRequest");
    ahlw.Kj("KEY_STAGE_2_NORMAL_B77");
    jnm.a(paramString2, new ahlq(this, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  static void a(OpenSdkShareModel paramOpenSdkShareModel, Bundle paramBundle, oidb_cmd0xb77.ReqBody paramReqBody)
  {
    if (paramOpenSdkShareModel != null)
    {
      paramBundle = new oidb_cmd0xb77.MiniAppMsgBody();
      paramBundle.mini_app_appid.set(Long.parseLong(paramOpenSdkShareModel.miniAppAppid));
      paramBundle.mini_app_path.set(paramOpenSdkShareModel.miniAppPath);
      paramBundle.web_page_url.set(paramOpenSdkShareModel.webPageUrl);
      paramBundle.title.set(paramOpenSdkShareModel.title);
      paramBundle.desc.set(paramOpenSdkShareModel.desc);
      paramBundle.json_str.set(paramOpenSdkShareModel.jsonStr);
      paramReqBody.mini_app_msg_body.set(paramBundle);
      paramReqBody.msg_style.set(10);
    }
    while (!ArkFullScreenAppActivity.t(paramBundle)) {
      return;
    }
    paramOpenSdkShareModel = paramBundle.getString("forward_ark_app_name");
    String str1 = paramBundle.getString("forward_ark_app_view");
    String str2 = paramBundle.getString("forward_ark_app_desc");
    String str3 = paramBundle.getString("forward_ark_app_ver");
    paramOpenSdkShareModel = new ArkAppMessage(paramBundle.getString("forward_ark_app_prompt"), paramOpenSdkShareModel, str2, str1, str3, paramBundle.getString("forward_ark_app_meta"), paramBundle.getString("forward_ark_app_config"), paramBundle.getString("forward_ark_app_compat"));
    paramBundle = new oidb_cmd0xb77.ArkJsonBody();
    paramBundle.json_str.set(paramOpenSdkShareModel.toAppXml());
    paramReqBody.ark_json_body.set(paramBundle);
    paramReqBody.msg_style.set(8);
  }
  
  public static boolean anP()
  {
    aeli localaeli = aelj.a();
    if (localaeli != null) {}
    for (boolean bool = localaeli.ahe();; bool = false)
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "isOpenedSDKShareImageByServer, shareImageByServer = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  private void cI(Bundle paramBundle)
  {
    String str = paramBundle.getString("app_name");
    paramBundle = anre.a(paramBundle);
    if ((paramBundle != null) && ((paramBundle instanceof AbsShareMsg))) {}
    for (paramBundle = (AbsShareMsg)paramBundle;; paramBundle = null)
    {
      this.jdField_a_of_type_Aqju = a(this.mActivity, this.jdField_a_of_type_Aqju, this.mBaseChatPie, paramBundle.mSourceAppid, paramBundle.mMsgServiceID, str);
      return;
    }
  }
  
  private void dou()
  {
    if (this.mBaseChatPie != null)
    {
      this.mActivity = this.mBaseChatPie.mActivity;
      if (this.mActivity != null) {
        this.mExtra = this.mActivity.getIntent().getExtras();
      }
    }
    this.chq = false;
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, " updateCurrentInfo mActivity = " + this.mActivity + ", mExtra=" + this.mExtra + ", mBaseChatPie =" + this.mBaseChatPie);
    }
  }
  
  private void dov()
  {
    String str;
    if (this.mExtra != null)
    {
      str = this.mExtra.getString("app_name");
      if (!this.mExtra.getBoolean("refuse_show_share_result_dialog", false))
      {
        localObject = anre.a(this.mExtra);
        if (!(localObject instanceof AbsShareMsg)) {
          break label97;
        }
      }
    }
    label97:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      this.jdField_a_of_type_Aqju = a(this.mActivity, this.jdField_a_of_type_Aqju, this.mBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      a(this.mExtra, this.cZW, this.mShareAppId, true);
      return;
    }
  }
  
  public static long gg()
  {
    aeli localaeli = aelj.a();
    if (localaeli == null) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration null == confBean");
    }
    long l;
    do
    {
      return 5000L;
      l = localaeli.fu();
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "getVerifyAppinfoTimeoutDuration, timeoutDuration = ", Long.valueOf(l) });
    } while (l == 0L);
    return l;
  }
  
  private void l(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "jumpToErrorWeb: invoked. info: jumpUrl = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "jumpToErrorWeb: Failed. info: exception = ", paramString);
    }
  }
  
  public static String lo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return acfp.m(2131720024) + str;
  }
  
  private void ts()
  {
    if (this.bi == null)
    {
      this.bi = new ahlp(this);
      this.mActivity.registerReceiver(this.bi, new IntentFilter("action_notify_aio_activity"));
    }
  }
  
  public static String z(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      paramString = MessageDigest.getInstance("MD5");
      paramString.update(paramContext[0].toByteArray());
      paramContext = aqhs.bytes2HexStr(paramString.digest());
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toLowerCase();
      paramString.reset();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public int[] C()
  {
    return new int[] { 6, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      }
      this.isFirstShow = true;
      return;
      onDestory();
    } while (!QLog.isColorLevel());
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState DESTROY =");
  }
  
  protected void Q(int paramInt, String paramString1, String paramString2)
  {
    ahlw.x("KEY_STAGE_2_TOTAL", false);
    if (this.au == null) {
      this.au = aqha.a(this.mActivity, 230);
    }
    this.au.setMessage(paramString1);
    paramString1 = new ahlo(this, paramInt, paramString2);
    this.au.setPositiveButton(2131721079, paramString1);
    this.au.show();
  }
  
  public void bNl()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "showWaitDialog");
    if (this.as == null)
    {
      this.as = new ReportDialog(this.mActivity, 2131756467);
      if (!this.mActivity.isFinishing())
      {
        this.as.setCancelable(false);
        this.as.setContentView(2131559761);
        ((TextView)this.as.findViewById(2131373180)).setText(2131696921);
        this.as.show();
      }
    }
    while (this.as.isShowing()) {
      return;
    }
    this.as.show();
  }
  
  public void dow()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "hideWaiteDialog");
    if ((this.as != null) && (this.as.isShowing()) && (!this.mActivity.isFinishing())) {
      this.b.post(new ForwardShareByServerHelper.4(this));
    }
  }
  
  public void dv(Intent paramIntent)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "forwardShare");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        break label307;
      }
    }
    label307:
    for (boolean bool = ((Bundle)localObject).getBoolean("share_send_msg_by_server", false);; bool = false)
    {
      this.cZW = paramIntent.getIntExtra("req_type", 2147483647);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare sendMsgByServer =", Boolean.valueOf(bool), ",mForwardSubType=", Integer.valueOf(this.cZW) });
      this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramIntent.getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
      if (bool)
      {
        localObject = a();
        String str1 = ForwardUtils.cz(this.mExtra.getInt("req_type"));
        String str2 = ForwardUtils.cx(this.mExtra.getInt("uintype"));
        if ((localObject instanceof AbsShareMsg))
        {
          paramIntent = ((AbsShareMsg)localObject).mContentTitle;
          anot.a(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, "", str1, str2, paramIntent);
          dou();
          a(this.jdField_a_of_type_Akyf, (AbsStructMsg)localObject);
        }
      }
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "forwardShare: intent.null ");
        return;
        paramIntent = "";
        break;
        paramIntent = paramIntent.getExtras();
      } while ((paramIntent == null) || (paramIntent.getBoolean("refuse_show_share_result_dialog", false)));
      localObject = paramIntent.getString("key_share_image_by_server");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        cI(paramIntent);
        return;
      }
      localObject = ahic.ln((String)localObject);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare errorMsg = ", localObject });
      if (localObject == null)
      {
        ts();
        return;
      }
      if (((String)localObject).length() == 0)
      {
        cI(paramIntent);
        return;
      }
      Kl((String)localObject);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if ((!this.chq) && (this.isFirstShow))
        {
          bNl();
          this.b.sendMessageDelayed(this.b.obtainMessage(94), 10000L);
          return true;
        }
      } while (!QLog.isColorLevel());
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "isRequestDone do not show dialog");
      return true;
    } while ((this.mActivity.isFinishing()) || (!this.isFirstShow));
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
    anot.a(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    this.isTimeOut = true;
    dow();
    Kl(acfp.m(2131706500));
    return true;
  }
  
  public void onDestory()
  {
    this.b.removeMessages(94);
    dow();
    if (this.jdField_a_of_type_Aqju != null) {
      this.jdField_a_of_type_Aqju.dismiss();
    }
    this.chq = false;
    this.isTimeOut = false;
    this.isFirstShow = false;
    this.uy = -1L;
    if (this.bi != null)
    {
      this.mActivity.unregisterReceiver(this.bi);
      this.bi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */