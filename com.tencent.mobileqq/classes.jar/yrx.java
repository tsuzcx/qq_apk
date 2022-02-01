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

public class yrx
  extends ytw
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  biaj jdField_a_of_type_Biaj;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new yry(this);
  public boolean a;
  public int b = 20;
  
  public yrx(@NonNull yty paramyty)
  {
    super(paramyty);
  }
  
  private biaj a()
  {
    biaj localbiaj = new biaj(a());
    localbiaj.a(afur.a(50.0F, a()));
    localbiaj.a(true);
    localbiaj.c(false);
    localbiaj.f(-1);
    localbiaj.e(0);
    localbiaj.d(-15550475);
    localbiaj.g(3);
    localbiaj.jdField_f_of_type_Boolean = true;
    localbiaj.jdField_f_of_type_Int = 2;
    localbiaj.e(true);
    localbiaj.a(new ysa(this));
    return localbiaj;
  }
  
  private void i()
  {
    zem localzem = new zem(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localzem.b = zfc.a(2);
    localzem.a = new zeq(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ytw)localIterator.next()).a(0, localzem);
    }
    yqp.d("EditPicSave", "PUBLISH start ...");
    a(anni.a(2131702477), false, 0);
    a(20);
    Stream.of(localzem).map(new zeo((yrd)a(yrd.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new zfa(yrt.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new yrz(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biaj == null) {
      return;
    }
    this.jdField_a_of_type_Biaj.a();
    this.jdField_a_of_type_Biaj.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Biaj.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Biaj.b(true);
    this.jdField_a_of_type_Biaj.d(false);
    this.jdField_a_of_type_Biaj.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    yqv.b("0X80080E1", yqv.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561876);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372926);
      this.jdField_a_of_type_Biaj = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Biaj);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371338)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Biaj.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yvj.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrx
 * JD-Core Version:    0.7.0.1
 */