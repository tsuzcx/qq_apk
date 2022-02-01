package com.tencent.biz.qqstory.takevideo.music;

import acfp;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
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
import aqha;
import aqhq;
import aqiw;
import aqju;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
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
import rdc;
import rdo;
import rjp;
import rjr;
import rju;
import rjv;
import rjw;
import rjx;
import rjy;
import rka;
import rkb;
import rkc;
import rox;
import rpq;
import wja;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, MusicHorizontalSeekView.a, pmp, ppv.b<pyy, qaj>
{
  protected long Cg = 1000L;
  protected long Ch;
  public ProgressBar G;
  protected EditVideoParams a;
  protected MusicPlayTask a;
  public MusicHorizontalSeekView a;
  protected pmz a;
  public rka a;
  public boolean aIu;
  public boolean aIv;
  protected boolean aIw;
  protected int asi;
  public EditVideoMusic b;
  private psc.a<prw.a> jdField_b_of_type_Psc$a = new rjy(this);
  public rjp b;
  private rjr jdField_b_of_type_Rjr;
  public int bsu;
  public int bsv;
  protected int bsw;
  protected int bsx;
  protected volatile int bsy;
  public rkc c;
  protected ConcurrentHashMap<String, String> cm = new ConcurrentHashMap();
  protected ConcurrentHashMap<String, Long> cn = new ConcurrentHashMap();
  protected GridView f;
  public final boolean mIsTakePhoto;
  protected Timer mTimer;
  public TextView mTitleView;
  public Handler mUIHandler = new rjv(this);
  public View oW;
  public View oX;
  protected View oY;
  public TextView yH;
  protected TextView yI;
  protected TextView yJ;
  protected TextView yK;
  protected TextView yL;
  
  public EditVideoMusicDialog(Context paramContext, EditVideoMusic paramEditVideoMusic, boolean paramBoolean1, int paramInt, EditVideoParams paramEditVideoParams, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131755357);
    super.requestWindowFeature(1);
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.mIsTakePhoto = paramBoolean1;
    this.bsu = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.asi = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi;
    this.aIu = paramBoolean2;
    this.aIw = paramBoolean3;
    this.jdField_b_of_type_Rjr = new rjr(paramContext, new rju(this), this.mUIHandler);
    initUI(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = rpq.getWindowScreenHeight(getContext());
    paramContext.windowAnimations = 2131755376;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void bvc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "pressCancelBtn");
    }
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.c);
    if (this.c != null)
    {
      this.c.start = this.bsw;
      this.c.end = this.bsx;
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
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(rkc.f);
      return;
    }
    this.mUIHandler.sendEmptyMessage(6);
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(rkc.f);
  }
  
  private void bvd()
  {
    int j = 1;
    rkc localrkc = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localrkc != null)
    {
      i = j;
      if (this.c != null)
      {
        if ((localrkc.musicType == 3) || (localrkc.musicType == 2)) {
          break label110;
        }
        i = j;
      }
    }
    while ((this.aIw) && (i != 0))
    {
      aqha.a(getContext(), 230).setMessage(acfp.m(2131705558)).setPositiveButton(acfp.m(2131705539), new rjx(this)).setNegativeButton(acfp.m(2131705482), new rjw(this)).show();
      return;
      label110:
      i = j;
      if (localrkc.id.equals(this.c.id)) {
        i = 0;
      }
    }
    dismiss();
  }
  
  public void a(pyy parampyy, qaj paramqaj, ErrorMessage paramErrorMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.Ch).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label205;
      }
    }
    label205:
    for (parampyy = "null";; parampyy = paramErrorMessage.getErrorMessage())
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, parampyy);
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
    parampyy = paramqaj.a;
    int j = parampyy.music_config.size();
    paramqaj = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramqaj.add(new rkc((qqstory_struct.MusicConfigInfo)parampyy.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "GetMusicConfigResponse size = " + j);
      }
    }
    for (;;)
    {
      rar.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.nu = paramqaj;
      rkc.d(getContext(), paramqaj);
      this.mUIHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    bsT();
    af(paramInt1, paramInt2, paramInt3);
    if (this.mIsTakePhoto) {}
    for (String str = "2";; str = "1")
    {
      rar.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      ras.so("0X80076DA");
      return;
    }
  }
  
  public void af(int paramInt1, int paramInt2, int paramInt3)
  {
    rkc localrkc = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localrkc != null)
    {
      paramInt2 = localrkc.duration;
      localrkc.start = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      localrkc.end = (localrkc.start + this.bsu);
      if ((localrkc.end > paramInt2) && (paramInt2 > this.bsu))
      {
        localrkc.end = paramInt2;
        localrkc.start = (paramInt2 - this.bsu);
      }
      eo(localrkc.start, localrkc.end);
    }
  }
  
  public void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    af(paramInt1, paramInt2, paramInt3);
    tR(true);
  }
  
  public void be(String paramString, int paramInt)
  {
    String str = rkb.gh(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, new Object[] { "onDownloadFinish() url:", paramString, " errCode:", Integer.valueOf(paramInt) });
    }
    Object localObject;
    if (paramInt == 0)
    {
      this.bsy = 0;
      if (this.cm == null) {
        this.cm = new ConcurrentHashMap();
      }
      this.cm.put(paramString, str);
      localObject = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString.equals(((rkc)localObject).aAQ)))
      {
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.st(str);
        this.mUIHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((rkc)localObject).id, str).commit();
      }
      rar.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.cn.get(paramString)).longValue();
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + rox.getFileNameFromUrl(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + rox.getFileSize(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      localObject = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject != null) && (paramString != null) && (paramString.equals(((rkc)localObject).aAQ)))
      {
        if (paramInt != 6)
        {
          localObject = this.mUIHandler.obtainMessage(7, getContext().getResources().getString(2131700434));
          this.mUIHandler.sendMessage((Message)localObject);
        }
        bvc();
      }
      rar.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      ras.so("0X80076D9");
    }
  }
  
  protected void bsT()
  {
    bvf();
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.bsS();
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.bsT();
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = new MusicPlayTask();
    this.mTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask, 0L, this.Cg);
  }
  
  public void bvf()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = null;
    }
    this.bsv = -1;
    this.mUIHandler.sendEmptyMessage(8);
  }
  
  protected void bvg()
  {
    rkc localrkc = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localrkc != null) && (localrkc.musicType == 3) && (this.jdField_a_of_type_Rka.a(localrkc) > 0) && (localrkc != null) && (!localrkc.equals(this.jdField_a_of_type_Rka.b())))
    {
      this.jdField_a_of_type_Rka.f(localrkc);
      this.jdField_a_of_type_Rka.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void ck(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.bsy = 0;
    paramString1 = this.mUIHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.mUIHandler.sendMessage(paramString1);
  }
  
  public void d(rkc paramrkc)
  {
    String str = paramrkc.aAQ;
    Object localObject = paramrkc.aAR;
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramrkc = (rkc)localObject;
      if (!rox.exists((String)localObject)) {
        paramrkc = (String)this.cm.get(str);
      }
      localObject = paramrkc;
      if (!rox.exists(paramrkc)) {
        localObject = rkb.gh(str);
      }
      if (!rox.exists((String)localObject)) {
        break label171;
      }
      if ((this.jdField_a_of_type_Pmz != null) && (this.jdField_a_of_type_Pmz.isDownloading()))
      {
        aqhq.deleteFile(this.jdField_a_of_type_Pmz.getDownloadPath());
        this.jdField_a_of_type_Pmz.cancel();
      }
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a() != null)
      {
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.st((String)localObject);
        this.mUIHandler.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "exists audio_url = " + str + ", path = " + (String)localObject);
      }
    }
    return;
    label171:
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      bvg();
      QQToast.a(BaseApplication.getContext(), 2131697432, 0).show();
      return;
    }
    this.cn.put(str, Long.valueOf(System.currentTimeMillis()));
    this.cm.put(str, localObject);
    if ((this.jdField_a_of_type_Pmz != null) && (this.jdField_a_of_type_Pmz.isDownloading()))
    {
      aqhq.deleteFile(this.jdField_a_of_type_Pmz.getDownloadPath());
      this.jdField_a_of_type_Pmz.cancel();
    }
    ThreadManager.post(new EditVideoMusicDialog.3(this, str), 5, null, true);
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
    this.mUIHandler.removeMessages(8);
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
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramrkc);
    d(paramrkc);
    ras.so("0X80076D6");
  }
  
  protected boolean eU(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 5) {
      bool = false;
    }
    return bool;
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
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.yI.setText(rkb.i(paramInt1, false));
      this.yJ.setText(rkb.i(i, false));
      return;
      i = j;
    }
  }
  
  public void initUI(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561906, null);
    super.setContentView((View)localObject);
    if (this.mIsTakePhoto)
    {
      this.Cg = (this.bsu / 4);
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
      if (!this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.KZ()) {
        break label575;
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
      this.jdField_a_of_type_Rka = new rka(paramContext, this.f, this.mIsTakePhoto, eU(this.asi));
      this.f.setAdapter(this.jdField_a_of_type_Rka);
      this.jdField_a_of_type_Rka.cr(null);
      label340:
      localObject = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.mIsTakePhoto) {
          break label616;
        }
        paramContext = rkc.e;
        label369:
        localEditVideoMusic.a(paramContext);
      }
      this.c = ((rkc)localObject);
      this.bsw = ((rkc)localObject).start;
      this.bsx = ((rkc)localObject).end;
      this.aIv = rdc.al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 512);
      if (this.aIv) {
        this.jdField_b_of_type_Rjp = new rjp(this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.mUIHandler);
      }
      if (eU(this.asi)) {
        if ((this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.nu != null) && (!this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.nu.isEmpty())) {
          break label623;
        }
      }
    }
    label575:
    label616:
    label623:
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.nu = rkc.d(getContext());
      this.mUIHandler.sendEmptyMessage(1);
      if (i != 0)
      {
        if (!aqiw.isNetSupport(getContext())) {
          break label628;
        }
        this.Ch = System.currentTimeMillis();
        paramContext = new pyy();
        ppv.a().a(paramContext, this);
      }
      return;
      if (this.bsu < 5000)
      {
        this.Cg = (this.bsu / 6);
        break;
      }
      this.Cg = 1000L;
      break;
      ((View)localObject).findViewById(2131365882).getLayoutParams().height = wja.dp2px(138.0F, this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.getResources());
      ((View)localObject).findViewById(2131372087).setVisibility(8);
      break label340;
      paramContext = rkc.f;
      break label369;
    }
    label628:
    this.mUIHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), acfp.m(2131705537), 0).show();
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
      ras.so("0X80076DB");
      dismiss();
      continue;
      ras.so("0X80076DC");
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
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onItemClick error musicInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label52:
      this.jdField_a_of_type_Rka.f(localrkc);
      this.jdField_a_of_type_Rka.notifyDataSetChanged();
      bsT();
      if (paramInt < this.jdField_a_of_type_Rka.ty())
      {
        if (localrkc.musicType == 0)
        {
          this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localrkc);
          this.mUIHandler.sendEmptyMessage(3);
          if (this.mIsTakePhoto) {}
          for (localObject = "2";; localObject = "1")
          {
            rar.a("video_edit", "close_music", 0, 0, new String[] { localObject, "", "", "" });
            ras.so("0X80076D3");
            break;
          }
        }
        if (localrkc.musicType == 1)
        {
          this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localrkc);
          this.mUIHandler.sendEmptyMessage(6);
          if (this.mIsTakePhoto) {}
          for (localObject = "2";; localObject = "1")
          {
            rar.a("video_edit", "clk_video_sound", 0, 0, new String[] { localObject, "", "", "" });
            ras.so("0X80076D4");
            this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.e("608", "3", "2", true);
            break;
          }
        }
        if (localrkc.musicType == 2) {
          if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
          {
            bvg();
            QQToast.a(BaseApplication.getContext(), 2131697432, 0).show();
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "click add qqmusic");
            }
            this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.tC(false);
            bvf();
            localObject = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            int i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi;
            if ((localObject instanceof BaseActivity)) {
              rkb.b((BaseActivity)localObject, i);
            }
            if (this.mIsTakePhoto) {}
            for (localObject = "2";; localObject = "1")
            {
              rar.a("video_edit", "add_qqmusic", 0, 0, new String[] { localObject, "", "", "" });
              ras.so("0X80076D5");
              this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.e("608", "3", "1", true);
              break;
            }
          }
        }
      }
      else
      {
        if (localrkc.musicType != 4) {
          break;
        }
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(rkc.e);
        if (this.jdField_b_of_type_Rjp != null) {
          this.jdField_b_of_type_Rjp.b(localrkc);
        }
      }
    }
    if (!TextUtils.isEmpty(localrkc.aAQ))
    {
      this.oW.setVisibility(0);
      this.yH.setVisibility(8);
      this.mTitleView.setText(localrkc.title);
      this.oX.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(localrkc);
    d(localrkc);
    if (this.mIsTakePhoto) {}
    for (Object localObject = "2";; localObject = "1")
    {
      rar.a("video_edit", "add_music", 0, 0, new String[] { localObject, "", "", "" });
      ras.g("0X80076D8", "", "", localrkc.title, "");
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.e("608", "3", "1", true);
      break;
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
        QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "onProgress() mIndex = " + this.bsy + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void tR(boolean paramBoolean)
  {
    bvf();
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.resetPlay();
    }
    this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.startPlayer();
    rkc localrkc = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    rdo localrdo;
    if (localrkc != null)
    {
      localrdo = (rdo)this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b.a(rdo.class);
      if (localrdo != null) {
        if ((localrkc.musicType != 2) && (localrkc.musicType != 3) && (localrkc.musicType != 0)) {
          break label88;
        }
      }
    }
    label88:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrdo.tt(paramBoolean);
      return;
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
      if (EditVideoMusicDialog.this.b.a() != null)
      {
        EditVideoMusicDialog localEditVideoMusicDialog = EditVideoMusicDialog.this;
        localEditVideoMusicDialog.bsv += 1;
        if ((!QLog.isColorLevel()) || (EditVideoMusicDialog.this.isShowing())) {
          EditVideoMusicDialog.this.mUIHandler.sendEmptyMessage(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */