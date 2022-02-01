package com.tencent.mobileqq.activity.qwallet;

import aaai;
import aagd;
import aagm;
import aagm.b;
import acfp;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqcl;
import aqge;
import aqgv;
import arkm.a;
import arkm.c;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView.b;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import zxi;
import zxj;
import zys;
import zyt;
import zyv;
import zyw;
import zyx;
import zyy;
import zyz;
import zza;
import zzb;
import zzc;

public class RedPacketKSongFragment
  extends RedPacketPopFragment
  implements aagm.b, KSongMicView.b
{
  public static final String bbs = acfp.m(2131713781);
  public static final String bbt = acfp.m(2131713803);
  public static final String[] dc = { acfp.m(2131713798), acfp.m(2131713790), acfp.m(2131713808) };
  public TextView Ap;
  public long Im;
  TextView Nu;
  public TextView Nv;
  public aagm a;
  public MediaPlayerManager a;
  private a jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$a;
  public KSongMicView a;
  KSongVolumeView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView;
  KSongProsBar jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar;
  public KSongView a;
  public ImageView bU;
  public String bbu = "https://i.gtimg.cn/channel/imglib/201806/upload_8f5d7c5994fc2ceb1e92f11436db039d.zip";
  public String bbv = "https://imgcache.qq.com/channel/static/socialpay/music/song_54.zip";
  public String bbw = "https://imgcache.qq.com/channel/static/socialpay/music/";
  public boolean buA;
  public boolean buB;
  public boolean buC = true;
  public boolean buD;
  private boolean buE;
  private Handler ch;
  public AnimationView d;
  private View.OnClickListener eD = new zys(this);
  private View.OnClickListener eE = new zyv(this);
  public MediaPlayer mMediaPlayer;
  private BroadcastReceiver mReceiver = new zzb(this);
  ImageView vH;
  View yY;
  public View yZ;
  
  private void FI(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.CB(paramInt);
  }
  
  private void cancelLoading()
  {
    this.buA = true;
    this.d.stop();
    this.Nu.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private void csH()
  {
    this.buA = false;
    showLoading();
    csJ();
  }
  
  private void csM()
  {
    if (this.ch != null) {
      this.ch.removeCallbacksAndMessages(null);
    }
  }
  
  private void showLoading()
  {
    this.d.setVisibility(0);
    this.Nu.setVisibility(0);
    int i = new Random().nextInt(3);
    this.Nu.setText(dc[(i + 0)]);
    Object localObject = ((aaai)getActivity().app.getManager(245)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if ((localJSONObject == null) || (localJSONObject.optInt("type") != 7)) {
            continue;
          }
          this.bbw = localJSONObject.optJSONObject("params").optString("prefix", "https://imgcache.qq.com/channel/static/socialpay/music/");
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      ((PreloadManager)getActivity().app.getManager(151)).c(this.bbu, new zzc(this));
      return;
      i += 1;
    }
  }
  
  private void zT(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=18").append("&isOffline=").append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByKSong", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    zxj localzxj = (zxj)getActivity().app.getManager(125);
    zxi localzxi = localzxj.a(this.b.mQQWalletRedPacketMsg.redPacketId);
    localzxj.z(this.b.mQQWalletRedPacketMsg.redPacketId, this.b.frienduin, this.b.istroop);
    localObject = (aaai)getActivity().app.getManager(245);
    int i;
    Bundle localBundle;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((aaai)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localBundle = new Bundle();
      localBundle.putString("feedsid", qc());
      aagm.c(qc(), this.b);
      aagd.e(getActivity().app, this.b);
      localSessionInfo = this.sessionInfo;
      if (i != 1) {
        break label348;
      }
    }
    label348:
    for (localObject = paramString;; localObject = "")
    {
      localzxj.a(localSessionInfo, localzxi, l, 131072, (String)localObject, this.b.mQQWalletRedPacketMsg.elem.skinId, this.b.fromHBList, localBundle);
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
    getActivity().runOnUiThread(new RedPacketKSongFragment.14(this, paramInt));
  }
  
  protected boolean QP()
  {
    if (!super.QP()) {
      return false;
    }
    this.zc.setBackgroundDrawable(getResources().getDrawable(2130848156));
    this.yZ.setOnClickListener(this.eD);
    this.yZ.setOnTouchListener(aagd.a(0.7F));
    this.bU.setOnClickListener(this.eE);
    Object localObject = aqgv.b(getActivity().app, this.b.senderuin, true);
    localObject = aagd.b(getActivity(), (String)localObject, 135.0F, this.Nw.getPaint());
    this.Nw.setText((String)localObject + "的K歌红包");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.setStatusListener(this);
    this.jdField_a_of_type_Aagm = aagm.a();
    this.jdField_a_of_type_Aagm.a(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.mReceiver, (IntentFilter)localObject);
    this.ch = new Handler(ThreadManager.getSubThreadLooper());
    this.bU.setContentDescription(bbs);
    aqcl.R(this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView, false);
    csH();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(getActivity().app);
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.show", 0, 0, "", "", "", "");
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
  
  public void a(String paramString, arkm.c paramc, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "playSong:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (this.mMediaPlayer != null) {
        this.mMediaPlayer.release();
      }
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.prepareAsync();
      this.buE = false;
      this.mMediaPlayer.setOnPreparedListener(new zyy(this, paramBoolean));
      this.mMediaPlayer.setOnCompletionListener(new zyz(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setKListener(new zza(this, paramc));
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void ap(boolean paramBoolean, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.12(this, paramBoolean, paramString));
  }
  
  public void bC(int paramInt, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.13(this, paramInt, paramString));
  }
  
  public void close()
  {
    super.close();
    aagm.a().cug();
  }
  
  public void csD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onPlayBtnClick:" + this.buB + "|" + this.buC);
    }
    try
    {
      if (!this.buB)
      {
        this.buB = true;
        this.bU.setImageDrawable(getResources().getDrawable(2130848182));
        this.Nv.setText(bbt);
        csG();
        this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(0);
        this.Ap.setVisibility(8);
        return;
      }
      if (this.buE) {
        if (this.buC)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.pause();
          this.mMediaPlayer.pause();
          this.buC = false;
          this.bU.setImageDrawable(getResources().getDrawable(2130848180));
          this.Nv.setText(bbs);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RedPacketKSongFragment", 2, "onPlayBtnClick throwable:" + localThrowable.getMessage());
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.hk(true);
        this.mMediaPlayer.start();
        this.buC = true;
        this.bU.setImageDrawable(getResources().getDrawable(2130848182));
        this.Nv.setText(bbt);
      }
    }
  }
  
  public void csE()
  {
    this.bU.setImageDrawable(getResources().getDrawable(2130848180));
    this.bU.setVisibility(0);
    this.Nv.setVisibility(0);
    this.Nv.setText(bbs);
    this.buB = false;
    this.buC = true;
  }
  
  public void csF()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$a.bbz, new zyw(this), false);
  }
  
  public void csG()
  {
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.play", 0, 0, "", "", "", "");
    this.bU.setImageDrawable(getResources().getDrawable(2130848182));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$a.bby, new zyx(this), true);
  }
  
  public void csI()
  {
    this.Ap.setVisibility(0);
    this.Ap.setText(acfp.m(2131713813));
    this.yZ.setVisibility(0);
  }
  
  public void csJ()
  {
    this.bbv = (this.bbw + "song_" + this.b.mQQWalletRedPacketMsg.elem.songId + ".zip");
    ((PreloadManager)getActivity().app.getManager(151)).c(this.bbv, new zyt(this));
  }
  
  public void csK()
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.11(this));
  }
  
  public void csL()
  {
    this.yY.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.setVisibility(0);
    this.bU.setVisibility(0);
    this.Nv.setVisibility(0);
  }
  
  public void csN()
  {
    csF();
  }
  
  public void csO()
  {
    this.buD = false;
    csP();
  }
  
  public void csP()
  {
    this.ch.removeCallbacksAndMessages(null);
    this.ch.postDelayed(new RedPacketKSongFragment.15(this), 20000L);
  }
  
  protected void initUI(View paramView)
  {
    super.initUI(paramView);
    ((ViewStub)paramView.findViewById(2131378885)).inflate();
    this.Ap = ((TextView)paramView.findViewById(2131379754));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView = ((KSongMicView)paramView.findViewById(2131376953));
    this.d = ((AnimationView)paramView.findViewById(2131370104));
    this.Nu = ((TextView)paramView.findViewById(2131370817));
    this.yY = paramView.findViewById(2131370956);
    this.bU = ((ImageView)paramView.findViewById(2131373378));
    this.Nv = ((TextView)paramView.findViewById(2131373400));
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView = ((KSongView)paramView.findViewById(2131370106));
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar = ((KSongProsBar)paramView.findViewById(2131370105));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView = ((KSongVolumeView)paramView.findViewById(2131369146));
    this.yZ = paramView.findViewById(2131377228);
    this.vH = ((ImageView)paramView.findViewById(2131370103));
    u(this.vH);
  }
  
  public boolean isFinish()
  {
    return super.isFinish();
  }
  
  public boolean onBackEvent()
  {
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.close", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onBegin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onBegin() is called");
    }
  }
  
  public void onCancel() {}
  
  public void onDestroy()
  {
    super.onDestroy();
    aqge.m(getActivity(), false);
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.cuf();
    }
    cancelLoading();
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.release();
    AnimationView.AnimationInfo localAnimationInfo = this.d.getAnimationFromInfo();
    if (localAnimationInfo != null) {
      localAnimationInfo.destoryBitmaps();
    }
    try
    {
      getActivity().unregisterReceiver(this.mReceiver);
      label79:
      csM();
      v(this.vH);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
  }
  
  public void onEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onEnd() is called");
    }
    if (AudioHelper.isForbidByRubbishMeizu(1)) {
      ChatActivityUtils.db(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(0);
    this.Ap.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(0);
    this.bU.setVisibility(8);
    this.Nv.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.reset();
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.release();
    }
    if ((this.jdField_a_of_type_Aagm != null) && (this.b != null))
    {
      this.jdField_a_of_type_Aagm.Al(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$a.bbz);
      this.jdField_a_of_type_Aagm.a(this.sessionInfo, this.b, "", false);
      this.buD = true;
    }
    anot.a(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.start", 0, 0, "", "", "", "");
  }
  
  public void onError(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
    csE();
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.reset();
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(8);
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.release();
    }
    setTips(paramString);
    this.jdField_a_of_type_Aagm.cuf();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.reset();
    this.buD = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onPause() is called :" + this.buD);
    }
    if (this.buD) {
      onError(acfp.m(2131713794));
    }
  }
  
  public String qc()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a().cAG;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public void setTips(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(8);
    this.Ap.setVisibility(0);
    this.Ap.setText(paramString);
  }
  
  public int yu()
  {
    return 30000;
  }
  
  public static class a
  {
    public String bbA;
    public String bbB;
    public String bby;
    public String bbz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment
 * JD-Core Version:    0.7.0.1
 */