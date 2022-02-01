package com.tencent.mobileqq.activity.bless;

import aaqi;
import aaza;
import aaza.c;
import aaza.d;
import acff;
import achq;
import akws;
import akxj;
import akxq;
import akxy.a;
import anbb;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import anff;
import anfr;
import angi;
import angt;
import anot;
import aojn;
import aojv;
import aonu;
import aooh.a;
import aooi;
import aqgo;
import aqha;
import aqhq;
import aqoi;
import aurf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import ujt;
import ylm;
import ylo;
import ylt;
import ylu;
import ylv;
import ylw;
import ylx;
import yly;
import ylz;
import yma;
import ymb;
import ymc;

public class BlessSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  private static long Kj = 60000L;
  private static long Kk = 60000L;
  private static long Kl;
  private static long Km;
  private static long Kn;
  public static String aYT = "";
  public static String aYU = "";
  private static AtomicBoolean bO = new AtomicBoolean(false);
  private static AtomicBoolean bP = new AtomicBoolean(false);
  private static boolean bnt;
  private static aurf d;
  private static int resultCode = 1;
  private long Ko;
  private b a;
  private String aYV;
  private String aYW;
  private String aYX;
  private String aYY;
  private aaza.c b = new ylv(this);
  private String bN;
  private int bZO = 0;
  private int baS;
  public boolean bns;
  private Dialog dialog;
  private achq e = new ylt(this);
  private int encodetype;
  private MessageForPic f;
  private String fakeId;
  private BroadcastReceiver mReceiver = new ylu(this);
  protected ArrayList<String> uinList;
  public Dialog v;
  
  public static void aa(Context paramContext, int paramInt)
  {
    aqha.a(paramContext, 232, null, paramContext.getString(paramInt), 2131721058, 2131695172, new ymb(paramContext), new ymc()).show();
  }
  
  private void cjA()
  {
    boolean bool = true;
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_Ylm.a();
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      this.bns = true;
      if (this.eK == 15)
      {
        if (this.uinList.size() <= 10) {
          localMessageForBlessPTV.needUpdateMsgTag = bool;
        }
      }
      else {
        this.app.b().a(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, this.jdField_a_of_type_Ylm.a(2, localMessageForBlessPTV.videoFileTime));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    QLog.i("BlessSelectMemberActivity", 2, "error case no ptv message in manager");
  }
  
  private void cjB()
  {
    boolean bool = true;
    if ((this.f != null) && (this.uinList != null) && (this.uinList.size() > 0))
    {
      this.bns = true;
      if (this.eK == 15)
      {
        localMessageForPic = this.f;
        if (this.uinList.size() <= 10) {
          localMessageForPic.needUpdateMsgTag = bool;
        }
      }
      else
      {
        this.app.b().a(this.app, this.f, this.uinList, this.jdField_a_of_type_Ylm.a(3, 0));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        MessageForPic localMessageForPic;
        return;
        bool = false;
      }
    }
    QLog.i("BlessSelectMemberActivity", 2, "sendBlessPic failed!" + this.f + " ,uinList:" + this.uinList);
  }
  
  private void cjC()
  {
    if (this.baS == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      this.baS = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cjx()
  {
    Object localObject = new aaza.d(this.bN, this.aYX, null, 0, 0);
    String str = this.fakeId;
    if (this.encodetype == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aaza(this, str, bool, (aaza.d)localObject);
      ((aaza)localObject).b(this.b);
      ((aaza)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
      return;
    }
  }
  
  public static void d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    aqha.a(paramContext, 232, null, paramContext.getString(paramInt), new yma(paramBoolean, paramContext), null).show();
  }
  
  public static int fs(int paramInt)
  {
    int i = 0;
    if ((paramInt == 15) || (paramInt == 16)) {
      i = 1;
    }
    while (paramInt != 32) {
      return i;
    }
    return 2;
  }
  
  private void yQ(String paramString)
  {
    if (!Ub())
    {
      go();
      return;
    }
    if (!paramString.equals(""))
    {
      this.bns = true;
      ujt.a(this.app, paramString, this.uinList, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    go();
  }
  
  public void Ak(boolean paramBoolean)
  {
    int i = (int)((System.currentTimeMillis() - this.Ko) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb result:" + paramBoolean + " ,type:" + this.bZO + " ,cost:" + i);
    }
    if (paramBoolean)
    {
      go();
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.BlessJsApiPlugin");
      localIntent.putExtra("callback", this.aYW);
      localIntent.putExtra("bless_type", this.bZO);
      localIntent.putExtra("bless_num", this.uinList.size());
      if ((this.bZO == 1) && (!TextUtils.isEmpty(this.aYV))) {
        anot.a(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.bZO), String.valueOf(this.uinList.size()), "", "");
      }
      for (;;)
      {
        sendBroadcast(localIntent);
        finish();
        return;
        if ((this.bZO == 2) || (this.bZO == 3))
        {
          Object localObject = new Intent("tencent.video.q2v.startUploadPTV");
          ((Intent)localObject).putExtra("broadcastType", 1);
          ((Intent)localObject).putExtra("recordType", this.bZO);
          this.app.getApp().sendBroadcast((Intent)localObject);
          if ((this.bZO == 2) && (this.jdField_a_of_type_Ylm.a() != null))
          {
            localObject = this.jdField_a_of_type_Ylm.ay(this.jdField_a_of_type_Ylm.a().uuid, this.jdField_a_of_type_Ylm.a().md5);
            localIntent.putExtra("bless_ptv_url", (String)localObject);
            localIntent.putExtra("bless_ptv_uuid", this.jdField_a_of_type_Ylm.a().uuid);
            localIntent.putExtra("bless_ptv_md5", this.jdField_a_of_type_Ylm.a().md5);
            localIntent.putExtra("bless_ptv_nick", aqgo.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
            localIntent.putExtra("ptv_file_path", this.jdField_a_of_type_Ylm.a().videoFileName);
            localIntent.putExtra("ptv_thumb_path", this.jdField_a_of_type_Ylm.a().mThumbFilePath);
            if (QLog.isColorLevel()) {
              QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb ptvurl:" + (String)localObject);
            }
          }
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.bZO);
  }
  
  public void Al(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.bZO);
    this.app.getApp().sendBroadcast(localIntent);
    this.jdField_a_of_type_Ylm.t(this.uinList, fs(this.eK));
    if (this.eK == 32)
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra(anbb.ccQ, paramBoolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      QQToast.a(this, 2, 2131721829, 1).show();
      return;
    }
    localIntent = new Intent(this, BlessResultActivity.class);
    localIntent.putExtra("param_method", this.bZO);
    localIntent.putExtra("param_count", this.uinList.size());
    if ((this.bZO == 2) && (this.jdField_a_of_type_Ylm.a() != null))
    {
      localIntent.putExtra("param_snap_path", this.jdField_a_of_type_Ylm.a().mThumbFilePath);
      localIntent.putExtra("param_ptv_path", this.jdField_a_of_type_Ylm.a().videoFileName);
      localIntent.putExtra("param_ptv_uuid", this.jdField_a_of_type_Ylm.a().uuid);
      localIntent.putExtra("param_ptv_md5", this.jdField_a_of_type_Ylm.a().md5);
      localIntent.putExtra(anbb.ccQ, paramBoolean);
    }
    startActivity(localIntent);
    finish();
  }
  
  public boolean Ub()
  {
    if (Kl > 0L)
    {
      long l = System.currentTimeMillis() - Km;
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "send text overload=" + l / 1000L + " duration=" + Kl);
      }
      if (l > Kl * 1000L)
      {
        gp(0L);
        Km = 0L;
      }
    }
    else
    {
      return true;
    }
    d(this, 2131690921, true);
    return false;
  }
  
  public void aC()
  {
    super.aC();
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165418));
    this.mTitle.setTextColor(-1);
    this.Bi.setTextColor(getResources().getColorStateList(2131165412));
    this.mRightBtn.setTextColor(getResources().getColorStateList(2131165412));
  }
  
  public void be(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = (int)((System.currentTimeMillis() - this.Ko) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResult result:" + paramBoolean1 + " ,type:" + this.bZO + " ,cost:" + i);
    }
    if (paramBoolean1)
    {
      go();
      if ((this.bZO == 1) && (!this.aYV.equals("")))
      {
        this.jdField_a_of_type_Ylm.yO(this.aYV);
        this.jdField_a_of_type_Ylm.cji();
        Al(paramBoolean2);
        anot.a(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.bZO), String.valueOf(this.uinList.size()), "", "");
      }
      for (;;)
      {
        Properties localProperties = new Properties();
        localProperties.setProperty("bless_param_type", "" + this.bZO);
        localProperties.setProperty("bless_param_entrance_type", "" + this.eK);
        localProperties.setProperty("bless_param_uinlist_size", "" + this.uinList.size());
        if (Kn > 0L) {
          localProperties.setProperty("bless_param_wait_time", "" + Kn);
        }
        ylo.b("bless_event_send_result", localProperties, i);
        return;
        if ((this.bZO == 2) || (this.bZO == 3)) {
          Al(paramBoolean2);
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.bZO);
  }
  
  public void cjw()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    if ((this.eK == 15) || (this.eK == 32))
    {
      this.uinList.clear();
      if (this.aQ.size() > 0)
      {
        Iterator localIterator = this.aQ.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          this.uinList.add(localResultRecord.uin);
        }
      }
      ii();
      return;
    }
    this.mIntent.putParcelableArrayListExtra("result_set", this.aQ);
    setResult(-1, this.mIntent);
    finish();
  }
  
  protected void cjy()
  {
    Object localObject = ((ylm)getAppInterface().getManager(138)).a();
    boolean bool;
    if (localObject != null)
    {
      aqoi localaqoi = this.app.a().a(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localaqoi != null) && (aonu.class.isInstance(localaqoi)))
      {
        bool = ((aojn)localaqoi).isPause();
        int i = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001)) {
          this.app.a().B(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.f != null)
    {
      localObject = this.app.a().a(this.f.frienduin, this.f.uniseq);
      if ((localObject != null) && (aojv.class.isInstance(localObject)))
      {
        bool = ((aojn)localObject).isPause();
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + bool);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.cancel(true);
    }
  }
  
  public void cjz()
  {
    sq(null);
    bnt = false;
    this.jdField_a_of_type_Ylm.gF(this.uinList);
    this.Ko = System.currentTimeMillis();
    d.sendEmptyMessageDelayed(2, Kk);
    if (this.bZO == 1) {
      yQ(this.aYV);
    }
    do
    {
      do
      {
        return;
        if (this.bZO != 2) {
          break;
        }
        if (!Ub())
        {
          go();
          return;
        }
        new a(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.getStatus() != AsyncTask.Status.FINISHED))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.cancel(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b = new b(this.app, this, this.uinList, this.eK);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } while (getIntent().getIntExtra("param_key_redbag_type", 0) != LocalMediaInfo.REDBAG_TYPE_GET);
      aaqi.e("", "0X80088E4", this.uinList.size(), "3");
      return;
    } while (this.bZO != 3);
    if (TextUtils.isEmpty(this.bN))
    {
      QQToast.a(this, 1, 2131701267, 1).show();
      go();
      finish();
      return;
    }
    mw(this.bN);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.bZO = this.mIntent.getExtras().getInt("param_blesstype");
    this.aYV = this.mIntent.getExtras().getString("param_blessword_content");
    this.encodetype = this.mIntent.getIntExtra("encode_type", 0);
    this.fakeId = this.mIntent.getStringExtra("fake_id");
    this.bN = this.mIntent.getStringExtra("thumbfile_send_path");
    this.aYX = this.mIntent.getStringExtra("thumbfile_md5");
    this.aYW = this.mIntent.getStringExtra("param_web_callback");
    addObserver(this.e);
    cjC();
    this.uinList = new ArrayList();
    bO.set(false);
    resultCode = 1;
    aYT = "";
    bnt = false;
    this.ZM = false;
    d = new aurf(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.e);
    if (d != null) {
      d.removeMessages(2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$b.cancel(true);
    }
    try
    {
      if (this.baS == 1)
      {
        unregisterReceiver(this.mReceiver);
        this.baS = 0;
      }
      this.f = null;
      Kn = 0L;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    XG();
    ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).notifyDataSetChanged();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131165418);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.eK == 15) || (this.eK == 32)) {
      this.jdField_a_of_type_Ylm.cjh();
    }
  }
  
  public void go()
  {
    try
    {
      if (this.v != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog");
        }
        this.v.dismiss();
      }
      if (d != null) {
        d.removeMessages(2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public void gp(long paramLong)
  {
    long l = 300L;
    if (paramLong > 300L) {
      paramLong = l;
    }
    for (;;)
    {
      l = paramLong;
      if (paramLong <= 0L) {
        l = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "setSendMsgOverloadDuration: " + l);
      }
      Kl = l;
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send video cannel!");
      }
      cjy();
      bnt = true;
      go();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
      }
      cjy();
      bnt = true;
      go();
      aa(this, 2131720280);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
      }
      cjx();
    }
  }
  
  protected void ii()
  {
    anot.a(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.bZO), "", "", "");
    if ((this.aYY == null) || (this.dialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.eK == 15) {
        localStringBuilder.append(getString(2131690917));
      }
      for (;;)
      {
        localObject = (acff)this.app.getManager(51);
        int i = 0;
        while ((i < this.uinList.size()) && (i < 50))
        {
          Friends localFriends = ((acff)localObject).e((String)this.uinList.get(i));
          if (localFriends != null) {
            localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
          }
          i += 1;
        }
        if (this.eK == 32) {
          localStringBuilder.append(getString(2131721828));
        }
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.uinList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131690918), new Object[] { "", Integer.valueOf(this.uinList.size()) }));
      }
      this.aYY = localStringBuilder.toString();
      this.dialog = aqha.a(this, -1, null, this.aYY, 2131721058, 2131690915, new ylw(this), new ylx(this));
      if (this.bZO == 2)
      {
        localObject = this.dialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.dialog.findViewById(2131365863);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.dialog.show();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void mw(String paramString)
  {
    Object localObject = new akxy.a();
    ((akxy.a)localObject).setLocalPath(paramString);
    ((akxy.a)localObject).So(1006);
    ((akxy.a)localObject).setProtocolType(aooh.a.dQC);
    ((akxy.a)localObject).NP("0");
    ((akxy.a)localObject).kc(this.app.getCurrentAccountUin());
    ((akxy.a)localObject).Sp(0);
    paramString = ((akxy.a)localObject).a();
    paramString.isBlessPic = true;
    paramString.cuY = false;
    this.f = ((MessageForPic)new akws(this.app).a(paramString));
    if (this.f != null) {
      this.f.isBlessPic = true;
    }
    paramString.message = this.f;
    localObject = akxj.a(2, 1006);
    ((akxq)localObject).c(paramString);
    akxj.a((akxq)localObject, this.app);
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Ylm.TY())
    {
      this.jdField_a_of_type_Ylm.Ai(false);
      Object localObject = this.jdField_a_of_type_Ylm.bL();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        acff localacff = (acff)this.app.getManager(51);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localacff.e(str);
          if (localFriends != null) {
            localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        e(localArrayList, true);
        ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).notifyDataSetChanged();
      }
    }
  }
  
  protected void sq(String paramString)
  {
    if (this.v == null)
    {
      this.v = new ReportDialog(this, 2131756467);
      this.v.setContentView(2131558767);
      this.v.setOnKeyListener(new yly(this));
      this.v.findViewById(2131379443).setOnClickListener(new ylz(this));
      this.v.show();
      localObject = getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.v.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.v.getWindow().setAttributes(localLayoutParams);
      if (this.bZO == 2)
      {
        localObject = this.v.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
    }
    Object localObject = (TextView)this.v.findViewById(2131373180);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719518);
    }
    for (;;)
    {
      if (!this.v.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "showProgressDialog");
        }
        this.v.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
  
  public static class a
    extends AsyncTask<Void, Void, Integer>
  {
    Intent P;
    int busiType;
    int eK;
    WeakReference<BaseActivity> mActivity;
    MessageForShortVideo jdField_n_of_type_ComTencentMobileqqDataMessageForShortVideo;
    WeakReference<QQAppInterface> jdField_n_of_type_JavaLangRefWeakReference;
    String thumbPath;
    int uinType;
    
    public a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
    {
      this.jdField_n_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
      this.mActivity = new WeakReference(paramBaseActivity);
      this.P = paramBaseActivity.getIntent();
      this.eK = this.P.getIntExtra("param_entrance", 0);
      this.thumbPath = this.P.getStringExtra("thumbfile_send_path");
      this.busiType = 2;
      this.uinType = this.P.getIntExtra("uintype", -1);
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: create");
      }
    }
    
    public boolean KA()
    {
      if (ShortVideoUtils.awI()) {
        return true;
      }
      ShortVideoUtils.B((AppInterface)this.jdField_n_of_type_JavaLangRefWeakReference.get());
      return ShortVideoUtils.awI();
    }
    
    protected Integer a(Void... arg1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: doInBackground start");
      }
      long l = SystemClock.elapsedRealtime();
      ??? = (BaseActivity)this.mActivity.get();
      if (??? == null) {
        return Integer.valueOf(5);
      }
      if (!TextUtils.isEmpty(BlessSelectMemberActivity.aYT))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: currVideoPath is not null");
        }
        return Integer.valueOf(1);
      }
      SendVideoActivity.cY(this.P);
      aniq.dHk = this.P.getIntExtra("sv_total_frame_count", 0);
      aniq.bQi = this.P.getIntExtra("sv_total_record_time", 0);
      if (!aqhq.fileExistsAndNotEmpty(this.thumbPath)) {
        return Integer.valueOf(2);
      }
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = URLDrawable.getDrawable(new File(this.thumbPath), (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).downloadImediatly();
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        localObject1 = anfr.a(0, this.busiType);
        angt localangt = anfr.a(this.P, (angi)localObject1);
        if (localangt == null) {
          return Integer.valueOf(5);
        }
        localangt.cFA = true;
        localangt.cFz = false;
        if ((localangt.shortVideoId != null) && (localangt.shortVideoId.length() == 39)) {
          localangt.shortVideoId = localangt.shortVideoId.substring(0, 28);
        }
        ((angi)localObject1).c(localangt);
        this.jdField_n_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)new anff(???.app).a(localangt));
        if ((this.jdField_n_of_type_ComTencentMobileqqDataMessageForShortVideo instanceof MessageForBlessPTV)) {
          ((MessageForBlessPTV)this.jdField_n_of_type_ComTencentMobileqqDataMessageForShortVideo).videoFileName = this.P.getStringExtra("bless_ptv_mp4_path");
        }
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: generate req and mr success, cost:" + (SystemClock.elapsedRealtime() - l));
        }
        l = SystemClock.elapsedRealtime();
        ((ylm)((QQAppInterface)this.jdField_n_of_type_JavaLangRefWeakReference.get()).getManager(138)).j(this.jdField_n_of_type_ComTencentMobileqqDataMessageForShortVideo);
        if (BlessSelectMemberActivity.b() == null) {
          break label452;
        }
        BlessSelectMemberActivity.b().sendEmptyMessage(3);
      }
      try
      {
        synchronized (BlessSelectMemberActivity.c())
        {
          BlessSelectMemberActivity.c().wait(BlessSelectMemberActivity.eu());
          BlessSelectMemberActivity.access$1502(SystemClock.elapsedRealtime() - l);
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: encodeVideo cost = " + (SystemClock.elapsedRealtime() - l));
          }
          if (BlessSelectMemberActivity.Kn >= BlessSelectMemberActivity.eu())
          {
            return Integer.valueOf(9);
            return Integer.valueOf(2);
            label452:
            QLog.e("BlessSelectMemberActivity", 1, "mUIHandler is null!");
          }
        }
        return Integer.valueOf(BlessSelectMemberActivity.resultCode);
      }
      catch (InterruptedException ???)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: wait exception = " + ???.getMessage());
        }
        return Integer.valueOf(5);
      }
    }
    
    protected void onPostExecute(Integer arg1)
    {
      super.onPostExecute(???);
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 1, "BlessPTVProcessTask: onPostExecute result=" + ???);
      }
      BlessSelectMemberActivity.ft(???.intValue());
      synchronized (BlessSelectMemberActivity.d())
      {
        BlessSelectMemberActivity.d().set(true);
        BlessSelectMemberActivity.d().notifyAll();
        return;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      BlessSelectMemberActivity.ft(1);
      QLog.d("BlessSelectMemberActivity", 1, "Is video useable:" + KA() + ", mEntrance:" + this.eK);
    }
  }
  
  static class b
    extends AsyncTask<Void, Void, Integer>
  {
    long Kp = 0L;
    long Kq = 0L;
    int eK;
    WeakReference<Context> mContext;
    String mVideoMd5;
    WeakReference<QQAppInterface> n;
    ArrayList<String> uinList;
    
    public b(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
    {
      this.mContext = new WeakReference(paramContext);
      this.n = new WeakReference(paramQQAppInterface);
      this.uinList = paramArrayList;
      this.eK = paramInt;
    }
    
    /* Error */
    protected Integer a(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   5: ifeq +11 -> 16
      //   8: ldc 62
      //   10: iconst_2
      //   11: ldc 64
      //   13: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   16: invokestatic 72	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:d	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   19: astore 5
      //   21: aload 5
      //   23: monitorenter
      //   24: invokestatic 72	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:d	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   27: invokevirtual 77	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   30: ifne +69 -> 99
      //   33: invokestatic 83	android/os/SystemClock:elapsedRealtime	()J
      //   36: lstore_2
      //   37: invokestatic 72	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:d	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   40: invokestatic 86	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:eu	()J
      //   43: invokevirtual 92	java/lang/Object:wait	(J)V
      //   46: invokestatic 83	android/os/SystemClock:elapsedRealtime	()J
      //   49: lload_2
      //   50: lsub
      //   51: invokestatic 96	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1502	(J)J
      //   54: pop2
      //   55: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   58: ifeq +41 -> 99
      //   61: ldc 62
      //   63: iconst_2
      //   64: new 98	java/lang/StringBuilder
      //   67: dup
      //   68: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   71: ldc 101
      //   73: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: invokestatic 108	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1500	()J
      //   79: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   82: ldc 113
      //   84: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: invokestatic 117	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1200	()I
      //   90: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   93: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   99: aload 5
      //   101: monitorexit
      //   102: invokestatic 108	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1500	()J
      //   105: invokestatic 86	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:eu	()J
      //   108: lcmp
      //   109: iflt +57 -> 166
      //   112: bipush 9
      //   114: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   117: areturn
      //   118: astore 6
      //   120: aload 5
      //   122: monitorexit
      //   123: aload 6
      //   125: athrow
      //   126: astore 5
      //   128: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   131: ifeq -29 -> 102
      //   134: ldc 62
      //   136: iconst_2
      //   137: new 98	java/lang/StringBuilder
      //   140: dup
      //   141: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   144: ldc 134
      //   146: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: aload 5
      //   151: invokevirtual 137	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   154: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   160: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   163: goto -61 -> 102
      //   166: invokestatic 117	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1200	()I
      //   169: iconst_1
      //   170: if_icmpeq +10 -> 180
      //   173: invokestatic 117	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$1200	()I
      //   176: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: areturn
      //   180: aload_0
      //   181: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   184: putfield 30	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:Kp	J
      //   187: getstatic 145	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:aYT	Ljava/lang/String;
      //   190: astore 8
      //   192: aload_0
      //   193: getfield 41	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:n	Ljava/lang/ref/WeakReference;
      //   196: invokevirtual 148	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   199: checkcast 150	com/tencent/mobileqq/app/QQAppInterface
      //   202: sipush 138
      //   205: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
      //   208: checkcast 156	ylm
      //   211: invokevirtual 159	ylm:a	()Lcom/tencent/mobileqq/data/MessageForShortVideo;
      //   214: astore 7
      //   216: aload 7
      //   218: ifnonnull +8 -> 226
      //   221: iconst_5
      //   222: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   225: areturn
      //   226: aload 7
      //   228: instanceof 161
      //   231: ifeq +52 -> 283
      //   234: aload 7
      //   236: checkcast 161	com/tencent/mobileqq/data/MessageForBlessPTV
      //   239: aload_0
      //   240: getfield 43	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:uinList	Ljava/util/ArrayList;
      //   243: putfield 162	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
      //   246: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   249: ifeq +34 -> 283
      //   252: ldc 62
      //   254: iconst_2
      //   255: new 98	java/lang/StringBuilder
      //   258: dup
      //   259: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   262: ldc 164
      //   264: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   267: aload_0
      //   268: getfield 43	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:uinList	Ljava/util/ArrayList;
      //   271: invokevirtual 167	java/util/ArrayList:toString	()Ljava/lang/String;
      //   274: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   277: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   280: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   283: aload_0
      //   284: getfield 41	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:n	Ljava/lang/ref/WeakReference;
      //   287: invokevirtual 148	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   290: checkcast 150	com/tencent/mobileqq/app/QQAppInterface
      //   293: astore 6
      //   295: aload 6
      //   297: ifnull +11 -> 308
      //   300: aload 6
      //   302: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
      //   305: invokevirtual 176	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
      //   308: aload 7
      //   310: getfield 181	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
      //   313: invokestatic 187	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
      //   316: ifeq +275 -> 591
      //   319: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   322: ifeq +11 -> 333
      //   325: ldc 62
      //   327: iconst_2
      //   328: ldc 189
      //   330: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   333: aload 7
      //   335: getfield 192	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
      //   338: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   341: ifeq +82 -> 423
      //   344: aload 7
      //   346: aload_0
      //   347: getfield 200	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:mVideoMd5	Ljava/lang/String;
      //   350: putfield 192	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
      //   353: aload 7
      //   355: ldc 202
      //   357: invokestatic 207	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
      //   360: astore_1
      //   361: aload 8
      //   363: aload_1
      //   364: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   367: ifne +41 -> 408
      //   370: aload 8
      //   372: aload_1
      //   373: invokestatic 217	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   376: pop
      //   377: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   380: ifeq +28 -> 408
      //   383: ldc 62
      //   385: iconst_2
      //   386: new 98	java/lang/StringBuilder
      //   389: dup
      //   390: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   393: ldc 219
      //   395: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   398: aload_1
      //   399: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   402: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   405: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   408: aload_1
      //   409: putstatic 225	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:aYU	Ljava/lang/String;
      //   412: aload 7
      //   414: aload_1
      //   415: putfield 181	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
      //   418: aload 7
      //   420: invokevirtual 228	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
      //   423: aload 6
      //   425: ifnull +520 -> 945
      //   428: invokestatic 231	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$000	()Z
      //   431: ifne +514 -> 945
      //   434: iconst_0
      //   435: iconst_3
      //   436: invokestatic 236	anfr:a	(II)Langi;
      //   439: astore_1
      //   440: aload 7
      //   442: aload_1
      //   443: invokestatic 239	anfr:a	(Ljava/lang/Object;Langi;)Langt;
      //   446: astore 5
      //   448: aload 5
      //   450: iconst_0
      //   451: putfield 245	angt:cFz	Z
      //   454: aload 5
      //   456: iconst_1
      //   457: putfield 248	angt:cFA	Z
      //   460: aload 5
      //   462: getfield 251	angt:shortVideoId	Ljava/lang/String;
      //   465: ifnull +32 -> 497
      //   468: aload 5
      //   470: getfield 251	angt:shortVideoId	Ljava/lang/String;
      //   473: invokevirtual 254	java/lang/String:length	()I
      //   476: bipush 39
      //   478: if_icmpne +19 -> 497
      //   481: aload 5
      //   483: aload 5
      //   485: getfield 251	angt:shortVideoId	Ljava/lang/String;
      //   488: iconst_0
      //   489: bipush 28
      //   491: invokevirtual 258	java/lang/String:substring	(II)Ljava/lang/String;
      //   494: putfield 251	angt:shortVideoId	Ljava/lang/String;
      //   497: aload_1
      //   498: aload 5
      //   500: invokevirtual 264	angi:c	(Langt;)V
      //   503: aload_1
      //   504: aload 6
      //   506: invokestatic 267	anfr:a	(Langi;Lcom/tencent/mobileqq/app/QQAppInterface;)V
      //   509: aload_0
      //   510: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   513: putfield 32	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:Kq	J
      //   516: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   519: ifeq +67 -> 586
      //   522: ldc 62
      //   524: iconst_2
      //   525: new 98	java/lang/StringBuilder
      //   528: dup
      //   529: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   532: ldc_w 269
      //   535: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   538: aload 7
      //   540: getfield 272	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
      //   543: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   546: ldc_w 274
      //   549: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   552: aload 7
      //   554: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   557: ldc_w 279
      //   560: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   563: aload_0
      //   564: getfield 32	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:Kq	J
      //   567: aload_0
      //   568: getfield 30	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:Kp	J
      //   571: lsub
      //   572: l2d
      //   573: ldc2_w 280
      //   576: ddiv
      //   577: invokevirtual 284	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   580: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   583: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   586: iconst_1
      //   587: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   590: areturn
      //   591: aload 8
      //   593: invokestatic 187	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
      //   596: ifne +24 -> 620
      //   599: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   602: ifeq +12 -> 614
      //   605: ldc 62
      //   607: iconst_2
      //   608: ldc_w 286
      //   611: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   614: bipush 10
      //   616: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   619: areturn
      //   620: new 288	java/io/File
      //   623: dup
      //   624: aload 8
      //   626: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
      //   629: astore 5
      //   631: aload 5
      //   633: invokevirtual 293	java/io/File:length	()J
      //   636: lstore_2
      //   637: lload_2
      //   638: lconst_0
      //   639: lcmp
      //   640: ifne +23 -> 663
      //   643: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   646: ifeq +12 -> 658
      //   649: ldc 62
      //   651: iconst_2
      //   652: ldc_w 295
      //   655: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   658: iconst_3
      //   659: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   662: areturn
      //   663: new 297	java/io/FileInputStream
      //   666: dup
      //   667: aload 5
      //   669: invokespecial 300	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   672: astore 5
      //   674: aload 5
      //   676: ifnull +196 -> 872
      //   679: aload 5
      //   681: lload_2
      //   682: invokestatic 306	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   685: invokestatic 312	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   688: astore 5
      //   690: aload 5
      //   692: astore_1
      //   693: aload 5
      //   695: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   698: ifeq +174 -> 872
      //   701: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   704: ifeq +30 -> 734
      //   707: ldc 62
      //   709: iconst_2
      //   710: new 98	java/lang/StringBuilder
      //   713: dup
      //   714: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   717: ldc_w 314
      //   720: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   723: aload 5
      //   725: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   728: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   731: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   734: iconst_3
      //   735: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   738: areturn
      //   739: astore 5
      //   741: aload 5
      //   743: invokevirtual 317	java/io/FileNotFoundException:printStackTrace	()V
      //   746: iconst_0
      //   747: ifeq +125 -> 872
      //   750: aconst_null
      //   751: lload_2
      //   752: invokestatic 306	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   755: invokestatic 312	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   758: astore 5
      //   760: aload 5
      //   762: astore_1
      //   763: aload 5
      //   765: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   768: ifeq +104 -> 872
      //   771: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   774: ifeq +30 -> 804
      //   777: ldc 62
      //   779: iconst_2
      //   780: new 98	java/lang/StringBuilder
      //   783: dup
      //   784: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   787: ldc_w 314
      //   790: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   793: aload 5
      //   795: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   798: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   801: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   804: iconst_3
      //   805: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   808: areturn
      //   809: astore_1
      //   810: iconst_0
      //   811: ifeq +59 -> 870
      //   814: aconst_null
      //   815: lload_2
      //   816: invokestatic 306	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   819: invokestatic 312	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   822: astore 5
      //   824: aload 5
      //   826: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   829: ifeq +41 -> 870
      //   832: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   835: ifeq +30 -> 865
      //   838: ldc 62
      //   840: iconst_2
      //   841: new 98	java/lang/StringBuilder
      //   844: dup
      //   845: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   848: ldc_w 314
      //   851: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   854: aload 5
      //   856: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   859: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   862: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   865: iconst_3
      //   866: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   869: areturn
      //   870: aload_1
      //   871: athrow
      //   872: aload_0
      //   873: aload_1
      //   874: putfield 200	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity$b:mVideoMd5	Ljava/lang/String;
      //   877: aload 7
      //   879: lload_2
      //   880: l2i
      //   881: putfield 320	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
      //   884: aload 7
      //   886: getfield 323	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
      //   889: invokestatic 187	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
      //   892: ifeq -559 -> 333
      //   895: aload 7
      //   897: getfield 326	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
      //   900: ldc_w 328
      //   903: invokestatic 332	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   906: astore_1
      //   907: aload_1
      //   908: aload 7
      //   910: getfield 323	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
      //   913: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   916: ifne -583 -> 333
      //   919: aload_1
      //   920: aload 7
      //   922: getfield 323	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
      //   925: invokestatic 217	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   928: ifne +8 -> 936
      //   931: iconst_3
      //   932: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   935: areturn
      //   936: aload 7
      //   938: aload_1
      //   939: putfield 323	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
      //   942: goto -609 -> 333
      //   945: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   948: ifeq -362 -> 586
      //   951: new 98	java/lang/StringBuilder
      //   954: dup
      //   955: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   958: ldc_w 334
      //   961: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   964: astore_1
      //   965: aload 6
      //   967: ifnull +36 -> 1003
      //   970: iconst_1
      //   971: istore 4
      //   973: ldc 62
      //   975: iconst_2
      //   976: aload_1
      //   977: iload 4
      //   979: invokevirtual 337	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   982: ldc_w 339
      //   985: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   988: invokestatic 231	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:access$000	()Z
      //   991: invokevirtual 337	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   994: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   997: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   1000: goto -414 -> 586
      //   1003: iconst_0
      //   1004: istore 4
      //   1006: goto -33 -> 973
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1009	0	this	b
      //   0	1009	1	paramVarArgs	Void[]
      //   36	844	2	l	long
      //   971	34	4	bool	boolean
      //   126	24	5	localInterruptedException	InterruptedException
      //   446	278	5	localObject1	Object
      //   739	3	5	localFileNotFoundException	java.io.FileNotFoundException
      //   758	97	5	str1	String
      //   118	6	6	localObject2	Object
      //   293	673	6	localQQAppInterface	QQAppInterface
      //   214	723	7	localMessageForShortVideo	MessageForShortVideo
      //   190	435	8	str2	String
      // Exception table:
      //   from	to	target	type
      //   24	99	118	finally
      //   99	102	118	finally
      //   120	123	118	finally
      //   16	24	126	java/lang/InterruptedException
      //   123	126	126	java/lang/InterruptedException
      //   663	674	739	java/io/FileNotFoundException
      //   663	674	809	finally
      //   741	746	809	finally
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      QLog.i("BlessSelectMemberActivity", 1, "BlessPTVUploadTask: onPostExecute result=" + paramInteger + " ,entrance=" + this.eK);
      Properties localProperties = new Properties();
      localProperties.setProperty("bless_param_ptv_result", "" + paramInteger);
      localProperties.setProperty("bless_param_entrance_type", "" + this.eK);
      ylo.c("bless_event_ptv_result", localProperties);
      if (paramInteger.intValue() != 1)
      {
        ((BlessSelectMemberActivity)this.mContext.get()).go();
        switch (paramInteger.intValue())
        {
        }
      }
      for (;;)
      {
        BlessSelectMemberActivity.ft(1);
        return;
        BlessSelectMemberActivity.d((Context)this.mContext.get(), 2131720284, true);
        continue;
        BlessSelectMemberActivity.d((Context)this.mContext.get(), 2131720279, true);
        continue;
        BlessSelectMemberActivity.d((Context)this.mContext.get(), 2131720249, true);
        continue;
        BlessSelectMemberActivity.d((Context)this.mContext.get(), 2131720276, true);
        continue;
        BlessSelectMemberActivity.aa((Context)this.mContext.get(), 2131720280);
        continue;
        BlessSelectMemberActivity.d((Context)this.mContext.get(), 2131720277, true);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      BlessSelectMemberActivity.access$1502(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */