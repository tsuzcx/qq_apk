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
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class vfl
  extends vhk
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpu jdField_a_of_type_Bcpu;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new vfm(this);
  public boolean a;
  public int b = 20;
  
  public vfl(@NonNull vhm paramvhm)
  {
    super(paramvhm);
  }
  
  private bcpu a()
  {
    bcpu localbcpu = new bcpu(a());
    localbcpu.a(actj.a(50.0F, a()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.e(true);
    localbcpu.a(new vfo(this));
    return localbcpu;
  }
  
  private void i()
  {
    vsa localvsa = new vsa(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localvsa.b = vsq.a(2);
    localvsa.a = new vse(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhk)localIterator.next()).a(0, localvsa);
    }
    ved.d("EditPicSave", "PUBLISH start ...");
    a(ajya.a(2131703696), false, 0);
    a(20);
    Stream.of(localvsa).map(new vsc((ver)a(ver.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new vso(vfh.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new vfn(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpu == null) {
      return;
    }
    this.jdField_a_of_type_Bcpu.a();
    this.jdField_a_of_type_Bcpu.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpu.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpu.b(true);
    this.jdField_a_of_type_Bcpu.d(false);
    this.jdField_a_of_type_Bcpu.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    vej.b("0X80080E1", vej.a);
    i();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561434);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpu = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpu);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370452)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpu.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Vix.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfl
 * JD-Core Version:    0.7.0.1
 */