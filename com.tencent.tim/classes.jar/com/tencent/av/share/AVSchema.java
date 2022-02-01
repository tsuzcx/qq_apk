package com.tencent.av.share;

import acfp;
import acms;
import acnd;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import apuh;
import aqha;
import aqju;
import ayxa;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import ijl;
import ijl.b;
import iuu;
import iuv;
import iuw;
import iux;
import iuy;
import iuz;
import iva;
import jjk.b;
import mqq.os.MqqHandler;
import wja;

public class AVSchema
  extends PublicBaseFragment
{
  public final String TAG = "AVSchema." + AudioHelper.hG();
  boolean Vj = false;
  boolean Vk = false;
  a jdField_a_of_type_ComTencentAvShareAVSchema$a = new a();
  c jdField_a_of_type_ComTencentAvShareAVSchema$c = new c(null);
  QQAppInterface b;
  Runnable by = null;
  public aqju m = null;
  Handler mHandler;
  
  public AVSchema()
  {
    QLog.w(this.TAG, 1, "AVSchema");
  }
  
  static a a(Bundle paramBundle)
  {
    a locala = new a();
    locala.guid = paramBundle.getString("guid");
    return locala;
  }
  
  static boolean a(a parama1, a parama2)
  {
    if (parama1 == null) {}
    while (parama2 == null) {
      return false;
    }
    return TextUtils.equals(parama1.guid, parama2.guid);
  }
  
  aqju a()
  {
    aqL();
    this.m = aqha.a(getActivity(), 230);
    this.m.setCancelable(true);
    this.m.setOnDismissListener(new iuw(this));
    return this.m;
  }
  
  void a(long paramLong, a parama)
  {
    QLog.w(this.TAG, 1, "cancelLastRequest, info[" + parama + "], seq[" + paramLong + "]");
  }
  
  void aqL()
  {
    aqju localaqju = this.m;
    this.m = null;
    if (localaqju != null) {}
    try
    {
      localaqju.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void b(long paramLong, a parama)
  {
    ReqGroupVideo.ReqShareBackflowVerify localReqShareBackflowVerify = new ReqGroupVideo.ReqShareBackflowVerify();
    localReqShareBackflowVerify.uint64_uin.set(getApp().getLongAccountUin());
    localReqShareBackflowVerify.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(parama.guid));
    b localb = new b(parama);
    ijl.a(paramLong, getApp(), "QQRTCSvc.group_video_share_backflow_verify", localReqShareBackflowVerify, localb);
    QLog.w(this.TAG, 1, "realyRequest, info[" + parama + "], seq[" + paramLong + "]");
  }
  
  void b(aqju paramaqju)
  {
    paramaqju.setNegativeButton(acfp.m(2131703011), new iux(this));
  }
  
  void c(aqju paramaqju)
  {
    paramaqju.setNegativeButton(acfp.m(2131703010), new iuy(this));
  }
  
  public void finish()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    QLog.w(this.TAG, 1, "finish", new Throwable("打印调用栈"));
  }
  
  void g(long paramLong, String paramString1, String paramString2)
  {
    aqju localaqju = a();
    localaqju.setMessage(paramString1);
    c(localaqju);
    localaqju.setPositiveButton(acfp.m(2131703013), new iuu(this, paramString2));
    localaqju.show();
    QLog.w(this.TAG, 1, "handleResult_ROOM_CLOSE, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  public boolean g(String paramString, long paramLong)
  {
    if (isDetached())
    {
      QLog.w(this.TAG, 1, paramString + ", isDetached, seq[" + paramLong + "]");
      return true;
    }
    if (getActivity() == null)
    {
      QLog.w(this.TAG, 1, paramString + ", !Activity, seq[" + paramLong + "]");
      return true;
    }
    return false;
  }
  
  QQAppInterface getApp()
  {
    if ((this.b == null) && ((getActivity().getAppInterface() instanceof QQAppInterface))) {
      this.b = ((QQAppInterface)getActivity().getAppInterface());
    }
    return this.b;
  }
  
  void h(long paramLong, String paramString1, String paramString2)
  {
    aqju localaqju = a();
    localaqju.setMessage(paramString1);
    c(localaqju);
    localaqju.setPositiveButton(acfp.m(2131703014), new iuv(this, paramString2));
    localaqju.show();
    QLog.w(this.TAG, 1, "handleResult_NEED_ADMIN_CONFIRM, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  public void jF(String paramString)
  {
    QLog.w(this.TAG, 1, "gotoAIO, groupUin[" + paramString + "], mHadGotoAIO[" + this.Vj + "]");
    if (this.Vj) {
      return;
    }
    Intent localIntent = wja.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(localIntent);
    this.Vj = true;
  }
  
  public void jG(String paramString)
  {
    paramString = TroopInfoActivity.c(paramString, 14);
    apuh.a(getActivity(), paramString, 2);
  }
  
  void jH(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvShareAVSchema$c.QD = paramString;
    acms localacms = (acms)getApp().getBusinessHandler(20);
    localacms.bJ(paramString, false);
    localacms.cMF();
  }
  
  void jb(boolean paramBoolean)
  {
    if (getActivity() == null) {}
    do
    {
      View localView1;
      do
      {
        return;
        localView1 = getActivity().findViewById(2131363555);
      } while (localView1 == null);
      View localView2 = (View)localView1.getParent();
      if (paramBoolean)
      {
        localView1.setVisibility(0);
        localView2.setBackgroundColor(-271725107);
        ((TextView)localView2.findViewById(2131371994)).setText(2131696693);
        return;
      }
      localView1.setVisibility(4);
      localView2.setBackgroundColor(16777216);
    } while ((this.mHandler == null) || (this.by == null));
    this.mHandler.removeCallbacks(this.by);
    this.by = null;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    long l = AudioHelper.hG();
    AudioHelper.I(this.TAG + ".onActivityCreated_seq[" + l + "]", paramBundle);
    QLog.w(this.TAG, 1, "onActivityCreated, seq[" + l + "]");
    request(l);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.w(this.TAG, 1, "onAttach, activity[" + paramActivity + "]");
    ayxa.initLiuHaiProperty(paramActivity);
    getApp().addObserver(this.jdField_a_of_type_ComTencentAvShareAVSchema$c);
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561627, paramViewGroup, false);
    paramLayoutInflater.getLayoutParams().height = -1;
    int i = ayxa.getNotchInScreenHeight(getActivity());
    paramViewGroup = paramLayoutInflater.findViewById(2131363555);
    ((FrameLayout.LayoutParams)paramViewGroup.getLayoutParams()).topMargin = i;
    paramViewGroup.setVisibility(4);
    ((View)paramViewGroup.getParent()).setBackgroundColor(16777216);
    QLog.w(this.TAG, 1, "onCreateView, view[" + paramLayoutInflater + "], status_bar_height[" + i + "]");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isDevelopLevel()) {}
    for (Throwable localThrowable = new Throwable("打印调用栈");; localThrowable = null)
    {
      QLog.w(this.TAG, 1, "onDetach", localThrowable);
      this.jdField_a_of_type_ComTencentAvShareAVSchema$c.QD = "";
      getApp().removeObserver(this.jdField_a_of_type_ComTencentAvShareAVSchema$c);
      if (this.mHandler != null)
      {
        if (this.by != null)
        {
          this.mHandler.removeCallbacks(this.by);
          this.by = null;
        }
        this.mHandler = null;
      }
      aqL();
      return;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l = AudioHelper.hG();
    AudioHelper.g(this.TAG + ".onNewIntent_seq[" + l + "]", paramIntent);
    request(l);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.w(this.TAG, 1, "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onResume, seq[" + l + "], mQQCustomDialog[" + this.m + "]");
    request(l);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.w(this.TAG, 1, "onViewCreated, view[" + paramView + "]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    QLog.w(this.TAG, 1, "onWindowFocusChanged, hasFocus[" + paramBoolean + "]");
  }
  
  void request(long paramLong)
  {
    Object localObject = getArguments();
    AudioHelper.I(this.TAG + ".request_seq[" + paramLong + "]", (Bundle)localObject);
    localObject = a((Bundle)localObject);
    boolean bool = a(this.jdField_a_of_type_ComTencentAvShareAVSchema$a, (a)localObject);
    QLog.w(this.TAG, 1, "request, isSameInfo[" + bool + "], mInfo[" + this.jdField_a_of_type_ComTencentAvShareAVSchema$a + "], seq[" + paramLong + "]");
    if (bool) {}
    do
    {
      return;
      if ((this.mHandler != null) && (this.by == null))
      {
        this.by = new AVSchema.1(this);
        this.mHandler.postDelayed(this.by, 1000L);
      }
      a(paramLong, this.jdField_a_of_type_ComTencentAvShareAVSchema$a);
      this.jdField_a_of_type_ComTencentAvShareAVSchema$a = ((a)localObject);
    } while (this.jdField_a_of_type_ComTencentAvShareAVSchema$a == null);
    b(paramLong, this.jdField_a_of_type_ComTencentAvShareAVSchema$a);
  }
  
  void s(long paramLong, String paramString)
  {
    aqju localaqju = a();
    localaqju.setMessage(paramString);
    b(localaqju);
    localaqju.show();
    QLog.w(this.TAG, 1, "handleResult_I_Known, msg[" + paramString + "], seq[" + paramLong + "]");
    new MqqHandler(Looper.getMainLooper()).postDelayed(new AVSchema.4(this, paramLong), 100L);
  }
  
  public void t(long paramLong, String paramString)
  {
    if (this.Vk) {
      return;
    }
    jjk.b.axe();
    boolean bool = AVNotifyCenter.ul();
    QLog.w(this.TAG, 1, "joinVideoChat, groupUin[" + paramString + "], isBeInvitingOnDoubleVideo[" + bool + "], seq[" + paramLong + "]");
    if (bool)
    {
      QQToast.a(getActivity(), 2131698108, 1).show(getActivity().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    this.Vk = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("MultiAVType", 10);
    AudioHelper.rw(this.TAG + ".joinVideoChat");
    ChatActivityUtils.a(getApp(), getApp().getApp(), 1, paramString, true, true, new iuz(this, paramLong), localBundle);
  }
  
  static class a
  {
    int atR = 99;
    String groupName = null;
    String guid = null;
    
    public String toString()
    {
      return this.guid;
    }
  }
  
  class b
    extends ijl.b<ReqGroupVideo.ReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify>
  {
    AVSchema.a b;
    
    b(AVSchema.a parama)
    {
      this.b = parama;
    }
    
    public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqShareBackflowVerify paramReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, Object paramObject)
    {
      if (AVSchema.this.isDetached()) {
        return;
      }
      new Handler(Looper.getMainLooper()).post(new AVSchema.MyMsgListener.1(this, paramRspShareBackflowVerify, paramLong));
    }
  }
  
  public class c
    extends acnd
  {
    public String QD;
    
    private c() {}
    
    public void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
    {
      long l = AudioHelper.hG();
      if (AVSchema.this.g("onGetSimpleTroopInfoResult", l)) {}
      do
      {
        do
        {
          do
          {
            return;
          } while (paramTroopInfo == null);
          paramString = paramTroopInfo.troopuin;
        } while ((TextUtils.isEmpty(this.QD)) || (!TextUtils.equals(this.QD, paramString)));
        QLog.w(AVSchema.this.TAG, 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "], enum_verify_status[" + AVSchema.this.a.atR + "], seq[" + l + "]");
        AVSchema.this.a.groupName = paramTroopInfo.troopname;
      } while (AVSchema.this.a.atR != 0);
      if (ChatActivityUtils.a(AVSchema.this.getActivity(), true, new iva(this, l)))
      {
        AVSchema.this.t(l, this.QD);
        return;
      }
      QLog.w(AVSchema.this.TAG, 1, "onGetSimpleTroopInfoResult, 等权限确认, seq[" + l + "]");
    }
    
    public void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(AVSchema.this.TAG, 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.AVSchema
 * JD-Core Version:    0.7.0.1
 */