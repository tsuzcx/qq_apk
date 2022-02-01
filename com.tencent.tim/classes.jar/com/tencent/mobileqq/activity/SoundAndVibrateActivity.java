package com.tencent.mobileqq.activity;

import accp;
import aean;
import aean.a;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import anot;
import aqlz;
import aqnm;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import vuw;
import vux;
import vuy;
import vuz;
import vva;
import vvb;
import vvc;
import vvd;
import vve;
import vvf;
import vvg;
import vvh;
import vvi;
import vvj;
import vvk;
import vvl;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
  implements aean.a
{
  public static String aQc = "user_choose_";
  public static int bAf = AppSetting.bAf;
  public static int bAg = AppSetting.bAg;
  private TextView FN;
  private FormSwitchItem Y;
  aean a;
  private FormSwitchItem aD;
  private FormSwitchItem aE;
  public FormSwitchItem aF;
  public FormSwitchItem aG;
  private FormSwitchItem aH;
  private FormSwitchItem aI;
  private FormSwitchItem ae;
  private FormSimpleItem aj;
  private FormSimpleItem ak;
  private FormSimpleItem al;
  private FormSimpleItem am;
  private FormSimpleItem an;
  FormSimpleItem ao;
  private FormSimpleItem ap;
  private final int bKJ = 1;
  private final int bKK = 0;
  private final int bKL = 1;
  private final int bKM = 2;
  private final int bKN = 3;
  private final int bKO = 4;
  private MediaPlayer d;
  float density;
  private HashMap<Integer, a> gE = new HashMap();
  View uP;
  
  private void BB(int paramInt)
  {
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      aqnm.setVisible(this.aG, 0);
      return;
    }
    aqnm.setVisible(this.aG, 8);
  }
  
  private void BD(int paramInt)
  {
    Iterator localIterator = this.gE.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.id == paramInt)
      {
        locala.bav = true;
        int i = this.a.Ce();
        this.a.a(this.ap, i);
        this.ap.setRightTextColor(1);
      }
      else
      {
        locala.bav = false;
      }
    }
  }
  
  private void bVx()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (aqlz.ai(this.app) == 0)
    {
      localFormSwitchItem = this.aH;
      if (this.app.AI() != 0) {}
      for (;;)
      {
        localFormSwitchItem.setChecked(bool1);
        if (AppSetting.enableTalkBack)
        {
          if (!this.aH.isChecked()) {
            break;
          }
          this.aH.a().setContentDescription(getString(2131720419));
        }
        return;
        bool1 = false;
      }
    }
    FormSwitchItem localFormSwitchItem = this.aH;
    if (aqlz.ai(this.app) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      break;
    }
    this.aH.a().setContentDescription(getString(2131720418));
  }
  
  private void bVy()
  {
    startActivity(new Intent(getActivity(), SpecailCareListActivity.class));
  }
  
  private void sz()
  {
    a locala1 = new a(0, getResources().getString(2131720389), false);
    a locala2 = new a(1, getResources().getString(2131720390), false);
    a locala3 = new a(2, getResources().getString(2131720391), false);
    a locala4 = new a(3, getResources().getString(2131720392), false);
    a locala5 = new a(2131372769, getResources().getString(2131691040), false);
    this.gE.put(Integer.valueOf(0), locala1);
    this.gE.put(Integer.valueOf(1), locala2);
    this.gE.put(Integer.valueOf(2), locala3);
    this.gE.put(Integer.valueOf(3), locala4);
    this.gE.put(Integer.valueOf(4), locala5);
  }
  
  private void u(TextView paramTextView)
  {
    String str1 = getResources().getString(2131720015);
    int i = paramTextView.getCurrentTextColor();
    String str2 = paramTextView.getText() + str1;
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new vvd(this), str2.length() - str1.length(), str2.length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void wy(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      Intent localIntent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
      localIntent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
      localIntent.putExtra("android.provider.extra.CHANNEL_ID", paramString);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "go to channel setting  notificationChannelId: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        try
        {
          paramString = new Intent();
          paramString.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          paramString.setData(Uri.fromParts("package", getPackageName(), null));
          startActivity(paramString);
          if (QLog.isColorLevel())
          {
            QLog.d("IphoneTitleBarActivity", 2, "go to system setting");
            return;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          QLog.e("IphoneTitleBarActivity", 2, "go to setting fail");
        }
      }
    }
  }
  
  private void xZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aqlz.R(this.app, 1);
      if (AppSetting.enableTalkBack) {
        this.aH.a().setContentDescription(getString(2131720419));
      }
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    aqlz.R(this.app, 2);
    if (AppSetting.enableTalkBack) {
      this.aH.a().setContentDescription(getString(2131720418));
    }
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  public void BC(int paramInt)
  {
    this.a.a(this.ap, paramInt);
  }
  
  public void bVz()
  {
    if ((this.d != null) && (this.d.isPlaying())) {
      this.d.stop();
    }
  }
  
  /* Error */
  public void d(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 411	android/media/MediaPlayer
    //   11: dup
    //   12: invokespecial 421	android/media/MediaPlayer:<init>	()V
    //   15: putfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   18: aconst_null
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +22 -> 48
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 423	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 424	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: return
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   47: return
    //   48: aload_0
    //   49: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   52: invokevirtual 428	android/media/MediaPlayer:reset	()V
    //   55: aload_1
    //   56: invokevirtual 431	android/net/Uri:getScheme	()Ljava/lang/String;
    //   59: ldc_w 433
    //   62: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +106 -> 171
    //   68: new 439	java/io/FileInputStream
    //   71: dup
    //   72: new 441	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokevirtual 444	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: invokespecial 445	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 448	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: aload_1
    //   88: astore_2
    //   89: aload_1
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   95: aload_1
    //   96: invokevirtual 452	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   99: invokevirtual 456	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   102: aload_1
    //   103: astore_2
    //   104: aload_1
    //   105: astore_3
    //   106: aload_0
    //   107: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   110: iconst_3
    //   111: invokevirtual 459	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   114: aload_1
    //   115: astore_2
    //   116: aload_1
    //   117: astore_3
    //   118: aload_0
    //   119: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   122: invokevirtual 462	android/media/MediaPlayer:prepare	()V
    //   125: aload_1
    //   126: astore_2
    //   127: aload_1
    //   128: astore_3
    //   129: aload_1
    //   130: invokevirtual 465	java/io/FileInputStream:close	()V
    //   133: aload_1
    //   134: astore_2
    //   135: aload_1
    //   136: astore_3
    //   137: aload_0
    //   138: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   141: invokevirtual 468	android/media/MediaPlayer:start	()V
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   152: iconst_0
    //   153: invokevirtual 471	android/media/MediaPlayer:setLooping	(Z)V
    //   156: aload_1
    //   157: ifnull -116 -> 41
    //   160: aload_1
    //   161: invokevirtual 465	java/io/FileInputStream:close	()V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   170: return
    //   171: aload_0
    //   172: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual 474	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   180: aload_0
    //   181: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   184: iconst_3
    //   185: invokevirtual 459	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   188: aload_0
    //   189: getfield 409	com/tencent/mobileqq/activity/SoundAndVibrateActivity:d	Landroid/media/MediaPlayer;
    //   192: invokevirtual 462	android/media/MediaPlayer:prepare	()V
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -64 -> 133
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_3
    //   204: ifnull -163 -> 41
    //   207: aload_3
    //   208: invokevirtual 465	java/io/FileInputStream:close	()V
    //   211: return
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_1
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 465	java/io/FileInputStream:close	()V
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   234: goto -7 -> 227
    //   237: astore_1
    //   238: goto -19 -> 219
    //   241: astore_1
    //   242: goto -39 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SoundAndVibrateActivity
    //   0	245	1	paramUri	Uri
    //   19	205	2	localUri	Uri
    //   229	2	2	localIOException	java.io.IOException
    //   24	184	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	42	java/io/IOException
    //   160	164	165	java/io/IOException
    //   20	25	200	java/lang/Exception
    //   48	87	200	java/lang/Exception
    //   171	195	200	java/lang/Exception
    //   207	211	212	java/io/IOException
    //   20	25	218	finally
    //   48	87	218	finally
    //   171	195	218	finally
    //   223	227	229	java/io/IOException
    //   91	102	237	finally
    //   106	114	237	finally
    //   118	125	237	finally
    //   129	133	237	finally
    //   137	144	237	finally
    //   148	156	237	finally
    //   91	102	241	java/lang/Exception
    //   106	114	241	java/lang/Exception
    //   118	125	241	java/lang/Exception
    //   129	133	241	java/lang/Exception
    //   137	144	241	java/lang/Exception
    //   148	156	241	java/lang/Exception
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563102);
    setTitle(getString(2131696477));
    this.a = aean.a(this.app);
    this.a.a(this);
    initUI();
    return false;
  }
  
  public void doOnDestroy()
  {
    bVz();
    if (this.d != null)
    {
      this.d.release();
      this.d = null;
    }
    this.a.b(this);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    int i = this.a.Ce();
    this.a.a(this.ap, i);
  }
  
  public void initUI()
  {
    this.density = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    int j = this.app.AI();
    int k = this.app.AJ();
    this.aD = ((FormSwitchItem)findViewById(2131378573));
    this.aE = ((FormSwitchItem)findViewById(2131381569));
    this.aF = ((FormSwitchItem)findViewById(2131368152));
    this.aG = ((FormSwitchItem)findViewById(2131368153));
    this.an = ((FormSimpleItem)findViewById(2131367743));
    this.ao = ((FormSimpleItem)findViewById(2131367744));
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 28)
    {
      aqnm.setVisible(this.aE, 0);
      aqnm.setVisible(this.aG, 0);
      aqnm.setVisible(this.an, 8);
      aqnm.setVisible(this.ao, 8);
      this.aH = ((FormSwitchItem)findViewById(2131378612));
      this.ap = ((FormSimpleItem)findViewById(2131378574));
      this.Y = ((FormSwitchItem)findViewById(2131378286));
      this.ae = ((FormSwitchItem)findViewById(2131370872));
      Object localObject = this.app.getCurrentUin();
      bool1 = aqlz.ca(this.app);
      this.Y.setChecked(bool1);
      FormSwitchItem localFormSwitchItem = this.ae;
      if (!this.Y.isChecked()) {
        break label1342;
      }
      i = 0;
      label269:
      localFormSwitchItem.setVisibility(i);
      this.Y.setOnCheckedChangeListener(new vuw(this, (String)localObject));
      boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject, getString(2131695500), "qqsetting_lock_screen_whenexit_key", true);
      this.ae.setChecked(bool2);
      if (!NotifyPushSettingActivity.Ql()) {
        break label1348;
      }
      this.ae.setChecked(false);
      this.ae.setVisibility(8);
      label343:
      this.ae.setOnCheckedChangeListener(new vve(this, (String)localObject));
      if (AppSetting.enableTalkBack) {
        this.ae.setContentDescription("锁屏显示消息弹框");
      }
      if (AppSetting.enableTalkBack) {
        this.Y.setContentDescription("通知内显示消息内容");
      }
      if (AppSetting.enableTalkBack)
      {
        this.aE.setContentDescription(getString(2131721684));
        this.aG.setContentDescription(getString(2131694537));
        this.aD.setContentDescription(getString(2131720387));
        this.aF.setContentDescription(getString(2131694532));
      }
      this.uP = findViewById(2131378582);
      this.aj = ((FormSimpleItem)findViewById(2131381169));
      this.ak = ((FormSimpleItem)findViewById(2131381168));
      this.al = ((FormSimpleItem)findViewById(2131381170));
      sz();
      this.am = ((FormSimpleItem)findViewById(2131381171));
      this.aI = ((FormSwitchItem)findViewById(2131378572));
      if (k == 0) {
        break label1387;
      }
      this.aE.setChecked(true);
      BB(0);
      i = this.app.AH();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canVibratorGroup :" + i);
      }
      if (i != 0) {
        break label1376;
      }
      this.aG.setChecked(false);
      label609:
      if (j == 0) {
        break label1665;
      }
      this.aD.setChecked(true);
      this.aF.setVisibility(0);
      i = SettingCloneUtil.readValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", bAg);
      if ((!localSharedPreferences.getBoolean(aQc + this.app.getCurrentAccountUin(), false)) && (i == bAg))
      {
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putBoolean(aQc + this.app.getCurrentAccountUin(), true);
        ((SharedPreferences.Editor)localObject).commit();
      }
      this.aj.setRightIcon(null);
      this.ak.setRightIcon(null);
      this.al.setRightIcon(null);
      this.am.setRightIcon(null);
      if (i != 2131230720) {
        break label1404;
      }
      this.aj.setRightIcon(getResources().getDrawable(2130851794));
      BD(0);
      if (AppSetting.enableTalkBack) {
        this.aj.setContentDescription(getString(2131720389) + getString(2131691504));
      }
      label849:
      i = this.app.AG();
      if (QLog.isColorLevel()) {
        QLog.d("SoundSetting", 2, "canPlayGroupSound :" + i);
      }
      if (i != 0) {
        break label1631;
      }
      this.aF.setChecked(false);
      label902:
      localObject = ThemeUtil.getUserCurrentThemeId(this.app);
      if (((String)localObject).equals("1000")) {
        break label1729;
      }
      localObject = ThemeUtil.getThemeInfo(this, (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
        break label1729;
      }
    }
    label1074:
    label1342:
    label1729:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (localSharedPreferences.getBoolean("theme_voice_setting_" + this.app.getCurrentAccountUin(), true))
        {
          this.aI.setChecked(true);
          label994:
          this.aj.setOnClickListener(new vvf(this));
          this.ak.setOnClickListener(new vvg(this));
          this.al.setOnClickListener(new vvh(this));
          this.am.setOnClickListener(new vvi(this));
          if (!this.aD.isChecked()) {
            break label1703;
          }
          this.aD.setBackgroundResource(2130839701);
          this.aD.setOnCheckedChangeListener(new vvj(this));
          if (!this.aE.isChecked()) {
            break label1716;
          }
          this.aE.setBackgroundResource(2130839701);
        }
      }
      for (;;)
      {
        this.aE.setOnCheckedChangeListener(new vvk(this));
        this.aF.setOnCheckedChangeListener(new vvl(this));
        this.aG.setOnCheckedChangeListener(new vux(this));
        this.an.setOnClickListener(new vuy(this));
        this.ao.setOnClickListener(new vuz(this));
        this.aI.setOnCheckedChangeListener(new vva(this, localSharedPreferences));
        this.aH = ((FormSwitchItem)findViewById(2131378612));
        this.FN = ((TextView)findViewById(2131378613));
        u(this.FN);
        this.aH.setOnCheckedChangeListener(new vvb(this));
        this.ap.setOnClickListener(new vvc(this));
        if (this.ap.getVisibility() == 0) {
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
        }
        bVx();
        return;
        aqnm.setVisible(this.aE, 8);
        aqnm.setVisible(this.aG, 8);
        aqnm.setVisible(this.an, 0);
        break;
        i = 8;
        break label269;
        label1348:
        if (bool1)
        {
          this.ae.setVisibility(0);
          break label343;
        }
        this.ae.setVisibility(8);
        break label343;
        label1376:
        this.aG.setChecked(true);
        break label609;
        label1387:
        this.aE.setChecked(false);
        BB(8);
        break label609;
        label1404:
        if (i == 2131230721)
        {
          this.ak.setRightIcon(getResources().getDrawable(2130851794));
          BD(1);
          if (!AppSetting.enableTalkBack) {
            break label849;
          }
          this.ak.setContentDescription(getString(2131720390) + getString(2131691504));
          break label849;
        }
        if (i == bAf)
        {
          this.al.setRightIcon(getResources().getDrawable(2130851794));
          BD(2);
          if (!AppSetting.enableTalkBack) {
            break label849;
          }
          this.al.setContentDescription(getString(2131720391) + getString(2131691504));
          break label849;
        }
        if (i == bAg)
        {
          this.am.setRightIcon(getResources().getDrawable(2130851794));
          BD(3);
          SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", bAg);
          break label849;
        }
        this.ak.setRightIcon(getResources().getDrawable(2130851794));
        BD(1);
        break label849;
        label1631:
        this.aF.setChecked(true);
        break label902;
        this.aI.setChecked(false);
        break label994;
        this.aI.setVisibility(8);
        break label994;
        this.aD.setChecked(false);
        this.aF.setVisibility(8);
        this.aI.setVisibility(8);
        this.ap.setVisibility(8);
        break label994;
        this.aD.setBackgroundResource(2130839682);
        break label1074;
        this.aE.setBackgroundResource(2130839682);
      }
    }
  }
  
  public Boolean j()
  {
    if ((!this.app.YI()) && (!this.app.YJ()) && (this.app.YK()) && ((this.app.a() == null) || (!this.app.a().OQ()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void setVisible(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.aj.setRightIcon(getResources().getDrawable(2130851794));
      this.ak.setRightIcon(null);
      this.al.setRightIcon(null);
      this.am.setRightIcon(null);
      if (AppSetting.enableTalkBack)
      {
        this.aj.setContentDescription(getString(2131720389) + getString(2131691504));
        this.ak.setContentDescription(getString(2131720390) + getString(2131721546));
        this.al.setContentDescription(getString(2131720391) + getString(2131721546));
        this.am.setContentDescription(getString(2131720392) + getString(2131721546));
      }
      anot.a(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      this.aj.setRightIcon(null);
      this.ak.setRightIcon(getResources().getDrawable(2130851794));
      this.al.setRightIcon(null);
      this.am.setRightIcon(null);
      if (AppSetting.enableTalkBack)
      {
        this.aj.setContentDescription(getString(2131720389) + getString(2131721546));
        this.ak.setContentDescription(getString(2131720390) + getString(2131691504));
        this.al.setContentDescription(getString(2131720391) + getString(2131721546));
        this.am.setContentDescription(getString(2131720392) + getString(2131721546));
      }
      anot.a(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      this.aj.setRightIcon(null);
      this.ak.setRightIcon(null);
      this.al.setRightIcon(getResources().getDrawable(2130851794));
      this.am.setRightIcon(null);
      if (AppSetting.enableTalkBack)
      {
        this.aj.setContentDescription(getString(2131720389) + getString(2131721546));
        this.ak.setContentDescription(getString(2131720390) + getString(2131721546));
        this.al.setContentDescription(getString(2131720391) + getString(2131691504));
        this.am.setContentDescription(getString(2131720392) + getString(2131721546));
      }
      anot.a(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.aj.setRightIcon(null);
    this.ak.setRightIcon(null);
    this.al.setRightIcon(null);
    this.am.setRightIcon(getResources().getDrawable(2130851794));
    if (AppSetting.enableTalkBack)
    {
      this.aj.setContentDescription(getString(2131720389) + getString(2131721546));
      this.ak.setContentDescription(getString(2131720390) + getString(2131721546));
      this.al.setContentDescription(getString(2131720391) + getString(2131721546));
      this.am.setContentDescription(getString(2131720392) + getString(2131691504));
    }
    anot.a(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  class a
  {
    boolean bav = false;
    int id;
    String itemName;
    
    a(int paramInt, String paramString, boolean paramBoolean)
    {
      this.id = paramInt;
      this.itemName = paramString;
      this.bav = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */