import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class yyq
  extends yxr
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bjbh jdField_a_of_type_Bjbh;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public yyq(@NonNull yxt paramyxt)
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
    localbjbh.a(new yyt(this));
    return localbjbh;
  }
  
  private void i()
  {
    bdll.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    bdbt.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    bdbt.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    bdbt.x = 0;
    bdbt.E = 0;
    int i;
    zih localzih;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bdbt.J = i;
      yuk.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
      localzih = new zih(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localzih.b = zix.a(2);
      localActivity = this.jdField_a_of_type_Yze.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localzih.a = new zin(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((yxr)((Iterator)localObject).next()).a(0, localzih);
      }
      i = 0;
      break;
    }
    yuk.d("EditVideoSave", "PUBLISH start ...");
    a(anzj.a(2131702794), false, 0);
    a(2);
    Stream.of(localzih).map(new ThreadOffFunction("EditVideoSave", 2)).map(new zio()).map(new zii((yuy)this.jdField_a_of_type_Yxt.a(yuy.class))).map(new ziz(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yyr(this, localzih));
  }
  
  private void j()
  {
    yuk.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
    bdbt.y = 5000;
    bdbt.z = 125;
    bdbt.x = 0;
    bdbt.E = 0;
    int i;
    zih localzih;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bdbt.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localzih = new zih(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localzih.b = zix.a(2);
      localObject2 = this.jdField_a_of_type_Yze.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localzih.a = new zin((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((yxr)((Iterator)localObject1).next()).a(0, localzih);
      }
      i = 0;
      break;
    }
    yuk.d("EditVideoSave", "PUBLISH start ...");
    a(anzj.a(2131702670), false, 0);
    a(2);
    Object localObject2 = Stream.of(localzih).map(new ThreadOffFunction("EditVideoSave", 2)).map(new zik());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_Ywh != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Yxt.jdField_a_of_type_Ywh.a(0));
    }
    ((Stream)localObject1).map(new ziw()).map(new zig()).map(new ziz(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yys(this, localzih));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbh == null) {
      return;
    }
    this.jdField_a_of_type_Bjbh.a();
    this.jdField_a_of_type_Bjbh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bjbh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bjbh.b(true);
    this.jdField_a_of_type_Bjbh.d(false);
    this.jdField_a_of_type_Bjbh.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_a_of_type_Yxt.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          bbgf.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Yze.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          bbgf.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        bbgf.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(anzj.a(2131702675));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Yze.a(), 1, localStringBuilder, 0).a();
        return;
      }
    } while (paramInt2 != 0);
    g();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      i();
      return;
    }
    j();
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
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yze.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyq
 * JD-Core Version:    0.7.0.1
 */