import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.4;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ahjz
  implements Handler.Callback, wvs
{
  private final DialogInterface.OnClickListener O = new ahkc(this);
  private Dialog ar;
  private aqju as;
  private MqqHandler b = new aurf(Looper.getMainLooper(), this);
  private BroadcastReceiver bi;
  private volatile boolean isFirstShow;
  private Activity mActivity;
  private BaseChatPie mBaseChatPie;
  private Bundle mExtra;
  private Intent mIntent;
  private long mShareAppId;
  
  public ahjz(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private int Fa()
  {
    return this.mIntent.getIntExtra("req_type", 2147483647);
  }
  
  private void Kh(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      l(paramString, this.mActivity);
    }
    ahlw.x("KEY_STAGE_2_TOTAL", false);
    ahlj.a(this.mExtra, Fa(), this.mShareAppId, false);
  }
  
  private void Ki(String paramString)
  {
    if (this.bi == null)
    {
      this.bi = new ahkb(this, paramString);
      this.mActivity.registerReceiver(this.bi, new IntentFilter("action_notify_aio_activity_by_b77"));
    }
  }
  
  private void O(int paramInt, String paramString1, String paramString2)
  {
    ahlw.x("KEY_STAGE_2_TOTAL", false);
    ahlj.a(this.mExtra, Fa(), this.mShareAppId, false);
    if ((this.mExtra != null) && (this.mExtra.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      anot.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    ahhj.a(this.mActivity, paramString1, new ahka(this, paramInt, paramString2));
  }
  
  public static void a(Activity paramActivity, wvm paramwvm)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "doSdkShare");
    if (TextUtils.isEmpty(paramActivity.getIntent().getStringExtra("key_b77_sdk_share")))
    {
      paramwvm = (ahlj)paramwvm.a(13);
      if (paramwvm != null) {
        paramwvm.dv(paramActivity.getIntent());
      }
    }
    do
    {
      return;
      paramActivity = (ahjz)paramwvm.a(57);
    } while (paramActivity == null);
    paramActivity.dot();
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp, Context paramContext)
  {
    String str = paramMessageForArkApp.getExtInfoFromExtStr(anbb.cdf);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", str, ", uinseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    int i = ForwardUtils.parseInt(str);
    if ((i == 0) || (i == 25201) || (i == -2)) {
      return false;
    }
    str = paramMessageForArkApp.getExtInfoFromExtStr(anbb.cdh);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "resendSdkFakeMsg fakeShareInfo empty");
      return false;
    }
    ahkd localahkd = new ahkd();
    try
    {
      localahkd.a(paramMessageForArkApp, paramContext, new JSONObject(str));
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "Exception", paramMessageForArkApp);
    }
    return false;
  }
  
  private void ak(Map<String, Object> paramMap)
  {
    Integer localInteger1 = (Integer)paramMap.get("key_b77_error_code");
    Integer localInteger2 = (Integer)paramMap.get("key_b77_jump_result");
    String str1 = (String)paramMap.get("key_b77_jump_url");
    String str2 = (String)paramMap.get("key_b77_wording");
    paramMap = (String)paramMap.get("key_b77_develop_msg");
    if ((localInteger1 != null) && (localInteger1.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "errorCode=", localInteger1 });
      O(localInteger1.intValue(), str2, paramMap);
      return;
    }
    if ((localInteger2 != null) && (localInteger2.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpResult=", localInteger2 });
      Kh(str1);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "handleSendSuccess");
    dov();
  }
  
  private void bNl()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog");
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
    }
    do
    {
      return;
      if (this.ar == null) {
        break;
      }
    } while (this.ar.isShowing());
    this.ar.show();
    return;
    this.ar = new ReportDialog(this.mActivity, 2131756467);
    this.ar.setCancelable(false);
    this.ar.setContentView(2131559761);
    ((TextView)this.ar.findViewById(2131373180)).setText(2131696921);
    this.ar.show();
  }
  
  public static boolean d(MessageForArkApp paramMessageForArkApp)
  {
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(anbb.cdf);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", paramMessageForArkApp });
    return 25201 == ForwardUtils.parseInt(paramMessageForArkApp);
  }
  
  private void dot()
  {
    dou();
    String str = this.mIntent.getStringExtra("key_b77_sdk_share");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
      return;
    }
    this.mIntent.removeExtra("key_b77_sdk_share");
    Map localMap = ((ahlc)this.mBaseChatPie.app.getManager(350)).r(str);
    if (localMap == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "initBroadcastReceiver");
      Ki(str);
      this.b.sendMessageDelayed(this.b.obtainMessage(93), 500L);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
    ak(localMap);
  }
  
  private void dou()
  {
    if (this.mBaseChatPie != null)
    {
      this.mActivity = this.mBaseChatPie.mActivity;
      this.mIntent = this.mActivity.getIntent();
      this.mExtra = this.mIntent.getExtras();
      if (this.mExtra != null) {
        this.mShareAppId = this.mExtra.getLong("req_share_id");
      }
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { " updateCurrentInfo mExtra=", this.mExtra, ", mShareAppId=", Long.valueOf(this.mShareAppId) });
  }
  
  private void dov()
  {
    if (this.mExtra != null)
    {
      String str = this.mExtra.getString("app_name");
      Object localObject = anre.a(this.mExtra);
      if ((localObject instanceof AbsShareMsg))
      {
        localObject = (AbsShareMsg)localObject;
        this.as = ahlj.a(this.mActivity, this.as, this.mBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      }
    }
    ahlj.a(this.mExtra, Fa(), this.mShareAppId, true);
  }
  
  private void dow()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "hideWaiteDialog");
    if ((this.ar != null) && (this.ar.isShowing()) && (!this.mActivity.isFinishing())) {
      this.b.post(new ForwardSDKB77AIOHelper.4(this));
    }
  }
  
  private void l(String paramString, Context paramContext)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpToErrorWeb: invoked. info: jumpUrl = ", paramString });
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
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "jumpToErrorWeb: Failed. info: exception = ", paramString);
    }
  }
  
  private void onDestroy()
  {
    this.b.removeMessages(94);
    this.b.removeMessages(93);
    dow();
    if (this.as != null) {
      this.as.dismiss();
    }
    this.isFirstShow = false;
    if (this.bi != null)
    {
      this.mActivity.unregisterReceiver(this.bi);
      this.bi = null;
    }
  }
  
  public int[] C()
  {
    return new int[] { 6, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
      this.isFirstShow = true;
      return;
    }
    onDestroy();
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return true;
      } while (!this.isFirstShow);
      bNl();
      this.b.sendMessageDelayed(this.b.obtainMessage(94), 10000L);
      return true;
      if ((this.mActivity == null) || (this.mActivity.isFinishing()) || (!this.isFirstShow))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
        return true;
      }
      anot.a(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
      dow();
      ahhj.a(this.mActivity, acfp.m(2131706500), this.O);
      Object localObject = this.mExtra.getString("fake_friend_uin", "");
      int i = this.mExtra.getInt("fake_is_troop", 0);
      long l = this.mExtra.getLong("fake_uinseq", 0L);
      paramMessage = ((BaseActivity)this.mActivity).app;
      localMessageRecord = paramMessage.b().b((String)localObject, i, l);
      localObject = new StringBuilder().append("msg_sdk_share_request_timeout_status friendUin=").append(artw.qx((String)localObject)).append(", isTroop=").append(i).append(", uinseq=").append(l).append("fakeRecord == null : ");
      if (localMessageRecord == null) {
        bool = true;
      }
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, bool);
    } while (!(localMessageRecord instanceof MessageForArkApp));
    ahiy.a(paramMessage, (MessageForArkApp)localMessageRecord, -8, acfp.m(2131706500));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjz
 * JD-Core Version:    0.7.0.1
 */