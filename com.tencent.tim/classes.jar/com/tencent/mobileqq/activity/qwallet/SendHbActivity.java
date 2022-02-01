package com.tencent.mobileqq.activity.qwallet;

import aaao;
import aaay;
import aabj;
import aabn;
import aagd;
import acfp;
import ahgq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqgv;
import aqha;
import aqju;
import avor;
import avox;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zzh;
import zzk;
import zzl;
import zzm;

public class SendHbActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private aabj jdField_a_of_type_Aabj;
  private aabn jdField_a_of_type_Aabn;
  private BaseHbFragment jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
  private BroadcastReceiver aT = new zzh(this);
  private JSONObject aZ;
  private View ai;
  private ImageButton au;
  private String bbD;
  private String bbE;
  private String bbF;
  public String bbG;
  private String bbH;
  public String bbI;
  private String bbJ = "";
  private String bbK = "";
  private String bbL;
  private int bdj;
  private boolean buJ;
  private boolean buK;
  private boolean buL;
  private QWalletPayProgressDialog c;
  public int cfF;
  private int cfG = -1;
  private int cfH = 0;
  private String hb_from_type;
  Intent intent = new Intent();
  private boolean isConfirm;
  private boolean jg;
  private String mAppInfo;
  public String mGroupId;
  private Intent mIntent;
  private BroadcastReceiver mReceiver = new zzm(this);
  public long mReportSeq;
  private String mUin;
  private Map<String, String> mapParams;
  private String np;
  private View rootView;
  List<Integer> uT = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(32768), Integer.valueOf(16384), Integer.valueOf(128), Integer.valueOf(256), Integer.valueOf(512), Integer.valueOf(2048) }));
  private ImageView vJ;
  private View zd;
  
  private String aB(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private void amK()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void csT()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qwallet.report");
    registerReceiver(this.aT, localIntentFilter);
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
  
  private void csW()
  {
    int i = 1;
    Object localObject;
    if ("1".equals(aagd.b(this.mapParams, "makeHb_type", "0")))
    {
      this.rootView.setVisibility(8);
      this.bbJ = ((String)this.mapParams.get("total_amount"));
      this.bbK = ((String)this.mapParams.get("total_num"));
      if (this.hb_from_type.equals("100"))
      {
        localObject = Y();
        ((Map)localObject).put("type", "1");
        new aaay(this).Z((Map)localObject);
        return;
      }
      new aaay(this).ctq();
      return;
    }
    if ((this.buJ) && ("h5".equals(this.mapParams.get("invoke_from"))) && (this.cfF == 2048))
    {
      new aaay(this).dY("", this.mUin);
      finish();
      return;
    }
    if ((this.buK) || (this.cfF == 64))
    {
      csX();
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof SendHbMainFragment)) {
        new ImmersionBar(this, -1308622848, this.zd);
      }
      csY();
      return;
    }
    switch (this.cfF)
    {
    default: 
      if (this.cfF == 4096) {
        if (("1".equals(this.bbD)) || ("7".equals(this.bbD)) || ("6".equals(this.bbD))) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = getString(2131698996);
      if (this.cfF == 512) {
        localObject = getString(2131699263);
      }
      boolean bool = getIntent().getBooleanExtra("isFromPanel", false);
      Bundle localBundle = k();
      localBundle.putBoolean("isFromPanel", bool);
      localBundle.putInt("tabMask", i);
      localBundle.putString("hbTitle", (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new SendHbMainFragment();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
      break;
      csZ();
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new ThemeHbFragment();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(k());
      break;
      i = 2;
      continue;
      if (!avox.LG.contains(this.bbD)) {
        if (this.cfF == 2048) {
          i = 3;
        } else if (this.cfF == 512) {
          i = 3;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private void csX()
  {
    boolean bool = false;
    Object localObject;
    if (TextUtils.isEmpty(this.bbI))
    {
      localObject = this.mIntent.getStringExtra("theme_config");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (String str = "hb_theme_";; str = "")
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("hb_theme_id")) {
          continue;
        }
        this.bbI = ((JSONObject)localObject).optString(String.format("%sid", new Object[] { str }));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        Bundle localBundle = k();
        localBundle.putString("theme_type", this.bbI);
        if (64 != this.cfF) {
          break label184;
        }
        this.buK = true;
        this.mGroupId = this.mIntent.getStringExtra("group_id");
        this.bbG = this.mIntent.getStringExtra("group_member_number");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new ThemeHbFragment();
        localBundle.putString("group_count", this.bbG);
        if ((!"2".equals(this.bbD)) && (!"3".equals(this.bbD))) {
          break label233;
        }
        bool = true;
        localBundle.putBoolean("isGroupThemeHb", bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
      }
      if (!TextUtils.isEmpty(this.bbI)) {
        break;
      }
      QLog.i("SendHbActivity", 2, "params error, no theme id...");
      QQToast.a(this, "params error, no theme id...", 0).show();
      finish();
      return;
    }
    label184:
    label233:
    return;
  }
  
  private void csY()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null)
    {
      ((FrameLayout)findViewById(2131365563)).setVisibility(0);
      localFragmentTransaction.add(2131365563, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment);
      localFragmentTransaction.commit();
    }
  }
  
  private void cta()
  {
    if (aagd.b(this.mapParams, "makeHb_type", "0").equals("1")) {
      finish();
    }
  }
  
  private String hX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(aB(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private void initData()
  {
    this.mUin = this.app.getCurrentAccountUin();
    this.bbF = this.app.getCurrentNickname();
    this.buK = this.mIntent.getBooleanExtra("theme", false);
    this.jdField_a_of_type_Aabn = new aabn(this);
    this.jdField_a_of_type_Aabj = new aabj();
    this.mReportSeq = this.mIntent.getLongExtra("vacreport_key_seq", 0L);
    this.buJ = this.mIntent.getBooleanExtra("is_H5", false);
    this.bdj = this.mIntent.getIntExtra("come_from", 1);
    this.np = this.mIntent.getStringExtra("callbackSn");
    this.mAppInfo = this.mIntent.getStringExtra("app_info");
    String str = this.mIntent.getStringExtra("extra_data");
    this.mapParams = m(str);
    zU(str);
    this.hb_from_type = aagd.b(this.mapParams, "hb_from_type", "0");
    this.bbE = ((String)this.mapParams.get("recv_uin"));
    this.bbD = ((String)this.mapParams.get("recv_type"));
    this.bbH = this.bbD;
    this.cfF = avor.c(this.mapParams.get("channel"), 1);
    QLog.i("SendHbActivity", 2, "mChannel = " + this.cfF);
    if (!this.buK) {
      this.bbI = ((String)this.mapParams.get("theme_type"));
    }
    try
    {
      if ((!TextUtils.isEmpty(this.bbI)) && (Integer.valueOf(this.bbI).intValue() > 1)) {
        this.buK = true;
      }
      if (TextUtils.isEmpty(this.bbI)) {
        this.bbI = this.mIntent.getStringExtra("theme_type");
      }
      if (5 == this.cfF) {
        this.cfF = 16;
      }
      if (6 == this.cfF) {
        this.cfF = 32;
      }
      if ((5 == this.cfF) || (16 == this.cfF) || (128 == this.cfF) || (256 == this.cfF))
      {
        this.bbF = aqgv.G(this.app, this.mUin);
        if (TextUtils.isEmpty(this.bbF)) {
          this.bbF = this.app.getCurrentNickname();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void initView()
  {
    this.zd = findViewById(2131378716);
    this.rootView = findViewById(2131377546);
    this.ai = findViewById(2131377995);
    this.au = ((ImageButton)findViewById(2131377991));
    this.au.setOnClickListener(this);
    ((Button)findViewById(2131377992)).setOnClickListener(this);
  }
  
  private Bundle k()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.mapParams.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.mapParams.get(str));
    }
    localBundle.putString("channel", String.valueOf(this.cfF));
    return localBundle;
  }
  
  private Map<String, String> m(String paramString)
  {
    QLog.i("SendHbActivity", 2, "extra_data = " + paramString);
    paramString = aagd.o(paramString);
    String str = (String)paramString.remove("extra_info");
    if (!TextUtils.isEmpty(str)) {
      paramString.putAll(aagd.o(str));
    }
    paramString.put("send_name", this.bbF);
    paramString.put("send_uin", this.mUin);
    return paramString;
  }
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    if (this.vJ == null)
    {
      this.vJ = new ImageView(this);
      this.vJ.setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      this.vJ.setPadding(0, 0, 0, 0);
      this.vJ.setScaleType(ImageView.ScaleType.FIT_XY);
      ((FrameLayout)getWindow().getDecorView()).addView(this.vJ, new ViewGroup.LayoutParams(-1, -1));
    }
    ImageView localImageView = this.vJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void zU(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("isH5=").append(this.buJ);
    localStringBuilder.append("&comeFrom=").append(this.bdj);
    localStringBuilder.append("&callbackSn=").append(this.np);
    localStringBuilder.append("&appInfo=").append(this.mAppInfo);
    localStringBuilder.append("&extra=").append(paramString);
    if (this.mReportSeq == 0L)
    {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", localStringBuilder.toString(), 0, null);
      return;
    }
    VACDReportUtil.b(this.mReportSeq, null, "hbinvoke", localStringBuilder.toString(), 0, null);
  }
  
  private void zW(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof aaao))) {
      ((aaao)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment).ctk();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.bdj);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.mAppInfo);
      paramString = new Bundle();
      paramString.putString("json", localJSONObject.toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.a(this, 9, paramString);
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
  
  public void A(String paramString1, String paramString2, int paramInt)
  {
    c(this.mUin, yv(), paramString1, paramString2, "");
  }
  
  public Map<String, String> Y()
  {
    HashMap localHashMap = new HashMap(this.mapParams);
    localHashMap.put("name", this.bbF);
    if (2048 != this.cfF) {
      localHashMap.put("recv_type", this.bbH);
    }
    localHashMap.put("hb_from_type", this.hb_from_type + "");
    return localHashMap;
  }
  
  public Map<String, String> Z()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.mUin);
    localHashMap.put("viewTag", "sendHb");
    localHashMap.put("comeForm", "2");
    localHashMap.put("appInfo", this.mAppInfo);
    return localHashMap;
  }
  
  public aabj a()
  {
    return this.jdField_a_of_type_Aabj;
  }
  
  public aabn a()
  {
    return this.jdField_a_of_type_Aabn;
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  protected void aD(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("send_name", this.bbF);
      localJSONObject.putOpt("send_uin", this.mUin);
      localJSONObject.putOpt("send_listid", paramJSONObject.optString("send_listid"));
      localJSONObject.putOpt("amount", paramJSONObject.optString("amount"));
      localJSONObject.putOpt("feedsid", this.mapParams.get("feedsid"));
      localJSONObject.putOpt("channel", this.cfF + "");
      paramJSONObject = new JSONObject();
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        paramJSONObject.putOpt("resultCode", Integer.valueOf(0));
        paramJSONObject.putOpt("retmsg", "");
        paramJSONObject.putOpt("data", localJSONObject.toString());
        localIntent.putExtra("result", paramJSONObject.toString());
        localIntent.putExtra("callbackSn", this.np);
        localIntent.putExtra("PayInvokerId", 5);
        setResult(-1, localIntent);
        finish();
        return;
        paramJSONObject = paramJSONObject;
        paramJSONObject.printStackTrace();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  protected void aE(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("retmsg", paramJSONObject.toString());
    setResult(-1, localIntent);
    finish();
  }
  
  protected void aF(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("userId", this.mUin);
        ((JSONObject)localObject).put("viewTag", "qrcodeHb");
        ((JSONObject)localObject).put("comeForm", 2);
        JSONObject localJSONObject = new JSONObject();
        str = q(paramJSONObject);
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.putOpt("qrData", str);
        }
        localJSONObject.putOpt("comeFrom", Integer.valueOf(this.bdj));
        zV(paramJSONObject.optString("qr_token"));
        ((JSONObject)localObject).put("extra_data", localJSONObject.toString());
        paramJSONObject = new Bundle();
        paramJSONObject.putString("json", ((JSONObject)localObject).toString());
        paramJSONObject.putString("callbackSn", "0");
        paramJSONObject.putLong("vacreport_key_seq", this.mReportSeq);
        localObject = aagd.b(this.mapParams, "from_plugin", "");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          PayBridgeActivity.a(this, 5, paramJSONObject);
          finish();
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      if ("1".equals(localObject))
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("qrData", str);
        setResult(-1, paramJSONObject);
      }
    }
  }
  
  protected void aG(JSONObject paramJSONObject)
  {
    QLog.i("SendHbActivity", 2, "onFaceHbResult bundle_data = " + paramJSONObject);
    Object localObject = paramJSONObject.optJSONObject("data");
    if (localObject == null) {}
    for (;;)
    {
      QLog.i("SendHbActivity", 2, "onFaceHbResult final data = " + paramJSONObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("callbackSn", this.np);
      ((Intent)localObject).putExtra("PayInvokerId", 5);
      JSONObject localJSONObject = new JSONObject();
      label252:
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int i = paramJSONObject.optInt("retcode", -1);
          paramJSONObject.printStackTrace();
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            ((Intent)localObject).putExtra("result", i + "");
            ((Intent)localObject).putExtra("retmsg", paramJSONObject.optString("retmsg"));
            localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
            if (i == 0) {
              c(this.mUin, yv(), "bqredpacket.pay.expose", "", "");
            }
            QLog.i("SendHbActivity", 2, "onFaceHbResult back jdata = " + localJSONObject);
            ((Intent)localObject).putExtra("data", localJSONObject.toString());
            setResult(-1, (Intent)localObject);
            finish();
            return;
          }
          catch (Exception paramJSONObject)
          {
            break label252;
          }
          paramJSONObject = paramJSONObject;
          i = -1;
        }
      }
      paramJSONObject = (JSONObject)localObject;
    }
  }
  
  /* Error */
  protected void aH(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: iconst_2
    //   4: new 562	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 871
    //   14: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 853	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_1
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: new 873	java/lang/StringBuffer
    //   35: dup
    //   36: aload_1
    //   37: ldc_w 875
    //   40: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 880	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokespecial 881	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_1
    //   51: ldc_w 883
    //   54: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +17 -> 79
    //   65: aload_2
    //   66: ldc_w 885
    //   69: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   78: pop
    //   79: aload_1
    //   80: ldc_w 890
    //   83: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +17 -> 108
    //   94: aload_2
    //   95: ldc_w 892
    //   98: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: aload_2
    //   103: aload_3
    //   104: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   107: pop
    //   108: aload_1
    //   109: ldc_w 894
    //   112: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifne +17 -> 137
    //   123: aload_2
    //   124: ldc_w 896
    //   127: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   130: pop
    //   131: aload_2
    //   132: aload_3
    //   133: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload_1
    //   138: ldc_w 898
    //   141: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +17 -> 166
    //   152: aload_2
    //   153: ldc_w 900
    //   156: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: aload_2
    //   161: aload_1
    //   162: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   165: pop
    //   166: new 390	org/json/JSONObject
    //   169: dup
    //   170: invokespecial 743	org/json/JSONObject:<init>	()V
    //   173: astore_1
    //   174: new 390	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 743	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: aload_3
    //   183: ldc_w 875
    //   186: aload_2
    //   187: invokevirtual 901	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   190: invokevirtual 748	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload_1
    //   195: ldc_w 824
    //   198: iconst_0
    //   199: invokevirtual 753	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload_1
    //   204: ldc_w 811
    //   207: ldc_w 903
    //   210: invokevirtual 748	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload_1
    //   215: ldc_w 800
    //   218: aload_3
    //   219: invokevirtual 748	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: ldc_w 409
    //   226: iconst_2
    //   227: new 562	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 905
    //   237: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: invokevirtual 853	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: new 110	android/content/Intent
    //   253: dup
    //   254: invokespecial 111	android/content/Intent:<init>	()V
    //   257: astore_2
    //   258: aload_2
    //   259: ldc_w 529
    //   262: aload_0
    //   263: getfield 531	com/tencent/mobileqq/activity/qwallet/SendHbActivity:np	Ljava/lang/String;
    //   266: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   269: pop
    //   270: aload_2
    //   271: ldc 207
    //   273: iconst_5
    //   274: invokevirtual 809	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   277: pop
    //   278: aload_2
    //   279: ldc_w 806
    //   282: aload_1
    //   283: invokevirtual 763	org/json/JSONObject:toString	()Ljava/lang/String;
    //   286: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   289: pop
    //   290: aload_0
    //   291: iconst_m1
    //   292: aload_2
    //   293: invokevirtual 828	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   296: aload_0
    //   297: invokevirtual 296	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   300: return
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   306: return
    //   307: astore_2
    //   308: goto -85 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	SendHbActivity
    //   0	311	1	paramJSONObject	JSONObject
    //   49	244	2	localObject1	Object
    //   307	1	2	localException	Exception
    //   57	162	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	79	301	java/lang/Exception
    //   79	108	301	java/lang/Exception
    //   108	137	301	java/lang/Exception
    //   137	166	301	java/lang/Exception
    //   166	174	301	java/lang/Exception
    //   223	300	301	java/lang/Exception
    //   174	223	307	java/lang/Exception
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
  
  public void am(String paramString1, String paramString2, String paramString3)
  {
    aqha.a(this, 230, null, paramString1, paramString2, paramString3, new zzk(this), new zzl(this)).show();
  }
  
  public void c(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    aagd.a(this.app, paramString1, this.bdj, this.mAppInfo, this.mReportSeq, paramInt, paramString2, paramString3, paramString4);
  }
  
  public void csV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", -1);
      label17:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.np);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(0, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void csZ()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment = new QzoneHbFragment();
    Bundle localBundle = k();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment.setArguments(localBundle);
  }
  
  public void ctb()
  {
    this.intent.putExtra("hb_id", this.bbL);
    this.intent.putExtra("send_uin", this.mUin);
    this.intent.putExtra("hb_type", "1");
    this.intent.putExtra("forward_text", getString(2131699262));
    HashMap localHashMap = aagd.o((String)this.mapParams.get("selector"));
    int i = aagd.a(localHashMap, "type", 0);
    if (this.buK) {
      this.intent.putExtra("item", 1);
    }
    for (;;)
    {
      this.intent.putExtra("forward_type", 17);
      this.intent.putExtra("invoke_from", "qwallet");
      ahgq.P(this, this.intent);
      return;
      if ((this.hb_from_type.equals("100")) && (i == 1))
      {
        this.intent.putExtra("item", yw());
        this.intent.putExtra("title", aagd.b(localHashMap, "title", acfp.m(2131714295)));
      }
    }
  }
  
  protected void dZ(String paramString1, String paramString2)
  {
    int i = 1;
    QLog.i("SendHbActivity", 2, "sendConfirmRequest viewtag = " + paramString1 + " sp_data = " + paramString2);
    this.isConfirm = true;
    this.c = new QWalletPayProgressDialog(this);
    this.c.show();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("sp_data", paramString2);
        if (32768 == this.cfF)
        {
          if (this.bbD.equals("1"))
          {
            localJSONObject.put("channel", i);
            paramString2 = new JSONObject();
            paramString2.put("userId", this.mUin);
            paramString2.put("viewTag", paramString1);
            paramString2.put("comeForm", 2);
            paramString2.put("appInfo", this.mAppInfo);
            paramString2.put("extra_data", localJSONObject.toString());
            PayBridgeActivity.tenpay(this, paramString2.toString(), 5, "0");
          }
        }
        else
        {
          localJSONObject.put("channel", String.valueOf(this.cfF));
          continue;
        }
        i = 1024;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity doOnBackPressed...");
    setResult(0, new Intent());
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.mIntent = localIntent;
    localIntent.putExtra("fling_action_key", 0);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    try
    {
      csT();
      setProgressBarIndeterminateVisibility(false);
      setRequestedOrientation(1);
      setContentView(2131560726);
      initData();
      initView();
      csW();
      amK();
      QWalletHelper.preloadQWallet(this.app);
      if (QWalletHelper.isNeedPreConnect(this, this.mUin, "type_mqq_and_myun")) {
        csU();
      }
      return true;
    }
    catch (OutOfMemoryError paramBundle) {}
    return false;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Aabn.onDestroy();
    try
    {
      if (this.mReportSeq != 0L) {
        VACDReportUtil.endReport(this.mReportSeq, "hongbao.wrap.destroy", null, this.cfH, null);
      }
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
      this.mReceiver = null;
      unregisterReceiver(this.aT);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jg = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jg = false;
    c(this.mUin, yv(), "hongbao.wrap.show", "", "");
    setNightMaskVisible("1103".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Aabn.ctE();
  }
  
  public void e(CharSequence paramCharSequence)
  {
    if ((!this.jg) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).show(aj(this));
    }
  }
  
  public void k(CharSequence paramCharSequence)
  {
    e(paramCharSequence);
  }
  
  public void l(CharSequence paramCharSequence)
  {
    e(paramCharSequence);
  }
  
  public void m(CharSequence paramCharSequence)
  {
    e(paramCharSequence);
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: iconst_2
    //   4: new 562	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1115
    //   14: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_1
    //   18: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc_w 1117
    //   24: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: ldc_w 409
    //   40: iconst_2
    //   41: new 562	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 1119
    //   51: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 853	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 301	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   68: ifnull +13 -> 81
    //   71: aload_0
    //   72: getfield 301	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   75: iload_1
    //   76: iload_2
    //   77: aload_3
    //   78: invokevirtual 1121	com/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment:onActivityResult	(IILandroid/content/Intent;)V
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 1078	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jg	Z
    //   86: aload_3
    //   87: ifnull +1214 -> 1301
    //   90: iload_2
    //   91: iconst_m1
    //   92: if_icmpne +1209 -> 1301
    //   95: aload_3
    //   96: ldc_w 806
    //   99: invokevirtual 386	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 6
    //   104: aconst_null
    //   105: astore 5
    //   107: aload 6
    //   109: ifnull +205 -> 314
    //   112: aload 6
    //   114: invokevirtual 1124	java/lang/String:length	()I
    //   117: ifle +197 -> 314
    //   120: new 390	org/json/JSONObject
    //   123: dup
    //   124: aload 6
    //   126: invokespecial 391	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: astore 4
    //   131: ldc_w 409
    //   134: iconst_2
    //   135: new 562	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1126
    //   145: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 4
    //   150: invokevirtual 853	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 417	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 4
    //   161: ifnull +1153 -> 1314
    //   164: aload 4
    //   166: ldc_w 811
    //   169: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 5
    //   174: aload 4
    //   176: ldc_w 824
    //   179: iconst_m1
    //   180: invokevirtual 864	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   183: istore_2
    //   184: aload_0
    //   185: iload_2
    //   186: putfield 83	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfH	I
    //   189: aload 4
    //   191: ldc_w 800
    //   194: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore_3
    //   198: aload_3
    //   199: ifnull +126 -> 325
    //   202: aload_3
    //   203: invokevirtual 1124	java/lang/String:length	()I
    //   206: ifle +119 -> 325
    //   209: new 390	org/json/JSONObject
    //   212: dup
    //   213: aload_3
    //   214: invokespecial 391	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 83	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfH	I
    //   222: ifeq +44 -> 266
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 170	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mUin	Ljava/lang/String;
    //   230: aload_0
    //   231: invokevirtual 778	com/tencent/mobileqq/activity/qwallet/SendHbActivity:yv	()I
    //   234: new 562	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   241: aload 5
    //   243: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 1128
    //   249: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_2
    //   253: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: ldc 68
    //   261: ldc 68
    //   263: invokevirtual 781	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: getfield 1002	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   270: invokevirtual 1131	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   273: iload_2
    //   274: ifne +738 -> 1012
    //   277: aload_3
    //   278: ifnull +734 -> 1012
    //   281: iload_1
    //   282: lookupswitch	default:+26->308, 5:+48->330, 9:+419->701
    //   309: astore_3
    //   310: aload_3
    //   311: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   314: aconst_null
    //   315: astore 4
    //   317: goto -186 -> 131
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   325: aconst_null
    //   326: astore_3
    //   327: goto -109 -> 218
    //   330: aload_0
    //   331: getfield 997	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   334: ifeq +259 -> 593
    //   337: aload_0
    //   338: iconst_0
    //   339: putfield 997	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   342: aload_0
    //   343: iconst_m1
    //   344: putfield 74	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfG	I
    //   347: aload_3
    //   348: ldc_w 1133
    //   351: invokevirtual 1135	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   354: istore_1
    //   355: iconst_1
    //   356: iload_1
    //   357: if_icmpeq +8 -> 365
    //   360: iconst_2
    //   361: iload_1
    //   362: if_icmpne +168 -> 530
    //   365: aload_0
    //   366: getfield 549	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbE	Ljava/lang/String;
    //   369: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +67 -> 439
    //   375: aload_0
    //   376: getfield 243	com/tencent/mobileqq/activity/qwallet/SendHbActivity:rootView	Landroid/view/View;
    //   379: iconst_0
    //   380: invokevirtual 249	android/view/View:setVisibility	(I)V
    //   383: aload_0
    //   384: getfield 592	com/tencent/mobileqq/activity/qwallet/SendHbActivity:ai	Landroid/view/View;
    //   387: iconst_0
    //   388: invokevirtual 249	android/view/View:setVisibility	(I)V
    //   391: aload_0
    //   392: getfield 308	com/tencent/mobileqq/activity/qwallet/SendHbActivity:zd	Landroid/view/View;
    //   395: ifnull +13 -> 408
    //   398: aload_0
    //   399: getfield 308	com/tencent/mobileqq/activity/qwallet/SendHbActivity:zd	Landroid/view/View;
    //   402: ldc_w 306
    //   405: invokevirtual 1138	android/view/View:setBackgroundColor	(I)V
    //   408: aload_0
    //   409: aload_3
    //   410: ldc_w 818
    //   413: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   416: putfield 117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbL	Ljava/lang/String;
    //   419: aload_0
    //   420: aload_0
    //   421: getfield 170	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mUin	Ljava/lang/String;
    //   424: aload_0
    //   425: invokevirtual 778	com/tencent/mobileqq/activity/qwallet/SendHbActivity:yv	()I
    //   428: ldc_w 1140
    //   431: ldc 68
    //   433: ldc 68
    //   435: invokevirtual 781	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   438: return
    //   439: sipush 256
    //   442: aload_0
    //   443: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   446: if_icmpeq +68 -> 514
    //   449: sipush 128
    //   452: aload_0
    //   453: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   456: if_icmpeq +58 -> 514
    //   459: sipush 512
    //   462: aload_0
    //   463: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   466: if_icmpeq +48 -> 514
    //   469: sipush 2048
    //   472: aload_0
    //   473: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   476: if_icmpeq +38 -> 514
    //   479: aload_0
    //   480: getfield 1142	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aZ	Lorg/json/JSONObject;
    //   483: ifnull +828 -> 1311
    //   486: aload_0
    //   487: getfield 1142	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aZ	Lorg/json/JSONObject;
    //   490: astore_3
    //   491: aload_0
    //   492: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   495: sipush 16384
    //   498: if_icmpne +10 -> 508
    //   501: aload_0
    //   502: aload 4
    //   504: invokevirtual 1144	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aG	(Lorg/json/JSONObject;)V
    //   507: return
    //   508: aload_0
    //   509: aload_3
    //   510: invokevirtual 1146	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aH	(Lorg/json/JSONObject;)V
    //   513: return
    //   514: sipush 2048
    //   517: aload_0
    //   518: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   521: if_icmpne -213 -> 308
    //   524: aload_0
    //   525: aload_3
    //   526: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aF	(Lorg/json/JSONObject;)V
    //   529: return
    //   530: sipush 256
    //   533: aload_0
    //   534: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   537: if_icmpeq +22 -> 559
    //   540: sipush 128
    //   543: aload_0
    //   544: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   547: if_icmpeq +12 -> 559
    //   550: aload_0
    //   551: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   554: ldc 88
    //   556: if_icmpne +9 -> 565
    //   559: aload_0
    //   560: aload_3
    //   561: invokevirtual 1150	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aE	(Lorg/json/JSONObject;)V
    //   564: return
    //   565: sipush 512
    //   568: aload_0
    //   569: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   572: if_icmpne +9 -> 581
    //   575: aload_0
    //   576: aload_3
    //   577: invokevirtual 1152	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aD	(Lorg/json/JSONObject;)V
    //   580: return
    //   581: aload_0
    //   582: aload_0
    //   583: ldc_w 1153
    //   586: invokevirtual 325	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   589: invokevirtual 1110	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Ljava/lang/CharSequence;)V
    //   592: return
    //   593: bipush 64
    //   595: aload_0
    //   596: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   599: if_icmpeq +12 -> 611
    //   602: aload_0
    //   603: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   606: bipush 64
    //   608: if_icmpne +70 -> 678
    //   611: new 390	org/json/JSONObject
    //   614: dup
    //   615: invokespecial 743	org/json/JSONObject:<init>	()V
    //   618: astore 4
    //   620: aload 4
    //   622: ldc_w 1155
    //   625: aload_3
    //   626: ldc_w 1155
    //   629: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokevirtual 816	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   635: pop
    //   636: aload 4
    //   638: ldc 251
    //   640: aload_0
    //   641: getfield 70	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbJ	Ljava/lang/String;
    //   644: invokevirtual 816	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload_0
    //   649: iconst_m1
    //   650: aload_0
    //   651: iload_2
    //   652: ldc 68
    //   654: aload 4
    //   656: invokevirtual 763	org/json/JSONObject:toString	()Ljava/lang/String;
    //   659: invokevirtual 1157	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(ILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   662: invokevirtual 828	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   665: aload_0
    //   666: invokevirtual 296	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   669: return
    //   670: astore_3
    //   671: aload_3
    //   672: invokevirtual 773	org/json/JSONException:printStackTrace	()V
    //   675: goto -27 -> 648
    //   678: aload_0
    //   679: aload_3
    //   680: ldc_w 1159
    //   683: invokevirtual 1135	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   686: putfield 74	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfG	I
    //   689: aload_0
    //   690: aload_3
    //   691: ldc_w 1155
    //   694: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: invokespecial 1161	com/tencent/mobileqq/activity/qwallet/SendHbActivity:zW	(Ljava/lang/String;)V
    //   700: return
    //   701: aload_3
    //   702: ldc_w 875
    //   705: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   708: astore 4
    //   710: new 873	java/lang/StringBuffer
    //   713: dup
    //   714: invokespecial 1162	java/lang/StringBuffer:<init>	()V
    //   717: astore 5
    //   719: aload 5
    //   721: ldc_w 1164
    //   724: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   727: pop
    //   728: aload 5
    //   730: aload_0
    //   731: getfield 72	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbK	Ljava/lang/String;
    //   734: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   737: pop
    //   738: aload 5
    //   740: ldc_w 1166
    //   743: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: pop
    //   747: ldc 226
    //   749: aload_0
    //   750: getfield 316	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbD	Ljava/lang/String;
    //   753: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   756: ifne +42 -> 798
    //   759: ldc_w 318
    //   762: aload_0
    //   763: getfield 316	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbD	Ljava/lang/String;
    //   766: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   769: ifne +29 -> 798
    //   772: ldc_w 1168
    //   775: aload_0
    //   776: getfield 316	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbD	Ljava/lang/String;
    //   779: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   782: ifne +16 -> 798
    //   785: ldc_w 1170
    //   788: aload_0
    //   789: getfield 316	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbD	Ljava/lang/String;
    //   792: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifeq +147 -> 942
    //   798: aload 5
    //   800: ldc_w 1172
    //   803: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   806: pop
    //   807: aload 5
    //   809: ldc_w 1174
    //   812: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   815: pop
    //   816: aload 5
    //   818: aload_0
    //   819: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   822: invokevirtual 1177	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   825: pop
    //   826: aload 5
    //   828: ldc_w 1179
    //   831: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   834: pop
    //   835: aload 5
    //   837: aload_0
    //   838: getfield 70	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbJ	Ljava/lang/String;
    //   841: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   844: pop
    //   845: aload_0
    //   846: aload_0
    //   847: getfield 170	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mUin	Ljava/lang/String;
    //   850: aload_0
    //   851: invokevirtual 778	com/tencent/mobileqq/activity/qwallet/SendHbActivity:yv	()I
    //   854: ldc_w 1181
    //   857: aload 5
    //   859: invokevirtual 901	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   862: aconst_null
    //   863: invokevirtual 781	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 4
    //   868: ifnull -560 -> 308
    //   871: aload_0
    //   872: getfield 549	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbE	Ljava/lang/String;
    //   875: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   878: ifne +30 -> 908
    //   881: aload_0
    //   882: getfield 74	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfG	I
    //   885: iconst_1
    //   886: if_icmpeq +22 -> 908
    //   889: aload_0
    //   890: getfield 103	com/tencent/mobileqq/activity/qwallet/SendHbActivity:uT	Ljava/util/List;
    //   893: aload_0
    //   894: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   897: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: invokeinterface 371 2 0
    //   905: ifeq +85 -> 990
    //   908: aload_3
    //   909: ldc_w 883
    //   912: invokevirtual 407	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   915: astore 4
    //   917: sipush 2048
    //   920: aload_0
    //   921: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   924: if_icmpne +54 -> 978
    //   927: aload_0
    //   928: ldc_w 1183
    //   931: aload 4
    //   933: invokevirtual 1185	com/tencent/mobileqq/activity/qwallet/SendHbActivity:dZ	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: aload_0
    //   937: aload_3
    //   938: putfield 1142	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aZ	Lorg/json/JSONObject;
    //   941: return
    //   942: ldc 205
    //   944: aload_0
    //   945: getfield 316	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbD	Ljava/lang/String;
    //   948: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   951: ifeq +15 -> 966
    //   954: aload 5
    //   956: ldc_w 1187
    //   959: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   962: pop
    //   963: goto -156 -> 807
    //   966: aload 5
    //   968: ldc_w 1189
    //   971: invokevirtual 888	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   974: pop
    //   975: goto -168 -> 807
    //   978: aload_0
    //   979: ldc_w 1191
    //   982: aload 4
    //   984: invokevirtual 1185	com/tencent/mobileqq/activity/qwallet/SendHbActivity:dZ	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: goto -51 -> 936
    //   990: aload_0
    //   991: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   994: sipush 16384
    //   997: if_icmpne +9 -> 1006
    //   1000: aload_0
    //   1001: aload_3
    //   1002: invokevirtual 1144	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aG	(Lorg/json/JSONObject;)V
    //   1005: return
    //   1006: aload_0
    //   1007: aload_3
    //   1008: invokevirtual 1146	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aH	(Lorg/json/JSONObject;)V
    //   1011: return
    //   1012: iload_2
    //   1013: ifle +213 -> 1226
    //   1016: aload_0
    //   1017: getfield 997	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   1020: ifeq +51 -> 1071
    //   1023: sipush 256
    //   1026: aload_0
    //   1027: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   1030: if_icmpeq +13 -> 1043
    //   1033: sipush 128
    //   1036: aload_0
    //   1037: getfield 290	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cfF	I
    //   1040: if_icmpne +81 -> 1121
    //   1043: new 110	android/content/Intent
    //   1046: dup
    //   1047: invokespecial 111	android/content/Intent:<init>	()V
    //   1050: astore_3
    //   1051: aload_3
    //   1052: ldc_w 811
    //   1055: aload 6
    //   1057: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1060: pop
    //   1061: aload_0
    //   1062: iconst_m1
    //   1063: aload_3
    //   1064: invokevirtual 828	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1067: aload_0
    //   1068: invokevirtual 296	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   1071: aload_0
    //   1072: ldc_w 1192
    //   1075: invokevirtual 325	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1078: astore_3
    //   1079: iload_2
    //   1080: ldc_w 1193
    //   1083: if_icmpne +66 -> 1149
    //   1086: aload_0
    //   1087: sipush 230
    //   1090: aconst_null
    //   1091: aload 5
    //   1093: aconst_null
    //   1094: aload_0
    //   1095: ldc_w 1194
    //   1098: invokevirtual 325	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1101: new 1196	zzi
    //   1104: dup
    //   1105: aload_0
    //   1106: invokespecial 1197	zzi:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1109: aconst_null
    //   1110: invokestatic 944	aqha:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   1113: invokevirtual 948	aqju:show	()V
    //   1116: aload_0
    //   1117: invokespecial 120	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cta	()V
    //   1120: return
    //   1121: aload_0
    //   1122: getfield 549	com/tencent/mobileqq/activity/qwallet/SendHbActivity:bbE	Ljava/lang/String;
    //   1125: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1128: ifne -57 -> 1071
    //   1131: aload_0
    //   1132: getfield 1142	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aZ	Lorg/json/JSONObject;
    //   1135: ifnull -64 -> 1071
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield 1142	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aZ	Lorg/json/JSONObject;
    //   1143: invokevirtual 1146	com/tencent/mobileqq/activity/qwallet/SendHbActivity:aH	(Lorg/json/JSONObject;)V
    //   1146: goto -75 -> 1071
    //   1149: iload_2
    //   1150: ldc_w 1198
    //   1153: if_icmpne +51 -> 1204
    //   1156: aload 5
    //   1158: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1161: ifne +43 -> 1204
    //   1164: aload_0
    //   1165: invokevirtual 1103	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isFinishing	()Z
    //   1168: ifne -52 -> 1116
    //   1171: aload_0
    //   1172: sipush 230
    //   1175: aconst_null
    //   1176: aload 5
    //   1178: aconst_null
    //   1179: aload_0
    //   1180: ldc_w 1199
    //   1183: invokevirtual 325	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1186: new 1201	zzj
    //   1189: dup
    //   1190: aload_0
    //   1191: invokespecial 1202	zzj:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1194: aconst_null
    //   1195: invokestatic 944	aqha:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   1198: invokevirtual 948	aqju:show	()V
    //   1201: goto -85 -> 1116
    //   1204: aload 5
    //   1206: ifnull +12 -> 1218
    //   1209: aload_0
    //   1210: aload 5
    //   1212: invokevirtual 1110	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Ljava/lang/CharSequence;)V
    //   1215: goto -99 -> 1116
    //   1218: aload_0
    //   1219: aload_3
    //   1220: invokevirtual 1110	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Ljava/lang/CharSequence;)V
    //   1223: goto -107 -> 1116
    //   1226: iload_2
    //   1227: bipush 246
    //   1229: if_icmpge +35 -> 1264
    //   1232: aload_0
    //   1233: new 562	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 563	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 1203
    //   1243: invokestatic 990	acfp:m	(I)Ljava/lang/String;
    //   1246: invokevirtual 569	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: iload_2
    //   1250: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokevirtual 1110	com/tencent/mobileqq/activity/qwallet/SendHbActivity:e	(Ljava/lang/CharSequence;)V
    //   1259: aload_0
    //   1260: invokespecial 120	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cta	()V
    //   1263: return
    //   1264: new 110	android/content/Intent
    //   1267: dup
    //   1268: invokespecial 111	android/content/Intent:<init>	()V
    //   1271: astore_3
    //   1272: aload_3
    //   1273: ldc 207
    //   1275: iconst_5
    //   1276: invokevirtual 809	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload_3
    //   1281: ldc_w 806
    //   1284: aload 6
    //   1286: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1289: pop
    //   1290: aload_0
    //   1291: iconst_m1
    //   1292: aload_3
    //   1293: invokevirtual 828	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1296: aload_0
    //   1297: invokespecial 120	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cta	()V
    //   1300: return
    //   1301: aload_0
    //   1302: invokespecial 120	com/tencent/mobileqq/activity/qwallet/SendHbActivity:cta	()V
    //   1305: return
    //   1306: astore 7
    //   1308: goto -1035 -> 273
    //   1311: goto -820 -> 491
    //   1314: aconst_null
    //   1315: astore_3
    //   1316: goto -1050 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1319	0	this	SendHbActivity
    //   0	1319	1	paramInt1	int
    //   0	1319	2	paramInt2	int
    //   0	1319	3	paramIntent	Intent
    //   129	854	4	localObject1	Object
    //   105	1106	5	localObject2	Object
    //   102	1183	6	str	String
    //   1306	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   120	131	309	java/lang/Exception
    //   209	218	320	java/lang/Exception
    //   620	648	670	org/json/JSONException
    //   266	273	1306	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131377992)
    {
      c(this.mUin, yv(), "hongbao.wrapped.send", "", "");
      ctb();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131377991)
      {
        String str2 = getString(2131699128) + getString(2131698807);
        String str1 = getString(2131699082);
        if (this.buK)
        {
          str2 = getString(2131699128);
          str1 = getString(2131698889);
        }
        am(str2, str1, getString(2131699131));
        if (this.buL) {
          c(this.mUin, yv(), "hongbao.wrapped.keyback", "", "");
        } else {
          c(this.mUin, yv(), "hongbao.wrapped.close", "", "");
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity onKeyDown keyCode = " + paramInt + " event = " + paramKeyEvent);
    if (paramInt == 4)
    {
      this.buL = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment instanceof SendHbMainFragment)) {
          ((SendHbMainFragment)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment).ctr();
        }
        zY("theme.pack.keyback");
        csV();
        this.cfH = -1;
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public String q(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wishing", paramJSONObject.optString("wishing"));
      localJSONObject.put("total_num", paramJSONObject.optString("total_num"));
      localJSONObject.put("recv_num", paramJSONObject.optString("recv_num"));
      localJSONObject.put("qr_data", paramJSONObject.optString("qr_data"));
      localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
      paramJSONObject = new JSONArray();
      paramJSONObject.put(localJSONObject);
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s(int paramInt1, String paramString, int paramInt2)
  {
    c(this.mUin, paramInt1, paramString, "", "");
  }
  
  public void s(String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    if ("2".equals(paramString)) {
      localIntent.putExtra("param_only_discussion_member", true);
    }
    for (;;)
    {
      localIntent.putExtra("param_title", getString(2131698878));
      localIntent.putExtra("param_min", 0);
      localIntent.putExtra("param_done_button_wording", getString(2131719437));
      localIntent.putExtra("param_done_button_highlight_wording", getString(2131719438));
      localIntent.putExtra("param_max", 5);
      localIntent.putExtra("param_entrance", 25);
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label210;
      }
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        new ResultRecord().uin = str;
        paramString.add(SelectMemberActivity.a(str, "", 0, this.mUin));
      }
      if ("3".equals(paramString)) {
        localIntent.putExtra("param_only_troop_member", true);
      }
    }
    localIntent.putExtra("param_selected_records_for_create_discussion", paramString);
    label210:
    localIntent.putExtra("group_uin", this.bbE);
    paramString = getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new ArrayList();
      paramArrayList.add(paramString);
      localIntent.putExtra("param_uins_hide", paramArrayList);
    }
    startActivityForResult(localIntent, 1024);
  }
  
  public int yv()
  {
    int i;
    if (this.buJ) {
      i = 131;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbActivity", 2, "getProcessType: processFlag:" + i);
      }
      return i;
      if (TextUtils.isEmpty(this.bbD))
      {
        if (avox.LH.contains(this.bbD)) {
          i = 133;
        } else {
          i = 132;
        }
      }
      else {
        i = 499;
      }
    }
  }
  
  public int yw()
  {
    String str = aagd.b(aagd.o((String)this.mapParams.get("selector")), "friend_type", "1");
    int i = 0;
    if (str.equals("1")) {
      i = 1;
    }
    do
    {
      return i;
      if (str.equals("2")) {
        return 16;
      }
      if (str.equals("3")) {
        return 256;
      }
      if (str.equals("1|2")) {
        return 17;
      }
      if (str.equals("1|3")) {
        return 257;
      }
      if (str.equals("2|3")) {
        return 272;
      }
    } while (!str.equals("1|2|3"));
    return 273;
  }
  
  public void zV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QWalletHelper.saveQRTokenConfig(this, paramString, this.mUin);
  }
  
  public void zX(String paramString)
  {
    this.bbJ = paramString;
    try
    {
      Object localObject = Y();
      ((Map)localObject).put("total_num", aagd.b(this.mapParams, "total_num", "1"));
      ((Map)localObject).put("total_amount", hX(paramString));
      ((Map)localObject).put("channel", String.valueOf(this.cfF));
      ((Map)localObject).put("recv_uin", this.bbE);
      ((Map)localObject).put("bus_type", this.mapParams.get("bus_type"));
      ((Map)localObject).put("recv_type", "1");
      ((Map)localObject).put("type", "1");
      paramString = Z();
      paramString.put("extra_data", new JSONObject((Map)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", new JSONObject(paramString).toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.a(this, 5, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void zY(String paramString)
  {
    c(this.mUin, yv(), paramString, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */