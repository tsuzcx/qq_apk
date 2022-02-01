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

public class yuv
  extends ytw
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  biaj jdField_a_of_type_Biaj;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public yuv(@NonNull yty paramyty)
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
    localbiaj.a(new yuy(this));
    return localbiaj;
  }
  
  private void i()
  {
    bcst.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    bcjb.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    bcjb.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    bcjb.x = 0;
    bcjb.E = 0;
    int i;
    zem localzem;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bcjb.J = i;
      yqp.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + bcjb.z + " CodecParam.mRecordTime" + bcjb.y);
      localzem = new zem(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localzem.b = zfc.a(2);
      localActivity = this.jdField_a_of_type_Yvj.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localzem.a = new zes(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ytw)((Iterator)localObject).next()).a(0, localzem);
      }
      i = 0;
      break;
    }
    yqp.d("EditVideoSave", "PUBLISH start ...");
    a(anni.a(2131702687), false, 0);
    a(2);
    Stream.of(localzem).map(new ThreadOffFunction("EditVideoSave", 2)).map(new zet()).map(new zen((yrd)this.jdField_a_of_type_Yty.a(yrd.class))).map(new zfe(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yuw(this, localzem));
  }
  
  private void j()
  {
    yqp.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + bcjb.z + " CodecParam.mRecordTime" + bcjb.y);
    bcjb.y = 5000;
    bcjb.z = 125;
    bcjb.x = 0;
    bcjb.E = 0;
    int i;
    zem localzem;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bcjb.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localzem = new zem(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localzem.b = zfc.a(2);
      localObject2 = this.jdField_a_of_type_Yvj.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localzem.a = new zes((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ytw)((Iterator)localObject1).next()).a(0, localzem);
      }
      i = 0;
      break;
    }
    yqp.d("EditVideoSave", "PUBLISH start ...");
    a(anni.a(2131702563), false, 0);
    a(2);
    Object localObject2 = Stream.of(localzem).map(new ThreadOffFunction("EditVideoSave", 2)).map(new zep());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_Ysm != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Yty.jdField_a_of_type_Ysm.a(0));
    }
    ((Stream)localObject1).map(new zfb()).map(new zel()).map(new zfe(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new yux(this, localzem));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biaj == null) {
      return;
    }
    this.jdField_a_of_type_Biaj.a();
    this.jdField_a_of_type_Biaj.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Biaj.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Biaj.b(true);
    this.jdField_a_of_type_Biaj.d(false);
    this.jdField_a_of_type_Biaj.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Yty.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          banm.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Yvj.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          banm.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        banm.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(anni.a(2131702568));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_Yvj.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561876);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372926);
      this.jdField_a_of_type_Biaj = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Biaj);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371338)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Biaj.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yvj.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yuv
 * JD-Core Version:    0.7.0.1
 */