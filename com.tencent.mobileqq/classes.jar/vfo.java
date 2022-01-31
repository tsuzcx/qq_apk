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

public class vfo
  extends vhn
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpf jdField_a_of_type_Bcpf;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new vfp(this);
  public boolean a;
  public int b = 20;
  
  public vfo(@NonNull vhp paramvhp)
  {
    super(paramvhp);
  }
  
  private bcpf a()
  {
    bcpf localbcpf = new bcpf(a());
    localbcpf.a(actn.a(50.0F, a()));
    localbcpf.a(true);
    localbcpf.c(false);
    localbcpf.f(-1);
    localbcpf.e(0);
    localbcpf.d(-15550475);
    localbcpf.g(3);
    localbcpf.jdField_f_of_type_Boolean = true;
    localbcpf.jdField_f_of_type_Int = 2;
    localbcpf.e(true);
    localbcpf.a(new vfr(this));
    return localbcpf;
  }
  
  private void i()
  {
    vsd localvsd = new vsd(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localvsd.b = vst.a(2);
    localvsd.a = new vsh(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhn)localIterator.next()).a(0, localvsd);
    }
    veg.d("EditPicSave", "PUBLISH start ...");
    a(ajyc.a(2131703685), false, 0);
    a(20);
    Stream.of(localvsd).map(new vsf((veu)a(veu.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new vsr(vfk.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new vfq(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpf == null) {
      return;
    }
    this.jdField_a_of_type_Bcpf.a();
    this.jdField_a_of_type_Bcpf.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpf.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpf.b(true);
    this.jdField_a_of_type_Bcpf.d(false);
    this.jdField_a_of_type_Bcpf.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    vem.b("0X80080E1", vem.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561435);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpf = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpf);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370453)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpf.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Vja.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */