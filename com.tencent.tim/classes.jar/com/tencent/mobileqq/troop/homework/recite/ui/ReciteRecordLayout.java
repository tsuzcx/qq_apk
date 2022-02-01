package com.tencent.mobileqq.troop.homework.recite.ui;

import acfp;
import aliv;
import aliv.a;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import aniq;
import aojs;
import apir;
import apis;
import apjg;
import apjh;
import apji;
import apjj;
import apjk;
import apjl;
import apjm;
import apjn;
import apjo;
import apjr;
import apjs;
import apkb;
import apke;
import aqge;
import aqha;
import aqhq;
import aqiw;
import aqju;
import aqlv;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.QQRecorder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wpi;

public class ReciteRecordLayout
  extends LinearLayout
  implements VoiceRecognizerListener, QQRecorder.a, QQRecorder.b, wpi
{
  apkb jdField_a_of_type_Apkb;
  private a jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$a;
  VolumeVisualizerView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView;
  public aqju aD;
  aqju aE;
  public TextView aaP;
  public volatile boolean cQW = false;
  volatile boolean cQX = false;
  String cpG;
  String cpH;
  QQRecorder d;
  INetInfoHandler e;
  CountDownTimer g;
  public CountDownTimer h;
  public BaseActivity mActivity;
  public Context mContext;
  Handler mUiHandler = new Handler();
  
  public ReciteRecordLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReciteRecordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReciteRecordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    fq(paramContext);
    init();
  }
  
  private void eai()
  {
    int j = 0;
    if (((this.mActivity instanceof Activity)) && ((this.mActivity == null) || (this.mActivity.isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReciteRecordLayout", 2, "showNoRecordPermissionDlg failed, mActivity not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131700686;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.mActivity.getString(i));
        if (j == 0) {
          break label234;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.mActivity.getResources().getColor(2131165750), this.mActivity.getResources().getColor(2131165758)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        aqha.a(this.mActivity, acfp.m(2131713748), (CharSequence)localObject, 0, 2131721303, null, null, new apjh(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReciteRecordLayout", 2, "show noPermission error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131700688;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131700687;
      }
      else
      {
        i = 2131700685;
        j = 1;
      }
    }
    label234:
    aqha.a(this.mActivity, 230, acfp.m(2131713742), localException.toString(), acfp.m(2131713744), "", null, new apji(this)).show();
  }
  
  private void fq(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    View.inflate(paramContext, 2131560854, this);
    this.aaP = ((TextView)findViewById(2131376978));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView = ((VolumeVisualizerView)findViewById(2131382074));
  }
  
  private void init()
  {
    this.h = new apjm(this, 3000L, 1000L);
    this.e = new apjn(this);
    this.g = new apjo(this, 10000L, 1000L);
  }
  
  private String oF(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    char[] arrayOfChar = new char[k << 1];
    int j = 0;
    while (j < k)
    {
      arrayOfChar[i] = paramString.charAt(j);
      arrayOfChar[(i + 1)] = ' ';
      j += 1;
      i = j << 1;
    }
    return new String(arrayOfChar);
  }
  
  private void showNetworkErrorDialog()
  {
    if (isRecording())
    {
      eah();
      if (this.aD == null)
      {
        this.aD = aqha.a(this.mActivity, 230).setMessage(2131699697).setNegativeButton(acfp.m(2131713743), new apjl(this)).setPositiveButton(2131699691, new apjg(this), false);
        this.aD.setCancelable(false);
      }
      this.aD.show();
    }
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    return -1;
  }
  
  public String a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      throw new IllegalArgumentException("activity can not be null");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "startRecord!");
    }
    if (this.jdField_a_of_type_Apkb != null) {
      this.jdField_a_of_type_Apkb.reset();
    }
    if (this.g != null) {
      this.g.cancel();
    }
    this.cQW = false;
    this.mActivity = paramBaseActivity;
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 2131699660, 0).show();
      return null;
    }
    if (!aqhq.aCJ())
    {
      aqha.a(paramBaseActivity, 230).setMessage(2131699661).setPositiveButton(2131699651, new apjr(this)).show();
      return null;
    }
    if ((!QQRecorder.aES()) || (!QQRecorder.mw(1)))
    {
      aqha.a(paramBaseActivity, 230).setMessage(2131699650).setPositiveButton(2131699651, new apjs(this)).show();
      return null;
    }
    if (paramBaseActivity.app.bF())
    {
      QQToast.a(this.mContext, 2131697385, 0).show();
      return null;
    }
    if (this.d == null)
    {
      this.d = new QQRecorder(this.mContext);
      this.d.b(new QQRecorder.RecorderParam(16000, aniq.ckG, 1));
      this.d.a(this);
      this.d.a(this);
    }
    aqge.m(this.mContext, true);
    if (TextUtils.isEmpty(this.cpG)) {
      this.cpG = aojs.a(paramBaseActivity.app.getCurrentAccountUin(), null, 65, null);
    }
    this.d.start(this.cpG);
    this.cQX = false;
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(0);
    VoiceRecognizer.shareInstance().setListener(this);
    paramBaseActivity = (TroopManager)paramBaseActivity.app.getManager(52);
    try
    {
      VoiceRecognizer.shareInstance().init(this.mContext, paramBaseActivity.a.cpC, apke.G(this.mContext, "libWXVoice.so"));
      VoiceRecognizer.shareInstance().start();
      AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this.e);
      return this.cpG;
    }
    catch (Exception paramBaseActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReciteRecordLayout", 2, "VoiceRecognizer init error = " + paramBaseActivity);
        }
      }
    }
  }
  
  public void a(aliv paramaliv, aliv.a parama) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    apis.nY(paramString);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.length() == 0L))
    {
      paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
      apis.a(paramString, paramRecorderParam, paramRecorderParam.length);
    }
    this.mUiHandler.post(new ReciteRecordLayout.9(this));
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    apis.nZ(paramString);
    this.mUiHandler.post(new ReciteRecordLayout.11(this, paramString, paramDouble));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onRecorderError = " + paramString2);
    }
    apis.Of(paramString1);
    stopRecord();
    this.mUiHandler.post(new ReciteRecordLayout.13(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    apis.a(paramString, paramArrayOfByte, paramInt1);
    if (paramInt2 < 500) {
      if (!this.cQW)
      {
        this.g.start();
        this.cQW = true;
      }
    }
    for (;;)
    {
      this.mUiHandler.post(new ReciteRecordLayout.8(this, paramInt2));
      return;
      if (this.cQW)
      {
        this.g.cancel();
        this.cQW = false;
      }
    }
  }
  
  public void as(int paramInt) {}
  
  public void at(String paramString) {}
  
  public void b(aliv paramaliv, aliv.a parama)
  {
    VoiceRecognizer.shareInstance().appendData(parama.data, parama.offset, parama.size, this.cQX);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    stopRecord();
    this.mUiHandler.post(new ReciteRecordLayout.14(this));
  }
  
  public int bz()
  {
    this.mUiHandler.post(new ReciteRecordLayout.10(this));
    return 0;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    stopRecord();
    this.mUiHandler.postDelayed(new ReciteRecordLayout.12(this), 500L);
  }
  
  public void eah()
  {
    if (isRecording()) {
      this.d.stop();
    }
    aqge.m(this.mContext, false);
    AppNetConnInfo.unregisterNetInfoHandler(this.e);
    this.cQX = true;
    VoiceRecognizer.shareInstance().destroy();
    if (this.g != null) {
      this.g.cancel();
    }
    this.cQW = false;
  }
  
  public void hB() {}
  
  public boolean isRecording()
  {
    return (this.d != null) && (this.d.isRecording());
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (isRecording()) {
      stopRecord();
    }
    if ((this.aD != null) && (this.aD.isShowing())) {
      this.aD.dismiss();
    }
    if ((this.aE != null) && (this.aE.isShowing())) {
      this.aE.dismiss();
    }
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public void onGetError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onGetError = " + paramInt);
    }
    if ((paramInt == -201) || (paramInt == -202)) {
      showNetworkErrorDialog();
    }
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onGetResult text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$a != null) && (!TextUtils.isEmpty(paramVoiceRecognizerResult.text)) && (!paramVoiceRecognizerResult.text.equals(this.cpH)))
    {
      this.cpH = paramVoiceRecognizerResult.text;
      if (QLog.isColorLevel()) {
        QLog.e("ReciteRecordLayout", 2, "onGetResult2 text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$a.a(paramVoiceRecognizerResult.text, ChnToSpell.aJ(oF(paramVoiceRecognizerResult.text), 1), paramVoiceRecognizerResult.startTime, paramVoiceRecognizerResult.stopTime, paramVoiceRecognizerResult.isAllEnd);
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
  
  public void onPause()
  {
    if (isRecording())
    {
      eah();
      if (this.aE == null)
      {
        this.aE = aqha.a(this.mActivity, 230).setMessage(2131699687).setNegativeButton(2131699698, new apjk(this)).setPositiveButton(2131699690, new apjj(this));
        this.aE.setCancelable(false);
      }
      this.aE.show();
    }
  }
  
  public void onVolumeChanged(int paramInt) {}
  
  public void setOnReciteListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$a = parama;
  }
  
  public void setmReciteDetectManager(apkb paramapkb)
  {
    this.jdField_a_of_type_Apkb = paramapkb;
  }
  
  public void stopRecord()
  {
    this.cQX = true;
    if (isRecording()) {
      this.d.stop();
    }
    aqge.m(this.mContext, false);
    this.cpG = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.e);
    if (this.h != null) {
      this.h.cancel();
    }
    if (this.g != null) {
      this.g.cancel();
    }
    this.cQW = false;
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, double paramDouble1, double paramDouble2, boolean paramBoolean);
    
    public abstract void c(String paramString, double paramDouble);
    
    public abstract void dZX();
    
    public abstract void dZY();
    
    public abstract void dZZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout
 * JD-Core Version:    0.7.0.1
 */