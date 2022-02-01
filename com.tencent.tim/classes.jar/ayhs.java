import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import java.util.Iterator;
import java.util.List;

public class ayhs
  extends aygy
{
  public float Fy = 3.0F;
  public boolean aGH;
  arht b;
  int eKi = -1;
  private String fakeId;
  private Dialog mDialog;
  public float progress;
  
  public ayhs(@NonNull aygz paramaygz)
  {
    super(paramaygz);
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
    localarht.a(new ayhv(this));
    return localarht;
  }
  
  private void aac()
  {
    anot.a(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    aniq.bQi = (int)((EditRecordVideoSource)localObject).recordTime;
    aniq.dHk = ((EditRecordVideoSource)localObject).bpF;
    aniq.dFO = 0;
    aniq.dHo = 0;
    int i;
    ayqb localayqb;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_b_of_type_Aygz.b != null)
    {
      i = this.jdField_b_of_type_Aygz.b.tc();
      aniq.bsT = i;
      ram.d("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
      localayqb = new ayqb(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localayqb.aAU = ayqu.ce(2);
      localActivity = this.a.getActivity();
      i = ((EditRecordVideoSource)localObject).bpK;
      j = ((EditRecordVideoSource)localObject).bpL;
      str = ((EditRecordVideoSource)localObject).sourcePath;
      f = ((EditRecordVideoSource)localObject).mH;
      if ((this.jdField_b_of_type_Aygz.b == null) || (this.jdField_b_of_type_Aygz.b.tc() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localayqb.a = new ayqj(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).bpJ, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).azu, ((EditRecordVideoSource)localObject).aGI);
      localObject = this.jdField_b_of_type_Aygz.lu.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aygy)((Iterator)localObject).next()).a(0, localayqb);
      }
      i = 0;
      break;
    }
    ram.w("EditVideoSave", "PUBLISH start ...");
    d(acfp.m(2131705621), false, 0);
    updateProgress(2);
    Stream.of(localayqb).map(new ThreadOffFunction("EditVideoSave", 2)).map(new ayqk()).map((StreamFunction)ppf.a(ayqc.class, new Object[] { (aydg)this.jdField_b_of_type_Aygz.a(aydg.class) })).map(new ayqw(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new ayht(this, localayqb));
  }
  
  private void bts()
  {
    ram.d("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    ayqb localayqb;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).d.rotation;
      localayqb = new ayqb(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localayqb.g.videoMaxrate = aniq.dFI;
      if (anki.axH()) {
        localayqb.g.videoMaxrate = (anki.JM() * 1000);
      }
      localayqb.aAU = ayqu.ce(2);
      localObject2 = this.a.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).getWidth();
      k = ((EditVideoParams.EditSource)localObject1).getHeight();
      str = ((EditVideoParams.EditSource)localObject1).getSourcePath();
      f = ((EditVideoParams.EditSource)localObject1).getWidth() * 1.0F / ((EditVideoParams.EditSource)localObject1).getHeight();
      if ((this.jdField_b_of_type_Aygz.b == null) || (this.jdField_b_of_type_Aygz.b.tc() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localayqb.a = new ayqj((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_b_of_type_Aygz.lu.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((aygy)((Iterator)localObject1).next()).a(0, localayqb);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).d.rotation;
      break;
    }
    ram.w("EditVideoSave", "PUBLISH start ...");
    d(acfp.m(2131705484), false, 0);
    updateProgress(2);
    Object localObject2 = Stream.of(localayqb).map(new ThreadOffFunction("EditVideoSave", 2)).map(new ayqg());
    localObject1 = localObject2;
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfe != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfe.a(0));
    }
    ((Stream)localObject2).map(new ayqp()).map(new ayqw(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new ayhu(this, localayqb));
  }
  
  public void adc()
  {
    if (this.a == null) {
      return;
    }
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
      this.jdField_b_of_type_Aygz.changeState(0);
      this.aGH = true;
      if (paramInt2 == -1)
      {
        updateProgress(100);
        this.a.getRootView().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        dismissProgressDialog();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131705659));; localStringBuilder = new StringBuilder(acfp.m(2131705513)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.a.getContext(), 1, localStringBuilder, 0).show();
          return;
        }
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
    this.eKi = paramInt;
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      aac();
      return;
    }
    bts();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_b_of_type_Arht == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Arht.stopAnimating();
      this.jdField_b_of_type_Arht.setProgress(paramInt);
      this.jdField_b_of_type_Arht.setShowText(true);
      this.jdField_b_of_type_Arht.setShowImage(false);
      this.jdField_b_of_type_Arht.setText(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_b_of_type_Arht.getProgress() + ", progress:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhs
 * JD-Core Version:    0.7.0.1
 */