package com.tencent.mobileqq.activity.qwallet;

import aagd;
import acfd;
import acff;
import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anpc;
import aqcv;
import aqdj;
import aqgv;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import wja;
import zzt;
import zzu;
import zzv;
import zzw;
import zzx;
import zzy;

public class TransactionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView GY;
  private TextView HU;
  private TextView NA;
  private TextView NB;
  private TextView NC;
  private TextView Nz;
  private String QE;
  private EditText aS;
  private EditText aT;
  private EditText aU;
  private Button aX;
  private String bbM;
  private String bbS;
  private String bbT;
  private String bbU;
  private String bbV;
  private String bbW;
  private String bbX;
  private String bbY;
  private String bbZ;
  private int bdj;
  private boolean buL;
  private boolean buN;
  private boolean buO;
  private boolean buP;
  private int cfK;
  private int cfL;
  private int cfM = 140;
  private Button eU;
  acfd g = new zzv(this);
  private LinearLayout gh;
  private ImageView gm;
  private boolean jg;
  private EditText mAmoutTxt;
  private String mAppInfo;
  private Context mContext;
  private String mDesc;
  private long mReportSeq;
  private String mSource;
  private String mTag;
  protected TextWatcher mTextWatcher = new zzt(this);
  private String mUin;
  private long mlastInvalidatetime;
  private String np;
  private TextView titleTV;
  protected TextWatcher v = new zzw(this);
  private ImageView vK;
  private ImageView vN;
  private View ze;
  private View zf;
  private View zg;
  private View zh;
  private View zi;
  
  private String a(float paramFloat)
  {
    if ((paramFloat >= 1000.0F) && (paramFloat <= 9999.0F)) {
      return acfp.m(2131715407);
    }
    if ((paramFloat >= 10000.0F) && (paramFloat <= 99999.0F)) {
      return acfp.m(2131715411);
    }
    if ((paramFloat >= 100000.0F) && (paramFloat <= 999999.0F)) {
      return acfp.m(2131715410);
    }
    if ((paramFloat >= 1000000.0F) && (paramFloat <= 9999999.0F)) {
      return acfp.m(2131715408);
    }
    if ((paramFloat >= 10000000.0F) && (paramFloat < 1.0E+008F)) {
      return acfp.m(2131715406);
    }
    return "";
  }
  
  private void csU()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.mUin);; localObject = "")
    {
      localBundle.putString("uin", this.mUin);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("skey_type", "2");
      localBundle.putInt("PayInvokerId", 21);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void ctd()
  {
    if (this.buO)
    {
      if (TextUtils.isEmpty(this.bbZ)) {}
      for (String str = "向陌生人转账最低1.00元！";; str = this.bbZ)
      {
        ThreadManager.getUIHandler().post(new TransactionActivity.4(this, str));
        return;
      }
    }
    ThreadManager.getUIHandler().post(new TransactionActivity.5(this));
  }
  
  private void cte()
  {
    JSONObject localJSONObject = YellowTipsLayout.getYellowTipsConfig(getApplicationContext(), this.mUin);
    YellowTipsLayout localYellowTipsLayout = (YellowTipsLayout)findViewById(2131372274);
    if ((localYellowTipsLayout != null) && (localYellowTipsLayout.setYellowTipsJsonConfig(localJSONObject, "transfer_ad"))) {
      this.ze.setPadding(0, 0, 0, 0);
    }
  }
  
  public static String g(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt < 0) {
      return "0";
    }
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "0";
  }
  
  private void gi(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!ImmersiveUtils.setStatusTextColor(true, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().setStatusBarColor(637534208);
      }
      this.gh.setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.titleTV.setTextColor(-16777216);
      this.GY.setVisibility(0);
      this.ze.setVisibility(0);
      this.zf.setVisibility(8);
      this.HU.setCompoundDrawablesWithIntrinsicBounds(2130844128, 0, 0, 0);
      return;
    }
    if ((!ImmersiveUtils.setStatusTextColor(false, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setStatusBarColor(0);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { getResources().getColor(2131166438), getResources().getColor(2131166437) });
    if (Build.VERSION.SDK_INT <= 15) {
      this.gh.setBackgroundDrawable(localGradientDrawable);
    }
    for (;;)
    {
      this.titleTV.setTextColor(-1);
      this.GY.setVisibility(8);
      this.ze.setVisibility(8);
      this.zf.setVisibility(0);
      this.HU.setCompoundDrawablesWithIntrinsicBounds(2130848258, 0, 0, 0);
      return;
      this.gh.setBackground(localGradientDrawable);
    }
  }
  
  private String hX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new BigDecimal(paramString);
      BigDecimal localBigDecimal = new BigDecimal("100");
      paramString = new DecimalFormat("#").format(paramString.multiply(localBigDecimal).doubleValue());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private boolean iG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if ((paramString.indexOf('.') != 0) && ((paramString.indexOf('.') <= 0) || (paramString.indexOf('.') >= paramString.length() - 3))) {
        try
        {
          double d = Double.valueOf(paramString).doubleValue();
          if (d > 0.0D) {
            if (this.buO)
            {
              int i = this.cfL;
              if (i > d * 100.0D) {}
            }
            else
            {
              return true;
            }
          }
        }
        catch (Exception paramString) {}
      }
    }
    return false;
  }
  
  private void zZ(String paramString)
  {
    if (!this.buN) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TargetUin", this.bbV);
      localJSONObject.put("PayeeNick", this.bbM);
      localJSONObject.put("pay_status", paramString);
      paramString = new JSONObject();
      paramString.put("userId", this.mUin);
      paramString.put("viewTag", "transferPush");
      paramString.put("comeForm", this.bdj);
      paramString.put("appInfo", this.mAppInfo);
      paramString.put("extra_data", localJSONObject.toString());
      PayBridgeActivity.tenpay(this, paramString.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    try
    {
      paramString5.append(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
      paramString5.append("|");
      paramString5.append(aqcv.gP());
      paramString5.append("|");
      if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
      {
        paramString5.append(paramString3);
        paramString5.append(".");
        paramString5.append(paramString4);
      }
      paramString5.append("|");
      paramString5.append(this.bdj);
      paramString5.append(".");
      if (!TextUtils.isEmpty(this.mAppInfo)) {
        paramString5.append(this.mAppInfo.replace("|", ","));
      }
      paramString5.append("|");
      VACDReportUtil.b(this.mReportSeq, null, paramString2, "op_type=" + paramInt1, 0, "");
      anpc.a(BaseApplication.getContext()).i(this.app, paramString5.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public int aj(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299627);
      float f = paramContext.getResources().getDisplayMetrics().density;
      return i - (int)(f * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void ctf()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("PayeeUin", this.bbV);
      localJSONObject1.put("PayeeNick", this.bbT);
      if (!TextUtils.isEmpty(this.bbU))
      {
        localJSONObject1.put("Amout", hX(this.bbU));
        localJSONObject1.put("Memo", this.mDesc);
      }
      for (;;)
      {
        localJSONObject1.put("ComeFrom", this.bdj);
        localJSONObject1.put("HistransSign", this.bbS);
        localJSONObject1.put("source", this.mSource);
        localJSONObject1.put("group_type", this.bbW);
        localJSONObject1.put("group_uin", this.QE);
        localJSONObject1.put("na_from_h5_data", this.bbX);
        localJSONObject1.put("h5_success", true);
        JSONObject localJSONObject2 = new JSONObject();
        if ("transferInput".equals(this.mTag))
        {
          localJSONObject2.put("getpayee_type", 1);
          localJSONObject2.put("payee_uin", this.bbV);
          localJSONObject2.put("payee_nick", this.bbT);
        }
        localJSONObject2.put("fromPage", "AioTransfer");
        localJSONObject1.put("transPay_data", localJSONObject2.toString());
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("userId", this.mUin);
        localJSONObject2.put("viewTag", "transferInfor");
        localJSONObject2.put("comeForm", this.bdj);
        localJSONObject2.put("appInfo", this.mAppInfo);
        localJSONObject2.put("extra_data", localJSONObject1.toString());
        PayBridgeActivity.tenpay(this, localJSONObject2.toString(), 5, "0");
        return;
        localJSONObject1.put("Amout", hX(this.mAmoutTxt.getText().toString()));
        localJSONObject1.put("Memo", this.aT.getText().toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.mReportSeq = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.mReportSeq == 0L) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "transfer", "transinvoke", null, 0, null);
    }
    for (;;)
    {
      this.mContext = this;
      addObserver(this.g);
      try
      {
        this.mUin = this.app.getCurrentAccountUin();
        this.bbM = this.app.getCurrentNickname();
        this.bdj = getIntent().getIntExtra("come_from", 1);
        this.np = getIntent().getStringExtra("callbackSn");
        this.mAppInfo = getIntent().getStringExtra("app_info");
        this.buN = getIntent().getBooleanExtra("fromJump", false);
        this.mTag = getIntent().getStringExtra("tag");
        this.buP = getIntent().getBooleanExtra("avoidInput", false);
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.bbV = paramBundle.optString("targetUin");
        this.bbT = paramBundle.optString("targetNickname");
        this.bbU = paramBundle.optString("trans_fee");
        this.mDesc = paramBundle.optString("desc");
        this.bbS = paramBundle.optString("sign");
        this.mSource = paramBundle.optString("source");
        this.bbW = paramBundle.optString("group_type");
        this.QE = paramBundle.optString("group_uin");
        this.bbX = paramBundle.optString("na_from_h5_data");
        initView();
        zZ("1");
        ThreadManager.getFileThreadHandler().post(new TransactionActivity.3(this));
        if (QWalletHelper.isNeedPreConnect(this.mContext, this.mUin, "type_mqq_and_myun")) {
          csU();
        }
        return true;
        VACDReportUtil.b(this.mReportSeq, null, "transinvoke", null, 0, null);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.g);
    super.doOnDestroy();
    if (this.mReportSeq != 0L) {
      VACDReportUtil.endReport(this.mReportSeq, "transfer.qqid.destroy", null, 0, null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jg = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(16);
      this.jg = false;
      if (this.zf.getVisibility() == 0)
      {
        a(this.mUin, 128, "transfer.qqid.show", "", "", this.bdj, "");
        return;
      }
      a(this.mUin, 128, "transfer.amount.show", "", "", this.bdj, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e(CharSequence paramCharSequence)
  {
    if ((!this.jg) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).show(aj(this.mContext));
    }
  }
  
  @TargetApi(14)
  protected void initView()
  {
    Object localObject1;
    try
    {
      setContentView(2131562179);
      this.gh = ((LinearLayout)findViewById(2131377546));
      this.zg = findViewById(2131374383);
      this.zh = findViewById(2131374417);
      this.ze = findViewById(2131377556);
      this.zf = findViewById(2131363474);
      cte();
      this.HU = ((TextView)findViewById(2131369579));
      this.HU.setVisibility(0);
      this.HU.setOnClickListener(this);
      this.titleTV = ((TextView)findViewById(2131369627));
      this.vN = ((ImageView)findViewById(2131380142));
      this.zi = findViewById(2131371507);
      this.NC = ((TextView)findViewById(2131380143));
      this.mAmoutTxt = ((EditText)findViewById(2131362698));
      this.aS = ((EditText)findViewById(2131372914));
      this.aU = ((EditText)findViewById(2131379362));
      this.aU.addTextChangedListener(this.v);
      this.mAmoutTxt.addTextChangedListener(this.mTextWatcher);
      this.aS.addTextChangedListener(this.mTextWatcher);
      this.aT = ((EditText)findViewById(2131371244));
      this.Nz = ((TextView)findViewById(2131372926));
      this.aT.setOnEditorActionListener(new zzx(this));
      this.aX = ((Button)findViewById(2131380139));
      this.aX.setOnClickListener(this);
      this.aX.setEnabled(false);
      this.eU = ((Button)findViewById(2131379356));
      this.eU.setOnClickListener(this);
      this.eU.setEnabled(false);
      this.eU.setClickable(false);
      this.gm = ((ImageView)findViewById(2131379381));
      this.NA = ((TextView)findViewById(2131379380));
      String str = aagd.b(this.mContext, this.bbT, wja.dp2px(this.cfM, this.mContext.getResources()), this.NA.getPaint());
      this.NA.setText(str + "(" + this.bbV + ")");
      this.vK = ((ImageView)findViewById(2131380140));
      this.vK.setOnClickListener(this);
      this.GY = ((TextView)findViewById(2131369612));
      this.GY.setVisibility(0);
      this.GY.setText(acfp.m(2131715409));
      this.GY.setOnClickListener(this);
      if ("transferInput".equals(this.mTag))
      {
        gi(false);
        this.titleTV.setText(2131699230);
        getWindow().setWindowAnimations(2131755892);
        this.aU.requestFocus();
        if (!TextUtils.isEmpty(this.bbV))
        {
          this.aU.setText(this.bbV);
          this.aU.setSelection(this.bbV.length());
        }
        this.mSource = "3";
        this.bdj = 2;
        if ((this.buP) && (!TextUtils.isEmpty(this.bbV)))
        {
          this.eU.performClick();
          this.NB = ((TextView)findViewById(2131380141));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        finish();
        continue;
        new Handler().postDelayed(new TransactionActivity.7(this), 100L);
      }
      gi(true);
      localObject1 = (acff)this.app.getManager(51);
      if (((acff)localObject1).e(this.bbV) == null) {
        break label908;
      }
    }
    label724:
    Object localObject2;
    if (((acff)localObject1).isFriend(this.bbV))
    {
      localObject1 = getString(2131699297);
      if (this.bdj != 2) {
        break label924;
      }
      localObject2 = (String)localObject1 + getString(2131699301);
      this.aX.setText(getString(2131699304));
      label771:
      if (TextUtils.isEmpty(this.bbU)) {
        break label976;
      }
      if (!TextUtils.isEmpty(this.mDesc)) {
        this.Nz.setText(this.mDesc);
      }
      if (!TextUtils.isEmpty(this.bbU))
      {
        this.bbU = g(this.bbU, "100", 2);
        this.aS.setText(this.bbU);
      }
      this.gh.setBackgroundColor(Color.parseColor("#ffffff"));
      this.zg.setVisibility(0);
      this.zh.setVisibility(8);
      this.aX.setEnabled(true);
    }
    for (;;)
    {
      this.titleTV.setText((CharSequence)localObject2);
      localObject1 = aqdj.a(this.app, 1, this.bbV);
      this.gm.setImageDrawable((Drawable)localObject1);
      break;
      label908:
      localObject1 = getString(2131699299);
      this.buO = true;
      break label724;
      label924:
      localObject2 = localObject1;
      if (this.bdj != 5) {
        break label771;
      }
      localObject2 = (String)localObject1 + getString(2131699300);
      this.aX.setText(getString(2131699309));
      break label771;
      label976:
      this.gh.setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.mAmoutTxt.requestFocus();
      this.zh.setVisibility(0);
      this.zg.setVisibility(8);
      new Handler().postDelayed(new TransactionActivity.8(this), 100L);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jg = false;
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("result");
      if ((paramIntent == null) || (paramIntent.length() <= 0)) {
        break label114;
      }
    }
    int i;
    label114:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(paramIntent);
            i = paramInt2;
            if (localObject1 == null) {
              break label128;
            }
            localObject1 = null;
          }
          catch (Exception paramIntent)
          {
            try
            {
              i = ((JSONObject)localObject1).optInt("resultCode", -1);
              paramInt2 = i;
              paramIntent = new JSONObject(((JSONObject)localObject1).optString("retmsg"));
              if ((i != 0) || (paramIntent == null)) {
                break;
              }
              switch (paramInt1)
              {
              default: 
                return;
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              i = paramInt2;
            }
            paramIntent = paramIntent;
            paramIntent.printStackTrace();
          }
          continue;
          paramIntent = null;
        }
        if (this.app != null) {
          getSharedPreferences("transfer", 0).edit().putBoolean("is_need_dialog_" + this.app.getCurrentAccountUin() + this.bbV, false).commit();
        }
        localObject1 = paramIntent.optString("callback_url");
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = new StringBuffer(Uri.decode((String)localObject1));
      Object localObject2 = paramIntent.optString("sp_data");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&sp_data=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("transaction_id");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&transaction_id=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("total_fee");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&total_fee=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = paramIntent.optString("pay_time");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuffer)localObject1).append("&pay_time=");
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      localObject2 = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callback_url", ((StringBuffer)localObject1).toString());
        localJSONObject.put("exec_code", paramIntent.optString("exec_code"));
        localJSONObject.put("uin", this.bbV);
        localJSONObject.put("url", ((StringBuffer)localObject1).toString());
        ((JSONObject)localObject2).put("resultCode", 0);
        ((JSONObject)localObject2).put("retmsg", "SUCCESS");
        if (this.bdj == 5) {
          ((JSONObject)localObject2).put("retdata", localJSONObject);
        }
        for (;;)
        {
          paramIntent = new Intent();
          paramIntent.putExtra("callbackSn", this.np);
          paramIntent.putExtra("PayInvokerId", 5);
          paramIntent.putExtra("result", ((JSONObject)localObject2).toString());
          setResult(-1, paramIntent);
          finish();
          return;
          ((JSONObject)localObject2).put("data", localJSONObject);
        }
      }
      catch (Exception paramIntent)
      {
        break label480;
      }
    } while (i <= 0);
    label128:
    label480:
    Object localObject1 = ((JSONObject)localObject1).optString("retmsg");
    paramIntent = (Intent)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramIntent = getString(2131699121);
    }
    QQToast.a(this.mContext, paramIntent, 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369579) {
      if (("transferInput".equals(this.mTag)) && (this.ze.getVisibility() == 0) && (!this.buP)) {
        if (this.buL)
        {
          a(this.mUin, 128, "transfer.qqid.keyback", "", "", this.bdj, "");
          this.aU.requestFocus();
          gi(false);
          this.bbT = null;
          this.gm.setImageDrawable(null);
          this.NA.setText("");
          this.titleTV.setText(2131699298);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.mUin, 128, "transfer.qqid.back", "", "", this.bdj, "");
      break;
      if (this.buL) {
        a(this.mUin, 128, "transfer.amout.keyback", "", "", this.bdj, "");
      }
      for (;;)
      {
        zZ("2");
        v(-1, null);
        if (this.mContext != null) {
          ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.aT.getWindowToken(), 0);
        }
        finish();
        break;
        a(this.mUin, 128, "transfer.amount.back", "", "", this.bdj, "");
      }
      Object localObject;
      if (i == 2131369612)
      {
        i = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".indexOf(':');
        if (i != -1)
        {
          localObject = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".substring(0, i);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).toLowerCase();
            if ((((String)localObject).compareTo("http") == 0) || (((String)localObject).compareTo("https") == 0))
            {
              localObject = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("url", "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment");
              ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
              startActivityForResult((Intent)localObject, -1);
            }
          }
        }
      }
      else if (i == 2131380139)
      {
        long l = System.currentTimeMillis();
        if (this.mlastInvalidatetime + 1000L < l)
        {
          if (getSharedPreferences("transfer", 0).getBoolean("is_need_dialog_" + this.mUin + this.bbV, true)) {
            aqha.a(this.mContext, 233, null, getString(2131699305), 2131721058, 2131720231, new zzy(this), new zzu(this)).show();
          }
          for (;;)
          {
            this.mlastInvalidatetime = l;
            break;
            a(this.mUin, 128, "transfer.amount.go", "", "", this.bdj, "");
            ctf();
          }
        }
      }
      else
      {
        if (i == 2131379356)
        {
          this.bbV = this.aU.getText().toString();
          gi(true);
          this.mAmoutTxt.requestFocus();
          this.bbT = aqgv.b(this.app, this.bbV, true);
          localObject = aagd.b(this.mContext, this.bbT, wja.dp2px(this.cfM, this.mContext.getResources()), this.NA.getPaint());
          this.NA.setText((String)localObject + "(" + this.bbV + ")");
          localObject = aqdj.a(this.app, 1, this.bbV);
          this.gm.setImageDrawable((Drawable)localObject);
          a(this.mUin, 128, "transfer.qqid.next", "", "", this.bdj, "");
          localObject = getString(2131699299) + getString(2131699301);
          if ("transferInput".equals(this.mTag))
          {
            acff localacff = (acff)this.app.getManager(51);
            if ((localacff.e(this.bbV) != null) && (localacff.isFriend(this.bbV))) {
              localObject = getString(2131699297) + getString(2131699301);
            }
          }
          for (this.buO = false;; this.buO = true)
          {
            this.titleTV.setText((CharSequence)localObject);
            ctd();
            this.mAmoutTxt.setText("");
            break;
          }
        }
        if (i == 2131380140)
        {
          this.mAmoutTxt.setText("");
          this.zi.setVisibility(0);
          this.vN.setVisibility(8);
          this.NC.setVisibility(8);
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.buL = true;
      this.HU.performClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void v(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label29:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.np);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity
 * JD-Core Version:    0.7.0.1
 */