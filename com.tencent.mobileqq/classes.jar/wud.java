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

public class wud
  extends wwc
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bepe jdField_a_of_type_Bepe;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new wue(this);
  public boolean a;
  public int b = 20;
  
  public wud(@NonNull wwe paramwwe)
  {
    super(paramwwe);
  }
  
  private bepe a()
  {
    bepe localbepe = new bepe(a());
    localbepe.a(aekt.a(50.0F, a()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.e(true);
    localbepe.a(new wug(this));
    return localbepe;
  }
  
  private void i()
  {
    xgs localxgs = new xgs(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localxgs.b = xhi.a(2);
    localxgs.a = new xgw(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wwc)localIterator.next()).a(0, localxgs);
    }
    wsv.d("EditPicSave", "PUBLISH start ...");
    a(alpo.a(2131704068), false, 0);
    a(20);
    Stream.of(localxgs).map(new xgu((wtj)a(wtj.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new xhg(wtz.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new wuf(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepe == null) {
      return;
    }
    this.jdField_a_of_type_Bepe.a();
    this.jdField_a_of_type_Bepe.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bepe.b(true);
    this.jdField_a_of_type_Bepe.d(false);
    this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wtb.b("0X80080E1", wtb.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bepe.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Wxp.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wud
 * JD-Core Version:    0.7.0.1
 */