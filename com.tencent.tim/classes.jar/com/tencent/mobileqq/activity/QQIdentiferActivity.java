package com.tencent.mobileqq.activity;

import acfp;
import aiao;
import aiay.a;
import aijf;
import alxi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anih;
import anot;
import anpc;
import aqha;
import aqiw;
import aqju;
import arfy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppWordings;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;
import com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vns;
import vnu;
import vnv;
import vnw;

@RequiresApi(api=18)
public class QQIdentiferActivity
  extends BaseActivity
  implements aiay.a, Handler.Callback, View.OnClickListener, IdentifierCameraCaptureView.a
{
  private StringBuilder D = new StringBuilder();
  private TextView EL;
  private TextView EM;
  private TextView EN;
  private TextView EO;
  private final long GC = 60000L;
  private volatile long GD;
  private long GE;
  private aiao jdField_a_of_type_Aiao;
  private arfy jdField_a_of_type_Arfy;
  private CircleBarView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView;
  private IdentifierCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView;
  public YTReflectLayout a;
  private String aOS = acfp.m(2131696075);
  private String aOT;
  private boolean aZo;
  private boolean aZp;
  private boolean aZq;
  private MqqHandler b = new MqqHandler(this);
  private AtomicBoolean bA = new AtomicBoolean(false);
  private AtomicBoolean bB = new AtomicBoolean(false);
  private AtomicBoolean bC = new AtomicBoolean(true);
  public int bJn;
  private int bJo = -1;
  private int bJp = 120000;
  private int bJq = 1500;
  private int bJr = Color.rgb(0, 202, 252);
  private int bJs = Color.rgb(255, 64, 96);
  private int bJt = Color.argb(0, 0, 0, 0);
  private int bJu = 1000;
  private int baS;
  private AtomicBoolean bz = new AtomicBoolean(false);
  private byte[] ci;
  private LinearLayout gj;
  private LinearLayout gl;
  private RelativeLayout ha;
  private RelativeLayout hb;
  private Map<String, Object> hk = new HashMap();
  private Map<String, Integer> hl;
  private Map<String, String> hm = new QQIdentiferActivity.1(this);
  private long ie;
  private Context mContext;
  private BroadcastReceiver mReceiver = new vnw(this);
  private String method;
  private ImageView qK;
  private ImageView qL;
  private MqqHandler t = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
  private View tP;
  private View tQ;
  
  private boolean Qq()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      bk(205, acfp.m(2131711774));
      finish();
      return false;
    }
    if (!anih.agb())
    {
      bk(203, acfp.m(2131711772));
      aqha.a(this, 230, acfp.m(2131711787), acfp.m(2131711780), "", acfp.m(2131711768), new vnv(this), null).show();
      return false;
    }
    if (isInMultiWindow())
    {
      bk(206, aijf.bOe);
      finish();
      return false;
    }
    return true;
  }
  
  private CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = new CameraCaptureView.e();
    locale.TO(480);
    locale.TN(640);
    locale.Ov(false);
    return locale;
  }
  
  private void ad(String paramString1, String paramString2, String paramString3)
  {
    if ("setFaceData".equals(this.method)) {
      anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "1", paramString2, paramString3, "");
    }
    do
    {
      return;
      if ("loginVerify".equals(this.method))
      {
        anot.c(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "2", paramString2, paramString3, "");
        return;
      }
    } while (!"changeSecureMobile".equals(this.method));
    anot.c(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", paramString2, paramString3, "");
  }
  
  private void bSO()
  {
    if (this.bz.get()) {
      bk(210, aijf.bOg);
    }
  }
  
  private void bSR()
  {
    ThreadManagerV2.executeOnFileThread(new QQIdentiferActivity.9(this));
  }
  
  private void bk(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localIntent.putExtra("data", localBundle);
    setResult(-1, d(localIntent));
  }
  
  private void bl(int paramInt, String paramString)
  {
    QLog.d("qq_Identification.act", 1, new Object[] { "collectErrorCode error code : ", Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("errorCode", String.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("errorMsg", paramString);
    }
    paramString = getAppInterface();
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getAccount())
    {
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("key_uin", paramString);
      }
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(paramString, "tagIdentificationErrorCode", this.aZo, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private Intent d(Intent paramIntent)
  {
    String str = this.D.toString();
    if ((paramIntent != null) && (paramIntent.hasExtra("data"))) {
      bl(paramIntent.getBundleExtra("data").getInt("ret", 299), "");
    }
    if (TextUtils.isEmpty(str)) {
      return paramIntent;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("allResults", str);
    return localIntent;
  }
  
  private String oV()
  {
    int i = getIntent().getIntExtra("serviceType", -1);
    Object localObject = (FaceDetectForThirdPartyManager.AppConf)getIntent().getSerializableExtra("FaceRecognition.AppConf");
    if ((localObject == null) || (i == -1) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al == null) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "getAppWording PARAMS ERROR serviceType=" + i + " appConf=" + localObject);
      }
      return null;
    }
    localObject = ((FaceDetectForThirdPartyManager.AppConf)localObject).al.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FaceDetectForThirdPartyManager.AppWordings localAppWordings = (FaceDetectForThirdPartyManager.AppWordings)((Iterator)localObject).next();
      if (localAppWordings.serviceType == i) {
        return localAppWordings.text;
      }
    }
    return null;
  }
  
  private void vX(String paramString)
  {
    if ("identify".equals(this.method)) {
      return;
    }
    if (paramString == null)
    {
      QLog.e("qq_Identification.act", 1, "add wording record, wording is null");
      return;
    }
    if (this.hl.containsKey(paramString))
    {
      Integer localInteger = (Integer)this.hl.get(paramString);
      this.hl.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    this.hl.put(paramString, Integer.valueOf(1));
  }
  
  private void vY(String paramString)
  {
    ad(paramString, "", "");
  }
  
  public void T(Map<String, Object> paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView == null) || (this.bB.get())) {}
    for (;;)
    {
      return;
      if (paramMap.containsKey("ui_tips")) {}
      try
      {
        String str1 = getActivity().getPackageName();
        String str2 = (String)paramMap.get("ui_tips");
        String str3 = (String)this.hm.get(str2);
        if (!TextUtils.isEmpty(str3)) {}
        for (this.aOT = str3;; this.aOT = getString(getResources().getIdentifier(str2, "string", str1)))
        {
          if (paramMap.containsKey("ui_action"))
          {
            if (!"not_pass".equals(paramMap.get("ui_action"))) {
              break label277;
            }
            this.hk.put("keyStateIdentify", "stateNotPass");
          }
          if ((!paramMap.containsKey("process_action")) || (!"failed".equals(paramMap.get("process_action")))) {
            break;
          }
          this.aZp = true;
          this.aOS = ((String)paramMap.get("message"));
          QLog.e("qq_Identification.act", 1, new Object[] { "handleEvent process result failed : ", this.aOS });
          j(this.aOS);
          bl(-10, this.aOS);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("qq_Identification.act", 1, "get resource string error : " + localException.getMessage());
          continue;
          label277:
          if ("pass".equals(paramMap.get("ui_action"))) {
            this.hk.put("keyStateIdentify", "statePass");
          } else {
            this.hk.put("keyStateIdentify", null);
          }
        }
      }
    }
  }
  
  public void a(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
    this.jdField_a_of_type_Arfy.b(paramColorMatrixColorFilter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(this.bJt);
    this.bA.set(true);
    long l = System.currentTimeMillis();
    if (this.GE != 0L) {
      QLog.d("qq_Identification.act", 1, new Object[] { "reflect delta time is : ", Long.valueOf(l - this.GE) });
    }
    this.GE = l;
  }
  
  public void a(CharSequence paramCharSequence, Map<String, Object> paramMap)
  {
    if ((this.gl.getVisibility() != 0) || (this.bA.get()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJt);
      if (this.bA.get()) {
        this.EM.setText(paramCharSequence);
      }
      return;
    }
    this.EM.setText(paramCharSequence);
    paramMap = paramMap.get("keyStateIdentify");
    if ("statePass".equals(paramMap))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(this.bJr);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJt);
    }
    for (;;)
    {
      vX(paramCharSequence.toString());
      return;
      if ("stateNotPass".equals(paramMap))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(this.bJs);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJt);
      }
    }
  }
  
  public void au(boolean paramBoolean, int paramInt)
  {
    this.b.removeMessages(1);
    if (paramBoolean)
    {
      this.gl.setVisibility(4);
      this.ha.findViewById(2131379836).setVisibility(8);
      if (!TextUtils.isEmpty(oV()))
      {
        String str = oV();
        i(str);
        vX(str);
      }
      this.aZq = true;
      this.jdField_a_of_type_Arfy.Yx(getResources().getColor(2131167595));
      findViewById(2131364221).post(new QQIdentiferActivity.8(this));
      return;
    }
    bk(paramInt, this.aOS);
    j(acfp.m(2131711779));
  }
  
  public void bSN()
  {
    if (!aqiw.isNetworkAvailable(this))
    {
      this.aOS = acfp.m(2131711766);
      this.aZo = false;
      this.aZp = true;
      bk(202, this.aOS);
      QLog.e("qq_Identification.act", 1, "onUploadVideo net error");
      j(this.aOS);
      return;
    }
    this.bz.set(true);
    bSQ();
  }
  
  public void bSP()
  {
    this.gl.setVisibility(8);
    this.ha.findViewById(2131379836).setVisibility(0);
    this.jdField_a_of_type_Arfy.Yx(getResources().getColor(2131167597));
    this.EL.setText(acfp.m(2131711769));
    vX(acfp.m(2131711769));
  }
  
  public void bSQ()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.bB.set(true);
    this.bC.set(false);
    this.gl.setVisibility(8);
    this.ha.findViewById(2131379836).setVisibility(0);
    this.jdField_a_of_type_Arfy.Yx(getResources().getColor(2131167597));
    this.EL.setText(acfp.m(2131711763));
    findViewById(2131369263).setVisibility(8);
    vX(acfp.m(2131711763));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(this.bJt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJr);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.TW(1000);
    bSR();
    this.b.sendEmptyMessageDelayed(5, 60000L);
  }
  
  public void bSS()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.bB.set(true);
    this.bC.set(false);
    this.gl.setVisibility(8);
    this.tQ.setVisibility(0);
    this.ha.findViewById(2131379836).setVisibility(8);
    this.gj.setVisibility(0);
    this.EO.setText(acfp.m(2131711778));
    this.qK.setImageResource(2130841125);
    this.hb.setVisibility(0);
    findViewById(2131379839).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.stopLoading();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(this.bJr);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJt);
    this.b.removeMessages(5);
    this.bA.set(false);
    long l;
    if ("loginVerify".equals(this.method))
    {
      anot.a(null, "dc00898", "", "", "0X800A31A", "0X800A31A", 0, 0, "", "", "", "");
      l = System.currentTimeMillis() - this.ie;
      if (!"setFaceData".equals(this.method)) {
        break label375;
      }
      anot.a(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "1", "", "");
    }
    label375:
    while (!"loginVerify".equals(this.method))
    {
      return;
      if ("setFaceData".equals(this.method))
      {
        anot.a(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
        break;
      }
      if ("deleteFace".equals(this.method))
      {
        anot.a(null, "dc00898", "", "", "0X800AE96", "0X800AE96", 0, 0, "", "", "", "");
        break;
      }
      if (!"changeSecureMobile".equals(this.method)) {
        break;
      }
      anot.a(null, "dc00898", "", "", "0X800AEC4", "0X800AEC4", 0, 0, "", "", "", "");
      break;
    }
    anot.a(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "2", "", "");
  }
  
  public void btv()
  {
    this.ha.findViewById(2131379836).setVisibility(8);
    this.gj.setVisibility(8);
    this.hb.setVisibility(8);
    this.gl.setVisibility(0);
    this.jdField_a_of_type_Arfy.Yx(getResources().getColor(2131167595));
    this.qL.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setVisibility(0);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mContext = this;
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setFlags(67108864, 67108864);
    }
    getWindow().setFlags(128, 128);
    requestWindowFeature(1);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561382);
    this.GD = System.currentTimeMillis();
    this.hl = new HashMap();
    paramBundle = getIntent();
    this.bJn = paramBundle.getIntExtra("key_identification_type", 2);
    this.method = paramBundle.getStringExtra("method");
    this.gl = ((LinearLayout)findViewById(2131379805));
    this.ha = ((RelativeLayout)findViewById(2131368809));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView = ((IdentifierCameraCaptureView)findViewById(2131368808));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.Ot(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setPreviewCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureListener(new vns(this));
    this.EL = ((TextView)findViewById(2131373697));
    this.EO = ((TextView)findViewById(2131379843));
    this.qK = ((ImageView)findViewById(2131379841));
    this.EM = ((TextView)findViewById(2131379806));
    this.EN = ((TextView)findViewById(2131364210));
    this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout = ((YTReflectLayout)findViewById(2131382410));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView = ((CircleBarView)findViewById(2131382409));
    this.hb = ((RelativeLayout)findViewById(2131379840));
    this.tP = findViewById(2131381448);
    this.gj = ((LinearLayout)findViewById(2131379842));
    this.tQ = findViewById(2131382411);
    this.qL = ((ImageView)findViewById(2131369685));
    this.jdField_a_of_type_Arfy = new arfy();
    if (Build.VERSION.SDK_INT > 15) {
      this.tP.setBackground(this.jdField_a_of_type_Arfy);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(getResources().getColor(2131165615));
      paramBundle = findViewById(2131364221);
      paramBundle.setOnClickListener(this);
      paramBundle.post(new QQIdentiferActivity.3(this, paramBundle));
      findViewById(2131379839).setOnClickListener(this);
      if (Qq()) {
        break;
      }
      QLog.e("qq_Identification.act", 1, "preCheck not pass");
      return true;
      this.tP.setBackgroundDrawable(this.jdField_a_of_type_Arfy);
    }
    this.bz.set(false);
    this.jdField_a_of_type_Aiao = new aiao(this, this.bJn);
    this.b.sendEmptyMessageDelayed(1, this.bJp);
    this.b.sendEmptyMessage(4);
    bSP();
    if (TextUtils.isEmpty(oV()))
    {
      QLog.d("qq_Identification.act", 1, "getAppWording return empty");
      alxi.a().a(getApplicationContext(), new vnu(this));
    }
    if (this.baS == 0)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
      paramBundle.addAction("tencent.av.v2q.AvSwitch");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.mContext.registerReceiver(this.mReceiver, paramBundle);
      this.baS = 1;
    }
    this.ie = System.currentTimeMillis();
    int i = getIntent().getIntExtra("serviceType", -1);
    anot.a(this.app, "dc00898", "", "", "0X80097EA", "0X80097EA", 0, 0, i + "", "" + this.bJn, getIntent().getIntExtra("srcAppId", 0) + "", "");
    vY("0X800A85F");
    vY("0X800AEC3");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.aZq = false;
    this.b.removeCallbacksAndMessages(null);
    this.t.removeCallbacksAndMessages(null);
    if (TextUtils.isEmpty(oV())) {
      alxi.a().stop();
    }
    if (this.jdField_a_of_type_Aiao != null) {
      this.jdField_a_of_type_Aiao.destroy();
    }
    if (this.baS == 1)
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.baS = 0;
    }
    long l;
    if (!this.aZo)
    {
      l = System.currentTimeMillis() - this.ie;
      if (!"setFaceData".equals(this.method)) {
        break label224;
      }
      anot.a(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "1", "", "");
    }
    while ((this.hl != null) && (!this.hl.isEmpty()))
    {
      Iterator localIterator = this.hl.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad("0X800A863", String.valueOf(((Integer)this.hl.get(str)).intValue()), str);
      }
      label224:
      if ("loginVerify".equals(this.method)) {
        anot.a(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "2", "", "");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.bB.set(true);
    YtSDKKitFramework.getInstance().deInit();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    QLog.d("qq_Identification.act", 1, new Object[] { "onResume isScanningFace : ", Boolean.valueOf(this.bC.get()) });
    if (this.bC.get()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onResume();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 3: 
      if ("loginVerify".equals(this.method))
      {
        anot.c(this.app, "dc00898", "", "", "0X800AD2C", "0X800AD2C", 0, 0, "", "", "", "");
        paramMessage = new Intent();
        paramMessage.setAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        paramMessage.setPackage(MobileQQ.getContext().getPackageName());
        sendBroadcast(paramMessage);
      }
      finish();
      return false;
    case 1: 
      QLog.d("qq_Identification.act", 1, "init time out");
      au(false, 218);
      return false;
    case 4: 
      if ((!TextUtils.isEmpty(this.aOT)) && (!this.bB.get())) {
        a(this.aOT, this.hk);
      }
      this.b.sendEmptyMessageDelayed(4, this.bJu);
      return false;
    }
    QLog.d("qq_Identification.act", 1, "MSG_POST_FILE_TIME_OUT");
    j(acfp.m(2131711766));
    return false;
  }
  
  public void i(CharSequence paramCharSequence)
  {
    this.EN.setText(paramCharSequence);
    vX(paramCharSequence.toString());
  }
  
  public void j(CharSequence paramCharSequence)
  {
    int i = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = acfp.m(2131711770);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.bB.set(true);
    this.bC.set(false);
    this.gl.setVisibility(8);
    this.gj.setVisibility(0);
    this.hb.setVisibility(0);
    this.ha.findViewById(2131379836).setVisibility(8);
    this.EO.setText((CharSequence)localObject);
    this.qK.setImageResource(2130841124);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.stopLoading();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kY(getResources().getColor(2131165615));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.kZ(this.bJt);
    this.jdField_a_of_type_Arfy.Yx(getResources().getColor(2131167597));
    this.b.removeMessages(5);
    this.bA.set(false);
    bSR();
    paramCharSequence = findViewById(2131379839);
    if (this.aZp) {}
    for (;;)
    {
      paramCharSequence.setVisibility(i);
      vX(((CharSequence)localObject).toString());
      vY("0X800A865");
      vY("0X800AEC5");
      return;
      i = 8;
    }
  }
  
  public void o(int paramInt, Bundle paramBundle)
  {
    this.bz.set(false);
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("ret", -1);
      if ((i != -1) && (paramBundle.getBoolean("needRetry", false))) {
        this.D.append(i).append("|");
      }
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "QQIdentifer onRequestFinish: ,ret=" + i);
      }
    }
    for (;;)
    {
      Intent localIntent;
      switch (paramInt)
      {
      default: 
        if (paramBundle != null)
        {
          this.aOS = paramBundle.getString("errMsg");
          localIntent = new Intent();
          localIntent.putExtra("data", paramBundle);
          setResult(-1, d(localIntent));
        }
        break;
      }
      for (;;)
      {
        this.aZo = false;
        this.aZp = true;
        for (;;)
        {
          QLog.d("qq_Identification.act", 1, new Object[] { "onRequestFinish: code=", Integer.valueOf(paramInt), ",ret=", Integer.valueOf(i), "|", this.aOS, " isSuccess : ", Boolean.valueOf(this.aZo) });
          this.b.post(new QQIdentiferActivity.6(this));
          return;
          if (paramBundle != null)
          {
            if (paramBundle.getInt("ret") == 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.aZo = bool;
              this.aZp = paramBundle.getBoolean("needRetry");
              this.aOS = paramBundle.getString("errMsg");
              localIntent = new Intent();
              localIntent.putExtra("data", paramBundle);
              paramBundle = d(localIntent);
              if (this.aZo) {
                paramBundle.putExtra("key_face_scan_result", true);
              }
              setResult(-1, paramBundle);
              break;
            }
          }
          this.aZo = false;
          this.aZp = true;
          this.aOS = acfp.m(2131711762);
          setResult(-1, d(null));
        }
        this.aOS = acfp.m(2131711770);
        setResult(-1, d(null));
      }
      i = -1;
    }
  }
  
  public boolean onBackEvent()
  {
    bSO();
    return super.onBackEvent();
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
      if (!"setFaceData".equals(this.method))
      {
        QLog.d("qq_Identification.act", 1, "click cancel, method is not METHOD_SETTING_FACE_DATA");
        bSO();
      }
      vY("0X800A860");
      finish();
      continue;
      vY("0X800A866");
      YtSDKKitFramework.getInstance().deInit();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onResume();
      this.bC.set(true);
      btv();
    }
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 24)) {}
    while (!paramBoolean) {
      return;
    }
    bk(206, acfp.m(2131711773));
    finish();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters().getPreviewSize();
    if (!this.aZq) {
      return;
    }
    this.ci = paramArrayOfByte;
    YtFSM.getInstance().update(paramArrayOfByte, paramCamera.width, paramCamera.height, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity
 * JD-Core Version:    0.7.0.1
 */