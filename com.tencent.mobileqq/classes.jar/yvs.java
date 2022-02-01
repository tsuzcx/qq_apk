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

public class yvs
  extends yxr
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bjbh jdField_a_of_type_Bjbh;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new yvt(this);
  public boolean a;
  public int b = 20;
  
  public yvs(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  private bjbh a()
  {
    bjbh localbjbh = new bjbh(a());
    localbjbh.a(agej.a(50.0F, a()));
    localbjbh.a(true);
    localbjbh.c(false);
    localbjbh.g(-1);
    localbjbh.f(0);
    localbjbh.d(-15550475);
    localbjbh.i(3);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    localbjbh.e(true);
    localbjbh.a(new yvv(this));
    return localbjbh;
  }
  
  private void i()
  {
    zih localzih = new zih(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localzih.b = zix.a(2);
    localzih.a = new zil(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).a(0, localzih);
    }
    yuk.d("EditPicSave", "PUBLISH start ...");
    a(anzj.a(2131702584), false, 0);
    a(20);
    Stream.of(localzih).map(new zij((yuy)a(yuy.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new ziv(yvo.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new yvu(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbh == null) {
      return;
    }
    this.jdField_a_of_type_Bjbh.a();
    this.jdField_a_of_type_Bjbh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bjbh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bjbh.b(true);
    this.jdField_a_of_type_Bjbh.d(false);
    this.jdField_a_of_type_Bjbh.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    yuq.b("0X80080E1", yuq.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561917);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373039);
      this.jdField_a_of_type_Bjbh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bjbh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371445)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bjbh.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yze.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvs
 * JD-Core Version:    0.7.0.1
 */