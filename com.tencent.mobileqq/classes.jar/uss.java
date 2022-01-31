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

public class uss
  extends uur
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bbmh jdField_a_of_type_Bbmh;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new ust(this);
  public boolean a;
  public int b = 20;
  
  public uss(@NonNull uut paramuut)
  {
    super(paramuut);
  }
  
  private bbmh a()
  {
    bbmh localbbmh = new bbmh(a());
    localbbmh.a(aciy.a(50.0F, a()));
    localbbmh.a(true);
    localbbmh.c(false);
    localbbmh.f(-1);
    localbbmh.e(0);
    localbbmh.d(-15550475);
    localbbmh.g(3);
    localbbmh.jdField_f_of_type_Boolean = true;
    localbbmh.jdField_f_of_type_Int = 2;
    localbbmh.e(true);
    localbbmh.a(new usv(this));
    return localbbmh;
  }
  
  private void i()
  {
    vfh localvfh = new vfh(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localvfh.b = vfx.a(2);
    localvfh.a = new vfl(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uur)localIterator.next()).a(0, localvfh);
    }
    urk.d("EditPicSave", "PUBLISH start ...");
    a(ajjy.a(2131637900), false, 0);
    a(20);
    Stream.of(localvfh).map(new vfj((ury)a(ury.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new vfv(uso.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new usu(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbmh == null) {
      return;
    }
    this.jdField_a_of_type_Bbmh.a();
    this.jdField_a_of_type_Bbmh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bbmh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bbmh.b(true);
    this.jdField_a_of_type_Bbmh.d(false);
    this.jdField_a_of_type_Bbmh.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    urq.b("0X80080E1", urq.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131495844);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131306298);
      this.jdField_a_of_type_Bbmh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bbmh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131304792)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bbmh.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Uwe.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uss
 * JD-Core Version:    0.7.0.1
 */