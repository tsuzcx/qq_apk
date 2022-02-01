package com.tencent.av.ui;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqji.c;
import aqjl;
import aqju;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils.a;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import iid;
import iiv;
import iiz;
import ikp;
import java.util.ArrayList;
import jbm;
import jbn;
import jbo;
import jbp;
import jbq;
import jbr;
import jbs;
import jbt;
import jbu;
import jjk;
import jka;
import jll;
import jll.a;
import mqq.app.BaseActivity;
import wja;

public class MultiVideoEnterPageActivity
  extends BaseActivity
{
  public String Rv = null;
  String Rw = null;
  String Rx;
  public final String TAG = "MultiVideoEnterPageActivity_" + AudioHelper.hG();
  public boolean Xn = false;
  boolean Xo = false;
  public VideoController a;
  TimeoutRunnable jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
  c jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c = new c();
  iiz jdField_a_of_type_Iiz = new d();
  MultiVideoEnterPageMembersControlUI[] jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = null;
  final int aqE = 0;
  final int aqF = 1;
  public int aqI = 0;
  public int aqJ = 0;
  public int aqx;
  int awF = 0;
  int awI = 0;
  public int awJ = 0;
  iid jdField_b_of_type_Iid = new jbr(this);
  jka jdField_b_of_type_Jka = new jbm(this);
  Runnable bW = null;
  Runnable bY = null;
  Runnable bZ = null;
  public MultiMembersAudioUI c = null;
  LinearLayout db = null;
  VideoAppInterface mApp = null;
  TextView mM = null;
  ProgressBar mProgressBar = null;
  int mSessionType;
  int mType;
  int mUinType;
  public long md;
  public long oD = 0L;
  long[] q = null;
  
  public MultiVideoEnterPageActivity()
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  private void ah(int paramInt, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramInt == 3000)
    {
      i = j;
      if (aqjl.cV(this.mApp.w(this.Rv)))
      {
        ChatActivityUtils.a.a(this.TAG, this.Rv, new jbu(this));
        i = 1;
      }
    }
    if (i == 0) {
      mA(10);
    }
  }
  
  private void anv()
  {
    if (this.mApp.RA == true)
    {
      this.mApp.RA = false;
      ikp.anv();
    }
  }
  
  private boolean wo()
  {
    boolean bool = false;
    if (this.mApp.sM())
    {
      jjk.S(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "startMultipVideo phone is calling!");
      }
      String str = getResources().getString(2131697638);
      aqha.a(this, 230, getResources().getString(2131697879), str, 2131721058, 2131721079, new jbn(this), null).show();
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131373996: 
    case 2131374003: 
      do
      {
        return;
        bO(paramView);
        return;
      } while (wo());
      aqji.c.edZ();
      ah(this.mUinType, this.Rw);
      return;
    }
    anv();
    if (this.mUinType == 1) {
      if (this.awJ == 10) {
        anot.a(null, "CliOper", "", "", "0X8005934", "0X8005934", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      finish();
      super.overridePendingTransition(0, 2130772209);
      return;
      anot.a(null, "CliOper", "", "", "0X80046DB", "0X80046DB", 0, 0, "", "", "", "");
      continue;
      if (this.mUinType == 3000) {
        anot.a(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
      }
    }
  }
  
  void ats()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 25);
    localIntent.putExtra("relationId", this.md);
    localIntent.putExtra("openClass", this.Xo);
    localIntent.putExtra("relationType", this.aqx);
    localIntent.putExtra("MultiAVType", this.awJ);
    localIntent.putExtra("reason", 5);
    localIntent.putExtra("from", "MultiVideoEnterPageActivity");
    localIntent.setPackage(this.mApp.getApp().getPackageName());
    super.sendBroadcast(localIntent);
  }
  
  void att()
  {
    int i = aqiw.getSystemNetwork(this);
    if (aqiw.bX(this)) {
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "setNetTips,netinfo=" + i);
    }
    switch (i)
    {
    default: 
      i = -1;
    }
    while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int k = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int j = 0;
      while (j < k)
      {
        MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[j];
        if (i != -1) {
          localMultiVideoEnterPageMembersControlUI.mM.setText(i);
        }
        localMultiVideoEnterPageMembersControlUI.mProgressBar.setVisibility(8);
        j += 1;
      }
      i = 2131697733;
      continue;
      i = 2131697732;
      continue;
      i = 2131721715;
      continue;
      i = -1;
    }
    if (i != -1) {
      this.mM.setText(i);
    }
    this.mProgressBar.setVisibility(8);
  }
  
  void atu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "quitGAudioChatDialog");
    }
    b localb1 = new b(0);
    b localb2 = new b(1);
    a.a(this, 230, null, super.getResources().getString(2131697710), 2131721690, 2131697626, localb1, localb2).show();
  }
  
  public void bO(View paramView)
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, 2131696206, 1).show(super.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(this.md));
    localBundle = this.mApp.a(6, 0, 0, localBundle, null);
    if (localBundle == null)
    {
      QLog.w(this.TAG, 1, "closeGAudio, rsp is null");
      paramView.setVisibility(8);
      return;
    }
    boolean bool2 = localBundle.getBoolean("isAdmin");
    boolean bool1 = localBundle.getBoolean("isOwner");
    if (1 == AudioHelper.jY(7))
    {
      AudioHelper.UA(acfp.m(2131708588));
      bool1 = true;
    }
    if ((!bool2) && (!bool1))
    {
      QLog.w(this.TAG, 1, "closeGAudio, 没有权限");
      paramView.setVisibility(8);
      QQToast.a(super.getApplicationContext(), 2131694557, 1).show();
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8009E29", "0X8009E29", 0, 0, "", "", "", "");
    a.a(this, 230, getResources().getString(2131697695), getResources().getString(2131694554), 2131697614, 2131721737, new jbs(this, paramView), new jbt(this)).show();
  }
  
  public void c(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null)
    {
      QLog.w(this.TAG, 1, "onUserListALLUpdate, simpleData is null, flag[" + this.Xn + "]");
      if (!this.Xn)
      {
        ats();
        finish();
      }
    }
    do
    {
      return;
      if ((paramInt1 != 2) && (paramInt1 != 10) && (paramInt1 != 12)) {
        break;
      }
      this.awI = paramArrayList.size();
      QLog.w(this.TAG, 1, "onUserListALLUpdate, flag[" + this.Xn + "], groupId[" + paramLong + "], userCount[" + paramInt2 + "], simpleData[" + paramArrayList.size() + "], mMemberCount[" + this.awI + "], multiAVType[" + paramInt1 + "]");
      if (this.awI != 0) {
        break label342;
      }
      if (!this.Xn) {
        break label333;
      }
    } while ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length != 2));
    if (paramInt1 == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mM.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mM.setText(2131697871);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mProgressBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.setText(2131697736);
      return;
      this.awI = paramInt2;
      break;
      if (paramInt1 == 10)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mM.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mM.setText(2131697872);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mProgressBar.setVisibility(8);
      }
    }
    label333:
    ats();
    finish();
    return;
    label342:
    if ((paramInt1 == 10) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1))
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mProgressBar.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].bC(paramArrayList);
      if (this.Xn)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mM.setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].mProgressBar.setVisibility(8);
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].gk.setVisibility(0);
        }
      }
      jT(true);
    }
    for (;;)
    {
      this.mProgressBar.setVisibility(0);
      this.c.setVisibility(0);
      paramArrayList = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList.size(), paramArrayList);
      this.c.bC(paramArrayList);
      paramArrayList = String.format(super.getResources().getString(2131697869), new Object[] { Integer.valueOf(this.awI) });
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mO.setText(paramArrayList);
      att();
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
      return;
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 0))
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mProgressBar.setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].bC(paramArrayList);
        if (this.Xn)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mM.setVisibility(8);
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].mProgressBar.setVisibility(8);
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  void initUI()
  {
    Object localObject;
    if (ThemeUtil.isInNightMode(this.mApp))
    {
      findViewById(2131374125).setBackgroundColor(Color.parseColor("#181818"));
      localObject = getResources().getDrawable(2130843036);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      ((TextView)findViewById(2131374100)).setCompoundDrawables((Drawable)localObject, null, null, null);
      ((TextView)findViewById(2131374100)).setCompoundDrawablePadding(0);
      ((TextView)findViewById(2131374100)).setTextColor(Color.parseColor("#737373"));
    }
    this.mM = ((TextView)findViewById(2131374002));
    this.c = ((MultiMembersAudioUI)findViewById(2131366475));
    this.c.setIsEnterpage(true);
    this.c.b(this.md, this.aqx, true);
    this.c.setOnItemClickListener(this.jdField_b_of_type_Jka);
    this.mProgressBar = ((ProgressBar)findViewById(2131374000));
    this.mProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    this.mProgressBar.setVisibility(0);
    this.db = ((LinearLayout)super.findViewById(2131366474));
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.p(this);
    if (ThemeUtil.isInNightMode(this.mApp))
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mN.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mO.setTextColor(Color.parseColor("#757575"));
      this.mM.setTextColor(Color.parseColor("#A8A8A8"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setTextColor(Color.parseColor("#737373"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setBackgroundDrawable(getResources().getDrawable(2130843102));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.setTextColor(Color.parseColor("#FFFFFF"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.setBackgroundDrawable(getResources().getDrawable(2130843104));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (!this.Xn) {
        break label667;
      }
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.setVisibility(4);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI = new MultiVideoEnterPageMembersControlUI[2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] = new MultiVideoEnterPageMembersControlUI(this);
      localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.db.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0], (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].b(this.md, this.aqx, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setMode(MultiVideoEnterPageMembersControlUI.awK);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].Xf = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].gk.setVisibility(0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setLowHeightMode();
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].bk.setOnClickListener(new jbo(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] = new MultiVideoEnterPageMembersControlUI(this);
      localObject = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      this.db.addView(this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1], (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].b(this.md, this.aqx, true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setMode(MultiVideoEnterPageMembersControlUI.awL);
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].Xf = true;
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].bk.setOnClickListener(new jbp(this));
      this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].bm.setOnClickListener(new jbq(this));
    }
    for (;;)
    {
      jT(false);
      if ((this.mUinType == 1) && (this.awJ == 2)) {
        jll.b(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj, getResources().getString(2131694558), this.awJ);
      }
      return;
      label667:
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.setOnTouchListener(new jll.a());
    }
  }
  
  void jT(boolean paramBoolean)
  {
    if (this.mUinType != 1) {}
    Object localObject;
    do
    {
      boolean bool;
      do
      {
        return;
        if (paramBoolean)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("uin", String.valueOf(this.md));
        }
        for (localObject = this.mApp.a(6, 0, 0, (Bundle)localObject, null); localObject == null; localObject = getIntent().getBundleExtra("groupInfo"))
        {
          QLog.w(this.TAG, 1, "setCloseBtn, rsp is null");
          return;
        }
        bool = ((Bundle)localObject).getBoolean("isAdmin");
        paramBoolean = ((Bundle)localObject).getBoolean("isOwner");
        if (1 == AudioHelper.jY(7))
        {
          AudioHelper.UA(acfp.m(2131708593));
          paramBoolean = true;
        }
      } while ((!bool) && (!paramBoolean));
      if (!this.Xn) {
        break;
      }
    } while ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length <= 1) || (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] == null));
    this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].bm.setVisibility(0);
    return;
    int i = (ImmersiveUtils.getScreenWidth() - wja.dp2px(12.0F, getResources()) * 2 - wja.dp2px(11.0F, getResources())) / 2;
    if (i < wja.dp2px(170.0F, getResources()))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.bj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setOnTouchListener(new jll.a());
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setVisibility(0);
  }
  
  public void lh(int paramInt)
  {
    if (this.Xn)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.md, 10);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.md, 2);
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.md, paramInt)) {
      return;
    }
    QQToast.a(this, acfp.m(2131708590), 1).show(a(this).getDimensionPixelSize(2131299627));
    finish();
  }
  
  public void mA(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onEnterButtonClick --> AVType = " + paramInt);
    }
    mB(paramInt);
    if (this.mUinType == 1) {
      if (paramInt == 10) {
        anot.a(null, "CliOper", "", "", "0X8005935", "0X8005935", 0, 0, "", "", "", "");
      }
    }
    while (this.mUinType != 3000)
    {
      return;
      anot.a(null, "CliOper", "", "", "0X80046DC", "0X80046DC", 0, 0, "", "", "", "");
      return;
    }
    if (this.awI <= 0)
    {
      anot.a(null, "CliOper", "", "", "0X8005577", "0X8005577", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
  }
  
  void mB(int paramInt)
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, 2131696206, 1).show(super.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().state > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.b().state < 7))
    {
      QQToast.a(this, 2131698108, 1).show(super.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QLog.w(this.TAG, 1, "onClickEnterMultiVideoChat, mRelationId[" + this.md + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.OB + "], mGAudioGroupId[" + this.jdField_a_of_type_ComTencentAvVideoController.kJ + "], mHaveMoreRoom[" + this.Xn + "], avtype[" + paramInt + "], currentAvtype[" + this.awJ + "]");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.OB) && (this.md != this.jdField_a_of_type_ComTencentAvVideoController.kJ)) || (this.jdField_a_of_type_ComTencentAvVideoController.sw()) || (this.mApp.sN()))
    {
      atu();
      return;
    }
    mC(paramInt);
  }
  
  @TargetApi(9)
  void mC(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.jdField_a_of_type_ComTencentAvVideoController.b().anb;
    }
    paramInt = i;
    if (this.mUinType == 3000)
    {
      paramInt = i;
      if (!this.Xn) {
        paramInt = 1;
      }
    }
    Intent localIntent;
    if (paramInt == 2)
    {
      localIntent = new Intent(this, JumpActivity.class);
      localIntent.setData(Uri.parse("mqqapi://gvideo/open_plugin?src_type=app"));
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", String.valueOf(this.md));
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("DiscussUinList", this.q);
      localIntent.putExtra("MultiAVType", paramInt);
      localIntent.putExtra("uin", String.valueOf(this.md));
      localIntent.putExtra("uinType", this.mUinType);
      localIntent.putExtra("ConfAppID", this.aqI);
      localIntent.putExtra("MeetingConfID", this.aqJ);
      super.startActivity(localIntent);
      finish();
      if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.kq(1010);
      }
      return;
      localIntent = new Intent(this, AVActivity.class);
    }
  }
  
  public void my(int paramInt)
  {
    if (this.Xn)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length == 2) && (paramInt == 10))
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(4);
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].gk.setVisibility(8);
        }
        ats();
      }
      return;
    }
    ats();
    finish();
  }
  
  public void mz(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setNetTips-->type=" + paramInt);
    }
    if (this.bY == null) {
      this.bY = new RemoveTipsRunnale();
    }
    if ((this.mApp == null) || (this.mApp.getHandler() == null)) {}
    do
    {
      return;
      this.mApp.getHandler().post(this.bY);
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      while (this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
      {
        MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
        int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
        int i = 0;
        while (i < j)
        {
          MultiVideoEnterPageMembersControlUI localMultiVideoEnterPageMembersControlUI = arrayOfMultiVideoEnterPageMembersControlUI[i];
          if (paramInt != -1)
          {
            localMultiVideoEnterPageMembersControlUI.mM.setText(paramInt);
            localMultiVideoEnterPageMembersControlUI.mProgressBar.setVisibility(0);
          }
          i += 1;
        }
        this.mApp.getHandler().postDelayed(new MultiVideoEnterPageActivity.6(this), 1000L);
        paramInt = -1;
        continue;
        paramInt = 2131698163;
        continue;
        paramInt = 2131698165;
      }
    } while (paramInt == -1);
    this.mM.setText(paramInt);
    this.mProgressBar.setVisibility(0);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    anv();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559933);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    AVActivity.c(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    AVActivity.d(super.getWindow());
    this.mApp = ((VideoAppInterface)super.getAppRuntime());
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "onCreate-->can not get the VideoAppInterface");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "onCreate-->can not get the VideoController");
      }
      finish();
      return;
    }
    this.mApp.addObserver(this.jdField_b_of_type_Iid);
    this.mApp.addObserver(this.jdField_a_of_type_Iiz);
    if (!wn())
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "can not processExtraData");
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = new TimeoutRunnable();
    this.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable, 15000L);
    initUI();
    anot.a(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "exp", 0, 0, this.Rv, "", "", "");
    if (this.bW == null) {
      this.bW = new RefreshDisplayNameRunnable();
    }
    this.mApp.getHandler().post(this.bW);
    aqji.c.edY();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.deleteObserver(this.jdField_b_of_type_Iid);
    this.mApp.deleteObserver(this.jdField_a_of_type_Iiz);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable);
    this.mApp.getHandler().removeCallbacks(this.bY);
    this.mApp.getHandler().removeCallbacks(this.bZ);
    this.mApp.getHandler().removeCallbacks(this.bW);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.OQ = false;
    }
    this.bW = null;
    this.bZ = null;
    this.bY = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$TimeoutRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.destroy();
    this.mM = null;
    this.mProgressBar = null;
    this.c = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      QLog.w(this.TAG, 1, "onResume, mRelationType[" + this.aqx + "], mRelationId[" + this.md + "], multiAVType[" + this.jdField_a_of_type_ComTencentAvVideoController.b().anb + "], currentAvtype[" + this.awJ + "]");
      lh(this.awJ);
    }
    if (this.bZ == null) {
      this.bZ = new RefreshFaceRunnable();
    }
    for (;;)
    {
      this.mApp.getHandler().postDelayed(this.bZ, 2000L);
      return;
      this.mApp.getHandler().removeCallbacks(this.bZ);
    }
  }
  
  public boolean uw()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {}
    while (isFinishing()) {
      return true;
    }
    return false;
  }
  
  boolean wn()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "processExtraData-->can not get intent");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              AudioHelper.b(this.TAG + ".processExtraData", localIntent.getExtras(), true);
              this.Xo = localIntent.getBooleanExtra("openClass", false);
              this.q = localIntent.getLongArrayExtra("DiscussUinList");
              this.Rx = localIntent.getStringExtra("creator_nick");
              this.mSessionType = localIntent.getIntExtra("sessionType", 0);
              if ((this.mSessionType == 3) || (this.mSessionType == 4)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.TAG, 2, "processExtraData-->get the wrong sessionType,Type=" + this.mSessionType);
            return false;
            this.mType = localIntent.getIntExtra("Type", -1);
            if (this.mType == 3) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e(this.TAG, 2, "processExtraData-->get the wrong GAudioStatus,Type=" + this.mType);
          return false;
          this.Rw = localIntent.getStringExtra("uin");
          this.Rv = localIntent.getStringExtra("GroupId");
          if (this.Rv != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "processExtraData-->can not get the groupuin");
        return false;
        this.md = Long.valueOf(this.Rv).longValue();
        if (this.md != 0L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.TAG, 2, "processExtraData-->can not get the groupuin");
      return false;
      int i = localIntent.getIntExtra("MultiAVType", 0);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Get Intent AVType : " + i);
      }
      this.awJ = i;
      this.mUinType = localIntent.getIntExtra("uinType", -1);
      if (this.mUinType == 3000) {}
      for (this.aqx = 2;; this.aqx = 1)
      {
        this.Xn = localIntent.getBooleanExtra("flag", false);
        return true;
        if (this.mUinType != 1) {
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "processExtraData-->can not get uin Type.");
    return false;
  }
  
  class RefreshDisplayNameRunnable
    implements Runnable
  {
    RefreshDisplayNameRunnable() {}
    
    public void run()
    {
      Object localObject = MultiVideoEnterPageActivity.this.mApp.getApp().getString(2131697560);
      if (MultiVideoEnterPageActivity.this.aqx == 2) {
        localObject = MultiVideoEnterPageActivity.this.mApp.getDisplayName(3000, String.valueOf(MultiVideoEnterPageActivity.this.md), null);
      }
      for (;;)
      {
        MultiVideoEnterPageActivity.this.a.mN.setText((CharSequence)localObject);
        localObject = MultiVideoEnterPageActivity.this;
        ((MultiVideoEnterPageActivity)localObject).awF += 1;
        if (MultiVideoEnterPageActivity.this.bW != null)
        {
          if (MultiVideoEnterPageActivity.this.awF >= 3) {
            break;
          }
          MultiVideoEnterPageActivity.this.mApp.getHandler().postDelayed(MultiVideoEnterPageActivity.this.bW, 1000L);
        }
        return;
        if (MultiVideoEnterPageActivity.this.aqx == 1) {
          localObject = MultiVideoEnterPageActivity.this.mApp.getDisplayName(1, String.valueOf(MultiVideoEnterPageActivity.this.md), null);
        }
      }
      MultiVideoEnterPageActivity.this.mApp.getHandler().removeCallbacks(MultiVideoEnterPageActivity.this.bW);
    }
  }
  
  class RefreshFaceRunnable
    implements Runnable
  {
    RefreshFaceRunnable() {}
    
    public void run()
    {
      if (MultiVideoEnterPageActivity.this.a != null)
      {
        MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = MultiVideoEnterPageActivity.this.a;
        int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
        int i = 0;
        while (i < j)
        {
          arrayOfMultiVideoEnterPageMembersControlUI[i].asZ();
          i += 1;
        }
      }
      if (MultiVideoEnterPageActivity.this.c != null) {
        MultiVideoEnterPageActivity.this.c.asZ();
      }
      MultiVideoEnterPageActivity.this.mApp.getHandler().postDelayed(this, 2000L);
    }
  }
  
  class RemoveTipsRunnale
    implements Runnable
  {
    RemoveTipsRunnale() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiVideoEnterPageActivity.this.TAG, 2, "RemoveTipsRunnale Run");
      }
      MultiVideoEnterPageActivity.this.att();
    }
  }
  
  class TimeoutRunnable
    implements Runnable
  {
    TimeoutRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.w(MultiVideoEnterPageActivity.this.TAG, 1, "TimeoutRunnable, mHaveMoreRoom[" + MultiVideoEnterPageActivity.this.Xn + "]");
      }
      QQToast.a(MultiVideoEnterPageActivity.this, 2131697868, 1).show(MultiVideoEnterPageActivity.d(MultiVideoEnterPageActivity.this).getDimensionPixelSize(2131299627));
      if (!MultiVideoEnterPageActivity.this.Xn)
      {
        MultiVideoEnterPageActivity.this.ats();
        MultiVideoEnterPageActivity.this.finish();
      }
    }
  }
  
  static class a
    extends aqju
  {
    public a(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public static aqju a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
    {
      paramContext = new a(paramContext, 2131756467);
      paramContext.setContentView(2131559151);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
      paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      QLog.w("MultiVideoEnterPageActivity", 1, "onWindowFocusChanged, hasFocus[" + paramBoolean + "]");
      if (!paramBoolean) {
        dismiss();
      }
    }
  }
  
  class b
    implements DialogInterface.OnClickListener
  {
    int mode;
    
    public b(int paramInt)
    {
      this.mode = paramInt;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      switch (this.mode)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.e(MultiVideoEnterPageActivity.this.TAG, 2, "DialogInterfaceOnClickListener-->Wrong type.mode=" + this.mode);
        }
        paramDialogInterface.dismiss();
        return;
      case 0: 
        MultiVideoEnterPageActivity.this.mApp.getApp().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        paramDialogInterface.dismiss();
        if (MultiVideoEnterPageActivity.this.a.sw()) {
          MultiVideoEnterPageActivity.this.a.hI(true);
        }
        MultiVideoEnterPageActivity.this.a.b(MultiVideoEnterPageActivity.this.a.b().relationType, MultiVideoEnterPageActivity.this.a.b().ll, 81);
        MultiVideoEnterPageActivity.this.mC(MultiVideoEnterPageActivity.this.awJ);
        return;
      }
      paramDialogInterface.dismiss();
    }
  }
  
  static class c
  {
    Button bj = null;
    LinearLayout de = null;
    RelativeLayout ef = null;
    Button mCloseBtn = null;
    TextView mN = null;
    TextView mO = null;
    
    void destroy()
    {
      this.ef = null;
      this.mN = null;
      this.mO = null;
      this.bj = null;
      this.mCloseBtn = null;
      this.de = null;
    }
    
    void p(Activity paramActivity)
    {
      this.ef = ((RelativeLayout)paramActivity.findViewById(2131374138));
      this.mN = ((TextView)paramActivity.findViewById(2131373973));
      this.mO = ((TextView)paramActivity.findViewById(2131373972));
      this.bj = ((Button)paramActivity.findViewById(2131374003));
      this.mCloseBtn = ((Button)paramActivity.findViewById(2131373996));
      this.de = ((LinearLayout)paramActivity.findViewById(2131374001));
    }
    
    void setVisibility(int paramInt)
    {
      if (this.ef != null) {
        this.ef.setVisibility(paramInt);
      }
      if (this.mN != null) {
        this.mN.setVisibility(paramInt);
      }
      if (this.mO != null) {
        this.mO.setVisibility(paramInt);
      }
      if (this.de != null) {
        this.de.setVisibility(paramInt);
      }
      if (this.bj != null) {
        this.bj.setVisibility(paramInt);
      }
      if ((this.mCloseBtn != null) && (paramInt != 0)) {
        this.mCloseBtn.setVisibility(paramInt);
      }
    }
  }
  
  class d
    extends iiz
  {
    d() {}
    
    public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      if ((MultiVideoEnterPageActivity.this.jdField_a_of_type_ComTencentAvVideoController == null) || (MultiVideoEnterPageActivity.this.mApp == null))
      {
        QLog.w(MultiVideoEnterPageActivity.this.TAG, 1, "onKickOutResult, empty");
        return;
      }
      if (paramLong != MultiVideoEnterPageActivity.this.md)
      {
        QLog.w(MultiVideoEnterPageActivity.this.TAG, 1, "onKickOutResult, ignore");
        return;
      }
      if (paramBoolean)
      {
        MultiVideoEnterPageActivity.this.jdField_a_of_type_ComTencentAvVideoController.h(MultiVideoEnterPageActivity.this.mApp.getLongAccountUin(), paramLong, MultiVideoEnterPageActivity.this.oD);
        MultiVideoEnterPageActivity.this.my(paramInt2);
        return;
      }
      if (paramInt3 == -5)
      {
        if (MultiVideoEnterPageActivity.this.Xn) {
          if ((MultiVideoEnterPageActivity.this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (MultiVideoEnterPageActivity.this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1) && (MultiVideoEnterPageActivity.this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] != null)) {
            MultiVideoEnterPageActivity.this.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].bm.setVisibility(8);
          }
        }
        for (;;)
        {
          QQToast.a(MultiVideoEnterPageActivity.this, 2131694556, 1).show(MultiVideoEnterPageActivity.b(MultiVideoEnterPageActivity.this).getDimensionPixelSize(2131299627));
          return;
          MultiVideoEnterPageActivity.this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$c.mCloseBtn.setVisibility(8);
        }
      }
      QQToast.a(MultiVideoEnterPageActivity.this, 2131694555, 1).show(MultiVideoEnterPageActivity.c(MultiVideoEnterPageActivity.this).getDimensionPixelSize(2131299627));
    }
    
    public void onFinish(long paramLong)
    {
      super.onFinish(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d(MultiVideoEnterPageActivity.this.TAG, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + paramLong + ", mRelationId = " + MultiVideoEnterPageActivity.this.md);
      }
      if ((paramLong != 0L) && (paramLong == MultiVideoEnterPageActivity.this.md))
      {
        if (QLog.isColorLevel()) {
          QLog.d(MultiVideoEnterPageActivity.this.TAG, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
        }
        MultiVideoEnterPageActivity.this.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity
 * JD-Core Version:    0.7.0.1
 */