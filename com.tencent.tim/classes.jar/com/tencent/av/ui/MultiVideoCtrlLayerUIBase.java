package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqju;
import atan;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import iid;
import iin;
import iiv;
import imm;
import ioa;
import irc;
import ivv;
import iwq;
import iwu;
import iya;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.av.ui.MultiVideoCtrlLayerUIBase.a;>;
import java.util.Iterator;
import jaz;
import jba;
import jbe;
import jbf;
import jbg;
import jbh;
import jbi;
import jbj;
import jbk;
import jbl;
import jcr;
import jgg;
import jjc;
import jji;
import jjk;
import jjp;
import jka;
import jkn;
import jko;
import jkz;
import jll;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import wja;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  static int auk;
  private static boolean sIsSpecialDevice;
  String Rs = null;
  String Rt;
  String Ru = "";
  boolean Xi = false;
  public boolean Xj = true;
  public boolean Xk = false;
  private boolean Xl;
  private boolean Xm;
  private BroadcastReceiver Y = new jbg(this);
  atan jdField_a_of_type_Atan = null;
  public InviteUserNoticeRunnable a;
  StartRecvVideoRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable = new StartRecvVideoRunnable();
  jcr jdField_a_of_type_Jcr = null;
  jko jdField_a_of_type_Jko = null;
  public int aqx = 0;
  public int awD = -1;
  public int awE = 0;
  int awF = 0;
  int awG = 0;
  int awH = 1;
  public MultiMembersAudioUI b;
  MultiMembersVideoUI jdField_b_of_type_ComTencentAvUiMultiMembersVideoUI = null;
  private iin jdField_b_of_type_Iin = new jaz(this);
  jka jdField_b_of_type_Jka = new jbi(this);
  Runnable bC = null;
  Runnable bD = null;
  Runnable bE = null;
  Runnable bF = null;
  public Runnable bV = null;
  public Runnable bW = null;
  Runnable bX = new MultiVideoCtrlLayerUIBase.3(this);
  iid c;
  RelativeLayout ee = null;
  ImageView gy = null;
  ArrayList<a> iJ = new ArrayList();
  ArrayList<a> iL = new ArrayList();
  public boolean isVideo = false;
  TextView mK = null;
  TextView mL = null;
  public int mLastRotation = 0;
  public boolean mQuit;
  public long mSelfUin = 0L;
  public int mUinType = -1;
  TextView mUserName = null;
  public long md;
  public long oC = 0L;
  
  static
  {
    int i = 16;
    auk = 16;
    if (Build.VERSION.SDK_INT >= 21)
    {
      auk = i;
      if ((!Build.MODEL.equalsIgnoreCase("SM-G7106")) && (!Build.MODEL.equalsIgnoreCase("MI 2")) && (!Build.MODEL.equalsIgnoreCase("GT-B9388")) && (!Build.MODEL.equalsIgnoreCase("L39u")) && (!Build.MODEL.equalsIgnoreCase("R7007")) && (!Build.MODEL.equalsIgnoreCase("VIVO X5S L"))) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      sIsSpecialDevice = bool;
      return;
      i = 9;
      break;
    }
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, iya paramiya)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramiya);
    this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = new InviteUserNoticeRunnable();
    this.jdField_c_of_type_Iid = new jba(this);
  }
  
  private void bV(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.ss();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("doRefreshGaudioMuteUIStatus", paramInt1, paramInt2, false);
    }
    if (bool)
    {
      super.mZ(2131373947);
      if (this.mApp != null) {
        this.mApp.l(new Object[] { Integer.valueOf(108) });
      }
    }
    do
    {
      return;
      super.mY(2131373947);
    } while (this.mApp == null);
    this.mApp.l(new Object[] { Integer.valueOf(109) });
  }
  
  private String g(ArrayList<a> paramArrayList)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int n = jjc.cI(localiiv.uinType);
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    int k;
    if (paramArrayList.size() > 0)
    {
      localObject1 = ((Context)this.mContext.get()).getString(2131698105);
      localObject2 = new int[3];
      Object tmp51_49 = localObject2;
      tmp51_49[0] = -1;
      Object tmp55_51 = tmp51_49;
      tmp55_51[1] = -1;
      Object tmp59_55 = tmp55_51;
      tmp59_55[2] = -1;
      tmp59_55;
      i = 0;
      if (i < paramArrayList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "speakingInfoList. idx = " + i + ", uin = " + ((a)paramArrayList.get(i)).uin + ", audioEnergy = " + ((a)paramArrayList.get(i)).alU);
        }
        if ((localObject2[0] == -1) || (((a)paramArrayList.get(localObject2[0])).alU < ((a)paramArrayList.get(i)).alU))
        {
          localObject2[2] = localObject2[1];
          localObject2[1] = localObject2[0];
          localObject2[0] = i;
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject2[1] == -1) || (((a)paramArrayList.get(localObject2[1])).alU < ((a)paramArrayList.get(i)).alU))
          {
            localObject2[2] = localObject2[1];
            localObject2[1] = i;
          }
          else if ((localObject2[2] == -1) || (((a)paramArrayList.get(localObject2[2])).alU < ((a)paramArrayList.get(i)).alU))
          {
            localObject2[2] = i;
          }
        }
      }
      j = 0;
      if (j < this.iL.size())
      {
        k = 0;
        label324:
        if (k >= localObject2.length) {
          break label1174;
        }
        if (localObject2[k] < 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      label342:
      if (i != 0)
      {
        ((a)paramArrayList.get(localObject2[k])).uin = "";
        ((a)this.iL.get(j)).alU = ((a)paramArrayList.get(localObject2[k])).alU;
      }
      for (;;)
      {
        j += 1;
        break;
        if (((a)this.iL.get(j)).uin.equalsIgnoreCase(((a)paramArrayList.get(localObject2[k])).uin))
        {
          i = 1;
          break label342;
        }
        k += 1;
        break label324;
        ((a)this.iL.get(j)).uin = "";
      }
      j = 0;
      i = 0;
      int m;
      if (j < this.iL.size())
      {
        k = i;
        m = j;
        if (((a)this.iL.get(j)).uin.equalsIgnoreCase(""))
        {
          k = i;
          label513:
          i = k;
          if (k < localObject2.length)
          {
            if (localObject2[k] >= 0) {
              break label577;
            }
            i = k;
          }
          label535:
          if ((i >= localObject2.length) || (localObject2[i] >= 0)) {
            break label1165;
          }
          this.iL.remove(j);
          m = j - 1;
          k = i;
        }
      }
      for (;;)
      {
        j = m + 1;
        i = k;
        break;
        label577:
        if (!((a)paramArrayList.get(localObject2[k])).uin.equalsIgnoreCase(""))
        {
          ((a)this.iL.get(j)).uin = ((a)paramArrayList.get(localObject2[k])).uin;
          ((a)this.iL.get(j)).alU = ((a)paramArrayList.get(localObject2[k])).alU;
          ((a)paramArrayList.get(localObject2[k])).uin = "";
          i = k + 1;
          break label535;
        }
        k += 1;
        break label513;
        k = this.iL.size();
        if (k < 3)
        {
          j = i;
          for (;;)
          {
            i = j;
            if (j < localObject2.length) {
              if (localObject2[j] >= 0) {
                break label736;
              }
            }
            for (i = j;; i = j + 1)
            {
              k += 1;
              break;
              label736:
              if (((a)paramArrayList.get(localObject2[j])).uin.equalsIgnoreCase("")) {
                break label824;
              }
              this.iL.add(new a(((a)paramArrayList.get(localObject2[j])).uin, ((a)paramArrayList.get(localObject2[j])).alU));
              ((a)paramArrayList.get(localObject2[j])).uin = "";
            }
            label824:
            j += 1;
          }
        }
        i = 0;
        paramArrayList = (ArrayList<a>)localObject1;
        localObject1 = paramArrayList;
        if (i < this.iL.size())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "speakingInfoList. uin = " + ((a)this.iL.get(i)).uin + ", audioEnergy = " + ((a)this.iL.get(i)).alU);
          }
          localObject2 = this.mApp.getDisplayName(n, ((a)this.iL.get(i)).uin, String.valueOf(localiiv.ll));
          localObject1 = localObject2;
          if (jji.length((String)localObject2) > 9) {
            localObject1 = jji.subString((String)localObject2, 0, 9) + "...";
          }
          if (i < this.iL.size() - 1) {}
          for (paramArrayList = paramArrayList + (String)localObject1 + ((Context)this.mContext.get()).getString(2131698104);; paramArrayList = paramArrayList + (String)localObject1)
          {
            i += 1;
            break;
          }
          localObject1 = ((Context)this.mContext.get()).getString(2131698105);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.aN().size() != 0)
        {
          paramArrayList = (ArrayList<a>)localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.aN().size() == 1)
          {
            paramArrayList = (ArrayList<a>)localObject1;
            if (((VideoController.b)this.jdField_a_of_type_ComTencentAvVideoController.aN().get(0)).uin != Long.parseLong(this.mApp.getCurrentAccountUin())) {}
          }
        }
        else
        {
          paramArrayList = "";
        }
        return paramArrayList;
        label1165:
        k = i;
        m = j;
      }
      label1174:
      i = 0;
    }
  }
  
  private void g(long paramLong, boolean paramBoolean, int paramInt)
  {
    int j = 0;
    if (((Activity)this.mContext.get() == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    boolean bool;
    label66:
    TextView localTextView;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) || (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0))
    {
      bool = true;
      if (!bool) {
        break label341;
      }
      i = 2131374266;
      localTextView = (TextView)this.mRootView.findViewById(i);
      localObject = Long.toString(paramLong);
      i = 0;
      label89:
      if (i >= this.iJ.size()) {
        break label461;
      }
      if (!((a)this.iJ.get(i)).uin.equalsIgnoreCase((String)localObject)) {
        break label362;
      }
      if (!paramBoolean) {
        break label349;
      }
      ((a)this.iJ.get(i)).alU = paramInt;
      if (paramInt < 10) {
        this.iJ.remove(i);
      }
    }
    label162:
    label461:
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) && (i == 0) && (paramInt > 10)) {
        this.iJ.add(new a((String)localObject, paramInt));
      }
      ((AVActivity)this.mContext.get()).b.P(paramLong, paramBoolean);
      if ((!bool) && (this.jdField_a_of_type_ComTencentAvVideoController.aN().size() <= 8)) {}
      for (this.Ru = "";; this.Ru = g((ArrayList)localObject))
      {
        localTextView.setText(this.Ru);
        QLog.d(this.TAG, 2, "refreshSpokesmanInfoContent. uin = " + paramLong + ", isSpeaking = " + paramBoolean + ", hasVideo = " + bool + ", member cnt = " + this.jdField_a_of_type_ComTencentAvVideoController.aN().size() + ", mSpokesmanNicknameListStr = " + this.Ru);
        return;
        bool = false;
        break;
        label341:
        i = 2131373920;
        break label66;
        label349:
        this.iJ.remove(i);
        break label162;
        label362:
        i += 1;
        break label89;
        localObject = new ArrayList();
        paramInt = j;
        while (paramInt < this.iJ.size())
        {
          ((ArrayList)localObject).add(new a(((a)this.iJ.get(paramInt)).uin, ((a)this.iJ.get(paramInt)).alU));
          paramInt += 1;
        }
      }
    }
  }
  
  public void E(long paramLong, int paramInt)
  {
    this.axA = paramInt;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b().tj())) {
      return;
    }
    this.mLastRotation = (360 - paramInt);
    c(paramLong, this.mLastRotation);
  }
  
  protected abstract void Fb();
  
  public void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    while (!paramBoolean1) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PQ) && (this.jdField_a_of_type_ComTencentAvVideoController.b().QB)) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.nQ(TraeHelper.aBf);
    }
    ate();
  }
  
  void I(long paramLong, int paramInt)
  {
    boolean bool = true;
    String str;
    if (paramInt <= 1)
    {
      str = this.mRes.getString(2131697753);
      bool = false;
    }
    for (;;)
    {
      this.mL.setClickable(bool);
      this.mL.setText(str);
      this.gy.setClickable(bool);
      if (bool) {
        break;
      }
      this.gy.setVisibility(8);
      return;
      str = String.format(this.mRes.getString(2131697525), new Object[] { Integer.valueOf(paramInt) });
    }
    this.gy.setVisibility(0);
  }
  
  void I(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.H(paramLong, paramBoolean);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.TAG, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
  }
  
  void J(long paramLong, int paramInt)
  {
    if (this.mL != null)
    {
      if ((QLog.isDevelopLevel()) || (this.mL.getVisibility() != paramInt)) {
        QLog.w(this.TAG, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.mL.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.mL.setVisibility(paramInt);
      CharSequence localCharSequence = this.mL.getText();
      if (TextUtils.equals(this.mRes.getString(2131697753), localCharSequence)) {
        this.gy.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.gy.setVisibility(paramInt);
  }
  
  protected void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.mZ(2131373947);
      if ((this.mApp != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.lZ() == 3) {
          break label58;
        }
        kv(true);
        this.mApp.l(new Object[] { Integer.valueOf(108) });
      }
    }
    label58:
    do
    {
      return;
      iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, 9, 3000L);
      break;
      super.mY(2131373947);
      iwu.a(this.jdField_a_of_type_ComTencentAvVideoController.mApp, false);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131373947, ((Context)this.mContext.get()).getString(2131694251));
      }
    } while ((this.mApp == null) || (!paramBoolean2));
    kv(false);
    this.mApp.l(new Object[] { Integer.valueOf(109) });
  }
  
  public boolean K(boolean paramBoolean)
  {
    int i = 2;
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    boolean bool2 = jkn.xL();
    boolean bool1;
    if ((!localiiv.QO) && (!localiiv.QP))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + localiiv.QI + "], micAuthByAdmin[" + localiiv.ane + "], openMic[" + paramBoolean + "]");
      }
      if ((!bool1) || (!localiiv.QI) || (localiiv.ane == 0)) {
        break label222;
      }
      if (!paramBoolean) {
        break label215;
      }
    }
    label215:
    for (int j = 2131697738;; j = 2131697931)
    {
      iwu.a(this.mApp, 1033, this.mRes.getString(j));
      if (paramBoolean) {
        i = 1;
      }
      anot.a(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", i, 0, "1", "", "", "");
      return true;
      bool1 = false;
      break;
    }
    label222:
    if ((!bool2) && (bool1) && (localiiv.ane == 1))
    {
      if (paramBoolean) {}
      for (j = 2131697741;; j = 2131697932)
      {
        iwu.a(this.mApp, 1033, this.mRes.getString(j));
        if (paramBoolean) {
          i = 1;
        }
        anot.a(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", i, 0, "2", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    String str;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "genDiscussTitle, name == null");
      }
      str = "";
    }
    TextPaint localTextPaint;
    float f2;
    float f1;
    do
    {
      do
      {
        return str;
        int i = wja.dp2px(160.0F, this.mRes);
        localTextPaint = paramTextView.getPaint();
        f2 = i - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - 4.0F * this.mRes.getDisplayMetrics().density;
        str = paramString;
      } while (f2 <= 0.0F);
      f1 = localTextPaint.measureText(paramString);
      str = paramString;
    } while (f1 <= f2);
    float f3 = f2 - localTextPaint.measureText("…");
    paramTextView = paramString;
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramTextView.length() > 0))
      {
        paramTextView = paramTextView.substring(0, paramTextView.length() - 1);
        f2 = localTextPaint.measureText(paramTextView);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramTextView.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d(this.TAG, 2, "genDiscussTitle, name widht[" + f1 + "]");
        }
      }
      else
      {
        str = paramString;
        if (f3 <= 0.0F) {
          break;
        }
        str = paramString;
        if (paramTextView.length() <= 0) {
          break;
        }
        return paramTextView + "…";
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (isDestroyed()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "refreshUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], audioEnergy[" + paramInt3 + "]");
      }
    } while (paramLong == 0L);
    RefreshUIRunnable localRefreshUIRunnable = new RefreshUIRunnable(paramLong, paramInt1, paramBoolean, paramInt2);
    AVActivity localAVActivity = a();
    localAVActivity.runOnUiThread(localRefreshUIRunnable);
    if (this.jdField_b_of_type_ComTencentAvUiMultiMembersVideoUI != null)
    {
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.c(this.mSelfUin, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.ss());
      localAVActivity.b.Q(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.ss());
    }
    if (paramInt2 == 42) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      g(paramLong, paramBoolean, paramInt3);
      atk();
      return;
    }
  }
  
  void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "notifyDataChangeByQuitUin, from[" + paramString + "], seq[" + paramLong1 + "]");
    }
    Object localObject;
    if ((paramInt == 1) && (this.mContext.get() != null))
    {
      localObject = (Activity)this.mContext.get();
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      if (this.auE == 3) {
        break label111;
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      ((VideoController)localObject).k(paramLong2, bool);
      x(paramLong1, paramString);
      return;
    }
  }
  
  boolean aA(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "checkRemoteVideo, displayViewList[" + localiiv.jdField_if.size() + "], seq[" + paramLong + "]");
    }
    if (localiiv.jdField_if.size() == 0)
    {
      w(paramLong, "checkRemoteVideo");
      g(false, false, false);
      return false;
    }
    if ((localiiv.jdField_if.size() == 1) && (((ioa)localiiv.jdField_if.get(0)).uin == this.mSelfUin))
    {
      g(false, false, false);
      jJ("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  void aG(Intent paramIntent)
  {
    try
    {
      this.mSelfUin = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      this.mUinType = localiiv.uinType;
      if (this.mUinType == 3000)
      {
        this.aqx = 2;
        localiiv.relationType = this.aqx;
        int i = localiiv.anc;
        this.oC = localiiv.ll;
        this.awD = localiiv.anc;
        this.Xl = false;
        if (paramIntent != null) {
          this.isVideo = paramIntent.getBooleanExtra("isVideo", false);
        }
        QLog.w(this.TAG, 1, "processIntentData, mUinType[" + this.mUinType + "], mRelationType[" + this.aqx + "], mIntentRelationId[" + this.oC + "], mStatusType[" + this.awD + "], mStatusType[" + i + "->" + this.awD + "], getSimpleDataList[" + this.jdField_a_of_type_ComTencentAvVideoController.aP() + "], getGAudioList[" + this.jdField_a_of_type_ComTencentAvVideoController.aN() + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Can not get AccountUin WHY!!!???");
        }
        this.mSelfUin = 0L;
        continue;
        if (this.mUinType == 1) {
          this.aqx = 1;
        }
      }
    }
  }
  
  ArrayList<VideoController.b> aS()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.aN();
    }
    return null;
  }
  
  public void asA()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Jko != null) {
      this.jdField_a_of_type_Jko.cancelNotification(this.jdField_a_of_type_ComTencentAvVideoController.b().sessionId);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.alM();
  }
  
  public void asB()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "showNotification quit[" + this.mQuit + "], inRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.OB + "]");
      }
    } while ((this.mQuit) || (!this.jdField_a_of_type_ComTencentAvVideoController.OB));
    String str1;
    String str2;
    Bitmap localBitmap;
    if (this.jdField_a_of_type_Jko != null)
    {
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      str1 = String.valueOf(localiiv.ll);
      str2 = this.mApp.getDisplayName(this.mUinType, str1, null);
      localBitmap = this.mApp.a(this.mUinType, str1, null, true, true);
      i = 44;
      if (localiiv.td()) {
        if (localiiv.amI != 3) {
          break label205;
        }
      }
    }
    label205:
    for (int i = 62;; i = 63)
    {
      this.jdField_a_of_type_Jko.a(this.jdField_a_of_type_ComTencentAvVideoController.b().sessionId, str2, localBitmap, str1, i, this.mUinType, this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
      this.jdField_a_of_type_ComTencentAvVideoController.alL();
      return;
    }
  }
  
  abstract void atc();
  
  abstract void atd();
  
  public abstract void ate();
  
  void atj()
  {
    long l2 = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "initViewList, seq[" + l2 + "]");
    }
    if ((this.awD == 0) || (this.awD == 1)) {}
    for (long l1 = this.oC;; l1 = this.jdField_a_of_type_ComTencentAvVideoController.kJ)
    {
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.b(l1, this.aqx, false);
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_b_of_type_Jka);
      x(l2, "initViewList");
      return;
    }
  }
  
  public void atk()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject1;
    label153:
    label240:
    do
    {
      ImageView localImageView;
      do
      {
        return;
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().PY) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() <= 0)) {
          break;
        }
        i = 1;
        localObject1 = (TextView)this.mRootView.findViewById(2131373920);
        localObject2 = (TextView)this.mRootView.findViewById(2131374266);
        localImageView = (ImageView)this.mRootView.findViewById(2131373953);
        if (i == 0) {
          break label332;
        }
        ((TextView)localObject1).setVisibility(8);
        if ((!sIsSpecialDevice) && (!this.Xk))
        {
          QLog.d(this.TAG, 2, "refreshSpokesmanInfoUI video. txt = " + this.Ru);
          if (!this.Ya) {
            break label308;
          }
          i = 71;
          j = i;
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            j = i - ImmersiveUtils.getStatusBarHeight((Context)this.mContext.get());
          }
          localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)jll.dp2px(this.jdField_a_of_type_ComTencentAvVideoController.mApp.getApp().getApplicationContext(), j));
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((TextView)localObject2).setText(this.Ru);
          if (this.Ru.length() <= 0) {
            break label314;
          }
          i = 0;
          ((TextView)localObject2).setVisibility(i);
          if (this.Ru.length() <= 0) {
            break label320;
          }
          i = k;
          localImageView.setVisibility(i);
        }
        localObject1 = a();
      } while ((localObject1 == null) || (((AVActivity)localObject1).b == null));
      if (this.Ya) {}
      for (i = 115;; i = 65)
      {
        ((AVActivity)localObject1).b.nk(i);
        return;
        i = 0;
        break;
        i = 21;
        break label153;
        i = 8;
        break label240;
        i = 8;
        break label258;
      }
      ((TextView)localObject2).setVisibility(8);
      localImageView.setVisibility(8);
    } while (sIsSpecialDevice);
    label258:
    label308:
    label314:
    label320:
    label332:
    ((TextView)localObject1).setText(this.Ru);
    Object localObject2 = a();
    if (((localObject2 != null) && (((AVActivity)localObject2).a != null) && (((AVActivity)localObject2).a.xh())) || (this.jdField_a_of_type_ComTencentAvVideoController.aN().size() <= 8))
    {
      QLog.d(this.TAG, 2, "refreshSpokesmanInfoUI audio. txt = " + this.Ru + ", isSoftKeyboardShown = " + ((AVActivity)localObject2).a.xh() + ", member cnt = " + this.jdField_a_of_type_ComTencentAvVideoController.aN().size());
      ((TextView)localObject1).setVisibility(8);
      label480:
      if (((TextView)localObject1).getVisibility() == 0) {
        this.mRootView.findViewById(2131374119).setVisibility(8);
      }
    }
    else
    {
      QLog.d(this.TAG, 2, "refreshSpokesmanInfoUI audio. txt = " + this.Ru);
      if (this.Ru.length() <= 0) {
        break label556;
      }
    }
    label556:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject1).setVisibility(i);
      break label480;
      break;
    }
  }
  
  void atl()
  {
    long l = AudioHelper.hG();
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("startOrResumeRemoteOrLocalVideo, seq[").append(l).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "]");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label89;
      }
    }
    label89:
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {
        break label117;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
    return;
    label117:
    int j = this.jdField_a_of_type_ComTencentAvVideoController.ky();
    int k = this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, 1);
    int i;
    if (k != -1)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "startOrResumeRemoteOrLocalVideo, onStageNum[" + j + "], index[" + k + "]");
      }
      if ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb)) {
        break label389;
      }
      if (i != 0)
      {
        if (j >= auk) {
          break label341;
        }
        if (!wk()) {
          break label281;
        }
        O(l, 65535);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() <= 0) {
        break label384;
      }
      vF();
      return;
      i = 0;
      break;
      label281:
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.alN();
      continue;
      label341:
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.alN();
    }
    label384:
    auV();
    return;
    label389:
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.alN();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().a(l, "startOrResumeRemoteOrLocalVideo", true, true);
      v("startOrResumeRemoteOrLocalVideo", l);
      if (!aqiw.isNetworkAvailable((Context)this.mContext.get()))
      {
        DoubleVideoCtrlUI.b(this.mApp, 0);
        return;
      }
      g(true, true, true);
      return;
    }
    auV();
  }
  
  void atm()
  {
    auQ();
    iwu.a(this.mApp, 1036);
    iwu.a(this.mApp, 1037);
    iwu.b(this.mApp, 1030);
    this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, true, true);
    g(true, false, true);
  }
  
  public void atn()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().ani == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel() != 4) {
        break label131;
      }
      i = 3;
      if ((i != 3) || (jkn.xG())) {
        break label136;
      }
      i = 4;
    }
    label131:
    label136:
    for (;;)
    {
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      if (localAVActivity != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.TAG, 4, "initScreenLayout Style=" + i + "|" + this.jdField_a_of_type_ComTencentAvVideoController.b().ani + "|" + this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel());
        }
        localAVActivity.G(i, false);
      }
      return;
      i = 4;
      break;
    }
  }
  
  void ato()
  {
    long l = AudioHelper.hG();
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "refreshMemberCtrlButton, SessionType[" + localiiv.amI + "], multiAVType[" + localiiv.anb + "], mUinType[" + this.mUinType + "], isManager[" + localiiv.QO + "], isRoomCreator[" + localiiv.QP + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.OB + "]");
    O(l, 65535);
  }
  
  public void atp()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int i = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.mApp.getCurrentAccountUin() + ".level", 1);
    int j = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.mApp.getCurrentAccountUin() + ".sendDura", 5000);
    int k = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.mApp.getCurrentAccountUin() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.v(i, j, k);
  }
  
  abstract void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  protected long bN()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {
      return this.md;
    }
    return this.oC;
  }
  
  public void bZ(long paramLong) {}
  
  void c(long paramLong, View paramView)
  {
    QLog.w(this.TAG, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.b().Qd + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      ds(paramLong);
    }
    super.dE(paramLong);
  }
  
  /* Error */
  public void c(String arg1, int paramInt1, String paramString2, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: aload_3
    //   4: iload 4
    //   6: invokespecial 1104	com/tencent/av/ui/VideoControlUI:c	(Ljava/lang/String;ILjava/lang/String;I)V
    //   9: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +62 -> 74
    //   15: aload_0
    //   16: getfield 333	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:TAG	Ljava/lang/String;
    //   19: iconst_2
    //   20: new 335	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 1106
    //   30: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1108
    //   40: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc_w 1110
    //   50: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 1112
    //   60: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 4
    //   65: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: ifnonnull +4 -> 83
    //   82: return
    //   83: aload_0
    //   84: getfield 1114	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:Xm	Z
    //   87: ifne -5 -> 82
    //   90: aload_3
    //   91: invokestatic 776	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 779	java/lang/Long:longValue	()J
    //   97: lstore 6
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne +20 -> 121
    //   104: aload_0
    //   105: sipush 1036
    //   108: invokevirtual 1117	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mX	(I)V
    //   111: aload_0
    //   112: getfield 271	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   115: sipush 1036
    //   118: invokestatic 1009	iwu:a	(Lcom/tencent/av/app/VideoAppInterface;I)V
    //   121: aload_0
    //   122: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   125: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   128: aload_1
    //   129: invokestatic 776	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   132: invokevirtual 779	java/lang/Long:longValue	()J
    //   135: iload_2
    //   136: invokevirtual 947	iiv:b	(JI)I
    //   139: istore 5
    //   141: iload 5
    //   143: iconst_m1
    //   144: if_icmpeq -62 -> 82
    //   147: aload_0
    //   148: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   151: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   154: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   157: iload 5
    //   159: invokevirtual 350	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   162: checkcast 764	ioa
    //   165: astore_3
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   173: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   176: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   179: invokevirtual 308	java/util/ArrayList:size	()I
    //   182: if_icmpge +371 -> 553
    //   185: aload_0
    //   186: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   189: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   192: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   195: iload_2
    //   196: invokevirtual 350	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   199: checkcast 764	ioa
    //   202: astore 8
    //   204: lload 6
    //   206: aload 8
    //   208: getfield 765	ioa:uin	J
    //   211: lcmp
    //   212: ifne +365 -> 577
    //   215: iload 4
    //   217: aload 8
    //   219: getfield 1120	ioa:videoSrcType	I
    //   222: if_icmpne +355 -> 577
    //   225: aload_3
    //   226: iconst_0
    //   227: putfield 1123	ioa:Tp	Z
    //   230: aload_3
    //   231: getfield 765	ioa:uin	J
    //   234: aload_0
    //   235: getfield 141	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mSelfUin	J
    //   238: lcmp
    //   239: ifeq +32 -> 271
    //   242: aload 8
    //   244: getfield 765	ioa:uin	J
    //   247: aload_0
    //   248: getfield 141	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mSelfUin	J
    //   251: lcmp
    //   252: ifeq +19 -> 271
    //   255: iconst_4
    //   256: aload_0
    //   257: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   260: invokevirtual 1022	com/tencent/av/VideoController:getVideoAbilityLevel	()I
    //   263: if_icmpeq +8 -> 271
    //   266: aload_3
    //   267: iconst_0
    //   268: putfield 1126	ioa:Tq	Z
    //   271: aload 8
    //   273: iconst_1
    //   274: putfield 1123	ioa:Tp	Z
    //   277: iconst_4
    //   278: aload_0
    //   279: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   282: invokevirtual 1022	com/tencent/av/VideoController:getVideoAbilityLevel	()I
    //   285: if_icmpeq +55 -> 340
    //   288: aload 8
    //   290: getfield 1126	ioa:Tq	Z
    //   293: ifne +47 -> 340
    //   296: aload_0
    //   297: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   300: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   303: aload_0
    //   304: getfield 141	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mSelfUin	J
    //   307: invokevirtual 1129	iiv:w	(J)I
    //   310: istore 4
    //   312: iload 4
    //   314: iconst_m1
    //   315: if_icmpeq +25 -> 340
    //   318: aload_0
    //   319: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   322: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   325: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   328: iload 4
    //   330: invokevirtual 350	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   333: checkcast 764	ioa
    //   336: iconst_0
    //   337: putfield 1126	ioa:Tq	Z
    //   340: aload 8
    //   342: iconst_1
    //   343: putfield 1126	ioa:Tq	Z
    //   346: aload 8
    //   348: getfield 765	ioa:uin	J
    //   351: aload_0
    //   352: getfield 141	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mSelfUin	J
    //   355: lcmp
    //   356: ifne +38 -> 394
    //   359: aload_0
    //   360: getfield 137	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:aqx	I
    //   363: iconst_2
    //   364: if_icmpne +30 -> 394
    //   367: aconst_null
    //   368: ldc_w 652
    //   371: ldc 195
    //   373: ldc 195
    //   375: ldc_w 1131
    //   378: ldc_w 1131
    //   381: iconst_0
    //   382: iconst_0
    //   383: ldc 195
    //   385: ldc 195
    //   387: ldc 195
    //   389: ldc 195
    //   391: invokestatic 648	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 8
    //   396: getfield 1134	ioa:isRender	Z
    //   399: ifne +27 -> 426
    //   402: aload_0
    //   403: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   406: invokevirtual 1022	com/tencent/av/VideoController:getVideoAbilityLevel	()I
    //   409: iconst_4
    //   410: if_icmpeq +16 -> 426
    //   413: aload_0
    //   414: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   417: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   420: getfield 1040	iiv:anb	I
    //   423: invokestatic 1139	jjk:nG	(I)V
    //   426: aload_0
    //   427: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   430: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   433: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   436: iload 5
    //   438: aload 8
    //   440: invokevirtual 1143	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: aload_0
    //   445: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   448: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   451: getfield 429	iiv:if	Ljava/util/ArrayList;
    //   454: iload_2
    //   455: aload_3
    //   456: invokevirtual 1143	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload_0
    //   461: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   464: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   467: getfield 975	iiv:ig	Ljava/util/ArrayList;
    //   470: astore_1
    //   471: aload_1
    //   472: monitorenter
    //   473: aload_0
    //   474: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   477: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   480: getfield 975	iiv:ig	Ljava/util/ArrayList;
    //   483: iload 5
    //   485: aload 8
    //   487: invokevirtual 1143	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: aload_0
    //   492: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   495: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   498: getfield 975	iiv:ig	Ljava/util/ArrayList;
    //   501: iload_2
    //   502: aload_3
    //   503: invokevirtual 1143	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_0
    //   508: getfield 246	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   511: invokevirtual 293	com/tencent/av/VideoController:b	()Liiv;
    //   514: invokevirtual 1145	iiv:amI	()V
    //   517: aload_1
    //   518: monitorexit
    //   519: aload_0
    //   520: getfield 312	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:mContext	Ljava/lang/ref/WeakReference;
    //   523: invokevirtual 318	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   526: checkcast 446	com/tencent/av/ui/AVActivity
    //   529: getfield 449	com/tencent/av/ui/AVActivity:b	Lcom/tencent/av/ui/VideoLayerUI;
    //   532: aload 8
    //   534: getfield 765	ioa:uin	J
    //   537: aload 8
    //   539: getfield 1120	ioa:videoSrcType	I
    //   542: aload_3
    //   543: getfield 765	ioa:uin	J
    //   546: aload_3
    //   547: getfield 1120	ioa:videoSrcType	I
    //   550: invokevirtual 1148	com/tencent/av/ui/VideoLayerUI:b	(JIJI)V
    //   553: aload_0
    //   554: invokevirtual 970	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:vF	()Z
    //   557: pop
    //   558: return
    //   559: astore_1
    //   560: aload_0
    //   561: getfield 333	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:TAG	Ljava/lang/String;
    //   564: iconst_2
    //   565: ldc_w 1150
    //   568: invokestatic 562	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: return
    //   572: astore_3
    //   573: aload_1
    //   574: monitorexit
    //   575: aload_3
    //   576: athrow
    //   577: iload_2
    //   578: iconst_1
    //   579: iadd
    //   580: istore_2
    //   581: goto -413 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	MultiVideoCtrlLayerUIBase
    //   0	584	2	paramInt1	int
    //   0	584	3	paramString2	String
    //   0	584	4	paramInt2	int
    //   139	345	5	i	int
    //   97	108	6	l	long
    //   202	336	8	localioa	ioa
    // Exception table:
    //   from	to	target	type
    //   90	99	559	java/lang/Exception
    //   473	519	572	finally
    //   573	575	572	finally
  }
  
  public void cD(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "goOffStage, seq[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_c_of_type_Iya == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.alO();
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "goOffStage", false, false);
    this.jdField_c_of_type_Iya.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    setViewVisibility(2131374249, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.jl(false);
    }
    v("goOffStage", paramLong);
  }
  
  public void cU(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onStart, seq[" + paramLong + "]");
    }
    super.cU(paramLong);
    if (this.Xi)
    {
      dp(this.md);
      this.Xi = false;
    }
  }
  
  public void cV(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onResume, seq[" + paramLong + "]");
    }
    super.cV(paramLong);
    jdMethod_do(paramLong);
    dq(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground = false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.OB)) {
      resumeVideo();
    }
    if (this.bF == null)
    {
      this.bF = new RefreshFaceRunnable();
      this.mApp.getHandler().postDelayed(this.bF, 2000L);
    }
  }
  
  public void cW(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 2, "onStop, seq[" + paramLong + "]");
    }
    super.cW(paramLong);
    asB();
    this.Xi = false;
  }
  
  public int cv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onApnChanged --> NetType = " + paramInt);
    }
    DoubleVideoCtrlUI.b(this.mApp, paramInt);
    if ((aqiw.isWifiConnected((Context)this.mContext.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.OB) && (this.Xm)) {
      vF();
    }
    return 0;
  }
  
  void d(long paramLong, View paramView)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "onClick_CAMERA, sessionInfo[" + localiiv + "], mHasLauncnRequestFromCameraButton[" + this.Xl + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      if (localiiv.PY) {
        break label321;
      }
      if (!wl()) {
        break label94;
      }
      label94:
      while (K(false)) {
        return;
      }
      jjk.lb(true);
      if (aqiw.isWifiConnected((Context)this.mContext.get())) {
        break label352;
      }
      if (VideoController.ag(VideoController.Mp + this.mApp.getCurrentAccountUin()) <= 0) {
        break label358;
      }
    }
    label278:
    label321:
    label352:
    label358:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        paramView = (Context)this.mContext.get();
        if (paramView == null) {
          break;
        }
        aqha.a(paramView, 230, this.mRes.getString(2131697879), this.mRes.getString(2131697875), 2131697614, 2131697626, new jbe(this, paramLong), new jbf(this)).show();
      }
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          if ((localiiv.kK() != -1) || (aqiw.isWifiConnected((Context)this.mContext.get()))) {
            break label278;
          }
          dr(paramLong);
        }
        for (;;)
        {
          S(paramLong, 2131697526);
          return;
          if (wk())
          {
            this.Xl = true;
            O(paramLong, 65535);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.TAG, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
            continue;
            cD(paramLong);
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, localiiv.jdField_if, localiiv.ig, 1, false);
          }
        }
      }
    }
  }
  
  public void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    atk();
  }
  
  public void da(long paramLong) {}
  
  public void de(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "OnPause, seq[" + paramLong + "]");
    }
    super.de(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().isBackground = true;
    this.mApp.iw("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!ivv.tY()) || ((!aqiw.isWifiConnected((Context)this.mContext.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rb))) && (this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
        cD(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().kK() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.ck("Multi_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().b(this.mSelfUin, true, true);
    }
    this.mApp.getHandler().removeCallbacks(this.cc);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog deniedForAudioRecord(2) 10");
  }
  
  void jdMethod_do(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.OB))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.ss())
      {
        super.mY(2131373947);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.kb(this.jdField_a_of_type_ComTencentAvVideoController.ss());
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.alI();
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().state != 9) {
        break label113;
      }
      M(paramLong, true);
      P(paramLong, 2131697753);
    }
    for (;;)
    {
      dC(paramLong);
      this.jdField_a_of_type_Jkz.lj(true);
      this.jdField_a_of_type_Jkz.li(true);
      return;
      label113:
      M(paramLong, false);
      z(paramLong, null);
    }
  }
  
  void dp(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendVideoMsgBroadcast--> discussionId = " + paramLong);
    }
    if (this.mApp != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.AddVideoMsg");
        localIntent.putExtra("uinType", this.mUinType);
        localIntent.putExtra("msgType", 13);
        localIntent.putExtra("isVideoMsg", false);
        localIntent.putExtra("friendUin", Long.toString(paramLong));
        localIntent.putExtra("senderUin", this.mApp.getCurrentAccountUin());
        localIntent.putExtra("isSender", true);
        localIntent.putExtra("isRead", true);
        localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.b().anb);
        localIntent.setPackage(this.mApp.getApplication().getPackageName());
        this.mApp.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  public void dq(long paramLong)
  {
    if (isDestroyed()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.OB)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373947, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.i(2131373947, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.ss()) {
        break label117;
      }
      mY(2131373947);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.kb(this.jdField_a_of_type_ComTencentAvVideoController.ss());
      }
      ato();
      long l = this.md;
      this.mApp.T(this.mUinType, String.valueOf(l));
      O(paramLong, 65535);
      dC(paramLong);
      return;
      label117:
      mZ(2131373947);
    }
  }
  
  public void dr(long paramLong)
  {
    Context localContext = (Context)this.mContext.get();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("goOnStageWithoutWiFiCheck, mContext[");
    if (localContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], seq[" + paramLong + "]");
      if (localContext != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().isVideo()) {}
    for (int i = 2131697891;; i = 2131697892)
    {
      aqha.a(localContext, 230, null, this.mRes.getString(i), 2131697614, 2131697626, new jbj(this, paramLong), new jbk(this)).show();
      return;
    }
  }
  
  void ds(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.wr()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.ws()))
    {
      QLog.d(this.TAG, 1, "intercept doMute operation");
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.ss();
    if (this.jdField_a_of_type_ComTencentAvVideoController.OB) {}
    for (long l = this.md;; l = this.oC)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "doMute, relationId[" + l + "], mute[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break label282;
      }
      if (K(true)) {
        break;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PQ) {
        break label172;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.TAG, 1, "PhoneCalling-status not support open MIC");
      return;
    }
    label172:
    if (this.aqx == 2) {
      jjk.D(true, 1);
    }
    int i;
    for (;;)
    {
      kv(true);
      i = this.jdField_a_of_type_ComTencentAvVideoController.kB();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.1", l, true, true, -1);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.1", i, this.jdField_a_of_type_ComTencentAvVideoController.kB(), false);
      }
      super.mZ(2131373947);
      if (this.mApp == null) {
        break;
      }
      this.mApp.l(new Object[] { Integer.valueOf(108) });
      return;
      jjk.D(true, 10);
    }
    label282:
    if (this.aqx == 2) {
      jjk.D(false, 1);
    }
    for (;;)
    {
      kv(false);
      i = this.jdField_a_of_type_ComTencentAvVideoController.kB();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.2", l, false, true, -1);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.2", i, this.jdField_a_of_type_ComTencentAvVideoController.kB(), false);
      }
      super.mY(2131373947);
      if (this.mApp == null) {
        break;
      }
      this.mApp.l(new Object[] { Integer.valueOf(109) });
      return;
      jjk.D(false, 10);
    }
  }
  
  public void dt(long paramLong)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "go on stage failed, info[" + paramLong + "]");
    }
    setViewVisibility(2131374249, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.jl(false);
    }
    O(l, 65535);
    if (paramLong == 7L) {
      iwu.b(this.mApp, 1029);
    }
    for (;;)
    {
      if (this.aqx == 2) {
        anot.a(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      }
      return;
      if (paramLong == 8L) {
        iwu.a(this.mApp, 1033, this.mRes.getString(2131697931));
      } else {
        iwu.b(this.mApp, 1028);
      }
    }
  }
  
  void du(long paramLong)
  {
    QLog.d(this.TAG, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      j = localAVActivity.lI();
      if (3 != j) {
        break label140;
      }
      i = 1;
      if (4 != j) {
        break label145;
      }
      j = 1;
      label77:
      if (j == 0) {
        break label151;
      }
      anot.a(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      label109:
      if ((j == 0) && (i == 0)) {
        break label186;
      }
      if (i == 0) {
        break label181;
      }
      i = 4;
      label124:
      localAVActivity.G(i, false);
    }
    for (;;)
    {
      S(paramLong, 2131697537);
      return;
      label140:
      i = 0;
      break;
      label145:
      j = 0;
      break label77;
      label151:
      anot.a(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      break label109;
      label181:
      i = 3;
      break label124;
      label186:
      QLog.d(this.TAG, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
    }
  }
  
  void dv(long paramLong)
  {
    dw(paramLong);
    S(paramLong, 2131697528);
  }
  
  void dw(long paramLong)
  {
    boolean bool = false;
    QLog.d(this.TAG, 1, "OnClick_MemberInfo");
    anot.a(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    AVActivity localAVActivity = (AVActivity)this.mContext.get();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().QO) || (this.jdField_a_of_type_ComTencentAvVideoController.b().QP)) {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), bool, true);
  }
  
  protected void dx(long paramLong)
  {
    if (!VideoController.sm()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    localiiv.p(paramLong, true);
    long l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    int i = 0;
    if (i < localiiv.jdField_if.size())
    {
      ioa localioa = (ioa)localiiv.jdField_if.get(i);
      if ((localioa.uin == l) && (localioa.videoSrcType == 2)) {
        localioa.isRender = true;
      }
      for (localioa.Tr = true;; localioa.Tr = false)
      {
        i += 1;
        break;
        localioa.isRender = false;
      }
    }
    localiiv.e(-1L, "onUserScreenShareOpen", 4);
    v("onUserScreenShareOpen", paramLong);
    f(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
  }
  
  protected void dy(long paramLong)
  {
    if (!VideoController.sm()) {
      return;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    localiiv.p(paramLong, false);
    if (localiiv.jdField_if.size() == 0) {
      localiiv.e(-1L, "onUserScreenShareOpen", 3);
    }
    aA(paramLong);
    v("onUserScreenShareClose", paramLong);
  }
  
  abstract void e(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public void f(long paramLong, ArrayList<ioa> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        ioa localioa = (ioa)paramArrayList.get(i);
        if ((localioa.uin == this.mSelfUin) && (localioa.videoSrcType == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().PY)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_c_of_type_Iya.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        return;
      }
      i += 1;
    }
  }
  
  void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + paramBoolean1 + " , needNoticeWiFiTips = " + paramBoolean2 + " , needShowGLView = " + paramBoolean3);
    }
    this.Xm = paramBoolean1;
    this.jdField_a_of_type_ComTencentAvVideoController.b().hY(paramBoolean1);
    if (this.jdField_b_of_type_Iwq != null) {
      this.jdField_b_of_type_Iwq.a(paramBoolean1, new jbl(this));
    }
    if (paramBoolean1)
    {
      jjk.G(aqiw.isWifiConnected((Context)this.mContext.get()), this.jdField_a_of_type_ComTencentAvVideoController.b().anb);
      auV();
      if (paramBoolean2) {
        iwu.b(this.mApp, 3013);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        f(AudioHelper.hG(), this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
      }
      return;
      iwu.a(this.mApp, 3013);
      continue;
      iwu.a(this.mApp, 3013);
      iwu.a(this.mApp, 1030);
    }
  }
  
  public Intent getIntent()
  {
    if (this.mContext != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      if (localAVActivity != null) {
        return localAVActivity.getIntent();
      }
    }
    return null;
  }
  
  protected int getLayout()
  {
    return 2131559901;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.TAG, 1, "showPermissionDialog grantForAudioRecord(2) 09");
  }
  
  public void h(int paramInt1, int paramInt2, String paramString)
  {
    super.h(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onVideoViewModeChange --> lastMode = " + paramInt1 + " , currentMode = " + paramInt2 + ",bigUin=" + paramString);
    }
    if ((paramInt1 == paramInt2) || (this.Xm)) {}
    label95:
    label98:
    label230:
    do
    {
      return;
      boolean bool;
      int i;
      if (paramInt2 == 3)
      {
        bool = true;
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel()) {
          break label225;
        }
        paramInt1 = 1;
        i = 1;
        if (i >= this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size()) {
          continue;
        }
        paramString = (ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i);
        paramString.Tp = bool;
        if ((paramInt1 != 0) && (!paramString.Tq))
        {
          int j = this.jdField_a_of_type_ComTencentAvVideoController.b().w(this.mSelfUin);
          if (j != -1) {
            ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(j)).Tq = false;
          }
        }
        if ((paramInt2 != 3) || (paramInt1 == 0)) {
          break label230;
        }
      }
      for (paramString.Tq = false;; paramString.Tq = true)
      {
        i += 1;
        break label98;
        bool = false;
        break;
        paramInt1 = 0;
        break label95;
      }
    } while (!vF());
    label225:
    this.jdField_a_of_type_ComTencentAvVideoController.b().QQ = true;
  }
  
  void h(long paramLong, ArrayList<VideoController.b> paramArrayList)
  {
    if (isDestroyed()) {}
    int i;
    do
    {
      return;
      if (paramArrayList != null) {
        break;
      }
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "doInternalUIFreash, gaFList[" + i + "], seq[" + paramLong + "]");
      }
    } while (this.mRes == null);
    if (i <= 1) {
      P(paramLong, 2131697753);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI != null)
      {
        this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.bC(paramArrayList);
        atk();
      }
      ((AVActivity)this.mContext.get()).b.bG(paramArrayList);
      I(paramLong, i);
      return;
      i = paramArrayList.size();
      break;
      z(paramLong, null);
    }
  }
  
  void initUI()
  {
    long l = AudioHelper.hG();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.TAG, 1, "initUI, SessionType[" + ((iiv)localObject1).amI + "], switchToGAudioMode[" + ((iiv)localObject1).and + "], localMute[" + ((iiv)localObject1).PV + "], seq[" + l + "]");
    super.initUI();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      Fb();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.atX();
      localObject2 = (Activity)this.mContext.get();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_Jkz = jkz.a(this.jdField_a_of_type_Jkz, (Activity)localObject2, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_Jkz.lh(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
      }
    }
    this.mZ.post(this.bX);
    R(l, 8);
    this.mUserName = ((TextView)this.mRootView.findViewById(2131373990));
    this.mL = ((TextView)this.mRootView.findViewById(2131371237));
    this.gy = ((ImageView)this.mRootView.findViewById(2131377282));
    this.mK = ((TextView)this.mRootView.findViewById(2131373991));
    O(l, 65535);
    Object localObject2 = (AVActivity)this.mContext.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.ee = ((RelativeLayout)this.mRootView.findViewById(2131374244));
    this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.mRootView.findViewById(2131374139));
    this.jdField_b_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.mRootView.findViewById(2131374140));
    int i = ImmersiveUtils.getScreenHeight();
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i -= ImmersiveUtils.getStatusBarHeight((Context)this.mContext.get());
    }
    for (;;)
    {
      i = (int)(i * 58 / 1000.0F);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
      localMarginLayoutParams.topMargin = i;
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localMarginLayoutParams);
      this.jdField_b_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
      atj();
      jjp.bz(((AVActivity)localObject2).getApplicationContext());
      if (this.jdField_a_of_type_ComTencentAvVideoController.OB)
      {
        this.jdField_a_of_type_Jkz.li(true);
        this.jdField_a_of_type_Jkz.lj(true);
        if ((this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.xe())) {
          this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.avG();
        }
      }
      if ((((iiv)localObject1).sU()) && (((iiv)localObject1).PV))
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.kB();
        this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", ((iiv)localObject1).ll, false, true, -1);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.initUI", i, this.jdField_a_of_type_ComTencentAvVideoController.kB(), false);
        }
        super.mY(2131373947);
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axH();
      if (this.bW == null) {
        this.bW = new RefreshDisplayNameRunnable();
      }
      this.mApp.getHandler().post(this.bW);
      this.jdField_a_of_type_Jcr = new jcr((Context)this.mContext.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.er, null, null, this.mUserName, this.mRootView.findViewById(2131374119), null);
      this.jdField_a_of_type_Jcr.atK();
      if (((iiv)localObject1).amI == 4) {
        v("initUI", l);
      }
      ((AVActivity)this.mContext.get()).b.Q(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.ss());
      if (AudioHelper.jY(0) == 1) {
        this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(531496751);
      }
      localObject1 = (ImageView)this.mRootView.findViewById(2131373953);
      ((ImageView)localObject1).setOnClickListener(new jbh(this, (ImageView)localObject1));
      return;
    }
  }
  
  protected abstract boolean isFull();
  
  public void jI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.bD != null) {
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bD, 30000L);
      return;
      this.bD = new RequestVideoTimeOutRunnable();
    }
  }
  
  public void jJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "removeRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.bD != null) {
      this.mApp.getHandler().removeCallbacks(this.bD);
    }
  }
  
  void jR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.eq.setVisibility(0);
      this.mK.setVisibility(0);
      this.mUserName.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.nl(8);
      }
    }
    do
    {
      return;
      this.eq.setVisibility(8);
      this.mUserName.setVisibility(0);
      this.mK.setVisibility(8);
    } while (this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar == null);
    this.jdField_b_of_type_ComTencentAvUiVideoNetStateBar.nl(0);
  }
  
  void jS(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.mContext.get();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "switchMode --> Can not get activity");
      }
    }
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131373997);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.mRes.getColor(2131167595));
      } while (localObject == null);
      ((AVActivity)localObject).jm(false);
      ((AVActivity)localObject).jq(false);
      ((AVActivity)localObject).jn(true);
      return;
      localRelativeLayout.setBackgroundColor(this.mRes.getColor(2131166293));
    } while (localObject == null);
    ((AVActivity)localObject).jm(true);
    ((AVActivity)localObject).jq(true);
    ((AVActivity)localObject).jn(false);
  }
  
  public void jf(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (this.jdField_a_of_type_Atan == null)
    {
      this.jdField_a_of_type_Atan = new atan((Context)this.mContext.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (jjp.cK("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_Atan.a(l, 2, 0, null, jjp.hr() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!jjp.cK("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_Atan.dN(l);
      break;
    }
    this.jdField_a_of_type_Atan.a(l, 2, 0, null, jjp.hr() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  public void jg(boolean paramBoolean)
  {
    this.mQuit = paramBoolean;
    this.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(this.oC), Boolean.valueOf(paramBoolean) });
    if (this.mQuit) {
      asA();
    }
  }
  
  abstract void l(Intent paramIntent);
  
  public void mj(int paramInt)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().tj())
    {
      ml(paramInt);
      dE(l);
    }
  }
  
  public void mk(int paramInt) {}
  
  public void mp(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onLayoutModeChange --> ScreenType = " + paramInt + " , hasSetBigVideoView = " + this.jdField_a_of_type_ComTencentAvVideoController.b().tl());
    }
    Iterator localIterator;
    ioa localioa;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.iterator();
        while (localIterator.hasNext())
        {
          localioa = (ioa)localIterator.next();
          if (!localioa.Tp) {
            localioa.Tq = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0) {
        ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tq = true;
      }
    }
    for (;;)
    {
      vF();
      return;
      if (paramInt == 4)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().tl()) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0))
        {
          ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tp = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.iterator();
          while (localIterator.hasNext())
          {
            localioa = (ioa)localIterator.next();
            if (!localioa.Tp) {
              localioa.Tq = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)
        {
          ((ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tq = true;
        }
      }
    }
  }
  
  void mx(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 8) || (paramInt == 74)) {}
    do
    {
      do
      {
        return;
      } while (irc.getGLVersion(this.mApp.getApp()) != 1);
      iwu.a(this.mApp, 1012, this.mApp.getApp().getString(2131721742));
      anot.a(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      anot.a(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "OnCreate");
    }
    Object localObject = (BaseActivity)this.mContext.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "Can not get activity");
      }
      return;
    }
    this.mApp.addObserver(this.jdField_c_of_type_Iid);
    this.mApp.addObserver(this.jdField_b_of_type_Iin);
    ((BaseActivity)localObject).registerReceiver(this.Y, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    this.jdField_a_of_type_Jko = jko.a(this.mApp);
    localObject = getIntent();
    aG((Intent)localObject);
    l((Intent)localObject);
    this.jdField_a_of_type_ComTencentAvVideoController.alJ();
  }
  
  public void onDestroy(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "OnDestroy, seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.alK();
    this.mApp.deleteObserver(this.jdField_c_of_type_Iid);
    this.mApp.deleteObserver(this.jdField_b_of_type_Iin);
    if (this.mContext.get() != null) {
      ((Context)this.mContext.get()).unregisterReceiver(this.Y);
    }
    this.mApp.getHandler().removeCallbacks(this.bC);
    this.mApp.getHandler().removeCallbacks(this.bD);
    this.mApp.getHandler().removeCallbacks(this.bE);
    this.mApp.getHandler().removeCallbacks(this.bF);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable);
    if (this.bV != null) {
      this.mApp.getHandler().removeCallbacks(this.bV);
    }
    this.mApp.getHandler().removeCallbacks(this.bW);
    this.bC = null;
    this.bD = null;
    this.bE = null;
    this.bF = null;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = null;
    this.bV = null;
    this.bW = null;
    auQ();
    iwu.a(this.mApp, 1030);
    iwu.a(this.mApp, 1036);
    iwu.a(this.mApp, 1037);
    iwu.a(this.mApp, 3013);
    iwu.a(this.mApp, 1034);
    iwu.a(this.mApp, 1035);
    this.jdField_a_of_type_Jkz.lh(false);
    this.jdField_a_of_type_Jkz.li(false);
    this.jdField_a_of_type_Jkz.lj(false);
    this.jdField_a_of_type_Jkz = null;
    this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_b_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.Rt = null;
    if (this.mRootView != null) {
      this.mRootView.removeAllViews();
    }
    if (this.jdField_a_of_type_Atan != null)
    {
      this.jdField_a_of_type_Atan.dN(paramLong);
      this.jdField_a_of_type_Atan = null;
    }
    if (this.jdField_a_of_type_Jcr != null)
    {
      this.jdField_a_of_type_Jcr.destroy();
      this.jdField_a_of_type_Jcr = null;
    }
    super.onDestroy(paramLong);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "OnNewIntent");
    }
    aG(paramIntent);
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      auV();
    }
    l(paramIntent);
    if (bool) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axJ();
    }
    atc();
  }
  
  public void r(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      cD(paramLong);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mSelfUin, this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if, this.jdField_a_of_type_ComTencentAvVideoController.b().ig, 1, false);
    }
    super.r(paramLong, paramInt);
  }
  
  public void refreshUI()
  {
    super.refreshUI();
  }
  
  void resumeVideo()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resumeVideo");
    }
    if (this.bC == null) {
      this.bC = new AutoCheckRunnable();
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bC, 500L);
      return;
      this.mApp.getHandler().removeCallbacks(this.bC);
    }
  }
  
  public void s(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      vF();
    }
    atk();
  }
  
  void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(paramInt1, paramInt2);
  }
  
  public void u(long paramLong, int paramInt1, int paramInt2)
  {
    bV(paramInt1, paramInt2);
  }
  
  public void v(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onGroupVideoChatClosed, relationId[" + paramLong + "], mIntentRelationId[" + this.oC + "]");
    }
    if (this.oC != paramLong) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.mUinType);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", this.TAG);
      AVActivity localAVActivity = (AVActivity)this.mContext.get();
      if (localAVActivity != null)
      {
        localIntent.setPackage(this.mApp.getApplication().getPackageName());
        localAVActivity.sendBroadcast(localIntent);
        jg(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  public void v(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    } while (localiiv == null);
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "switchUIMode[" + paramString + "], SessionType[" + localiiv.amI + "], seq[" + paramLong + "]");
    }
    if (localiiv.amI == 4)
    {
      this.jdField_a_of_type_Jkz.lj(false);
      this.jdField_a_of_type_Jkz.li(false);
      this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      ((AVActivity)this.mContext.get()).b.nc(this.jdField_a_of_type_ComTencentAvVideoController.b().ani);
      ((AVActivity)this.mContext.get()).b.d(this.jdField_a_of_type_ComTencentAvVideoController.b());
      ato();
      if (!localiiv.PY) {
        break label392;
      }
    }
    label392:
    for (int i = 2;; i = 1)
    {
      w(true, i);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.lk(true);
      }
      jR(true);
      jS(true);
      J(paramLong, 0);
      Q(paramLong, 8);
      for (boolean bool = true;; bool = false)
      {
        g(Boolean.valueOf(bool));
        O(paramLong, 65535);
        this.mApp.l(new Object[] { Integer.valueOf(102) });
        return;
        this.mRootView.setVisibility(0);
        kt(true);
        this.jdField_a_of_type_Jkz.lj(true);
        this.jdField_a_of_type_Jkz.li(true);
        this.jdField_b_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
        paramString = (AVActivity)this.mContext.get();
        if (!paramString.isFinishing()) {
          paramString.b.nc(-1);
        }
        ato();
        w(false, 1);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.lk(false);
        }
        jR(false);
        jS(false);
        J(paramLong, 8);
        Q(paramLong, 0);
        c(paramLong, 0.0F);
      }
    }
  }
  
  public boolean vF()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startRecvAllVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    Object localObject = (Context)this.mContext.get();
    if ((localObject != null) && ((localObject instanceof AVActivity)))
    {
      localObject = (AVActivity)localObject;
      if (localObject == null) {}
    }
    for (boolean bool1 = ((AVActivity)localObject).isResume();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "startRecvAllVideo --> isResume = " + bool1);
      }
      if (!bool1) {
        break;
      }
      int j = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size();
      int i = j;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().PY) {
        i = j - 1;
      }
      if (i <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.TAG, 2, "startRecvAllVideo --> There is no video need request");
        return false;
      }
      i = irc.getGLVersion(this.mApp.getApp());
      if (i == 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.TAG, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = " + i);
        return false;
      }
      anot.a(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      i = this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "startRecvAllVideo --> Ability = " + i);
      }
      if (i != 4)
      {
        if (this.aqx == 2) {
          anot.a(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 1) {
          iwu.b(this.mApp, 3007);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().ih.clear();
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size())
      {
        localObject = (ioa)this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i);
        if ((((ioa)localObject).Tq) && (l != ((ioa)localObject).uin)) {
          this.jdField_a_of_type_ComTencentAvVideoController.b().ih.add(localObject);
        }
        i += 1;
      }
      g(false, false, false);
      auQ();
      iwu.a(this.mApp, 1036);
      iwu.a(this.mApp, 1037);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().ani == 3) {}
      for (bool1 = bool2;; bool1 = false) {
        return this.jdField_a_of_type_ComTencentAvVideoController.F(bool1);
      }
    }
  }
  
  void w(long paramLong, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      paramString = new StringBuilder().append("closeRemoteVideo[").append(paramString).append("], seq[").append(paramLong).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.ck("Multi_closeRemoteVideo");
    this.jdField_a_of_type_ComTencentAvVideoController.b().a(paramLong, "closeRemoteVideo", false, true);
    v("closeRemoteVideo", paramLong);
    jJ("closeRemoteVideo");
    this.jdField_c_of_type_Iya.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if });
  }
  
  protected boolean wd()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.b().td();
  }
  
  public boolean wk()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.sv();
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  boolean wl()
  {
    if ((!imm.isNormalSharp()) || (irc.getGLVersion(this.mApp.getApp()) == 1))
    {
      DoubleVideoCtrlUI.o(this.mApp);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.ky() >= auk)
    {
      iwu.b(this.mApp, 1031);
      return false;
    }
    return true;
  }
  
  protected boolean wm()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    boolean bool2 = jkn.xL();
    if ((!localiiv.QO) && (!localiiv.QP)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "canStopMuteStatus, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + localiiv.QI + "], micAuthByAdmin[" + localiiv.ane + "], mIsPhoneCalling[" + this.jdField_a_of_type_ComTencentAvVideoController.b().PQ + "]");
      }
      if (((bool1) && (localiiv.QI) && (localiiv.ane != 0)) || ((!bool2) && (bool1) && (localiiv.ane == 1)) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PQ)) {
        break;
      }
      return true;
    }
  }
  
  void x(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "notifyDataChange, from[" + paramString + "], seq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.c();
    ThreadManager.getSubThreadHandler().post(new MultiVideoCtrlLayerUIBase.6(this, paramString, paramLong));
  }
  
  class AutoCheckRunnable
    implements Runnable
  {
    AutoCheckRunnable() {}
    
    public void run()
    {
      MultiVideoCtrlLayerUIBase.this.atl();
    }
  }
  
  public class InviteUserNoticeRunnable
    implements Runnable
  {
    int count = 0;
    String name = null;
    
    InviteUserNoticeRunnable() {}
    
    public void ag(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.name = paramString;
    }
    
    public void run()
    {
      AVActivity localAVActivity = (AVActivity)MultiVideoCtrlLayerUIBase.this.mContext.get();
      if (localAVActivity != null) {
        localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1(this));
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.e(MultiVideoCtrlLayerUIBase.this.TAG, 2, "onInviteUserNotice-->Can not get AVActivity");
    }
  }
  
  class RefreshDisplayNameRunnable
    implements Runnable
  {
    RefreshDisplayNameRunnable() {}
    
    public void run()
    {
      Object localObject = MultiVideoCtrlLayerUIBase.this.mApp.getDisplayName(MultiVideoCtrlLayerUIBase.this.mUinType, String.valueOf(MultiVideoCtrlLayerUIBase.this.oC), null);
      MultiVideoCtrlLayerUIBase.this.Rt = MultiVideoCtrlLayerUIBase.this.mApp.getApp().getString(2131697560);
      if (MultiVideoCtrlLayerUIBase.this.aqx == 2) {
        MultiVideoCtrlLayerUIBase.this.Rt = MultiVideoCtrlLayerUIBase.this.a((String)localObject, MultiVideoCtrlLayerUIBase.this.mApp.e(MultiVideoCtrlLayerUIBase.this.aqx, String.valueOf(MultiVideoCtrlLayerUIBase.this.oC)), MultiVideoCtrlLayerUIBase.this.mUserName);
      }
      for (;;)
      {
        MultiVideoCtrlLayerUIBase.this.mUserName.setText(MultiVideoCtrlLayerUIBase.this.Rt);
        MultiVideoCtrlLayerUIBase.this.mK.setText(MultiVideoCtrlLayerUIBase.this.Rt);
        MultiVideoCtrlLayerUIBase.this.mK.setText(null);
        localObject = MultiVideoCtrlLayerUIBase.this;
        ((MultiVideoCtrlLayerUIBase)localObject).awF += 1;
        if (MultiVideoCtrlLayerUIBase.this.bW != null)
        {
          if (MultiVideoCtrlLayerUIBase.this.awF >= 3) {
            break;
          }
          MultiVideoCtrlLayerUIBase.this.mApp.getHandler().postDelayed(MultiVideoCtrlLayerUIBase.this.bW, 1000L);
        }
        return;
        if (MultiVideoCtrlLayerUIBase.this.aqx == 1) {
          MultiVideoCtrlLayerUIBase.this.Rt = ((String)localObject);
        }
      }
      MultiVideoCtrlLayerUIBase.this.mApp.getHandler().removeCallbacks(MultiVideoCtrlLayerUIBase.this.bW);
    }
  }
  
  class RefreshFaceRunnable
    implements Runnable
  {
    RefreshFaceRunnable() {}
    
    public void run()
    {
      if (MultiVideoCtrlLayerUIBase.this.b != null) {
        MultiVideoCtrlLayerUIBase.this.b.asZ();
      }
      MultiVideoCtrlLayerUIBase.this.mApp.getHandler().postDelayed(this, 2000L);
    }
  }
  
  public class RefreshNoiseStateRunnable
    implements Runnable
  {
    public RefreshNoiseStateRunnable() {}
    
    public void run()
    {
      if (MultiVideoCtrlLayerUIBase.this.a.st())
      {
        MultiVideoCtrlLayerUIBase.this.a.b(0L, false, 0L);
        if (QLog.isColorLevel()) {
          QLog.e(MultiVideoCtrlLayerUIBase.this.TAG, 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
        }
      }
      Handler localHandler;
      Runnable localRunnable;
      if (MultiVideoCtrlLayerUIBase.this.bV != null)
      {
        localHandler = MultiVideoCtrlLayerUIBase.this.mApp.getHandler();
        localRunnable = MultiVideoCtrlLayerUIBase.this.bV;
        if (MultiVideoCtrlLayerUIBase.this.a.kL >= 2000L) {
          break label105;
        }
      }
      label105:
      for (long l = 2000L;; l = MultiVideoCtrlLayerUIBase.this.a.kL)
      {
        localHandler.postDelayed(localRunnable, l);
        return;
      }
    }
  }
  
  class RefreshUIRunnable
    implements Runnable
  {
    int aul;
    boolean isRefresh;
    int refreshType;
    long uin;
    
    public RefreshUIRunnable(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.isRefresh = paramBoolean;
      this.aul = paramInt2;
      this.uin = paramLong;
      this.refreshType = paramInt1;
    }
    
    public void run()
    {
      MultiVideoCtrlLayerUIBase.this.b(this.uin, this.refreshType, this.isRefresh, this.aul);
    }
  }
  
  class RequestVideoTimeOutRunnable
    implements Runnable
  {
    RequestVideoTimeOutRunnable() {}
    
    public void run()
    {
      if (MultiVideoCtrlLayerUIBase.this.a != null)
      {
        MultiVideoCtrlLayerUIBase.this.a.ck("Multi_RequestVideoTimeOutRunnable");
        MultiVideoCtrlLayerUIBase.this.atm();
        if (MultiVideoCtrlLayerUIBase.this.aqx == 2) {
          anot.a(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.e(MultiVideoCtrlLayerUIBase.this.TAG, 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
    }
  }
  
  class StartRecvVideoRunnable
    implements Runnable
  {
    public String QJ;
    
    StartRecvVideoRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiVideoCtrlLayerUIBase.this.TAG, 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.QJ);
      }
      MultiVideoCtrlLayerUIBase.this.vF();
    }
  }
  
  public static class a
  {
    public int alU;
    public String uin = "";
    
    public a(String paramString, int paramInt)
    {
      this.uin = paramString;
      this.alU = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */