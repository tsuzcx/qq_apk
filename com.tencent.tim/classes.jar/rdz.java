import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class rdz
  extends rdb
{
  private long BO = -1L;
  public boolean aGH;
  arht b;
  public int bpE = 3;
  private String fakeId;
  private Dialog mDialog;
  public int progress;
  
  public rdz(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private arht a()
  {
    arht localarht = new arht(getContext());
    localarht.YE(wja.dp2px(50.0F, getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    localarht.a(new rec(this));
    return localarht;
  }
  
  private void aac()
  {
    anot.a(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    aniq.bQi = (int)((EditRecordVideoSource)localObject).recordTime;
    aniq.dHk = ((EditRecordVideoSource)localObject).bpF;
    aniq.dFO = 0;
    aniq.dHo = 0;
    int i;
    rkm localrkm;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_b_of_type_Rdc.b != null)
    {
      i = this.jdField_b_of_type_Rdc.b.tc();
      aniq.bsT = i;
      ram.d("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
      localrkm = new rkm(this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localrkm.aAU = rlc.ce(2);
      localActivity = this.a.getActivity();
      i = ((EditRecordVideoSource)localObject).bpK;
      j = ((EditRecordVideoSource)localObject).bpL;
      str = ((EditRecordVideoSource)localObject).sourcePath;
      f = ((EditRecordVideoSource)localObject).mH;
      if ((this.jdField_b_of_type_Rdc.b == null) || (this.jdField_b_of_type_Rdc.b.tc() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localrkm.a = new rks(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).bpJ, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).azu, ((EditRecordVideoSource)localObject).aGI);
      localObject = this.jdField_b_of_type_Rdc.lu.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rdb)((Iterator)localObject).next()).a(0, localrkm);
      }
      i = 0;
      break;
    }
    ram.w("EditVideoSave", "PUBLISH start ...");
    d(acfp.m(2131705672), false, 0);
    updateProgress(2);
    Stream.of(localrkm).map(new ThreadOffFunction("EditVideoSave", 2)).map(new rkt()).map(new rkn((rba)this.jdField_b_of_type_Rdc.a(rba.class))).map(new rle(this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new rea(this, localrkm));
  }
  
  private void bts()
  {
    ram.d("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
    aniq.bQi = 5000;
    aniq.dHk = 125;
    aniq.dFO = 0;
    aniq.dHo = 0;
    int i;
    rkm localrkm;
    int j;
    String str;
    float f;
    if (this.jdField_b_of_type_Rdc.b != null)
    {
      i = this.jdField_b_of_type_Rdc.b.tc();
      aniq.bsT = i;
      localObject1 = (EditTakeVideoSource)this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localrkm = new rkm(this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localrkm.aAU = rlc.ce(2);
      localObject2 = this.a.getActivity();
      i = ((EditTakeVideoSource)localObject1).getWidth();
      j = ((EditTakeVideoSource)localObject1).getHeight();
      str = ((EditTakeVideoSource)localObject1).getSourcePath();
      f = ((EditTakeVideoSource)localObject1).getWidth() * 1.0F / ((EditTakeVideoSource)localObject1).getHeight();
      if ((this.jdField_b_of_type_Rdc.b == null) || (this.jdField_b_of_type_Rdc.b.tc() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localrkm.a = new rks((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).d.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_b_of_type_Rdc.lu.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((rdb)((Iterator)localObject1).next()).a(0, localrkm);
      }
      i = 0;
      break;
    }
    ram.w("EditVideoSave", "PUBLISH start ...");
    d(acfp.m(2131705548), false, 0);
    updateProgress(2);
    Object localObject2 = Stream.of(localrkm).map(new ThreadOffFunction("EditVideoSave", 2)).map(new rkp());
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_Rdc.jdField_a_of_type_Rcc != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_b_of_type_Rdc.jdField_a_of_type_Rcc.a(0));
    }
    ((Stream)localObject1).map(new rlb()).map(new rkl()).map(new rle(this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new reb(this, localrkm));
  }
  
  public void adc()
  {
    this.a.getRootView().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  @TargetApi(14)
  public void d(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mDialog == null)
    {
      this.mDialog = new ReportDialog(getContext());
      Object localObject = this.mDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.mDialog.requestWindowFeature(1);
      this.mDialog.setContentView(2131562035);
      localObject = (ImageView)this.mDialog.findViewById(2131373659);
      this.jdField_b_of_type_Arht = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_b_of_type_Arht);
    }
    ((TextView)this.mDialog.findViewById(2131371989)).setText(paramString);
    this.mDialog.setCancelable(paramBoolean);
    this.mDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_b_of_type_Arht.setProgress(0);
    a().getRootView().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.fakeId == null) || (!this.fakeId.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_b_of_type_Rdc.changeState(0);
      this.aGH = true;
      if (paramInt2 == -1)
      {
        updateProgress(100);
        long l = SystemClock.elapsedRealtime() - this.BO;
        if (this.BO != -1L) {
          alwx.aR(l, 0);
        }
        for (;;)
        {
          this.a.getRootView().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          alwx.aR(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        dismissProgressDialog();
        alwx.aR(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131705553));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.a.getContext(), 1, localStringBuilder, 0).show();
        return;
      }
    } while (paramInt2 != 0);
    dismissProgressDialog();
  }
  
  public void onDestroy()
  {
    dismissProgressDialog();
    super.onDestroy();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_b_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      aac();
      return;
    }
    bts();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_b_of_type_Arht == null) {
      return;
    }
    this.jdField_b_of_type_Arht.stopAnimating();
    this.jdField_b_of_type_Arht.setProgress(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_b_of_type_Arht.getProgress() + ", progress:" + paramInt);
    }
    this.jdField_b_of_type_Arht.setShowText(true);
    this.jdField_b_of_type_Arht.setShowImage(false);
    this.jdField_b_of_type_Arht.setText(String.valueOf(paramInt) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdz
 * JD-Core Version:    0.7.0.1
 */