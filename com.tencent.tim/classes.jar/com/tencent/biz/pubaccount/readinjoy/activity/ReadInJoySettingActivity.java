package com.tencent.biz.pubaccount.readinjoy.activity;

import acbn;
import acje;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqfo;
import arhz;
import ausj;
import auss;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import java.util.List;
import jnm;
import jnm.d;
import kbp;
import kbs;
import kgw;
import kip;
import kiq;
import kir;
import kis;
import kit;
import kiu;
import kiv;
import kiw;
import kix;
import kiy;
import kiz;
import kja;
import kjb;
import kjc;
import kjd;
import kxm;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import obt;
import obt.a;
import ocp;
import odj;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoRsp;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String UIN = acbn.blw;
  private ausj A;
  private final String ZA = "";
  private final String ZB = "";
  private final String ZC = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  private String Zs = "QQ看点";
  private final String Zt = "";
  private final String Zu = "";
  private final String Zv = "";
  private final String Zw = "";
  private final String Zx = "";
  private final String Zy = "";
  private final String Zz = "";
  private DialogInterface.OnKeyListener a = new kiw(this);
  public int aDG;
  private int aJk = 2;
  public int aJl;
  private boolean afA;
  private boolean afB;
  private boolean afC;
  private boolean afD;
  private boolean afE;
  private boolean afF;
  public boolean afG;
  protected boolean afH;
  public boolean afI;
  private boolean afJ;
  private boolean afz;
  public QQAppInterface app;
  private acje b = new kjd(this);
  private String[] bg;
  private KandianMergeManager c;
  Calendar calendar = Calendar.getInstance();
  private LinearLayout dt;
  View jE;
  private View jF;
  private View jG;
  private CompoundButton.OnCheckedChangeListener l;
  public Context mContext;
  public Handler mHandler = new Handler();
  Intent mIntent;
  public arhz mProgress;
  public Resources mRes;
  private TextView nU;
  private Switch p;
  private Switch q;
  private Switch r;
  private Switch s;
  private Switch t;
  private ausj y;
  private ausj z;
  
  private void aDu()
  {
    this.l = new kjc(this);
    if (((Integer)awit.f("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.afC = bool;
      this.afD = this.afC;
      this.r = ((Switch)findViewById(2131382407));
      this.r.setChecked(this.afC);
      this.r.setOnCheckedChangeListener(this.l);
      return;
    }
  }
  
  private void aDv()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.y != null) {
      return;
    }
    String str = String.format("", new Object[] { this.Zs });
    this.y = ((ausj)auss.a(this, null));
    this.y.setMainTitle(str);
    this.y.addButton("", 3);
    this.y.addCancelButton(2131721058);
    this.y.a(new kiq(this));
    this.y.a(new kir(this));
    this.y.setOnKeyListener(this.a);
  }
  
  private void aDw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.z != null) {
      return;
    }
    String str = String.format("", new Object[] { this.Zs });
    this.z = ((ausj)auss.a(this, null));
    this.z.setMainTitle(str);
    this.z.addButton(String.format("", new Object[] { this.Zs }), 3);
    this.z.addCancelButton(2131721058);
    this.z.a(new kis(this));
    this.z.a(new kit(this));
  }
  
  private Drawable ak()
  {
    obt.a locala = obt.a(this.app, this.mContext, 3);
    if ((locala != null) && (locala.getIcon() != null)) {
      return locala.getIcon();
    }
    return obt.g(this.mContext, 3);
  }
  
  private void init()
  {
    boolean bool2 = true;
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new ReadInJoyNewFeedsTopGestureLayout(this));
    }
    this.mContext = this.app.getApplication().getApplicationContext();
    this.mRes = this.app.getApplication().getResources();
    this.c = ((KandianMergeManager)this.app.getManager(162));
    this.afz = this.c.Bx();
    this.afA = this.c.By();
    this.afB = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.afF = awit.aMG();
    boolean bool1;
    if (!awit.cC(this.app)) {
      bool1 = true;
    }
    for (;;)
    {
      this.afE = bool1;
      try
      {
        if (kxm.iP() != null) {
          this.aJk = Integer.parseInt(kxm.iP());
        }
        label183:
        this.Zs = obt.a(this.app, this.mContext, 3);
        Object localObject = ak();
        ((ImageView)findViewById(2131368698)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131372208);
        ((TextView)localObject).setText(this.Zs);
        ((TextView)localObject).setContentDescription(this.Zs);
        localObject = (TextView)findViewById(2131365742);
        ((TextView)localObject).setText(String.format("", new Object[] { this.Zs }));
        ((TextView)localObject).setContentDescription(String.format("", new Object[] { this.Zs }));
        ml(this.afE);
        localObject = (TextView)findViewById(2131376887);
        ((TextView)localObject).setText(String.format("", new Object[] { this.Zs }));
        ((TextView)localObject).setContentDescription(String.format("", new Object[] { this.Zs }));
        aDw();
        aDv();
        pd(this.aJk);
        this.mProgress = new arhz(this, super.getTitleBarHeight());
        this.mProgress.setCanceledOnTouchOutside(true);
        this.mProgress.a(new kip(this));
        this.q = ((Switch)findViewById(2131373276));
        this.q.setChecked(this.afB);
        this.q.setOnCheckedChangeListener(new kix(this));
        this.t = ((Switch)findViewById(2131381393));
        this.dt = ((LinearLayout)findViewById(2131370762));
        localObject = this.dt;
        int i;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          i = 0;
          label514:
          ((LinearLayout)localObject).setVisibility(i);
          localObject = this.t;
          if (odj.rh() != 0) {
            break label928;
          }
          bool1 = true;
          label534:
          ((Switch)localObject).setChecked(bool1);
          this.t.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718548)));
          ((TextView)findViewById(2131380631)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718548)));
          this.t.setOnCheckedChangeListener(new kiy(this));
          kbp.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          aDu();
          this.nU = ((TextView)findViewById(2131370020));
          this.s = ((Switch)findViewById(2131378302));
          this.s.setChecked(this.afF);
          this.s.setOnCheckedChangeListener(new kiz(this));
          if (!this.afF) {
            break label933;
          }
          this.nU.setText(2131718532);
          label711:
          this.jF = findViewById(2131369325);
          this.jF.setOnClickListener(this);
          this.jG = findViewById(2131378472);
          this.jG.setOnClickListener(this);
          findViewById(2131381803).setOnClickListener(this);
          this.bg = new String[] { this.mRes.getString(2131701918), this.mRes.getString(2131701920), this.mRes.getString(2131701919) };
          ((TextView)findViewById(2131373274)).setText(this.bg[this.aJk]);
          bool1 = ThemeUtil.isInNightMode(this.app);
          this.jE = findViewById(2131374735);
          if (!bool1) {
            break label946;
          }
          if (this.jE != null) {
            this.jE.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!awit.t(this.app)) {
            break label965;
          }
          localObject = findViewById(2131376758);
          ((View)localObject).setVisibility(0);
          ((View)localObject).setOnClickListener(new kja(this));
          this.app.addObserver(this.b);
          return;
          bool1 = false;
          break;
          i = 8;
          break label514;
          label928:
          bool1 = false;
          break label534;
          label933:
          this.nU.setText(2131718535);
          break label711;
          label946:
          if (this.jE != null) {
            this.jE.setVisibility(8);
          }
        }
        label965:
        findViewById(2131376886).setVisibility(0);
        localObject = (TextView)findViewById(2131376889);
        ((TextView)localObject).setText("");
        ((TextView)localObject).setContentDescription("");
        this.p = ((Switch)findViewById(2131370022));
        localObject = this.p;
        if (!this.afz) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((Switch)localObject).setChecked(bool1);
          this.p.setOnCheckedChangeListener(new kjb(this));
          break;
        }
      }
      catch (Exception localException)
      {
        break label183;
      }
    }
  }
  
  private void mf(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("uin", localQQAppInterface.getCurrentAccountUin());
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        localJSONObject2.put("state", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoySettingActivity", 2, "report youngster switch click" + localJSONException.toString());
        continue;
      }
      kbp.a(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
      return;
      i = 0;
    }
  }
  
  private void mg(boolean paramBoolean)
  {
    QLog.e("ReadInJoySettingActivity", 2, "requestChangeYoungsterMode, value = " + paramBoolean);
    oidb_0xe1b.ReqBody localReqBody = new oidb_0xe1b.ReqBody();
    localReqBody.uint32_req_type.set(2);
    oidb_0xe1b.SetFlagInfoReq localSetFlagInfoReq = new oidb_0xe1b.SetFlagInfoReq();
    flag_info.FlagInfo localFlagInfo = new flag_info.FlagInfo();
    localFlagInfo.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    if (paramBoolean) {
      localFlagInfo.uint32_teenager_flag.set(1);
    }
    for (;;)
    {
      localSetFlagInfoReq.rpt_msg_flag_info_list.add(localFlagInfo);
      localReqBody.msg_set_flag_info_req.set(localSetFlagInfoReq);
      jnm.a((QQAppInterface)getAppInterface(), new a(paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
      return;
      localFlagInfo.uint32_teenager_flag.set(0);
    }
  }
  
  private void mh(boolean paramBoolean)
  {
    this.aJl += 1;
    this.afH = true;
    this.afG = true;
    oq(2131701903);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), kbs.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(ocp.getVersionInfo());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.aJl);
      kbs.aL(localNewIntent);
      this.aDG += 1;
      this.app.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void mj(boolean paramBoolean)
  {
    if (paramBoolean) {
      kbp.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", kxm.iQ(), false);
    }
    SettingCloneUtil.writeValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void mk(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.app;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      awit.ar(localQQAppInterface, bool);
      this.afz = paramBoolean;
      mh(this.afz);
      if (!paramBoolean) {
        break;
      }
      ml(paramBoolean);
      this.p.setChecked(this.afz);
      anot.a(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    kbp.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", kxm.iQ(), false);
    kbp.d("0X80067F9", "", "", "", "", kxm.iQ());
    ml(paramBoolean);
  }
  
  private void ml(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131378119);
    TextView localTextView = (TextView)findViewById(2131378733);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  private void pd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.A != null) {
      return;
    }
    this.A = ((ausj)auss.a(this, null));
    this.A.addRadioButton(this.mRes.getString(2131701918), 5, false);
    this.A.addRadioButton(this.mRes.getString(2131701920), 5, false);
    this.A.addRadioButton(this.mRes.getString(2131701919), 5, false);
    this.A.setRadioButtonChecked(paramInt);
    this.A.addCancelButton(2131721058);
    this.A.a(new kiu(this));
    this.A.a(new kiv(this));
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label172;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label151:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label172:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!aqfo.isFlyme())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560475);
    this.mIntent = getIntent();
    init();
    if (!ThemeUtil.isInNightMode(this.app)) {
      aDb();
    }
    this.afJ = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.y != null) && (this.y.isShowing()))
    {
      this.y.dismiss();
      this.y = null;
    }
    if ((this.z != null) && (this.z.isShowing()))
    {
      this.z.dismiss();
      this.z = null;
    }
    if ((this.A != null) && (this.A.isShowing()))
    {
      this.A.dismiss();
      this.A = null;
    }
    super.doOnDestroy();
    this.mProgress = null;
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app != null) {
      this.app.removeObserver(this.b);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.afC != this.afD) {
      awit.H("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.afJ)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      this.afJ = false;
    }
  }
  
  public void mi(boolean paramBoolean)
  {
    Switch localSwitch = this.p;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.afJ = true;
      awit.eW(this.app);
      kgw.bM(this);
      kbp.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", kxm.iQ(), false);
      continue;
      this.A.show();
      continue;
      kgw.L(this.mContentView.getContext(), 1);
    }
  }
  
  protected void oq(int paramInt)
  {
    this.jF.postDelayed(new ReadInJoySettingActivity.9(this, paramInt), 500L);
  }
  
  public boolean zu()
  {
    return this.afH;
  }
  
  class a
    extends jnm.d
  {
    private boolean afK;
    
    a(boolean paramBoolean)
    {
      this.afK = paramBoolean;
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      if ((paramInt != 0) || (paramArrayOfByte == null)) {}
      label72:
      int i;
      label151:
      int j;
      try
      {
        QQToast.a(ReadInJoySettingActivity.this.getApplicationContext(), 2131718573, 0).show();
        paramArrayOfByte = ReadInJoySettingActivity.this;
        if (this.afK) {
          break label492;
        }
        bool1 = true;
        ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
        paramArrayOfByte = ReadInJoySettingActivity.b(ReadInJoySettingActivity.this);
        if (this.afK) {
          break label498;
        }
        bool1 = bool2;
        paramArrayOfByte.setChecked(bool1);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          break label491;
        }
      }
      paramBundle = new oidb_0xe1b.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((paramBundle.msg_set_flag_info_rsp.has()) && (paramBundle.msg_set_flag_info_rsp.rpt_msg_flag_info_list.has()))
      {
        paramArrayOfByte = ((oidb_0xe1b.SetFlagInfoRsp)paramBundle.msg_set_flag_info_rsp.get()).rpt_msg_flag_info_list.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty())) {
          break label513;
        }
        i = 0;
        paramInt = 0;
        j = paramInt;
        if (i < paramArrayOfByte.size())
        {
          paramBundle = (flag_info.FlagInfo)paramArrayOfByte.get(i);
          if (paramBundle == null) {
            break label488;
          }
          paramInt = paramBundle.uint32_teenager_flag.get();
          break label504;
        }
        label192:
        if ((this.afK) && (j == 1))
        {
          QQToast.a(ReadInJoySettingActivity.this.getApplicationContext(), 2131718575, 0).show();
          awit.H("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
          ReadInJoySettingActivity.d(ReadInJoySettingActivity.this, true);
          return;
          QLog.d("ReadInJoySettingActivity", 2, "requestChangeYoungsterMode, value = " + this.afK + "failed.");
          return;
        }
        if ((!this.afK) && (j == 0))
        {
          QQToast.a(ReadInJoySettingActivity.this.getApplicationContext(), 2131718574, 0).show();
          awit.H("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
          ReadInJoySettingActivity.d(ReadInJoySettingActivity.this, false);
          return;
        }
        QQToast.a(ReadInJoySettingActivity.this.getApplicationContext(), 2131718573, 0).show();
        paramArrayOfByte = ReadInJoySettingActivity.this;
        if (j != 1) {
          break label519;
        }
      }
      for (;;)
      {
        ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
        ReadInJoySettingActivity.b(ReadInJoySettingActivity.this).setChecked(ReadInJoySettingActivity.c(ReadInJoySettingActivity.this));
        if (ReadInJoySettingActivity.c(ReadInJoySettingActivity.this))
        {
          awit.H("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
          return;
        }
        awit.H("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
        return;
        QQToast.a(ReadInJoySettingActivity.this.getApplicationContext(), 2131718573, 0).show();
        paramArrayOfByte = ReadInJoySettingActivity.this;
        if (!this.afK)
        {
          bool1 = true;
          ReadInJoySettingActivity.d(paramArrayOfByte, bool1);
          paramArrayOfByte = ReadInJoySettingActivity.b(ReadInJoySettingActivity.this);
          if (this.afK) {
            break label482;
          }
        }
        label482:
        for (bool1 = true;; bool1 = false)
        {
          paramArrayOfByte.setChecked(bool1);
          return;
          bool1 = false;
          break;
        }
        label488:
        break label504;
        label491:
        return;
        label492:
        bool1 = false;
        break;
        label498:
        bool1 = false;
        break label72;
        label504:
        i += 1;
        break label151;
        label513:
        j = 0;
        break label192;
        label519:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */