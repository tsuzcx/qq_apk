package com.tencent.av.ui;

import acfp;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ausj;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import iid;
import iin;
import iiv;
import ivv;
import izc;
import izf;
import izg;
import izh;
import izi;
import izj;
import izk;
import izl;
import java.util.ArrayList;
import jkn;
import wja;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean WA;
  private boolean Wz = true;
  private BroadcastReceiver Z;
  public VideoController a;
  private iid jdField_a_of_type_Iid = new izl(this);
  private iin jdField_a_of_type_Iin = new izg(this);
  private PinnedDividerListView b;
  public izc b;
  private Runnable bF;
  private View hU;
  private ArrayList<VideoController.b> iH;
  private View.OnTouchListener j = new izf(this);
  private Dialog m;
  VideoAppInterface mApp;
  public long mGroupId = 0L;
  private TextView mI;
  private TextView mTitle;
  
  private void I(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Izc != null) {
      this.jdField_b_of_type_Izc.H(paramLong, paramBoolean);
    }
  }
  
  private void asQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    asR();
    ausj localausj = ausj.d(this);
    View localView = super.getLayoutInflater().inflate(2131559905, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131373994);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localausj.addView(localView);
    localView = new View(this);
    localView.setBackgroundColor(Color.parseColor("#E5E6E7"));
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, wja.dp2px(1.0F, getResources())));
    localausj.addView(localView);
    localView = super.getLayoutInflater().inflate(2131558466, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131362005);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837647));
    boolean bool = jkn.xL();
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().QI)
    {
      localTextView2.setText(super.getString(2131697717));
      localTextView2.setTextColor(super.getResources().getColor(2131165230));
      if (bool) {}
      for (i = 2131697718;; i = 2131697719)
      {
        localTextView1.setText(super.getString(i));
        localausj.addView(localView);
        localausj.addCancelButton(super.getResources().getString(2131691040));
        localView.setOnClickListener(new izj(this, localausj));
        localausj.setOnDismissListener(new izk(this));
        localausj.setCanceledOnTouchOutside(true);
        this.m = localausj;
        try
        {
          this.m.show();
          return;
        }
        catch (Exception localException) {}
      }
    }
    else
    {
      localTextView2.setText(super.getString(2131697720));
      localTextView2.setTextColor(super.getResources().getColor(2131165227));
      if (bool) {}
      for (i = 2131697721;; i = 2131697722)
      {
        localTextView1.setText(super.getString(i));
        break;
      }
    }
  }
  
  private void asS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.WA)
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.aN().size();
        this.iH = this.jdField_a_of_type_ComTencentAvVideoController.a(i, this.jdField_a_of_type_ComTencentAvVideoController.aL());
      }
    }
    for (;;)
    {
      mq(this.iH.size());
      return;
      this.iH = ((ArrayList)this.jdField_a_of_type_ComTencentAvVideoController.aP().clone());
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
      }
    }
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  @TargetApi(14)
  private void initViews()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131377546);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      localRelativeLayout.setFitsSystemWindows(true);
    }
    boolean bool = ThemeUtil.isInNightMode(this.mApp);
    this.mTitle = ((TextView)super.findViewById(2131369627));
    this.hU = super.findViewById(2131369586);
    this.jdField_b_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131380348));
    this.mI = ((TextView)super.findViewById(2131374110));
    this.mI.setOnClickListener(this);
    this.mI.setOnTouchListener(this.j);
    if (bool)
    {
      localRelativeLayout.setBackgroundColor(Color.parseColor("#000000"));
      super.findViewById(2131379791).setBackgroundColor(-16777216);
      super.findViewById(2131373348).setBackgroundColor(Color.parseColor("#000000"));
      ((TextView)super.findViewById(2131369579)).setBackgroundDrawable(getResources().getDrawable(2130851113));
      this.mTitle.setTextColor(Color.parseColor("#A8A8A8"));
      this.mI.setTextColor(Color.parseColor("#A8A8A8"));
    }
    Object localObject;
    if (this.Wz)
    {
      localObject = super.getLayoutInflater().inflate(2131559909, this.jdField_b_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      if (!bool) {
        break label403;
      }
      ((View)localObject).findViewById(2131377546).setBackgroundColor(Color.parseColor("#080808"));
      ((TextView)((View)localObject).findViewById(2131379420)).setTextColor(Color.parseColor("#757575"));
    }
    label403:
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
      if (!this.Wz)
      {
        this.mI.setClickable(false);
        this.mI.setVisibility(8);
      }
      this.hU.setVisibility(0);
      this.hU.setOnTouchListener(new izh(this));
      this.hU.setOnClickListener(new izi(this));
      return;
      View localView = new View(localRelativeLayout.getContext());
      if (bool) {}
      for (localObject = "#080808";; localObject = "#F5F6FA")
      {
        localView.setBackgroundColor(Color.parseColor((String)localObject));
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(12.0F, localRelativeLayout.getResources())));
        localObject = localView;
        break;
      }
    }
  }
  
  private void mq(int paramInt)
  {
    if (this.mTitle != null) {
      if (!this.Wz) {
        break label44;
      }
    }
    label44:
    for (String str = acfp.m(2131706849);; str = acfp.m(2131706848))
    {
      this.mTitle.setText(String.format(str, new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
  }
  
  @TargetApi(11)
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "drawUI-->type=" + paramInt1 + " uin=" + paramLong + " fresh=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        notifyDataChange();
      }
      if (paramInt2 == 42)
      {
        I(paramLong, true);
        return;
      }
    } while (paramInt2 != 43);
    I(paramLong, false);
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    super.runOnUiThread(new RefreshUIRunnable(paramInt1, paramLong, paramBoolean, paramInt2));
  }
  
  public void asP()
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (localiiv != null)
    {
      if (localiiv.QI) {
        this.mI.setText(super.getString(2131697717));
      }
    }
    else {
      return;
    }
    this.mI.setText(super.getString(2131697720));
  }
  
  public void asR()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      label24:
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131755343);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559907);
    paramBundle = super.getIntent().getStringExtra("discussUin");
    this.Wz = super.getIntent().getBooleanExtra("Owner", true);
    this.WA = super.getIntent().getBooleanExtra("isInRoom", true);
    if (!this.WA) {
      this.Wz = false;
    }
    if (TextUtils.isEmpty(paramBundle))
    {
      finish();
      return false;
    }
    AVActivity.c(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    initViews();
    this.mApp = ((VideoAppInterface)super.getAppRuntime());
    if (this.mApp == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    this.mGroupId = this.jdField_a_of_type_ComTencentAvVideoController.b().ll;
    asS();
    this.jdField_b_of_type_Izc = new izc(this, this.mApp, this.jdField_b_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.b().ll, this.jdField_a_of_type_ComTencentAvVideoController.b().relationType, this.Wz);
    this.jdField_b_of_type_Izc.bC(this.iH);
    asP();
    this.mApp.addObserver(this.jdField_a_of_type_Iid);
    if (this.WA) {
      this.mApp.addObserver(this.jdField_a_of_type_Iin);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.Z = new a();
    super.registerReceiver(this.Z, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - l) + "ms");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
    if (this.WA) {
      this.mApp.deleteObserver(this.jdField_a_of_type_Iin);
    }
    if (this.bF != null) {
      this.mApp.getHandler().removeCallbacks(this.bF);
    }
    this.bF = null;
    this.jdField_b_of_type_Izc.onDestroy();
    this.jdField_b_of_type_Izc = null;
    if (this.iH != null) {
      this.iH.clear();
    }
    this.iH = null;
    this.mApp = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    try
    {
      if (this.Z != null)
      {
        super.unregisterReceiver(this.Z);
        this.Z = null;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
      this.mTitle = null;
      this.hU = null;
      this.mI = null;
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMembersCtrlActivity", 2, "", localException);
        }
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    iA(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.bF == null)
    {
      this.bF = new RefreshFaceRunnable(null);
      this.mApp.getHandler().postDelayed(this.bF, 2000L);
    }
    asP();
    iA(true);
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2130771990);
  }
  
  void notifyDataChange()
  {
    asS();
    if (this.jdField_b_of_type_Izc != null) {
      this.jdField_b_of_type_Izc.bC(this.iH);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374110) {
      asQ();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  class RefreshFaceRunnable
    implements Runnable
  {
    private RefreshFaceRunnable() {}
    
    public void run()
    {
      if (GAudioMembersCtrlActivity.this.b != null) {
        GAudioMembersCtrlActivity.this.b.asO();
      }
      GAudioMembersCtrlActivity.this.mApp.getHandler().postDelayed(this, 2000L);
    }
  }
  
  class RefreshUIRunnable
    implements Runnable
  {
    boolean Vv;
    int aul;
    int type;
    long uin;
    
    public RefreshUIRunnable(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.uin = paramLong;
      this.type = paramInt1;
      this.Vv = paramBoolean;
      this.aul = paramInt2;
    }
    
    public void run()
    {
      GAudioMembersCtrlActivity.this.a(this.type, this.uin, this.Vv, this.aul);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(GAudioMembersCtrlActivity.this.mApp.getApp().getPackageName()))) {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMembersCtrlActivity", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
        }
      }
      int i;
      long l;
      do
      {
        do
        {
          return;
        } while (!paramContext.equals("tencent.av.v2q.StopVideoChat"));
        i = paramIntent.getIntExtra("stopReason3rd", -1);
        l = paramIntent.getLongExtra("groupId", -1L);
      } while ((i != 1) || (GAudioMembersCtrlActivity.this.mGroupId != l));
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "ACTION_STOP_VIDEO_CHAT");
      }
      GAudioMembersCtrlActivity.this.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity
 * JD-Core Version:    0.7.0.1
 */