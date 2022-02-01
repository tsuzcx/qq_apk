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

public class xxd
  extends xzb
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bhhi jdField_a_of_type_Bhhi;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new xxe(this);
  public boolean a;
  public int b = 20;
  
  public xxd(@NonNull xzd paramxzd)
  {
    super(paramxzd);
  }
  
  private bhhi a()
  {
    bhhi localbhhi = new bhhi(a());
    localbhhi.a(AIOUtils.dp2px(50.0F, a()));
    localbhhi.a(true);
    localbhhi.c(false);
    localbhhi.g(-1);
    localbhhi.f(0);
    localbhhi.d(-15550475);
    localbhhi.i(3);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    localbhhi.e(true);
    localbhhi.a(new xxg(this));
    return localbhhi;
  }
  
  private void i()
  {
    yjh localyjh = new yjh(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localyjh.b = yjx.a(2);
    localyjh.a = new yjl(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath());
    Iterator localIterator = this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xzb)localIterator.next()).a(0, localyjh);
    }
    xvv.d("EditPicSave", "PUBLISH start ...");
    a(amtj.a(2131702819), false, 0);
    a(20);
    Stream.of(localyjh).map(new yjj((xwj)a(xwj.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new yjv(xwz.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new xxf(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhi == null) {
      return;
    }
    this.jdField_a_of_type_Bhhi.a();
    this.jdField_a_of_type_Bhhi.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bhhi.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bhhi.b(true);
    this.jdField_a_of_type_Bhhi.d(false);
    this.jdField_a_of_type_Bhhi.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    xwb.b("0X80080E1", xwb.a);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561794);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373009);
      this.jdField_a_of_type_Bhhi = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bhhi);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371413)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bhhi.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Yan.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxd
 * JD-Core Version:    0.7.0.1
 */