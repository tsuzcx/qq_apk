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

public class wym
  extends xal
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  betn jdField_a_of_type_Betn;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new wyn(this);
  public boolean a;
  public int b = 20;
  
  public wym(@NonNull xan paramxan)
  {
    super(paramxan);
  }
  
  private betn a()
  {
    betn localbetn = new betn(a());
    localbetn.a(aepi.a(50.0F, a()));
    localbetn.a(true);
    localbetn.c(false);
    localbetn.f(-1);
    localbetn.e(0);
    localbetn.d(-15550475);
    localbetn.g(3);
    localbetn.jdField_f_of_type_Boolean = true;
    localbetn.jdField_f_of_type_Int = 2;
    localbetn.e(true);
    localbetn.a(new wyp(this));
    return localbetn;
  }
  
  private void i()
  {
    xlb localxlb = new xlb(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localxlb.b = xlr.a(2);
    localxlb.a = new xlf(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xal)localIterator.next()).a(0, localxlb);
    }
    wxe.d("EditPicSave", "PUBLISH start ...");
    a(alud.a(2131704080), false, 0);
    a(20);
    Stream.of(localxlb).map(new xld((wxs)a(wxs.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new xlp(wyi.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new wyo(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Betn == null) {
      return;
    }
    this.jdField_a_of_type_Betn.a();
    this.jdField_a_of_type_Betn.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Betn.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Betn.b(true);
    this.jdField_a_of_type_Betn.d(false);
    this.jdField_a_of_type_Betn.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wxk.b("0X80080E1", wxk.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561642);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372332);
      this.jdField_a_of_type_Betn = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Betn);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370777)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Betn.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Xby.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wym
 * JD-Core Version:    0.7.0.1
 */