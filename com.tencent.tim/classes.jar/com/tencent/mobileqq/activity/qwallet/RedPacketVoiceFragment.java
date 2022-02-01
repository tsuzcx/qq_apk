package com.tencent.mobileqq.activity.qwallet;

import aaai;
import aafy;
import aagd;
import aagm;
import aagm.b;
import acfp;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqgv;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import zxi;
import zxj;
import zzg;

public class RedPacketVoiceFragment
  extends RedPacketPopFragment
  implements aagm.b, RecordMicView.b
{
  TextView Ap;
  public long Im;
  TextView Nx;
  TextView Ny;
  aagm jdField_a_of_type_Aagm;
  RecordMicView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView;
  private Bundle an;
  private int bQi;
  private String bbC;
  private boolean buI;
  private Handler ch;
  private VolumeIndicateSquareView d;
  private VolumeIndicateSquareView e;
  LinearLayout hR;
  ImageView vI;
  
  private void FI(int paramInt)
  {
    paramInt /= 1180;
    this.d.CB(paramInt);
    this.e.CB(paramInt);
  }
  
  private void aAK()
  {
    this.d.reset();
    this.e.reset();
  }
  
  private void csR()
  {
    if (!isFinish()) {}
    for (QQAppInterface localQQAppInterface = getActivity().app;; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ThreadManager.post(new RedPacketVoiceFragment.2(this, new WeakReference(localQQAppInterface)), 5, null, true);
      }
      return;
    }
  }
  
  private boolean isOffline()
  {
    if (((aaai)getActivity().app.getManager(245)).a("voice_pwd", 0, new String[] { "offline" }) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketVoiceFragment", 2, "get isOffLine fromConfig:" + bool);
      }
      return bool;
    }
  }
  
  private void zT(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=13").append("&isOffline=").append(this.buI);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByVoice", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    zxj localzxj = (zxj)getActivity().app.getManager(125);
    zxi localzxi = localzxj.a(this.b.mQQWalletRedPacketMsg.redPacketId);
    localzxj.z(this.b.mQQWalletRedPacketMsg.redPacketId, this.b.frienduin, this.b.istroop);
    localObject = (aaai)getActivity().app.getManager(245);
    int i;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((aaai)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localSessionInfo = this.sessionInfo;
      if (i != 1) {
        break label304;
      }
    }
    label304:
    for (localObject = paramString;; localObject = "")
    {
      localzxj.a(localSessionInfo, localzxi, l, 65536, (String)localObject, this.b.mQQWalletRedPacketMsg.elem.skinId, this.b.fromHBList, null);
      aagd.e(getActivity().app, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localzxi.isOpen + ",isPasswdRedBagFinish=" + localzxi.isFinish + ",isPasswdRedBagOverDue=" + localzxi.bul + "|scoreSwitch:" + i + "|scoreId" + paramString);
      }
      return;
      i = 1;
      break;
    }
  }
  
  public void FH(int paramInt)
  {
    getActivity().runOnUiThread(new RedPacketVoiceFragment.5(this, paramInt));
  }
  
  protected boolean QP()
  {
    if (!super.QP()) {
      return false;
    }
    this.zc.setBackgroundDrawable(getResources().getDrawable(2130844216));
    String str = aqgv.b(getActivity().app, this.b.senderuin, true);
    str = aagd.b(getActivity(), str, 135.0F, this.Nw.getPaint());
    this.Nw.setText(str + acfp.m(2131713792));
    this.Nx.setText("“" + this.b.mQQWalletRedPacketMsg.elem.title + "”");
    this.Ap.setText(getResources().getString(2131697517));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setStatusListener(this);
    this.jdField_a_of_type_Aagm = aagm.a();
    this.jdField_a_of_type_Aagm.a(this);
    this.buI = isOffline();
    this.bQi = (this.b.mQQWalletRedPacketMsg.elem.soundRecordDuration * 1000);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setRecordTime(this.bQi);
    if (this.b.isSend())
    {
      this.Ny.setVisibility(0);
      this.an = ((Bundle)getArguments().getParcelable("detail_bundle"));
      this.Ny.setOnClickListener(new zzg(this));
    }
    aafy.a().init();
    csR();
    this.ch = new Handler(ThreadManager.getSubThreadLooper());
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public boolean VY()
  {
    if (this.Im == 0L) {
      this.Im = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.Im >= 75L)
    {
      this.Im = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public void ap(boolean paramBoolean, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketVoiceFragment.3(this, paramBoolean, paramString));
  }
  
  public void bC(int paramInt, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketVoiceFragment.4(this, paramInt, paramString));
  }
  
  public void close()
  {
    super.close();
    aagm.a().cug();
  }
  
  public void csN() {}
  
  public void csO() {}
  
  public void csP()
  {
    this.ch.removeCallbacksAndMessages(null);
    this.ch.postDelayed(new RedPacketVoiceFragment.6(this), 20000L);
  }
  
  public void csS()
  {
    onError(getResources().getString(2131697518));
  }
  
  protected void initUI(View paramView)
  {
    super.initUI(paramView);
    ((ViewStub)paramView.findViewById(2131378892)).inflate();
    this.Nx = ((TextView)paramView.findViewById(2131373876));
    this.Ap = ((TextView)paramView.findViewById(2131379754));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView = ((RecordMicView)paramView.findViewById(2131376953));
    this.vI = ((ImageView)paramView.findViewById(2131382058));
    u(this.vI);
    this.hR = ((LinearLayout)paramView.findViewById(2131382072));
    this.d = ((VolumeIndicateSquareView)paramView.findViewById(2131369147));
    this.e = ((VolumeIndicateSquareView)paramView.findViewById(2131369148));
    this.Ny = ((TextView)paramView.findViewById(2131368333));
  }
  
  public boolean isFinish()
  {
    return super.isFinish();
  }
  
  public boolean onBackEvent()
  {
    if (this.buH) {
      anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.keyback", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return super.onBackEvent();
      anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.back", 0, 0, "", "", "", "");
    }
  }
  
  public void onBegin()
  {
    this.Ap.setText(getResources().getString(2131697519));
    this.hR.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketVoiceFragment", 2, "onBegin() is called");
    }
    if (AudioHelper.isForbidByRubbishMeizu(1)) {
      ChatActivityUtils.db(getActivity());
    }
    this.buI = isOffline();
    if (TextUtils.isEmpty(this.bbC)) {}
    try
    {
      this.bbC = aafy.a().jdMethod_if(this.b.mQQWalletRedPacketMsg.elem.title);
      if ((this.jdField_a_of_type_Aagm != null) && (this.b != null)) {
        this.jdField_a_of_type_Aagm.a(this.sessionInfo, this.b, this.bbC, this.buI);
      }
      anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.start", 0, 0, "", "", "", "");
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
  
  public void onCancel()
  {
    onError(getResources().getString(2131697517));
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.cancel", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ch != null) {
      this.ch.removeCallbacksAndMessages(null);
    }
    v(this.vI);
  }
  
  public void onEnd()
  {
    this.Ap.setText(getResources().getString(2131697520));
    this.hR.setVisibility(8);
    aAK();
    csP();
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.stopRecord();
    }
  }
  
  public void onError(String paramString)
  {
    this.Ap.setText(paramString);
    this.hR.setVisibility(8);
    aAK();
    this.jdField_a_of_type_Aagm.cuf();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.reset();
  }
  
  public int yu()
  {
    return 30000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment
 * JD-Core Version:    0.7.0.1
 */