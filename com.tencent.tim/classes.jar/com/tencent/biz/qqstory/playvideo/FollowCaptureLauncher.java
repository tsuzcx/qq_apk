package com.tencent.biz.qqstory.playvideo;

import acfp;
import alwy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import aqha;
import aqju;
import arht;
import ayzv;
import azbq;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import pnh;
import pno;
import pnx;
import qex;
import qey;
import qez;
import qmm.d;
import qmm.f;
import ram;
import rar;
import rnq;
import wja;

public class FollowCaptureLauncher
  implements qmm.d, qmm.f
{
  private arht jdField_a_of_type_Arht;
  private a jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a;
  private AbsVideoInfoWidget jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget;
  private pno jdField_a_of_type_Pno;
  private boolean aCX = true;
  private boolean aCY;
  private boolean aCZ;
  private boolean aDa;
  private boolean aDb;
  private String axh;
  private String axi;
  private String axj;
  private int blQ;
  private int blR;
  private int blS;
  private Dialog mDialog;
  private long startTime;
  
  public FollowCaptureLauncher(AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget = paramAbsVideoInfoWidget;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a = new a(this);
  }
  
  private arht a()
  {
    arht localarht = new arht(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity());
    localarht.YE(wja.dp2px(50.0F, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity().getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    return localarht;
  }
  
  private boolean aA(Context paramContext)
  {
    boolean bool = false;
    if (!alwy.auJ())
    {
      ram.d("FollowCaptureLauncher", "checkApiVersionDialog false");
      aqha.a(paramContext, 230).setMessage(acfp.m(2131706383)).setPositiveButton(2131721079, new qez(this)).show();
      bool = true;
    }
    return bool;
  }
  
  private void bnO()
  {
    this.aCY = false;
    this.blQ = 0;
    this.axh = null;
    this.aCX = true;
    this.blR = 0;
    this.blS = 0;
    this.axi = null;
    this.axj = null;
    this.aCZ = false;
    this.aDa = false;
    this.aDb = false;
  }
  
  private void bnP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, vid:" + this.axh);
    }
    if (this.aCY)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, cancel");
      }
      return;
    }
    if (TextUtils.isEmpty(this.axj))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, path is null");
      }
      rar.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.startTime, new String[] { "iframe_video_path_null" });
      bnR();
      return;
    }
    if (!new File(this.axj).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, file not exist");
      }
      rar.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.startTime, new String[] { "iframe_video_nonexist" });
      bnR();
      return;
    }
    FollowCaptureParam localFollowCaptureParam = new FollowCaptureParam();
    if ((this.axi != null) && (this.aCZ))
    {
      localObject = ayzv.H(this.axi);
      localFollowCaptureParam.backgroundPath = localObject[0];
      localFollowCaptureParam.foregroundPath = localObject[1];
    }
    localFollowCaptureParam.videoPath = this.axj;
    localFollowCaptureParam.vid = this.axh;
    localFollowCaptureParam.showLink = this.aCX;
    localFollowCaptureParam.comparedLevel = this.blR;
    localFollowCaptureParam.comparedActivityId = this.blS;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("edit_video_type", 10014);
    ((Bundle)localObject).putSerializable("extra_follow_capture_param", localFollowCaptureParam);
    rnq.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity(), (Bundle)localObject, 1024);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.removeCallbacksAndMessages(null);
    bnO();
    rar.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.startTime, new String[0]);
  }
  
  private void bnQ()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    this.aCY = true;
    sC(false);
    rar.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.startTime, new String[] { "activity_stop" });
  }
  
  private void bnR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowCaptureLauncher", 2, "showFollowCaptureError");
    }
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    bnO();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity(), 0, acfp.m(2131706382), 0).show();
  }
  
  private void bnT()
  {
    this.blQ = Math.min(this.blQ + 1, 99);
    if (this.blQ == 99) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.removeMessages(65536);
    }
    for (;;)
    {
      updateProgress(this.blQ);
      return;
      if (this.blQ > 80) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendEmptyMessageDelayed(65536, 500L);
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendEmptyMessageDelayed(65536, 200L);
      }
    }
  }
  
  private void bnU()
  {
    this.aDb = true;
  }
  
  private void bnV()
  {
    this.aCZ = true;
  }
  
  private void bnW()
  {
    int i = getProgress();
    if (this.blQ < i) {
      this.blQ = i;
    }
    if ((this.aCZ) && (this.aDb) && (this.aDa))
    {
      updateProgress(100);
      bnP();
      this.mDialog.dismiss();
    }
  }
  
  private void cu(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ConvertAllIFrameRunnable(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a), 16, null, true);
  }
  
  private int getProgress()
  {
    int j = 0;
    if (this.aCZ) {
      j = 20;
    }
    int i = j;
    if (this.aDa) {
      i = j + 40;
    }
    j = i;
    if (this.aDb) {
      j = i + 40;
    }
    return j;
  }
  
  private void rB(String paramString)
  {
    ThreadManagerV2.excute(new FollowCaptureLauncher.1(this, paramString), 16, null, true);
  }
  
  private void rD(String paramString)
  {
    if ((paramString == null) || (!paramString.equals(this.axh)) || (this.aDa)) {}
    File localFile;
    do
    {
      return;
      this.aDa = true;
      localFile = pnh.a(paramString, 0, false, false);
    } while (localFile == null);
    paramString = new File(ayzv.U(), paramString + ".mp4");
    cu(localFile.getPath(), paramString.getPath());
  }
  
  private void rE(String paramString)
  {
    rD(paramString);
  }
  
  private void sC(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget != null)
    {
      Object localObject = (StoryPlayerGroupHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a();
      if (localObject != null)
      {
        localObject = ((StoryPlayerGroupHolder)localObject).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).sH(paramBoolean);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget == null) {
      QLog.e("FollowCaptureLauncher", 1, "follow capture error:BannerVideoInfoWidget is null");
    }
    do
    {
      do
      {
        return;
      } while (aA(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity()));
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 1, "follow capture vid:" + paramString1 + " templateUrl:" + paramString2);
      }
      bnO();
    } while (TextUtils.isEmpty(paramString1));
    this.startTime = System.currentTimeMillis();
    this.axh = paramString1;
    this.aCX = paramBoolean;
    this.blR = paramInt1;
    this.blS = paramInt2;
    sC(true);
    ayzv.eUz();
    if (!TextUtils.isEmpty(paramString2))
    {
      this.axi = ayzv.sU(paramString2);
      if (!ayzv.uq(this.axi))
      {
        rB(paramString2);
        paramString2 = new File(ayzv.U(), paramString1 + ".mp4");
        this.axj = paramString2.getPath();
        if (!paramString2.exists()) {
          break label255;
        }
        this.aDa = true;
        this.aDb = true;
      }
    }
    for (;;)
    {
      if ((!this.aDa) || (!this.aDb) || (!this.aCZ)) {
        break label298;
      }
      updateProgress(100);
      bnP();
      return;
      this.aCZ = true;
      break;
      this.aCZ = true;
      break;
      label255:
      File localFile = pnh.a(paramString1, 0, false, false);
      if (localFile != null)
      {
        this.aDa = true;
        cu(localFile.getPath(), paramString2.getPath());
      }
      else
      {
        fO(paramString1);
      }
    }
    label298:
    this.blQ = getProgress();
    d(acfp.m(2131706381), true, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendEmptyMessageDelayed(65536, 100L);
  }
  
  public void bnS()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendEmptyMessage(65538);
  }
  
  public void d(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mDialog == null)
    {
      this.mDialog = new ReportDialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity());
      Object localObject = this.mDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        ((Window)localObject).setDimAmount(0.0F);
      }
      this.mDialog.requestWindowFeature(1);
      this.mDialog.setContentView(2131561856);
      localObject = (ImageView)this.mDialog.findViewById(2131373659);
      this.jdField_a_of_type_Arht = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Arht);
    }
    ((TextView)this.mDialog.findViewById(2131371989)).setText(paramString);
    this.mDialog.setCancelable(paramBoolean);
    this.mDialog.setCanceledOnTouchOutside(paramBoolean);
    this.mDialog.setOnCancelListener(new qey(this));
    this.jdField_a_of_type_Arht.setProgress(this.blQ);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendEmptyMessageDelayed(65545, paramInt);
  }
  
  public void fO(String paramString)
  {
    if (this.jdField_a_of_type_Pno == null) {
      this.jdField_a_of_type_Pno = new pno();
    }
    this.jdField_a_of_type_Pno.a(paramString, 0, true, new qex(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    sC(false);
    if (paramInt2 == -1)
    {
      pnx.qU("FollowCaptureLauncher onActivityResult");
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a().mReportData.from != 106)
      {
        paramIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity(), QQStoryMainActivity.class);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity().startActivity(paramIntent);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Pno != null) {
      this.jdField_a_of_type_Pno.stop();
    }
  }
  
  public void onStop()
  {
    bnQ();
  }
  
  public void rC(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 65537;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher$a.sendMessage(localMessage);
  }
  
  public void showProgressDialog()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (localActivity.isDestroyed()))) {}
    while (this.mDialog == null) {
      return;
    }
    this.mDialog.show();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_a_of_type_Arht == null) {
      return;
    }
    this.jdField_a_of_type_Arht.stopAnimating();
    this.jdField_a_of_type_Arht.setProgress(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("FollowCaptureLauncher", 2, "[setProgress] current:" + this.jdField_a_of_type_Arht.getProgress() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Arht.setShowText(true);
    this.jdField_a_of_type_Arht.setShowImage(false);
    this.jdField_a_of_type_Arht.setText(String.valueOf(paramInt) + "%");
  }
  
  static class ConvertAllIFrameRunnable
    implements Runnable
  {
    private String axl;
    private String axm;
    private Handler handler;
    
    public ConvertAllIFrameRunnable(String paramString1, String paramString2, Handler paramHandler)
    {
      this.axl = paramString1;
      this.axm = paramString2;
      this.handler = paramHandler;
    }
    
    public void run()
    {
      try
      {
        ayzv.U();
        long l1 = System.currentTimeMillis();
        int i = azbq.an(this.axl, this.axm);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("FollowCaptureLauncher", 2, new Object[] { "ffmpegToAllIFrame cost: ", Long.valueOf(l2 - l1), ", ret:", Integer.valueOf(i) });
        }
        this.handler.sendEmptyMessage(65539);
        return;
      }
      catch (Exception localException)
      {
        do
        {
          this.handler.sendEmptyMessage(65540);
        } while (!QLog.isColorLevel());
        QLog.e("FollowCaptureLauncher", 2, "convert to all ifrane video error", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          this.handler.sendEmptyMessage(65540);
        } while (!QLog.isColorLevel());
        QLog.e("FollowCaptureLauncher", 2, "convert to all ifrane video error", localOutOfMemoryError);
      }
    }
  }
  
  public static class a
    extends Handler
  {
    WeakReference<FollowCaptureLauncher> cT;
    
    public a(FollowCaptureLauncher paramFollowCaptureLauncher)
    {
      this.cT = new WeakReference(paramFollowCaptureLauncher);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = 0;
      FollowCaptureLauncher localFollowCaptureLauncher = (FollowCaptureLauncher)this.cT.get();
      if (localFollowCaptureLauncher == null) {}
      for (;;)
      {
        return;
        switch (paramMessage.what)
        {
        }
        while (i != 0)
        {
          FollowCaptureLauncher.f(localFollowCaptureLauncher);
          return;
          FollowCaptureLauncher.b(localFollowCaptureLauncher);
          continue;
          FollowCaptureLauncher.a(localFollowCaptureLauncher, (String)paramMessage.obj);
          i = 1;
          continue;
          FollowCaptureLauncher.c(localFollowCaptureLauncher);
          i = 1;
          continue;
          FollowCaptureLauncher.d(localFollowCaptureLauncher);
          i = 1;
          continue;
          FollowCaptureLauncher.b(localFollowCaptureLauncher, (String)paramMessage.obj);
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("FollowCaptureLauncher", 2, new Object[] { "showFollowCaptureError, ", Integer.valueOf(paramMessage.what) });
          }
          rar.a("FollowLaunchEvent", false, System.currentTimeMillis() - FollowCaptureLauncher.a(localFollowCaptureLauncher), new String[] { String.valueOf(paramMessage.what) });
          FollowCaptureLauncher.e(localFollowCaptureLauncher);
          continue;
          localFollowCaptureLauncher.showProgressDialog();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */