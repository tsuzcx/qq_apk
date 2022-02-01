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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class ylw
  extends ynu
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bisa jdField_a_of_type_Bisa;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ylx(this);
  public boolean a;
  public int b = 20;
  
  public ylw(@NonNull ynw paramynw)
  {
    super(paramynw);
  }
  
  private bisa a()
  {
    bisa localbisa = new bisa(a());
    localbisa.a(AIOUtils.dp2px(50.0F, a()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.e(true);
    localbisa.a(new ylz(this));
    return localbisa;
  }
  
  private void i()
  {
    yya localyya = new yya(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localyya.b = yyq.a(2);
    localyya.a = new yye(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath());
    Iterator localIterator = this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ynu)localIterator.next()).a(0, localyya);
    }
    ykq.d("EditPicSave", "PUBLISH start ...");
    a(anvx.a(2131703170), false, 0);
    a(20);
    Stream.of(localyya).map(new yyc((ylc)a(ylc.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new yyo(yls.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new yly(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisa == null) {
      return;
    }
    this.jdField_a_of_type_Bisa.a();
    this.jdField_a_of_type_Bisa.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bisa.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bisa.b(true);
    this.jdField_a_of_type_Bisa.d(false);
    this.jdField_a_of_type_Bisa.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ykw.b("0X80080E1", ykw.a);
    i();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561862);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373219);
      this.jdField_a_of_type_Bisa = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bisa);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371598)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bisa.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ypg.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylw
 * JD-Core Version:    0.7.0.1
 */