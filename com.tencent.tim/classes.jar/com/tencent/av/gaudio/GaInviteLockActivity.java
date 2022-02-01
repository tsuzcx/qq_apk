package com.tencent.av.gaudio;

import acfp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import arlc;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import iid;
import iio;
import iiv;
import imb;
import imc;
import ino;
import inp;
import inq;
import inr;
import ins;
import int;
import inu;
import inv;
import inx;
import ivv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jcr;
import jjc;
import jjh;
import jjk;
import jko;
import jkq;
import mqq.os.MqqHandler;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  private boolean To;
  BroadcastReceiver X = null;
  private BroadcastReceiver Y = new inr(this);
  private final MainThreadRunnableTask jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask = new MainThreadRunnableTask();
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
  public QavPanel a;
  private iio jdField_a_of_type_Iio = new ino(this);
  private imc jdField_a_of_type_Imc = new imc();
  jcr jdField_a_of_type_Jcr = null;
  private iid b = new inq(this);
  private Runnable bm = new GaInviteLockActivity.2(this);
  private final Runnable bn = new GaInviteLockActivity.11(this);
  private MqqHandler c;
  Drawable cc = null;
  private MqqHandler d;
  private ArrayList<inx> ir = new ArrayList();
  private long mRoomId;
  TextView my = null;
  
  public GaInviteLockActivity()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
  }
  
  private void aE(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label292:
    for (;;)
    {
      return;
      if (jkq.o(paramIntent)) {
        anot.a(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l = AudioHelper.hG();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_d_of_type_Iiv == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label213;
          }
          if (uy()) {
            break label194;
          }
          aov();
          this.Tj = true;
          label98:
          anot.a(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label292;
        }
        QLog.i(this.TAG, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "], silent[" + this.Tj + "]");
        return;
        paramIntent = this.jdField_d_of_type_Iiv.sessionId;
        break;
        label194:
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.i(this.TAG, 2, "checkParamAndDoAction onPhoneCalling");
        break label98;
        label213:
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.i(this.TAG, 2, "checkParamAndDoAction not same , coming[" + str2 + "], cur[" + paramIntent + "]");
        break label98;
        if ("com.tencent.qav.notify.refuse".equals(str1))
        {
          TraeHelper.t(this.mApp);
          super.cm(l);
          this.Tj = true;
        }
      }
    }
  }
  
  private void aoB()
  {
    if (this.jdField_d_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_d_of_type_MqqOsMqqHandler.removeCallbacks(this.bm);
      this.jdField_d_of_type_MqqOsMqqHandler.postDelayed(this.bm, 10000L);
    }
  }
  
  private void aoC()
  {
    QLog.w(this.TAG, 1, "doAsyncGetHeadImgAndNickName");
    int i;
    if (this.gn != null)
    {
      this.gn.setImageResource(2130839584);
      i = 1;
      if (this.mx == null) {
        break label104;
      }
      String str = Long.toString(this.mf);
      this.mx.setText(str);
    }
    for (;;)
    {
      if ((this.c != null) && (i != 0))
      {
        this.c.removeCallbacks(this.bn);
        this.c.post(this.bn);
      }
      return;
      QLog.w(this.TAG, 1, "doAsyncGetHeadImgAndNickName[], mHeadImage为空");
      i = 0;
      break;
      label104:
      QLog.w(this.TAG, 1, "doAsyncGetHeadImgAndNickName[], mCallersName为空");
      i = 0;
    }
  }
  
  private void b(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.mGroupId) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.To = true;
      jq("handleMemberListUpdate");
    }
  }
  
  private void jq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "notifyDataChange mHasCallFromMemberList:=" + this.To + ":from=" + paramString);
    }
    aoB();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.aP();
    paramString = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoController.b)((Iterator)localObject1).next();
      if (((VideoController.b)localObject2).uin != this.mf) {
        paramString.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((VideoController.b)localObject2).uin));
    }
    int i = paramString.size();
    localObject1 = this.ir.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (inx)((Iterator)localObject1).next();
      VideoController.b localb;
      if (!localHashSet.contains(Long.valueOf(((inx)localObject2).mUserUin)))
      {
        localb = new VideoController.b();
        localb.uin = ((inx)localObject2).mUserUin;
        localb.timeStamp = ((inx)localObject2).mg;
        if (((inx)localObject2).mUserUin == this.mApp.getLongAccountUin())
        {
          paramString.add(0, localb);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        paramString.add(localb);
      }
    }
    ThreadManager.getSubThreadHandler().post(new GaInviteLockActivity.7(this, i, paramString));
  }
  
  private void lh(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.mGroupId, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getGAudioRoomMemList " + bool);
    }
    if (!bool)
    {
      QQToast.a(this, acfp.m(2131706698), 1).show(getResources().getDimensionPixelSize(2131299627));
      finish();
    }
  }
  
  private boolean ux()
  {
    boolean bool = false;
    if (this.mApp.sM())
    {
      jjk.S(false, true);
      aqha.b(this, this.mApp.getApp().getString(2131697640), this.mApp.getApp().getString(2131697638), null, new int(this), null);
      bool = true;
    }
    return bool;
  }
  
  private boolean uy()
  {
    boolean bool = false;
    if (this.mApp.sM())
    {
      jjk.S(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "startVideo phone is calling!");
      }
      String str = this.mApp.getApp().getString(2131697638);
      aqha.b(this, this.mApp.getApp().getString(2131697640), str, null, new inv(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    String str;
    if (VideoController.isScreenLocked(this))
    {
      str = "1";
      switch (paramView.getId())
      {
      }
    }
    do
    {
      return;
      str = "2";
      break;
      anot.a(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str, "", "", "");
      co(-1037L);
      return;
    } while (uy());
    anot.a(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str, "", "", "");
    aov();
  }
  
  void Fb()
  {
    int j = 8;
    boolean bool = VideoController.isScreenLocked(this);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131374149));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559952);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new ins(this));
    }
    View localView1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131374018);
    View localView2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131374016);
    if (bool) {}
    for (int i = 8;; i = 0)
    {
      localView1.setVisibility(i);
      i = j;
      if (bool) {
        i = 0;
      }
      localView2.setVisibility(i);
      if ((ThemeUtil.isInNightMode(this.mApp)) && (!bool)) {
        super.findViewById(2131374146).setVisibility(0);
      }
      return;
    }
  }
  
  void aox()
  {
    boolean bool = VideoController.isScreenLocked(this);
    if ((!ivv.isAppOnForeground(this)) || (bool) || (this.jdField_a_of_type_Jcr == null))
    {
      super.aox();
      return;
    }
    this.jdField_a_of_type_Jcr.a(new inp(this));
  }
  
  public void co(long paramLong)
  {
    if ((ivv.isAppOnForeground(this)) && (this.jdField_a_of_type_Jcr != null))
    {
      this.jdField_a_of_type_Jcr.a(new inu(this, paramLong));
      return;
    }
    super.cm(paramLong);
  }
  
  protected void initUI()
  {
    Fb();
    this.gn = ((ImageView)super.findViewById(2131374011));
    this.mx = ((TextView)super.findViewById(2131373998));
    this.mw = ((TextView)super.findViewById(2131374014));
    this.cc = jjh.d(super.getApplicationContext(), 2130842961);
    View localView = super.findViewById(2131374015);
    if (this.cc != null)
    {
      localView.setBackgroundDrawable(this.cc);
      this.my = ((TextView)super.findViewById(2131374023));
      if ((!aqiw.isWifiConnected(super.getApplicationContext())) && ((aqiw.is3Gor4G(super.getApplicationContext())) || (aqiw.isMobileNetWork(super.getApplicationContext()))))
      {
        this.my.setVisibility(0);
        this.my.setText(2131698167);
      }
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)findViewById(2131374135));
      if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.mGroupId, this.aqx);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.mApp.b());
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#4C000000");
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        if (this.aqx != 1) {
          break label335;
        }
      }
    }
    label335:
    for (int i = 10;; i = 1)
    {
      this.mRoomId = this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, i, this.mGroupId);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mGroupId, this.mRoomId, true);
      lh(i);
      localView = findViewById(2131362726);
      super.initUI();
      this.jdField_a_of_type_Jcr = new jcr(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.gn, this.mx, localView, null);
      if (this.jdField_a_of_type_Jcr != null) {
        this.jdField_a_of_type_Jcr.atK();
      }
      return;
      localView.setBackgroundResource(2130842961);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onCreate");
    }
    AVActivity.c(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.Tg = false;
    this.c = ThreadManager.getSubThreadHandler();
    this.jdField_d_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    super.setContentView(2131559903);
    super.onCreate(paramBundle);
    aoC();
    this.mApp.addObserver(this.jdField_a_of_type_Iio);
    this.mApp.addObserver(this.b);
    registerReceiver(this.Y, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.X = new a();
    super.registerReceiver(this.X, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.c(getClass().getName(), getIntent());
    }
    aE(getIntent());
    if (jjc.xA())
    {
      if (this.jdField_a_of_type_Jko == null) {
        this.jdField_a_of_type_Jko = jko.a(this.mApp);
      }
      this.jdField_a_of_type_Jko.cancelNotification(this.jdField_d_of_type_Iiv.sessionId);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.X != null)
    {
      super.unregisterReceiver(this.X);
      this.X = null;
    }
    unregisterReceiver(this.Y);
    if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null)
    {
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.atv();
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
    }
    this.mApp.deleteObserver(this.jdField_a_of_type_Iio);
    this.mApp.deleteObserver(this.b);
    this.ir.clear();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.dz(-1044L);
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_Jcr != null)
    {
      this.jdField_a_of_type_Jcr.destroy();
      this.jdField_a_of_type_Jcr = null;
    }
    if (this.jdField_d_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_d_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask);
      this.jdField_d_of_type_MqqOsMqqHandler.removeCallbacks(this.bm);
      this.jdField_d_of_type_MqqOsMqqHandler = null;
    }
    if (this.c != null)
    {
      this.c.removeCallbacks(this.bn);
      this.c = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      anot.a(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.TAG, 1, "onNewIntent()");
    aE(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Imc.a(this.mApp, this.jdField_a_of_type_ComTencentAvVideoController);
    if (!this.Tl) {
      arlc.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    arlc.y(BaseApplicationImpl.getContext(), 50, 0);
    arlc.a(BaseApplicationImpl.getContext(), false, 50, 1);
    arlc.y(BaseApplicationImpl.getContext(), 50, 2);
    Fb();
    if (this.jdField_d_of_type_Iiv != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.d(GaInviteLockActivity.class);
    }
    this.jdField_a_of_type_Imc.a(this, this.mApp, this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  class MainThreadRunnableTask
    implements Runnable
  {
    private String MO;
    private Bitmap be;
    private String groupName;
    
    public MainThreadRunnableTask() {}
    
    public void a(String paramString1, String paramString2, Bitmap paramBitmap)
    {
      this.groupName = paramString1;
      this.MO = paramString2;
      this.be = paramBitmap;
    }
    
    public void run()
    {
      if (GaInviteLockActivity.this.gn != null) {
        GaInviteLockActivity.this.gn.setImageBitmap(this.be);
      }
      if (GaInviteLockActivity.this.mx != null) {
        GaInviteLockActivity.this.mx.setText(this.MO);
      }
      if (GaInviteLockActivity.this.mw != null)
      {
        String str = GaInviteLockActivity.this.a(GaInviteLockActivity.this.aqx, GaInviteLockActivity.this.mGroupId, this.groupName, true, false);
        GaInviteLockActivity.this.mw.setText(str);
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (paramContext.equals("homekey")))
        {
          anot.a(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
          GaInviteLockActivity.this.co(-1038L);
        }
      }
      boolean bool;
      do
      {
        do
        {
          return;
        } while (!paramContext.equals("android.intent.action.SCREEN_OFF"));
        bool = VideoController.isScreenLocked(GaInviteLockActivity.this);
        if (bool) {
          anot.a(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
        }
      } while (!QLog.isColorLevel());
      QLog.w(GaInviteLockActivity.this.TAG, 1, "ACTION_SCREEN_OFF, isScreenLocked[" + bool + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */