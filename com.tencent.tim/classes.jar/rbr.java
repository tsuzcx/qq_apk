import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicSave.3;
import com.tencent.biz.qqstory.takevideo.EditPicSave.4;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class rbr
  extends rdb
{
  ThreadExcutor.IThreadListener a;
  public boolean aGH;
  arht b;
  public int bpE = 20;
  private Dialog mDialog;
  public int progress;
  
  public rbr(@NonNull rdc paramrdc)
  {
    super(paramrdc);
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new rbs(this);
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
    localarht.a(new rbu(this));
    return localarht;
  }
  
  private void bst()
  {
    rkm localrkm = new rkm(this.jdField_b_of_type_Rdc.a);
    localrkm.aAU = rlc.ce(2);
    localrkm.a = new rkq(this.jdField_b_of_type_Rdc.a.a.getSourcePath());
    Iterator localIterator = this.jdField_b_of_type_Rdc.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).a(0, localrkm);
    }
    ram.w("EditPicSave", "PUBLISH start ...");
    d(acfp.m(2131705462), false, 0);
    updateProgress(20);
    Stream.of(localrkm).map(new rko((rba)a(rba.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new rla(rbn.azs + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new rbt(this));
  }
  
  public void adc()
  {
    this.jdField_a_of_type_Rel.getRootView().postDelayed(new EditPicSave.4(this), 1000L);
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
    a().getRootView().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
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
    ras.bw("0X80080E1", ras.bpo);
    bst();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_b_of_type_Arht == null) {
      return;
    }
    this.jdField_b_of_type_Arht.stopAnimating();
    this.jdField_b_of_type_Arht.setProgress(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_b_of_type_Arht.getProgress() + ", progress:" + paramInt);
    }
    this.jdField_b_of_type_Arht.setShowText(true);
    this.jdField_b_of_type_Arht.setShowImage(false);
    this.jdField_b_of_type_Arht.setText(String.valueOf(paramInt) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbr
 * JD-Core Version:    0.7.0.1
 */