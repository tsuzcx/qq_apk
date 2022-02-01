package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import aass;
import aast;
import aasu;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqgz;
import aqhq;
import aqiw;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import pmp;
import pmz;
import ppv;
import ppv.b;
import prw;
import prw.a;
import psc.a;
import psd;
import psx;
import pyy;
import qaj;
import rar;
import ras;
import rjr;
import rka;
import rkb;
import rkc;
import rox;
import wja;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, MusicHorizontalSeekView.a, pmp, ppv.b<pyy, qaj>
{
  private static final String TAG = P2VEditMusicDialog.class.getSimpleName();
  protected long Cg = 1000L;
  protected long Ch;
  public ProgressBar G;
  public MusicHorizontalSeekView a;
  protected MusicPlayTask a;
  protected pmz a;
  public rka a;
  public boolean aIu;
  protected int asi;
  public a b;
  private psc.a<prw.a> jdField_b_of_type_Psc$a = new aasu(this);
  private rjr jdField_b_of_type_Rjr;
  public int bsu;
  public int bsv;
  protected volatile int bsy;
  public rkc c;
  protected GridView f;
  protected HashMap<String, String> hW = new HashMap();
  protected HashMap<String, Long> hX = new HashMap();
  protected Timer mTimer;
  public TextView mTitleView;
  public Handler mUIHandler = new aast(this);
  public View oW;
  public View oX;
  protected View oY;
  public ArrayList<rkc> se = new ArrayList();
  public TextView yH;
  protected TextView yI;
  protected TextView yJ;
  protected TextView yK;
  protected TextView yL;
  
  public P2VEditMusicDialog(Context paramContext, a parama, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755357);
    super.requestWindowFeature(1);
    this.bsu = paramInt;
    this.aIu = paramBoolean;
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a = parama;
    this.jdField_b_of_type_Rjr = new rjr(paramContext, new aass(this), this.mUIHandler);
    initUI(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755376;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void bJ(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { aqgz.getIMEI(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771991, 0);
  }
  
  private void bvc()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(this.c);
    if (this.c != null)
    {
      if (this.c.musicType == 1)
      {
        this.mUIHandler.sendEmptyMessage(6);
        return;
      }
      if (this.c.musicType == 0)
      {
        this.mUIHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.c.aAR))
      {
        this.mUIHandler.sendEmptyMessage(11);
        return;
      }
      this.mUIHandler.sendEmptyMessage(6);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(rkc.f);
      return;
    }
    this.mUIHandler.sendEmptyMessage(6);
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(rkc.f);
  }
  
  private void bvd()
  {
    rkc localrkc = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a();
    if ((localrkc == null) || (this.c == null) || ((localrkc.musicType != 3) && (localrkc.musicType != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localrkc.id.equals(this.c.id)) {}
    }
  }
  
  private void cxX()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.cwi();
  }
  
  public void a(pyy parampyy, qaj paramqaj, ErrorMessage paramErrorMessage)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.Ch).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label203;
      }
    }
    label203:
    for (parampyy = "null";; parampyy = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, parampyy);
      rar.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.Ch), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      parampyy = this.mUIHandler.obtainMessage(7);
      parampyy.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.mUIHandler.sendMessage(parampyy);
      rar.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramqaj = paramqaj.a;
    int j = paramqaj.music_config.size();
    parampyy = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        parampyy.add(new rkc((qqstory_struct.MusicConfigInfo)paramqaj.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramqaj = new StringBuffer();
        paramqaj.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (rkc)parampyy.get(i);
          paramqaj.append(", " + i + ": title = " + paramErrorMessage.title + ", audioUrl = " + paramErrorMessage.aAQ);
          i += 1;
        }
        QLog.d(TAG, 2, paramqaj.toString());
      }
    }
    for (;;)
    {
      rar.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.se = parampyy;
      rkc.d(getContext(), parampyy);
      this.mUIHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    cap();
    af(paramInt1, paramInt2, paramInt3);
  }
  
  public void af(int paramInt1, int paramInt2, int paramInt3)
  {
    rkc localrkc = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a();
    if (localrkc != null)
    {
      localrkc.start = ((int)(localrkc.duration * (paramInt3 / paramInt1)));
      localrkc.end = (localrkc.start + this.bsu);
      eo(localrkc.start, localrkc.end);
    }
  }
  
  public void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    af(paramInt1, paramInt2, paramInt3);
    cxW();
  }
  
  public void be(String paramString, int paramInt)
  {
    String str = rkb.gh(paramString);
    if (paramInt == 0)
    {
      this.bsy = 0;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onDownloadFinish() url = " + paramString);
      }
      if (this.hW == null) {
        this.hW = new HashMap();
      }
      this.hW.put(paramString, str);
      rkc localrkc = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a();
      if ((localrkc != null) && (paramString.equals(localrkc.aAQ)))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.AD(str);
        this.mUIHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localrkc.id, str).apply();
      }
      rar.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.hX.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(rox.getFileNameFromUrl(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(rox.getFileSize(str)).append(", url = " + paramString);
        QLog.d(TAG, 2, paramString.toString());
      }
      return;
      rar.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      ras.so("0X80076D9");
    }
  }
  
  public void bvb()
  {
    bvg();
    bve();
  }
  
  public void bve()
  {
    bvf();
    this.mTimer = new Timer();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = new MusicPlayTask();
    this.mTimer.schedule(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask, 0L, this.Cg);
  }
  
  protected void bvf()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    }
    this.bsv = -1;
    this.mUIHandler.sendEmptyMessage(8);
  }
  
  protected void bvg()
  {
    rkc localrkc = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a();
    if ((localrkc != null) && (localrkc.musicType == 3) && (this.jdField_a_of_type_Rka != null) && (this.jdField_a_of_type_Rka.a(localrkc) > 0) && (!localrkc.equals(this.jdField_a_of_type_Rka.b())))
    {
      this.jdField_a_of_type_Rka.f(localrkc);
      this.jdField_a_of_type_Rka.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void cap()
  {
    bvf();
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.cwg();
  }
  
  public void ck(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.bsy = 0;
    paramString1 = this.mUIHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.mUIHandler.sendMessage(paramString1);
  }
  
  public void cxW()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.cwh();
  }
  
  public void d(rkc paramrkc)
  {
    String str2 = paramrkc.aAQ;
    String str1 = paramrkc.aAR;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramrkc = str1;
      if (!rox.exists(str1))
      {
        str1 = (String)this.hW.get(str2);
        paramrkc = str1;
        if (!rox.exists(str1)) {
          paramrkc = rkb.gh(str2);
        }
      }
      if (rox.exists(paramrkc))
      {
        if ((this.jdField_a_of_type_Pmz != null) && (this.jdField_a_of_type_Pmz.isDownloading()))
        {
          aqhq.deleteFile(this.jdField_a_of_type_Pmz.getDownloadPath());
          this.jdField_a_of_type_Pmz.cancel();
        }
        if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a() != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.AD(paramrkc);
          this.mUIHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(TAG, 2, "exists audio_url = " + str2 + ", path = " + paramrkc);
          return;
          QLog.e(TAG, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
      {
        bvg();
        QQToast.a(BaseApplication.getContext(), 2131697432, 0).show();
        return;
      }
      this.hX.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.hW.put(str2, paramrkc);
      if ((this.jdField_a_of_type_Pmz != null) && (this.jdField_a_of_type_Pmz.isDownloading()))
      {
        aqhq.deleteFile(this.jdField_a_of_type_Pmz.getDownloadPath());
        this.jdField_a_of_type_Pmz.cancel();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(TAG, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void dismiss()
  {
    this.jdField_b_of_type_Rjr.destory();
    if ((this.jdField_a_of_type_Pmz != null) && (this.jdField_a_of_type_Pmz.isDownloading()))
    {
      aqhq.deleteFile(this.jdField_a_of_type_Pmz.getDownloadPath());
      this.jdField_a_of_type_Pmz.cancel();
    }
    ((prw)((psd)psx.a(20)).a(1)).b(this.jdField_b_of_type_Psc$a);
    bvf();
    cxW();
    super.dismiss();
  }
  
  public void e(rkc paramrkc)
  {
    if ((!TextUtils.isEmpty(paramrkc.aAQ)) || (!TextUtils.isEmpty(paramrkc.aAR)))
    {
      this.oW.setVisibility(0);
      this.yH.setVisibility(8);
      this.mTitleView.setText(paramrkc.title);
      this.oX.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(paramrkc);
    d(paramrkc);
    ras.so("0X80076D6");
  }
  
  public void en(int paramInt1, int paramInt2)
  {
    int i = (int)(this.yI.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.yI.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.yI.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.yJ.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.yJ.setLayoutParams(localLayoutParams);
  }
  
  public void eo(int paramInt1, int paramInt2)
  {
    int i = 1000;
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    if (j < 1000) {}
    for (;;)
    {
      j = i;
      if (this.asi == 1)
      {
        j = i;
        if (i > 8500.0D)
        {
          j = i;
          if (i < 13500.0D) {
            j = 10000;
          }
        }
      }
      i = j + paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.yI.setText(rkb.i(paramInt1, false));
      this.yJ.setText(rkb.i(i, true));
      return;
      i = j;
    }
  }
  
  public void initUI(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561906, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.bsu < 5000)
    {
      this.Cg = (this.bsu / 6);
      this.G = ((ProgressBar)((View)localObject).findViewById(2131372094));
      this.oX = ((View)localObject).findViewById(2131372083);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131372085));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.mTitleView = ((TextView)((View)localObject).findViewById(2131372086));
      this.yI = ((TextView)super.findViewById(2131377918));
      this.yJ = ((TextView)super.findViewById(2131377917));
      this.yK = ((TextView)super.findViewById(2131372090));
      this.yL = ((TextView)super.findViewById(2131372091));
      this.yK.setOnClickListener(this);
      this.yL.setOnClickListener(this);
      this.yH = ((TextView)((View)localObject).findViewById(2131366398));
      this.yH.setText("");
      this.oW = ((View)localObject).findViewById(2131377959);
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.KZ()) {
        break label459;
      }
      this.f = ((GridView)((View)localObject).findViewById(2131372084));
      this.f.setNumColumns(-1);
      this.f.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.f.setOverScrollMode(2);
      }
      this.f.setOnItemClickListener(this);
      this.oY = ((View)localObject).findViewById(2131365973);
      this.oY.setOnClickListener(this);
      localObject = this.f;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.WP()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_Rka = new rka(paramContext, (GridView)localObject, bool, true);
      this.f.setAdapter(this.jdField_a_of_type_Rka);
      this.jdField_a_of_type_Rka.cr(null);
      label351:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a() == null) {
        break label497;
      }
      this.c = new rkc();
      this.c.g(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a());
    }
    for (;;)
    {
      this.se = rkc.d(getContext());
      this.mUIHandler.sendEmptyMessage(1);
      if (!aqiw.isNetSupport(getContext())) {
        break label513;
      }
      this.Ch = System.currentTimeMillis();
      paramContext = new pyy();
      ppv.a().a(paramContext, this);
      return;
      this.Cg = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365882).getLayoutParams().height = wja.dp2px(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131372087).setVisibility(8);
      break label351;
      label497:
      this.c = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.a();
    }
    label513:
    this.mUIHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), acfp.m(2131709385), 0).show();
  }
  
  public void onBackPressed()
  {
    bvc();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bvc();
      dismiss();
      continue;
      bvd();
      continue;
      bvd();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    rkc localrkc;
    if (this.jdField_a_of_type_Rka != null)
    {
      localrkc = (rkc)this.jdField_a_of_type_Rka.getItem(paramInt);
      if (localrkc != null) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "onItemClick error musicInfo = " + null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label70:
      this.jdField_a_of_type_Rka.f(localrkc);
      this.jdField_a_of_type_Rka.notifyDataSetChanged();
      if (paramInt < this.jdField_a_of_type_Rka.ty())
      {
        cap();
        if (localrkc.musicType == 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(localrkc);
          this.mUIHandler.sendEmptyMessage(3);
        }
        else if (localrkc.musicType == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(localrkc);
          this.mUIHandler.sendEmptyMessage(6);
        }
        else if (localrkc.musicType == 2)
        {
          if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
          {
            bvg();
            QQToast.a(BaseApplication.getContext(), 2131697432, 0).show();
          }
          else
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.cwf();
            if ((!this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.WO()) && ((getContext() instanceof ContextThemeWrapper)) && ((((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity))) {
              bJ((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
            }
          }
        }
      }
      else
      {
        cap();
        if (!TextUtils.isEmpty(localrkc.aAQ))
        {
          this.oW.setVisibility(0);
          this.yH.setVisibility(8);
          this.mTitleView.setText(localrkc.title);
          this.oX.setVisibility(8);
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a.h(localrkc);
        d(localrkc);
        rar.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
      }
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.bsy * 0.05F)
    {
      this.bsy += 1;
      paramString = this.mUIHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.mUIHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onProgress() mIndex = " + this.bsy + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public int tx()
  {
    if (this.bsu < 5000) {
      return 5000;
    }
    return this.bsu;
  }
  
  public class MusicPlayTask
    extends TimerTask
  {
    protected MusicPlayTask() {}
    
    public void run()
    {
      if (P2VEditMusicDialog.this.b.a() != null)
      {
        P2VEditMusicDialog localP2VEditMusicDialog = P2VEditMusicDialog.this;
        localP2VEditMusicDialog.bsv += 1;
        if (QLog.isColorLevel()) {}
        P2VEditMusicDialog.this.mUIHandler.sendEmptyMessage(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void AD(String paramString);
    
    public abstract void Gd(int paramInt);
    
    public abstract boolean KZ();
    
    public abstract boolean WO();
    
    public abstract boolean WP();
    
    public abstract rkc a();
    
    public abstract void cwf();
    
    public abstract void cwg();
    
    public abstract void cwh();
    
    public abstract void cwi();
    
    public abstract void h(rkc paramrkc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */