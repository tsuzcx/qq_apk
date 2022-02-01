import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.3;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ayec
  extends aygy
{
  ThreadExcutor.IThreadListener a;
  public boolean aGH;
  private boolean aHY;
  arht jdField_b_of_type_Arht;
  private ayrk jdField_b_of_type_Ayrk;
  public int bpE = 20;
  private String cWO;
  private boolean hasSaved = true;
  private Dialog mDialog;
  private int mState = 0;
  public int progress;
  
  public ayec(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ayed(this);
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
    localarht.a(new ayef(this));
    return localarht;
  }
  
  private void afa(int paramInt)
  {
    if ((this.jdField_a_of_type_Ayii.getActivity() == null) || (TextUtils.isEmpty(this.cWO))) {}
    while (new File(this.cWO).exists()) {
      return;
    }
  }
  
  private String bV(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void bst()
  {
    ayqb localayqb = new ayqb(this.jdField_b_of_type_Aygz.a);
    localayqb.aAU = ayqu.ce(2);
    localayqb.a = new ayqh(this.jdField_b_of_type_Aygz.a.a.getSourcePath());
    Iterator localIterator = this.jdField_b_of_type_Aygz.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).a(0, localayqb);
    }
    ram.w("EditPicSave", "PUBLISH start ...");
    d(acfp.m(2131705463), false, 0);
    updateProgress(20);
    Stream.of(localayqb).map(new ayqe((aydg)a(aydg.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new ayqs(aydw.azs + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new ayee(this));
  }
  
  public void adc()
  {
    if (this.aHY) {
      return;
    }
    this.jdField_a_of_type_Ayii.getRootView().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  @TargetApi(14)
  public void d(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.aHY) {
      return;
    }
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
    this.aHY = true;
    dismissProgressDialog();
    super.onDestroy();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ras.bw("0X80080E1", ras.bpo);
      bst();
      return;
      this.mState = paramInt;
      this.jdField_b_of_type_Ayrk = null;
      return;
      this.mState = paramInt;
    } while (!(paramObject instanceof ayrk));
    this.jdField_b_of_type_Ayrk = ((ayrk)paramObject);
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.aHY) {}
    while (this.jdField_b_of_type_Arht == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayec
 * JD-Core Version:    0.7.0.1
 */