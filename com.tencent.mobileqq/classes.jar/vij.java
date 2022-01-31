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
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class vij
  extends vhk
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpu jdField_a_of_type_Bcpu;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b = 3;
  
  public vij(@NonNull vhm paramvhm)
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
    localbcpu.a(new vim(this));
    return localbcpu;
  }
  
  private void i()
  {
    axqy.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    axim.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    axim.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    axim.x = 0;
    axim.E = 0;
    int i;
    vsa localvsa;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      axim.J = i;
      ved.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + axim.z + " CodecParam.mRecordTime" + axim.y);
      localvsa = new vsa(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvsa.b = vsq.a(2);
      localActivity = this.jdField_a_of_type_Vix.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localvsa.a = new vsg(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((vhk)((Iterator)localObject).next()).a(0, localvsa);
      }
      i = 0;
      break;
    }
    ved.d("EditVideoSave", "PUBLISH start ...");
    a(ajya.a(2131703906), false, 0);
    a(2);
    Stream.of(localvsa).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vsh()).map(new vsb((ver)this.jdField_a_of_type_Vhm.a(ver.class))).map(new vss(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new vik(this, localvsa));
  }
  
  private void j()
  {
    ved.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + axim.z + " CodecParam.mRecordTime" + axim.y);
    axim.y = 5000;
    axim.z = 125;
    axim.x = 0;
    axim.E = 0;
    int i;
    vsa localvsa;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      axim.J = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localvsa = new vsa(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localvsa.b = vsq.a(2);
      localObject2 = this.jdField_a_of_type_Vix.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localvsa.a = new vsg((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((vhk)((Iterator)localObject1).next()).a(0, localvsa);
      }
      i = 0;
      break;
    }
    ved.d("EditVideoSave", "PUBLISH start ...");
    a(ajya.a(2131703782), false, 0);
    a(2);
    Object localObject2 = Stream.of(localvsa).map(new ThreadOffFunction("EditVideoSave", 2)).map(new vsd());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_Vga != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Vhm.jdField_a_of_type_Vga.a(0));
    }
    ((Stream)localObject1).map(new vsp()).map(new vrz()).map(new vss(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new vil(this, localvsa));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpu == null) {
      return;
    }
    this.jdField_a_of_type_Bcpu.a();
    this.jdField_a_of_type_Bcpu.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpu.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpu.b(true);
    this.jdField_a_of_type_Bcpu.d(false);
    this.jdField_a_of_type_Bcpu.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_Vhm.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long != -1L) {
          avtd.a(l, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_Vix.a().postDelayed(new EditVideoSave.1(this), 500L);
          return;
          avtd.a(l, -1);
        }
      }
      if (paramInt2 == 1)
      {
        g();
        avtd.a(-1L, -1);
        StringBuilder localStringBuilder = new StringBuilder(ajya.a(2131703787));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        bcql.a(this.jdField_a_of_type_Vix.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    g();
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Vix.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vij
 * JD-Core Version:    0.7.0.1
 */