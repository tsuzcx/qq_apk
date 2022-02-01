package com.tencent.mobileqq.activity.aio.audiopanel;

import acff;
import acfp;
import acoa;
import alik;
import alit;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import anpc;
import aqcl;
import aqge;
import aqha;
import aqju;
import aqrf;
import aqxm;
import aqxn;
import aqxo;
import aqxo.a;
import aqxp;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import kbp;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wja;
import wpi;
import wpo;
import wpr;
import wps;
import ycd;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements DialogInterface.OnClickListener, View.OnClickListener, aqxm, wpi
{
  public static volatile alik a;
  public static boolean bfb;
  public static String[] cD = { acfp.m(2131707799), acfp.m(2131707804), acfp.m(2131707781), acfp.m(2131707800), acfp.m(2131707798), acfp.m(2131707772), acfp.m(2131707759), acfp.m(2131707797), acfp.m(2131707780), acfp.m(2131707782), acfp.m(2131707767), acfp.m(2131707754), acfp.m(2131707765), acfp.m(2131707788), acfp.m(2131707756), acfp.m(2131707785), acfp.m(2131707770) };
  public static String[] cE = { acfp.m(2131707786), acfp.m(2131707764), acfp.m(2131707760), acfp.m(2131707801), acfp.m(2131707766), acfp.m(2131707779), acfp.m(2131707762), acfp.m(2131707802), acfp.m(2131707768), acfp.m(2131707761), acfp.m(2131707789), acfp.m(2131707791), acfp.m(2131707771), acfp.m(2131707758), acfp.m(2131707755), acfp.m(2131707794), acfp.m(2131707793) };
  public static int[] hm = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
  public static int[] hn = { 2130838471, 2130838470, 2130838473, 2130838472, 2130838469, 2130838468, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private TextView Ir;
  private aqxn jdField_a_of_type_Aqxn;
  public ChangeVoiceView a;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  public wpo a;
  protected String aid = "mvip.gxh.android.changevoice_";
  ListView b;
  private int bQl = -1;
  public boolean bfa;
  boolean bfc;
  private double by;
  public VasQuickUpdateManager.CallBacker callBacker = new wps(this);
  public WeakReference<BaseChatPie> dq;
  private TextView dx;
  private int[] ho = new int[hm.length];
  private String mAudioPath;
  private volatile int mCurType = -1;
  Bundle mDialogData;
  private ViewGroup mParent;
  Handler mUiHandler = new wpr(this, Looper.getMainLooper());
  private WeakReference<QQAppInterface> n;
  ArrayList<aqxo> nB = new ArrayList();
  arhz progessDialog;
  public ArrayList<aqxo> qn = new ArrayList();
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int vS()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.ho.length; j = k)
    {
      k = j;
      if (this.ho[i] == 1)
      {
        k = j + 1;
        this.ho[i] = 0;
      }
      i += 1;
    }
    return j;
  }
  
  public void B(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int i;
    if ((this.dq != null) && (this.dq.get() != null) && (((BaseChatPie)this.dq.get()).sessionInfo != null) && (this.n != null) && (this.n.get() != null))
    {
      if (!((BaseChatPie)this.dq.get()).aSf) {
        break label385;
      }
      j = 1;
      if (((BaseChatPie)this.dq.get()).sessionInfo.cZ != 0) {
        break label391;
      }
      i = 1;
    }
    for (;;)
    {
      anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "0X8005474", "0X8005474", j, 0, paramInt3 + "", i + "", "", "3.4.4");
      if ((this.dq.get() instanceof ycd)) {
        kbp.a((QQAppInterface)this.n.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((acff)((QQAppInterface)this.n.get()).getManager(51)).c(((QQAppInterface)this.n.get()).getCurrentAccountUin());
      anpc localanpc = anpc.a(super.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put("gender", String.valueOf(localCard.shGender));
      localHashMap.put("age", String.valueOf(localCard.age));
      localHashMap.put("time", String.valueOf(paramInt3));
      localHashMap.put("extra", String.valueOf(paramInt4));
      paramInt3 = paramInt1;
      if (paramInt2 == paramInt1) {
        paramInt3 = paramInt1 + 10;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt3));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localanpc.collectPerformance("", "VCPttSendEvent", false, 0L, 0L, localHashMap, "");
      return;
      label385:
      j = 2;
      break;
      label391:
      if (((BaseChatPie)this.dq.get()).sessionInfo.cZ == 3000) {
        i = 2;
      } else if (((BaseChatPie)this.dq.get()).sessionInfo.cZ == 1) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread-f:" + paramBoolean);
      }
      this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 107, paramInt1, paramInt2, paramObject));
      return;
    }
    setProgessDialog(false, 0);
    paramObject = (Bundle)paramObject;
    this.bfc = false;
    int i = paramObject.getInt("callId", 0);
    Object localObject1 = paramObject.getString("message");
    String str = paramObject.getString("svr_url");
    paramObject = paramObject.getString("svr_actStr");
    if (QLog.isColorLevel()) {
      QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread:" + paramBoolean);
    }
    switch (paramInt2)
    {
    default: 
      label276:
      paramInt1 = 4;
    }
    while (paramInt2 != 0)
    {
      QLog.d("ListenChangeVoicePanel", 1, "VoiceChangeObserver fail, ret=" + paramInt2 + ", msg=" + (String)localObject1);
      Object localObject2 = paramObject;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = paramObject;
        if (TextUtils.isEmpty(paramObject)) {
          localObject2 = acfp.m(2131707774);
        }
      }
      showTips(paramInt1, i, null, (String)localObject1, null, (String)localObject2, str);
      if ((!this.bfc) || (this.n.get() == null)) {
        break;
      }
      anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.mCurType, "", "", "");
      return;
      this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131707796);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = acfp.m(2131707777);
      }
      this.bfc = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131707784);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = acfp.m(2131707769);
      }
      this.bfc = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131707778);
      }
      this.bfc = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131707795);
      }
      this.bfc = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131707776);
      }
      this.bfc = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = acfp.m(2131707790);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = acfp.m(2131707763);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = acfp.m(2131707757);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = acfp.m(2131707773);
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.n = new WeakReference(???);
    this.dq = new WeakReference(paramBaseChatPie);
    this.mParent = paramViewGroup;
    this.dx = ((TextView)super.findViewById(2131370578));
    this.Ir = ((TextView)super.findViewById(2131370581));
    this.dx.setOnClickListener(this);
    this.Ir.setOnClickListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.dx.setContentDescription(this.dx.getText() + super.getContext().getString(2131692117));
      this.Ir.setContentDescription(this.Ir.getText() + super.getContext().getString(2131692117));
    }
    this.b = ((ListView)super.findViewById(2131368731));
    this.jdField_a_of_type_Wpo = new wpo(super.getContext());
    this.jdField_a_of_type_Wpo.dI = this;
    this.b.setAdapter(this.jdField_a_of_type_Wpo);
    for (;;)
    {
      synchronized (this.nB)
      {
        if (this.nB.size() < hm.length)
        {
          int i = 0;
          if (i < hm.length)
          {
            paramBaseChatPie = this.nB;
            int k = hm[i];
            paramViewGroup = cD[i];
            String str = cE[i];
            if (i < 6) {
              break label347;
            }
            j = 0;
            paramBaseChatPie.add(new aqxo(k, paramViewGroup, str, 0, j, 1, new aqxo.a(hn[i], null, null, null)));
            i += 1;
            continue;
          }
        }
        ThreadManager.post(new ListenChangeVoicePanel.2(this), 8, null, true);
        return;
      }
      label347:
      int j = 2;
    }
  }
  
  public void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = AudioPanel.fc(paramInt1) / 1250;
    Bundle localBundle = new Bundle();
    localBundle.putInt("progress", paramInt2);
    localBundle.putInt("playTime", paramInt3);
    localBundle.putInt("level", paramInt1);
    this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 103, localBundle));
  }
  
  public void buY()
  {
    this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 104, null));
  }
  
  public void caq()
  {
    if (this.mCurType == -1) {
      ThreadManager.getSubThreadHandler().post(new ListenChangeVoicePanel.4(this));
    }
  }
  
  public void car()
  {
    this.bQl = this.mCurType;
    if (this.mCurType == -1) {
      this.mCurType = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(1);
    }
    this.bfa = false;
  }
  
  public void cas()
  {
    this.jdField_a_of_type_Aqxn.changeType = this.mCurType;
    if (this.n.get() != null)
    {
      aqge.m(BaseApplication.getContext(), true);
      aqxp.b(((QQAppInterface)this.n.get()).getApp(), this.jdField_a_of_type_Aqxn, PressToChangeVoicePanel.GW, this);
    }
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.mAudioPath);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.mParent.findViewById(2131373559);
    localPressToChangeVoicePanel.reset();
    localPressToChangeVoicePanel.setVisibility(0);
    int i;
    if ((this.dq != null) && (this.dq.get() != null))
    {
      ((BaseChatPie)this.dq.get()).f(this.mAudioPath, null);
      aqxp.a(this.jdField_a_of_type_Aqxn);
      if (((BaseChatPie)this.dq.get()).aSf) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.n != null) && (this.n.get() != null))
      {
        anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "3.4.4");
        if (jdField_a_of_type_Alik != null) {
          jdField_a_of_type_Alik.F((QQAppInterface)this.n.get(), -1);
        }
        alit.a((QQAppInterface)this.n.get()).dGn();
      }
      return false;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.mDialogData == null) {}
    label497:
    label500:
    for (;;)
    {
      return;
      int i = this.mDialogData.getInt("funcType", 4);
      paramDialogInterface = this.mDialogData.getString("url");
      int j = this.mDialogData.getInt("fcID", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 1, "DialogInterface funcType=" + i + ", url:" + paramDialogInterface);
      }
      if ((1 == i) || (2 == i))
      {
        if ((paramInt != 1) || (this.n.get() == null) || (this.dq.get() == null)) {
          break label497;
        }
        if (1 == i)
        {
          aqrf.a((QQAppInterface)this.n.get(), ((BaseChatPie)this.dq.get()).a(), this.aid + j, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131697263), "voiceVip");
          i = 0;
        }
      }
      for (;;)
      {
        if ((!this.bfc) || (this.n.get() == null)) {
          break label500;
        }
        anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i, "", "", "");
        return;
        aqrf.a((QQAppInterface)this.n.get(), ((BaseChatPie)this.dq.get()).a(), this.aid + j, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131720669), "voiceSvip");
        i = 0;
        continue;
        if ((paramInt == 1) && (!TextUtils.isEmpty(paramDialogInterface)) && (this.dq.get() != null))
        {
          Intent localIntent = new Intent(((BaseChatPie)this.dq.get()).a(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramDialogInterface);
          localIntent.putExtra("isShowAd", false);
          ((BaseChatPie)this.dq.get()).a().startActivity(localIntent);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370578)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(1);
      }
      if (this.dq.get() != null) {
        ((BaseChatPie)this.dq.get()).f(this.mAudioPath, null);
      }
      reset();
      aqxp.a(this.jdField_a_of_type_Aqxn);
      i = 0;
      if (this.dq.get() != null)
      {
        if (((BaseChatPie)this.dq.get()).aSf) {
          i = 1;
        }
      }
      else
      {
        if (this.n.get() != null)
        {
          anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "3.4.4");
          if ((this.dq.get() != null) && ((this.dq.get() instanceof ycd))) {
            kbp.a((QQAppInterface)this.n.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
          }
          alit.a((QQAppInterface)this.n.get()).dGn();
          if (jdField_a_of_type_Alik != null) {
            jdField_a_of_type_Alik.F((QQAppInterface)this.n.get(), -1);
          }
        }
        i = 1;
      }
    }
    for (;;)
    {
      label241:
      Object localObject2;
      String str;
      if ((i >= 0) && (this.n.get() != null))
      {
        localObject2 = (QQAppInterface)this.n.get();
        str = "" + i;
        if (i != 0) {
          break label1000;
        }
      }
      label558:
      label589:
      label1000:
      for (Object localObject1 = "" + this.mCurType;; localObject1 = "")
      {
        anot.a((QQAppInterface)localObject2, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, (String)localObject1, "", "");
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          i = 2;
          break;
          if (i == 2131370581)
          {
            if (this.mCurType >= 6)
            {
              setProgessDialog(true, 2131700593);
              if (this.n.get() == null) {
                break label1011;
              }
              ((acoa)((QQAppInterface)this.n.get()).getBusinessHandler(96)).a(1, this.mCurType, this);
              i = 2;
              break label241;
            }
            this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 106, null));
            i = 2;
            break label241;
          }
          this.bfa = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label1006;
          }
          localObject2 = (ChangeVoiceView)paramView;
        } while ((localObject2 == null) || (((ChangeVoiceView)localObject2).a == null));
        if (2 == ((ChangeVoiceView)localObject2).a.status)
        {
          i = ((ChangeVoiceView)localObject2).mType;
          this.jdField_a_of_type_Wpo.bQb = i;
          if (i != this.mCurType) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.b != null) && (this.b.getChildCount() > 0) && ((this.b.getChildAt(0) instanceof ViewGroup)))
              {
                localObject1 = (ViewGroup)this.b.getChildAt(0);
                if ((localObject1 == null) || (((ViewGroup)localObject1).getChildCount() <= 0) || (!(((ViewGroup)localObject1).getChildAt(0) instanceof ChangeVoiceView))) {
                  break label754;
                }
                localObject1 = (ChangeVoiceView)((ViewGroup)localObject1).getChildAt(0);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject1);
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) && (localObject2 != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject2);
              ((ChangeVoiceView)localObject2).Cu(2);
              this.mCurType = i;
              cas();
              i = 0;
              if (this.dq.get() != null)
              {
                if (!((BaseChatPie)this.dq.get()).aSf) {
                  break label759;
                }
                i = 1;
              }
              if (this.n.get() != null) {
                anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.mCurType + "", "", "", "3.4.4");
              }
              this.ho[this.mCurType] = 1;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            localObject1 = null;
            break label558;
            label754:
            localObject1 = null;
            break label589;
            label759:
            i = 2;
            break label669;
            if (((ChangeVoiceView)localObject2).getState() == 2)
            {
              ((ChangeVoiceView)localObject2).Cu(1);
              aqxp.b(this.jdField_a_of_type_Aqxn);
            }
            else if (((ChangeVoiceView)localObject2).getState() == 1)
            {
              cas();
              ((ChangeVoiceView)localObject2).Cu(2);
              i = 0;
              if (this.dq.get() != null) {
                if (!((BaseChatPie)this.dq.get()).aSf) {
                  break label906;
                }
              }
              for (i = 1;; i = 2)
              {
                if (this.n.get() == null) {
                  break label909;
                }
                anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.mCurType + "", "", "", "3.4.4");
                break;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.mCurType + " newtype is " + i + " state is " + ((ChangeVoiceView)localObject2).getState());
            }
          }
        }
        showTips(4, ((ChangeVoiceView)localObject2).mType, null, acfp.m(2131707783), null, null, null);
        i = 0;
        break label241;
      }
      label669:
      label1006:
      i = -1;
      label906:
      label909:
      continue;
      label1011:
      i = 2;
    }
  }
  
  public void onDestroy()
  {
    if ((this.n != null) && (this.n.get() != null)) {
      ((VasQuickUpdateManager)((QQAppInterface)this.n.get()).getManager(184)).removeCallBacker(this.callBacker);
    }
    if (this.mAudioPath == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.mAudioPath);
      }
      reset();
      aqxp.a(this.jdField_a_of_type_Aqxn);
    } while ((this.dq == null) || (this.dq.get() == null));
    ((BaseChatPie)this.dq.get()).f(this.mAudioPath, null);
    Object localObject;
    int i;
    if ((this.n != null) && (this.n.get() != null))
    {
      localObject = (acff)((QQAppInterface)this.n.get()).getManager(51);
      if (((BaseChatPie)this.dq.get()).OV()) {
        break label286;
      }
      localObject = ((acff)localObject).a(((BaseChatPie)this.dq.get()).sessionInfo.aTl, ((BaseChatPie)this.dq.get()).sessionInfo.cZ, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.mCurType)) {
        break label341;
      }
      ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.mCurType;
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (localObject != null)) {
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, (QQAppInterface)this.n.get()));
      }
      bfb = false;
      return;
      label286:
      localObject = ((acff)localObject).a(((BaseChatPie)this.dq.get()).sessionInfo.aTl, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).pttChangeVoiceType != this.mCurType))
      {
        ((ExtensionInfo)localObject).pttChangeVoiceType = this.mCurType;
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        label341:
        i = 0;
      }
    }
  }
  
  public void onError()
  {
    this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 105, null));
    aqxp.b(this.jdField_a_of_type_Aqxn);
    aqge.m(BaseApplication.getContext(), false);
  }
  
  public void onPause()
  {
    aqxp.b(this.jdField_a_of_type_Aqxn);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(1);
    }
  }
  
  public void onPlayStop()
  {
    this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 102, null));
    aqge.m(BaseApplication.getContext(), false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void reset()
  {
    setVisibility(8);
    if (this.mParent != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.mParent.findViewById(2131373559);
      localPressToChangeVoicePanel.reset();
      localPressToChangeVoicePanel.setVisibility(0);
    }
    int i = 0;
    while (i < this.ho.length)
    {
      this.ho[i] = 0;
      i += 1;
    }
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.mAudioPath = paramString;
    this.by = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Aqxn = new aqxn(this.mAudioPath, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mBitRate, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mAudioType, this.mCurType);
    if (AppSetting.enableTalkBack) {
      aqcl.ip(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView);
    }
  }
  
  void setProgessDialog(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if ((this.progessDialog == null) && (this.dq.get() != null))
      {
        this.progessDialog = new arhz(((BaseChatPie)this.dq.get()).a(), wja.dp2px(50.0F, super.getResources()));
        this.progessDialog.setCancelable(true);
      }
      this.progessDialog.setMessage(paramInt);
      this.progessDialog.show();
    }
    while ((this.progessDialog == null) || (!this.progessDialog.isShowing())) {
      return;
    }
    this.progessDialog.dismiss();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      bfb = bool;
      super.setVisibility(paramInt);
      if ((bfb) && (this.n.get() != null)) {
        anot.a((QQAppInterface)this.n.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  boolean showTips(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mDialogData = new Bundle();
    this.mDialogData.putInt("funcType", paramInt1);
    this.mDialogData.putString("url", paramString5);
    this.mDialogData.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = acfp.m(2131707803);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = acfp.m(2131707792);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = acfp.m(2131707787);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = acfp.m(2131707775);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            if (this.dq.get() != null)
            {
              paramString1 = aqha.a(((BaseChatPie)this.dq.get()).a(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
              if (paramString1 != null)
              {
                paramString1.show();
                return true;
              }
            }
            return false;
          }
        }
      }
    }
  }
  
  public void yL(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.n.get() == null) {
      return;
    }
    ??? = (AppRuntime)this.n.get();
    if (!paramBoolean) {
      bool = true;
    }
    ??? = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)???, "changeVoice_json", bool, this.callBacker);
    if (??? != null)
    {
      bool = ((aqxp)((QQAppInterface)this.n.get()).getManager(176)).a(this.nB, (JSONObject)???);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + paramBoolean + ", isChecked=" + bool);
      }
    }
    synchronized (this.qn)
    {
      aqxo localaqxo;
      for (;;)
      {
        this.qn.clear();
        int i = this.nB.size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label258;
          }
          localaqxo = (aqxo)this.nB.get(i);
          if (localaqxo.status != 0)
          {
            if (6 <= i) {
              break;
            }
            this.qn.add(0, localaqxo);
          }
          i -= 1;
        }
        if ((QLog.isColorLevel()) || (paramBoolean)) {
          QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas null=xydata startDownload json. isLoaded=" + paramBoolean);
        }
      }
      this.qn.add(localaqxo);
    }
    label258:
    this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 101, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */