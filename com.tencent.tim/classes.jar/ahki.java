import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption.10;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption.8;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption.9;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;

public abstract class ahki
  extends ahgq
  implements artv
{
  protected static final Object dZ = new Object();
  ahki.a jdField_a_of_type_Ahki$a = new ahki.a(this);
  protected ahki.b a;
  private HandlerPlus jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(Looper.getMainLooper(), this.f);
  protected String aMl;
  public boolean aRg;
  protected long aaE;
  protected String apc;
  public ahgf b;
  protected Handler bJ;
  protected String bKL = "";
  protected swh c;
  @SuppressLint({"HandlerLeak"})
  private Handler cS = new ahkp(this);
  public int cZW;
  protected boolean chj;
  protected boolean chk;
  protected boolean chl;
  public boolean chm;
  volatile boolean chn = false;
  public AbsShareMsg d;
  protected BusinessObserver e;
  private Handler.Callback f = new ahkj(this);
  public String fT;
  public long mShareAppId;
  
  public ahki(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_e_of_type_MqqObserverBusinessObserver = new ahkm(this);
  }
  
  private void Kj(String paramString)
  {
    if (this.isSdkShare) {
      ahlw.Kj(paramString);
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "sdk_share:sdk callback=", Boolean.valueOf(paramBoolean), " appid=", Long.valueOf(paramLong), " action=", paramString });
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
        if (paramActivity.getIntent() != null)
        {
          String str = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString = str;
          if (!TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        paramString = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
        if (paramActivity.getIntent() != null)
        {
          paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString2)) {}
        }
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
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString1 })));
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
  
  private void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.isSdkShare) {
      ahlw.a(paramString, paramBundle, paramBoolean);
    }
  }
  
  private boolean anI()
  {
    if ((!this.isSdkShare) || (!this.chn) || (this.jdField_b_of_type_Ahgf == null)) {}
    do
    {
      return false;
      str = this.bf.getString("image_url");
      localObject = this.bf.getString("image_url_remote");
    } while ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)));
    String str = this.jdField_b_of_type_Ahgf.wl();
    this.bf.putString("image_url_remote", str);
    if (this.d != null)
    {
      this.d.updateCover(str);
      this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(2);
    }
    QLog.i("ForwardSdkBaseOption", 1, "checkAndUseAppIcon|use app icon:" + str);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "18");
    if (TextUtils.isEmpty(str)) {}
    for (str = "1";; str = "0")
    {
      ((Bundle)localObject).putString("intext_1", str);
      arts.a().a((Bundle)localObject, "" + this.appid, this.app.getCurrentUin(), false, this.isSdkShare);
      return true;
    }
  }
  
  private boolean anJ()
  {
    String str = this.bf.getString("image_url");
    int i = this.bf.getInt("req_type");
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image shareType:", Integer.valueOf(i) });
    if ((i == 5) && (!TextUtils.isEmpty(str)) && (!str.startsWith("http://")) && (!str.startsWith("https://")))
    {
      boolean bool = ForwardUtils.aL(this.mAppContext);
      Object localObject = this.mAppContext.getExternalFilesDir(null);
      if (localObject != null) {}
      for (localObject = ((File)localObject).getAbsolutePath();; localObject = "")
      {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image hasSDPermission:", Boolean.valueOf(bool), ", localImageUrl:", str, ",appSpecificPath=", localObject });
        if ((bool) || (TextUtils.isEmpty((CharSequence)localObject)) || (str.contains((CharSequence)localObject)) || (this.mActivity == null) || (this.mActivity.isFinishing())) {
          break;
        }
        localObject = new ahkl(this);
        aqha.a(this.mActivity, 233, acfp.m(2131721103), acfp.m(2131720162), -1, 2131720161, (DialogInterface.OnClickListener)localObject, null).show();
        return true;
      }
    }
    return false;
  }
  
  public static final void b(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    long l = 0L;
    if ((paramActivity == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = paramIntent.getBundleExtra("share_data");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramIntent.getExtras();
      }
      paramIntent = "shareToQzone";
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getString("share_action");
        paramIntent = (Intent)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramIntent = "shareToQzone";
        }
      }
      if (localObject1 != null) {
        l = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + l + " action=" + "shareToQzone");
      }
      localObject2 = new Intent();
      if (paramBoolean)
      {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), paramIntent })));
        avpw.ay((Intent)localObject2);
        if (localObject1 == null) {}
      }
      try
      {
        ((Intent)localObject2).setPackage(((Bundle)localObject1).getString("pkg_name"));
        try
        {
          paramActivity.startActivity((Intent)localObject2);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity, new Object[0]);
        return;
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l), paramIntent })));
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ((Intent)localObject2).setPackage(null);
        }
      }
    }
  }
  
  private void doB()
  {
    try
    {
      aryb.a().b(0, "SHARE_TO_QQ", this.app.getCurrentAccountUin(), String.valueOf(this.mShareAppId), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int Fb()
  {
    if (this.d != null) {
      return this.d.mMsgServiceID;
    }
    return 0;
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (paramInt >= 0) {
      this.bf.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null) {
      this.bf.putAll(paramBundle);
    }
    if (this.mActivity.isFinishing()) {}
    do
    {
      return;
      if (!anJ())
      {
        super.H(paramInt, paramBundle);
        if (paramInt == X.intValue()) {
          this.jdField_e_of_type_Aqju.setEditLint("");
        }
      }
    } while (paramBundle == null);
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "81");
    localBundle.putString("intext_1", "" + artv.b.kK(this.cZW));
    localBundle.putString("intext_2", "" + artv.b.u(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    arts.a().a(localBundle, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
  }
  
  protected void P(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.mActivity.setResult(-1, localIntent);
    if ((this.mActivity instanceof SplashActivity)) {
      hideProgressDialog();
    }
    while (anq()) {
      return;
    }
    this.mActivity.finish();
  }
  
  public boolean anK()
  {
    return true;
  }
  
  public boolean anj()
  {
    super.anj();
    this.bKL = "";
    this.chj = "login".equals(this.mIntent.getStringExtra("jfrom"));
    long l1 = this.bf.getLong("req_share_id");
    if ((TextUtils.isEmpty(this.mIntent.getStringExtra("pkg_name"))) && (!"1103584836".equals(String.valueOf(this.bf.getLong("req_share_id")))) && (!"101735437".equals(String.valueOf(this.bf.getLong("req_share_id"))))) {
      this.bf.putLong("req_share_id", 65520L);
    }
    this.mShareAppId = this.bf.getLong("req_share_id");
    this.aMl = this.mIntent.getStringExtra("open_id");
    this.apc = this.mIntent.getStringExtra("share_uin");
    this.cZW = this.mIntent.getIntExtra("req_type", 2147483647);
    String str2 = this.bf.getString("detail_url");
    String str1 = this.bf.getString("image_url");
    Object localObject2 = this.bf.getString("image_url_remote");
    long l2 = ForwardUtils.parseLong(this.bf.getString("chSrc"));
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "preloadData subType=", Integer.valueOf(this.cZW), ",targetUrl=", str2, ",remoteImg=", localObject2, ",localImg=", str1 });
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!jqc.isValidUrl((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((String)localObject2).startsWith("//")) {
          continue;
        }
        localObject1 = localObject2;
        str2 = new URL(str2).getProtocol();
        localObject1 = localObject2;
        localObject2 = str2 + ":" + (String)localObject2;
        localObject1 = localObject2;
        this.bf.putString("image_url_remote", (String)localObject2);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        continue;
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "repair invalid img url=", localObject1 });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "80");
      ((Bundle)localObject2).putString("intext_1", "" + artv.b.kK(this.cZW));
      ((Bundle)localObject2).putString("intext_3", "0");
      arts.a().a((Bundle)localObject2, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
      if ((this.cZW == 5) && (TextUtils.isEmpty(str1)) && (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
        }
        P(-1, acfp.m(2131706508), acfp.m(2131706520));
      }
      try
      {
        aryb.a().b(1, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.mShareAppId), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
        return false;
        localObject1 = null;
        continue;
        if (((ahlc)this.app.getManager(350)).a().anC())
        {
          x("KEY_STAGE_1_TOTAL", true);
          QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->preloadData-- null != mAppInfo");
          return true;
        }
        if ((l1 > 0L) && (!"101735437".equals(String.valueOf(l1))))
        {
          this.aaE = System.currentTimeMillis();
          this.chl = true;
          long l3 = System.currentTimeMillis() / 1000L;
          localObject2 = this.bf.getString("pkg_name");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = "";
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->sdk_share, getting appinfo in construct. sign: ", localObject1 });
            if (!(this instanceof ahkr))
            {
              am(2131719010);
              this.jdField_a_of_type_Arhz.setCancelable(false);
            }
            long l4 = ahlj.gg();
            Kj("KEY_GET_APP_INFO");
            svi.a(this.app, this.mAppContext, this.app.getCurrentAccountUin(), l1, (String)localObject1, l2, l3, this.jdField_e_of_type_MqqObserverBusinessObserver, (String)localObject2, l4, true);
            return true;
          }
          localObject1 = AgentActivity.q(this.mAppContext, (String)localObject2, l3 + "");
          continue;
        }
        if (!(this instanceof ahkr)) {
          continue;
        }
        ck("", false);
      }
      catch (Exception localException) {}
    }
  }
  
  public void b(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "52");
    ((Bundle)localObject).putString("intext_3", "0");
    ((Bundle)localObject).putString("stringext_1", paramString1);
    arts.a().a((Bundle)localObject, "", paramString2, false, this.isSdkShare);
    ahlw.Kj("batch_url_exchange");
    paramHashMap = jqc.a(BaseApplication.getContext(), paramString2, this.fT, 1, paramHashMap, localBundle);
    localObject = new HashMap();
    ((HashMap)localObject).put("param_ret_code", Integer.toString(localBundle.getInt("retcode", -1)));
    ahlw.a("batch_url_exchange", paramString2, (HashMap)localObject, localBundle.getBoolean("isSuccess"));
    l = System.currentTimeMillis() - l;
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (((String)paramHashMap.get(paramHashMap.keySet().iterator().next())).contains("url.cn"))) {}
    for (int i = 0;; i = 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = "batchUrlExchange for IMAGE_SHARE, isFailed = " + i + ", cost = " + l;
        if ((i != 1) && (l <= 3000L)) {
          break label607;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject);
      }
      for (;;)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "12");
        ((Bundle)localObject).putString("intext_3", "0");
        ((Bundle)localObject).putString("intext_1", "" + i);
        ((Bundle)localObject).putString("intext_2", "" + localBundle.getInt("retcode", 0));
        ((Bundle)localObject).putString("intext_5", "" + l);
        if (i == 1) {
          ((Bundle)localObject).putString("stringext_1", paramString1);
        }
        arts.a().a((Bundle)localObject, "", paramString2, false, this.isSdkShare);
        if (paramHashMap != null)
        {
          if (paramHashMap.containsKey("imageUrl"))
          {
            this.bf.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
            this.bf.remove("image_url");
          }
          if (paramHashMap.containsKey("audioUrl")) {
            this.bf.putString("audio_url", (String)paramHashMap.get("audioUrl"));
          }
          if (paramHashMap.containsKey("targetUrl")) {
            this.bf.putString("detail_url", (String)paramHashMap.get("targetUrl"));
          }
          if (paramHashMap.containsKey("sourceUrl")) {
            this.bf.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
          }
          if (paramHashMap.containsKey("sourceIcon")) {
            this.bf.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
          }
        }
        this.mActivity.runOnUiThread(new ForwardSdkBaseOption.10(this));
        return;
        label607:
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject);
      }
    }
  }
  
  protected void ck(String paramString, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive show forbidden dialog");
    String str = this.bf.getString("app_name");
    aqju localaqju = aqha.b(this.mActivity, 230);
    localaqju.setTitle(this.mActivity.getString(2131720160));
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.mActivity.getString(2131720163);
      }
      localaqju.setMessageWithUrl((String)localObject);
    }
    for (;;)
    {
      localObject = localaqju.setPositiveButton(2131720025, new ahko(this));
      StringBuilder localStringBuilder = new StringBuilder().append(this.mActivity.getString(2131691039));
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = "";
      }
      ((aqju)localObject).setNegativeButton(paramString, new ahkn(this));
      localaqju.setCancelable(false);
      localaqju.show();
      return;
      localaqju.setMessage(2131720163);
    }
  }
  
  protected void dnK()
  {
    if (this.chk) {
      a(this.mActivity, true, "shareToQQ", this.mShareAppId);
    }
    for (;;)
    {
      this.mActivity.setResult(1);
      this.mActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
      }
      return;
      a(this.mActivity, false, "shareToQQ", this.mShareAppId);
    }
  }
  
  protected void dnL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
    }
    doA();
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "82");
    localBundle.putString("intext_1", "" + artv.b.kK(this.cZW));
    localBundle.putString("intext_2", "" + artv.b.u(this.bf.getInt("uintype"), this.bf.getString("uin")));
    localBundle.putString("intext_3", "0");
    arts.a().a(localBundle, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
  }
  
  void doA()
  {
    if ((this.jdField_e_of_type_Aqju != null) && (this.jdField_e_of_type_Aqju.isShowing())) {
      this.jdField_e_of_type_Aqju.dismiss();
    }
    if ((this.jdField_b_of_type_Swh != null) && (this.jdField_b_of_type_Swh.isShowing())) {
      this.jdField_b_of_type_Swh.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "asyncUploadImageAndSendToBuddy mForwardSubType=" + this.cZW);
    }
    if (this.bKL != null) {
      this.bf.putString("share_comment_message", this.bKL);
    }
    if (this.cZW != 5)
    {
      String str = this.bf.getString("detail_url");
      if (!anqx.pE(str))
      {
        doC();
        return;
      }
      am(2131693321);
      ThreadManager.post(new ForwardSdkBaseOption.8(this, str), 8, null, false);
      return;
    }
    am(2131693321);
    gd("ForwardOption.ForwardSdkBaseOption", "ThreadManager.post asyncUploadImageAndSendToBuddy");
    ThreadManager.post(f(), 8, null, false);
  }
  
  public void doC()
  {
    if (this.mActivity.isFinishing())
    {
      QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg mActivity.isFinishing()");
      dol();
    }
    Object localObject2;
    label286:
    do
    {
      return;
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "realSendStructMsg, mForwardSubType = ", Integer.valueOf(this.cZW) });
      hideProgressDialog();
      if (this.mIntent.getIntExtra("forward_type", -1) != 2) {
        break;
      }
      localObject1 = anre.a(this.bf);
      ((AbsStructMsg)localObject1).forwardID = this.bf.getInt("KEY_MSG_FORWARD_ID", 0);
      if (anq())
      {
        localObject2 = this.bf.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject1, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).QD);
        }
      }
      localObject2 = this.bf.getString("uin");
      i = this.bf.getInt("uintype");
      Object localObject3 = this.bf.getString("troop_uin");
      AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject1, (String)localObject2, i, (String)localObject3);
      localObject2 = this.bf.getString("uin");
      i = this.bf.getInt("uintype");
      this.bf.getString("troop_uin");
      anpc.a(BaseApplication.getContext()).a(this.app, "sha_share2qq", 1, "", "", String.valueOf(this.mShareAppId));
      if (this.cZW != 5) {
        break label653;
      }
      localObject1 = "connect_sharepic";
      jqo.a(this.app, (String)localObject2, (String)localObject1, "send", this.mShareAppId, Fb(), String.valueOf(i));
      P(0, "", "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "83");
      ((Bundle)localObject1).putString("intext_1", "" + artv.b.kK(this.cZW));
      ((Bundle)localObject1).putString("intext_2", "" + artv.b.u(i, (String)localObject2));
      ((Bundle)localObject1).putString("intext_3", "0");
      arts.a().a((Bundle)localObject1, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
      localObject1 = this.bf.getString("detail_url");
    } while ((!this.isSdkShare) || (TextUtils.isEmpty((CharSequence)localObject1)));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "55");
    if (this.jdField_b_of_type_Ahgf == null) {}
    for (int i = 0;; i = this.jdField_b_of_type_Ahgf.ER())
    {
      ((Bundle)localObject1).putString("intext_1", "" + i);
      ((Bundle)localObject1).putString("app_id", "" + this.mShareAppId);
      arts.a().a((Bundle)localObject1, "", this.app.getCurrentAccountUin(), false, this.isSdkShare);
      return;
      localObject1 = new Intent(this.mActivity, MessageShareActivity.class);
      localObject2 = new Bundle(this.bf);
      if ((this.mActivity instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.mActivity).setTitle(null);
      }
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setFlags(67108864);
      this.mActivity.startActivity((Intent)localObject1);
      break;
      label653:
      localObject1 = "connect_share2qq";
      break label286;
    }
  }
  
  public void dol() {}
  
  protected void dox()
  {
    if (this.jdField_b_of_type_Ahgf.ani())
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Ahgf.wk())) {
        this.bf.putString("struct_share_key_source_icon", this.jdField_b_of_type_Ahgf.wk());
      }
      String str = this.jdField_b_of_type_Ahgf.wl();
      if (!TextUtils.isEmpty(str)) {
        this.bf.putString("struct_share_key_source_icon_big", str);
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_Ahgf.getSourceUrl())) && (this.mShareAppId != Long.parseLong("1103584836"))) {
        this.bf.putString("struct_share_key_source_url", this.jdField_b_of_type_Ahgf.getSourceUrl());
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Ahgf.getAppName())) {
        this.bf.putString("struct_share_key_source_name", this.jdField_b_of_type_Ahgf.getAppName());
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Ahgf.getPkgName())) {
        this.bf.putString("struct_share_key_source_a_action_data", this.jdField_b_of_type_Ahgf.getPkgName());
      }
      if (this.d != null)
      {
        this.d.mSourceIcon = this.bf.getString("struct_share_key_source_icon");
        this.d.mSourceName = this.bf.getString("struct_share_key_source_name");
        if (TextUtils.isEmpty(this.d.mSourceName)) {
          this.d.mSourceName = this.bf.getString("app_name");
        }
      }
      this.bf.putByte("struct_share_key_app_info_status", (byte)1);
      anI();
    }
  }
  
  protected void doy()
  {
    Object localObject2 = this.bf.getString("title");
    Object localObject3 = this.bf.getString("desc");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("...")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("..."));
      }
    }
    localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (jqn.j((String)localObject1, "UTF-8") > 80) {
      localObject3 = jqn.a((String)localObject1, 80, "UTF-8", null);
    }
    localObject1 = localObject2;
    if (jqn.j((String)localObject2, "UTF-8") > 130) {
      localObject1 = jqn.a((String)localObject2, 130, "UTF-8", null);
    }
    if ((localObject3 != null) && (!((String)localObject3).endsWith("...")) && (!((String)localObject3).equals(this.bf.getString("title")))) {}
    for (localObject2 = (String)localObject3 + "...";; localObject2 = localObject3)
    {
      if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.bf.getString("desc")))) {
        localObject1 = (String)localObject1 + "...";
      }
      for (;;)
      {
        this.bf.putString("title", (String)localObject2);
        this.bf.putString("desc", (String)localObject1);
        return;
      }
    }
  }
  
  public final void doz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "-->getQQAccountSKey--send g_t_n_p, account = ", this.app.getAccount() });
    }
    if (this.isSdkShare)
    {
      String str = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        this.fT = str;
        this.chm = true;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->getQQAccountSKey--use TicketManager cache, account = ", this.app.getAccount() });
        return;
      }
    }
    Kj("KEY_SSO_GET_TICKET_NO_PASSWD");
    this.app.ssoGetTicketNoPasswd(this.app.getCurrentAccountUin(), 4096, this.jdField_a_of_type_Ahki$a);
  }
  
  protected Runnable f()
  {
    return new ForwardSdkBaseOption.9(this);
  }
  
  public void gd(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void ij(int paramInt1, int paramInt2)
  {
    if ((this.jdField_e_of_type_Aqju != null) && (this.jdField_e_of_type_Aqju.isShowing())) {
      this.jdField_e_of_type_Aqju.dismiss();
    }
    hideProgressDialog();
    if ((paramInt2 == V.intValue()) && (paramInt1 == 0)) {
      this.chk = true;
    }
    if (this.jdField_b_of_type_Swh == null)
    {
      this.jdField_b_of_type_Swh = new swh(this.mActivity);
      this.jdField_b_of_type_Swh.a(new ahkk(this));
    }
    for (;;)
    {
      String str = this.mActivity.getString(2131691039);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.bf.getString("app_name"))) {
        localObject = str + this.bf.getString("app_name");
      }
      this.jdField_b_of_type_Swh.c((String)localObject, d());
      this.jdField_b_of_type_Swh.yT(2131693313);
      localObject = this.jdField_b_of_type_Swh;
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        label181:
        ((swh)localObject).setResult(bool);
        if (paramInt1 != 0) {
          break label227;
        }
        doB();
        this.jdField_b_of_type_Swh.d(null, null);
      }
      try
      {
        this.jdField_b_of_type_Swh.show();
        return;
        this.jdField_b_of_type_Swh.dismiss();
        continue;
        bool = false;
        break label181;
        label227:
        if (paramInt1 == 1002) {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!upload image fail---------------------------------");
          }
        }
        for (;;)
        {
          this.jdField_b_of_type_Swh.d(this.mActivity.getString(2131718840), d());
          break;
          if (paramInt1 == 1003) {
            this.jdField_b_of_type_Swh.yT(2131693316);
          } else if (paramInt1 == 1004)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!skey not ready fail---------------------------------");
            }
          }
          else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!vkey not ready fail---------------------------------");
          }
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "resultDlg.show() failed");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_b_of_type_Swh != null) && (this.jdField_b_of_type_Swh.isShowing())) {
      this.jdField_b_of_type_Swh.dismiss();
    }
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    if (this.bJ != null) {
      this.bJ.removeCallbacksAndMessages(null);
    }
    if (this.cS != null)
    {
      this.cS.removeMessages(0);
      this.cS = null;
    }
  }
  
  protected void x(String paramString, boolean paramBoolean)
  {
    if (this.isSdkShare) {
      ahlw.x(paramString, paramBoolean);
    }
  }
  
  static class a
    extends SSOAccountObserver
  {
    WeakReference<ahki> gX;
    
    public a(ahki paramahki)
    {
      this.gX = new WeakReference(paramahki);
    }
    
    public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      QLog.d("ForwardSdkBaseOption", 1, new Object[] { "-->onFailed--account = ", paramString, ", ret = ", Integer.valueOf(paramInt2) });
      paramString = (ahki)this.gX.get();
      if (paramString != null) {
        ahki.a(paramString, "KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
      }
      if ((paramString != null) && (!paramString.chm) && (ahki.a(paramString) != null)) {
        ahki.a(paramString).sendEmptyMessage(0);
      }
    }
    
    public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
    {
      QLog.d("ForwardSdkBaseOption", 1, new Object[] { "-->onGetTicketNoPasswd--recv g_t_n_p, account = ", paramString });
      if (paramInt == 4096) {}
      for (paramString = new String(paramArrayOfByte);; paramString = null)
      {
        paramArrayOfByte = (ahki)this.gX.get();
        if (paramArrayOfByte != null)
        {
          ahki.a(paramArrayOfByte, "KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
          paramArrayOfByte.fT = paramString;
          paramArrayOfByte.chm = true;
        }
        return;
      }
    }
  }
  
  class b
  {
    View contentView;
    Context context;
    HashMap<anqu, View> lc = new HashMap(1);
    
    b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private boolean h(AbsStructMsg paramAbsStructMsg)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int i;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
        bool1 = bool2;
        if (paramAbsStructMsg != null) {
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < paramAbsStructMsg.size())
        {
          anqu localanqu = (anqu)paramAbsStructMsg.get(i);
          if (!(localanqu instanceof antd)) {
            break label95;
          }
          paramAbsStructMsg = (antd)localanqu;
          bool1 = bool2;
          if (paramAbsStructMsg.dMi != 1)
          {
            bool1 = bool2;
            if (paramAbsStructMsg.dMi != 3) {
              bool1 = true;
            }
          }
        }
        return bool1;
        label95:
        i += 1;
      }
    }
    
    View ce()
    {
      if ((ahki.this.d instanceof StructMsgForImageShare)) {
        return ahki.this.d.getPreDialogView(this.context, null);
      }
      if ((ahki.this.d instanceof StructMsgForAudioShare)) {
        this.contentView = ahki.this.d.getPreDialogView(this.context, this.contentView);
      }
      do
      {
        return this.contentView;
        localObject1 = new HeightLimitedLinearLayout(this.context);
        ((HeightLimitedLinearLayout)localObject1).setOrientation(1);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 1;
        ((HeightLimitedLinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((HeightLimitedLinearLayout)localObject1).setMaxHeight(this.context.getResources().getDisplayMetrics().heightPixels >> 1);
        this.contentView = ((View)localObject1);
        doD();
      } while ((!h(ahki.this.d)) || (ahki.this.d.mMsgUrl == null) || ((ahki.this instanceof ahjt)));
      ahki.this.cZS = 8;
      Object localObject1 = new FrameLayout(this.context);
      Object localObject2 = new View(ahki.this.mActivity);
      ((View)localObject2).setBackgroundResource(2130840508);
      ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, aqnm.dip2px(33.0F), 16));
      ((View)localObject2).setOnClickListener(new ahkq(this));
      ((View)localObject2).setContentDescription(acfp.m(2131706534));
      localObject2 = new FrameLayout.LayoutParams(-1, -2, 16);
      ((FrameLayout.LayoutParams)localObject2).rightMargin = aqnm.dip2px(16.0F);
      ((FrameLayout)localObject1).addView(this.contentView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new ImageView(ahki.this.mActivity);
      ((ImageView)localObject2).setImageResource(2130840498);
      ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F), 21));
      return localObject1;
    }
    
    void doD()
    {
      if ((ahki.this.d == null) || (this.contentView == null)) {}
      label326:
      label327:
      for (;;)
      {
        return;
        if ((ahki.this.d instanceof StructMsgForImageShare))
        {
          QLog.w("ForwardOption.ForwardSdkBaseOption", 1, "updateStructView|StructMsgForImageShare not supported！");
          return;
        }
        if ((ahki.this.d instanceof StructMsgForAudioShare))
        {
          ahki.this.d.getPreDialogView(this.context, this.contentView);
          return;
        }
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("pre_dialog", true);
        Object localObject2 = new ArrayList(1);
        Iterator localIterator = ahki.this.d.getStructMsgItemLists().iterator();
        int i = 0;
        label116:
        if (localIterator.hasNext())
        {
          anqu localanqu = (anqu)localIterator.next();
          View localView1 = (View)this.lc.get(localanqu);
          View localView2 = localanqu.a(this.context, localView1, (Bundle)localObject1);
          if ((localView2 != null) && ((localanqu instanceof antd)))
          {
            TextView localTextView = (TextView)localView2.findViewById(2131380976);
            if (localTextView != null)
            {
              localTextView.setGravity(16);
              localTextView.setMaxLines(2);
              localTextView.setTextSize(14.0F);
              localTextView.setTextColor(this.context.getResources().getColor(2131165827));
            }
          }
          if ((localView2 == null) || (localView2 == localView1)) {
            break label326;
          }
          this.lc.put(localanqu, localView2);
          ((List)localObject2).add(localView2);
          i = 1;
        }
        for (;;)
        {
          break label116;
          if (i == 0) {
            break label327;
          }
          ((ViewGroup)this.contentView).removeAllViewsInLayout();
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (View)((Iterator)localObject1).next();
            ((ViewGroup)this.contentView).addView((View)localObject2);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */