package com.tencent.mobileqq.activity;

import accy;
import acfp;
import ajry;
import akwp;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import anot;
import anxr;
import aqha;
import aqjb;
import aqju;
import aqmj;
import aqvk;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;
import vif;
import vig;
import vih;
import vii;
import vij;
import vik;
import vil;
import vim;
import vin;
import vio;
import vip;
import viq;
import vir;
import vis;
import vit;
import viu;
import viv;
import viw;
import vix;
import viy;
import viz;
import vjb;
import vjc;
import vjd;
import vje;
import vjf;
import vjg;
import vjh;
import vji;
import vjk;
import vjl;

public class NotificationActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static final Pattern URL_MATCH_TXT_REGEX = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
  public static NotificationActivity a;
  private static final String aOv;
  public static final ArrayList<String> pq = new ArrayList(Arrays.asList(new String[] { "0X800AA2F", "0X800AA30", "0X800AA31", "0X800AA32" }));
  private aqvk jdField_a_of_type_Aqvk;
  private b jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$b = new b();
  private c jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$c = new c(1);
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private String aOr = "";
  private String aOs;
  private String aOt;
  private final String aOu = "lhPaySn";
  private boolean aYL;
  private boolean aYM;
  private c b = new c(2);
  private int bIF;
  private int bIG;
  private final int bIH = 1;
  private int bII;
  private final int bIJ = 1;
  private final int bIK = 2;
  private final int bIL = 3;
  private final int bIM = 4;
  private final int bIN = 5;
  private final int bIO = 6;
  private byte[] cd;
  private Dialog dialog;
  private arhz m;
  private BroadcastReceiver mReceiver = new vjg(this);
  private String msg;
  private String title;
  private MqqHandler uiHandler = new MqqHandler(Looper.getMainLooper(), this);
  
  static
  {
    aOv = aqjb.an.pattern() + "|" + aqjb.WEB_URL.pattern();
  }
  
  private void Bj(int paramInt)
  {
    QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  id: " + paramInt);
    if ((this.dialog != null) && (this.dialog.isShowing())) {}
    try
    {
      this.dialog.dismiss();
      this.dialog = null;
      switch (paramInt)
      {
      default: 
        sendBroadcast(new Intent("before_account_change"));
        xG(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  throwable: " + localThrowable);
        continue;
        this.title = getString(2131694734);
        this.msg = getString(2131694735);
        this.dialog = aqha.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new vjh(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131427343));
        localTextView.setTextColor(getResources().getColor(2131165625));
        if ((this.title != null) && (this.title.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.msg);
            this.dialog = aqha.a(this, 230).setMessage(this.msg).addView(localTextView).setPositiveButton(2131701876, new vji(this, str1), false);
            paramInt = 1;
            if (paramInt != 0) {
              break;
            }
            if (TextUtils.isEmpty(this.msg)) {
              break label434;
            }
            localTextView.setText(Html.fromHtml(this.msg));
            this.dialog = aqha.a(this, 230).setMessage(this.msg).addView(localTextView).setPositiveButton(2131693282, new vjk(this));
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          paramInt = 0;
          continue;
          label434:
          localTextView.setText(Html.fromHtml(getString(2131694441)));
        }
        try
        {
          this.dialog = a();
        }
        catch (Exception localException1)
        {
          CX();
        }
        continue;
        if (QQPlayerService.isPlaying()) {
          sendBroadcast(new Intent("qqplayer_exit_action"));
        }
        ajry.a().dyZ();
        paramInt = 2131721079;
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
          paramInt = 2131696440;
        }
        localObject1 = b(this.msg);
        this.dialog = aqha.a(this, 230, this.title, (CharSequence)localObject1, paramInt, 2131721079, null, new vjl(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
          if ((getIntent() != null) && (getIntent().getBooleanExtra("isSameDevice", false)) && (!isInMultiWindow()))
          {
            this.dialog = null;
            xH(true);
          }
          else
          {
            ((aqju)this.dialog).setPositiveButton(2131693973, new vig(this));
            localObject1 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
            ((Intent)localObject1).putExtra("kickedUin", this.app.getAccount());
            ((Intent)localObject1).putExtra("msg", this.msg);
            ((Intent)localObject1).setPackage("com.tencent.tim");
            sendBroadcast((Intent)localObject1);
            continue;
            this.dialog = aqha.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new vih(this));
            continue;
            this.dialog = aqha.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new vii(this));
            continue;
            this.dialog = aqha.a(this, 230).setTitle(getString(2131695562)).setMessage(getString(2131719400)).setPositiveButton(getString(2131719402), new vik(this)).setNegativeButton(getString(2131719399), new vij(this));
          }
        }
      }
      if (this.bIG != 40) {
        break label1192;
      }
    }
    anot.c(this.app, "dc00898", "", this.aOr, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.msg);
    Object localObject1 = getIntent();
    this.aOs = "";
    this.bII = 0;
    this.aOt = "";
    String str2;
    if (localObject1 != null)
    {
      this.aOs = ((Intent)localObject1).getStringExtra("errorUrl");
      this.bII = ((Intent)localObject1).getIntExtra("errorver", 0);
      if (!TextUtils.isEmpty(this.aOs))
      {
        localObject1 = MiniAppSecurityUtil.getArgumentsFromURL(this.aOs);
        if (localObject1 != null)
        {
          str2 = (String)((Map)localObject1).get("forbid_token");
          this.aOt = ((String)((Map)localObject1).get("forbid_status"));
          if ((!TextUtils.isEmpty(str2)) && (this.bII == 1))
          {
            MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplicationImpl.sApplication, this.aOr);
            MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplicationImpl.sApplication, this.aOr, str2);
          }
        }
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      for (;;)
      {
        if (paramInt != 0)
        {
          anot.c(this.app, "dc00898", "", "", "0X800AA15", "0X800AA15", 0, 0, "", "", this.aOt, "");
          this.dialog = aqha.a(this, 0, null, this.msg, getString(2131695576), getString(2131695575), getString(2131695577), new vil(this), new vim(this), new vin(this));
          break;
        }
        this.dialog = aqha.a(this, 0, null, this.msg, getString(2131695579), getString(2131695575), getString(2131695577), new vio(this), new vip(this), new viq(this));
        break;
        label1192:
        switch (this.bIG)
        {
        default: 
          this.dialog = aqha.b(this, 230).setMessageWithUrl(this.msg).setTitle(getString(2131701596)).setPositiveButton(17039370, new vis(this));
          break;
        case 41: 
        case 116: 
          localObject1 = (Long)aqvk.oy.get(this.aOr);
          if ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() < 30000L))
          {
            this.dialog = aqha.a(this, 230).setTitle(acfp.m(2131709150)).setMessage(acfp.m(2131709148)).setNegativeButton(acfp.m(2131709157), new vir(this));
            break;
          }
          bRV();
          break;
          Object localObject2 = getIntent().getExtras();
          localObject1 = ((Bundle)localObject2).getString("dlg_title");
          str2 = ((Bundle)localObject2).getString("dlg_content");
          String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
          String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
          localObject2 = ((Bundle)localObject2).getString("dlg_url");
          this.dialog = aqha.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new viu(this, (String)localObject2)).setNegativeButton(str3, new vit(this));
          break;
          localObject1 = getResources().getString(2131695709);
          str2 = getResources().getString(2131695708);
          str3 = getResources().getString(2131695705);
          str4 = getResources().getString(2131695707);
          Object localObject3 = getResources().getString(2131695706);
          localObject2 = new CheckBox(this);
          ((CheckBox)localObject2).setText((CharSequence)localObject3);
          ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131427343));
          ((CheckBox)localObject2).setTextColor(getResources().getColor(2131165625));
          localObject3 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
          boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
          ((CheckBox)localObject2).setChecked(bool);
          this.dialog = aqha.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new viw(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new viv(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
          break;
          try
          {
            localObject3 = getIntent().getExtras();
            localObject1 = ((Bundle)localObject3).getString("dlg_title", "");
            str2 = ((Bundle)localObject3).getString("dlg_content", "");
            str3 = ((Bundle)localObject3).getString("dlg_lbutton", "");
            str4 = ((Bundle)localObject3).getString("dlg_rbutton", "");
            localObject2 = ((Bundle)localObject3).getString("dlg_url", "");
            paramInt = ((Bundle)localObject3).getInt("dlg_lbtnid", 0);
            int i = ((Bundle)localObject3).getInt("dlg_rbtnid", 0);
            localObject3 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject3).getInt("dlg_seccmd", 0)) });
            this.dialog = aqha.a(this, 230).setTitle((String)localObject1).setMessage(str2);
            if (this.dialog == null) {
              break;
            }
            if (!TextUtils.isEmpty(str4)) {
              ((aqju)this.dialog).setPositiveButton(str4, new vix(this, (String)localObject2, i, (String)localObject3));
            }
            if (!TextUtils.isEmpty(str3)) {
              ((aqju)this.dialog).setNegativeButton(str3, new viy(this, paramInt, (String)localObject3));
            }
            anot.a(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject3, "", "", "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      break;
    }
  }
  
  private void Bk(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    if (paramInt == 116) {}
    for (boolean bool = true;; bool = false)
    {
      f("3", "mvip.gongneng.android.haoma_03", bool, true);
      return;
    }
  }
  
  private void Bl(int paramInt)
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("lh_is_from_login_verify_code", false))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("NotificationActivity", 4, String.format(Locale.getDefault(), "checkSetResult, isFromLH: %s, resultCode: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      if (bool)
      {
        localIntent = new Intent();
        localIntent.putExtra("lh_is_from_login_verify_code", true);
        setResult(paramInt, localIntent);
      }
      return;
    }
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2131559720);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365878);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365877);
    localObject = (TextView)((Window)localObject).findViewById(2131365902);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131700547) + "3.4.4" + getString(2131700546));
    localButton1.setOnClickListener(new viz(this));
    localButton2.setOnClickListener(new vjc(this));
    return localAlertDialog;
  }
  
  private void bRS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  private void bRT()
  {
    accy localaccy = (accy)this.app.getBusinessHandler(4);
    if (localaccy != null) {
      localaccy.close();
    }
  }
  
  private void bRU()
  {
    int i = this.jdField_a_of_type_Aqvk.Mx();
    int j = this.jdField_a_of_type_Aqvk.Mw();
    if ((j == -1) || (i == -1))
    {
      QQToast.a(this, acfp.m(2131709161), 0).show();
      finish();
      return;
    }
    String str = j + "";
    if (i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      f(str, "mvip.p.lh.pay_over", bool, false);
      return;
    }
  }
  
  private void bRV()
  {
    ThreadManagerV2.excute(new NotificationActivity.32(this), 16, null, true);
  }
  
  private void bRW()
  {
    ThreadManagerV2.excute(new NotificationActivity.35(this), 16, null, true);
  }
  
  private void f(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.cd == null)
    {
      paramString1 = "https://haoma.qq.com/m/expire.html?num=" + this.aOr;
      paramString2 = new Intent(this, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      startActivity(paramString2);
      Bl(0);
      finish();
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("unit", acfp.m(2131709151));
        localJSONObject.put("userId", this.aOr);
        localJSONObject.put("openMonth", paramString1);
        localJSONObject.put("offerId", "1450000833");
        localJSONObject.put("aid", paramString2);
        localJSONObject.put("ticketValue", SecUtil.toHexString(this.cd));
        localJSONObject.put("ticketName", "vask_27");
        localJSONObject.put("isCanChange", paramBoolean2);
        if (paramBoolean1)
        {
          localJSONObject.put("serviceCode", "CJCLUBT");
          localJSONObject.put("serviceName", "QQ超级会员");
          paramString1 = new Intent(this, PayBridgeActivity.class);
          paramString2 = new Bundle();
          paramString2.putString("json", localJSONObject.toString());
          paramString2.putString("callbackSn", "lhPaySn");
          paramString1.putExtras(paramString2);
          paramString1.putExtra("payparmas_from_is_login_state", false);
          paramString1.putExtra("pay_requestcode", 4);
          startActivityForResult(paramString1, 1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        Bl(0);
        finish();
        return;
      }
      localJSONObject.put("serviceCode", "LTMCLUB");
      localJSONObject.put("serviceName", "QQ会员");
    }
  }
  
  private void hideProgressDialog()
  {
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
  }
  
  private void showProgressDialog()
  {
    if (this.m == null) {
      this.m = new arhz(this, getTitleBarHeight());
    }
    if (!this.m.isShowing())
    {
      this.m.setMessage(acfp.m(2131709152));
      this.m.show();
    }
  }
  
  private void xG(boolean paramBoolean)
  {
    QLog.i("NotificationActivity", 1, "showDialog: invoked.  inResume: " + paramBoolean + " isDialogShow: " + this.aYL);
    if (this.aYL) {}
    while (((!paramBoolean) && (Build.VERSION.SDK_INT >= 28)) || (this.dialog == null) || (this.dialog.isShowing()) || (isFinishing())) {
      return;
    }
    this.dialog.setCancelable(false);
    try
    {
      this.dialog.show();
      this.aYL = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "showDialog: invoked.  t: " + localThrowable);
      }
    }
  }
  
  private void xH(boolean paramBoolean)
  {
    String str = null;
    Object localObject1 = this.app.getApplication().getAllAccounts();
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = this.app.getAccount();
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject3 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (SimpleAccount)((Iterator)localObject3).next();
        } while (!((String)localObject2).equals(((SimpleAccount)localObject1).getUin()));
      }
    }
    for (;;)
    {
      finish();
      this.app.setKickIntent(null);
      if (localObject1 != null)
      {
        aqmj.i(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
        if (paramBoolean)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new NotificationActivity.31(this, (SimpleAccount)localObject1), 500L);
          return;
        }
        this.app.login((SimpleAccount)localObject1);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("password", null);
      if (!akwp.a().N(this.app, this.app.getCurrentAccountUin()))
      {
        this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
        this.app.getApplication().refreAccountList();
      }
      localObject3 = (anxr)this.app.getManager(61);
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ((anxr)localObject3).dK();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          if (!akwp.a().N(this.app, str))
          {
            this.app.updateSubAccountLogin(str, false);
            this.app.getApplication().refreAccountList();
          }
        }
      }
      startActivity(new Intent(this, LoginActivity.class).putExtras((Bundle)localObject2).addFlags(67108864));
      return;
      localObject1 = null;
    }
  }
  
  public void CX()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.exit(false);
  }
  
  public CharSequence b(String paramString)
  {
    if (paramString == null) {}
    while (!aqjb.am.matcher(paramString).find()) {
      return paramString;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    Matcher localMatcher = URL_MATCH_TXT_REGEX.matcher(paramString);
    int k = 0;
    int i = 0;
    int j = 0;
    String str;
    Object localObject;
    if (localMatcher.find())
    {
      k = localMatcher.start(0);
      j = localMatcher.end(0);
      str = paramString.substring(localMatcher.start(1), localMatcher.end(1));
      localObject = paramString.substring(localMatcher.start(2), localMatcher.end(2));
      if (i == k) {
        break label401;
      }
      localSpannableStringBuilder.append(paramString.substring(i, k));
      i = j;
    }
    label401:
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new a((String)localObject, new WeakReference(this)), 0, str.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131165985)), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      k = 1;
      break;
      if (k != 0)
      {
        localSpannableStringBuilder.append(paramString.substring(j));
        return localSpannableStringBuilder;
      }
      localMatcher = Pattern.compile(aOv, 2).matcher(paramString);
      i = 0;
      j = 0;
      while (localMatcher.find())
      {
        int n = localMatcher.start();
        j = localMatcher.end();
        str = paramString.substring(n, j);
        k = i;
        if (i != n)
        {
          localSpannableStringBuilder.append(paramString.substring(i, n));
          k = j;
        }
        localObject = new SpannableString(str);
        ((SpannableString)localObject).setSpan(new a(str, new WeakReference(this)), 0, str.length(), 33);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131165985)), 0, str.length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject);
        i = k;
      }
      localSpannableStringBuilder.append(paramString.substring(j));
      return localSpannableStringBuilder;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (LiangHaoBuyFragment.g(paramIntent) != 0) {
        break label24;
      }
    }
    label24:
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      Bl(paramInt1);
      finish();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559712);
    Object localObject = "";
    paramBundle = (Bundle)localObject;
    try
    {
      this.bIF = getIntent().getIntExtra("type", 0);
      paramBundle = (Bundle)localObject;
      localObject = getIntent().getAction();
      paramBundle = (Bundle)localObject;
      if (QLog.isColorLevel())
      {
        paramBundle = (Bundle)localObject;
        QLog.d("NotificationActivity", 2, "NotificationActivity action = " + (String)localObject);
      }
      paramBundle = (Bundle)localObject;
      if (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(localObject)) {
        break label347;
      }
      paramBundle = (Bundle)localObject;
      this.bIF = 1;
      paramBundle = (Bundle)localObject;
      bRT();
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          for (;;)
          {
            String str;
            paramBundle.mergeFrom((byte[])localObject);
            if (paramBundle.has()) {
              break label482;
            }
            return false;
            paramBundle = (Bundle)localObject;
            if ("mqq.intent.action.ACCOUNT_TIPS".equals(localObject))
            {
              paramBundle = (Bundle)localObject;
              this.bIF = 6;
              continue;
              localException = localException;
              localObject = paramBundle;
              paramBundle = (Bundle)localObject;
              if (QLog.isColorLevel())
              {
                QLog.e("NotificationActivity", 2, "doOnCreate exception", localException);
                paramBundle = (Bundle)localObject;
              }
            }
            else
            {
              paramBundle = (Bundle)localObject;
              if ("mqq.intent.action.ACCOUNT_KICKED".equals(localObject))
              {
                paramBundle = (Bundle)localObject;
                bRS();
                paramBundle = (Bundle)localObject;
                bRT();
                paramBundle = (Bundle)localObject;
                this.bIF = 5;
              }
              else
              {
                paramBundle = (Bundle)localObject;
                if (!"mqq.intent.action.GRAY".equals(localObject)) {
                  break;
                }
                paramBundle = (Bundle)localObject;
                this.bIF = 2;
              }
            }
          }
          paramBundle = (Bundle)localObject;
        } while (!"mqq.intent.action.SUSPEND".equals(localObject));
        paramBundle = (Bundle)localObject;
        this.bIF = 4;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if ((paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
          break label540;
        }
        if (!QLog.isColorLevel()) {
          break label538;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.post(new NotificationActivity.2(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
        this.dialog = aqha.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(paramBundle.str_right_button.get(), new vjb(this, paramBundle));
        if (!paramBundle.str_left_button.has()) {
          break label648;
        }
        ((aqju)this.dialog).setNegativeButton(paramBundle.str_left_button.get(), new vjf(this));
        xG(false);
        return true;
      }
    }
    paramBundle = (Bundle)localObject;
    this.title = getIntent().getStringExtra("title");
    paramBundle = (Bundle)localObject;
    this.msg = getIntent().getStringExtra("msg");
    paramBundle = (Bundle)localObject;
    this.aOr = getIntent().getStringExtra("loginalias");
    paramBundle = (Bundle)localObject;
    this.cd = getIntent().getByteArrayExtra("expiredSig");
    paramBundle = (Bundle)localObject;
    this.bIG = getIntent().getIntExtra("loginret", 0);
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
    paramBundle = (Bundle)localObject;
    str = getIntent().getStringExtra("securityScan");
    if (str != null)
    {
      paramBundle = (Bundle)localObject;
      if ("security_scan".equals(str))
      {
        paramBundle = (Bundle)localObject;
        this.bIF = 7;
      }
    }
    paramBundle = (Bundle)localObject;
    QLog.d("NotificationActivity", 1, "notification activity type:" + this.bIF);
    label538:
    label540:
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle))
    {
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
      }
      label347:
      label482:
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
    }
    label648:
    this.jdField_a_of_type_Aqvk = new aqvk(this.aOr);
    Bj(this.bIF);
    registerReceiver(this.mReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  isDialogShow: " + this.aYL);
    try
    {
      unregisterReceiver(this.mReceiver);
      if ((this.dialog == null) || (!this.dialog.isShowing())) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.dialog.dismiss();
        this.dialog = null;
        super.doOnDestroy();
        if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
          jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
        }
        return;
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  t: " + localThrowable2);
        }
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    xG(true);
    if ((this.aYM) && (this.dialog != null) && (this.dialog.isShowing())) {
      ((aqju)this.dialog).setPositiveButton(2131701875, new vif(this));
    }
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.bIF == 3) {
      CX();
    }
  }
  
  public void finish()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      this.dialog = aqha.a(this, getResources().getString(2131695271), getResources().getString(2131695261), getResources().getString(2131695257), this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$c, acfp.m(2131709160), this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$c, this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$b);
      this.dialog.show();
      return true;
    case 2: 
      this.dialog = aqha.a(this, getResources().getString(2131695271), getResources().getString(2131695260), getResources().getString(2131695258), this.b, getResources().getString(2131695256), this.b, this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity$b);
      this.dialog.show();
      return true;
    case 3: 
      if (this.bIG == 41) {}
      for (paramMessage = getString(2131697144);; paramMessage = getString(2131697143))
      {
        String str = getString(2131697142);
        this.dialog = aqha.a(this, 230).setMessage(paramMessage).setTitle(str).setNegativeButton(2131697141, new vje(this)).setPositiveButton(2131697138, new vjd(this));
        this.dialog.setCancelable(false);
        this.dialog.show();
        return true;
      }
    case 4: 
      showProgressDialog();
      return true;
    case 5: 
      hideProgressDialog();
      QQToast.a(this, 2, acfp.m(2131709155), 0).show(getTitleBarHeight());
      aqvk.oy.put(this.aOr, Long.valueOf(System.currentTimeMillis()));
      finish();
      return true;
    }
    hideProgressDialog();
    QQToast.a(this, 1, acfp.m(2131709154), 0).show(getTitleBarHeight());
    finish();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  static class a
    extends ClickableSpan
  {
    public WeakReference<NotificationActivity> mActivity;
    public String mStr;
    
    public a(String paramString, WeakReference<NotificationActivity> paramWeakReference)
    {
      this.mStr = paramString;
      this.mActivity = paramWeakReference;
    }
    
    public void onClick(View paramView)
    {
      if (this.mActivity.get() != null)
      {
        paramView = (NotificationActivity)this.mActivity.get();
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", this.mStr);
        paramView.startActivity(localIntent);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        NotificationActivity.this.finish();
      }
    }
  }
  
  class c
    implements DialogInterface.OnClickListener
  {
    private int type;
    
    public c(int paramInt)
    {
      this.type = paramInt;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if (paramInt == 0) {
        if (this.type == 1) {
          NotificationActivity.a(NotificationActivity.this);
        }
      }
      while (paramInt != 1)
      {
        NotificationActivity.a(NotificationActivity.this).sendEmptyMessage(4);
        do
        {
          return;
        } while (this.type != 2);
        NotificationActivity.a(NotificationActivity.this, NotificationActivity.b(NotificationActivity.this));
        return;
      }
      NotificationActivity.b(NotificationActivity.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */