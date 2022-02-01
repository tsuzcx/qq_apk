package com.tencent.av.ui;

import acfp;
import aeee;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqji.c;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igv;
import ihq;
import iid;
import iio;
import iiv;
import iiv.a;
import iiv.b;
import iiz;
import imb;
import inx;
import ivv;
import izv;
import izw;
import izx;
import izy;
import izz;
import jaa;
import jab;
import jac;
import jad;
import jae;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jjc;
import jje;
import jji;
import jko;
import jll;
import mqq.os.MqqHandler;

public class MultiIncomingCallsActivity
  extends BaseGaInvite
{
  public static boolean isShowing;
  String OD = null;
  public String OG = "";
  String Rq;
  public boolean Td = false;
  private boolean To;
  boolean VL = false;
  boolean WT;
  boolean WU = false;
  private boolean WW;
  private boolean WX;
  private BroadcastReceiver Y;
  iid jdField_a_of_type_Iid = new izw(this);
  private iio jdField_a_of_type_Iio = new izv(this);
  iiz jdField_a_of_type_Iiz = new izx(this);
  jje jdField_a_of_type_Jje = null;
  jko jdField_a_of_type_Jko;
  int aqD = -1;
  int aww = 0;
  MutiMemberThumbList jdField_b_of_type_ComTencentAvUiMutiMemberThumbList;
  private iid jdField_b_of_type_Iid = new izy(this);
  private Runnable bm = new MultiIncomingCallsActivity.2(this);
  Bitmap bv = null;
  private MqqHandler d;
  iiv e = null;
  private ArrayList<inx> ir = new ArrayList();
  int mBindType = 0;
  private BroadcastReceiver mBroadcastReceiver = new izz(this);
  TextView mJ = null;
  public String mPeerUin = null;
  private long mRoomId;
  long[] o = null;
  
  private void aoB()
  {
    if (this.d != null)
    {
      this.d.removeCallbacks(this.bm);
      this.d.postDelayed(this.bm, 10000L);
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
      notifyDataChange();
    }
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void lh(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.mGroupId, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getGAudioRoomMemList " + bool);
    }
    if (!bool)
    {
      QQToast.a(this, acfp.m(2131708580), 1).show(getResources().getDimensionPixelSize(2131299627));
      finish();
    }
  }
  
  private void notifyDataChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "notifyDataChange mHasCallFromMemberList:=" + this.To);
    }
    aoB();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.aP();
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoController.b)((Iterator)localObject1).next();
      if (((VideoController.b)localObject2).uin != this.mf) {
        localArrayList.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((VideoController.b)localObject2).uin));
    }
    int i = localArrayList.size();
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
          localArrayList.add(0, localb);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        localArrayList.add(localb);
      }
    }
    ThreadManager.getSubThreadHandler().post(new MultiIncomingCallsActivity.10(this, i, localArrayList));
  }
  
  public void H(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      QLog.w(this.TAG, 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      localObject = Long.valueOf(jji.B(this.mPeerUin));
      if (!this.Td) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, ((Long)localObject).longValue(), 2);
    return;
    if (this.e == null) {}
    for (Object localObject = this.mPeerUin;; localObject = this.e.peerUin)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.O((String)localObject, 241);
      this.jdField_a_of_type_ComTencentAvVideoController.ko(241);
      return;
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("ignoreMultiCall, refuse3rd[").append(paramBoolean2).append("], mVideoController[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      bool = true;
      QLog.w(str, 1, bool + "], seq[" + paramLong1 + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label88:
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
      }
      while ((paramBoolean1) && (this.mApp != null))
      {
        this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
      }
    }
  }
  
  public void a(long paramLong, Intent paramIntent, iiv paramiiv)
  {
    aqji.c.SF(true);
    sendBroadcast(new Intent("com.tencent.werewoves.plugin"));
    sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    mv(1);
    if (ihq.sH())
    {
      sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
      return;
    }
    a(paramLong, "onClickAccept", paramIntent, paramiiv);
    this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(this.mGroupId), Integer.valueOf(3) });
    kd("onClickAccept");
  }
  
  public void a(long paramLong, String paramString, Intent paramIntent, iiv paramiiv)
  {
    iiv localiiv = igv.a().a();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("acceptRequest, from[").append(paramString).append("], HandleSessionInfo[").append(paramiiv).append("], CurMainSession[").append(localiiv).append("], mSessionInfo[").append(this.e).append("], SameSession[");
    boolean bool;
    if (paramiiv == localiiv)
    {
      bool = true;
      QLog.w(str, 1, bool + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.OD + "], getAliveSessionCount[" + igv.a().kv() + "], seq[" + paramLong + "]");
      this.WU = true;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.OD) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.hI(true);
    }
    for (;;)
    {
      if ((this.e != null) && (!this.e.tc()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Session already destroyed, id:" + this.e.sessionId + ", status = " + this.e.state);
        }
        return;
        bool = false;
        break;
        label250:
        if ((paramiiv != null) && (localiiv == paramiiv) && (igv.a().kv() >= 2))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.hM(true);
          if (paramiiv.tc()) {
            a(paramLong, paramString, false, paramiiv, -1);
          }
          for (;;)
          {
            c(paramiiv);
            break;
            this.jdField_a_of_type_ComTencentAvVideoController.a(true, 205, new int[] { localiiv.anb });
            this.jdField_a_of_type_ComTencentAvVideoController.ko(205);
          }
        }
      }
    }
    if (uv())
    {
      aov();
      return;
    }
    aF(paramIntent);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, iiv paramiiv, int paramInt)
  {
    boolean bool3 = true;
    QLog.w(this.TAG, 1, "ignoreRequest[" + paramString + "], refuse3rd[" + paramBoolean + "], mainSessionInfo[" + paramiiv + "], iFlag[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      this.WU = false;
    }
    TraeHelper.t(this.mApp);
    paramString = this.mPeerUin;
    boolean bool1 = this.Td;
    int i = this.aqx;
    long l = this.mGroupId;
    if (!paramBoolean) {
      if (paramiiv != null)
      {
        String str = paramiiv.peerUin;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramiiv.senderUin;
        }
        bool1 = paramiiv.Qw;
        i = paramiiv.relationType;
        l = paramiiv.ll;
      }
    }
    for (;;)
    {
      int j = jll.cM(i);
      if (!paramBoolean)
      {
        bool2 = bool3;
        if (!bool1) {
          if (!co(j)) {
            break label234;
          }
        }
      }
      label234:
      for (boolean bool2 = bool3; co(j); bool2 = false)
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, paramString, bool2, paramBoolean);
      return;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.TAG, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    QLog.w(this.TAG, 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    long l2;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = jji.B(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l1, 23);
          if ((!paramBoolean2) || (this.mApp == null)) {
            break;
          }
          this.mApp.l(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.TAG, 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l1, 1);
        continue;
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallsActivity.11(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  public void aC(Intent paramIntent)
  {
    long l = AudioHelper.hG();
    this.aqx = 3;
    super.aC(paramIntent);
    if (paramIntent == null) {}
    label358:
    do
    {
      return;
      this.mPeerUin = paramIntent.getStringExtra("peerUin");
      this.OD = paramIntent.getStringExtra("extraUin");
      this.Td = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      this.aqD = paramIntent.getIntExtra("memberType", -1);
      this.WT = paramIntent.getBooleanExtra("hasGVideoJoined", false);
      this.VL = paramIntent.getBooleanExtra("isAudioMode", false);
      this.mBindType = paramIntent.getIntExtra("bindType", 0);
      String str = igv.a(3, this.mPeerUin, new int[0]);
      if (this.Td)
      {
        str = igv.a(100, this.mPeerUin, new int[0]);
        this.VL = false;
      }
      int i;
      if (uv())
      {
        this.aww = paramIntent.getIntExtra("MultiAVType", -1);
        if (this.aww == 2)
        {
          this.VL = false;
          this.OG = paramIntent.getStringExtra("inviteId");
          str = igv.a(this.aqx, String.valueOf(this.mGroupId), new int[0]);
          this.o = paramIntent.getLongArrayExtra("memberList");
          i = jjc.cJ(this.aqx);
          this.OE = this.mApp.getDisplayName(i, String.valueOf(this.mf), String.valueOf(this.mGroupId));
        }
      }
      for (this.bv = this.mApp.a(i, String.valueOf(this.mf), this.OD, true, true);; this.bv = this.mApp.a(this.mUinType, this.mPeerUin, this.OD, true, true))
      {
        this.e = igv.a().c(str);
        if (this.e != null) {
          break label358;
        }
        kd("processIntent_fail");
        return;
        this.VL = true;
        break;
        this.OE = this.mApp.getDisplayName(this.mUinType, this.mPeerUin, this.OD);
      }
    } while (m(paramIntent));
    b(l, paramIntent);
  }
  
  void aF(Intent paramIntent)
  {
    Object localObject2 = null;
    QLog.d(this.TAG, 1, "startVideoChatActivity");
    TraeHelper.a().connectHighestPriorityDevice();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.OQ)) {
      this.mApp.l(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject1;
    int i;
    if (this.e != null)
    {
      localObject1 = this.e.MX;
      i = this.e.bindType;
      localObject2 = this.e.signature;
    }
    for (;;)
    {
      int j = paramIntent.getIntExtra("uinType", -1);
      boolean bool = paramIntent.getBooleanExtra("isAudioMode", false);
      if (this.Td)
      {
        paramIntent = super.getIntent().getStringExtra("peerUin");
        localIntent.putExtra("sessionType", 3);
        localIntent.putExtra("Type", 1);
        localIntent.putExtra("uin", paramIntent);
        localIntent.putExtra("uinType", 0);
        localIntent.putExtra("isDoubleVideoMeeting", true);
        localIntent.putExtra("inviteUin", paramIntent);
        localIntent.putExtra("sessionType", 1);
        localIntent.putExtra("isSender", false);
        localIntent.putExtra("isEnter", true);
        localIntent.putExtra("name", this.OE);
        super.startActivity(localIntent);
        super.overridePendingTransition(2130772239, 2130772238);
        return;
      }
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", (String)localObject1);
      localIntent.putExtra("uin", this.mPeerUin);
      localIntent.putExtra("name", this.OE);
      localIntent.putExtra("extraUin", this.OD);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = this.TAG;
        localObject1 = new StringBuilder().append("startVideoChatActivity: bindType = ").append(i).append(",bindId = ").append((String)localObject1).append(",BindType = ");
        if (this.e == null)
        {
          paramIntent = "session info null";
          label433:
          QLog.d((String)localObject2, 2, paramIntent);
        }
      }
      else
      {
        if (j == 0) {
          localIntent.putExtra("isFriend", this.mApp.isFriend(this.mPeerUin));
        }
        if (!bool) {
          break label514;
        }
        localIntent.putExtra("sessionType", 1);
      }
      for (;;)
      {
        localIntent.putExtra("isSender", false);
        break;
        paramIntent = Integer.valueOf(this.e.bindType);
        break label433;
        label514:
        localIntent.putExtra("sessionType", 2);
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  public void aou()
  {
    if (this.jdField_a_of_type_Jko != null) {
      this.jdField_a_of_type_Jko.cancelNotification(this.e.sessionId);
    }
    mv(2);
    a(AudioHelper.hG(), "onInviteTimeOut", true, igv.a().a(), 8);
    kd("onInviteTimeOut");
  }
  
  void aov()
  {
    QLog.d(this.TAG, 1, "startGActivity");
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.mGroupId));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.o);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.e.anb);
    localIntent.putExtra("uin", String.valueOf(this.mGroupId));
    localIntent.putExtra("uinType", this.mUinType);
    localIntent.putExtra("isFromInviteDialog", true);
    super.startActivity(localIntent);
  }
  
  void asW()
  {
    if (this.jdField_a_of_type_Jko == null) {
      this.jdField_a_of_type_Jko = jko.a(this.mApp);
    }
    if (uv())
    {
      if (this.e != null)
      {
        localObject = String.valueOf(this.mGroupId);
        Bitmap localBitmap = this.mApp.a(this.mUinType, (String)localObject, null, true, true);
        String str = this.mApp.getDisplayName(jjc.cJ(this.aqx), Long.toString(this.mf), (String)localObject);
        this.jdField_a_of_type_Jko.a(this.e.sessionId, str, localBitmap, (String)localObject, 57, this.mUinType, 3);
      }
      return;
    }
    Object localObject = this.mApp.a(this.mUinType, this.mPeerUin, this.OD, true, true);
    if ((!this.VL) && (!this.Td))
    {
      this.jdField_a_of_type_Jko.a(this.e.sessionId, this.OE, (Bitmap)localObject, null, 56, this.mUinType, 2);
      return;
    }
    this.jdField_a_of_type_Jko.a(this.e.sessionId, this.OE, (Bitmap)localObject, null, 55, this.mUinType, 1);
  }
  
  void asX()
  {
    if (this.mw == null) {
      return;
    }
    this.mw.setSingleLine();
    if (uv())
    {
      localObject = a(this.aqx, this.mGroupId, null, this.VL, true);
      this.mw.setText((CharSequence)localObject);
      return;
    }
    if (this.Td)
    {
      this.mw.setText(2131697839);
      return;
    }
    Object localObject = this.mw;
    if (this.VL) {}
    for (int i = 2131697852;; i = 2131697853)
    {
      ((TextView)localObject).setText(i);
      return;
    }
  }
  
  void asY()
  {
    if (this.jdField_a_of_type_Jje != null) {}
    try
    {
      this.jdField_a_of_type_Jje.dismiss();
      this.jdField_a_of_type_Jje = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  void b(long paramLong, Intent paramIntent)
  {
    asY();
    boolean bool1 = ThemeUtil.isInNightMode(this.mApp);
    this.jdField_a_of_type_Jje = new jje(this, bool1);
    View localView = LayoutInflater.from(this).inflate(2131559893, null);
    Object localObject1;
    label211:
    Object localObject2;
    label285:
    label485:
    int j;
    if (uv())
    {
      localObject1 = (ViewStub)localView.findViewById(2131374124);
      if (localObject1 != null) {
        ((ViewStub)localObject1).inflate();
      }
      this.gn = ((ImageView)localView.findViewById(2131374130));
      this.mx = ((TextView)localView.findViewById(2131374129));
      this.mx.setSingleLine();
      this.mw = ((TextView)localView.findViewById(2131374134));
      this.mJ = ((TextView)localView.findViewById(2131374128));
      if (ihq.sH())
      {
        this.mJ.setText(2131697811);
        this.mJ.setTextColor(getResources().getColor(2131166280));
      }
      asX();
      if (!uv()) {
        break label900;
      }
      if (this.bv != null) {
        this.gn.setImageBitmap(this.bv);
      }
      this.mx.setText(this.OE);
      this.jdField_a_of_type_Jje.k(localView, false);
      if (uv())
      {
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)localView.findViewById(2131374135));
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.mGroupId, this.aqx);
        localObject2 = this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList;
        if (!bool1) {
          break label929;
        }
        localObject1 = "#757575";
        ((MutiMemberThumbList)localObject2).setTextColor((String)localObject1);
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.setHeadImgMask(bool1);
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#F246505F");
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        this.mRoomId = this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.aww, this.mGroupId);
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.mGroupId, this.mRoomId, true);
        lh(this.aww);
      }
      localObject2 = (Button)localView.findViewById(2131374133);
      ((Button)localObject2).setOnClickListener(new jab(this, paramLong));
      this.jdField_a_of_type_Jje.setOnCancelListener(new jac(this, paramLong));
      this.jdField_a_of_type_Jje.setOnDismissListener(new jad(this));
      iiv localiiv = igv.a().a();
      localObject1 = (Button)localView.findViewById(2131374127);
      ((Button)localObject1).setOnClickListener(new jae(this, paramLong, paramIntent, localiiv));
      if (!uv()) {
        break label937;
      }
      ((Button)localObject1).setText(2131697854);
      ((Button)localObject2).setText(2131697860);
      if ((!this.VL) && (!this.Td)) {
        ((Button)localObject1).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130843040), null, null, null);
      }
      boolean bool2 = uv();
      if (bool1)
      {
        j = Color.parseColor("#A8A8A8");
        if (!bool2) {
          break label956;
        }
      }
    }
    label900:
    label929:
    label937:
    label956:
    for (int i = 2131374126;; i = 2131373976)
    {
      localView.findViewById(i).setBackgroundDrawable(getResources().getDrawable(2130851725));
      paramIntent = localView.findViewById(2131374131);
      paramIntent.setBackgroundDrawable(jll.a(67.199997F, this));
      paramIntent.setVisibility(0);
      this.mx.setTextColor(j);
      this.mw.setTextColor(j);
      this.mJ.setTextColor(j);
      localView.findViewById(2131365844).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842966);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject2).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject2).setCompoundDrawablePadding(0);
      ((Button)localObject2).setTextColor(j);
      localView.findViewById(2131374137).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842964);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject1).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject1).setCompoundDrawablePadding(0);
      ((Button)localObject1).setTextColor(j);
      this.jdField_a_of_type_Jje.show();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.mPeerUin, this.OD, Boolean.valueOf(this.Td), Integer.valueOf(this.mUinType), Integer.valueOf(this.aqx), Integer.valueOf(this.aqD), Boolean.valueOf(this.WT), Boolean.valueOf(this.VL), Integer.valueOf(this.mBindType) }));
      }
      TraeHelper.a().a(paramLong, this.mApp, 2131230749, null, 0, null);
      return;
      localObject1 = (ViewStub)localView.findViewById(2131373975);
      break;
      if (this.bv != null) {
        this.gn.setImageBitmap(this.bv);
      }
      k(this.mx);
      break label211;
      localObject1 = "#878B99";
      break label285;
      ((Button)localObject1).setText(2131697854);
      ((Button)localObject2).setText(2131697861);
      break label485;
    }
  }
  
  void c(iiv paramiiv)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramiiv != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramiiv.ll);
      localIntent.putExtra("peerUin", paramiiv.peerUin);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  void k(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f = super.getResources().getDimensionPixelSize(2131298234);
    String str2;
    int i;
    if (uv())
    {
      str2 = String.valueOf(this.mGroupId);
      str1 = super.getApplicationContext().getString(2131697703);
      int j = this.mApp.e(this.aqx, str2);
      i = j;
      if (j == 0)
      {
        if (this.o != null) {
          i = this.o.length + 1;
        }
      }
      else
      {
        if (i <= 999) {
          break label183;
        }
        f = super.getResources().getDimensionPixelSize(2131298236);
        label102:
        str2 = this.mApp.getDisplayName(this.mUinType, str2, null);
        str2 = jll.a(super.getApplicationContext(), str2, paramTextView, f);
        str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
      }
    }
    for (String str1 = str2 + str1;; str1 = this.OE)
    {
      paramTextView.setText(str1);
      return;
      i = 1;
      break;
      label183:
      if (i <= 99) {
        break label102;
      }
      f = super.getResources().getDimensionPixelSize(2131298235);
      break label102;
    }
  }
  
  public void kd(String paramString)
  {
    QLog.w(this.TAG, 1, "destroyUI[" + paramString + "]");
    asY();
    super.finish();
  }
  
  public boolean m(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    long l = AudioHelper.hG();
    String str1 = paramIntent.getAction();
    String str2;
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      str2 = paramIntent.getStringExtra("session_id");
      if (this.e == null)
      {
        localObject = null;
        if (!TextUtils.equals(str2, (CharSequence)localObject)) {
          break label137;
        }
        a(l, paramIntent, igv.a().a());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "]");
      }
      return bool;
      localObject = this.e.sessionId;
      break;
      label137:
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "checkParamAndDoAction coming[" + str2 + "], cur[" + (String)localObject + "]");
      }
    }
  }
  
  public void mv(int paramInt)
  {
    label258:
    label1410:
    for (;;)
    {
      iiv localiiv;
      int i;
      int j;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Object localObject12;
      Object localObject4;
      try
      {
        localiiv = igv.a().a();
        if ((localiiv == null) || (igv.a().kv() < 2)) {
          return;
        }
        i = localiiv.state;
        j = localiiv.amH;
        Object localObject1 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        localObject9 = null;
        localObject10 = null;
        localObject11 = null;
        localObject12 = null;
        localObject4 = null;
        if ((localiiv.uinType != 21) && ((localiiv.uinType != 1011) || (localiiv.jdField_a_of_type_Iiv$a == null) || (localiiv.jdField_a_of_type_Iiv$a.anA <= 0) || (localiiv.jdField_a_of_type_Iiv$a.chatType != 1))) {
          break label258;
        }
        if (paramInt == 0)
        {
          localObject4 = "0X8005BB9";
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label1410;
          }
          QLog.d(this.TAG, 2, "double random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
          localObject1 = localObject4;
          if (localObject1 == null) {
            break;
          }
          anot.a(null, "CliOper", "", "", localObject1, localObject1, 0, 0, "", "", "", "");
          return;
        }
      }
      finally {}
      if (paramInt == 1)
      {
        localObject4 = "0X8005BBA";
      }
      else if (paramInt == 2)
      {
        localObject4 = "0X8005BBB";
        continue;
        if ((localiiv.jdField_a_of_type_Iiv$b != null) && (localiiv.jdField_a_of_type_Iiv$b.chatType != 0) && (localiiv.jdField_a_of_type_Iiv$b.groupId > 0L))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBF";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "multi gonghui, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BC0";
            }
            else
            {
              localObject4 = localObject3;
              if (paramInt == 2) {
                localObject4 = "0X8005BC1";
              }
            }
          }
        }
        if ((localiiv.jdField_a_of_type_Iiv$a != null) && (localiiv.jdField_a_of_type_Iiv$a.anA > 0) && (localiiv.jdField_a_of_type_Iiv$a.chatType == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBC";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "multi random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BBD";
            }
            else
            {
              localObject4 = localObject5;
              if (paramInt == 2) {
                localObject4 = "0X8005BBE";
              }
            }
          }
        }
        if (localiiv.Qw)
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAA";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "double share, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAB";
            }
            else
            {
              localObject4 = localObject6;
              if (paramInt == 2) {
                localObject4 = "0X8005BAC";
              }
            }
          }
        }
        if ((localiiv.relationType == 1) && (localiiv.amI == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB3";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "group audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB4";
            }
            else
            {
              localObject4 = localObject7;
              if (paramInt == 2) {
                localObject4 = "0X8005BB5";
              }
            }
          }
        }
        if ((localiiv.relationType == 1) && (localiiv.amI == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB6";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "group video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB7";
            }
            else
            {
              localObject4 = localObject8;
              if (paramInt == 2) {
                localObject4 = "0X8005BB8";
              }
            }
          }
        }
        if ((localiiv.relationType == 2) && (localiiv.amI == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAD";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "discuss audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAE";
            }
            else
            {
              localObject4 = localObject9;
              if (paramInt == 2) {
                localObject4 = "0X8005BAF";
              }
            }
          }
        }
        if ((localiiv.relationType == 2) && (localiiv.amI == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB0";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "discuss video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB1";
            }
            else
            {
              localObject4 = localObject10;
              if (paramInt == 2) {
                localObject4 = "0X8005BB2";
              }
            }
          }
        }
        if ((localiiv.amI == 2) || ((localiiv.amK == 2) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA7";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "double video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA8";
            }
            else
            {
              localObject4 = localObject11;
              if (paramInt == 2) {
                localObject4 = "0X8005BA9";
              }
            }
          }
        }
        if ((localiiv.amI == 1) || ((localiiv.amK == 1) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA4";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.TAG, 2, "double audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA5";
            }
            else
            {
              localObject4 = localObject12;
              if (paramInt == 2) {
                localObject4 = "0X8005BA6";
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "nothing, action:" + paramInt + ", reportType:" + null + "SessionType:" + localiiv.amI + ", BeginSessionType:" + localiiv.amK + ", sessionStatus:" + j + ", state:" + i);
        }
        Object localObject3 = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onCreate, seq[" + l + "]");
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130851773);
    super.getWindow().addFlags(128);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramBundle != null) && (paramBundle.a(this)))
    {
      this.WW = true;
      return;
    }
    TraeHelper.a().dN(l);
    aC(super.getIntent());
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.c(getClass().getName(), getIntent());
    }
    if (this.mApp != null)
    {
      if (!uv()) {
        this.mApp.addObserver(this.jdField_a_of_type_Iiz);
      }
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
      if (uv())
      {
        this.d = ThreadManager.getUIHandler();
        this.mApp.addObserver(this.jdField_a_of_type_Iio);
        this.mApp.addObserver(this.jdField_b_of_type_Iid);
        this.Y = new jaa(this);
        registerReceiver(this.Y, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    try
    {
      registerReceiver(this.mBroadcastReceiver, paramBundle);
      this.WX = true;
      if (uv())
      {
        i = 30000;
        startTimer(i);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        int i = 60000;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    isShowing = false;
    QLog.d(this.TAG, 1, "onDestroy");
    asY();
    this.bv = null;
    if (this.mApp != null)
    {
      this.mApp.deleteObserver(this.jdField_a_of_type_Iiz);
      this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
      this.mApp.deleteObserver(this.jdField_a_of_type_Iio);
      this.mApp.deleteObserver(this.jdField_b_of_type_Iid);
    }
    if (this.Y != null) {}
    try
    {
      unregisterReceiver(this.Y);
      this.Y = null;
      if (this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList != null) {
        this.jdField_b_of_type_ComTencentAvUiMutiMemberThumbList.atv();
      }
      if (this.d != null)
      {
        this.d.removeCallbacks(this.bm);
        this.d = null;
      }
      if (this.jdField_a_of_type_Jko != null)
      {
        iiv localiiv = igv.a().a();
        if (this.e != localiiv) {
          this.jdField_a_of_type_Jko.cancelNotification(this.e.sessionId);
        }
        if (localiiv != null) {
          this.jdField_a_of_type_Jko.cM(localiiv.sessionId);
        }
        if ((localiiv != null) && (localiiv.sessionId != null) && (!localiiv.sessionId.equals(this.Rq))) {
          this.jdField_a_of_type_Jko.cancelNotification(this.Rq);
        }
        this.jdField_a_of_type_Jko = null;
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "onDestroy main[" + localiiv + "], cur[" + this.e + "], id[" + this.Rq + "]");
        }
      }
      if ((this.mApp != null) && (!this.WW)) {
        this.mApp.l(new Object[] { Integer.valueOf(707) });
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (this.WX)
          {
            unregisterReceiver(this.mBroadcastReceiver);
            this.WX = false;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.WU) && (paramInt == 4))
    {
      mv(2);
      a(AudioHelper.hG(), "onKeyDown", true, null, -1);
      kd("onKeyDown");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onNewIntent");
    }
    m(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d(this.TAG, 1, "onPause");
    aeee.e(this, 2, true);
    iA(false);
  }
  
  public void onResume()
  {
    super.onResume();
    isShowing = true;
    QLog.d(this.TAG, 1, "onResume");
    aeee.e(this, 2, false);
    iA(true);
    mv(0);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.co(this.mPeerUin);
      this.jdField_a_of_type_ComTencentAvVideoController.d(MultiIncomingCallsActivity.class);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.d(this.TAG, 1, "onStart");
    if (this.e == null) {}
    iiv localiiv;
    do
    {
      return;
      if (this.jdField_a_of_type_Jko == null) {
        this.jdField_a_of_type_Jko = jko.a(this.mApp);
      }
      this.jdField_a_of_type_Jko.cancelNotification(this.e.sessionId);
      localiiv = igv.a().a();
    } while ((localiiv == null) || (this.e.sessionId.equals(localiiv.sessionId)));
    this.mApp.a(false, null);
    this.jdField_a_of_type_Jko.cL(localiiv.sessionId);
    this.Rq = localiiv.sessionId;
  }
  
  public void onStop()
  {
    super.onStop();
    QLog.d(this.TAG, 1, "onStop");
    if (!super.isFinishing())
    {
      asW();
      this.mApp.a(true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */